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
public class JCreatePanel extends JFrame{
    
    private JPanel optionsPane, listPane, pathPane;
    private JTextField fieldName, fieldPath;
    private JLabel nameLabel, pathLabel;
    private JButton jButtonCreate;
   
    
    
    public JCreatePanel() {
        this.setTitle("CreateFile");
        this.setLayout(new BorderLayout()); 
        
        pathPane = new JPanel();
        pathPane.setSize(500, 30);
        pathPane.setLayout(new BorderLayout());
        pathLabel = new JLabel("Path:");
        fieldPath = new JTextField("F:\\");
        
        optionsPane = new JPanel();
        optionsPane.setSize(500, 50);
        optionsPane.setLayout(new BorderLayout());  
        
        nameLabel = new JLabel("File Name:");
        fieldName = new JTextField();
        jButtonCreate = new JButton("Create");
        jButtonCreate.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent event) {
                jButtonCreateFile(event);
            }
        });
        
        
    }
    
    private void jButtonCreateFile(java.awt.event.ActionEvent evt) {
        File path = new File(fieldPath.getText());
        
    }
    
   
    
}