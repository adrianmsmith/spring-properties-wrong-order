package com.databasesandlife.propertieswrongorder;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class Main {

    protected static String getJavaValue() throws IOException {
        var properties = new Properties();
        properties.load(Main.class.getClassLoader().getResourceAsStream("foo.properties"));
        return properties.getProperty("foo");
    }

    protected static String getSpringValue() throws IOException {
        var properties = PropertiesLoaderUtils.loadAllProperties("foo.properties");
        return properties.getProperty("foo");
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("-----");
        System.out.println("Expecting the value 'higher-priority' to override 'lower-priority'");
        System.out.println("Value of property according to Java is: " + getJavaValue());
        System.out.println("Value of property according to Spring is: " + getSpringValue());
        System.out.println("-----");
    }
}
