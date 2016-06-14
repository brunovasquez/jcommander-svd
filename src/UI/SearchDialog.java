/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;
import Utilities.SearchItem;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Shirley Pinto
 */
public class SearchDialog extends JDialog {
   
    private JButton jButtonStartSearch;
    private JButton jButtonCancel;
    private JLabel jLabelSearchIn;
    private JLabel jLabelSearchFor;
    private JLabel jLabelResults;
    private JScrollPane jScrollPane;
    private JTextField jTextSearchFor;
    private JTextField jTextSearchIn;
    private GroupLayout layout;
    private JList resultList;
    private DefaultListModel listModel;

    /**
     * Creates new form Search
     * @param parent
     * @param modal
     */
    public SearchDialog(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabelSearchFor = new JLabel();
        jTextSearchFor = new JTextField();
        jButtonStartSearch = new JButton();
        jButtonCancel = new JButton();
        jLabelSearchIn = new JLabel();
        jTextSearchIn = new JTextField(BodyPanel.selectedPath);
        jLabelResults = new JLabel();
        jScrollPane = new JScrollPane();
        resultList = new JList();
        

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        jLabelSearchFor.setText("Search for: ");
        jButtonStartSearch.setText("Start Search");
        jButtonStartSearch.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchAction(evt);
            }
        });
        
        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelAction(evt);
            }
        });
        
        jLabelSearchIn.setText("Search in:");
        jLabelResults.setText("Results:");
        
        listModel = new DefaultListModel();
        listModel.addElement("(List of results...)");
        resultList.setModel(listModel);
        jScrollPane.getViewport().setView(resultList);
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
                        .addComponent(jLabelSearchFor)
                        .addGap(4, 4, 4)
                        .addComponent(jTextSearchFor, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButtonStartSearch, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelSearchIn, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jTextSearchIn, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButtonCancel, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelResults)
                    .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jLabelSearchFor, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jTextSearchFor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jButtonStartSearch)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabelSearchIn))
                    .addComponent(jTextSearchIn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancel))
                .addGap(18, 18, 18)
                .addComponent(jLabelResults)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
                
        );
    }
    
    /**
     * Method that response to Search button click, this is where the search method
     * from basic operation is called.
     * @param evt Event received from the JButton.
     */
    private void jButtonSearchAction(java.awt.event.ActionEvent evt) {
        File path = new File(jTextSearchIn.getText());
        listModel = new DefaultListModel();
        if ((jTextSearchFor.getText().isEmpty()) || (jTextSearchIn.getText().isEmpty())) {
            JOptionPane.showMessageDialog(this, "File Name or Path are empty! Fill the fields requeried");
            
        } else {     
            if(path.exists()) {
                java.util.List<String> items = new ArrayList<>();
                java.util.List<String> coincidences = SearchItem.searchUsingWilcards(jTextSearchFor.getText(), path, items);
                if(!coincidences.isEmpty()) {
                    for (String coincidence : coincidences) {
                        listModel.addElement(coincidence);
                    }
                }else {
                    JOptionPane.showMessageDialog(this, "There are no files with similar name.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                resultList.setModel(listModel);
            } else {
                JOptionPane.showMessageDialog(this, "The path where to search doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /**
     * Method to clean up all the fields and list in the Panel
     * @param evt Event received from the JButton.
     */
    private void jButtonCancelAction(java.awt.event.ActionEvent evt) {
        jTextSearchFor.setText("");
        jTextSearchIn.setText("C:\\");
        listModel = new DefaultListModel();
        listModel.addElement("(List of results...)");       
        resultList.setModel(listModel);
        
    }
}
