/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SRC;

import java.util.ArrayList;


/**
 * This object in charge  to manage  attributes
 * @author Daniel Gumucio
 */
public class AttributeHandler {
    
    ArrayList<Attribute> listAttributes;
    /**
     * Construct  the  object  with list of  attributes
     * @param listAttributes - arrayList of attributes
     */
    public AttributeHandler(ArrayList<Attribute> listAttributes)
    {
        if(!listAttributes.isEmpty())
        {
            this.listAttributes = listAttributes;
        }
    }
    
    /**
     * Method to  add attributes from list
     * @param newAttribute
     * @return boolean
     */
    public boolean addNewAttribute(Attribute newAttribute)
    {
        return this.listAttributes.add(newAttribute);
    }
    
    /**
     * Method to  delete attributes  from  list
     * @param otherAttribute
     * @return boolean
     */
    public boolean deleteAttribute(Attribute otherAttribute)
    {
        return this.listAttributes.remove(otherAttribute);
    }
    
    /**
     * Method  to get All list of  attributes
     * @return ArrayList of  attributes
     */
    public ArrayList<Attribute> getAllList()
    {
        return this.listAttributes;
    }
    
    /**
     * method to get an especific  attribute from the  list
     * for  this  use  another method search()
     * @param nameAttribute
     * @return Attribute object
     */
    public Attribute getAttributeFromList(String nameAttribute)
    {
       Attribute searched = null;
       int indexOfAttribute = searchAttribute(nameAttribute,this.listAttributes); 
       if(indexOfAttribute != -1)
       {
            searched=this.listAttributes.get(indexOfAttribute);
       }
       
       return searched;
    }
    
    /**
     * Method to search  an  attribute  in the  list
     * @param nameAttribute
     * @param listAttributesSearch
     * @return the  index of attribute  in the  list
     */
    private int searchAttribute(String nameAttribute, ArrayList<Attribute> listAttributesSearch)
    {
        int index = -1;
        if(!(nameAttribute.isEmpty() || listAttributesSearch.isEmpty())) 
        {
            for (int i = 0; i < listAttributesSearch.size(); i++)
            {
                if(listAttributesSearch.get(i).getNameAttribute().equals(nameAttribute))
                {
                    index = i;
                } 
            }
        }
        
        return index;
    }
    
    
}
