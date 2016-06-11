package src;

import Utilities.BasicOperation;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *Class in charge to map folder object that extend  of  Items and  at the  same
 *time has a list of Items
 * @author Daniel Gumucio
 */
public class FolderItem extends Item {
    
    public ArrayList <Item> itemList;
    
    /**
     * Constructor method that create folder object  based on folder Object (Path)
     * @param folderFile - It  is  a folder in a filesystem
     */
    public FolderItem(File folderFile)
    {
        super(folderFile);
        this.itemList = new ArrayList<>();
    }
    
    /**
     * Constructor method that creates  a new  folder
     * @param fileName String - Name  of  the  file
     * @param location String - Location of  the file
     * @param fileSize long - size  of  File in bytes
     * @param attributesFile AttributeHandler - Attribute  handler  that manage Attributes of item
     */
    public FolderItem(String fileName, String location, long fileSize, AttributeHandler attributesFile)
    {
        super(fileName, location, fileSize, attributesFile);
        this.itemList = null;
        BasicOperation.createDirectory(this.getName(),new File(this.getLocation()));
    }
    
    /**
     * This method is in charge to update the  folder name
     * @param newFolderName String  that  contains  the new name
     * @return boolean true if  name  is  changed  success
     */
    public boolean setFolderName(String newFolderName)
    {
        boolean nameChange = BasicOperation.renameItem(new File(this.getLocation() + this.getName()),
                new File(this.getLocation() + newFolderName ));
        this.setName(newFolderName);
        
        return (this.getName().equals(newFolderName) && nameChange);
    }
    
    /**
     * This  method is in charge to move folder to other  location
     * @param newLocation String  that  contains new  location
     * @return boolean is  true if  folder  was  moved
     */
    public boolean setFolderLocation(String newLocation)
    {
        File folderSource = new File(this.getLocation()+this.getName());
        File folderTarget = new File(newLocation+ File.separator + this.getName());
        
        return BasicOperation.moveItem(folderSource, folderTarget) && this.setLocation(newLocation);
    }
    
    /**
     * This method is in charge  to  update  the  Size of  folder
     * @return boolean true if  size  was  changed
     */
    public boolean updateSize()
    {
        File folder = new File(this.getLocation()+this.getName());
        this.setSize(folder.length());
        return this.getSize()==folder.length();
    }
    /**
     * Method  to get  the  list of items  of  folder
     * @return ArrayList  of  items that exist in a folder
     */
    public ArrayList<Item> getItemList()
    {
        Path path = Paths.get(this.getLocation()+""+this.getName());
        File f = path.toFile();
        File[] files = f.listFiles();
               
        if(files!=null)
        {
            this.itemList = fillItemList(files);
        }
        
        return this.itemList;
    }
    
    /**
     * Method set the item list of  folder
     * @param itemList - this  is  an  array list of  items files or  folders  or both
     * @return boolean if list of  items was filled
     */
    public boolean setItemList(ArrayList itemList)
    {
        boolean isSet = false;
               
        if(itemList.size() >= 0)
        {
            this.itemList = itemList;
        }
        
        return this.itemList.size() >= 0;
    }
    
    /**
     * Method  to  fill the  folder with items file opr folder
     * @param fileList this  is  a  list  of  files or  folders in teh  filesystem
     * @return Array List of  Items (files or  folders)
     */
    private ArrayList<Item> fillItemList(File[] fileList)
    {
        ArrayList<Item> items = new ArrayList<>();
        
        for (int index = 0; index < fileList.length; index++) 
        {
            if(fileList[index].isFile())
            {
                Item itemFile = new FileItem( fileList[index]);
                items.add(itemFile);
            }   
            else
            {
                Item itemFolder = new FolderItem( fileList[index]);
                items.add(itemFolder);
            }
        }
        
        return items;
    }
}