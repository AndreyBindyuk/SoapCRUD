
package generatedclientcode;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3-b02-
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "FileTransfererImplService", targetNamespace = "http://impl.filestransfer.services/", wsdlLocation = "file:/D:/MENTORINGAPPLICATIONS/SoapCRUD/wsdl/FileTransfererImplService.wsdl")
public class FileTransfererImplService
    extends Service
{

    private final static URL FILETRANSFERERIMPLSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(generatedclientcode.FileTransfererImplService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = generatedclientcode.FileTransfererImplService.class.getResource(".");
            url = new URL(baseUrl, "file:/D:/MENTORINGAPPLICATIONS/SoapCRUD/wsdl/FileTransfererImplService.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'file:/D:/MENTORINGAPPLICATIONS/SoapCRUD/wsdl/FileTransfererImplService.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        FILETRANSFERERIMPLSERVICE_WSDL_LOCATION = url;
    }

    public FileTransfererImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FileTransfererImplService() {
        super(FILETRANSFERERIMPLSERVICE_WSDL_LOCATION, new QName("http://impl.filestransfer.services/", "FileTransfererImplService"));
    }

    /**
     * 
     * @return
     *     returns FileTransfererImpl
     */
    @WebEndpoint(name = "FileTransfererImplPort")
    public FileTransfererImpl getFileTransfererImplPort() {
        return super.getPort(new QName("http://impl.filestransfer.services/", "FileTransfererImplPort"), FileTransfererImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FileTransfererImpl
     */
    @WebEndpoint(name = "FileTransfererImplPort")
    public FileTransfererImpl getFileTransfererImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://impl.filestransfer.services/", "FileTransfererImplPort"), FileTransfererImpl.class, features);
    }

}
