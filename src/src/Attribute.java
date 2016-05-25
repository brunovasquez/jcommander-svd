/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SRC;

import java.util.Objects;

/**
 * @author Daniel Gumucio
 * Attribute  represent  the  attribute  that could  have  a  file or  folder
 */
public class Attribute {
    
    public String nameAttribute;
    public String valueAttribute;
    
    /**
     * This  method  construct an Attribute 
     * @param name String of attribute
     * @param value String of  attribute
     */
    public Attribute(String name, String value)
    {
        if(!(name.replaceAll("\\s", "").isEmpty()))
        {
            nameAttribute = name;
            valueAttribute = value;
        }
        
    }
    
    /**
     * Method to get name  of  Atribute
     * @return an String a  name  of  Attribute
     */
    public String getNameAttribute()
    {
        return nameAttribute;
    }
    
    /**
     * Method to get value  of  Attribute
     * @return an String Value  of  Attribute 
     */
    public String getValueAttribute()
    {
        return valueAttribute;
    }
    
    /**
     * This  method update name of  an Attribute
     * @param newNameAttribute
     * @return boolean - true if  the  name was  changed
     */
    public  boolean setNameAttribute(String newNameAttribute)
    {
        nameAttribute = newNameAttribute;
        return (nameAttribute == null ? newNameAttribute == null : nameAttribute.equals(newNameAttribute));
    }
    
    /**
     * This  method update  the  value of an Attribute
     * @param newValueAttribute String
     * @return boolean if value is  changed
     */
    public  boolean setValueAttribute(String newValueAttribute)
    {
        valueAttribute = newValueAttribute;
        return (valueAttribute == null ? newValueAttribute == null : valueAttribute.equals(newValueAttribute));
    }
    
    /**
     * Method  that see if  it is  an attribute
     * @param other
     * @return 
     */
    public boolean isAttribute(Attribute other)
    {
        boolean result = true;
        
        if(!(other.getNameAttribute()instanceof String)|| !(other.getValueAttribute() instanceof String))
        {
           result = false;
        }
        
        return result;
    }
    
    
 
}
