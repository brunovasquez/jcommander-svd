/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;
import src.Attribute;
import src.AttributeHandler;
import src.FileItem;

/*
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import src.Attribute;
import src.AttributeHandler;
import src.FileItem;*/

/**
 * Class in charge to test FileItem object
 * @author Daniel Gumucio
 */
public class FileItemTest {
    
   @Test
   public void createAFile()
   {
       Attribute attributeReadOnly = new  Attribute("ReadOnly", "Enabled");
       Attribute attributeHidden = new Attribute("Hidden", "Disabled");
       ArrayList<Attribute> listAttributes = new ArrayList<>() ;
       listAttributes.add(attributeReadOnly);
       listAttributes.add(attributeHidden);
                
       AttributeHandler attributeList = new AttributeHandler(listAttributes);
       
       FileItem fileItem = new FileItem("test", File.listRoots()[0].getAbsolutePath(), 0, attributeList, ".txt");
       
       assertFalse( fileItem.getName().isEmpty());  
   }        
    
   @Test
   public void VerifyCreateItemListingFiles()
    {
        Path path = Paths.get(File.listRoots()[0].getAbsolutePath());
        File f = path.toFile();
        File[] files = f.listFiles();
        ArrayList<FileItem> items = new ArrayList<>();
        
        for (int index = 0; index < files.length; index++) 
        {
            if(files[index].isFile())
            {
                FileItem itemFile = new FileItem( files[index]);
                items.add(itemFile);
            }   
        }
        
        boolean areFiles = true;
        for(int indexItemList = 0; indexItemList < items.size(); indexItemList++)
        {
            if(!items.get(indexItemList).isFileItem())
            {
                areFiles = false;
                break;
            }
        }
        assertTrue(areFiles);
    }
 
   @Test
   public void getExtensionForAFile()
   {
       Attribute attributeReadOnly = new  Attribute("ReadOnly", "Enabled");
       Attribute attributeHidden = new Attribute("Hidden", "Disabled");
       ArrayList<Attribute> listAttributes = new ArrayList<>() ;
       listAttributes.add(attributeReadOnly);
       listAttributes.add(attributeHidden);
                
       AttributeHandler attributeList = new AttributeHandler(listAttributes);
       
       FileItem fileItem = new FileItem("test", File.listRoots()[0].getAbsolutePath(), 0, attributeList, ".txt");
       
       assertEquals(".txt", fileItem.getExtension());
   }
   
   @Test
   public void setExtensionForAfile()
   {
       Attribute attributeReadOnly = new  Attribute("ReadOnly", "Enabled");
       Attribute attributeHidden = new Attribute("Hidden", "Disabled");
       ArrayList<Attribute> listAttributes = new ArrayList<>() ;
       listAttributes.add(attributeReadOnly);
       listAttributes.add(attributeHidden);
                
       AttributeHandler attributeList = new AttributeHandler(listAttributes);
       
       FileItem fileItem = new FileItem("test", File.listRoots()[0].getAbsolutePath(), 0, attributeList, ".txt");
       fileItem.setExtension(".doc");
       
       assertEquals(".doc", fileItem.getExtension());
   }
}
