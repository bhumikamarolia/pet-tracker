# Pet Tracker - Spring Boot API

A simple Spring Boot application for tracking pets (Dogs and Cats) with in-zone detection and grouped reporting. Designed as part of a backend task using Java 11, Spring Boot, JPA, and an in-memory H2 database.

## Features

- REST API to add and track Dogs and Cats  
- Single Table Inheritance using `@Inheritance`  
- Validation: Cat must have `lostTracker` field  
- DTO-based input validation with `@NotNull`
- Endpoint to get pets that are out of zone, grouped by type and tracker  
- H2 in-memory database — no setup needed  
- Unit & integration tests using JUnit, Mockito, and MockMvc
- Global error handling using `@ControllerAdvice`
- Structured error responses (e.g. `{"lostTracker": "must not be null"}`)

## 🧠 Design Considerations

- **Scalable Architecture**: Clean separation between layers enables easy feature scaling.
- **DTOs for Input/Output**: Prevents entity leakage and improves maintainability.
- **Validation Logic**: Enforced via Java Bean Validation and custom business checks.
- **Structured Error Responses**: API returns user-friendly and consistent error messages.
- **Extensible Logic**: Easily extendable to more pet types or tracker features.

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
- `dto/` - Input/output objects: DogDTO, CatDTO, PetResponseDTO
- `repository/` - PetRepository  
- `service/` - PetService (with validation logic)  
- `controller/` - PetController (REST APIs)  
- `exception/` - Global exception handler  
- `test/` - Unit and integration tests

## Author

Created by Bhumika Marolia as part of an interview backend coding task.
