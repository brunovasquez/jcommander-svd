/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;
import java.util.ArrayList;
import javax.swing.*;
import src.Attribute;
import src.AttributeHandler;
import src.FolderItem;
import java.awt.event.*;

/**
 *
 * @author Daniel Gumucio
 */
public class CreateDialog extends JDialog {
    
    private JButton jButtonCreate;
    private JButton jButtonCancel;
    private JLabel jLabelName;
    private JLabel jLabelLocation;
    private JTextField jTextName;
    private JTextField jTextLocation;
    private GroupLayout layout;
    private JScrollPane jScrollPane;
    
    
    /**
     * Creates new form Create
     * @param parent
     * @param modal
     */
    public CreateDialog(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        jButtonCreate = new  JButton();
        jButtonCancel = new JButton();
        jLabelName = new  JLabel();
        jLabelLocation = new JLabel();
        jTextName = new  JTextField();
        jTextLocation = new JTextField();
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        jLabelName.setText("Name :");
        jButtonCreate.setText("Create");
        jButtonCreate.addActionListener(new ActionListener(){
        
        @Override
             public void actionPerformed(ActionEvent evt) {
                 jButtonCreateAction(evt);
             }
        
        });
        
        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
             @Override
             public void actionPerformed(ActionEvent evt) {
                 jButtonCancelAction(evt);
             }
         });
        jLabelLocation.setText("Location :");
        jTextLocation.setText(BodyPanel.selectedPath);
        jTextLocation.setEnabled(false);
        
        layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        this.setHorizontalGroup();
        this.setVerticalGroup();

        pack();
        
    }
    
   /**
     * Method to set horizontal group's components
     */
    private void setHorizontalGroup () {
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelName)
                        .addGap(4, 4, 4)
                        .addComponent(jTextName, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
                        )
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelLocation, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jTextLocation, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
                        )
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCreate)
                        .addGap(4, 4, 4)
                        .addComponent(jButtonCancel)
                        )
                    )
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
    
    /**
     * Method to set vertical group's component
     */
    private void setVerticalGroup() {
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jTextName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    )
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabelLocation))
                    .addComponent(jTextLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    )
                
                .addGap(6,6,6)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jButtonCreate))
                        .addGap(3, 3, 3)
                        .addComponent(jButtonCancel)
                    )
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }
    
    private void jButtonCancelAction(ActionEvent evt) 
    {
       setModal(false);
       this.dispose();
    }
    
    private void jButtonCreateAction(ActionEvent evt)
    {
        Attribute attributeReadOnly = new Attribute("ReadOnly", "Disabled");
        Attribute attributeHidden = new Attribute("Hidden", "Disabled");
        ArrayList<Attribute> attributeList = new ArrayList<>();
        attributeList.add(attributeReadOnly);
        attributeList.add(attributeHidden);
        
        AttributeHandler attributeHandler = new AttributeHandler(attributeList);
        FolderItem folderItem = new FolderItem(jTextName.getText(),jTextLocation.getText(),0,attributeHandler);
        JOptionPane.showMessageDialog(this, "Folder was  created sucessfully", "Information", JOptionPane.INFORMATION_MESSAGE);
        setModal(false);
       this.dispose();
    }
            
}