package br.com.remartins.sampledesktop.manager;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.lang.reflect.Field;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.remartins.sampledesktop.util.Utils;

public class PropertiesManagerTest {
	
	private static final Logger LOGGER = Logger.getLogger(PropertiesManagerTest.class);

	@Test
	public void getPropertyLoadFile() {
		try {
			PropertiesManager pm = PropertiesManager.instance();
			assertTrue("Sample Desktop".equals(pm.getProperty("aplication_name")));
		} catch (IOException ex) {
			fail(ex.getMessage());
		}
	}

	@Test
	public void getPropertyCreateFile() {
		try {
			FileProperties fp = new FileProperties();
			fp.deletePropertiesFileDisk(Utils.getFilePropertiesPath());
			
			PropertiesManager pm = PropertiesManager.instance();
			resetPropertiesManagerSingleton(pm);
			pm = PropertiesManager.instance();

			assertTrue("Sample Desktop".equals(pm.getProperty("aplication_name")));
		} catch (IOException ex) {
			fail(ex.getMessage());
		}
	}
	
	
	private void resetPropertiesManagerSingleton(PropertiesManager pm) {

		try {
			Field instance = PropertiesManager.class.getDeclaredField("instance");
			instance.setAccessible(true);
			instance.set(pm, null);
		} catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException 
				| SecurityException e) {
			LOGGER.error(e);
		}

	}

}
