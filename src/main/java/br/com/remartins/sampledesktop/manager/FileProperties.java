package br.com.remartins.sampledesktop.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileProperties {


	public Properties loadPropertiesFromFile(File file) throws IOException {
		FileInputStream fi = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(fi);
		return properties;
	}

	public void savePropertiesFileDisk(Properties properties, File file) throws IOException {
		savePropertiesFileDisk(properties, file, null);
	}
	
	public void savePropertiesFileDisk(Properties properties, File file, String titleProperties) throws IOException {
		FileOutputStream fo = new FileOutputStream(file);
		properties.store(fo, titleProperties);
		fo.flush();
		fo.close();
	}

}
