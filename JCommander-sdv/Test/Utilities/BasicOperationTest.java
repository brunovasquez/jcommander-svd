/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @version 1.0
 * @since   2016-05-22 
 * @author vania huayta
 */
public class BasicOperationTest {
    @Test
    public void testCopyFileToAnotherPathWhereFileDoesNotExist(){
        File source = new File("C:\\Users\\Usuario\\Documents\\text.txt");
        File target = new File("C:\\Users\\Usuario\\Documents\\test\\text.txt");
                
        boolean result = BasicOperation.copyItem(source, target);
        
        assertTrue(result);
    }
    
    @Test
    public void testCopyFileToAnotherPathWhereFileAlreadyExistAndReplace(){
        File source = new File("C:\\Users\\Usuario\\Documents\\text.txt");
        File target = new File("C:\\Users\\Usuario\\Documents\\test\\text.txt");
        
        boolean result = BasicOperation.copyItem(source, target);
        
        assertTrue(result);
    }
    
    @Test
    public void testCopyDirectoryToAnotherPath(){
        File source = new File("C:\\Users\\Usuario\\Documents\\test2");
        File target = new File("C:\\Users\\Usuario\\Documents\\test8");
        
        boolean result = BasicOperation.copyItem(source, target);
        
        assertTrue(result);
    }
}
