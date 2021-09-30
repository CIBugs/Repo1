package ca.uhn.fhir.jpa.subscription;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.net.URI;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.Observation;
import org.hl7.fhir.dstu3.model.Patient;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.dstu3.model.Subscription;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import ca.uhn.fhir.jpa.dao.DaoConfig;
import ca.uhn.fhir.jpa.provider.dstu3.BaseResourceProviderDstu3Test;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.server.EncodingEnum;

/**
 * Adds a FHIR subscription with criteria through the rest interface. Then creates a websocket with the id of the
 * subscription
 * <p>
 * Note: This test only returns a ping with the subscription id, Check FhirSubscriptionWithSubscriptionIdDstu3Test for
 * a test that returns the xml of the observation
 * <p>
 * To execute the following test, execute it the following way:
 * 0. execute 'clean' test
 * 1. Execute the 'createPatient' test
 * 2. Update the patient id static variable
 * 3. Execute the 'createSubscription' test
 * 4. Update the subscription id static variable
 * 5. Execute the 'attachWebSocket' test
 * 6. Execute the 'sendObservation' test
 * 7. Look in the 'attachWebSocket' terminal execution and wait for your ping with the subscription id
 */
public class FhirSubscriptionWithCriteriaDstu3Test extends BaseResourceProviderDstu3Test {

	private static final Logger ourLog = org.slf4j.LoggerFactory.getLogger(FhirSubscriptionWithCriteriaDstu3Test.class);

	private String myPatientId;
	private String mySubscriptionId;
	private WebSocketClient myWebSocketClient;
	private SocketImplementation mySocketImplementation;

	@After
	public void after() throws Exception {
		super.after();
		myDaoConfig.setSubscriptionEnabled(new DaoConfig().isSubscriptionEnabled());
		myDaoConfig.setSubscriptionPollDelay(new DaoConfig().getSubscriptionPollDelay());
	}
	
	@Before
	public void before() throws Exception {
		super.before();
		
		myDaoConfig.setSubscriptionEnabled(true);
		myDaoConfig.setSubscriptionPollDelay(0L);
		
		/*
		 * Create patient
		 */
		
		Patient patient = FhirDstu3Util.getPatient();
		MethodOutcome methodOutcome = ourClient.create().resource(patient).execute();
		myPatientId = methodOutcome.getId().getIdPart();

		/* 
		 * Create subscription
		 */
		Subscription subscription = new Subscription();
		subscription.setReason("Monitor new neonatal function (note, age will be determined by the monitor)");
		subscription.setStatus(Subscription.SubscriptionStatus.ACTIVE);
		// subscription.setCriteria("Observation?subject=Patient/" + PATIENT_ID);
		subscription.setCriteria("Observation?code=SNOMED-CT|82313006&_format=xml");

		Subscription.SubscriptionChannelComponent channel = new Subscription.SubscriptionChannelComponent();
		channel.setType(Subscription.SubscriptionChannelType.WEBSOCKET);
		channel.setPayload("application/json");
		subscription.setChannel(channel);

		methodOutcome = ourClient.create().resource(subscription).execute();
		mySubscriptionId = methodOutcome.getId().getIdPart();
		
		/*
		 * Attach websocket
		 */

		myWebSocketClient = new WebSocketClient();
		mySocketImplementation = new SocketImplementation(mySubscriptionId, EncodingEnum.JSON);

		myWebSocketClient.start();
		URI echoUri = new URI("ws://localhost:" + ourPort + "/websocket/dstu3");
		ClientUpgradeRequest request = new ClientUpgradeRequest();
		ourLog.info("Connecting to : {}", echoUri);
		Future<Session> connection = myWebSocketClient.connect(mySocketImplementation, echoUri, request);
		Session session = connection.get(2, TimeUnit.SECONDS);
		
		ourLog.info("Connected to WS: {}", session.isOpen());
	}

	@After
	public void afterCloseWebsocket() throws Exception {
		ourLog.info("Shutting down websocket client");
		myWebSocketClient.stop();
	}
	
	@Test
	public void createObservation() throws Exception {
		Observation observation = new Observation();
		CodeableConcept codeableConcept = new CodeableConcept();
		observation.setCode(codeableConcept);
		Coding coding = codeableConcept.addCoding();
		coding.setCode("82313006");
		coding.setSystem("SNOMED-CT");
		Reference reference = new Reference();
		reference.setReference("Patient/" + myPatientId);
		observation.setSubject(reference);
		observation.setStatus(Observation.ObservationStatus.FINAL);

		MethodOutcome methodOutcome2 = ourClient.create().resource(observation).execute();
		String observationId = methodOutcome2.getId().getIdPart();
		observation.setId(observationId);

		ourLog.info("Observation id generated by server is: " + observationId);
		
		int changes = mySubscriptionDao.pollForNewUndeliveredResources();
		ourLog.info("Polling showed {}", changes);
		assertEquals(1, changes);

		Thread.sleep(2000);
		
		ourLog.info("WS Messages: {}", mySocketImplementation.getMessages());
		assertThat(mySocketImplementation.getMessages(), contains("bound " + mySubscriptionId, "ping " + mySubscriptionId));
	}

	@Test
	public void createObservationThatDoesNotMatch() throws Exception {
		Observation observation = new Observation();
		CodeableConcept codeableConcept = new CodeableConcept();
		observation.setCode(codeableConcept);
		Coding coding = codeableConcept.addCoding();
		coding.setCode("8231");
		coding.setSystem("SNOMED-CT");
		Reference reference = new Reference();
		reference.setReference("Patient/" + myPatientId);
		observation.setSubject(reference);
		observation.setStatus(Observation.ObservationStatus.FINAL);

		MethodOutcome methodOutcome2 = ourClient.create().resource(observation).execute();
		String observationId = methodOutcome2.getId().getIdPart();
		observation.setId(observationId);

		ourLog.info("Observation id generated by server is: " + observationId);
		
		int changes = mySubscriptionDao.pollForNewUndeliveredResources();
		ourLog.info("Polling showed {}", changes);
		assertEquals(0, changes);

		Thread.sleep(2000);
		
		ourLog.info("WS Messages: {}", mySocketImplementation.getMessages());
		assertThat(mySocketImplementation.getMessages(), contains("bound " + mySubscriptionId));
	}
}
