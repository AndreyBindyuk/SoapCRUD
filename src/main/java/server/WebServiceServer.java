package server;

import services.filestransfer.FileTransferer;
import services.filestransfer.impl.FileTransfererImpl;

import javax.xml.ws.Endpoint;

public class WebServiceServer {
    public static void main(String[] args) {
        String bindingURI = "http://localhost:9898/epam/fileService";
        FileTransferer service = new FileTransfererImpl();
        Endpoint.publish(bindingURI, service);
        System.out.println("Server started at: " + bindingURI);
    }
}
