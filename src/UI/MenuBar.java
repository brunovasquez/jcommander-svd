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
class MenuBar extends JMenuBar{
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuSearch;

    public MenuBar() {
        
        jMenuFile = new javax.swing.JMenu();
        jMenuEdit = new javax.swing.JMenu();
        jMenuSearch = new javax.swing.JMenuItem("Search for files");
        
        jMenuFile.setText("File");
        jMenuFile.add(jMenuSearch);
        this.add(jMenuFile);
        
        jMenuSearch.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSearchActionPerformed(evt);
            }
        });

        jMenuEdit.setText("Edit");
        this.add(jMenuEdit);

    }
    
    private void jMenuSearchActionPerformed(java.awt.event.ActionEvent evt) {
        SearchPanel searchPanel = new SearchPanel();
        
    }
}
