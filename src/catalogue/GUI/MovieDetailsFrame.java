package catalogue.GUI;

import catalogue.endpoint.MovieItem;
import catalogue.logic.CatalogueLogic;
import java.awt.Color;
import java.awt.Desktop;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ProgressMonitor;

/**
 * Adott film adatlapját kezelő osztály.
 * @author Ludrik Balázs
 */
public class MovieDetailsFrame extends javax.swing.JFrame {

    /**
     * A program logikáját reprezentáló objektum
     */
    CatalogueLogic logic  = null;
    /**
     * Egy film bejegyzést reprezentáló objektum
     */
    MovieItem movie;
    /**
     * Filmhez tartozó rendezók azonosítóinak listája
     */
    List<Integer> directorIdx = new ArrayList<Integer>();
    /**
     * Filmhez tartozó műfajok azonosítóinak listája
     */
    List<Integer> genreIdx = new ArrayList<Integer>();
    
    /**
     * Konstruktor
     * @param movie             film bejegyzés
     * @param logic             a program logikáját reprezentáló objektum
     */
    public MovieDetailsFrame(MovieItem movie, List<Integer> directorIdx, List<Integer> genreIdx, CatalogueLogic logic) {
        
        this.logic = logic;
        this.movie = movie;
        this.directorIdx = directorIdx;
        this.genreIdx = genreIdx;
        initComponents();   //komponensek inicializálása
        customizeComponents();  //komponensek testreszanása
        this.setTitle(movie.getTitleHu()+" Adatlap");
         
//        if (monitor == null)
//            return;
//        if (monitor.isCanceled()) {
//            return;
//        } else {
//            monitor.setProgress(100);
//        }
        
        setLocationRelativeTo(this);
        setVisible(true);
        
    }
    
    /**
     * A felület komponenseinek testreszabását végzi.
     */
    public void customizeComponents() {
        
        jTextFieldOriginalTitle.setText(movie.getTitleOrig());
        jTextFieldTitle.setText(movie.getTitleHu());
        jTextFieldYear.setText(""+movie.getYear());
        jTextFieldType.setText(movie.getType());
        
        
        String releaseName = logic.getReleaseNamebyID(movie.getReleaseid());
        if( releaseName != null) {
            jTextFieldExtra.setText( releaseName);
        } else {
            jTextFieldExtra.setText(" n/a");
        }
        
//        int movieId = movie.getId();
        
//        directorIdx = logic.getDirectorOfMovie(movieId);    //rendezők  azonosítóinak listája
        
        
        StringBuilder names;
        names = new StringBuilder( "" );
        try {
            for( int i=0; i<directorIdx.size() ; i++) {
                //Rendezők összeállítása
                String directorName = logic.getDirectorNamebyID(directorIdx.get(i));
                if( directorName != null) {
                    names.append(" - ").append(directorName);
                }
//                names.append(" - ").append(logic.getDirectorNamebyID(directorIdx.get(i)));
            }
            jTextFieldDirector.setText( names.toString().substring(3) );
        } catch( Exception ex) {
            jTextFieldDirector.setText( "N/A" );
        }
        
        //Monitorozás
//        if (monitor == null)
//            return;
//        if (monitor.isCanceled()) {
//            return;
//        } else {
//            monitor.setProgress(60);
//        }
        
//        genreIdx = logic.getGenreOfMovie(movieId);          //műfajok azonosítóinak listája
        try {
            names = new StringBuilder( "" );
//            names = new StringBuilder( logic.getGenreNameById(genreIdx.get(0)));
            for( int i=0; i<genreIdx.size() ; i++) {
                //műfaj összeállítása
                String genreName = logic.getGenreNameById(genreIdx.get(i));
                if( genreName != null) {
                    names.append(" | ").append(genreName);
                }
//                names.append(" | ").append(logic.getGenreNameById(genreIdx.get(i)));
            }
            jTextFieldGenres.setText(names.toString().substring(3));
        } catch(Exception ex) {
            jTextFieldGenres.setText("n/a");
        }
        
        //Monitorozás
//        if (monitor == null)
//            return;
//        if (monitor.isCanceled()) {
//            return;
//        } else {
//            monitor.setProgress(90);
//        }
        
        jLabelAmount.setText( movie.getAmount().toString() );
        
        // A textfieldek nem szerkeszthetőek
        jTextFieldDirector.setEditable(false);
        jTextFieldExtra.setEditable(false);
        jTextFieldGenres.setEditable(false);
        jTextFieldOriginalTitle.setEditable(false);
        jTextFieldTitle.setEditable(false);
        jTextFieldType.setEditable(false);
        jTextFieldYear.setEditable(false);
        
    }
    
