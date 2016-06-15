package Items;

import Utilities.BasicOperation;
import Utilities.RunCommand;
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
        BasicOperation.createFile(this.getName()+extension, new File(location));
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
        boolean extensionChange = BasicOperation.renameItem(new File(this.getLocation()+this.getName()+this.getExtension()),
                new File(this.getLocation()+this.getName()+ newExtension));
        this.extension = newExtension;
        return (this.extension.equals(newExtension) && extensionChange) ;
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
     * This method set  the fileName
     * @param newName String  that contains  the  new  name of  filename
     * @return boolean  true if  name  was  changed  sucessfully
     */
    public boolean setFileName(String newName)
    {
        boolean nameChange = BasicOperation.renameItem(new File(this.getLocation() + this.getName() + this.getExtension()),
                new File(this.getLocation() + newName + this.getExtension() ));
        this.setName(newName);
        
        return (this.getName().equals(newName) && nameChange);
    }
    
    /**
     * This  method is in charge to move file to other  location
     * @param newLocation String  that  contains new  location
     * @return boolean is  true if  file  was  moved
     */
    public boolean setFileLocation(String newLocation)
    {
        File fileSource = new File(this.getLocation()+this.getName()+this.getExtension());
        File fileTarget = new File(newLocation+ File.separator + this.getName()+ this.getExtension());
        
        return BasicOperation.moveItem(fileSource, fileTarget) && this.setLocation(newLocation);
    }
    
    /**
     * This method is in charge  to  update  the  Size of  file
     * @return boolean true if  size  was  changed
     */
    public boolean updateSize()
    {
        File file = new File(this.getLocation()+this.getName()+this.getExtension());
        this.setSize(file.length());
        return this.getSize()==file.length();
    }
    
    /**
     * Method in charge to update  attribute of  file
     * @param attributeUpdated Atrtibute object updated
     * @return  boolean true if  attribute  was  changed
     */
    public boolean setFileAttribute(Attribute attributeUpdated)
    {
        boolean attributeBoolUpdated = false;
        File file = new File(this.getLocation()+this.getName()+this.getExtension());
        
        if(attributeUpdated.getNameAttribute().equals("ReadOnly"))
        {
            if(attributeUpdated.getValueAttribute().equals("Enabled"))
            {
                attributeBoolUpdated = runChange(file.getAbsolutePath(), "ReadOnly", "Enabled") && this.setAttributes(attributeUpdated);
            }
            else
            {
                attributeBoolUpdated = runChange(file.getAbsolutePath(), "ReadOnly", "Disabled") && this.setAttributes(attributeUpdated);
            } 
        }
        else
        {
            if(attributeUpdated.getValueAttribute().equals("Enabled"))
            {
                 attributeBoolUpdated = runChange(file.getAbsolutePath(), "Hidden", "Enabled") && this.setAttributes(attributeUpdated);
            }
            else
            {
                attributeBoolUpdated = runChange(file.getAbsolutePath(), "Hidden", "Disabled") && this.setAttributes(attributeUpdated);
            }
        }
        return attributeBoolUpdated;
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
    
    /**
     * Method incharge  to  run command  to  update value  for  attribute in filesystem
     * @param fileLocation String  that cotains the absolut  path of  file
     * @param attributeName String that contains name of  attribute
     * @param attributeValue String  thta  contains de value  of  attribute
     * @return boolean true if command run sucees  
     */
    private boolean runChange(String fileLocation, String attributeName, String attributeValue )
    {
        String commandRun = "";
        
        if(attributeName.equals("ReadOnly"))
        {
            if(attributeValue.equals("Enabled"))
            {
                commandRun = RunCommand.runCommandWindows("attrib +r "+ fileLocation );
            }
            else
            {
                commandRun = RunCommand.runCommandWindows("attrib -r "+ fileLocation);
            }
        }
        else
        {
            if(attributeValue.equals("Enabled"))
            {
                commandRun = RunCommand.runCommandWindows("attrib +h "+ fileLocation );
            }
            else
            {
                commandRun = RunCommand.runCommandWindows("attrib -h "+ fileLocation);
            }
        }
        
        return commandRun.isEmpty();
    }
}