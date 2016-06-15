/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Utilities.BasicOperation;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.*;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Shirley Pinto
 */
public class MoveDialog extends JDialog {
    
    public static final int RET_CANCEL = 0;
    public static final int RET_OK = 1;
    private JButton cancelButton;
    private JTextField fieldMoveFrom;
    private JTextField fieldMoveTo;
    private JLabel labelMoveFrom;
    private JLabel labelMoveTo;
    private JButton okButton;
    private int returnStatus = RET_CANCEL;
    
    /**
     * Creates new form MoveDialog
     */
    public MoveDialog(Frame parent, boolean modal, File from, File to) {
        super(parent, modal);
        initComponents();
        
        this.fieldMoveFrom.setText(from.getPath());
        this.fieldMoveTo.setText(to.getPath());
                
        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        okButton = new JButton();
        cancelButton = new JButton();
        labelMoveFrom = new JLabel();
        fieldMoveFrom = new JTextField();
        fieldMoveTo = new JTextField();
        labelMoveTo = new JLabel();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                closeDialog(evt);
            }
        });
        getContentPane().setLayout(new AbsoluteLayout());

        this.initOkButton();
        this.initCancelButton();
        
        labelMoveFrom.setText("Move:");
        getContentPane().add(labelMoveFrom, new AbsoluteConstraints(10, 14, -1, -1));
        getContentPane().add(fieldMoveFrom, new AbsoluteConstraints(49, 11, 341, -1));
        getContentPane().add(fieldMoveTo, new AbsoluteConstraints(49, 42, 341, -1));

        labelMoveTo.setText("To:");
        getContentPane().add(labelMoveTo, new AbsoluteConstraints(10, 45, 29, -1));
        pack();
    }

    /**
     * Method to move the item after clicking ok button
     * @param evt 
     */
    private void okButtonActionPerformed(ActionEvent evt) {  
        BasicOperation.moveItem(new File(this.fieldMoveFrom.getText()), new File(fieldMoveTo.getText()));
        doClose(RET_OK);
    }

    /**
     * Method to close the dialog after clicking cancel button
     * @param evt 
     */
    private void cancelButtonActionPerformed(ActionEvent evt) {
        doClose(RET_CANCEL);
    }

    /**
     * Closes the dialog
     */
    private void closeDialog(WindowEvent evt) {
        doClose(RET_CANCEL);
    }
    
    /**
     * Method to close the dialog
     * @param retStatus 
     */
    public void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    /**
     * Method to initialize ok button's events
     */
    private void initOkButton() {
        okButton.setText("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        getContentPane().add(okButton, new AbsoluteConstraints(101, 79, 85, -1));
        getRootPane().setDefaultButton(okButton);
    }

    /**
     * Method to initialize cancel button's events
     */
    private void initCancelButton() {
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton, new AbsoluteConstraints(215, 79, 85, -1));
    }
}
