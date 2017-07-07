package cn.datarx.automation.helpers;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Yuan on 2017/7/6.
 */
public class Env {

    private static Logger logger = Logger.getLogger(Env.class);

    private static Properties properties;

    static {

        properties = new Properties();

        try (InputStream in = ClassLoader.getSystemResourceAsStream("env.properties")) {
            properties.load(in);
        } catch (IOException e) {
            logger.error(e);
        }

    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

}
