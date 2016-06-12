/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Class for different type of search methods to be used
 * 
 * @version 1.0
 * @since   2016-06-07 
 * @author vania huayta
 */
public class SearchItem {
    
    /**
     * Method to Search an Item in a specific path using wildcards as * and ?.
     * @param itemName Name of the item to be searched.
     * @param path String of the path where search for the item.
     * @param items List of coincidences.
     * @return coincidences is a list of paths where the file was found.
      */
    public static List<String> searchUsingWilcards(String itemName, File path, List<String> items) {
        List<String> result = items;
        File[] list = path.listFiles();
        if(list != null) {
            search(itemName, list, result);
        }
        return result;
    }
    /**
     * Method used by searchUsingWilcards, so it can iterate when there are directories.
     * @param itemName Name of the item to be searched.
     * @param list String of the path where search for the item.
     * @param items List of coincidences.
     * @return coincidences is a list of paths where the file was found.
     */
    static List<String> search(String itemName, File[] list, List<String> items) {
        List<String> result = items;
        String regularExpression = itemName.replace("*", ".*").replace("?", ".?");
        Pattern pattern = Pattern.compile(regularExpression);
        for (File file : list) {
            String filename = file.getAbsolutePath();
            Matcher matcher = pattern.matcher(filename);
            if (matcher.matches()) {
                result.add(filename);
            }
            if (file.isDirectory()) {
                searchUsingWilcards(itemName, file, result);
            }
        }
        return result;
    }
}
