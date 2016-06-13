/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;


import Utilities.SearchItem;
import java.awt.*;
import java.io.File;
import javax.swing.*;
import java.util.*;

/**
 * @version 1.0
 * @since 06/12/2016
 * @author vania huayta
 */
public class SearchPanel extends JFrame{
    
    private JPanel optionsPane, listPane, pathPane;
    private JTextField fieldName, fieldPath;
    private JLabel nameLabel, pathLabel;
    private JButton jButtonSearch, jButtonClean;
    private JList matchesList;
    private DefaultListModel listModel;
    
    
    public SearchPanel() {
        this.setTitle("Search for files");
        this.setLayout(new BorderLayout()); 
        
        pathPane = new JPanel();
        pathPane.setSize(500, 30);
        pathPane.setLayout(new BorderLayout());
        pathLabel = new JLabel("Path:");
        fieldPath = new JTextField("C:\\");
        
        optionsPane = new JPanel();
        optionsPane.setSize(500, 50);
        optionsPane.setLayout(new BorderLayout());  
        
        nameLabel = new JLabel("File Name:");
        fieldName = new JTextField();
        jButtonSearch = new JButton("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchAction(evt);
            }
        });
        
        pathPane.add(pathLabel, BorderLayout.WEST);
        pathPane.add(fieldPath, BorderLayout.CENTER);
        
        optionsPane.add(nameLabel,BorderLayout.WEST);
        optionsPane.add(fieldName, BorderLayout.CENTER );
        optionsPane.add(jButtonSearch, BorderLayout.EAST);
        optionsPane.add(pathPane, BorderLayout.PAGE_END);
        
        listPane = new JPanel();
        listPane.setSize(500, 280);
        listPane.setLayout(new BorderLayout());
        
        listModel = new DefaultListModel();
        listModel.addElement("(Coincidences list...)");       
        matchesList = new JList(listModel);
        jButtonClean = new JButton("Clean");
        jButtonClean.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCleanAction(evt);
            }
        });
        
        listPane.add(matchesList, BorderLayout.NORTH);
        listPane.add(jButtonClean, BorderLayout.PAGE_END);
        
        this.add(optionsPane, BorderLayout.NORTH);
        this.add(listPane, BorderLayout.CENTER);
        this.setBounds(100, 100, 500, 300);
        this.setVisible(true);
        this.show(true);
        
    }
    
    private void jButtonSearchAction(java.awt.event.ActionEvent evt) {
        File path = new File(fieldPath.getText());
        listModel = new DefaultListModel();
        if ((fieldPath.getText().isEmpty()) || (fieldName.getText().isEmpty())) {
            listModel.addElement("File Name or Path are empty! Fill the fields requeried");
            matchesList.setModel(listModel);
        } else {     
            if(path.exists()) {
                java.util.List<String> items = new ArrayList<>();
                java.util.List<String> coincidences = SearchItem.searchUsingWilcards(fieldName.getText(), path, items);
                if(!coincidences.isEmpty()) {
                    for (String coincidence : coincidences) {
                        listModel.addElement(coincidence);
                    }
                }else {
                    listModel.addElement("There are no files with similar name");
                }
                matchesList.setModel(listModel);
            } else {
                listModel.addElement("The path where to search doesn't exist");
                matchesList.setModel(listModel);
            }
        }
    }
    
    private void jButtonCleanAction(java.awt.event.ActionEvent evt) {
        fieldName.setText("");
        fieldPath.setText("C:\\");
        listModel = new DefaultListModel();
        listModel.addElement("(Coincidences list...)");       
        matchesList.setModel(listModel);
    }
    
}
