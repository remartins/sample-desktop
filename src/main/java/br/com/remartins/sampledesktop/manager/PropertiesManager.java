package br.com.remartins.sampledesktop.manager;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import br.com.remartins.sampledesktop.util.Constants;
import br.com.remartins.sampledesktop.util.Utils;

public class PropertiesManager {


	private FileProperties fileProperties;
	
	private static PropertiesManager instance;
	private File propFile;
	private Properties prop;

	private PropertiesManager() throws IOException {
		this.fileProperties = new FileProperties();
		this.propFile = new File(getPropertiesPath());

		if (propFile.exists()) {
			loadProperties();
		} else {
			createPropertiesDefault();
			loadProperties();
		}
	}


	public static PropertiesManager instance() throws IOException {
		if (instance == null) {
			instance = new PropertiesManager();
		}
		return instance;
	}

	public String getProperty(String key) {
		return prop.getProperty(key);
	}

	private void loadProperties() throws IOException {
		this.prop = fileProperties.loadPropertiesFromFile(this.propFile);
	}


	private void createPropertiesDefault() throws IOException {
		prop = new Properties();
		prop.put(Constants.KEY_PROPERTIES_SAMPLE, Constants.VALUE_PROPERTIES_SAMPLE);
		fileProperties.savePropertiesFileDisk(prop, propFile, Constants.TITLE_PROPERTIES);
	}


	private String getPropertiesPath() {
		return Utils.getCurrentDirectory() + File.separator + Constants.FILENAME_PROPERTIES;
	}

}
