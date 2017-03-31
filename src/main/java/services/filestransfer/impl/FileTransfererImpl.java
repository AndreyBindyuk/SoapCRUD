package services.filestransfer.impl;

import exception.FileFaultException;
import services.filestransfer.FileTransferer;
import services.preparingfiles.PreparingFileData;
import services.preparingfiles.impl.PreparingFileDataImpl;

import javax.jws.*;
import java.io.*;
import java.util.Properties;

@WebService
public class FileTransfererImpl implements FileTransferer {
    PreparingFileData preparingFileData = new PreparingFileDataImpl();
    private static final String serverFilesFolder = "serverFilesFolder.properties";

    @WebMethod
    public String upload(String fileName, byte[] fileBytes) throws FileFaultException {
        String filePath = getServerFilePath() + fileName;
        File file = new File(filePath);
        if (file.exists()) {
            throw new FileFaultException("file already exists");
        } else if (preparingFileData.uploadfile(file, fileBytes)) {
            return "file is uploaded";
        } else
            return "file is not uploaded";
    }

    @WebMethod
    public byte[] download(String filePath) throws FileFaultException {
        System.out.println("Sending file: " + filePath);
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileFaultException("File does not exist by current file path");
        } else {
            return preparingFileData.downloadfile(file);
        }
    }

    @WebMethod
    public String delete(String filePath) throws FileFaultException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileFaultException("File does not exist by current file path");
        } else if (preparingFileData.deletefile(file)) {
            return "file is deleted";
        } else {
            return "file could not be deleted";
        }
    }


    private String getServerFilePath() {
        String serverFilePath = null;
        Properties props = new Properties();
        try {
            InputStream input = new FileInputStream(serverFilesFolder);
            props.load(input);
            serverFilePath = (String) props.get("serverFilesFolder");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return serverFilePath;
    }
}
