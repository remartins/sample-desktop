package br.com.remartins.sampledesktop;

import java.io.IOException;

import org.apache.log4j.Logger;

import br.com.remartins.sampledesktop.manager.PropertiesManager;
import br.com.remartins.sampledesktop.util.Constants;

public class Main {
	
	private static final Logger LOGGER = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		try {
			PropertiesManager pm = PropertiesManager.instance();
			System.out.println(pm.getProperty(Constants.KEY_PROPERTIES_SAMPLE));
		} catch (IOException e) {
			LOGGER.error(e);
		}
	}

}
