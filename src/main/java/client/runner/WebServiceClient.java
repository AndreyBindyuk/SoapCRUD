package client.runner;

import client.FileTransfererImpl;
import client.FileTransfererImplService;

import java.io.*;

public class WebServiceClient {
    public static void main(String[] args) {
        FileTransfererImplService client = new FileTransfererImplService();
        FileTransfererImpl service = client.getFileTransfererImplPort();

        String fileName = "1.xml";
        String filePath = "D:\\meizu\\client\\Upload\\" + fileName;
        File file = new File(filePath);

        // uploads a file
        try {
            FileInputStream  fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            byte[] fileBytes = new byte[(int) file.length()];
            bufferedInputStream.read(fileBytes);
            service.upload(file.getName(),fileBytes);
            bufferedInputStream.close();
            System.out.println("File uploaded: " + filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // downloads another file
        fileName = "2.xml";
        filePath = "D:\\meizu\\client\\Download\\" + fileName;
        byte[] fileBytes = service.download(fileName);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write(fileBytes);
            bufferedOutputStream.close();
            System.out.println("File downloaded: " + filePath);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
