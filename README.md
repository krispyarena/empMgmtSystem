# Employee Management System

Welcome to the Employee Management System project! This README will guide you through the setup, structure, and usage of the project. This application is developed using Spring Boot and Bootstrap, providing a comprehensive platform for managing employee data.

## Project Overview

The Employee Management System is a full-stack web application with the following key features:

- **CRUD Operations**: Manage employee records with Create, Read, Update, and Delete functionality.
- **User Authentication**: Secure login and registration system.
- **Search and Filter**: Efficiently search and filter employee records.
- **Responsive Design**: A user-friendly interface that adapts to various devices.

## Features

### Backend (Spring Boot)

- **CRUD Operations**: 
  - Implement CRUD operations for managing employee data.
- **Authentication**:
  - Secure user authentication and role-based authorization.
- **API Documentation**:
  - Use Swagger for API documentation.

### Frontend (Bootstrap)

- **Login and Registration**:
  - Components for user authentication.
- **Employee Management**:
  - Components to view, add, update, and delete employee records.
- **Search and Filter**:
  - Implement search and filter functionality.
- **Responsive Design**:
  - Use Bootstrap for a responsive and attractive user interface.

## Getting Started

### Prerequisites

- Java 11 or higher
- Node.js and npm
- MySQL or any other preferred database

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/krispyarena/empMgmtSystem.git
   cd empMgmtSystem
   ```

2. **Backend Setup (Spring Boot)**
   - Update the database configuration in `application.properties`.
   - Build and run the Spring Boot application.
   ```bash
   ./mvnw spring-boot:run
   ```


### Usage

- Navigate to `http://localhost:3000` in your browser.
- Register a new user or login with existing credentials.
- Explore the various features such as adding employees, updating records, and searching for employees.

### Deployment

#### Deploying to Heroku

- Follow the official [Heroku documentation](https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku) to deploy the Spring Boot backend.
- Follow the official [Heroku documentation](https://devcenter.heroku.com/articles/deploying-react-apps) to deploy the Bootstrap frontend.

#### Deploying to AWS

- Follow the official [AWS documentation](https://aws.amazon.com/getting-started/hands-on/deploy-springboot-application/) to deploy the Spring Boot backend.
- Follow the official [AWS documentation](https://aws.amazon.com/getting-started/hands-on/deploy-react-app-cicd-amplify/) to deploy the Bootstrap frontend.

## Contributing

If you would like to contribute to this project, please fork the repository and create a pull request. We welcome all contributions that improve the project.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any inquiries or feedback, please contact at krispy.arena@gmail.com or create an issue on this repository.
