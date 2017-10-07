package br.com.remartins.sampledesktop.manager;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

public class FilePropertiesTest {

	@Test
	public void savePropertiesFileDisk() {
		try {
			File filePropertiesTemp = File.createTempFile("fileproperties", ".properties");
			filePropertiesTemp.deleteOnExit();

			FileProperties fileProperties = new FileProperties();
			Properties properties = new Properties();
			properties.put("key", "value");

			fileProperties.savePropertiesFileDisk(properties, filePropertiesTemp);

			assertTrue(filePropertiesTemp.length() > 0);

		} catch (IOException ex) {
			fail();
		}
	}

	@Test
	public void loadPropertiesFromFile() {
		try {
		File filePropertiesTemp = File.createTempFile("fileproperties", ".properties");
		filePropertiesTemp.deleteOnExit();

		FileProperties fileProperties = new FileProperties();
		Properties properties = new Properties();
		properties.put("key", "value");

		fileProperties.savePropertiesFileDisk(properties, filePropertiesTemp);
			
		Properties propertiesLoaded = fileProperties.loadPropertiesFromFile(filePropertiesTemp);
		
		assertTrue("value".equals(propertiesLoaded.get("key")));

		} catch (IOException ex) {
			fail();
		}
	}
	
	@Test
	public void deletePropertiesFileDiskError() {
		FileProperties fileProperties = new FileProperties();
		try {
			fileProperties.deletePropertiesFileDiskError();
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

}
