/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Class where the action's buttons are defined
 * @author Shirley Pinto
 */
public class ActionButtons extends JPanel {
    private JButton jButtonCopy;
    private JButton jButtonDelete;
    private JButton jButtonEdit;
    private JButton jButtonMove;
    private JButton jButtonSearch;
    private JButton jButtonCreate;
    private JFrameJC parent;
    
    public ActionButtons(JFrameJC parent) {
        this.parent = parent;  
        jButtonEdit = new JButton();
        jButtonCopy = new JButton();
        jButtonMove = new JButton();
        jButtonDelete = new JButton();
        jButtonSearch = new JButton();
        jButtonCreate = new JButton();

        jButtonEdit.setText("Edit");
        jButtonEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) { jButtonEditActionPerformed(evt);}
        });
        this.add(jButtonEdit);
        jButtonSearch.setText("Search");
        this.add(jButtonSearch);
        jButtonCreate.setText("Create Folder");
        this.add(jButtonCreate);
        
        this.initSearchButton();
        this.initCreateButton();
        this.initCopyButton();
        this.initMoveButton();
        this.initDeleteButton();     
    }
    
    /**
    * Method to activate the copy action
    * @param evt 
    */
    private void jButtonCopyActionPerformed(ActionEvent evt) {
         parent.getjPanelBody().jButtonCopyActionPerformed(evt);
    }
    
    /**
    * Method to activate the move action
    * @param evt 
    */
    private void jButtonMoveActionPerformed(ActionEvent evt) {
         parent.getjPanelBody().jButtonMoveActionPerformed(evt);
    }
    
    /**
    * Method to activate the edit action
    * @param evt 
    */
    private void jButtonEditActionPerformed(ActionEvent evt) {
         parent.getjPanelBody().jButtonEditActionPerformed(evt);
    }
    
    /**
     * Method to activate the delete action
     * @param evt 
     */
    private void jButtonDeleteActionPerformed(ActionEvent evt) {
         parent.getjPanelBody().jButtonDeleteActionPerformed(evt);
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
        if(BodyPanel.selectedPath!=null) {
            CreateDialog createDialog = new CreateDialog(parent, true);
            createDialog.setVisible(true);
        }
    }

    /**
     * Method to initialize Search action button
     */
    private void initSearchButton() {
         jButtonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) { jButtonSearchActionPerformed(evt);}
        });
    }

    /**
     * Method to initialize Create action button
     */
    private void initCreateButton() {
        jButtonCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 jButtonCreateActionPerformed(e);
            }
        });
    }

    /**
     * Method to initialize Copy action button
     */
    private void initCopyButton() {
        jButtonCopy.setText("Copy");
        jButtonCopy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) { jButtonCopyActionPerformed(evt); }        
        });
        this.add(jButtonCopy);
    }

    /**
     * Method to initialize Delete action button
     */
    private void initDeleteButton() {
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) { jButtonDeleteActionPerformed(evt); }
        });
        this.add(jButtonDelete);        
    }

    /**
     * Method to initialize Move action button
     */
    private void initMoveButton() {
        jButtonMove.setText("Move");
        jButtonMove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) { jButtonMoveActionPerformed(evt); }        
        });
        this.add(jButtonMove);
    }
}
