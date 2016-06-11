
package src;

import Utilities.BasicOperation;
import java.io.File;
/**
 * Class in charge  to map file object that extend  of Item 
 * @author Daniel Gumucio
 */
public class FileItem extends Item {
    
    public String extension;
    
    /**
     * Constructor method that create file object  based on File Object (Path) 
     * @param fileObject File - it  is  a file in a  filesystem
     */
    public FileItem(File fileObject)
    {
        super(fileObject);
        this.extension = getFileExtension(fileObject); 
    }
    
    /**
     * Constructor method that creates  a new  file
     * @param fileName String - Name  of  the  file
     * @param location String - Location of  the file
     * @param fileSize long - size  of  File in bytes
     * @param attributesFile AttributeHandler - Attribute  handler  that manage Attributes of  file
     * @param fileExtension String - Extension of  the  file
     */
    public FileItem(String fileName, String location, long fileSize, AttributeHandler attributesFile, String fileExtension)
    {
        super(fileName, location, fileSize, attributesFile);
        extension = fileExtension;   
        BasicOperation.createFile(this.getName(), new File(this.getLocation()));
    }
        
    /**
     * Method to get the extension of  the  file
     * @return an  string that is  the file extension
     */
    public String getExtension()
    {
        return this.extension;
    }
    
    /**
     * Method  to update the  extension of  a  file
     * @param newExtension String - new  extension of  a  file
     * @return boolean true if extension is  changed
     */
    public boolean setExtension(String newExtension)
    {
        if(!(newExtension.replaceAll("\\s", "").isEmpty()))
        {
             this.extension = newExtension;
        }
        
        return this.extension.equals(newExtension);
    }
    
    /**
     * Method verify if  it is  a file
     * @return boolean true if  object is  a file
     */
    public boolean isFileItem()
    {
        boolean isFile = false;
        
        if(super.isItem() || !this.getExtension().isEmpty())
        {
           isFile = true;
        }
        return isFile;
    }
    
    /**
     * Method to get the  file extension
     * @param file File - File of  filesystem 
     * @return String extension of  file
     */
    private static String getFileExtension(File file) 
    {
        String extensionFile = "";
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        {
            extensionFile = fileName.substring(fileName.lastIndexOf(".") +1);
        }
        
        return extensionFile;
    }  
}
