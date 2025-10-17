# Java Webapp Sample (Domain + Application layers)

This sample shows a minimal project structure for:
- domain: exceptions, model, repository interfaces (ports)
- application: usecase interfaces and service implementations
- in-memory repository for tests/dev
- JUnit 5 tests for domain and services

Build with Maven:
```
mvn -q -DskipTests=false test
```

Open in IntelliJ IDEA by importing the Maven project.
