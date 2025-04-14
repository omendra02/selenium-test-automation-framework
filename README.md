# Selenium Test Automation Project

This project contains Selenium WebDriver tests for web application testing.

## Security Guidelines

For security reasons, sensitive information should never be committed to the repository. Follow these guidelines:

1. Never commit the `config.properties` file
2. Use environment variables for sensitive data
3. Keep the `config.properties.sample` file updated with the latest configuration structure

## Setup Instructions

### Prerequisites
- Java 8 or higher
- Maven
- Chrome browser
- ChromeDriver

### Configuration

You have two options for configuration:

#### Option 1: Environment Variables
Set the following environment variables:
```bash
export TEST_BASE_URL=https://your-app-url.com
export TEST_RESULTS_PATH=TestResults
export TEST_VALID_EMAIL=your-email@example.com
export TEST_VALID_PASSWORD=your-password
export TEST_INVALID_EMAIL=invalid@example.com
export TEST_INVALID_PASSWORD=invalid123
```

#### Option 2: Configuration File
1. Copy `config.properties.sample` to `config.properties`
2. Update the values in `config.properties` with your actual configuration

### Running Tests

To run the tests:
```bash
mvn test
```


- Use the sample configuration file as a template for new environments

## Project Structure

- `src/test/java/Test/` - Test classes
- `src/test/java/Pages/` - Page Object Model classes
- `src/test/java/Config/` - Configuration management
- `src/test/resources/` - Configuration files and resources
- `TestResults/` - Test execution results (not committed) 
