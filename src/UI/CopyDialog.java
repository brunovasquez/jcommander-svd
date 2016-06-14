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
public class CopyDialog extends JDialog {
    
    public static final int RET_CANCEL = 0;
    public static final int RET_OK = 1;
    private JButton cancelButton;
    private JTextField fieldCopyFrom;
    private JTextField fieldCopyTo;
    private JLabel labelCopy;
    private JLabel labelTo;
    private JButton okButton;
    private int returnStatus = RET_CANCEL;
    
    /**
     * Creates new form CopyDialog
     */
    public CopyDialog(Frame parent, boolean modal, File from, File to) {
        super(parent, modal);
        initComponents();
        
        this.fieldCopyFrom.setText(from.getPath());
        this.fieldCopyTo.setText(to.getPath());
                
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
        labelCopy = new JLabel();
        fieldCopyFrom = new JTextField();
        fieldCopyTo = new JTextField();
        labelTo = new JLabel();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                closeDialog(evt);
            }
        });
        getContentPane().setLayout(new AbsoluteLayout());

        okButton.setText("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        getContentPane().add(okButton, new AbsoluteConstraints(101, 79, 85, -1));
        getRootPane().setDefaultButton(okButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton, new AbsoluteConstraints(215, 79, 85, -1));

        labelCopy.setText("Copy:");
        getContentPane().add(labelCopy, new AbsoluteConstraints(10, 14, -1, -1));
        getContentPane().add(fieldCopyFrom, new AbsoluteConstraints(49, 11, 341, -1));
        getContentPane().add(fieldCopyTo, new AbsoluteConstraints(49, 42, 341, -1));

        labelTo.setText("To:");
        getContentPane().add(labelTo, new AbsoluteConstraints(10, 45, 29, -1));

        pack();
    }

    private void okButtonActionPerformed(ActionEvent evt) {
        
        BasicOperation.copyItem(new File(this.fieldCopyFrom.getText()), new File(fieldCopyTo.getText()));
        doClose(RET_OK);
    }

    private void cancelButtonActionPerformed(ActionEvent evt) {
        doClose(RET_CANCEL);
    }

    /**
     * Closes the dialog
     */
    private void closeDialog(WindowEvent evt) {
        doClose(RET_CANCEL);
    }
    
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }
}
