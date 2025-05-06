# Pet Tracker - Spring Boot API

A simple Spring Boot application for tracking pets (Dogs and Cats) with in-zone detection and grouped reporting. Designed as part of a backend task using Java 11, Spring Boot, JPA, and an in-memory H2 database.

## Features

- REST API to add and track Dogs and Cats  
- Single Table Inheritance using `@Inheritance`  
- Validation: Cat must have `lostTracker` field  
- Endpoint to get pets that are out of zone, grouped by type and tracker  
- H2 in-memory database — no setup needed  
- Unit tests for service and controller layers

## Technologies Used

- Java 11  
- Spring Boot 2.7.15  
- Spring Data JPA  
- H2 Database  
- Maven Wrapper (mvnd)  
- JUnit 5 + Mockito  
- MockMvc for controller tests

## API Endpoints

### Add Dog
POST /pets/dog

### Add Cat
POST /pets/cat


### Add Cat without lostTracker (will fail)

Returns:

{
"error": "Field 'lostTracker' must not be null for Cat"
}

### Get All Pets
GET /pets

### Get Out-of-Zone Pets Grouped

GET /pets/out-of-zone


## Running Tests
mvnd test

## Running the Application
mvnd spring-boot:run

Then open http://localhost:8080

## Project Structure

- `model/` - Pet, Dog, Cat  
- `repository/` - PetRepository  
- `service/` - PetService (with validation logic)  
- `controller/` - PetController (REST APIs)  
- `exception/` - Global exception handler  
- `test/` - Unit and controller tests

## Author

Created by Bhumika Marolia as part of an interview backend coding task.
