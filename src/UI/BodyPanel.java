/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 * Class where the the panel items are defined
 * @author Shirley Pinto
 */
public class BodyPanel extends JPanel {

    private javax.swing.JComboBox checkBoxSelectDrive;
    private javax.swing.JTextField filePath;
    private javax.swing.JButton jButtonGo;
    private javax.swing.JPanel jPanelPath;
    private javax.swing.JScrollPane jScrollPaneLeft;
    private javax.swing.JScrollPane jScrollPaneRigth;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JTable tableLeft;
    private javax.swing.JTable tableRigth;
    private boolean onLeft = true;

    public BodyPanel() {
        
        jPanelPath = new javax.swing.JPanel();
        checkBoxSelectDrive = new javax.swing.JComboBox();
        filePath = new javax.swing.JTextField();
        jButtonGo = new javax.swing.JButton();
        jSplitPane = new javax.swing.JSplitPane();
        jScrollPaneLeft = new javax.swing.JScrollPane();
        tableLeft = new javax.swing.JTable();
        jScrollPaneRigth = new javax.swing.JScrollPane();
        tableRigth = new javax.swing.JTable();

        
        this.setLayout(new java.awt.BorderLayout());

        jPanelPath.setLayout(new java.awt.BorderLayout());

        checkBoxSelectDrive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxSelectDriveActionPerformed(evt);
            }
        });
        jPanelPath.add(checkBoxSelectDrive, java.awt.BorderLayout.LINE_START);

        filePath.setEditable(false);
        
        jPanelPath.add(filePath, java.awt.BorderLayout.CENTER);

        jButtonGo.setText("Go");
        jButtonGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoActionPerformed(evt);
            }
        });
        jPanelPath.add(jButtonGo, java.awt.BorderLayout.LINE_END);

        this.add(jPanelPath, java.awt.BorderLayout.PAGE_START);

        jScrollPaneLeft.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPaneLeftMouseClicked(evt);
            }
        });

        tableLeft.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Type", "Size", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableLeft.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tableLeftFocusGained(evt);
            }
        });
        jScrollPaneLeft.setViewportView(tableLeft);

        jSplitPane.setLeftComponent(jScrollPaneLeft);

        jScrollPaneRigth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPaneRigthMouseClicked(evt);
            }
        });

        tableRigth.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Type", "Size", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRigth.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tableRigthFocusGained(evt);
            }
        });
        jScrollPaneRigth.setViewportView(tableRigth);

        jSplitPane.setRightComponent(jScrollPaneRigth);

        this.add(jSplitPane, java.awt.BorderLayout.CENTER);
    }
    
    /**
     * Method to add the roots to panel
     * @param evt 
     */
    public void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        File[] drives = File.listRoots();
        for (int index = 0; index < drives.length; index++) {
            checkBoxSelectDrive.addItem(drives[index].getPath());
        }
    }                                 

    /**
     * Method to set the file path 
     * @param evt 
     */
    private void checkBoxSelectDriveActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        filePath.setText(checkBoxSelectDrive.getSelectedItem().toString());
    }                                                   

    /**
     * Method to list the file when the user selects Go button
     * @param evt 
     */
    private void jButtonGoActionPerformed(java.awt.event.ActionEvent evt) {                                          
        listFiles(filePath.getText());
    }    
    
    /**
     * Method to list all files of a given path 
     * @param pathFile where the items will be retrieved
     */
    public void listFiles(String pathFile) {
        Path path = Paths.get(pathFile);
        File f = path.toFile();
        File[] files = f.listFiles();
        
        DefaultTableModel model = null;
        
        if (onLeft) {
            model = (DefaultTableModel) tableLeft.getModel();
        } else {
            model = (DefaultTableModel) tableRigth.getModel();
        }
        
        model.getDataVector().removeAllElements();
        
        for (int index = 0; index < files.length; index++) {
            Date d = new Date(files[index].lastModified());
            String[] row= {files[index].getName(), files[index].isFile() ? "FILE" : "DIR", String.valueOf(files[index].length()/1024), d.toGMTString()};
                    
            model.addRow(row);            
        }        
    }
    
    /**
     * Method to set if the right panel is selected
     * @param evt 
     */
    private void tableRigthFocusGained(java.awt.event.FocusEvent evt) {                                       
        onLeft = false;
    }                                      

    /**
     * Method to set if the left panel is selected
     * @param evt 
     */
    private void tableLeftFocusGained(java.awt.event.FocusEvent evt) {                                      
        onLeft = true;
    }                                     

    /**
     * Method to scroll the left pane
     * @param evt 
     */
    private void jScrollPaneLeftMouseClicked(java.awt.event.MouseEvent evt) {                                             
        onLeft = true;
    }                                            

    /**
     * Method to scroll the right pane 
     * @param evt 
     */
    private void jScrollPaneRigthMouseClicked(java.awt.event.MouseEvent evt) {                                              
       onLeft = false;
    }                            
}
