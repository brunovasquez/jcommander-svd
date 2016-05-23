/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import SRC.Attribute;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class in charge  to run unit  tests fro  Attribute Object
 * @author Daniel Gumucio
 */
public class AttributeTest {
    
    public AttributeTest() {
    }
    
    @Test
    public void verifyAttributeIsCreatedWithNameAndValue() {
        Attribute attribute = new Attribute("ReadOnly","Enabled");
        
        String nameAttribute = "ReadOnly";
        String valueAttribute = "Enabled";
        
        assertTrue(nameAttribute.equals(attribute.getNameAttribute()) 
                && valueAttribute.equals(attribute.getValueAttribute()));
    }
    
    @Test
    public void verifyNameIsSet()
    {
        Attribute attribute = new Attribute("ReadOnly","Enabled");
        String nameAttribute = "Hidden";
        
        assertTrue(attribute.setNameAttribute(nameAttribute));
                
    }
    
    @Test
    public void verifyValueIsSet()
    {
        Attribute attribute = new Attribute("ReadOnly","Enabled");
        String valueAttribute = "Disabled";
        
        assertTrue(attribute.setValueAttribute(valueAttribute));
                
    }
    
    @Test
    public void verifyNameIsNotNull()
    {
        Attribute attribute = new Attribute("","Enabled");
        
        assertEquals(null,attribute.getValueAttribute());
    }
    
    @Test
    public void verifyIfItIsAnAttribute()
    {
        Attribute attribute = new Attribute("ReadOnly","Enabled");
        
        assertTrue(attribute.isAttribute(attribute));
    }
}
