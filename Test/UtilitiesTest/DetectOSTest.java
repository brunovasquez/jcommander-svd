/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilitiesTest;

import Utilities.DetectOS;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author vania huayta
 */
public class DetectOSTest {
    @Test
    public void testWindowsOS()
    {
        assertTrue(DetectOS.isWindows());
    }
    
    @Test
    public void testNotLinuxOS()
    {
        assertFalse(DetectOS.isUnix());
    }
}
