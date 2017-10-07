package br.com.remartins.sampledesktop.util;

import java.io.File;

public final class Utils {

	private Utils() {
	}

	/**
	 * Return current directory
	 * 
	 * @return
	 */
	public static String getCurrentDirectory() {
		return System.getProperty("user.dir");
	}
	
	public static String getFilePropertiesPath() {
		return getCurrentDirectory() + File.separator + Constants.FILENAME_PROPERTIES;
	}
}
