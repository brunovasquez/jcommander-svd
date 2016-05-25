/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SRC;

import java.util.ArrayList;


/**
 * This object in charge  to manage  attributes
 * @author Jcomander-svd
 */
public class AttributeHandler {
    
    ArrayList<Attribute> listAttributes;
    /**
     * Construct  the  object  with list of  attributes
     * @param listAttributes 
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
     * @return 
     */
    public boolean addNewAttribute(Attribute newAttribute)
    {
        return this.listAttributes.add(newAttribute);
    }
    
    /**
     * Method to  delete attributes  from  list
     * @param otherAttribute
     * @return 
     */
    public boolean deleteAttribute(Attribute otherAttribute)
    {
        return this.listAttributes.remove(otherAttribute);
    }
    
    /**
     * Methos  to get All list of  attributes
     * @return 
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
       int indexOfAttribute = searchAttribute(nameAttribute, this.listAttributes, 0); 
       if(indexOfAttribute != -1)
       {
            searched = this.listAttributes.get(indexOfAttribute);
       }
       
       return searched;
    }
    
    /**
     * Method to search  an  attribute  in the  list
     * @param nameAttribute
     * @param listAttributesSearch
     * @return the  index of attribute  in the  list
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
               indexList=indexList+1;
               indexResult = searchAttribute(nameAttribute, listAttributesSearch, indexList);
           }
        }
        return indexResult;
    }
}
