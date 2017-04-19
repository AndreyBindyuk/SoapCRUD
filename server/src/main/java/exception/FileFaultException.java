package exception;

import javax.xml.ws.WebFault;

/**
 * Created by Andrey_Bindyuk on 3/31/2017.
 */
@WebFault(name="FileFaultException",
        targetNamespace="http://www.example.com")
public class FileFaultException extends Exception {

    public FileFaultException(String message) {
        super(message);
    }
}
