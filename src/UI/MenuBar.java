/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * Class to define the Menu Bar's components
 * @author Shirley Pinto
 */
class MenuBar extends JMenuBar {
    private JMenu jMenuEdit;
    private JMenu jMenuFile;

    public MenuBar() {
        
        jMenuFile = new JMenu();
        jMenuEdit = new JMenu();
        
        jMenuFile.setText("File");
        this.add(jMenuFile);

        jMenuEdit.setText("Edit");
        this.add(jMenuEdit);
    }  
}
