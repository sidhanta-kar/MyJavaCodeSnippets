/**
 * 
 */
package com.sidco.snippet.util.system;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.commons.io.FilenameUtils;

/**
 * @author Sidhanta Kumar Kar
 *
 */
public class MySystemHandler {

	/**
	 * 
	 */
	public MySystemHandler() {
		super();
	}

	public String getFileExtension(String filename) {
		return FilenameUtils.getExtension(filename);
	}

	public void verifyFileLocation(String file) {
		System.out.println("Checking if Destination path is Valid");
		if (new File(FilenameUtils.getFullPath(file)).exists()) {
			System.out.println("Destination path is Valid");
		} else {
			System.out.println("Destination path doesn't exist.");
			System.out.println("Creating path...");
			new File(FilenameUtils.getFullPath(file)).mkdirs();
			System.out.println("End of Creating path...");
		}
		System.out.println("End of Checking if Destination path is Valid");
	}

	public ArrayList<String> runProcess(String command) throws IOException, InterruptedException {
		// ArrayList of output from the cmd
		ArrayList<String> output = new ArrayList<String>();
		// Fetch Runtime to Execute command on
		Runtime runtime = Runtime.getRuntime();
		// Execute the command on cmd
		Process process = runtime.exec(command);
		// Fetching the input stream
		InputStream ins = process.getInputStream();
		String line = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(ins));
		// Adding the fetched data from input stream to ArrayList
		while ((line = in.readLine()) != null) {
			output.add(line);
		}
		// Waiting for cmd execution to end
		process.waitFor();
		// Returning the output
		return output;
	}

	public ArrayList<File> findFiles(String rootPathConfig, String extension) throws Exception {

		// ArrayList with the paths to be returned
		ArrayList<File> ret = new ArrayList<File>();
		// Filter Files on Basis of Extension
		for (File filename : this.findAllFiles(rootPathConfig)) {
			// Check if extension is equal to extension specified in variable
			if (FilenameUtils.getExtension(filename.getAbsolutePath()).equalsIgnoreCase(extension)) {
				// Add the file name to the ArrayList
				ret.add(filename);
			}
		}
		return ret;
	}

	public ArrayList<File> findAllFiles(String rootPathConfig) throws Exception {

		// ArrayList with the paths to be returned
		ArrayList<File> ret = new ArrayList<File>();
		// Array of File names
		String[] fileNames = null;
		// ArrayList to store the Directories where files are to be searched
		ArrayList<String> nextDir = new ArrayList<String>();
		// Add the base path to the ArrayList from where searching is to start
		nextDir.add(rootPathConfig);

		// Checks whether the ArrayList is not empty
		while (!nextDir.isEmpty()) {
			// Converts the path at the index of the List, from String type to
			// File type
			File pathName = new File(nextDir.get(0));
			// Check if path is a Directory
			if (pathName.isDirectory()) {
				// Lists of all directories & files in the directory
				fileNames = pathName.list();
			}
			// If Directory is not empty
			if (fileNames != null && fileNames.length > 0) {
				// Loop to check all the directories,sub-directories and files
				// in the path specified
				for (int fileNamesIndex = 0; fileNamesIndex < fileNames.length; fileNamesIndex++) {
					// Creates a new file path from the base path and the new folder or
					// file specified getPath converts abstract path to path in String,
					// constructor creates new File object with fileName name
					File fileNameNew = new File(pathName.getPath(), fileNames[fileNamesIndex]);

					// Check if the new path is a directory
					if (fileNameNew.isDirectory()) {
						// Add new directory to the ArrayList nextDir
						nextDir.add(fileNameNew.getPath());
					} else {
						// Assigns the new reference
						File filename = fileNameNew;
						// Gets the absolute path and stores it in a String
						// variable to help find extension of File
						String absolutePath = filename.getAbsolutePath();
						// Gets the extension of the file for comparison
						String fileExtension = FilenameUtils.getExtension(absolutePath);
						// If the extension is not null
						if (fileExtension != null) {
							// If the path is not null
							if ((rootPathConfig != null)) {
								// Add the file name to the ArrayList
								ret.add(filename);
							}
						}
					}
				}
			}
			// Remove the currently checked Directory/File to avoid repetition search
			nextDir.remove(0);
		}
		return ret;
	}

}
