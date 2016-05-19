/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vania huayta
 */
public class BasicOperation {
    
    public static boolean copyItem(File source, File target){
        boolean result=false;
        try {
            Files.copy(source.toPath(), target.toPath(), REPLACE_EXISTING);
            result= true;
        } catch (IOException ex) {
            Logger.getLogger(BasicOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    /*public static boolean moveItem(Object item, String path){
        return true;
    }
    
    public static String[] searchItem(String itemName, String path){
        //return a list of paths
        String[] coincidences = new String[0];
        return coincidences;
    }*/
}
