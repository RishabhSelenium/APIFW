#RestAssured API Testing Automation Framework

This project has a RestAssured based API testing framework. Underlying, it uses RestAssured -API testing library, TestNG - Third-party free library for Running tests. This framework can be used for any Restful application to create API tests.

##Framework Details
REST Assured is a Java DSL for simplifying testing of REST based services built on top of HTTP Builder. It supports POST, GET, PUT, DELETE, OPTIONS, PATCH and HEAD requests and can be used to validate and verify the response of these requests.


##Project structure
This project uses a standard Maven Java project with standard java folder structure and POM.xml


##Properties
src/main/resources/constants.properties is a simple constants properties file to store various constants like application URL


##Test Package
src/test/java/ is the actual test package and contains multiple sub package details are mentioned in the following section holds all test classes (TestNG) related to restfulbooker application

```
src/test/Java
- com.testing.Assertions
  - TestCaseValidate.java
- com.testing.Resources
  - createUser.JSON
  - invalidEmail.JSON
  - userComment.JSON
  - UserPosts.JSON
  - userTodo.JSON
- com.testing.TestMethods
  - Testcase01.java
- com.testing.TestSteps
  - HttpMethods.Java
- com.testing.Utility
  - JsonParsing.java
  - JsonVariable.java
  - LoadJson.java
  - LoadPropertiesFile.java
  - RandomData.java
- Runner
  - ApiTestCases.java
  - SeleniumTestCase.java

```

**1.com.testing.Assertions**

TestCaseValidate.java
> Thi Java class is implemented to validate the Status code and Error message of Tests. We have ```validateErroMessage()``` and ```validateSTATUS``` in this class

**2.com.testing.Resources**
> This package contains all the JSON files we are using 

**3.com.testing.TestMethods**
TestCase01.java
> In this Java class we made methods to create user, post, comment, and todo

**4.com.testing.TestSteps**
HttpMethods.Java
> In this class we created methods to POST and GET the request

**5.com.testing.Utility**
JsonParsing.java
> This Java class is implemented to Parse the JSON

JsonVariable.java
> This Java will replace the value of key in JSON

LoadJson.java
> This class is used to load JSON file

> LoadPropertiesFile.java
This class is used to load Properties file where all the URI links are kept

> RandomData.java
This class is used to generate random Id's

**6.Runner**
ApiTestCases.java
> We are using this class to run our test cases. We implemented TestNG annotations to run our test cases. This class contains public void ```Test_001_createUser()```, ```Test_002_sameEmailAddress()```, ```Test_003_invalidEmail()``` and ```Test_004_fetchEntries()```. In this class we have called the methods from ```TestCase01```.


<h2>Installation</h2>

<h3>Steps to follow to setup API automation in local system:</h3>

<h4>Install Java: [Skip this step if already installed]</h4>

<h4>Check if Java is installed.</h4>

* In terminal enter java -version to check if java is installed in the system.
* In terminal enter javac -version to check if java compiler is installed in the system.
* Any version of java greater than 1.8 is supported.
* Install java development kit if not available.








