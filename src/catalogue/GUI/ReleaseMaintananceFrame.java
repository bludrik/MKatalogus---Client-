package catalogue.GUI;

import catalogue.endpoint.ReleaseItem;
import catalogue.logic.CatalogueLogic;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 * Kiadási típus kezelő felület. Itt nyílik lehetőség a katalógusban tárolt kiadási típusok karbantartására.
 * @author Ludrik Balazs
 */
public class ReleaseMaintananceFrame extends javax.swing.JFrame {

    /**
     * A program logikáját reprezentáló objektum.
     */
    private CatalogueLogic logic;
    /**
     * Kiadási típusokat tartalmazó lista.
     */
    List<ReleaseItem> releases;
   
    
    /**
     * Konstruktor
     * @param logic     alkalmazás logika
     */
    public ReleaseMaintananceFrame( CatalogueLogic logic) {
        initComponents();   //Form inicializáló műveletei
        
        this.logic = logic;
        
        setResizable(false);
        setLocationRelativeTo(this);
        setVisible(true);
    }
    

    /**
     * A felületen lévő komponensek inicializálását végzi.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelAdd = new javax.swing.JPanel();
        jLabelAddRelease = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelNewReleaseName = new javax.swing.JLabel();
        jTextFieldReleaseName = new javax.swing.JTextField();
        jButtonSave = new javax.swing.JButton();
        jPanelModify = new javax.swing.JPanel();
        jLabelModification = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelorigName = new javax.swing.JLabel();
        jComboBoxReleases = new javax.swing.JComboBox();
        jLabelNewName = new javax.swing.JLabel();
        jTextFieldModifiedName = new javax.swing.JTextField();
        jButtonModify = new javax.swing.JButton();
        jPanelDelete = new javax.swing.JPanel();
        jLabelDelete = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabelorigNameToDelete = new javax.swing.JLabel();
        jComboBoxReleasesToDelete = new javax.swing.JComboBox();
        jButtonDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kiadási típus karbantartó");

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });

        jPanelAdd.setBackground(new java.awt.Color(255, 255, 255));

        jLabelAddRelease.setText("Új kiadási típus hozzáadása");

        jLabelNewReleaseName.setText("Típus megnevezése: *");

        jButtonSave.setText("Mentés");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAddLayout = new javax.swing.GroupLayout(jPanelAdd);
        jPanelAdd.setLayout(jPanelAddLayout);
        jPanelAddLayout.setHorizontalGroup(
            jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAddRelease, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelAddLayout.createSequentialGroup()
                        .addComponent(jLabelNewReleaseName, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldReleaseName, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSave)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanelAddLayout.setVerticalGroup(
            jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAddRelease)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNewReleaseName)
                    .addComponent(jTextFieldReleaseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSave))
                .addContainerGap(202, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hozzáadás", jPanelAdd);

        jPanelModify.setBackground(new java.awt.Color(255, 255, 255));

        jLabelModification.setText("Kiadási típus módosítása");

        jLabelorigName.setText("Típus megnevezése: *");

        jComboBoxReleases.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelNewName.setText("Módosított típus: *");

        jButtonModify.setText("Mentés");
        jButtonModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelModifyLayout = new javax.swing.GroupLayout(jPanelModify);
        jPanelModify.setLayout(jPanelModifyLayout);
        jPanelModifyLayout.setHorizontalGroup(
            jPanelModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModifyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelModification, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelModifyLayout.createSequentialGroup()
                        .addGroup(jPanelModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelorigName, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNewName, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxReleases, 0, 131, Short.MAX_VALUE)
                            .addComponent(jTextFieldModifiedName)))
                    .addComponent(jButtonModify))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanelModifyLayout.setVerticalGroup(
            jPanelModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModifyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelModification)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelorigName)
                    .addComponent(jComboBoxReleases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNewName)
                    .addComponent(jTextFieldModifiedName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonModify)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Módosítás", jPanelModify);

        jPanelDelete.setBackground(new java.awt.Color(255, 255, 255));

        jLabelDelete.setText("Kiadási típus törlése");

        jLabelorigNameToDelete.setText("Típus megnevezése:");

        jComboBoxReleasesToDelete.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonDelete.setText("Törlés");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDeleteLayout = new javax.swing.GroupLayout(jPanelDelete);
        jPanelDelete.setLayout(jPanelDeleteLayout);
        jPanelDeleteLayout.setHorizontalGroup(
            jPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeleteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDeleteLayout.createSequentialGroup()
                            .addComponent(jLabelorigNameToDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBoxReleasesToDelete, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonDelete))
                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanelDeleteLayout.setVerticalGroup(
            jPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeleteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelorigNameToDelete)
                    .addComponent(jComboBoxReleasesToDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDelete))
                .addContainerGap(202, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Törlés", jPanelDelete);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifyActionPerformed
        Object selected = jComboBoxReleases.getSelectedItem();
        if( selected!=null ) {
            //MÓDOSÍTÁS
            String name = jTextFieldModifiedName.getText().trim();
            if(name.equals("")) { 
                JOptionPane.showMessageDialog(rootPane, "Adja meg a módosított megnevezést!","Módosítás", JOptionPane.WARNING_MESSAGE);      
            } else {
                logic.updateRelease( (String)selected, name );
                jTabbedPane1FocusGained(null);
                this.dispose();
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Nincs kiadás a listában. Módosítás nem engedélyezett", "Nincs kiadási típus", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonModifyActionPerformed

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained
       
        //
        // COMBOBOX FELTÖLTÉSE
        //
        releases = logic.getReleasesList();
        DefaultComboBoxModel dcm = (DefaultComboBoxModel)jComboBoxReleases.getModel();
        dcm.removeAllElements();
        for( ReleaseItem r : releases) {
            dcm.addElement(r.getName());
        }
        
        dcm = (DefaultComboBoxModel)jComboBoxReleasesToDelete.getModel();
        dcm.removeAllElements();
        for( ReleaseItem r : releases) {
            dcm.addElement(r.getName());
        }
    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        String name = jTextFieldReleaseName.getText().trim();
        if( name.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Adjon meg egy nevet!");
        } else {
            logic.insertRelease( name );
            //this.dispose();
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        Object selected = jComboBoxReleasesToDelete.getSelectedItem();
        if (selected != null) {
            logic.deleteRelease((String)selected);
            jTabbedPane1FocusGained(null);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nincs kiadás a listában. Törlés nem engedélyezett", "Nincs kiadási típus", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonModify;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox jComboBoxReleases;
    private javax.swing.JComboBox jComboBoxReleasesToDelete;
    private javax.swing.JLabel jLabelAddRelease;
    private javax.swing.JLabel jLabelDelete;
    private javax.swing.JLabel jLabelModification;
    private javax.swing.JLabel jLabelNewName;
    private javax.swing.JLabel jLabelNewReleaseName;
    private javax.swing.JLabel jLabelorigName;
    private javax.swing.JLabel jLabelorigNameToDelete;
    private javax.swing.JPanel jPanelAdd;
    private javax.swing.JPanel jPanelDelete;
    private javax.swing.JPanel jPanelModify;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldModifiedName;
    private javax.swing.JTextField jTextFieldReleaseName;
    // End of variables declaration//GEN-END:variables
}
