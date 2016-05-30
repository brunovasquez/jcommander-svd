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

    @Test
    public void testCopyFileToAnotherPathWhereFileDoesNotExist() 
            throws IOException {

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
    }
    
    @Test
    public void testDeleteSingleFile() throws IOException {
        File file = new File("test.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        boolean result = BasicOperation.deleteItem(file);
        
        assertTrue(result);
    }
    
    @Test
    public void testDeleteEmptyDirectory() {
        File emptyDirectory = new File("folderEmpty");
        emptyDirectory.mkdir();
                
        boolean result = BasicOperation.deleteItem(emptyDirectory);
        
        assertTrue(result);
    }
    
    @Test
    public void testDeleteDirectoryWithFiles() throws IOException {
        File directory = new File("folderWithFiles");
        directory.mkdir();
        File file1 = new File(directory.getAbsolutePath(), "test1");
        file1.createNewFile();
        File file2 = new File(directory.getAbsolutePath(), "test2");
        file2.createNewFile();
        
        assertTrue(BasicOperation.deleteItem(directory));
    }
    
    @Test
    public void testDeleteDirectoryWithFilesAndFolders() throws IOException {
        File directory = new File("folderWithFiles");
        directory.mkdir();
        File file1 = new File(directory.getAbsolutePath(), "test1");
        file1.createNewFile();
        File file2 = new File(directory.getAbsolutePath(), "test2");
        file2.createNewFile();
        
        File subDirectory = new File(directory.getAbsolutePath(), "subDirectory");
        subDirectory.mkdir();
        File file3 = new File(subDirectory.getAbsolutePath(), "test3");
        file3.createNewFile();
        
        assertTrue(BasicOperation.deleteItem(directory));
    }
    
    @Test
    public void testMoveSingleFile() throws IOException {
        File directory = new File("folderMove");
        directory.mkdir();
        
        File sourceFolder = new File(directory.getAbsolutePath(), "sourceFolder");
        sourceFolder.mkdir();
        
        File targetFolder = new File(directory.getAbsolutePath(), "targetFolder");
        targetFolder.mkdir();
        
        File file = new File(sourceFolder.getAbsolutePath(), "move");
        file.createNewFile();
        
        File source = new File(sourceFolder.getAbsolutePath(), file.getName());
        File target = new File(targetFolder.getAbsolutePath(), file.getName());
        
        assertTrue(BasicOperation.moveItem(source, target));
    }
    
    @Test
    public void testMoveEmptyDirectory() {
        File directory = new File("folderMove");
        if (!directory.exists()) {
            directory.mkdir();
        }
        File sourceFolder = new File(directory.getAbsolutePath(), "sourceFolder");
        sourceFolder.mkdir();
        
        File targetFolder = new File(directory.getAbsolutePath(), "targetFolder");
        targetFolder.mkdir();
        
        File source = sourceFolder;
        File target = new File(targetFolder.getAbsolutePath(), sourceFolder.getName());
        
        assertTrue(BasicOperation.moveItem(source, target));
    }
    
    @Test
    public void testMoveEmptyDirectoryWithFilesAndFolders() throws IOException {
        File directory = new File("folderMove");
        if (!directory.exists()) {
            directory.mkdir();
        }
        File sourceFolder = new File(directory.getAbsolutePath(), "sourceFolder");
        sourceFolder.mkdir();
        File file1 = new File(sourceFolder.getAbsolutePath(), "move1");
        file1.createNewFile();
        File file2 = new File(sourceFolder.getAbsolutePath(), "move2");
        file2.createNewFile();
        File secondSubDirectory = new File(sourceFolder.getAbsolutePath(), "secondFolder");
        secondSubDirectory.mkdir();
        File file3 = new File(secondSubDirectory.getAbsolutePath(), "move3");
        file3.createNewFile();
        
        File targetFolder = new File(directory.getAbsolutePath(), "targetFolder");
        targetFolder.mkdir();
        
        File source = sourceFolder;
        File target = new File(targetFolder.getAbsolutePath(), sourceFolder.getName());
        
        assertTrue(BasicOperation.moveItem(source, target));
    }
}
