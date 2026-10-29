package main.java;

import jakarta.jws.WebService;
import jakarta.xml.ws.Endpoint;

@WebService(
    endpointInterface = "main.java.HelloWorldServerInterface", //The interface that this class implements
    serviceName = "HelloWorldServerService", //The name of the service, should be equal or similar to the class name of the implementation
    portName = "HelloWorldServerPort", //The name of the port, should be equal or similar to the class name of the implementation
    targetNamespace = "http://server/" //Keep this namespace consistent with the package name of the interface

)

public class HelloWorldServer implements HelloWorldServerInterface {

    @Override
    public String sayHello() {
        return "Hello, World!";
    }

    public static void main(String[] args) {
        String address = "http://localhost:8080/HelloWorld";
        Endpoint endpoint = Endpoint.publish(address, new HelloWorldServer());

        System.out.println("SOAP service published at: " + address);
        System.out.println("WSDL available at: " + address + "?wsdl");
        System.out.println("Press Ctrl+C to stop the service.");

        Runtime.getRuntime().addShutdownHook(new Thread(endpoint::stop));
    }
}
