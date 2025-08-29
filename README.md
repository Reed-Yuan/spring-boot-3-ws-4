# Spring Boot 3 with JAX-WS 4.0 Service

This project demonstrates how to create a JAX-WS 4.0 web service using Spring Boot 3. The service provides user management operations through SOAP web services.

## Features

- **Spring Boot 3**: Latest version with Java 17 support
- **JAX-WS 4.0**: Jakarta XML Web Services 4.0 implementation
- **SOAP 1.2**: Modern SOAP binding with document/literal style
- **Metro Runtime**: JAX-WS reference implementation
- **User Management**: CRUD operations for user entities

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Spring Boot 3.2.0

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/example/
│   │       ├── Application.java          # Main Spring Boot application
│   │       ├── config/
│   │       │   └── JaxWsConfig.java     # JAX-WS configuration
│   │       ├── model/
│   │       │   └── User.java            # User entity with JAXB annotations
│   │       └── service/
│   │           └── UserService.java     # JAX-WS web service implementation
│   ├── resources/
│   │   └── application.properties       # Application configuration
│   └── webapp/
│       └── WEB-INF/
│           ├── web.xml                  # Web application configuration
│           └── sun-jaxws.xml            # JAX-WS endpoint configuration
└── test/
    └── java/
        └── com/example/
            └── UserServiceTest.java     # Test class
```

## Web Service Operations

The `UserService` provides the following SOAP operations:

1. **getUser(userId: String)**: Retrieve a user by ID
2. **createUser(user: User)**: Create a new user
3. **updateUser(user: User)**: Update an existing user
4. **deleteUser(userId: String)**: Delete a user by ID
5. **getAllUsers()**: Retrieve all users

## Building the Project

```bash
mvn clean compile
```

## Running the Application

```bash
mvn spring-boot:run
```

The application will start on port 8080.

## Accessing the Web Service

### WSDL Location
- **WSDL**: http://localhost:8080/ws/users?wsdl
- **Service Endpoint**: http://localhost:8080/ws/users

### SOAP Request Examples

#### Get User
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                   xmlns:user="http://example.com/user">
   <soapenv:Header/>
   <soapenv:Body>
      <user:getUser>
         <userId>123</userId>
      </user:getUser>
   </soapenv:Body>
</soapenv:Envelope>
```

#### Create User
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlso.org/soap/envelope/"
                   xmlns:user="http://example.com/user">
   <soapenv:Header/>
   <soapenv:Body>
      <user:createUser>
         <user>
            <id>456</id>
            <name>Jane Smith</name>
            <email>jane.smith@example.com</email>
         </user>
      </user:createUser>
   </soapenv:Body>
</soapenv:Envelope>
```

## Testing

Run the tests using:

```bash
mvn test
```

## Configuration

### Application Properties
- `server.port`: HTTP server port (default: 8080)
- `logging.level.com.example`: Logging level for application classes
- `logging.level.com.sun.xml.ws`: Logging level for JAX-WS runtime

### JAX-WS Configuration
- **Servlet Mapping**: `/ws/*`
- **Service Endpoint**: `/ws/users`
- **SOAP Binding**: Document/Literal style
- **SOAP Version**: SOAP 1.2

## Dependencies

- **Spring Boot Starter Web**: Web application support
- **Jakarta XML Web Services API**: JAX-WS 4.0 API
- **JAX-WS Runtime**: Metro implementation
- **JAXB Runtime**: XML binding support

## Troubleshooting

### Common Issues

1. **Port Already in Use**: Change `server.port` in `application.properties`
2. **WSDL Not Accessible**: Ensure the application is running and check the endpoint URL
3. **SOAP Faults**: Check the server logs for detailed error information

### Logging

Enable debug logging by setting:
```properties
logging.level.com.example=DEBUG
logging.level.com.sun.xml.ws=DEBUG
```

## Next Steps

- Add authentication and authorization
- Implement database persistence
- Add validation and error handling
- Create client applications
- Add monitoring and metrics

## License

This project is for educational purposes.
