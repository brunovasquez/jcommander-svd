/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author Shirley Pinto
 */
public class JFrameJC extends javax.swing.JFrame {
    // Variables declaration - do not modify                     
    private MenuBar jMenuBar;
    private BodyPanel jPanelBody;
    private ActionButtons jPanelButtons;
    // End of variables declaration                   

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

        jPanelButtons = new ActionButtons();
        jPanelBody = new BodyPanel();
        jMenuBar = new MenuBar();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                jPanelBody.formWindowOpened(evt);
            }
        });
        
        getContentPane().add(jPanelButtons, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(jPanelBody, java.awt.BorderLayout.CENTER);

        setJMenuBar(jMenuBar);

        pack();
    }

    
}
