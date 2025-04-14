package Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestConfig {
    private static final Properties properties = new Properties();
    private static final String CONFIG_FILE = "src/test/resources/config.properties";
    private static final String SAMPLE_CONFIG_FILE = "src/test/resources/config.properties.sample";

    static {
        try {
            // Try to load from environment variables first
            loadFromEnvironment();
            
            // Then try to load from config file
            try {
                properties.load(new FileInputStream(CONFIG_FILE));
            } catch (IOException e) {
                System.err.println("Warning: Could not load config.properties. Using environment variables and defaults.");
            }
        } catch (Exception e) {
            System.err.println("Error loading configuration: " + e.getMessage());
        }
    }

    private static void loadFromEnvironment() {
        // Base URL
        String baseUrl = System.getenv("TEST_BASE_URL");
        if (baseUrl != null) {
            properties.setProperty("base.url", baseUrl);
        }

        // Test results path
        String resultsPath = System.getenv("TEST_RESULTS_PATH");
        if (resultsPath != null) {
            properties.setProperty("test.results.path", resultsPath);
        }

        // Credentials
        String validEmail = System.getenv("TEST_VALID_EMAIL");
        if (validEmail != null) {
            properties.setProperty("valid.email", validEmail);
        }

        String validPassword = System.getenv("TEST_VALID_PASSWORD");
        if (validPassword != null) {
            properties.setProperty("valid.password", validPassword);
        }

        String invalidEmail = System.getenv("TEST_INVALID_EMAIL");
        if (invalidEmail != null) {
            properties.setProperty("invalid.email", invalidEmail);
        }

        String invalidPassword = System.getenv("TEST_INVALID_PASSWORD");
        if (invalidPassword != null) {
            properties.setProperty("invalid.password", invalidPassword);
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("base.url", "https://example.com");
    }

    public static String getTestResultsPath() {
        return properties.getProperty("test.results.path", "TestResults");
    }

    public static String getValidEmail() {
        return properties.getProperty("valid.email");
    }

    public static String getValidPassword() {
        return properties.getProperty("valid.password");
    }

    public static String getInvalidEmail() {
        return properties.getProperty("invalid.email", "invalid@example.com");
    }

    public static String getInvalidPassword() {
        return properties.getProperty("invalid.password", "invalid123");
    }
} 