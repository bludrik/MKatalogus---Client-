package catalogue.GUI;

import catalogue.endpoint.MovieItem;
import catalogue.endpoint.MovieSubItem;
import catalogue.logic.CatalogueLogic;
import catalogue.logic.ImageColumnRenderer;
import catalogue.logic.MovieTableModel;
import catalogue.logic.MyScrollBarUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/**
 * A Katalógus kezdő felületének osztálya.
 * @author Ludrik Balazs
 */
public class CatalogueUI extends javax.swing.JFrame {

    /**
     * A filmeket tartalmazó táblázat inicializálását végzi.
     */
    public void initTable( ) {
        
        
        //
        // TÁBLÁZATRA VONATKOZÓ ALAPBEÁLLÍTÁSOK
        //
        model = new MovieTableModel(logic); // saját modell használata
        jTableMovies.setModel( model );
        jTableMovies.setBackground(Color.WHITE);
        jTableMovies.setRowHeight(60);
        jTableMovies.setShowHorizontalLines(true);
        jTableMovies.setShowVerticalLines(false);
        jTableMovies.setGridColor(new Color(245, 245, 245));
        jTableMovies.getTableHeader().setReorderingAllowed(false); // Letiltja a tábla fejlécének átrendezhetőségét
        jTableMovies.setSelectionBackground( new Color(230,230,230));
        jTableMovies.setSelectionForeground(Color.black);
        jTableMovies.setFont( new Font("Tahoma", Font.BOLD, 11));
        jTableMovies.setBorder( null);
        jTableMovies.setAutoCreateRowSorter(true);
        jTableMovies.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        jScrollPaneMovieTable.getViewport().setBackground(Color.white); // viewport színét kell átállítani hogy a táblázat háttere a megfelelő legyen
        
        
        
        //
        // A CELLATARTALMAK ÉS FEJLÉCEK KÖZÉPRE RENDEZÉSE
        //
        DefaultTableCellRenderer columnRenderer =  new DefaultTableCellRenderer();
        columnRenderer.setHorizontalAlignment( JLabel.CENTER );
        columnRenderer.setBackground(Color.white);
        
        DefaultTableCellRenderer headerRenderer =  new DefaultTableCellRenderer();
        headerRenderer.setHorizontalAlignment( JLabel.CENTER );
        headerRenderer.setBackground(new Color(240, 240, 240));
        
        TableColumn column = jTableMovies.getColumnModel().getColumn(1);
        column.setCellRenderer( columnRenderer);
        column.setHeaderRenderer(headerRenderer);
        column.setPreferredWidth(350);
        
        column = jTableMovies.getColumnModel().getColumn(2); 
        column.setCellRenderer( columnRenderer );
        column.setHeaderRenderer(headerRenderer);
        
        column = jTableMovies.getColumnModel().getColumn(0);
        column.setCellRenderer( columnRenderer );
        column.setHeaderRenderer(headerRenderer);
        
        column = jTableMovies.getColumnModel().getColumn(3);
        ImageColumnRenderer imgRenderer = new ImageColumnRenderer();
        column.setCellRenderer(imgRenderer);
        column.setHeaderRenderer(headerRenderer);
        
    }
    
