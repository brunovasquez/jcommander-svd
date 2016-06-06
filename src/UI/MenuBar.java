/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javax.swing.JMenuBar;

/**
 * Class to define the Menu Bar's components
 * @author Shirley Pinto
 */
class MenuBar extends JMenuBar {
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuFile;

    /**
     * Main method where the menu bar's components are defined: File and Edit
     */
    public MenuBar() {
        
        jMenuFile = new javax.swing.JMenu();
        jMenuEdit = new javax.swing.JMenu();
        
        jMenuFile.setText("File");
        this.add(jMenuFile);

        jMenuEdit.setText("Edit");
        this.add(jMenuEdit);
    }
}