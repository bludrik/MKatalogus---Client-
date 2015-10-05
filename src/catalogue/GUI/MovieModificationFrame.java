package catalogue.GUI;

import catalogue.endpoint.DirectorItem;
import catalogue.endpoint.GenreItem;
import catalogue.endpoint.MovieItem;
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
 * Film adatainak módosítására szolgáló felület.
 * @author Balazs
 */
public class MovieModificationFrame extends javax.swing.JFrame {

    /**
     * Konstruktor
     */
    public MovieModificationFrame( CatalogueLogic cLogic, MovieItem movie ) {
        
        this.logic = cLogic;
        this.movie = movie;
        
        initComponents();
        customizeComponents();
        
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

        jPanel1 = new javax.swing.JPanel();
        jButtonModify = new javax.swing.JButton();
        jLabelNewFilm = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
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
        jLabelTitleOrig = new javax.swing.JLabel();
        jTextFieldTitleOrig = new javax.swing.JTextField();
        jLabelIMDBLink = new javax.swing.JLabel();
        jLabelGenre = new javax.swing.JLabel();
        jTextFieldIMDBLink = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListGenres = new javax.swing.JList();
        jLabelUpdate = new javax.swing.JLabel();
        jLabelAmount = new javax.swing.JLabel();
        jSpinnerAmount = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListDirectors = new javax.swing.JList();
        jLabelAddDirector = new javax.swing.JLabel();
        jLabelAddRelease = new javax.swing.JLabel();
        jLabelAddGenre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Film módosítása");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButtonModify.setText("Módosít");
        jButtonModify.setActionCommand("jButton");
        jButtonModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifyActionPerformed(evt);
            }
        });

        jLabelNewFilm.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNewFilm.setText("Szerkesztő felület");

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

        jLabelTitleOrig.setText("Eredeti cím: *");

        jLabelIMDBLink.setText("IMDB azonosító:");
        jLabelIMDBLink.setToolTipText("A film IMDb URL-jében a title után lévő karaktersorozat");

        jLabelGenre.setText("Műfaj: *");

        jScrollPane1.setViewportView(jListGenres);

        jLabelUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update.png"))); // NOI18N
        jLabelUpdate.setToolTipText("Adatok frisítése");
        jLabelUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelUpdateMouseClicked(evt);
            }
        });

        jLabelAmount.setText("Darabszám: *");
        jLabelAmount.setToolTipText("Hány példányban található meg Önnél a film?");

        jScrollPane2.setViewportView(jListDirectors);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelAmount)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonModify)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCancel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelNewFilm, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelUpdate))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jLabelDirector, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabelYear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabelTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addComponent(jLabelTitleOrig, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(14, 14, 14))
                                        .addComponent(jLabelGenre))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelType, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelIMDBLink, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldTitle)
                                    .addComponent(jTextFieldTitleOrig)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSpinnerAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldIMDBLink)
                                            .addComponent(jComboBoxRelease, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboBoxType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(jComboBoxYear, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelAddDirector)
                                            .addComponent(jLabelAddRelease)
                                            .addComponent(jLabelAddGenre))
                                        .addGap(0, 4, Short.MAX_VALUE)))))
                        .addGap(26, 26, 26))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNewFilm, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitle)
                    .addComponent(jTextFieldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitleOrig)
                    .addComponent(jTextFieldTitleOrig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelYear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDirector)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddDirector))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldIMDBLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIMDBLink))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxRelease, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelExtra)
                    .addComponent(jLabelAddRelease))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGenre)
                    .addComponent(jLabelAddGenre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAmount)
                    .addComponent(jSpinnerAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonModify)
                    .addComponent(jButtonCancel))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifyActionPerformed
        
        String titleHU = jTextFieldTitle.getText().trim();
        String titleEN = jTextFieldTitleOrig.getText().trim();
        
        if( titleEN.equals("") || titleHU.equals("") || jListDirectors.isSelectionEmpty() || jListGenres.isSelectionEmpty() || jComboBoxRelease.getModel().getSize()==0 ) {
            JOptionPane.showMessageDialog(rootPane, "A csillagozott mezők kitöltése kötelező", "Üresen hagyott csillagozott mezők", JOptionPane.WARNING_MESSAGE);
        } else {

            Integer id = logic.getReleaseIDbyName((String)jComboBoxRelease.getSelectedItem());
            if( id == null) {
                JOptionPane.showMessageDialog(rootPane, "Nincs megfelelő kiadvány beállítva","Nincs kiadvány", JOptionPane.WARNING_MESSAGE);
                return;
            }
            movie.setReleaseid( id );
            movie.setTitleHu(titleHU);
            movie.setType((String)jComboBoxType.getSelectedItem() );
            movie.setYear( (Integer)jComboBoxYear.getSelectedItem() );
            movie.setImdbUrl("http://imdb.com/title/"+jTextFieldIMDBLink.getText());
            movie.setTitleOrig(titleEN);
            movie.setAmount((Integer)jSpinnerAmount.getModel().getValue());

            logic.updateMoviesTable( movie.getId(), movie, jListGenres.getSelectedValuesList(), jListDirectors.getSelectedValuesList() );

            this.dispose();
        }
    }//GEN-LAST:event_jButtonModifyActionPerformed

    

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jLabelUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelUpdateMouseClicked
        updateComponents();
    }//GEN-LAST:event_jLabelUpdateMouseClicked

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

    //
    // Begin of declarations
    //
    
    
    /**
     * Egy film bejegyzést reprezentáló objektum.
     */
    MovieItem movie;
    /**
     * Alkalmazás logikája
     */
    private CatalogueLogic logic;
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonModify;
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
    private javax.swing.JLabel jLabelNewFilm;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelTitleOrig;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JLabel jLabelUpdate;
    private javax.swing.JLabel jLabelYear;
    private javax.swing.JList jListDirectors;
    private javax.swing.JList jListGenres;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
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
            lm.addElement(director.getFirstname() +" "+ director.getLastname());
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
        for( ReleaseItem release  : releases ) {
            dcm.addElement( release.getName() );
        }
        
        String releaseName = logic.getReleaseNamebyID(movie.getReleaseid());
        if( releaseName != null ) {
            dcm.setSelectedItem( releaseName );
        }
        jComboBoxRelease.setModel( dcm );
    }
    
    /**
     * Felület komponenseinek testreszabása.
     */
    public void customizeComponents(/*MovieItem movie, MovieItemPK key*/) {
        
        updateComponents();
       
        jTextFieldTitle.setText(movie.getTitleHu());
        jTextFieldTitleOrig.setText( movie.getTitleOrig());
        String[] tmp = movie.getImdbUrl().split("/");
        String imdbAzon = tmp[tmp.length-1];
        if( !imdbAzon.equals("title")) {
            jTextFieldIMDBLink.setText(imdbAzon);
        } 
        
        
        DefaultComboBoxModel dcm;
        dcm = new DefaultComboBoxModel();
        jComboBoxYear.setModel( dcm );
        for( int i=1900; i<= Calendar.getInstance().get( Calendar.YEAR ); i++ ) {
            dcm.addElement( i );
        }
        dcm.setSelectedItem(movie.getYear());

        //Típus comboBox feltöltés
        dcm = new DefaultComboBoxModel();
        jComboBoxType.setModel( dcm );
        jComboBoxType.getEditor().getEditorComponent().setBackground(Color.WHITE);
        dcm.addElement( "DVD" );
        dcm.addElement( "Blueray" );
        dcm.setSelectedItem(movie.getType());
        
        //Mennyiség jspinner beállítása 
        jSpinnerAmount.setModel(new SpinnerNumberModel(1, 1, 500, 1));
        jSpinnerAmount.setEditor(new JSpinner.DefaultEditor(jSpinnerAmount));   //ezáltal letiltom, hogy a jspinner beviteli mezőjébe írni lehessen
    }

    
}
