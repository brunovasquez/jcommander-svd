/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javax.swing.JMenuBar;

/**
 *
 * @author Shirley Pinto
 */
class MenuBar extends JMenuBar{
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuFile;

    public MenuBar() {
        
        jMenuFile = new javax.swing.JMenu();
        jMenuEdit = new javax.swing.JMenu();
        
        jMenuFile.setText("File");
        this.add(jMenuFile);

        jMenuEdit.setText("Edit");
        this.add(jMenuEdit);

    }
    
    
}
