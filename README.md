# ROCHE_ASSIGNMENT
Web UI Automation Framework 

# Techology and Tools
Java 8
TestNG
Selenium WebDriver
Hamcrest Assertion
Log4J 
Maven
Browser Drivers

# Framework
Automation Framework used Page Factory Pattern where WebElement initalization in one go which speedup the execution. Currently Test Data maintained into .properties file but can be used with .csv , .xml etc as developed model classe to traverse the data across the application.
Used inbuilt testng reporting tool to generate test reports.
Automation Framework developed with combination of test suite, but can be easly dicouple from test suite.
By default test suite run over FireFox browser but can be able to execute on other browser by passing argument run time.

# Execution [-browser run time parameter is optioal]
mvn clean test -browser='chrome' / 'firefox' \
testng testng.xml -browser='chrome' / 'firefox'
