<h3>RestAssured API Testing Automation Framework</h3>

This project has a RestAssured based API testing framework. Underlying, it uses RestAssured -API testing library, TestNG - Third-party free library for Running tests. This framework can be used for any Restful application to create API tests.

<h3>Framework Details</h3>

REST Assured is a Java DSL for simplifying testing of REST based services built on top of HTTP Builder. It supports POST, GET, PUT, DELETE, OPTIONS, PATCH and HEAD requests and can be used to validate and verify the response of these requests.


<h3>Project structure</h3>

This project uses a standard Maven Java project with standard java folder structure and POM.xml


<h3>Test Package</h3>

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
> Thi Java class is implemented to validate the Status code and Error message of Tests. We have ```validateErroMessage()``` and ```validateSTATUS()``` in this class

**2.com.testing.Resources**
> This package contains all the JSON files we are using to perform the test cases 

**3.com.testing.TestMethods**
TestCase01.java
> In this Java class we made methods to create post, comment, and todo

**4.com.testing.TestSteps**
HttpMethods.Java
> In this class we created methods to POST and GET the request
> personal access token is passed in headers of POST and GET methods

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

<h4>Install Eclipse / Any other latest IDE [Skip this step if already installed]:</h4>

<h4>Install eclipse photon if not available.</h4>

* Download eclipse installer.
* Run eclipse installer.
* Select install eclipse for java developers.
* Open workbench.

<h4>Get Code base:</h4>

<h4>Clone Project<h4>
  
* url : Url
  
<h3>Setup project in Eclipse:</h3>

* File -> Open Project from File System -> Browse the folder and open the cloned project.
* Open -> Help -> Eclipse Marketplace -> Search testng -> Install Testng for eclipse plugin -> Restart eclipse.
* Maven will be available by default, with eclipse. To check, right click on project -> should have an option called maven.


```
  Possible issues:
In case of error in pom.xml file ->Cannot read lifecycle mapping metadata for artifact org.apache.maven.plugins:mav
  - In terminal open Users/<profile_name>/.m2
  - Run rm -r repository
  - Right click on project -> Update project
In case of error in all import statements
  - Click on src/main/java folder -> build path -> remove from build path
  - Click on src -> main -> java ->right click -> build path -> use as source folder
  - Refresh the project
  ```
  
  <h1>Example</h1>
  
Now, let's get started with the 1st test case – : - Create a new user, post, comment and todo. A test for success scenario and also for when some mandatory fields are missing.
  
  <h3>Steps to run TestCase</h3>
  
  1. Navigae to ```com.testing.Resources``` package under ```src/test/java/```
  2. Naigate to ```Runner``` package and open ```ApiTestCases.java```
  3. Change **name** and **email** on line no. **33** and **34**.
  4. Set ```Test_001_createUser()``` as ```@Test(enabled=true)```
  5. Run ```ApiTestCases.java``` file as testNG
  
  **This test case will create new user, post, comment and todo**
  
  <h4>Similarly you have to change the email and name to execute Test_002_sameEmailAddress()
  
  <h3>To run all 4 test cases make sure ```@Test(enabled=true)``` is true for all.</h3>
  
 
  <h2>Asserting Response code</h2>
  
  ```validateSTATUS``` method from ```TestCaseValidate.java``` class is used to validate the status code
  
  <h2>Asserting ErrorMessage</h2>
  
  ```validateErroMessage()``` method from ```TestCaseValidate.java``` class is used to validate error code

  <h2>Test Report</h2>

  To get the test report navigate to **/RishabhAssignment/test-output/emailable-report.html**
  
  
  
  
  <img width="796" alt="Screenshot 2022-06-27 at 10 13 21 PM" src="https://user-images.githubusercontent.com/37605701/176001768-8e38ee0d-9e69-4b42-ac82-eef52a5886b9.png">

  
