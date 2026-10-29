package main.java;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService(
    name = "HelloWorldServer", // should be equal or similar to the class name of the implementation
    targetNamespace = "http://server/" //Keep this namespace consistent with the package name of the interface
)

public interface HelloWorldServerInterface {
    @WebMethod
    String sayHello(); //The remote operation called by the client.
}