    /**
     * Megnyitja a paraméterként kapott honlapot url címe alapján
     * @param uri   a megnyitandó honlap címe
     */
    public static void openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nem sikerült megnyitni a weblapot!", "Sikertelen weblapelérés!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Felület komponenseinek inicializálása
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDetails = new javax.swing.JPanel();
        jTextFieldYear = new javax.swing.JTextField();
        jLabelDirector = new javax.swing.JLabel();
        jTextFieldDirector = new javax.swing.JTextField();
        jLabelOriginalTitle = new javax.swing.JLabel();
        jTextFieldOriginalTitle = new javax.swing.JTextField();
        jTextFieldExtra = new javax.swing.JTextField();
        jTextFieldType = new javax.swing.JTextField();
        jTextFieldTitle = new javax.swing.JTextField();
        jLabelYear = new javax.swing.JLabel();
        jLabelGenre = new javax.swing.JLabel();
        jLabelType = new javax.swing.JLabel();
        jLabelExtra = new javax.swing.JLabel();
        jTextFieldGenres = new javax.swing.JTextField();
        jLabelIMDBPage = new javax.swing.JLabel();
        jLabelEditView = new javax.swing.JLabel();
        jLabelAmount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 255));
        setModalExclusionType(null);
        setResizable(false);

        jPanelDetails.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDetails.setPreferredSize(new java.awt.Dimension(560, 600));

        jTextFieldYear.setBackground(new java.awt.Color(240, 240, 240));
        jTextFieldYear.setForeground(new java.awt.Color(0, 102, 255));
        jTextFieldYear.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldYear.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabelDirector.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabelDirector.setText("Rendezte: ");

        jTextFieldDirector.setBackground(new java.awt.Color(240, 240, 240));
        jTextFieldDirector.setForeground(new java.awt.Color(0, 102, 255));
        jTextFieldDirector.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDirector.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabelOriginalTitle.setText("Eredeti cím:");

        jTextFieldOriginalTitle.setBackground(new java.awt.Color(240, 240, 240));
        jTextFieldOriginalTitle.setForeground(new java.awt.Color(0, 102, 255));
        jTextFieldOriginalTitle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldOriginalTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTextFieldExtra.setBackground(new java.awt.Color(240, 240, 240));
        jTextFieldExtra.setForeground(new java.awt.Color(0, 102, 255));
        jTextFieldExtra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldExtra.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTextFieldType.setBackground(new java.awt.Color(240, 240, 240));
        jTextFieldType.setForeground(new java.awt.Color(0, 102, 255));
        jTextFieldType.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldType.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTextFieldTitle.setBackground(new java.awt.Color(240, 240, 240));
        jTextFieldTitle.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jTextFieldTitle.setForeground(new java.awt.Color(0, 102, 255));
        jTextFieldTitle.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldTitle.setText("Cím");
        jTextFieldTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabelYear.setText("Készült:");

        jLabelGenre.setText("Műfaj:");

        jLabelType.setText("Adathordozó:");
        jLabelType.setToolTipText("(DVD, Blueray)");

        jLabelExtra.setText("Kiadás:");

        jTextFieldGenres.setBackground(new java.awt.Color(240, 240, 240));
        jTextFieldGenres.setForeground(new java.awt.Color(0, 102, 255));
        jTextFieldGenres.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldGenres.setBorder(null);

        jLabelIMDBPage.setForeground(new java.awt.Color(0, 153, 204));
        jLabelIMDBPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIMDBPage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imdb.png"))); // NOI18N
        jLabelIMDBPage.setToolTipText("IMDb oldal megnyitásához kattintson");
        jLabelIMDBPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelIMDBPageMouseClicked(evt);
            }
        });

        jLabelEditView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEditView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit.png"))); // NOI18N
        jLabelEditView.setToolTipText("Szerkesztő nézet");
        jLabelEditView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditViewMouseClicked(evt);
            }
        });

        jLabelAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAmount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/release.png"))); // NOI18N
        jLabelAmount.setText("1");
        jLabelAmount.setToolTipText("Példányszám");

        javax.swing.GroupLayout jPanelDetailsLayout = new javax.swing.GroupLayout(jPanelDetails);
        jPanelDetails.setLayout(jPanelDetailsLayout);
        jPanelDetailsLayout.setHorizontalGroup(
            jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTitle)
                    .addGroup(jPanelDetailsLayout.createSequentialGroup()
                        .addComponent(jLabelDirector)
                        .addGap(41, 41, 41)
                        .addComponent(jTextFieldDirector))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDetailsLayout.createSequentialGroup()
                        .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelOriginalTitle)
                            .addComponent(jLabelType)
                            .addComponent(jLabelExtra))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldOriginalTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(jTextFieldType)
                            .addComponent(jTextFieldExtra, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanelDetailsLayout.createSequentialGroup()
                        .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelYear)
                            .addComponent(jLabelGenre))
                        .addGap(60, 60, 60)
                        .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldYear, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(jTextFieldGenres))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelDetailsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelIMDBPage, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabelEditView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        jPanelDetailsLayout.setVerticalGroup(
            jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetailsLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAmount))
                .addGap(16, 16, 16)
                .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelDetailsLayout.createSequentialGroup()
                        .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelYear))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelGenre)
                            .addComponent(jTextFieldGenres, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDirector)
                            .addComponent(jTextFieldDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelOriginalTitle)
                            .addComponent(jTextFieldOriginalTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldType, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelType))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelExtra)
                            .addComponent(jTextFieldExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelIMDBPage))
                    .addComponent(jLabelEditView, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDetails, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelIMDBPageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIMDBPageMouseClicked
        try {
            try {
                openWebpage( new URL(movie.getImdbUrl()).toURI());
            } catch (MalformedURLException ex) {
                Logger.getLogger(MovieDetailsFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(rootPane, "Nem megfelelő url szintaxis.", "Rossz szintaxis.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jLabelIMDBPageMouseClicked

    private void jLabelEditViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditViewMouseClicked
        this.dispose();
        new MovieModificationFrame(logic, movie);
    }//GEN-LAST:event_jLabelEditViewMouseClicked
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAmount;
    private javax.swing.JLabel jLabelDirector;
    private javax.swing.JLabel jLabelEditView;
    private javax.swing.JLabel jLabelExtra;
    private javax.swing.JLabel jLabelGenre;
    private javax.swing.JLabel jLabelIMDBPage;
    private javax.swing.JLabel jLabelOriginalTitle;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JLabel jLabelYear;
    private javax.swing.JPanel jPanelDetails;
    private javax.swing.JTextField jTextFieldDirector;
    private javax.swing.JTextField jTextFieldExtra;
    private javax.swing.JTextField jTextFieldGenres;
    private javax.swing.JTextField jTextFieldOriginalTitle;
    private javax.swing.JTextField jTextFieldTitle;
    private javax.swing.JTextField jTextFieldType;
    private javax.swing.JTextField jTextFieldYear;
    // End of variables declaration//GEN-END:variables


}
