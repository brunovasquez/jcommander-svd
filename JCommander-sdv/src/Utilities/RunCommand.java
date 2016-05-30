/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to run a command that depends on OS platform
 * 
 * @version 1.0
 * @since   2016-05-29 
 * @author vania huayta
 */
class RunCommand {
    
    private static String command = "";
    
    static void runCommand(String windowsCommand) {
        try {
            Process process = Runtime.getRuntime().exec(windowsCommand);
            process.waitFor();
            BufferedReader reader=new BufferedReader(
                new InputStreamReader(process.getInputStream())
            ); 
            String line; 
            while((line = reader.readLine()) != null) 
            { 
                System.out.println(line);
            }
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(RunCommand.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
