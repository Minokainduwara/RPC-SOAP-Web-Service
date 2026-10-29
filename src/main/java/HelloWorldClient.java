package main.java;

import jakarta.xml.ws.Service;
import javax.xml.namespace.QName;
import java.net.URL;

public class HelloWorldClient {

    public static void main(String[] args) throws Exception {
        URL wsdl = new URL("http://localhost:8080/HelloWorld?wsdl");

        QName serviceName = new QName(
            "http://server/",
            "HelloWorldServerService"
        );

        QName portName = new QName(
            "http://server/",
            "HelloWorldServerPort"
        );

        Service service = Service.create(wsdl, serviceName);

        HelloWorldServerInterface client =
            service.getPort(portName, HelloWorldServerInterface.class);

        System.out.println(client.sayHello());
    }
}