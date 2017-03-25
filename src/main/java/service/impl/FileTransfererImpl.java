package service.impl;

import service.FileTransferer;

import javax.jws.*;
import java.io.*;

@WebService
public class FileTransfererImpl implements FileTransferer {

    @WebMethod
    public void upload(String fileName, byte[] fileBytes) {
        String filePath = "D:\\meizu\\server\\upload\\" + fileName;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream);
            outputStream.write(fileBytes);
            outputStream.close();
            System.out.println("Received file: " + filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @WebMethod
    public byte[] download(String fileName) {
        String filePath = "D:\\meizu\\server\\download\\" + fileName;
        System.out.println("Sending file: " + filePath);
        try {
            File file = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            byte[] fileBytes = new byte[(int) file.length()];
            bufferedInputStream.read(fileBytes);
            bufferedInputStream.close();
            return fileBytes;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
