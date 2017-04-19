package services.preparingfiles;

import exception.FileFaultException;

import java.io.File;

/**
 * Created by Andrey_Bindyuk on 3/31/2017.
 */
public interface PreparingFileData {

    public boolean uploadfile(File file, byte[] fileBytes);

    public byte[] downloadfile(File file) throws FileFaultException;

    public boolean deletefile(File file);

}
