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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Basics operation to perform with a file or directory.
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
    public static boolean copyItem(File source, File target){
        boolean result;
        if(source.isFile()){
            copyFile(source, target);
            result = true;
        }else{
            copyDirectory(source,target);
            result = true;
        }
        return result;
    }
    
    /**
     * Method to copy recursively a file.
     * @param source Name + source path for the file to be copied
     * @param target Name + target path for the file 
     */
    private static void copyFile(File source, File target){
        try {
            //REPLACE_EXISTING should be editable
            Files.copy(source.toPath(), target.toPath(), REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(BasicOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Method to copy recursively a directory with 
     * files and other directories. 
     * @param source Name + source path for the file to be copied
     * @param target Name + target path for the file
      */
    private static void copyDirectory(File source, File target){
        if (!target.exists()) {
            target.mkdir();
        }
        for (String file : source.list()) {
            copyItem(new File(source, file), new File(target, file));
        }
    }
    
    public static boolean deleteItem(File source){
        return true;
    }
    
    public static boolean moveItem(Object item, String path){
        return true;
    }
    
    public static String[] searchItem(String itemName, String path){
        //return a list of paths
        String[] coincidences = new String[0];
        return coincidences;
    }
}
