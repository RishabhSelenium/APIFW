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
- com.testing.Resources
- com.testing.TestMethods
- com.testing.TestSteps
- com.testing.Utility
- Runner
```





