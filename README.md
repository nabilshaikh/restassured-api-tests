# About

This Maven-based RestAssured and TestNG sample API test automation project is implemented using Java. The project aims to test the [/lead](https://api.tap.company/v3/connect/lead/) endpoint, which helps to initiate the new merchant onboarding process.
For more information, please visit the tap [documentation](https://developers.tap.company/reference/lead). 

## Description

#### Project Folder Structure:

```
├── src/main/java (folder to support common utilities and common methods being used across the framework)
│   └── /helper 
├── src/test/java (contains all the tests)
│   └── /api 
├── src/test/resources (fixtures folder that contains response body in JSON format)
├── .github/workflows (contains .yml file to support GitHub actions)
├── allure-results (contains test results for allure HTML report)
├── .env (contains environment configurations in key-value pair format)
├── testng.xml (configuration file for organizing and executing tests in TestNG)

```

Note:<br> 
The <ins>allure-results</ins> directory gets created only after the first test run.<br>

#### Salient Features:

- Implemented using the latest version of RestAssured [(v5.5.0)](https://github.com/rest-assured/rest-assured/wiki/Downloads) & [TestNG](https://testng.org/) as of today.
- Based on Gherkin standard.
- Provides console and HTML reports using [Allure](https://www.npmjs.com/package/@shelex/cypress-allure-plugin).
- All tests are configured on [CI/CD pipeline](https://github.com/nabilshaikh/restassured-api-tests/actions), hence not requiring any manual intervention to run tests.
- Moreover, to learn how this project evolves throughout the development stage, please refer to the [PRs](https://github.com/nabilshaikh/restassured-api-tests/pulls?q=is%3Apr+is%3Aclosed) in chronological order.

## Getting Started

### Installation:

1. Clone the project.
2. Open the project using [Eclipse](https://www.eclipse.org/downloads/packages/release/2022-09/r/eclipse-ide-java-developers) or any IDE of your choice.
3. Now, go to the terminal and run `mvn clean && mvn install`.<br>


### How To Run Tests?

- To run tests, <br>
        * `mvn test -Dsurefire.suiteXmlFiles=testng.xml` - run tests locally. <br>
        * `mvn allure:report` - generates the allure report. <br>

Once the test execution is complete, this is how the test report(s) would look like,

<ins>Allure report</ins>:

<kbd><img src="https://github.com/user-attachments/assets/48381253-b058-4d9a-ba6c-419d8cabacaf" alt="HTML Report 1" border="1" width=800></kbd>

<kbd><img src="https://github.com/user-attachments/assets/e7294abf-7a1f-431c-84f1-933f850808fb" alt="HTML Report 2" border="1" width=800></kbd>

<br>

<right><p align="right">(<a href="#about">back to top</a>)</p></right>

## Contact

<a href="mailto:nabilshaikh26@gmail.com"><img src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white" /> &nbsp; <a href="https://www.github.com/nabilshaikh"><img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white"/> &nbsp; <a href="https://www.gitlab.com/nabilshaikh26"><img src="https://img.shields.io/badge/GitLab-330F63?style=for-the-badge&logo=gitlab&logoColor=white"/> &nbsp; <a href="https://www.linkedin.com/in/nabil-shaikh-5362b71b3/"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white"/>

<right><p align="right">(<a href="#about">back to top</a>)</p></right>





