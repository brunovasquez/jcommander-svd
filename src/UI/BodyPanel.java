package UI;

import static UI.MoveDialog.RET_CANCEL;
import Utilities.DetectOS;
import java.awt.BorderLayout;
import java.io.File;
import java.nio.file.*;
import java.util.Date;
import javax.swing.*;
import java.awt.Component;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

/**
 * Class where the the panel items are defined
 * @author Shirley Pinto
 */
public class BodyPanel extends JPanel {

    private JComboBox checkBoxSelectDriveL;
    private JTextField fieldPathL;
    private JButton jButtonGoL;
    
    private JComboBox checkBoxSelectDriveR;
    private JTextField fieldPathR;
    private JButton jButtonGoR;
    
    private JPanel jPanelLeft;
    private JPanel jPanelRight;
    
    private JPanel jPanelPathsBar;
    private JScrollPane jScrollLeftPane;
    private JScrollPane jScrollRightPane;
    private JSplitPane jSplitPane;
    private JTable leftTable;
    private JTable rightTable;
    private boolean onLeft;
    static String selectedPath;
    private JFrameJC parent;
    private String separatorFiles;

 
    public BodyPanel(JFrameJC parent) {
        this.parent = parent;
        separatorFiles = DetectOS.isWindows() ? "\\" : "//";
        jPanelLeft = new JPanel();
        jPanelRight = new JPanel();
        jPanelPathsBar = new JPanel();
        
        checkBoxSelectDriveL = new JComboBox();
        fieldPathL = new JTextField();
        jButtonGoL = new JButton();
        
        checkBoxSelectDriveR = new JComboBox();
        fieldPathR = new JTextField();
        jButtonGoR = new JButton();
        
        jSplitPane = new JSplitPane();
        jScrollLeftPane = new JScrollPane();
        leftTable = new JTable();
        jScrollRightPane = new JScrollPane();
        rightTable = new JTable();
        onLeft = true;
        this.setLayout(new BorderLayout());
        initPathsPanel();
        this.add(jPanelPathsBar, BorderLayout.PAGE_START);
        setModelsData();
        this.add(jSplitPane, BorderLayout.CENTER);
        
        leftTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                selectedPath = (getSelectedItemPath());
            }
            }); 
        rightTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                selectedPath = (getSelectedItemPath());
            }
        }); 
    }
    
    /**
     * Method to add the roots to panel
     * @param evt 
     */
    public void formWindowOpened(WindowEvent evt) {                                  
        File[] drives = File.listRoots();
        for (int index = 0; index < drives.length; index++) {
            checkBoxSelectDriveL.addItem(drives[index].getPath());
            checkBoxSelectDriveR.addItem(drives[index].getPath());
        }
    }                                 

    /**
     * Method to set the file path for left panel
     * @param evt 
     */
    private void checkBoxSelectDriveLeftActionPerformed(ActionEvent evt) {                                                    
        fieldPathL.setText(checkBoxSelectDriveL.getSelectedItem().toString());
    }
    
    /**
     * Method to set the file path for right panel
     * @param evt 
     */
    private void checkBoxSelectDriveRightActionPerformed(ActionEvent evt) {                                                    
        fieldPathR.setText(checkBoxSelectDriveR.getSelectedItem().toString());
    }

    /**
     * Method to list the file when the user selects Go left button
     * @param evt 
     */
    private void jButtonGoLeftActionPerformed(ActionEvent evt) {                                          
        listFiles(fieldPathL.getText(), true);
    }
    
    /**
     * Method to list the file when the user selects Go left button
     * @param evt 
     */
    private void jButtonGoRightActionPerformed(ActionEvent evt) {                                          
        listFiles(fieldPathR.getText(), false);
    }
    
    /**
     * Method to define the Copy action
     * @param evt 
     */
    public void jButtonCopyActionPerformed(ActionEvent evt) {  
        if (onLeft) {
            CopyDialog copyDilog = new CopyDialog(this.parent, true, 
                    new File(this.selectedPath),
                    new File(fieldPathR.getText() + separatorFiles  + new File(selectedPath).getName()));
            copyDilog.setVisible(true);
            listFiles(fieldPathR.getText(), false);
        } else {
            CopyDialog copyDilog = new CopyDialog(this.parent, true, 
                    new File(this.selectedPath), 
                    new File(fieldPathL.getText() + separatorFiles + new File(selectedPath).getName()));
            copyDilog.setVisible(true);
            listFiles(fieldPathL.getText(), true);
        }
    }
    
    /**
     * Method to define the move action
     * @param evt 
     */
    public void jButtonMoveActionPerformed(ActionEvent evt) {                                          
        MoveDialog movedialog;
        if (onLeft) {
            movedialog = new MoveDialog(this.parent, true, 
                    new File(this.selectedPath),
                    new File(fieldPathR.getText() + separatorFiles + new File(selectedPath).getName()));
        } else {
            movedialog = new MoveDialog(this.parent, true, 
                    new File(this.selectedPath), 
                    new File(fieldPathL.getText() + separatorFiles + new File(selectedPath).getName()));
        }
        movedialog.setVisible(true);
        listFiles(fieldPathR.getText(), false);
        listFiles(fieldPathL.getText(), true);
        movedialog.doClose(RET_CANCEL);
    }
    
    /**
     * Method to define the delete action
     * @param evt 
     */
    public void jButtonDeleteActionPerformed(ActionEvent evt) {
        DeleteConfirmation del = new DeleteConfirmation(parent, true, selectedPath);
        del.setVisible(true);
        listFiles(fieldPathR.getText(), false);
        listFiles(fieldPathL.getText(), true);
    } 
    
    /**
     * Method to define edit action
     * @param evt 
     */
    public void jButtonEditActionPerformed(ActionEvent evt) {
          EditDialog editDialog;
        if (onLeft) {
            editDialog = new EditDialog(parent, true, 
                    this.selectedPath);
            editDialog.setVisible(true);
            listFiles(fieldPathR.getText(), false);
            
        } else {
            editDialog = new EditDialog(parent, true, 
                    this.selectedPath);
            editDialog.setVisible(true);           
            listFiles(fieldPathL.getText(), true);
        }     
        editDialog.doClose(RET_CANCEL);
    } 
    
    /**
     * Method to list all files of a given path 
     * @param pathFile where the items will be retrieved
     * @param panel to be filled
     */
    public void listFiles(String pathFile, boolean panel) {
        Path path = Paths.get(pathFile);
        File file = path.toFile();
        File[] files = file.listFiles();
       
        this.selectedPath = pathFile;
        DefaultTableModel model = null;
        model = panel ? (DefaultTableModel)leftTable.getModel() : (DefaultTableModel)rightTable.getModel();
        model.getDataVector().removeAllElements();
        
        for (int index = 0; index < files.length; index++) {
            Date date = new Date(files[index].lastModified());
            String[] row = { files[index].getName(), files[index].isFile() ? 
                    "FILE" : "DIR", String.valueOf(files[index].length()/1024), 
                    date.toGMTString(), files[index].getPath() };
            model.addRow(row);            
        }        
    }
    
    /**
     * Method to set if the right panel is selected
     * @param evt 
     */
    private void tableRigthFocusGained(FocusEvent evt) { 
        onLeft = false;
    }                                      

    /**
     * Method to set if the left panel is selected
     * @param evt 
     */
    private void tableLeftFocusGained(FocusEvent evt) {  
        onLeft = true;
    }                                     

    /**
     * Method to scroll the left pane
     * @param evt 
     */
    private void jScrollPaneLeftMouseClicked(MouseEvent evt) {                                             
        onLeft = true;
    }    
    
    /**
     * Method to initialize the paths in the bar
     */
    private void initPathsPanel() {
        jPanelPathsBar.setLayout(new BorderLayout());
        jPanelPathsBar.add(this.initLeftPanel(), BorderLayout.WEST);
        jPanelPathsBar.add(this.initRightPanel(), BorderLayout.EAST);
    }

    /**
     * Method to set the data in both panels
     */
    private void setModelsData() {
        jSplitPane.setLeftComponent(this.initScrollLeftPane());
        jSplitPane.setRightComponent(this.initScrollRightPane());
    }      

    /**
     * Method to initialize the leftPanel components
     * @return 
     */
    private Component initLeftPanel() {
        jPanelLeft.setLayout(new BorderLayout());

        checkBoxSelectDriveL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                checkBoxSelectDriveLeftActionPerformed(evt);
            }
        });
        jPanelLeft.add(checkBoxSelectDriveL, BorderLayout.LINE_START);

        fieldPathL.setEditable(true);
        fieldPathL.setColumns(32);
        
        jPanelLeft.add(fieldPathL, BorderLayout.CENTER);

        jButtonGoL.setText("Go");
        jButtonGoL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonGoLeftActionPerformed(evt);
            }
        });
        jPanelLeft.add(jButtonGoL, BorderLayout.LINE_END);
        
        return jPanelLeft;
    }

    /**
     * Method to define the rightPanel components
     * @return 
     */
    private Component initRightPanel() {
        jPanelRight.setLayout(new BorderLayout());

        checkBoxSelectDriveR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                checkBoxSelectDriveRightActionPerformed(evt);
            }
        });
        jPanelRight.add(checkBoxSelectDriveR, BorderLayout.LINE_START);

        fieldPathR.setEditable(true);
        fieldPathR.setColumns(32);
        
        jPanelRight.add(fieldPathR, BorderLayout.CENTER);

        jButtonGoR.setText("Go");
        jButtonGoR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonGoRightActionPerformed(evt);
            }
        });
        jPanelRight.add(jButtonGoR, BorderLayout.LINE_END);    
        return jPanelRight;
    }

    /**
     * Method to initialize the left table
     * @return 
     */
    private Component initLeftTable() {
        leftTable.setModel(new DefaultTableModel(
            new Object [][] { },
            new String [] { "Name", "Type", "Size", "Date", "Path" }) {
            Class[] types = new Class [] { String.class, String.class, String.class, String.class, String.class };
            boolean[] canEdit = new boolean [] { false, false, false, false, false };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        leftTable.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                tableLeftFocusGained(evt);
            }
        });   
        return leftTable;
    }

    /**
     * Method to initialize the right table
     * @return 
     */
    private Component initRightTable() {
        rightTable.setModel(new DefaultTableModel(
            new Object [][] { },
            new String [] { "Name", "Type", "Size", "Date","Path" }) {
            Class[] types = new Class [] { String.class, String.class, String.class, String.class, String.class };
            boolean[] canEdit = new boolean [] { false, false, false, false, false };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rightTable.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                tableRigthFocusGained(evt);
            }
        });
        return rightTable;
    }

    /**
     * Method to initialize the scroll right pane
     * @return 
     */
    private Component initScrollRightPane() {
        jScrollRightPane.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jScrollPaneRigthMouseClicked(evt);
            }
        });
        jScrollRightPane.setViewportView(this.initRightTable());    
        return jScrollRightPane;
    }

    /**
     * Method to initialize the scroll left pane
     * @return 
     */
    private Component initScrollLeftPane() {
        jScrollLeftPane.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jScrollPaneLeftMouseClicked(evt);
            }
        });

        jScrollLeftPane.setViewportView(this.initLeftTable());
        return jScrollLeftPane;
    }

    /**
     * Method to scroll the right pane 
     * @param evt 
     */
    private void jScrollPaneRigthMouseClicked(MouseEvent evt) {                                              
       onLeft = false;
    }
    
    /**
     * Method to get selected Item path
     * @return 
     */
    private String getSelectedItemPath() {
        String selected;
        if (onLeft) {
            int i = this.leftTable.getSelectedRow();
            selected = (String) this.leftTable.getValueAt(i, 4);
        } else {
            int i = this.rightTable.getSelectedRow();
            selected = (String) this.rightTable.getValueAt(i, 4);
        }
        return selected;
    }
}
