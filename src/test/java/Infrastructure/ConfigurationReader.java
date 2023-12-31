package Infrastructure;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigurationReader {
    private static ObjectNode configuration;

    public static void initializeConfig(String configFile) {
        try {
            // Read configuration file
            String configContent = new String(Files.readAllBytes(Paths.get(configFile)));

            // Parse JSON content
            ObjectMapper objectMapper = new ObjectMapper();
            configuration = objectMapper.readValue(configContent, ObjectNode.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ObjectNode getConfiguration() {
        if (configuration == null) {
            throw new IllegalStateException("Configuration has not been initialized. Call initializeConfig first.");
        }
        return configuration;
    }
    public static String getPlatformName() {
        return configuration.get("platformName").asText();
    }

    public static String getPlatformVersion() {
        return configuration.get("platformVersion").asText();
    }

    public static String getDeviceName() {
        return configuration.get("deviceName").asText();
    }

    public static String getAppPackage() {
        return configuration.get("appPackage").asText();
    }

    public static String getAppActivity() {
        return configuration.get("appActivity").asText();
    }

    public static String getAutomationName() {
        return configuration.get("automationName").asText();
    }
}