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
public class ActionButtons extends JPanel{
    private JButton jButtonCopy;
    private JButton jButtonDelete;
    private JButton jButtonEdit;
    private JButton jButtonMove;
    
    
    public ActionButtons(){
        jButtonEdit = new JButton();
        jButtonCopy = new JButton();
        jButtonMove = new JButton();
        jButtonDelete = new JButton();
        
        jButtonEdit.setText("Edit");
        this.add(jButtonEdit);

        jButtonCopy.setText("Copy");
        jButtonCopy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonCopyActionPerformed(evt);
            }

           
        });
        this.add(jButtonCopy);

        jButtonMove.setText("Move");
        this.add(jButtonMove);

        jButtonDelete.setText("Delete");
        this.add(jButtonDelete);

  
    }
    
    private void jButtonCopyActionPerformed(ActionEvent evt) {
         
    }
    
}
