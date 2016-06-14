/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.bind.Marshaller.Listener;

/**
 * Class where the action's buttons are defined
 * @author Shirley Pinto
 */
public class ActionButtons extends JPanel{
    private JButton jButtonCopy;
    private JButton jButtonDelete;
    private JButton jButtonEdit;
    private JButton jButtonMove;
    private JButton jButtonSearch;
    private JButton jButtonCreate;
    private JFrame parent;
    
    public ActionButtons(final JFrame parent) {
        this.parent = parent;  
        jButtonEdit = new JButton();
        jButtonCopy = new JButton();
        jButtonMove = new JButton();
        jButtonDelete = new JButton();
        jButtonSearch = new JButton();
        jButtonCreate = new JButton();

        jButtonEdit.setText("Edit");
        this.add(jButtonEdit);
        jButtonSearch.setText("Search");
        this.add(jButtonSearch);
        jButtonCreate.setText("Create Folder");
        this.add(jButtonCreate);
        
        jButtonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) { jButtonSearchActionPerformed(evt);}
        });
        

        jButtonCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 jButtonCreateActionPerformed(e);
            }
        });
        

        jButtonCopy.setText("Copy");
        jButtonCopy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) { jButtonCopyActionPerformed(evt); }        
        });
        
        this.add(jButtonCopy);
        jButtonMove.setText("Move");
        this.add(jButtonMove);
        jButtonDelete.setText("Delete");
        this.add(jButtonDelete);
        
        jButtonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) { jButtonDeleteActionPerformed(evt); }
        });
    }
    
    /**
    * Method to activate the copy action
    * @param evt 
    */
    private void jButtonCopyActionPerformed(ActionEvent evt) {
         //TODO
    }
    
    /**
     * Method to activate the delete action
     * @param evt 
     */
    private void jButtonDeleteActionPerformed(ActionEvent evt) {
        DeleteConfirmation del = new DeleteConfirmation(parent, true);
        del.setVisible(true);
    }   
    
    /**
     * Method to activate the search action
     * @param evt 
     */
    private void jButtonSearchActionPerformed(ActionEvent evt) {
        SearchDialog srch = new SearchDialog(parent, true);
        srch.setVisible(true);
    }
    

    /**
     * Method  to  activate  create  folder  action
     * @param evt 
     */

    private void jButtonCreateActionPerformed(ActionEvent evt) {
    if(BodyPanel.selectedPath!=null)
    {
        CreateDialog createDialog = new CreateDialog(parent, true);
        createDialog.setVisible(true);
    }
    }
}