    /**
     * Konstruktor. Elvégzi a komponensek inicializálását. 
     */
    public CatalogueUI() {
        
        setSize(800, 660);
        initComponents();
        customizeComponents();
        URL imageURL = this.getClass().getClassLoader().getResource("appIcon.png");
        try {
            BufferedImage image = ImageIO.read(imageURL);
            this.setIconImage(image);
        } catch (IOException ex) {
            Logger.getLogger(CatalogueUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        setResizable(false);
        setLocationRelativeTo(null);
        
    }
    
    /**
     * A felület komponenseinek inicializálását végzi.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLogo = new javax.swing.JPanel();
        jPanelMainPanel = new javax.swing.JPanel();
        jScrollPaneMovieTable = new javax.swing.JScrollPane();
        jTableMovies = new javax.swing.JTable();
        jPanelSearchBar = new javax.swing.JPanel();
        jTextFieldSearchBar = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jRadioButtonFilm = new javax.swing.JRadioButton();
        jRadioButtonDirector = new javax.swing.JRadioButton();
        jRadioButtonGenre = new javax.swing.JRadioButton();
        jRadioButtonType = new javax.swing.JRadioButton();
        jLabelUserContact = new javax.swing.JLabel();
        jPanelControl = new javax.swing.JPanel();
        jButtonNewMovie = new javax.swing.JButton();
        jButtonNewDirector = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonMovieDetails = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemAddNewFilm = new javax.swing.JMenuItem();
        jMenuItemAddDirector = new javax.swing.JMenuItem();
        jMenuItemGenreMaintanace = new javax.swing.JMenuItem();
        jMenuItemReleaseMaintanance = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemQuit = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();
        jMenuItemUpdate = new javax.swing.JMenuItem();
        jMenuItemDelete = new javax.swing.JMenuItem();

        jPanelLogo.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelLogoLayout = new javax.swing.GroupLayout(jPanelLogo);
        jPanelLogo.setLayout(jPanelLogoLayout);
        jPanelLogoLayout.setHorizontalGroup(
            jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );
        jPanelLogoLayout.setVerticalGroup(
            jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 165, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Elosztott Katalógus");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImages(null);

        jPanelMainPanel.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMainPanel.setMaximumSize(new java.awt.Dimension(800, 650));
        jPanelMainPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        jScrollPaneMovieTable.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPaneMovieTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPaneMovieTable.setForeground(new java.awt.Color(0, 102, 204));
        jScrollPaneMovieTable.setToolTipText("Filmek listája");
        jScrollPaneMovieTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPaneMovieTable.setMaximumSize(new java.awt.Dimension(600, 400));
        jScrollPaneMovieTable.setPreferredSize(new java.awt.Dimension(780, 400));
        jScrollPaneMovieTable.getVerticalScrollBar().setUI(new MyScrollBarUI());

        //
        jTableMovies.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTableMovies.setForeground(new java.awt.Color(102, 102, 102));
        jScrollPaneMovieTable.setViewportView(jTableMovies);

        jPanelSearchBar.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSearchBar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Keressen filmjei között", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.darkGray));
        jPanelSearchBar.setPreferredSize(new java.awt.Dimension(750, 100));

        jTextFieldSearchBar.setToolTipText("");
        jTextFieldSearchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldSearchBarKeyTyped(evt);
            }
        });

        jButtonSearch.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSearch.setText("Keres");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jRadioButtonFilm.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonFilm.setText("Cím");

        jRadioButtonDirector.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonDirector.setText("Rendező");

        jRadioButtonGenre.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonGenre.setText("Műfaj");

        jRadioButtonType.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonType.setText("Adathordozó szerint");

        javax.swing.GroupLayout jPanelSearchBarLayout = new javax.swing.GroupLayout(jPanelSearchBar);
        jPanelSearchBar.setLayout(jPanelSearchBarLayout);
        jPanelSearchBarLayout.setHorizontalGroup(
            jPanelSearchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSearchBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSearchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSearchBarLayout.createSequentialGroup()
                        .addComponent(jRadioButtonFilm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonDirector)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonGenre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonType))
                    .addGroup(jPanelSearchBarLayout.createSequentialGroup()
                        .addComponent(jTextFieldSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSearch)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelSearchBarLayout.setVerticalGroup(
            jPanelSearchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSearchBarLayout.createSequentialGroup()
                .addGroup(jPanelSearchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelSearchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonFilm)
                    .addComponent(jRadioButtonDirector)
                    .addComponent(jRadioButtonGenre)
                    .addComponent(jRadioButtonType))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelUserContact.setBackground(new java.awt.Color(245, 245, 245));
        jLabelUserContact.setPreferredSize(new java.awt.Dimension(89, 20));

        jPanelControl.setBackground(new java.awt.Color(255, 255, 255));
        jPanelControl.setPreferredSize(new java.awt.Dimension(260, 30));

        jButtonNewMovie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addFilm.png"))); // NOI18N
        jButtonNewMovie.setToolTipText("Film felvétele");
        jButtonNewMovie.setBorder(null);
        jButtonNewMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewMovieActionPerformed(evt);
            }
        });

        jButtonNewDirector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addDirector.png"))); // NOI18N
        jButtonNewDirector.setToolTipText("Rendező kezelő megnyitása");
        jButtonNewDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewDirectorActionPerformed(evt);
            }
        });

        jButtonUpdate.setBackground(new java.awt.Color(255, 255, 255));
        jButtonUpdate.setForeground(new java.awt.Color(240, 240, 240));
        jButtonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update.png"))); // NOI18N
        jButtonUpdate.setToolTipText("Összes film betöltése");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setBackground(new java.awt.Color(255, 255, 255));
        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        jButtonDelete.setToolTipText("Kijelölt filmek törlése");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonMovieDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/details.png"))); // NOI18N
        jButtonMovieDetails.setToolTipText("Kijelölt film adatlapjának megtekintése");
        jButtonMovieDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMovieDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelControlLayout = new javax.swing.GroupLayout(jPanelControl);
        jPanelControl.setLayout(jPanelControlLayout);
        jPanelControlLayout.setHorizontalGroup(
            jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNewMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNewDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonMovieDetails)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelControlLayout.setVerticalGroup(
            jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControlLayout.createSequentialGroup()
                .addGroup(jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonUpdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonNewDirector, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonNewMovie, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButtonMovieDetails, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelMainPanelLayout = new javax.swing.GroupLayout(jPanelMainPanel);
        jPanelMainPanel.setLayout(jPanelMainPanelLayout);
        jPanelMainPanelLayout.setHorizontalGroup(
            jPanelMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainPanelLayout.createSequentialGroup()
                .addGroup(jPanelMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelSearchBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPaneMovieTable, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                            .addComponent(jLabelUserContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelMainPanelLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jPanelControl, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMainPanelLayout.setVerticalGroup(
            jPanelMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneMovieTable, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelUserContact, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuFile.setText("Fájl");

        jMenuItemAddNewFilm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addFilm.png"))); // NOI18N
        jMenuItemAddNewFilm.setText("Új film felvétele");
        jMenuItemAddNewFilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewMovieActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemAddNewFilm);

        jMenuItemAddDirector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addDirector.png"))); // NOI18N
        jMenuItemAddDirector.setText("Rendező felvétele / módosítása");
        jMenuItemAddDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewDirectorActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemAddDirector);

        jMenuItemGenreMaintanace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/genre.png"))); // NOI18N
        jMenuItemGenreMaintanace.setText("Műfaj karbantartó");
        jMenuItemGenreMaintanace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGenreMaintanaceActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemGenreMaintanace);

        jMenuItemReleaseMaintanance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/release.png"))); // NOI18N
        jMenuItemReleaseMaintanance.setText("Kiadási típus karbantartó");
        jMenuItemReleaseMaintanance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReleaseMaintananceActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemReleaseMaintanance);
        jMenuFile.add(jSeparator1);

        jMenuItemQuit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quit.png"))); // NOI18N
        jMenuItemQuit.setText("Kilépés");
        jMenuItemQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemQuitActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemQuit);

        jMenuBar1.add(jMenuFile);

        jMenuEdit.setText("Szerkesztés");

        jMenuItemUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update.png"))); // NOI18N
        jMenuItemUpdate.setText("Frissítés");
        jMenuItemUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemUpdate);

        jMenuItemDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        jMenuItemDelete.setText("Törlés");
        jMenuItemDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemDelete);

        jMenuBar1.add(jMenuEdit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Rendezőkezelő gomb eseménykezelése.
     * @param evt   kiváltott esemény
     */
    private void jButtonNewDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewDirectorActionPerformed
        if( newDirectorFrame == null || !newDirectorFrame.isShowing() ) {
            // Ha még egyátalán nem volt megnyitva rendező beállító oldal vagy jelenleg nincs nyitva ilyen oldalt akkor nyithatunk újat
            newDirectorFrame = new DirectorFrame(logic);
        } else {
            newDirectorFrame.requestFocus();
        }
    }//GEN-LAST:event_jButtonNewDirectorActionPerformed

    
    /**
     * Film hozzáadása gomb eseménykezelője.
     * @param evt   kiváltott esemény
     */
    private void jButtonNewMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewMovieActionPerformed
        if( newFilmFrame == null || !newFilmFrame.isShowing() ) {
            // Ha még egyátalán nem volt megnyitva rendező beállító oldal vagy jelenleg nincs nyitva ilyen oldalt akkor nyithatunk újat
            newFilmFrame = new NewFilmFrame(logic);
        } else {
            newFilmFrame.requestFocus();
        }
    }//GEN-LAST:event_jButtonNewMovieActionPerformed

