# Personal Finance Tracker

A Java-based personal finance application that evolved from a command-line expense tracker into a Spring Boot REST API backed by PostgreSQL.

The project was created to strengthen my understanding of Java, object-oriented programming, backend development, REST APIs, Spring Boot, JPA/Hibernate, PostgreSQL, validation, error handling, and automated testing.

---

## Overview

The Personal Finance Tracker helps manage several areas of personal finance:

- Expenses
- Income
- Monthly budgets
- Savings goals
- Recurring expenses
- Financial summaries
- Financial dashboard

The project intentionally evolved over time rather than starting as a fully developed backend application.

### Project Progression

```text
Core Java
    ↓
Object-Oriented Programming
    ↓
Collections
    ↓
File Persistence
    ↓
Spring Boot
    ↓
REST API
    ↓
JPA / Hibernate
    ↓
PostgreSQL
    ↓
Validation
    ↓
Error Handling
    ↓
Automated Testing
    ↓
Financial Dashboard
```

---

# Why I Built This

I wanted to build a project that was more meaningful than a simple CRUD demonstration.

The application is based around a real personal use case: tracking income, expenses, budgets, savings, and recurring costs.

At the same time, it provides a practical way to learn backend engineering concepts.

The project is intentionally limited to a focused Version 1 rather than continuously adding unrelated features.

---

# Features

## Expenses

- Create expenses
- View all expenses
- View an expense by ID
- Delete expenses
- Calculate total expenses

Each expense contains:

- Amount
- Category
- Description
- Database-generated ID

## Income

- Create income
- View income
- View income by ID
- Delete income
- Calculate total income

## Monthly Budget

- Create or update a monthly budget
- View the current budget
- Calculate remaining budget
- Detect whether the user is over budget

## Savings Goals

- Create savings goals
- View savings goals
- View individual goals
- Add contributions
- Calculate remaining amounts
- Determine whether a goal is complete
- Delete savings goals

## Recurring Expenses

- Create recurring expenses
- View recurring expenses
- View individual recurring expenses
- Calculate monthly recurring costs
- Delete recurring expenses

## Financial Dashboard

The dashboard combines information from multiple parts of the application:

- Total income
- Total expenses
- Net balance
- Monthly budget
- Budget remaining
- Over-budget status
- Monthly recurring expenses
- Total saved
- Total savings target

---

# Technology Stack

### Programming

- Java 17
- Object-Oriented Programming
- Maven

### Backend

- Spring Boot
- Spring Web
- REST APIs
- Spring Data JPA
- Hibernate

### Database

- PostgreSQL

### Testing

- JUnit
- Mockito
- H2

### Development

- Git
- GitHub
- VS Code / IntelliJ
- PostgreSQL

---

# Architecture

The REST API uses a layered architecture:

```text
Client
  |
  | HTTP Request
  v
Controller
  |
  v
Service
  |
  v
Repository
  |
  v
JPA / Hibernate
  |
  v
PostgreSQL
```

### Controller

Handles HTTP requests and responses.

### Service

Contains application and business logic.

### Repository

Provides database access through Spring Data JPA.

### Entity

Represents persistent data stored in the database.

### JPA / Hibernate

Maps Java objects to relational database records.

More detailed architecture documentation is available in:

```text
docs/architecture.md
```

---

# API Endpoints

## Expenses

```text
POST   /api/expenses
GET    /api/expenses
GET    /api/expenses/{id}
GET    /api/expenses/total
DELETE /api/expenses/{id}
```

## Income

```text
POST   /api/income
GET    /api/income
GET    /api/income/{id}
GET    /api/income/total
DELETE /api/income/{id}
```

## Budget

```text
GET    /api/budget
PUT    /api/budget
GET    /api/budget/remaining
GET    /api/budget/over-budget
```

## Savings Goals

```text
POST   /api/savings-goals
GET    /api/savings-goals
GET    /api/savings-goals/{id}
DELETE /api/savings-goals/{id}

POST   /api/savings-goals/{id}/contributions?amount=100
GET    /api/savings-goals/{id}/remaining
GET    /api/savings-goals/{id}/complete
```

## Recurring Expenses

```text
POST   /api/recurring-expenses
GET    /api/recurring-expenses
GET    /api/recurring-expenses/{id}
GET    /api/recurring-expenses/monthly-total
DELETE /api/recurring-expenses/{id}
```

## Dashboard

```text
GET    /api/dashboard
```

---

# Example Requests

## Create an Expense

```http
POST /api/expenses
```

```json
{
  "amount": 25.50,
  "category": "Food",
  "description": "Lunch"
}
```

## Set a Budget

```http
PUT /api/budget
```

```json
{
  "monthlyAmount": 1000
}
```

## Create a Savings Goal

```http
POST /api/savings-goals
```

```json
{
  "name": "Laptop",
  "targetAmount": 1500,
  "currentAmount": 500
}
```

---

# Validation and Error Handling

The API validates important user input.

For example:

- Expense amounts must be positive.
- Required text fields cannot be blank.
- Budget amounts cannot be negative.

The project also uses centralized exception handling for consistent API errors.

Examples include:

```text
400 Bad Request
404 Not Found
500 Internal Server Error
```

---

# Testing

The project includes automated tests using:

- JUnit
- Mockito
- Spring Boot testing
- H2

The tests cover examples of:

- Expense calculations
- Savings goal calculations
- Savings goal completion
- Spring application startup

Run tests with:

```bash
cd api
mvn test
```

---

# Running Locally

## Requirements

- Java 17
- Maven
- PostgreSQL

## Database

Create the database:

```bash
createdb finance_tracker
```

Configure:

```text
api/src/main/resources/application.properties
```

Example:

```properties
spring.application.name=finance-api

server.port=8080

spring.datasource.url=jdbc:postgresql://localhost:5432/finance_tracker
spring.datasource.username=YOUR_POSTGRES_USERNAME
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Replace `YOUR_POSTGRES_USERNAME` with the PostgreSQL username configured on your computer.

## Start the API

```bash
cd api
mvn spring-boot:run
```

The API runs at:

```text
http://localhost:8080
```

---

# Project Structure

```text
JavaExpenseTracker/
│
├── README.md
│
├── docs/
│   ├── architecture.md
│   ├── development-reflection.md
│   └── learning-notes.md
│
├── src/
│   ├── Main.java
│   ├── Expense.java
│   ├── ExpenseTracker.java
│   ├── Income.java
│   ├── SavingsGoal.java
│   ├── RecurringExpense.java
│   ├── FinancialSummary.java
│   └── FileStorage.java
│
└── api/
    ├── README.md
    ├── pom.xml
    │
    └── src/
        ├── main/
        │   ├── java/
        │   │   └── com/finance/api/
        │   └── resources/
        │
        └── test/
            ├── java/
            └── resources/
```

---

# Development Story

### v0.1 — Core Java

Created the original command-line expense tracker.

### v0.2 — Financial Features

Added:

- Income
- Savings goals
- Recurring expenses
- Financial summaries

### v0.3 — Persistence

Added file-based data persistence.

### v0.4 — REST API

Introduced Spring Boot and REST endpoints.

### v0.5 — Database

Introduced PostgreSQL, JPA, and Hibernate.

### v0.6 — Budget and Dashboard

Added budget management and a combined financial dashboard.

### v0.7 — Engineering Quality

Added:

- Validation
- Error handling
- Automated tests
- Documentation

### v1.0 — Feature Freeze
