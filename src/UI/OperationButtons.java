/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
/**
 *
 * @author vania huayta
 */
public class OperationButtons extends JPanel {
    private JButton jButtonBack;
    private JButton jButtonForward;
    private JButton jButtonSelection;
    
    private JFrameJC parent;
    
    public OperationButtons(JFrameJC parent) {
        this.parent = parent;  
        ImageIcon back = new ImageIcon("C:\\repository JC_svd\\jcommander-svd\\resources\\icons\\back.png");
        ImageIcon forward = new ImageIcon("C:\\repository JC_svd\\jcommander-svd\\resources\\icons\\forward.png");
        ImageIcon select = new ImageIcon("C:\\repository JC_svd\\jcommander-svd\\resources\\icons\\select.png");
        
        jButtonBack = new JButton();
        jButtonBack.setIcon(back);
        jButtonForward = new JButton();
        jButtonForward.setIcon(forward);
        jButtonSelection = new JButton();
        jButtonSelection.setIcon(select);
        jButtonSelection.setToolTipText("Select/Unselect");
        
        this.add(jButtonBack);
        this.add(jButtonForward);
        this.add(jButtonSelection);
        
        jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) { 
                jButtonBackActionPerformed(evt);
            }
        });
        

        jButtonForward.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 jButtonForwardActionPerformed(e);
            }
        });
         
        jButtonSelection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) { 
                jButtonSelectionActionPerformed(evt); 
            }        
        });
        
        this.add(jButtonBack);
        this.add(jButtonForward);
        this.add(jButtonSelection);
    }
    
    private void jButtonBackActionPerformed(ActionEvent evt) {
        parent.getjPanelBody().jButtonBackActionPerformed(evt);
    }
    
    private void jButtonForwardActionPerformed(ActionEvent evt) {
        parent.getjPanelBody().jButtonForwardActionPerformed(evt);
    }
    
    private void jButtonSelectionActionPerformed(ActionEvent evt) {
        parent.getjPanelBody().jButtonSelectionActionPerformed(evt);
    }
}
