/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import SRC.Attribute;
import SRC.AttributeHandler;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author compu
 */
public class AttributeHandlerTest {
    
    public AttributeHandlerTest() {
    }

    @Test
    public void attributeHandlerHasListAttributes()
    {
        Attribute attributeReadOnly = new  Attribute("ReadOnly","Enabled");
        Attribute attributeHidden = new Attribute("Hidden","Disabled");
        ArrayList<Attribute> listAttributes = new ArrayList<>() ;
        listAttributes.add(attributeReadOnly);
        listAttributes.add(attributeHidden);
                
        AttributeHandler attributeHandler = new AttributeHandler(listAttributes);
        boolean areAttributes=true;
        for(int i=0;i<listAttributes.size();i++)
        { 
            if(!(listAttributes.get(i).isAttribute(listAttributes.get(i))))
            {
                areAttributes= false;
            }
        }
        
        assertTrue(attributeHandler.getAllList().size()>0 && areAttributes);
    }
    
    @Test
    public void addNewAttributeInList()
    {
        Attribute attributeReadOnly = new  Attribute("ReadOnly","Enabled");
        ArrayList<Attribute> listAttributes = new ArrayList<>() ;
        listAttributes.add(attributeReadOnly);
        assertEquals("ReadOnly",listAttributes.get(0).getNameAttribute());
    }
    @Test
    public void deleteAttributeFromTheList()
    {
        Attribute attributeReadOnly = new  Attribute("ReadOnly","Enabled");
        Attribute attributeHidden = new Attribute("Hidden","Disabled");
        
        ArrayList<Attribute> listAttributes = new ArrayList<>() ;
        
        listAttributes.add(attributeReadOnly);
        listAttributes.add(attributeHidden);
        
        AttributeHandler attributeHandler = new AttributeHandler(listAttributes);
        
        attributeHandler.deleteAttribute(attributeReadOnly);
        
        
        assertEquals(null,attributeHandler.getAttributeFromList("ReadOnly"));
               
    }
    
    @Test
    public void getAttributesList()
    {
        Attribute attributeReadOnly = new  Attribute("ReadOnly","Enabled");
        Attribute attributeHidden = new Attribute("Hidden","Disabled");
        
        ArrayList<Attribute> listAttributes = new ArrayList<>() ;
        
        listAttributes.add(attributeReadOnly);
        listAttributes.add(attributeHidden);
        
        AttributeHandler attributeHandler = new AttributeHandler(listAttributes);
        
        assertTrue(attributeHandler.getAllList().size()>0);
    }
    
    @Test
    public void searchEspecificAttributeFromList()
    {
        Attribute attributeReadOnly = new  Attribute("ReadOnly","Enabled");
        Attribute attributeHidden = new Attribute("Hidden","Disabled");
        
        ArrayList<Attribute> listAttributes = new ArrayList<>() ;
        
        listAttributes.add(attributeReadOnly);
        listAttributes.add(attributeHidden);
        
        AttributeHandler attributeHandler = new AttributeHandler(listAttributes);
        
        Attribute searched = attributeHandler.getAttributeFromList("Hidden");
        
        assertEquals("Hidden", searched.getNameAttribute());
    }
    
    @Test
    public void searchAnAttributeThatDoesNotExistInList()
    {
        Attribute attributeReadOnly = new  Attribute("ReadOnly","Enabled");
        Attribute attributeHidden = new Attribute("Hidden","Disabled");
        
        ArrayList<Attribute> listAttributes = new ArrayList<>() ;
        
        listAttributes.add(attributeReadOnly);
        listAttributes.add(attributeHidden);
        
        AttributeHandler attributeHandler = new AttributeHandler(listAttributes);
        
        Attribute searched = attributeHandler.getAttributeFromList("Other");
        
        assertEquals(null, searched);
    }
}
