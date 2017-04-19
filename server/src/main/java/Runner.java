import services.filestransfer.FileTransferer;
import services.filestransfer.impl.FileTransfererImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by Andrey_Bindyuk on 4/19/2017.
 */
public class Runner {
    public static void main(String[] args) {
        String bindingURI = "http://localhost:9898/epam/fileService";
        FileTransferer service = new FileTransfererImpl();
        Endpoint.publish(bindingURI, service);
        System.out.println("Server started at: " + bindingURI);
    }
}
