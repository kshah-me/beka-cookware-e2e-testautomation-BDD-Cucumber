# Beka-Cookware Ecommerce Test Automation BDD-Cucumber-TestNG

### This is a complete project where an [E-commerce site](https://www.beka-cookware.com/) site is automated by writing test suites using selenium-webdriver and BDD-Cucumber-TestNG as testing framework. This Framework help to run application on different languages, parallel execution on scenario level with thread safety, retrylogic in case failure, record the execution and could be configure in config.property file.


The following key modules/pages are automated:

- **HomePage**
- **SearchPage**
- **ProductDetailsPage**
- **CartPage**
- **Checkout**</br>

Key test cases(total **39**) are written for test suites created including the positive and negative test cases.</br>A state-transition flow of test-cases are designed and run like a user searching and adding product into cart from an e-commerce site.</br>
For failed test cases it will take a screenshot as well at the point of failure.


---

**Project Structure:**

- **pom.xml:** Maven configuration file containing project dependencies for Selenium Webdriver, Java, RestAssued, BDD-Cucumber,TestNG, screen-recorder and   Chaintest.

- **testNG.xml:** The thread count can be increase or decrease incase of parallel testing.


-**configuration:**
  -	**config.property:** This file helps to provide the URL, Execution recording option,set the preferred browser and provide the preferred Language settings in which the URL would be loaded. 
  
- **src/main/java:**
  - **base:** Contains DriverFactory.java, a class providing setup and teardown methods, initializing WebDriver instances.
  - **config:** ConfigReader.java, offering methods to read data from config file, here url of application, browser name on which test to be run, and Language of application are defined.
  - **pageObjects:** Stores CartPage.java, CheckoutPage.java, CommonActivity.java, HomePage.java, NavigationFilterPage.java,ProductDetailsPage.java, 
	  SearchPage.java defining XPath expressions for elements on mentioned pages.
  - **utility:** Contains various utility classes:
    - **AnnotationTransformer.java and RetryAnalyzer.java:** Controls the retry behavior of failed tests in BDD-Cucumber-TestNG.
    - **CaptureScreenshotEvidence.java:** Provides methods capturing screenshot while failing testcases.
    - **MouseKeyboardAction.java:** To perfomr mouseorkeybaord operation on any Webelement.
    - **PageScrollUtility.java:** It helps to scroll the page to defined element.
	- **ScreenRecorderUtil:** It create the video recording of execution
	- **UrlCheck.java:** This helps to verify all urls and images are broken or not
	- **WaitUtils:** This helps to wait for an Webelement for given condition 

- **src/test/java:**
  - **stepdefinitions:** stepdefinitions has implematation of all steps mentioned in features files
  - **hooks:** Hooks help to initiaze the browser and close the browser once the execution is done
  - **runner:** All features files location is mentioned for execution
---




### Technology: </br>

- Tool: Selenium Webdriver
- IDE: Intellij IDEA
- Build tool: Maven
- Language: Java
- Testing Framework : BDD-Cucumber-TestNG

### Prerequisite: </br>

- Need to install jdk 21, maven and chaintest
- Configure Environment variable for jdk 21, maven and chaintest
- Clone this project and unzip it
- Open the project into IntellIJ IDEA

### Build the project

```java
mvn clean install -DskipTests
```

### Run the Automation Script by the following command

```java
mvn clean test
```
- Let the project build successfully
- Selenium will open the browser and start automating.
- After automation to view allure report , give the following commands:


---

**Output:**

	- **target/chaintest/resources:** Execution report in html formate will be generated here. 
	- **test-execution-recordings:** The video recording of test execution with scenarios name will be generated here. 

```Chaintest report overview


```