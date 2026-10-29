# Hello World SOAP Service

A simple SOAP web service written in Java 21 using Jakarta XML Web Services
(JAX-WS). The service exposes one operation, `sayHello`, which returns:

```text
Hello, World!
```

## Requirements

- Java 21 or later
- Apache Maven

The project uses the `jaxws-rt` dependency to provide the Jakarta SOAP runtime.

## Project structure

```text
src/main/java/
├── HelloWorldServer.java
├── HelloWorldServerInterface.java
└── HelloWorldClient.java
```

- `HelloWorldServerInterface` declares the SOAP operation.
- `HelloWorldServer` implements and publishes the SOAP endpoint.
- `HelloWorldClient` loads the WSDL and invokes the remote operation.

## Start the SOAP service

From the project directory, run:

```bash
mvn compile exec:java -Dexec.mainClass=main.java.HelloWorldServer
```

The service is published at:

```text
http://localhost:8080/HelloWorld
```

The generated WSDL is available at:

```text
http://localhost:8080/HelloWorld?wsdl
```

Leave the server running while using the client. Stop it with `Ctrl+C`.

## Run the client

Open a second terminal in the project directory and run:

```bash
mvn compile exec:java -Dexec.mainClass=main.java.HelloWorldClient
```

Expected output:

```text
Hello, World!
```

## Build the project

To compile the project without starting the service:

```bash
mvn compile
```

The Maven build output is written to `target/`, which is excluded by
`.gitignore`.
