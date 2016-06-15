package ItemsTest;

import Items.Attribute;
import Items.AttributeHandler;
import Items.FileItem;
import Items.FolderItem;
import Items.Item;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class in charge  to test Item Object
 * @author Daniel Gumucio
 */
public class ItemTest {
    
    
    @Test
    public void verifyItemIsCreated()
    {
        Attribute attributeReadOnly = new  Attribute("ReadOnly", "Enabled");
        Attribute attributeHidden = new Attribute("Hidden", "Disabled");
        ArrayList<Attribute> listAttributes = new ArrayList<>() ;
        listAttributes.add(attributeReadOnly);
        listAttributes.add(attributeHidden);
                
        AttributeHandler attributeList = new AttributeHandler(listAttributes);
        
        Item item = new  FileItem("test", File.listRoots()[0].getAbsolutePath(), 0, attributeList,".txt");
        
        assertTrue((item.getName().equals("test")) && (item.getLocation().equals(File.listRoots()[0].getAbsolutePath())) 
        && item.getSize()==0.0 && (item.getListOfAttributes().getAllList().size() == listAttributes.size() 
                && !(item.getListOfAttributes().getAllList().retainAll(listAttributes))));
    }
    
    @Test
    public void VerifyCreateItemListingFileAndFolder()
    {
        Path path = Paths.get(File.listRoots()[0].getAbsolutePath());
        File f = path.toFile();
        File[] files = f.listFiles();
        ArrayList<Item> items = new ArrayList<>();
        
        for (int index = 0; index < files.length; index++) 
        {
            if(files[index].isFile())
            {
                Item itemFile = new FileItem( files[index]);
                items.add(itemFile);
            }   
            else
            {
                Item itemFolder = new FolderItem( files[index]);
                items.add(itemFolder);
            }
        }
        
        boolean areItems = true;
        for(int indexItemList = 0; indexItemList < items.size(); indexItemList++)
        {
            if(!items.get(indexItemList).isItem())
            {
                areItems = false;
                break;
            }
        }
        assertTrue(areItems);
    }


    @Test
    public void verifyIsTheSameItem()
    {
        Attribute attributeReadOnly = new  Attribute("ReadOnly", "Enabled");
        Attribute attributeHidden = new Attribute("Hidden", "Disabled");
        ArrayList<Attribute> listAttributes = new ArrayList<>() ;
        listAttributes.add(attributeReadOnly);
        listAttributes.add(attributeHidden);
        AttributeHandler attributeList = new AttributeHandler(listAttributes);
        
        Item item = new  FileItem("test", File.listRoots()[0].getAbsolutePath(), 0, attributeList,".txt");
        Item sameItem = new  FileItem("test", File.listRoots()[0].getAbsolutePath(), 0, attributeList, ".txt");
        
        assertTrue(item.areEquals(sameItem));
    }
    
    @Test
    public  void verifyAreDifferentItems()
    {
        Attribute attributeReadOnly = new  Attribute("ReadOnly", "Enabled");
        Attribute attributeHidden = new Attribute("Hidden", "Disabled");
        ArrayList<Attribute> listAttributes = new ArrayList<>() ;
        listAttributes.add(attributeReadOnly);
        listAttributes.add(attributeHidden);
        AttributeHandler attributeList = new AttributeHandler(listAttributes);
        
        Item item = new  FileItem("test", File.listRoots()[0].getAbsolutePath(), 0, attributeList, ".txt");
        
        Attribute attributeReadOnlyDisabled = new  Attribute("ReadOnly", "Disabled");
        Attribute attributeHiddenEnabled = new Attribute("Hidden", "Enabled");
        ArrayList<Attribute> listAttributesInverse = new ArrayList<>() ;
        listAttributesInverse.add(attributeReadOnlyDisabled);
        listAttributesInverse.add(attributeHiddenEnabled);
        AttributeHandler attributeListInverse = new AttributeHandler(listAttributesInverse);
        
        Item itemAttributeInverse = new  FileItem("test", File.listRoots()[0].getAbsolutePath(), 0, attributeListInverse, ".txt");
        
        assertFalse(item.equals(itemAttributeInverse));
    }
    
    
    @Test
    public void verifyItIsAnItem()
    {
        Attribute attributeReadOnly = new  Attribute("ReadOnly", "Enabled");
        Attribute attributeHidden = new Attribute("Hidden", "Disabled");
        ArrayList<Attribute> listAttributes = new ArrayList<>() ;
        listAttributes.add(attributeReadOnly);
        listAttributes.add(attributeHidden);
        AttributeHandler attributeList = new AttributeHandler(listAttributes);
        
        Item item = new  FileItem("test", File.listRoots()[0].getAbsolutePath(), 0, attributeList, ".txt");
        
        assertTrue(item.isItem());
    
    }

    
    @Test
    public void verifyNameAndLocationAreString()
    {
        Attribute attributeReadOnly = new  Attribute("ReadOnly", "Enabled");
        Attribute attributeHidden = new Attribute("Hidden", "Disabled");
        ArrayList<Attribute> listAttributes = new ArrayList<>() ;
        listAttributes.add(attributeReadOnly);
        listAttributes.add(attributeHidden);
        AttributeHandler attributeList = new AttributeHandler(listAttributes);
        
        Item item = new  FileItem("test", File.listRoots()[0].getAbsolutePath(), 0, attributeList , ".txt");
        
        String nameTest = "test";
        String locationTest = File.listRoots()[0].getAbsolutePath();
        
        assertTrue(nameTest.equals(item.getName()) && locationTest.equals(item.getLocation()));
     
    }
    
    
    @Test
    public void verifySize()
    {
        Attribute attributeReadOnly = new  Attribute("ReadOnly", "Enabled");
        Attribute attributeHidden = new Attribute("Hidden", "Disabled");
        ArrayList<Attribute> listAttributes = new ArrayList<>() ;
        listAttributes.add(attributeReadOnly);
        listAttributes.add(attributeHidden);
        AttributeHandler attributeList = new AttributeHandler(listAttributes);
        
        Item item = new  FileItem("test", File.listRoots()[0].getAbsolutePath(), 123456, attributeList , ".txt");
        
        assertEquals(123456, item.getSize());
    }
    
