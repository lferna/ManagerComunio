package factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GestorDePropiedades {

	private static Map parameters;
	private static final String CONFIGURATION_FILE = "ConfigurationParameters.properties";
	
	static{
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(CONFIGURATION_FILE));
			parameters = new HashMap (properties);
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		
	}
	
	private GestorDePropiedades(){		
	}
	
	public static String getParameter(String key){
		return (String)parameters.get(key);
	}
}
