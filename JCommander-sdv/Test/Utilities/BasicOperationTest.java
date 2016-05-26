/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.File;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @version 1.0
 * @since   2016-05-22 
 * @author vania huayta
 */
public class BasicOperationTest {
<<<<<<< HEAD
    /*@Test
    public void testCopyFileToAnotherPathWhereFileDoesNotExist() throws IOException{
=======
    @Test
    public void testCopyFileToAnotherPathWhereFileDoesNotExist() 
            throws IOException {
>>>>>>> refs/remotes/origin/CopyItem
        File source = new File("test.txt");
        if (!source.exists()) {
            source.createNewFile();
        }
        File targetFolder = new File("folderTest");
        targetFolder.mkdir();
        File target = new File(targetFolder.getAbsolutePath(), "test.txt");
        
        boolean result = BasicOperation.copyItem(source, target);
        
        assertTrue(result);
    }
    
    @Test
    public void testCopyFileToAnotherPathWhereFileAlreadyExistsAndReplace() 
            throws IOException {
        File source = new File("test.txt");
        if (!source.exists()) {
            source.createNewFile();
        }
        File targetFolder = new File("folderTest");
        targetFolder.mkdir();
        File target = new File(targetFolder.getAbsolutePath(), "test.txt");
        if (!target.exists()) {
            BasicOperation.copyItem(source, target);
        }
        boolean result = BasicOperation.copyItem(source, target);
        
        assertTrue(result);
    }
    
    @Test
    public void testCopyEmptyDirectoryToAnotherPath() {
        File source = new File("folderEmpty");
        source.mkdir();
        File target = new File("folderTest" + File.separator + "folderEmpty");
        
        boolean result = BasicOperation.copyItem(source, target);
        
        assertTrue(result);
    }
    
    @Test
    public void testCopyDirectoryWhitFileAndEmptyDirectoryToAnotherPath() {
        File source = new File("folderTest");
        source.mkdir();
        File target = new File("folderTest2");
        
        boolean result = BasicOperation.copyItem(source, target);
        
        assertTrue(result);
    }*/
    
    @Test
    public void testDeleteSingleFile() throws IOException{
        File file = new File("test.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        boolean result = BasicOperation.deleteItem(file);
        
        assertTrue(result);
    }
    
    @Test
    public void testDeleteEmptyDirectory(){
        File emptyDirectory = new File("folderEmpty");
        emptyDirectory.mkdir();
                
        boolean result = BasicOperation.deleteItem(emptyDirectory);
        
        assertTrue(result);
    }
}
