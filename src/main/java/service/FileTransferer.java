package service;

import javax.jws.*;

@WebService
public interface FileTransferer {

    @WebMethod
    public void upload(String fileName, byte[] fileBytes);

    @WebMethod
    public byte[] download(String fileName);
}
