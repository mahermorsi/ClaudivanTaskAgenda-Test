# Claudivan Taskagenda Automation Testing

This repository contains the automation infrastructure and test cases for the Claudivan Taskagenda application. The tests are implemented using Appium and Cucumber in Java, following the best practices of test automation.

## Description

Claudivan Taskagenda is a task management application designed to help users organize and track their tasks efficiently. This project aims to ensure the robustness and reliability of the application through comprehensive automated testing. The automation framework adheres to the Arrange, Act, Assert (AAA) structure and ensures test isolation, parallel execution, and consistent reporting using Allure Report.

Key features of this project include:

- **Test Isolation**: Each test is independent and does not affect or get affected by other tests.
- **Parallelism**: Tests can run in parallel to reduce execution time.
- **Assertions**: Uses accurate assertions to validate test outcomes.
- **Reporting**: Utilizes Allure Report for detailed and interactive test reports.
- **Infrastructure**: Structured in layers (infra, logic, tests) for maintainability.
- **Page Object Model (POM)**: Ensures a clean separation between test code and page-specific code.
- **Git Practices**: Encourages the use of pull requests, code reviews, and informative commit messages to maintain code quality.
- **Stability**: Focuses on creating stable tests that pass consistently, except in the case of actual bugs in the system.

## Project Structure

The project is structured in layers to ensure clean code separation and maintainability:

- **infra**: Contains the infrastructure code such as configurations and setup.
- **logic**: Contains the business logic and page object models (POM).
- **test**: Contains the test definitions.

## Setup

1. **Clone the repository**:
    ```sh
    git clone https://github.com/yourusername/claudivan-taskagenda-automation.git
    cd claudivan-taskagenda-automation
    ```

2. **Install dependencies**:
    Make sure you have Java, Maven, and Appium installed on your system.

3. **Configure the project**:
    Update the configuration files in the `infra` layer with the appropriate settings for your environment.

## Running Tests

To run the tests, use the following command:

```sh
mvn test

