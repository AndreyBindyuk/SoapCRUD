package client.runner.menu.impl;

import client.FileFaultException_Exception;
import client.FileTransfererImpl;
import client.FileTransfererImplService;
import client.runner.menu.MenuService;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MenuOperationsImpl implements MenuService {
    private static final String fileOperationsMenu = "fileOperationsMenu.txt";
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private FileTransfererImplService client = new FileTransfererImplService();
    private FileTransfererImpl service = client.getFileTransfererImplPort();

    @Override
    public void menuOperations() throws IOException {

        String text = new String(Files.readAllBytes(Paths.get(fileOperationsMenu)), StandardCharsets.UTF_8);
        System.out.println(text);
        while (true) {
            String input = br.readLine();
            switch (input) {
                case "1":
                    upload(input);
                    System.out.println(text);
                    break;
                case "2":
                    download();
                    System.out.println(text);
                    break;
                case "3":
                    delete(input);
                    System.out.println(text);
                    break;
            }
        }
    }

    private void upload(String input) {
        try {
            System.out.println("enter absolute path to file on client side: ");
            input = br.readLine();
            File file = new File(input);
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            byte[] fileBytes = new byte[(int) file.length()];
            bufferedInputStream.read(fileBytes);
            System.out.println(service.upload(file.getName(), fileBytes));
            bufferedInputStream.close();
        } catch (FileFaultException_Exception | IOException e) {
            e.printStackTrace();
        }
    }

    private void download() {
        try {
            System.out.println("enter file name for downloading from server: ");
            String fileName = br.readLine();
            byte[] fileBytes = service.download(fileName);
            System.out.println("enter file location on client side for downloading file from server: ");
            String folder = br.readLine();
            FileOutputStream fileOutputStream = new FileOutputStream(folder);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write(fileBytes);
            bufferedOutputStream.close();
            System.out.println("File downloaded from server: " + fileName);
        } catch (FileFaultException_Exception | IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(String input) {
        try {
            System.out.println("enter file name for removal from server:");
            input = br.readLine();
            System.out.println(service.delete(input));
        } catch (FileFaultException_Exception | IOException e) {
            e.printStackTrace();
        }
    }
}
