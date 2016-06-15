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
    public static BodyPanel jPanelBody;
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
        jPanelBody = new BodyPanel(this);
        jMenuBar = new MenuBar();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent evt) {
                getjPanelBody().formWindowOpened(evt);
            }
        });
        
        getContentPane().add(getjPanelButtons(), BorderLayout.PAGE_END);
        getContentPane().add(getjPanelBody(), BorderLayout.CENTER);
        setJMenuBar(getjMenuBar());

        pack();
    }

    /**
     * @return the jMenuBar
     */
    public MenuBar getjMenuBar() {
        return jMenuBar;
    }

    /**
     * @return the jPanelBody
     */
    public BodyPanel getjPanelBody() {
        return jPanelBody;
    }

    /**
     * @return the jPanelButtons
     */
    public ActionButtons getjPanelButtons() {
        return jPanelButtons;
    }
}
