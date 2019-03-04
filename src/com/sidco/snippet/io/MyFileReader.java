/**
 * 
 */
package com.sidco.snippet.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;

/**
 * @author Sidhanta Kumar Kar
 *
 */
public class MyFileReader {

	private File file;

	/**
	 * 
	 */
	public MyFileReader() {
		super();
	}

	/**
	 * @param fileName
	 */
	public MyFileReader(String fileName) {
		super();
		this.file = new File(fileName);
	}

	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * @param useUTF
	 * @return HashMap<Integer,String> readFile
	 * @throws IOException
	 */
	public HashMap<Integer,String> readWithBufferedReader(boolean useUTF) throws IOException {
		// Initialize variables
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		HashMap<Integer,String> readFile = new HashMap<Integer,String>();

		try {
			// Open Input Stream for reading purpose.
			inputStream = new FileInputStream(file);
			// Create new Input Stream Reader based on which encoding to use
			if (useUTF) {
				inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8").newDecoder());
			} else {
				inputStreamReader = new InputStreamReader(inputStream);
			}
			// Create new Buffered Reader
			bufferedReader = new BufferedReader(inputStreamReader);
			String currLine = "";
			Integer lineNumber = 0;
			// Reads to the end of the stream
			while ((currLine = bufferedReader.readLine()) != null) {
				readFile.put(++lineNumber,currLine);
				//System.out.println(lineNumber + " : " + currLine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Releases resources associated with the streams
			if (inputStream != null) {
				inputStream.close();
			}
			if (inputStreamReader != null) {
				inputStreamReader.close();
			}
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}
		return readFile;
	}

}
