package org.personal.helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropertiesHelper {

    Properties properties;

    public PropertiesHelper() {
        String path = "src/main/resources/testData.properties";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("testData.PropertiesHelper not found at " + path);
        }
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }

    public Object addValue(String key, String value) {
        return properties.put(key, value);
    }

    public Object updateValue(String key, String value) {
        return properties.replace(key, value);
    }

    public Object deleteValue(String key) {
        return properties.remove(key);
    }

}
