/***
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.caelum.vraptor.util;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.util.PropertyResourceBundle;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.util.SafeResourceBundle;

public class SafeResourceBundleTest {


	private SafeResourceBundle bundle;

	@Before
	public void setUp() throws Exception {
		PropertyResourceBundle delegate = new PropertyResourceBundle(new ByteArrayInputStream("abc=def".getBytes()));
		bundle = new SafeResourceBundle(delegate);
	}

	@Test
	public void shouldReturnDelegateValueWhenKeyExists() throws Exception {
		String result = bundle.getString("abc");
		assertThat(result, is("def"));
	}

	@Test
	public void shouldReturnKeyBetweenQuestionMarksWhenKeyDoesntExist() throws Exception {
		String result = bundle.getString("any key");
		assertThat(result, is("???any key???"));
	}
}
