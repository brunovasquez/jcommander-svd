/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Class where the main JFrame's components are called and defined
 * @author Shirley Pinto
 */
public class JFrameJC extends JFrame {
    private MenuBar jMenuBar;
    private BodyPanel jPanelBody;
    private ActionButtons jPanelButtons;

    /**
     * Creates new form UI
     */
    public JFrameJC() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
     private void initComponents() {

        jPanelButtons = new ActionButtons(this);
        jPanelBody = new BodyPanel();
        jMenuBar = new MenuBar();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent evt) {
                jPanelBody.formWindowOpened(evt);
            }
        });
        
        getContentPane().add(jPanelButtons, BorderLayout.PAGE_END);
        getContentPane().add(jPanelBody, BorderLayout.CENTER);
        setJMenuBar(jMenuBar);

        pack();
    }
}
