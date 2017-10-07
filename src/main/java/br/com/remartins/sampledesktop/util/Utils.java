package br.com.remartins.sampledesktop.util;

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

}
