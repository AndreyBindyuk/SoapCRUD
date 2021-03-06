
package generatedclientcode;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3-b02-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "FileTransfererImpl", targetNamespace = "http://impl.filestransfer.services/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface FileTransfererImpl {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     * @throws FileFaultException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "delete", targetNamespace = "http://impl.filestransfer.services/", className = "generatedclientcode.Delete")
    @ResponseWrapper(localName = "deleteResponse", targetNamespace = "http://impl.filestransfer.services/", className = "generatedclientcode.DeleteResponse")
    public String delete(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws FileFaultException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     * @throws FileFaultException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "upload", targetNamespace = "http://impl.filestransfer.services/", className = "generatedclientcode.Upload")
    @ResponseWrapper(localName = "uploadResponse", targetNamespace = "http://impl.filestransfer.services/", className = "generatedclientcode.UploadResponse")
    public String upload(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        byte[] arg1)
        throws FileFaultException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns byte[]
     * @throws FileFaultException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "download", targetNamespace = "http://impl.filestransfer.services/", className = "generatedclientcode.Download")
    @ResponseWrapper(localName = "downloadResponse", targetNamespace = "http://impl.filestransfer.services/", className = "generatedclientcode.DownloadResponse")
    public byte[] download(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws FileFaultException_Exception
    ;

}
