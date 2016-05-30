/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 * Class to detect the OS platform where the Application is running
 * 
 * @version 1.0
 * @since   2016-05-15 
 * @author vania huayta
 */
class DetectOS {
    private static String OS = System.getProperty("os.name").toLowerCase();

    /**
     * Method that return "true" when the OS is equals to Windows.
     * @return true when the OS is Windows.
     */
    static boolean isWindows() {
        return (OS.contains("win"));
    }

    /**
     * Method that return "true" when the OS is equals to MacOS.
     * @return true when the OS is MacOS.
     */
    static boolean isMac() {
        return (OS.contains("mac"));
    }

    /**
     * Method that return "true" when the OS is equals to Unix, Linux.
     * @return true when the OS is Unix, Linux.
     */
    static boolean isUnix() {
        return (OS.contains("nux") || OS.contains("nix") || OS.contains("aix"));
    }
}
