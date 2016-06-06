/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 * @author Daniel Gumucio
 * Attribute  represent  the  attribute  that could  have  a  file or  folder
 */
public class Attribute {
    
    public String nameAttribute;
    public String valueAttribute;
    
    /**
     * This  method  construct an Attribute 
     * @param name String name of attribute
     * @param value String  value of  attribute
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
     * Method to get name  of  Attribute
     * @return an String that in this  case is the  name  of  Attribute
     */
    public String getNameAttribute()
    {
        return nameAttribute;
    }
    
    /**
     * Method to get value  of  Attribute
     * @return an String that in this  case is the Value  of  Attribute 
     */
    public String getValueAttribute()
    {
        return valueAttribute;
    }
    
    /**
     * This  method update name of  an Attribute
     * @param newNameAttribute is  an  String  that  contains  the  new  name
     * @return boolean - true if  the  name was  changed
     */
    public  boolean setNameAttribute(String newNameAttribute)
    {
        if(!(newNameAttribute.replaceAll("\\s", "").isEmpty()))
        {
            nameAttribute = newNameAttribute;
        }
        
        return nameAttribute.equals(newNameAttribute);
    }
    
    /**
     * This  method update  the  value of an Attribute
     * @param newValueAttribute String that  contains  the new  value  of  attribute
     * @return boolean is  true if value is  changed
     */
    public  boolean setValueAttribute(String newValueAttribute)
    {
        if(!(newValueAttribute.replaceAll("\\s", "").isEmpty()))
        {
             valueAttribute = newValueAttribute;
        }
        
        return valueAttribute.equals(newValueAttribute);
    }
    
    /**
     * Method  that see if  it is  an attribute object
     * @param other is  an  attribute  object
     * @return boolean true  if object is  attribute
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
