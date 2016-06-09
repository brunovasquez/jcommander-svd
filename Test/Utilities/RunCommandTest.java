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
 *
 * @author vania huayta
 */
public class RunCommandTest {
    @Test
    public void testRunEmptyCommandOnWindows() {
        String command = "";
        String result = RunCommand.runCommandWindows(command);
        
        assertEquals(result,"");
    }
    
    @Test
    public void testRunDirCommandOnWindows() {
        String command = "dir";
        String result = RunCommand.runCommandWindows(command);
        
        assertNotEquals(result,"");
    }
    
    @Test
    public void testRunMkdirCommandOnWindows() {
        String command = "mkdir folderToTest";
        RunCommand.runCommandWindows(command);
        
        File folderToTest = new File("folderToTest");
        assertTrue(folderToTest.isDirectory());
        
        folderToTest.delete();
    }
    
    @Test
    public void testRunLsCommandLinux() {
        String result = RunCommand.runCommandLinux("root", "bobbit", 22, "whoami", "10.230.216.33");
        System.out.println(result);
        assertNotEquals(result,"");
    }
}
