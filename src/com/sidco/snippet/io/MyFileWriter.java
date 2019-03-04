/**
 * 
 */
package com.sidco.snippet.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @author Sidhanta Kumar Kar
 *
 */
public class MyFileWriter {

	private File file;

	/**
	 * 
	 */
	public MyFileWriter() {
		super();
	}

	/**
	 * @param file
	 */
	public MyFileWriter(String fileName) {
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
	 * @param writeFile
	 * @param useUTF
	 * @throws IOException
	 */
	public void writeWithBufferedWriter(HashMap<Integer, String> writeFileWithLineNumber, boolean useUTF)
			throws IOException {
		ArrayList<String> writeFile = new ArrayList<String>();
		for (Entry<Integer, String> contentToWrite : writeFileWithLineNumber.entrySet()) {
			// System.out.println(contentToWrite.getKey() + " : " +
			// contentToWrite.getValue());
			writeFile.add(contentToWrite.getValue());
		}
		this.writeWithBufferedWriter(writeFile, useUTF);
	}

	/**
	 * @param writeFile
	 * @param useUTF
	 * @throws IOException
	 */
	public void writeWithBufferedWriter(ArrayList<String> writeFile, boolean useUTF) throws IOException {
		// Initialize variables
		FileOutputStream fileOutputStream = null;
		OutputStreamWriter outputStreamWriter = null;
		BufferedWriter bufferedWriter = null;

		try {
			// If file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			// Create File Output Stream
			fileOutputStream = new FileOutputStream(file.getAbsoluteFile());
			// Create Output Stream Writer based on which encoding to use
			if (useUTF) {
				outputStreamWriter = new OutputStreamWriter(fileOutputStream, Charset.forName("UTF-8").newEncoder());
			} else {
				outputStreamWriter = new OutputStreamWriter(fileOutputStream);
			}
			// Create Buffered Writer
			bufferedWriter = new BufferedWriter(outputStreamWriter);
			for (String contentToWrite : writeFile) {
				// System.out.println(contentToWrite);
				// Writing string to Buffered Writer
				bufferedWriter.write(contentToWrite);
				// Adding New Line/Line Break
				bufferedWriter.newLine();
				bufferedWriter.flush();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Releases resources associated with the stream
			if (fileOutputStream != null) {
				fileOutputStream.close();
			}
			if (outputStreamWriter != null) {
				outputStreamWriter.close();
			}
			if (bufferedWriter != null) {
				bufferedWriter.close();
			}
		}
	}

}
