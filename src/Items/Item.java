
package Items;

import java.io.File;
import java.util.ArrayList;


/**
 *Abstract class to map and  do operations over Items
 * @author Daniel Gumucio
 */
public abstract class Item {
    protected String name;
    protected String location;
    protected long size;
    protected AttributeHandler attributeList;
    
    /**
     * Construct an Item based on a File get from  filesystem, this File  could be a simple  File or Folder
     * @param fileItem File  - it is  a File  from filesystem
     */
    public Item(File fileItem)
    {
        this.location = fileItem.getAbsolutePath();
        this.name = fileItem.getName();
        this.size = fileItem.length();
        this.attributeList = new AttributeHandler(getAttributesFromItem(fileItem));
    }
    
    /**
     * Construct an  Item based on new File or  Folder created
     * @param nameItem String - This  is the name of  Item
     * @param locationItem String - This is location where item is  located
     * @param sizeItem long - This  is  the  size of  item in bytes
     * @param attributesItem  AttributeHandler - This is  an Attribute Handler  object which manage  all  attributes  
     * related  to the item 
     */
    public Item(String nameItem, String locationItem,long sizeItem, AttributeHandler attributesItem)
    {
        this.name = nameItem;
        this.location = locationItem;
        this.size = sizeItem;
        this.attributeList = attributesItem;
    }
    
    /**
     * This  method get the  name of  attribute
     * @return String name of  attribute
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * This method get the  location of the item
     * @return String location of an  item
     */
    public String getLocation()
    {
        return this.location;
    }
    
    /**
     * This method get the  size of  Item
     * @return long size in bytes  related  to the item
     */
    public long getSize()
    {
        return this.size;
    }

    /**
     * This method get the  Attribute handler object of an Item
     * @return AttributeHandler object  
     */
    public AttributeHandler getListOfAttributes()
    {
        return this.attributeList;
    }
    
    /**
     * This method set  the  name of an Item
     * @param newName String - new  name for  the  item 
     * @return boolean true  if name is changed  correctly
     */
    public boolean setName(String newName)
    {
        boolean wasSet = false;
        if(!(newName.replaceAll("\\s", "").isEmpty()))
        {
            this.name = newName;
            wasSet = true;
        }
        return wasSet;
    }
    
    /**
     * Method  to set the  location for  an Item
     * @param newLocation String - the  new  location for  the  item
     * @return boolean  true if  Location is  changed
     */
    public boolean setLocation(String newLocation)
    {
        boolean wasSet = false;
        if(!(newLocation.replaceAll("\\s", "").isEmpty()))
        {
            this.location = newLocation;
            wasSet = true;
        }
        return wasSet;
    }
    
    /**
     * Method  to  set  the  size of Item
     * @param newSize long - new  size in bytes  for  Item
     * @return boolean true  if new Size  is  changed
     */
    public boolean setSize(long newSize)
    {
        boolean wasSet = false;
        if(newSize >= 0)
        {
            this.size = newSize;
            wasSet = true;
        }
        return wasSet;
    }
    
    /**
     * Method to  update  attributes  for  an Item 
     * @param attributeUpdated Attribute - attribute to  update
     * @return boolean  tru if attributes  are  set correctly
     */
    public boolean setAttributes(Attribute attributeUpdated)
    {
        boolean listAttributeUpdated = false;
        
        Attribute attributeFromList = this.attributeList.getAttributeFromList(attributeUpdated.getNameAttribute());
        if(this.attributeList.deleteAttribute(attributeFromList) &&
                this.attributeList.addNewAttribute(attributeUpdated))
        {
            listAttributeUpdated = true;
        }
        
        return true;
    }
    
    /**
     * Method to verify if  it  is an Item
     * @return boolean true if it is  Item
     */
    public boolean isItem()
    {
        boolean areEquals = false;
        if(this instanceof Item)
        {
            areEquals = (this.getSize() >= 0 && !this.getName().isEmpty() && !this.getLocation().isEmpty() 
                    && this.getListOfAttributes().getAllList().size() > 0);
        }
        return areEquals;
    }
    
    /**
     * Method to  verify if  two items  are  equal
     * @param item Item - Item Object to compare
     * @return boolean is  true  if items are equals
     */
    public boolean areEquals(Item item)
    {
        boolean areEquals = false;
        
        if(this.getName().equals(item.getName()) && (this.getLocation().equals(item.getLocation())) 
                && (this.getSize()== item.getSize()) && this.sameAttributes(item.getListOfAttributes().getAllList()))
        {
            areEquals = true;
        }
        return areEquals;
    }
    
    /**
     * Method  to  compare if  Items has the  same  attributes
     * @param attributes ArrayList of Attributes - in order  to compare
     * @return boolean true if it has  same attributes
     */
    protected boolean sameAttributes(ArrayList <Attribute> attributes)
    {
        return !(this.getListOfAttributes().getAllList().retainAll(attributes));
    }
    
    /**
     * Static Method to get Attributes for an Item
     * @param fileItem File - File to get attributes for  the  file sent
     * @return ArrayList of Attributes updated for  the  item 
     */
    private static ArrayList<Attribute> getAttributesFromItem(File fileItem)
    {
        ArrayList<Attribute> attributeList = new ArrayList<>();
        
        if(!fileItem.canWrite())
        {
            Attribute attributeReadOnly = new Attribute("ReadOnly","Enabled");
            attributeList.add(attributeReadOnly);
        }
        else
        {
            Attribute attributeReadOnly = new Attribute("ReadOnly","Disabled");
            attributeList.add(attributeReadOnly);
        }
        
        return attributeList;
    }
}
