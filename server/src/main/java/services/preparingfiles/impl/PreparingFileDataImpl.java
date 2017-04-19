package services.preparingfiles.impl;

import exception.FileFaultException;
import services.preparingfiles.PreparingFileData;

import java.io.*;

/**
 * Created by Andrey_Bindyuk on 3/31/2017.
 */
public class PreparingFileDataImpl implements PreparingFileData {

    @Override
    public boolean uploadfile(File file, byte[] fileBytes) {
        boolean isUploaded = false;
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream);) {
            outputStream.write(fileBytes);
            outputStream.close();
            isUploaded = true;
            System.out.println("Received file: " + file.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isUploaded;
    }

    @Override
    public byte[] downloadfile(File file) throws FileFaultException {
        byte[] fileBytes = new byte[(int) file.length()];
        try (FileInputStream fileInputStream = new FileInputStream(file);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);) {
            bufferedInputStream.read(fileBytes);
            bufferedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileFaultException("File is locked: " + file.getName());
        }
        return fileBytes;
    }

    @Override
    public boolean deletefile(File file) {
        boolean isDeleted = false;
        if (file.delete()) {
            isDeleted = true;
        }
        return isDeleted;
    }
}
