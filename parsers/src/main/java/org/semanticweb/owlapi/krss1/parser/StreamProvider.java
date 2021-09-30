/* Generated By:JavaCC: Do not edit this line. StreamProvider.java Version 7.0 */
/* JavaCCOptions:KEEP_LINE_COLUMN=true */
package org.semanticweb.owlapi.krss1.parser;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

 @SuppressWarnings("all")
public class StreamProvider implements Provider {

	Reader _reader;

	public StreamProvider(Reader reader) {
		_reader = reader;
	}
	
	public StreamProvider(InputStream stream) throws IOException {
		_reader = new BufferedReader(new InputStreamReader(stream));
	}
	
	public StreamProvider(InputStream stream, String charsetName) throws IOException {
		_reader = new BufferedReader(new InputStreamReader(stream, charsetName));
	}

	@Override
	public int read(char[] buffer, int off, int len) throws IOException {
	   int result = _reader.read(buffer, off, len);

	   if (result == 0) {
	      if (off < buffer.length && len > 0) {
	        result = -1;
	      }
	   }
	   
		return result;
	}

	@Override
	public void close() throws IOException {
		_reader.close();
	}

}

/* JavaCC - OriginalChecksum=7c2a47fc74e1499f47f4370d16bdd73b (do not edit this line) */
