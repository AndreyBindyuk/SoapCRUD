package client.runner;

import client.FileFaultException_Exception;
import client.FileTransfererImpl;
import client.FileTransfererImplService;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WebServiceClient {
    private static final String fileOperationsMenu = "fileOperationsMenu.txt";
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws FileFaultException_Exception, IOException {
        FileTransfererImplService client = new FileTransfererImplService();
        FileTransfererImpl service = client.getFileTransfererImplPort();
        byte[] fileBytes;
        String text = new String(Files.readAllBytes(Paths.get(fileOperationsMenu)), StandardCharsets.UTF_8);
        System.out.println(text);
        while (true) {
            String input = br.readLine();
            switch (input) {
                case "1":
                    System.out.println("enter absolute path to file on client side: ");
                    input = br.readLine();
                    File file = new File(input);
                    FileInputStream fileInputStream = new FileInputStream(file);
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                    fileBytes = new byte[(int) file.length()];
                    bufferedInputStream.read(fileBytes);
                    System.out.println(service.upload(file.getName(), fileBytes));
                    bufferedInputStream.close();
//                    System.out.println("File uploaded on server: " + file.getName());
                case "2":
                    System.out.println("enter file name for downloading from server: ");
                    String fileName = br.readLine();
                    fileBytes = service.download(fileName);
                    System.out.println("enter folder on client side for downloading files from server: ");
                    String folder = br.readLine();
                    FileOutputStream fileOutputStream = new FileOutputStream(folder);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    bufferedOutputStream.write(fileBytes);
                    bufferedOutputStream.close();
                    System.out.println("File downloaded from server: " + fileName);
                case "3":
                    System.out.println("enter file name for removal from server:");
                    input = br.readLine();
                    System.out.println(service.delete(input));
            }
        }
    }
}
