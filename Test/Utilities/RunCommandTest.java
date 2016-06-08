/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vania huayta
 */
public class RunCommandTest {
    @Test
    public void testRunCommandWindows() {
        String command = "cmd /c start cmd.exe";
                
        assertTrue(RunCommand.run(command));
    }
}
