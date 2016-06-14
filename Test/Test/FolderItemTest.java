package Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import src.Attribute;
import src.AttributeHandler;
import src.FileItem;
import src.FolderItem;
import Utilities.BasicOperation;


/**
 * Unit test for  FolderItem Object
 * @author Daniel Gumucio
 */
public class FolderItemTest {
      
   @Test
   public void createAFolder()
   {
       Attribute attributeReadOnly = new  Attribute("ReadOnly", "Enabled");
       Attribute attributeHidden = new Attribute("Hidden", "Disabled");
       ArrayList<Attribute> listAttributes = new ArrayList<>() ;
       listAttributes.add(attributeReadOnly);
       listAttributes.add(attributeHidden);
                
       AttributeHandler attributeList = new AttributeHandler(listAttributes);
       
       FolderItem folderItem = new FolderItem("test", File.listRoots()[0].getAbsolutePath(), 0, attributeList);
       
       assertFalse( folderItem.getName().isEmpty()); 
   }        
    
   @Test
   public void VerifyCreateItemListingFolders()
    {
        Path path = Paths.get(File.listRoots()[0].getAbsolutePath());
        File folder = path.toFile();
        File[] files = folder.listFiles();
        ArrayList<FolderItem> items = new ArrayList<>();
        
        for (int index = 0; index < files.length; index++) 
        {
            if(files[index].isDirectory())
            {
                FolderItem itemFolder = new FolderItem( files[index]);
                items.add(itemFolder);
            }   
        }
        
        boolean areFolder = true;
        for(int indexItemList = 0; indexItemList < items.size(); indexItemList++)
        {
            if(!(items.get(indexItemList) instanceof FolderItem))
            {
                areFolder = false;
                break;
            }
        }
        assertTrue(areFolder);
    }
 
   
   @Test
   public void getItemsForAFolderThatisEmpty()
   {
       Attribute attributeReadOnly = new  Attribute("ReadOnly", "Enabled");
       Attribute attributeHidden = new Attribute("Hidden", "Disabled");
       ArrayList<Attribute> listAttributes = new ArrayList<>() ;
       listAttributes.add(attributeReadOnly);
       listAttributes.add(attributeHidden);
                
       AttributeHandler attributeList = new AttributeHandler(listAttributes);
       FolderItem folderItem = new FolderItem("testFolder", File.listRoots()[0].getAbsolutePath()+"testfolder", 0, attributeList );
       
       Path path = Paths.get(folderItem.getLocation());
       File folder = path.toFile();
       File[] files = folder.listFiles();
       folder.delete();
              
       assertTrue(folderItem.getItemList()==null);
   }
  
   @Test
   public void getItemsForAFolderWhichHasItems()
   {
       Attribute attributeReadOnly = new  Attribute("ReadOnly", "Enabled");
       Attribute attributeHidden = new Attribute("Hidden", "Disabled");
       ArrayList<Attribute> listAttributes = new ArrayList<>() ;
       listAttributes.add(attributeReadOnly);
       listAttributes.add(attributeHidden);
                
       AttributeHandler attributeList = new AttributeHandler(listAttributes);
       FolderItem folderItem = new FolderItem("testFolder", File.listRoots()[0].getAbsolutePath(), 0, attributeList);
       
       FileItem fileItem = new FileItem("test", folderItem.getLocation()+""+folderItem.getName(), 0, attributeList, ".txt");
       
      
       assertFalse(folderItem.getItemList().isEmpty());
       
       //Cleanning the folder after  testing, maybe  this  should be part of  other method from this  class
       
       Path path = Paths.get(folderItem.getLocation());
       File folder = path.toFile();
       File[] files = folder.listFiles();
       
       for(int iterator = 0; iterator < files.length; iterator++)
       {
           if(files[iterator].getName().equals(folderItem.getName()))
           {
               BasicOperation.deleteItem(files[iterator]);
               break;
           } 
       }
   }
   
  @Test
   public void setAttributeOfFolder()
   {
       Attribute attributeReadOnly = new  Attribute("ReadOnly", "Disabled");
       Attribute attributeHidden = new Attribute("Hidden", "Disabled");
       ArrayList<Attribute> listAttributes = new ArrayList<>() ;
       listAttributes.add(attributeReadOnly);
       listAttributes.add(attributeHidden);
                
       AttributeHandler attributeList = new AttributeHandler(listAttributes);
       
       FolderItem folderItem = new FolderItem("test", File.listRoots()[0].getAbsolutePath(), 0, attributeList);
       
       Attribute attributeReadOnlyFalse = new  Attribute("Hidden", "Enabled");
       
       assertTrue(folderItem.setFolderAttribute(attributeReadOnlyFalse));
   }
}