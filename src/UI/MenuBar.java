/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem ;
import java.awt.event.*;
/**
 * Class to define the Menu Bar's components
 * @author Shirley Pinto
 */
class MenuBar extends JMenuBar {
    private JMenu jMenuEdit;
    private JMenu jMenuFile;
    private JMenuItem jMenuCreateFile; 
            
    public MenuBar() {
       
        jMenuFile = new JMenu();
        jMenuEdit = new JMenu();
        jMenuCreateFile = new JMenuItem("Create File");
                
        jMenuFile.setText("File");
        jMenuFile.add(jMenuCreateFile);
        this.add(jMenuFile);

        jMenuCreateFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jMenuCreateFileActionPerformed(evt);
            }
        });

        
        jMenuEdit.setText("Edit");
        this.add(jMenuEdit);
    }
    
    /**
     * Method to create file after selecting the menu
     * @param event 
     */
    private void jMenuCreateFileActionPerformed(ActionEvent event) {
        if(BodyPanel.selectedPath != null) {
            CreateFile createFile = new CreateFile();
            createFile.setVisible(true);
        }
    }
}  