    @Test
    public void verifySizeWasChanged()
    {
        Attribute attributeReadOnly = new  Attribute("ReadOnly", "Enabled");
        Attribute attributeHidden = new Attribute("Hidden", "Disabled");
        ArrayList<Attribute> listAttributes = new ArrayList<>() ;
        listAttributes.add(attributeReadOnly);
        listAttributes.add(attributeHidden);
        AttributeHandler attributeList = new AttributeHandler(listAttributes);
        
        Item item = new  FileItem("test", File.listRoots()[0].getAbsolutePath(), 123456, attributeList , ".txt");
        
        assertTrue(item.setSize(123) && item.getSize() == 123); 
    }
  
    @Test
    public void verifyNameWasChanged()
    {
        Attribute attributeReadOnly = new  Attribute("ReadOnly", "Enabled");
        Attribute attributeHidden = new Attribute("Hidden", "Disabled");
        ArrayList<Attribute> listAttributes = new ArrayList<>() ;
        listAttributes.add(attributeReadOnly);
        listAttributes.add(attributeHidden);
        AttributeHandler attributeList = new AttributeHandler(listAttributes);
        
        Item item = new  FileItem("test", File.listRoots()[0].getAbsolutePath(), 123456, attributeList , ".txt");
        
        String newName = "newTest";
        
        assertTrue(item.setName(newName) && newName.equals(item.getName()));
    }
    
    @Test
    public void verifyLocationWasChanged()
    {
        Attribute attributeReadOnly = new  Attribute("ReadOnly", "Enabled");
        Attribute attributeHidden = new Attribute("Hidden", "Disabled");
        ArrayList<Attribute> listAttributes = new ArrayList<>() ;
        listAttributes.add(attributeReadOnly);
        listAttributes.add(attributeHidden);
        AttributeHandler attributeList = new AttributeHandler(listAttributes);
        
        Item item = new  FileItem("test", File.listRoots()[0].getAbsolutePath(), 123456, attributeList , ".txt");
        
        String newLocation = File.listRoots()[0].getAbsolutePath()+ File.separator + "testFolder" ;
        
        assertTrue(item.setLocation(newLocation) && newLocation.equals(item.getLocation()));
    }
    
    @Test
    public void verifyAttributesWereChanged()
    {
        Attribute attributeReadOnly = new  Attribute("ReadOnly", "Enabled");
        Attribute attributeHidden = new Attribute("Hidden", "Disabled");
        ArrayList<Attribute> listAttributes = new ArrayList<>() ;
        listAttributes.add(attributeReadOnly);
        listAttributes.add(attributeHidden);
        AttributeHandler attributeList = new AttributeHandler(listAttributes);
        
        Item item = new  FileItem("test", File.listRoots()[0].getAbsolutePath(), 123456, attributeList , ".txt");
        
        Attribute updatedReadOnly = new Attribute("ReadOnly", "Disabled");
        Attribute updatedHidden = new Attribute("Hidden", "Enabled");
        
        assertTrue(item.setAttributes(updatedReadOnly) && item.setAttributes(updatedHidden) && 
                item.getListOfAttributes().getAttributeFromList("ReadOnly").getValueAttribute().equals("Disabled") && 
                item.getListOfAttributes().getAttributeFromList("Hidden").getValueAttribute().equals("Enabled"));
    }
}