    /**
     * 
     * @param evt 
     */
    private void jMenuItemQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemQuitActionPerformed
        dispose();
        System.exit(0);
    }//GEN-LAST:event_jMenuItemQuitActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        setUserMsg("Filmek listájának frissítése folyamatban...", Color.gray);
        logic.updateMoviesList();
        logic.fireMovieTableDataChanged();
        SimpleDateFormat sdf =  new SimpleDateFormat("HH:mm");
        String time = sdf.format( Calendar.getInstance().getTime());
        if( logic.getMoviesCount() == 0) {
            setUserMsg("[ "+time+" - Nincs film a katalógusban ]", Color.gray);
        } else {
            setUserMsg("[ "+time+" - Filmlista frissítve ]", Color.gray);
        }
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        if( logic.getMoviesCount()>0) {
            int[] toDeleteView = jTableMovies.getSelectedRows();        // a tábla nézete szerinti kijelölt sorok   
            if( toDeleteView.length!=0 ) {
                int[] toDeleteModel = new int[ toDeleteView.length ];       // a modellben lévő indexek
                for( int i=0; i<toDeleteView.length; i++) {
                    toDeleteModel[i] = jTableMovies.convertRowIndexToModel(toDeleteView[i]);
                }
                int reply = JOptionPane.showOptionDialog(rootPane, "Biztosan törölni kívánja a kijelölt filmeket?", "Törlés Megerősítése", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"Igen","Nem"}, "default");
                if(reply == 0 ) {
                    logic.deleteMovies( toDeleteModel );
                    
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Jelölje ki a törölni kívánt filmeket a táblázatban!", "Nincs kijelölt elem", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nincs film a katalógusban, így nem lehetséges a törlés.", "Nincs törölhető film", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jMenuItemGenreMaintanaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGenreMaintanaceActionPerformed
        if( genreFrame == null || !genreFrame.isShowing() ) {
            genreFrame = new GenreMaintananceFrame( logic );
        }
        else {
            genreFrame.requestFocus();
        }
    }//GEN-LAST:event_jMenuItemGenreMaintanaceActionPerformed

    private void jMenuItemReleaseMaintananceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReleaseMaintananceActionPerformed
        if( releaseFrame == null || !releaseFrame.isShowing() ) {
            releaseFrame = new ReleaseMaintananceFrame(logic);
        }
        else {
            releaseFrame.requestFocus();
        }
    }//GEN-LAST:event_jMenuItemReleaseMaintananceActionPerformed

    /**
     * Keresés eseménykezelő
     * @param evt 
     */
    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        String str = jTextFieldSearchBar.getText().trim();
        if( str.length() > 2 ) {
            //Csak akkor keres ha legalább 3 karakterre kere a felhasználó
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            String time = sdf.format(Calendar.getInstance().getTime());
            search(str);
            if( jTableMovies.getRowCount() > 0 ) {
                logic.sendMsgToUser("[ "+time+" - Keresés kész. ]", Color.gray);
            }
            else {
                logic.sendMsgToUser("[ "+time+" - Nincs a keresésnek megfelelő találat. ]", Color.gray);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Legalább 3 karakterből álló szót kell megadni a kereséshez", "Keresés", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSearchActionPerformed

    /**
     * Lehetővé teszi, hogy a kereső panelen az enter billentyű lenyomásának hatására végrehajtódjon a keresés.
     * @param evt   billentyű esemény
     */
    private void jTextFieldSearchBarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchBarKeyTyped
        char ch = evt.getKeyChar();
        if( ch == '\n')
        {
            jButtonSearchActionPerformed(null);
        }
    }//GEN-LAST:event_jTextFieldSearchBarKeyTyped

    private void jButtonMovieDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMovieDetailsActionPerformed
        try {
            GetMovieDataSheetWorker worker = new GetMovieDataSheetWorker();
            worker.execute();        
        } catch(    Exception ex) {
        
        }
    }//GEN-LAST:event_jButtonMovieDetailsActionPerformed
    
    /**
     * Main függvény.
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            
            //Beállítja a rendszer saját L&F -jét
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        
        
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CatalogueUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
//            SwingUtilities.invokeLater( new Runnable() {
            
                @Override
            public void run() {
                
                CatalogueUI gui = null;
                try {
                    gui = new CatalogueUI();
                    logic = new CatalogueLogic(gui);
                    gui.initTable();    // a CatalogueLogic után kell meghívni mert használja azt
                    gui.setVisible(true);
                    
                } catch( Exception ex) {
                    Logger.getLogger(CatalogueUI.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "<html>Hiba történt a program indításakor. A kliens nem tud kapcsolódni a távoli kiszolgálóhoz.<br><p style='margin-left:auto;margin-right:auto;width:50%;'><b>Tipp:</b> Ellenőrizze internetkapcsolatatát.</p><p style='margin-left:auto;margin-right:auto;width:80%;'><b>Tipp:</b> Vegye fel a kapcsolatot a webszolgáltatás üzemeltetőjével.</p></html>", "HIBA AZ INDULÁSKOR", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                } 
                
            }
        });
    }


    /**
     * A paraméterként kapott üzenetet írja ki az információs sávba a megfelelő színben.
     * @param msg
     * @param c 
     */
   public void setUserMsg( String msg, Color c ) {
       jLabelUserContact.setForeground(c);
       jLabelUserContact.setText(msg);
       
   }

   /**
    * Visszaadja a filmeket tartalmazó táblázat modelljét.
    * @return   MovieTableModel objektum
    */
    public MovieTableModel getModel() {
        return model;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonMovieDetails;
    private javax.swing.JButton jButtonNewDirector;
    private javax.swing.JButton jButtonNewMovie;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabelUserContact;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItemAddDirector;
    private javax.swing.JMenuItem jMenuItemAddNewFilm;
    private javax.swing.JMenuItem jMenuItemDelete;
    private javax.swing.JMenuItem jMenuItemGenreMaintanace;
    private javax.swing.JMenuItem jMenuItemQuit;
    private javax.swing.JMenuItem jMenuItemReleaseMaintanance;
    private javax.swing.JMenuItem jMenuItemUpdate;
    private javax.swing.JPanel jPanelControl;
    private javax.swing.JPanel jPanelLogo;
    private javax.swing.JPanel jPanelMainPanel;
    private javax.swing.JPanel jPanelSearchBar;
    private javax.swing.JRadioButton jRadioButtonDirector;
    private javax.swing.JRadioButton jRadioButtonFilm;
    private javax.swing.JRadioButton jRadioButtonGenre;
    private javax.swing.JRadioButton jRadioButtonType;
    private javax.swing.JScrollPane jScrollPaneMovieTable;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTableMovies;
    private javax.swing.JTextField jTextFieldSearchBar;
    // End of variables declaration//GEN-END:variables

    // SAJÁT VÁLTOZÓK DEKLARÁLÁSA
    private static CatalogueLogic logic;
    private MovieTableModel model;
    private ButtonGroup bGroup = new ButtonGroup();
    
    private DirectorFrame newDirectorFrame = null;
    private NewFilmFrame newFilmFrame = null;
    private MovieDetailsFrame detailsFrame = null;
    private GenreMaintananceFrame genreFrame = null;
    private ReleaseMaintananceFrame releaseFrame = null;
    
    /**
     * A felület komponenseinek testreszabását végzi.
     */
    public void customizeComponents() {
    
        //
        //Button Group
        //
        
        bGroup.add(jRadioButtonFilm);
        bGroup.add(jRadioButtonDirector);
        bGroup.add(jRadioButtonGenre);
        bGroup.add(jRadioButtonType);
        jRadioButtonFilm.setSelected(true);
        
        jLabelUserContact.setOpaque(true);  // hogy legyen háttérszíne

    }

    /**
     * Keresést kezdeményez a paraméterként kapott szöveggel az éppen kiválasztott rádió gombnak megfelelően.
     * @param str   keresett szöveg
     */
    public void search(String str) {
        if( jRadioButtonFilm.isSelected() ) {
            logic.getMoviesFilteredByName( str.toLowerCase() );
        }else if( jRadioButtonDirector.isSelected() ) {
            logic.getMoviesFilteredByDirector( str.replace("'", "''").toLowerCase() );
        } else if( jRadioButtonGenre.isSelected() ) {
            logic.getMoviesFilteredByGenre( str.toLowerCase() );
        } else {
            logic.getMoviesFilteredByType(str.toLowerCase());
        }   
    }

    
    //
    //  My own Swingworker - GetMovieDataSheetWorker
    //
    
    private class GetMovieDataSheetWorker extends SwingWorker<Integer, String> {
        
        @Override
        protected Integer doInBackground() {
           
            if( logic.getMoviesCount()>0) {
            int[] selected = jTableMovies.getSelectedRows();
            if( selected.length > 0 ) {
                if( detailsFrame == null || !detailsFrame.isShowing() ) {
                    setUserMsg("Film adatlapjának betöltése...10%", Color.gray);
                    int modelNumber = jTableMovies.convertRowIndexToModel(selected[0]);
                    MovieSubItem key = logic.getMovie(modelNumber);  
                    MovieItem movie = logic.getMovieByKey(key.getId());
                    setUserMsg("Film adatlapjának betöltése...30%", Color.gray);
                    
                    if( movie!= null) {
                        int movieId = movie.getId();
                        List<Integer> directorIdx = logic.getDirectorOfMovie(movieId);
                        setUserMsg("Film adatlapjának betöltése...60%", Color.gray);
                        List<Integer> genreIdx = logic.getGenreOfMovie(movieId);
                        setUserMsg("Film adatlapjának betöltése...80%", Color.gray);
                        detailsFrame = new MovieDetailsFrame( movie,directorIdx, genreIdx, logic); 
                        setUserMsg("Film adatlapjának betöltése...100%", Color.gray);
                    }
                } else {
                    detailsFrame.requestFocus();
                }//end of 'is detailsFrame open?'if
            } else {
                JOptionPane.showMessageDialog(rootPane, "Jelöljön ki egyet a felsorolt filmek közül!", "Nincs kijelölt elem", JOptionPane.INFORMATION_MESSAGE);
            }
            logic.sendMsgToUser("", Color.gray);
        } else {
            JOptionPane.showMessageDialog(rootPane, "A katalógus még nem tartalmaz egy filmet sem.","Katalógus nem tartalmaz filmet", JOptionPane.INFORMATION_MESSAGE);
        }
            return 1; 
        }
        
    
    }//end of SwingWorker
    
    
    
}//end of class CatalogueUI
