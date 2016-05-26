/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Basics operation to perform with one file or directory selected.
 * - Copy one file/directory (implemented)
 * - Delete one file/directory (not yet)
 * - Move one file/directory (not yet)
 * 
 * @version 1.0
 * @since   2016-05-19 
 * @author vania huayta
 */
public class BasicOperation {
    
    /**
     * Method to copy a file or directory with files 
     * and other directories.
     * @param source Name + source path for the file or directory to be copied
     * @param target Name + target path for the file or directory
     * @return true when the Item was copied successfully.
     */
    public static boolean copyItem(File source, File target) {
        boolean result;
        if (source.isFile()) {
            result = copyFile(source, target);
        } else {
            result = copyDirectory(source, target);
        }
        return result;
    }
    
    /**
     * Method to copy recursively a file.
     * @param source Name + source path for the file to be copied
     * @param target Name + target path for the file 
     * @return True when the file was copied successfully
     */
    private static boolean copyFile(File source, File target) {
        boolean result;
        try {
            //REPLACE_EXISTING should be editable
            Files.copy(source.toPath(), target.toPath(), REPLACE_EXISTING);
            result = true;
        } catch (IOException ex) {
            Logger.getLogger(BasicOperation.class.getName()).log(Level.SEVERE, null, ex);
            result = false;
        }
        return result;
    }
    
    /**
     * Method to copy recursively a directory with 
     * files and other directories. 
     * @param source Name + source path for the file to be copied
     * @param target Name + target path for the file
     * @return true when the directory was copied successfully
      */
    private static boolean copyDirectory(File source, File target) {
        if (!target.exists()) {
            target.mkdirs();
        }
        boolean result = false;
        if (source.exists()) {
            for (String file : source.list()) {
                File sourceFile = new File(source, file);
                File targetFile = new File(target, file);
                copyItem(sourceFile, targetFile);
            }
        }
        
        if (Arrays.equals(source.list(), target.list()) && target.exists()) {
            result = true;
        }
        return result;
    }
    
    /**
     * Method to delete an Item
     * @param item Name + source path for the file to be copied
     * @return true, when the Item was deleted successfully
      */
    public static boolean deleteItem(File item) {
        return true;
    }
    
    /**
     * Method to move an Item to a new path 
     * @param source Name + source path for the file to be moved
     * @param target Name + target path for the file
     * @return true, when an Item was moved to a new path successfully
      */
    public static boolean moveItem(File source, File target) {
        return true;
    }
    
    /**
     * Method to Search an Item in a specific path.
     * @param itemName Name of the item to be searched.
     * @param path Path where search for the item.
     * @return coincidences is a list of paths where the file was found.
      */
    public static String[] searchItem(String itemName, String path) {
        //return a list of paths
        String[] coincidences = new String[0];
        return coincidences;
    }
}
