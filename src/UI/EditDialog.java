/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Utilities.BasicOperation;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Shirley Pinto
 */
public class EditDialog extends JDialog {

    public static final int RET_CANCEL = 0;
    public static final int RET_OK = 1;
    public JFrameJC parent;
    private File actualFile;
    private JButton cancelButton;
    private JTextField fieldNewName;
    private JLabel labelEditing;
    private JLabel labelFileToEdit;
    private JLabel labelNewName;
    private JButton okButton;
    private int returnStatus = RET_CANCEL;
    
    /**
     * Creates new form EditDialog
     */
    public EditDialog(JFrameJC parent, boolean modal, String actName ) {
        super(parent, modal);
        this.parent = parent;
        initComponents(actName);

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
    private void initComponents(String actName) {

        okButton = new JButton();
        cancelButton = new JButton();
        labelEditing = new JLabel();
        labelFileToEdit = new JLabel();
        fieldNewName = new JTextField();
        labelNewName = new JLabel();

        setSize(new Dimension(400, 100));
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                closeDialog(evt);
            }
        });
        getContentPane().setLayout(new AbsoluteLayout());

        okButton.setText("Edit");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        getContentPane().add(okButton, new AbsoluteConstraints(250, 66, 67, -1));
        getRootPane().setDefaultButton(okButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton, new AbsoluteConstraints(323, 66, 67, -1));

        labelEditing.setText("Editing file:");
        getContentPane().add(labelEditing, new AbsoluteConstraints(10, 11, -1, -1));

        actualFile = new File(actName);
        labelFileToEdit.setText(actualFile.getName());
        getContentPane().add(labelFileToEdit, new AbsoluteConstraints(74, 11, -1, -1));
        getContentPane().add(fieldNewName, new AbsoluteConstraints(74, 36, 316, -1));

        labelNewName.setText("New name:");
        getContentPane().add(labelNewName, new AbsoluteConstraints(10, 39, -1, -1));

        pack();
    }

    private void okButtonActionPerformed(ActionEvent evt) {
        String path = actualFile.getParent();
        BasicOperation.renameItem(actualFile, new File(path+fieldNewName.getText()));
        
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
    
    public void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }
}
