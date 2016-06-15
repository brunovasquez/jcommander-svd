/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import com.jcraft.jsch.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.Channel;
import java.util.Properties;
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
    public static String runCommandWindows(String command) {        
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
                        result = result + "\n" + line;
                    line = reader.readLine();                                        
                }
        } catch (IOException | InterruptedException e) {
            Logger.getLogger(RunCommand.class.getName()).log(Level.SEVERE, "Error to execute command on windows: ", e);
        }                
        return result;
    }
    
    /**
     * Method to run a command in Linux Machine
     * @param userName String for user name to be used for execute the command
     * @param portServer port number to be used for execute the command
     * @param password String for password to be used for execute the command
     * @param command String that contains the command to be executed
     * @param hostname String for the server hostname to be used to execute the command
     * @return result message from the command execution.
     */
    public static String runCommandLinux(String userName, String password, int portServer, String command, String hostname) {        
        String result = "";
        JSch js = new JSch();        
        try {
                Session session = js.getSession(userName, hostname, portServer);
                session.setPassword(password);
                Properties config = new Properties();
                config.put("StrictHostKeyChecking", "no");
                session.setConfig(config);
                session.connect();
                Channel objChannel = session.openChannel("exec");
                ChannelExec objChanelExec = (ChannelExec) objChannel;
                objChanelExec.setCommand(command);
                objChanelExec.setErrStream(System.err);
                objChanelExec.connect();
                BufferedReader reader = new BufferedReader(new InputStreamReader(objChanelExec.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    result= result + line + "\n"; 
                }
                objChanelExec.disconnect();
                session.disconnect();
        }catch (JSchException | IOException ex) {            
            Logger.getLogger(RunCommand.class.getName()).log(Level.SEVERE, "It was not possible execute command remotely on Linux machine, exception: {0}", ex);
        }
        return result;
    }
}
