/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
/**
 *
 * @author Shirley Pinto
 */
public class ActionButtons extends JPanel {
    private JButton jButtonCopy;
    private JButton jButtonDelete;
    private JButton jButtonEdit;
    private JButton jButtonMove;
    
    public ActionButtons() {
        jButtonEdit = new javax.swing.JButton();
        jButtonCopy = new javax.swing.JButton();
        jButtonMove = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        
        jButtonEdit.setText("Edit");
        this.add(jButtonEdit);

        jButtonCopy.setText("Copy");
        jButtonCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCopyActionPerformed(evt);
            }    
        });
        
        this.add(jButtonCopy);

        jButtonMove.setText("Move");
        this.add(jButtonMove);

        jButtonDelete.setText("Delete");
        this.add(jButtonDelete);
    }
    
    /**
     * Method to active the event to copy an item
     * @param evt  
     */
    private void jButtonCopyActionPerformed(ActionEvent evt) {
         //TODO
    }
}
