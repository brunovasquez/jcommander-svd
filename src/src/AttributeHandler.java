/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;


/**
 * This object in charge  to manage  attributes
 * @author Daniel Gumucio
 */
public class AttributeHandler {
    
    ArrayList<Attribute> listAttributes;
    /**
     * Construct  the  object  with list of  attributes
     * @param listAttributes it  is a  list of attributes 
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
     * @param newAttribute it  is an Attribute object
     * @return boolean true if attribute was  added to the  list
     */
    public boolean addNewAttribute(Attribute newAttribute)
    {
        return this.listAttributes.add(newAttribute);
    }
    
    /**
     * Method to  delete attributes  from  list
     * @param otherAttribute It is an attribute object
     * @return boolean true if  Attribute was  deleted from the list
     */
    public boolean deleteAttribute(Attribute otherAttribute)
    {
        return this.listAttributes.remove(otherAttribute);
    }
    
    /**
     * Method  to get All list of  attributes
     * @return ArrayList it  is  an ArrayList of  Attributes
     */
    public ArrayList<Attribute> getAllList()
    {
        return this.listAttributes;
    }
    
    /**
     * Method to get an especific  attribute from the  list
     * for  this  use  another method search()
     * @param nameAttribute String  it is  the name of an Attribute
     * @return Attribute object that has  that name
     */
    public Attribute getAttributeFromList(String nameAttribute)
    {
       Attribute searched = null;
       int indexOfAttribute = searchAttribute(nameAttribute, this.listAttributes, 0); 
       if(indexOfAttribute != -1)
       {
            searched = this.listAttributes.get(indexOfAttribute);
       }
       
       return searched;
    }
    
    /**
     * Method to search  an  attribute  in the  list
     * @param nameAttribute String It  is name of Attribute
     * @param listAttributesSearch ArrayList It  is  the  ArrayList that contains all Attributes
     * @param indexList int Integer number that represent  the index of  ArrayList
     * @return the  index of attribute  in the  list, if  Attribute  does not  exist return -1
     */
    private int searchAttribute(String nameAttribute, ArrayList<Attribute> listAttributesSearch, int indexList)
    {
        int indexResult = -1;
        
        if(!(nameAttribute.isEmpty() || listAttributesSearch.isEmpty() || listAttributesSearch.size() <= indexList)) 
        {
           if(listAttributesSearch.get(indexList).getNameAttribute().equals(nameAttribute))
            {
                    indexResult = indexList;
            }
           else
           {
               indexList = indexList + 1;
               indexResult = searchAttribute(nameAttribute, listAttributesSearch, indexList);
           }
        }
        return indexResult;
    }
}
