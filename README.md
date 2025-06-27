# Checkout Staffing Planner - Spring Boot API

This application is a backend RESTful API used for managing checkout staff shift planning

---

## Features

- Employees can submit shift wishes for specific dates (`/wishbook`)
- Admins can generate shift plans based on submitted wishes (`/plan`)
- Employees and admins can view scheduled shifts per day (`/schedule`)
- Role-based restriction: only admins can access the planning endpoint
- Uses H2 in-memory database for testing the functionality
- Automatically preloads sample employee data at startup

---

## Technologies Used

- Java 17
- Spring Boot (Web, Data JPA)
- H2 In-Memory Database
- Maven

---

## How to Run

1. Ensure you have Java 17+ and Maven installed.
2. Open a terminal and navigate to the project directory.
3. Run the app:

```bash
./mvnw spring-boot:run