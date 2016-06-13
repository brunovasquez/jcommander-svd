/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;
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
        jTextSearchIn = new JTextField();
        jLabelResults = new JLabel();
        jScrollPane = new JScrollPane();
        

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        jLabelSearchFor.setText("Search for: ");
        jButtonStartSearch.setText("Start Search");
        jButtonCancel.setText("Cancel");
        jLabelSearchIn.setText("Search in:");
        jLabelResults.setText("Results:");

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
                    .addComponent(jScrollPane))
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
                .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }
}
