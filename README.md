# Test Automation Guide

This document provides instructions on how to run automated tests for the project using Maven. The tests can be executed in different environments and browsers.

---

## Table of Contents
1. [Running Tests with a Specific Environment](#running-tests-with-a-specific-environment)
2. [Running Tests in a Specific Browser](#running-tests-in-a-specific-browser)
3. [Task Description](#task-description)

---

## Running Tests with a Specific Environment

To run tests with a specific environment, set the Maven profile. The available profiles are:

- **dev** (default) - Development environment
- **test** - Test environment
- **prod** - Production environment

### Example: Run Tests in the Development Environment
```bash
mvn -Pdev test
```

## Running Tests in a Specific Browser

To run tests in a specific browser, set the browser system property. The available browsers are:

- **chrome** (default) 
- **firefox** 
- **edge**
- **safari**

### Example: Run Tests in the Development Environment
```bash
mvn -P{env} -Dbrowser=chrome test
```

## Task description
Launch URL: https://www.saucedemo.com/

### UC-1 Test Login form with empty credentials:
Type any credentials into "Username" and "Password" fields.
Clear the inputs.
Hit the "Login" button.
Check the error messages: "Username is required".

### UC-2 Test Login form with credentials by passing Username:
Type any credentials in username.
Enter password.
Clear the "Password" input.
Hit the "Login" button.
Check the error messages: "Password is required".

### UC-3 Test Login form with credentials by passing Username & Password:
Type credentials in username which are under Accepted username are sections.
Enter password as secret sauce.
Click on Login and validate the title “Swag Labs” in the dashboard.

Provide parallel execution, add logging for tests and use Data Provider to 
parametrize tests. Make sure that all tasks are supported by these 3 
conditions: UC-1; UC-2; UC-3.

Please, add task description as README.md into your solution!
To perform the task use the various of additional options:
Test Automation tool: Selenium WebDriver;
Project Builder: Maven;
Browsers: 1) Firefox; 2) Edge;
Locators: XPath;
Test Runner: JUnit;
[Optional] Patterns: 1) Singleton; 2) Adapter; 3) Strategy;
[Optional] Test automation approach: BDD;
Assertions: Hamcrest;
[Optional] Loggers: SLF4J.
