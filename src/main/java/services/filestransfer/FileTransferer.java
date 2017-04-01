package services.filestransfer;

import exception.FileFaultException;

import javax.jws.*;

@WebService
public interface FileTransferer {

    @WebMethod
    public String upload(String fileName, byte[] fileBytes) throws FileFaultException;

    @WebMethod
    public byte[] download(String fileName) throws FileFaultException;

    @WebMethod
    public String delete(String fileName) throws FileFaultException;
}
