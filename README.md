# Customer Bank API

A RESTful API built with Spring Boot for managing customer information. This project was developed as part of a coding challenge from a Udemy course for practice purposes.

## 📋 Overview

This is a full-stack Spring Boot application that provides a complete CRUD (Create, Read, Update, Delete) API for customer management. The application uses an in-memory H2 database for data persistence and follows a layered architecture pattern with controller, service, and repository layers.

## 🛠️ Technologies Used

- **Java 21**
- **Spring Boot 4.0.2**
- **Spring Data JPA** - For data persistence
- **Spring Web MVC** - For REST API endpoints
- **H2 Database** - In-memory database for development
- **Lombok 1.18.42** - Reduces boilerplate code (getters, setters, constructors)
- **Spring Boot DevTools** - For hot reload during development
- **Maven** - Build and dependency management

## 🏗️ Architecture

The application follows a clean layered architecture:

```
├── Controller Layer (CustomerController)
│   └── Handles HTTP requests and responses with proper ResponseEntity usage
├── Service Layer (CustomerService & CustomerServiceImpl)
│   └── Contains business logic with improved return types (Customer/Optional<Customer>)
├── Repository Layer (CustomerRepository)
│   └── Data access using Spring Data JPA
└── Model Layer (Customer)
    └── Entity representing customer data
```

## 📊 Data Model

### Customer Entity

The Customer entity uses **Lombok annotations** (`@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`) to automatically generate getters, setters, constructors, `toString()`, `equals()`, and `hashCode()` methods.

| Field        | Type   | Description                          |
|-------------|--------|--------------------------------------|
| id          | Long   | Auto-generated primary key           |
| firstName   | String | Customer's first name                |
| lastName    | String | Customer's last name                 |
| email       | String | Customer's email address (unique)    |
| phoneNumber | String | Customer's phone number              |

## 🚀 API Endpoints

All endpoints are prefixed with `/api/v1/`

| Method | Endpoint                    | Description              | Response Code |
|--------|-----------------------------|--------------------------|---------------|
| GET    | `/api/v1/customers`         | Get all customers        | 200 OK        |
| GET    | `/api/v1/customers/{id}`    | Get customer by ID       | 200 OK / 404 Not Found |
| POST   | `/api/v1/customers`         | Create a new customer    | 200 OK        |
| PUT    | `/api/v1/customers/{id}`    | Update existing customer | 200 OK / 404 Not Found |
| DELETE | `/api/v1/customers/{id}`    | Delete a customer        | 200 OK / 404 Not Found |

### Sample Request/Response

**GET `/api/v1/customers`**
```json
[
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "phoneNumber": "+1234567890"
  }
]
```

**GET `/api/v1/customers/1`**
```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "phoneNumber": "+1234567890"
}
```

**POST `/api/v1/customers`**

Request:
```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "phoneNumber": "+1234567890"
}
```

Response (200 OK):
```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "phoneNumber": "+1234567890"
}
```

**PUT `/api/v1/customers/1`**

Request:
```json
{
  "firstName": "Jane",
  "lastName": "Smith",
  "email": "jane.smith@example.com",
  "phoneNumber": "+9876543210"
}
```

Response (200 OK):
```json
{
  "id": 1,
  "firstName": "Jane",
  "lastName": "Smith",
  "email": "jane.smith@example.com",
  "phoneNumber": "+9876543210"
}
```

## 🏃 Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.6 or higher

### Installation & Running

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd customer-bank-api
   ```

2. **Build the project**
   ```bash
   ./mvnw clean install
   ```

3. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

   Or run the JAR directly:
   ```bash
   java -jar target/customer-bank-api-0.0.1-SNAPSHOT.jar
   ```

4. **Access the application**
   - API Base URL: `http://localhost:8080/api/v1/`
   - H2 Console: `http://localhost:8080/h2-console`
     - JDBC URL: `jdbc:h2:mem:testdb-challenge`
     - Username: `sa`
     - Password: (leave blank)

## 🧪 Testing the API

You can test the API using tools like:
- **cURL**
- **Postman** (Collection included in `Postman Collection/` directory)
- **HTTPie**
- **Insomnia**

### Using the Postman Collection

A ready-to-use Postman collection is included in the project:
- **Location:** `Postman Collection/Spring Boot Bank Customer API.postman_collection.json`
- **Import:** Import this file into Postman to access pre-configured requests for all endpoints

The collection includes requests for:
- Get All Customers
- Get Customer By ID
- Create Customer
- Update Customer
- Delete Customer

### Example using cURL

```bash
# Get all customers
curl http://localhost:8080/api/v1/customers

# Get a customer by ID
curl http://localhost:8080/api/v1/customers/1

# Create a customer
curl -X POST http://localhost:8080/api/v1/customers \
  -H "Content-Type: application/json" \
  -d '{"firstName":"Jane","lastName":"Smith","email":"jane@example.com","phoneNumber":"555-1234"}'

# Update a customer
curl -X PUT http://localhost:8080/api/v1/customers/1 \
  -H "Content-Type: application/json" \
  -d '{"firstName":"Jane","lastName":"Doe","email":"jane.doe@example.com","phoneNumber":"555-5678"}'

# Delete a customer
curl -X DELETE http://localhost:8080/api/v1/customers/1
```

## 💾 Database

The application uses an **H2 in-memory database** which means:
- Data is stored in memory and is lost when the application stops
- Perfect for development and testing
- No external database setup required
- SQL queries are logged to the console for debugging

You can access the H2 console at `http://localhost:8080/h2-console` to view and query the database directly.

## 📝 Configuration

Application configuration can be found in `src/main/resources/application.properties`:

```properties
spring.application.name=customer-bank-api
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb-challenge
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## 🎯 Learning Outcomes

This project demonstrates:
- Building RESTful APIs with Spring Boot
- Implementing CRUD operations
- Using Spring Data JPA for database operations
- Layered architecture pattern
- Exception handling in REST controllers
- Dependency injection with Spring
- H2 database integration
- Using Lombok to reduce boilerplate code
- Using Spring Boot DevTools for faster development

## 📚 Future Enhancements

Potential improvements for this project:
- Add input validation using Bean Validation
- Implement pagination for the GET all customers endpoint
- Add search and filter capabilities
- Implement proper exception handling with custom exception classes
- Add unit and integration tests
- Add API documentation with Swagger/OpenAPI
- Implement security with Spring Security
- Migrate to a persistent database (PostgreSQL, MySQL)
- Add logging with SLF4J

## 📄 License

This project was created for educational purposes as part of a Udemy course coding challenge.

## 👨‍💻 Author

Created as a practice project for learning Spring Boot development.

---

**Note:** This is a practice project and is not intended for production use.
