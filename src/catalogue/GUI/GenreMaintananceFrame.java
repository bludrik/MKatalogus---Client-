package catalogue.GUI;

import catalogue.endpoint.GenreItem;
import catalogue.logic.CatalogueLogic;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Műfajokat karbantartó felület.
 * @author Balazs
 */
public class GenreMaintananceFrame extends javax.swing.JFrame {

    /**
     * A program logikáját reprezentáló objektum.
     */
    private CatalogueLogic logic;
    /**
     * Műfajokat tartalmazó lista.
     */
    private List<GenreItem> genres;
    
    /**
     * Konstruktor
     * @param logic     alkalmazás logika
     */
    public GenreMaintananceFrame(CatalogueLogic logic) {
        initComponents();
        
        this.logic = logic;
        
        setResizable(false);
        setLocationRelativeTo(this);
        setVisible(true);
    }

    /**
     * Felület komponenseinek inicializálása.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelAddGenre = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldGenreName = new javax.swing.JTextField();
        jButtonSaveGenre = new javax.swing.JButton();
        jPanelModify = new javax.swing.JPanel();
        jLabelModification = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabelOrigName = new javax.swing.JLabel();
        jComboBoxGenres = new javax.swing.JComboBox();
        jLabelNewName = new javax.swing.JLabel();
        jTextFieldModifiedName = new javax.swing.JTextField();
        jButtonModify = new javax.swing.JButton();
        jPanelDelete = new javax.swing.JPanel();
        jLabelDelete = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelGenreToDelete = new javax.swing.JLabel();
        jComboBoxGenreToDelete = new javax.swing.JComboBox();
        jButtonDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Műfaj karbantartó");

        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });

        jPanelAddGenre.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Új műfaj hozzáadása");

        jLabel2.setText("Műfaj megnevezése: *");

        jTextFieldGenreName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldGenreNameKeyPressed(evt);
            }
        });

        jButtonSaveGenre.setText("Mentés");
        jButtonSaveGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveGenreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAddGenreLayout = new javax.swing.GroupLayout(jPanelAddGenre);
        jPanelAddGenre.setLayout(jPanelAddGenreLayout);
        jPanelAddGenreLayout.setHorizontalGroup(
            jPanelAddGenreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddGenreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAddGenreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAddGenreLayout.createSequentialGroup()
                        .addGroup(jPanelAddGenreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(29, Short.MAX_VALUE))
                    .addGroup(jPanelAddGenreLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldGenreName, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSaveGenre)
                        .addGap(33, 33, 33))))
        );
        jPanelAddGenreLayout.setVerticalGroup(
            jPanelAddGenreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddGenreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAddGenreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldGenreName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSaveGenre))
                .addContainerGap(165, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hozzáadás", jPanelAddGenre);

        jPanelModify.setBackground(new java.awt.Color(255, 255, 255));

        jLabelModification.setText("Kiadási típus módosítása");

        jLabelOrigName.setText("Műfaj megnevezése: *");

        jComboBoxGenres.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelNewName.setText("Módosított név: *");

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
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelModifyLayout.createSequentialGroup()
                        .addGroup(jPanelModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelOrigName, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNewName, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxGenres, 0, 131, Short.MAX_VALUE)
                            .addComponent(jTextFieldModifiedName)))
                    .addComponent(jButtonModify))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanelModifyLayout.setVerticalGroup(
            jPanelModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModifyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelModification)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOrigName)
                    .addComponent(jComboBoxGenres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNewName)
                    .addComponent(jTextFieldModifiedName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonModify)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Módosítás", jPanelModify);

        jPanelDelete.setBackground(new java.awt.Color(255, 255, 255));

        jLabelDelete.setText("Műfaj törlése");

        jLabelGenreToDelete.setText("Műfaj megnevezése:");

        jComboBoxGenreToDelete.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonDelete.setBackground(new java.awt.Color(255, 255, 255));
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
                    .addComponent(jLabelDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanelDeleteLayout.createSequentialGroup()
                            .addComponent(jLabelGenreToDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jComboBoxGenreToDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonDelete))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanelDeleteLayout.setVerticalGroup(
            jPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeleteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGenreToDelete)
                    .addComponent(jComboBoxGenreToDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDelete))
                .addContainerGap(160, Short.MAX_VALUE))
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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Módosítás");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveGenreActionPerformed
        String name = jTextFieldGenreName.getText();
        if( name.equals("") ) {
            JOptionPane.showMessageDialog(rootPane, "Adja meg a hozzáadni kívánt műfaj nevét!", "Nincs név!", JOptionPane.WARNING_MESSAGE);
        } else {
            logic.insertGenre(name);
        }
        
    }//GEN-LAST:event_jButtonSaveGenreActionPerformed

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained
        jComboBoxGenreToDelete.removeAllItems();    //műfajlista ürítése
        jComboBoxGenres.removeAllItems();
        genres = logic.getGenresList();
        
        try {
            for(int i = 0; i<genres.size(); i++){
                jComboBoxGenres.addItem(genres.get(i).getName());
                jComboBoxGenreToDelete.addItem(genres.get(i).getName());
            }
        } catch( Exception ex) {
            
        }
        
    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        Object selected = jComboBoxGenreToDelete.getSelectedItem();
        if ( selected!=null && logic.deleteGenre((String)selected) == 1 ) {
            jComboBoxGenreToDelete.removeItemAt(jComboBoxGenreToDelete.getSelectedIndex());
        } else if(selected == null) {
            JOptionPane.showMessageDialog(rootPane, "Sikertelen törlési kísérlet.", "Törlés", JOptionPane.ERROR_MESSAGE);
        }
        jTabbedPane1FocusGained(null);
        //this.dispose();
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifyActionPerformed
        Object selected = jComboBoxGenres.getSelectedItem();
        if( selected!=null ) {
            //MÓDOSÍTÁS
            String name = jTextFieldModifiedName.getText().trim();
            if(name.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Adja meg a módosított megnevezést!","Módosítás", JOptionPane.WARNING_MESSAGE);
            } else {
                logic.updateGenre( (String)selected, name );
                jTabbedPane1FocusGained(null);
                this.dispose();
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Nincs kiadás a listában. Módosítás nem engedélyezett", "Nincs kiadási típus", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonModifyActionPerformed

    private void jTextFieldGenreNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldGenreNameKeyPressed
        
    }//GEN-LAST:event_jTextFieldGenreNameKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonModify;
    private javax.swing.JButton jButtonSaveGenre;
    private javax.swing.JComboBox jComboBoxGenreToDelete;
    private javax.swing.JComboBox jComboBoxGenres;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelDelete;
    private javax.swing.JLabel jLabelGenreToDelete;
    private javax.swing.JLabel jLabelModification;
    private javax.swing.JLabel jLabelNewName;
    private javax.swing.JLabel jLabelOrigName;
    private javax.swing.JPanel jPanelAddGenre;
    private javax.swing.JPanel jPanelDelete;
    private javax.swing.JPanel jPanelModify;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldGenreName;
    private javax.swing.JTextField jTextFieldModifiedName;
    // End of variables declaration//GEN-END:variables
}
