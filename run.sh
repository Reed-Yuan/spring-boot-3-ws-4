#!/bin/bash

echo "Starting Spring Boot JAX-WS 4.0 Service..."
echo "=========================================="

# Check if Java is installed
if ! command -v java &> /dev/null; then
    echo "Error: Java is not installed or not in PATH"
    exit 1
fi

# Check Java version
JAVA_VERSION=$(java -version 2>&1 | head -n 1 | cut -d'"' -f2 | cut -d'.' -f1)
if [ "$JAVA_VERSION" -lt 17 ]; then
    echo "Error: Java 17 or higher is required. Current version: $JAVA_VERSION"
    exit 1
fi

echo "Java version: $(java -version 2>&1 | head -n 1)"
echo "Starting application on port 8080..."
echo "Access the service at: http://localhost:8080"
echo "WSDL available at: http://localhost:8080/ws/users?wsdl"
echo ""
echo "Press Ctrl+C to stop the application"
echo ""

# Run the Spring Boot application
mvn spring-boot:run
