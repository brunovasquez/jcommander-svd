/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to run a command that depends on OS platform
 * 
 * @version 1.0
 * @since   2016-05-29 
 * @author vania huayta
 */
public class RunCommand {
    
    /**
     * Method to run a command in Windows Machine
     * @param command String that contains the command to be executed
     * @return result message from the command execution, it will be empty if the command didn't worked
     */
    static String runCommandWindows(String command) {        
        String line;  
        String result = "";
        String executeCmd = "cmd /c" + " " + command;             
        Process runtimeProcess;
        try {                           
                runtimeProcess = Runtime.getRuntime().exec(executeCmd);
                runtimeProcess.waitFor();
                BufferedReader reader = new BufferedReader(new InputStreamReader(runtimeProcess.getInputStream()));
                line = reader.readLine();
                while (line != null) {
                    if (result.compareTo("") == 0)
                        result = line;
                    else
                        result = result +"\n"+line;
                    line = reader.readLine();                                        
                }
        } catch (IOException | InterruptedException e) {
            Logger.getLogger(RunCommand.class.getName()).log(Level.SEVERE, "Error to execute command on windows: ", e);
        }                
        return result;
    }
    
    /**
     * Method to run a command in Windows Machine
     * @param command String that contains the command to be executed
     * @return result message from the command execution, it will be empty if the command didn't worked
     */
    static String runCommandLinux(String command) {        
        //TODO complete Run command for Linux machines
        String result = "";
        return result;
    }
}
