package catalogue.GUI;

import catalogue.endpoint.DirectorItem;
import catalogue.endpoint.GenreItem;
import catalogue.endpoint.ReleaseItem;
import catalogue.logic.CatalogueLogic;
import java.awt.Color;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * Új film hozzáadását támogató felület.
 * @author Balazs
 */
public class NewFilmFrame extends javax.swing.JFrame {

    /**
     * Rendező kezelő felület objektum
     */
    DirectorFrame directorFrame;
    /**
     * Kiadási típus karbantartó felület
     */
    ReleaseMaintananceFrame releaseFrame;
    /**
     * Műfaj karbantartó felület
     */
    GenreMaintananceFrame genreFrame;
    
    /**
     * Konstruktor
     * @param cLogic    alkalmazás logika
     */
    public NewFilmFrame( CatalogueLogic cLogic ) {
        this.logic = cLogic;
        initComponents();
        
        //Figyelmeztető üzenet ha még nincs műfaj, rendező vagy kiadási típus felvéve a katalógusba
        StringBuilder warning=new StringBuilder("<html>Mielőtt filmet venne fel a katalógusba, a következőket teljesítenie kell:<br>");
        if(  logic.getDirectorsCount() == 0 ) {
            warning.append("    - rendező felvétele a katalógusba<br>");
        }
        if( logic.getReleasesCount() == 0 ) {
            warning.append("    - kiadás felvétele katalógusba<br>");
        }
        if( logic.getGenresCount() ==0 ) {
            warning.append("    - műfaj felvétele katalógusba");
        }
        warning.append("</html>");
        if( warning.toString().contains("-")) {
            JOptionPane.showMessageDialog(rootPane, warning.toString(), "Figyelmeztetés", JOptionPane.WARNING_MESSAGE);
            this.dispose();
        } else {
            customizeComponents();
            
            setResizable(false);
            setLocationRelativeTo(this);
            setVisible(true);
        }
    }

