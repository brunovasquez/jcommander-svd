/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.IOException;
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
     * Method to run a command 
     * @param command String that contains the command to be executed
     * @return true or false, depends on the running process
     */
    public static boolean run(String command) {
        boolean result = false;
        try {
            Process process = Runtime.getRuntime().exec(command);
            result = process.isAlive();
        } catch (IOException ex) {
            Logger.getLogger(RunCommand.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return result;
    }
}
