/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Utilities.BasicOperation;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

/**
 *
 * @author Shirley Pinto
 */
public class DeleteConfirmation extends JDialog {

    private JButton cancelButton;
    private JLabel jLabelDeleteText;
    private JLabel jLabelPath;
    private JButton okButton;
    private GroupLayout layout;
    private int returnStatus = RET_CANCEL;
    
    public static final int RET_CANCEL = 0;
    public static final int RET_OK = 1;

    /**
     * Creates new form DeleteConfirmation
     */
    public DeleteConfirmation (Frame parent, boolean modal, String path) {
        super(parent, modal);
        this.initComponents(path);

        // Close the dialog when Esc is pressed
        String cancelName = "Cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                closeDialog(RET_CANCEL);
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
    private void initComponents(String path) {

        okButton = new JButton();
        cancelButton = new JButton();
        jLabelDeleteText = new JLabel();
        jLabelPath = new JLabel();
        jLabelPath.setText(path);
        

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) { closeDialog(RET_CANCEL); }});

        okButton.setText("Delete");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) { okButtonActionPerformed(evt); }});

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) { cancelButtonActionPerformed(evt); }});

        jLabelDeleteText.setText("Do you really want to delete the selected Item" + new File(path).getName() +"?");

        layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        this.setHorizontalGroup();
        this.setVerticalGroup();
        layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {cancelButton, okButton});
        
        getRootPane().setDefaultButton(okButton);
        pack();
    }

    /**
     * Method to activate the close action after clicking ok button
     * @param evt 
     */
    private void okButtonActionPerformed(ActionEvent evt) {
        BasicOperation.deleteItem(new File(jLabelPath.getText()));
        closeDialog(RET_OK);
    }

    /**
     * Method to activate the close action after clicking cancel button
     * @param evt 
     */
    private void cancelButtonActionPerformed(ActionEvent evt) {
        closeDialog(RET_CANCEL);
    }

    /**
     * Method to close the dialog box
     * @param retStatus 
     */
    private void closeDialog(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    /**
     * Method to set horizontal group values
     */
    private void setHorizontalGroup() {
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDeleteText, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 103, Short.MAX_VALUE)
                .addComponent(okButton, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(cancelButton)
                .addGap(125, 125, 125))
        );
    }

    /**
     * Method to set vertical group values
     */
    private void setVerticalGroup() {
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelDeleteText, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );
    }
}