    /**
     * Felület komponenseinek inicializálását végzi.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContainer = new javax.swing.JPanel();
        jButtonAddNewFilm = new javax.swing.JButton();
        jLabelNewFilm = new javax.swing.JLabel();
        jSeparatorMenu = new javax.swing.JSeparator();
        jLabelTitle = new javax.swing.JLabel();
        jLabelYear = new javax.swing.JLabel();
        jLabelDirector = new javax.swing.JLabel();
        jLabelExtra = new javax.swing.JLabel();
        jLabelType = new javax.swing.JLabel();
        jTextFieldTitle = new javax.swing.JTextField();
        jComboBoxYear = new javax.swing.JComboBox();
        jComboBoxRelease = new javax.swing.JComboBox();
        jComboBoxType = new javax.swing.JComboBox();
        jButtonCancel = new javax.swing.JButton();
        jLabelTitleEng = new javax.swing.JLabel();
        jTextFieldTitleOrig = new javax.swing.JTextField();
        jLabelIMDBLink = new javax.swing.JLabel();
        jLabelGenre = new javax.swing.JLabel();
        jTextFieldIMDBLink = new javax.swing.JTextField();
        jScrollPaneGenre = new javax.swing.JScrollPane();
        jListGenres = new javax.swing.JList();
        jLabelRefresh = new javax.swing.JLabel();
        jLabelAddDirector = new javax.swing.JLabel();
        jLabelAddRelease = new javax.swing.JLabel();
        jLabelAddGenre = new javax.swing.JLabel();
        jLabelInformation = new javax.swing.JLabel();
        jLabelAmount = new javax.swing.JLabel();
        jSpinnerAmount = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListDirectors = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Film hozzáadása");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanelContainer.setBackground(new java.awt.Color(255, 255, 255));

        jButtonAddNewFilm.setText("Kész");
        jButtonAddNewFilm.setActionCommand("jButton");
        jButtonAddNewFilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddNewFilmActionPerformed(evt);
            }
        });

        jLabelNewFilm.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNewFilm.setText("Film hozzáadása");

        jLabelTitle.setText("Cím: *");

        jLabelYear.setText("Kiadás éve: *");

        jLabelDirector.setText("Rendező: *");

        jLabelExtra.setText("Kiadás: *");

        jLabelType.setText("Típus: *");

        jButtonCancel.setText("Vissza");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jLabelTitleEng.setText("Eredeti cím: *");

        jLabelIMDBLink.setText("IMDB azonosító:");
        jLabelIMDBLink.setToolTipText("A film IMDb URL-jében a title után lévő karaktersorozat");

        jLabelGenre.setText("Műfaj: *");

        jScrollPaneGenre.setViewportView(jListGenres);

        jLabelRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update.png"))); // NOI18N
        jLabelRefresh.setToolTipText("Adatok frissítése");
        jLabelRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRefreshMouseClicked(evt);
            }
        });

        jLabelAddDirector.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddDirector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addDirector.png"))); // NOI18N
        jLabelAddDirector.setToolTipText("Rendező kezelő");
        jLabelAddDirector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddDirectorMouseClicked(evt);
            }
        });

        jLabelAddRelease.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddRelease.setIcon(new javax.swing.ImageIcon(getClass().getResource("/release.png"))); // NOI18N
        jLabelAddRelease.setToolTipText("Kiadási típus hozzáadása");
        jLabelAddRelease.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddReleaseMouseClicked(evt);
            }
        });

        jLabelAddGenre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddGenre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/genre.png"))); // NOI18N
        jLabelAddGenre.setToolTipText("Műfaj hozzáadása");
        jLabelAddGenre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddGenreMouseClicked(evt);
            }
        });

        jLabelInformation.setText("*  mező kitöltése kötelező");

        jLabelAmount.setText("Darabszám: *");
        jLabelAmount.setToolTipText("Hány példányban található meg Önnél a film?");

        jScrollPane1.setViewportView(jListDirectors);

        javax.swing.GroupLayout jPanelContainerLayout = new javax.swing.GroupLayout(jPanelContainer);
        jPanelContainer.setLayout(jPanelContainerLayout);
        jPanelContainerLayout.setHorizontalGroup(
            jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContainerLayout.createSequentialGroup()
                .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContainerLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelContainerLayout.createSequentialGroup()
                                .addComponent(jLabelNewFilm, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelRefresh))
                            .addComponent(jSeparatorMenu, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelContainerLayout.createSequentialGroup()
                                .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContainerLayout.createSequentialGroup()
                                            .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jLabelDirector, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabelYear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabelTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addComponent(jLabelTitleEng, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabelAmount))
                                            .addGap(14, 14, 14))
                                        .addComponent(jLabelGenre))
                                    .addGroup(jPanelContainerLayout.createSequentialGroup()
                                        .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelType, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelIMDBLink, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldTitle)
                                    .addComponent(jTextFieldTitleOrig)
                                    .addGroup(jPanelContainerLayout.createSequentialGroup()
                                        .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSpinnerAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanelContainerLayout.createSequentialGroup()
                                                .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jComboBoxRelease, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jTextFieldIMDBLink, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelContainerLayout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                                    .addComponent(jComboBoxYear, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jComboBoxType, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jScrollPaneGenre, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                                                .addGap(12, 12, 12)
                                                .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabelAddDirector)
                                                    .addComponent(jLabelAddRelease)
                                                    .addComponent(jLabelAddGenre))))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContainerLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAddNewFilm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancel)))
                .addGap(17, 17, 17))
            .addGroup(jPanelContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInformation)
                .addGap(239, 271, Short.MAX_VALUE))
        );
        jPanelContainerLayout.setVerticalGroup(
            jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNewFilm, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparatorMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitle)
                    .addComponent(jTextFieldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitleEng)
                    .addComponent(jTextFieldTitleOrig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelYear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDirector)
                    .addComponent(jLabelAddDirector)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIMDBLink)
                    .addComponent(jTextFieldIMDBLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelExtra)
                    .addComponent(jLabelAddRelease)
                    .addComponent(jComboBoxRelease, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelGenre)
                    .addComponent(jScrollPaneGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddGenre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAmount)
                    .addComponent(jSpinnerAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddNewFilm)
                    .addComponent(jButtonCancel))
                .addGap(3, 3, 3)
                .addComponent(jLabelInformation)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddNewFilmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddNewFilmActionPerformed
        
        String titleHU = jTextFieldTitle.getText().trim();
        String titleOrig = jTextFieldTitleOrig.getText().trim();
        
        if( titleOrig.equals("") || titleHU.equals("") || jListDirectors.isSelectionEmpty() || jListGenres.isSelectionEmpty() || jComboBoxRelease.getModel().getSize()==0 ) {
            JOptionPane.showMessageDialog(rootPane, "A csillagozott mezők kitöltése kötelező.", "Kitöltetlen mezők", JOptionPane.WARNING_MESSAGE);
        } else {
            List<String> genreslist = jListGenres.getSelectedValuesList();
            List<String> directorsList = jListDirectors.getSelectedValuesList();
        
            logic.insertMovie(titleHU,
                                titleOrig,
                                    (Integer)jComboBoxYear.getSelectedItem(),
                                        directorsList,
                                        (String)jComboBoxRelease.getSelectedItem(),
                                            (String)jComboBoxType.getSelectedItem(),
                                                (String)jTextFieldIMDBLink.getText(),
                                                    genreslist,
                                                    (Integer)jSpinnerAmount.getModel().getValue());
            this.dispose();
        }
        
    }//GEN-LAST:event_jButtonAddNewFilmActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jLabelRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRefreshMouseClicked
        updateComponents();
    }//GEN-LAST:event_jLabelRefreshMouseClicked

    private void jLabelAddDirectorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddDirectorMouseClicked
        if( directorFrame == null || !directorFrame.isShowing()) {
            directorFrame = new DirectorFrame(logic);
        } else if( directorFrame.isShowing() ){
            //ha már megvan nyitva és kattintanak az ikonra akkor a megnyitott kerül a fókuszba
            directorFrame.requestFocus();
        }
        
    }//GEN-LAST:event_jLabelAddDirectorMouseClicked

    private void jLabelAddReleaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddReleaseMouseClicked
        if( releaseFrame == null || !releaseFrame.isShowing()) {
            releaseFrame = new ReleaseMaintananceFrame(logic);
        } else if( releaseFrame.isShowing() ){
            //ha már megvan nyitva és kattintanak az ikonra akkor a megnyitott kerül a fókuszba
            releaseFrame.requestFocus();
        }
    }//GEN-LAST:event_jLabelAddReleaseMouseClicked

    private void jLabelAddGenreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddGenreMouseClicked
        if( genreFrame == null || !genreFrame.isShowing()) {
            genreFrame = new GenreMaintananceFrame(logic);
        } else if( genreFrame.isShowing() ){
            //ha már megvan nyitva és kattintanak az ikonra akkor a megnyitott kerül a fókuszba
            genreFrame.requestFocus();
        }
    }//GEN-LAST:event_jLabelAddGenreMouseClicked
   
    
    private CatalogueLogic logic;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddNewFilm;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JComboBox jComboBoxRelease;
    private javax.swing.JComboBox jComboBoxType;
    private javax.swing.JComboBox jComboBoxYear;
    private javax.swing.JLabel jLabelAddDirector;
    private javax.swing.JLabel jLabelAddGenre;
    private javax.swing.JLabel jLabelAddRelease;
    private javax.swing.JLabel jLabelAmount;
    private javax.swing.JLabel jLabelDirector;
    private javax.swing.JLabel jLabelExtra;
    private javax.swing.JLabel jLabelGenre;
    private javax.swing.JLabel jLabelIMDBLink;
    private javax.swing.JLabel jLabelInformation;
    private javax.swing.JLabel jLabelNewFilm;
    private javax.swing.JLabel jLabelRefresh;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelTitleEng;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JLabel jLabelYear;
    private javax.swing.JList jListDirectors;
    private javax.swing.JList jListGenres;
    private javax.swing.JPanel jPanelContainer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneGenre;
    private javax.swing.JSeparator jSeparatorMenu;
    private javax.swing.JSpinner jSpinnerAmount;
    private javax.swing.JTextField jTextFieldIMDBLink;
    private javax.swing.JTextField jTextFieldTitle;
    private javax.swing.JTextField jTextFieldTitleOrig;
    // End of variables declaration//GEN-END:variables

    /**
     * A felület futásidőben változó komponenseinek frissítését végzi. 
     */
    public void updateComponents() {
        
        //RENDEZŐK LISTÁJÁNAK FELTÖLTÉSE
        jListDirectors.setModel(new DefaultListModel());
        List<DirectorItem> directors = logic.getDirectorsList();
        DefaultListModel lm = (DefaultListModel)jListDirectors.getModel();
        for( DirectorItem director : directors) {
            lm.addElement(director.getFirstname()+" "+director.getLastname());
        }
        jListDirectors.setSelectedIndex(0);
        
        
        //MŰFAJOK LISTÁJÁNAK FELTÖLTÉSE
        jListGenres.setModel(new DefaultListModel());
        List<GenreItem> genres = logic.getGenresList();
        lm = (DefaultListModel)jListGenres.getModel();
        for( GenreItem genre : genres) {
            lm.addElement(genre.getName());
        }
        jListGenres.setSelectedIndex(0);
        
        //KIADÁSI TÍPUSOK LISTÁJÁNAK FELTÖLTÉSE
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        jComboBoxRelease.getEditor().getEditorComponent().setBackground(Color.WHITE);
        List<ReleaseItem> releases = logic.getReleasesList();
        for( ReleaseItem extra  : releases ) {
            dcm.addElement( extra.getName() );
        }
        jComboBoxRelease.setModel( dcm );
    }
    
    /**
     * Felület komponenseinek testreszabása.
     */
    public void customizeComponents() {
        updateComponents();
        
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        jComboBoxYear.setModel( dcm );
        for( int i=1900; i<= Calendar.getInstance().get( Calendar.YEAR ); i++ ) {
            dcm.addElement( i );
        }

        //Típus comboBox feltöltés
        dcm = new DefaultComboBoxModel();
        jComboBoxType.setModel( dcm );
        jComboBoxType.getEditor().getEditorComponent().setBackground(Color.WHITE);
        dcm.addElement( "DVD" );
        dcm.addElement( "Blueray" );

        //Mennyiség jspinner beállítása 
        jSpinnerAmount.setModel(new SpinnerNumberModel(1, 1, 500, 1));
        jSpinnerAmount.setEditor(new JSpinner.DefaultEditor(jSpinnerAmount));   //ezáltal letiltom, hogy a jspinner beviteli mezőjébe írni lehessen
    }

    
}