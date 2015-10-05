package catalogue.GUI;

import catalogue.endpoint.DirectorItem;
import catalogue.logic.CatalogueLogic;
import catalogue.logic.DirectorTableModel;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Balazs
 */
public class DirectorFrame extends javax.swing.JFrame {

    /**
     * Alkalmazás logika
     */
    private CatalogueLogic logic;
    /**
     * Hónapok listája
     */
    private String[] months = {"Január","Február", "Március","Április", "Május", "Június", "Július", "Augusztus", "Szeptember", "Október", "November", "December"};
    /**
     * Rendezők táblázatának modellje
     */
    private DirectorTableModel model;
    
    /**
     * Konstruktor.
     */
    public DirectorFrame( CatalogueLogic logic) {
        this.logic = logic;
        initComponents();
                
        customizeComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        setVisible(true);
    }

    /**
     * Felület komponenseinek testreszabását végzi.
     */
    public void customizeComponents() {
        
        logic.updateDirectorsList();
        model = new DirectorTableModel(logic);
        jTableDirectors.setModel(model);
        jTableDirectors.getTableHeader().setReorderingAllowed(false); // Letiltja a tábla fejlécének átrendezhetőségét
        jTableDirectors.setAutoCreateRowSorter(true);
        
        //Év
        int actYear = Calendar.getInstance().get(Calendar.YEAR);
        for(int i=actYear-125; i< Calendar.getInstance().get(Calendar.YEAR)-12; i++){
            jComboBoxYear.addItem(i);
            jComboBoxModifiedYear.addItem(i);
        }
        
        //Hónap
        for(int i=0; i< months.length; i++ ){
            jComboBoxMonth.addItem(months[i]);
            jComboBoxModifiedMonth.addItem(months[i]);
        }
        
        //Nap
        for(int i=1; i< 32; i++ ){
            jComboBoxDay.addItem(i);
            jComboBoxModifiedDay.addItem(i);
        }
        
    }
    
    /**
     * Felület komponenseinek inicializálása.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneMain = new javax.swing.JTabbedPane();
        jPanelTabNew = new javax.swing.JPanel();
        jPanelHeader = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanelForm = new javax.swing.JPanel();
        jLabelDirFirstName = new javax.swing.JLabel();
        jTextFieldDirFirstName = new javax.swing.JTextField();
        jLabelDirLastName = new javax.swing.JLabel();
        jTextFieldDirLastName = new javax.swing.JTextField();
        jLabelDirBirth = new javax.swing.JLabel();
        jLabelDirBirthPlace = new javax.swing.JLabel();
        jTextFieldDirBirthPlace = new javax.swing.JTextField();
        jComboBoxYear = new javax.swing.JComboBox();
        jComboBoxMonth = new javax.swing.JComboBox();
        jComboBoxDay = new javax.swing.JComboBox();
        jButtonOK = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jPanelTrailer = new javax.swing.JPanel();
        jLabelinformation = new javax.swing.JLabel();
        jPanelTabModify = new javax.swing.JPanel();
        jPanelTab2Header = new javax.swing.JPanel();
        jLabelmodifyDirector = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanelTab2Form = new javax.swing.JPanel();
        jLabelModifiedFName = new javax.swing.JLabel();
        jTextFieldModifiedFName = new javax.swing.JTextField();
        jLabelModifiedLName = new javax.swing.JLabel();
        jTextFieldModifiedLName = new javax.swing.JTextField();
        jLabelModifiedBirth = new javax.swing.JLabel();
        jComboBoxModifiedYear = new javax.swing.JComboBox();
        jComboBoxModifiedMonth = new javax.swing.JComboBox();
        jComboBoxModifiedDay = new javax.swing.JComboBox();
        jLabelModifiedBPlace = new javax.swing.JLabel();
        jTextFieldModifiedBPlace = new javax.swing.JTextField();
        jButtonModifyOK = new javax.swing.JButton();
        jButtonModifyCancel = new javax.swing.JButton();
        jLabelModifiedDirecName = new javax.swing.JLabel();
        jComboBoxModifiedDirecName = new javax.swing.JComboBox();
        jButtonModifiedFill = new javax.swing.JButton();
        jLabelInformation2 = new javax.swing.JLabel();
        jPanelTabList = new javax.swing.JPanel();
        jTextFieldSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDirectors = new javax.swing.JTable();
        jButtonDelete = new javax.swing.JButton();
        jButtonCancel3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rendező kezelő panel");
        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPaneMain.setBackground(new java.awt.Color(255, 255, 255));

        jPanelTabNew.setBackground(new java.awt.Color(255, 255, 255));

        jPanelHeader.setBackground(new java.awt.Color(255, 255, 255));

        jLabelTitle.setText("Új rendező felvétele");

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHeaderLayout.createSequentialGroup()
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 270, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelForm.setBackground(new java.awt.Color(255, 255, 255));

        jLabelDirFirstName.setText("Keresztnév: *");

        jLabelDirLastName.setText("Családi név: *");

        jLabelDirBirth.setText("Születési idő: *");

        jLabelDirBirthPlace.setText("Születési hely: *");

        jButtonOK.setText("Kész");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Vissza");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFormLayout = new javax.swing.GroupLayout(jPanelForm);
        jPanelForm.setLayout(jPanelFormLayout);
        jPanelFormLayout.setHorizontalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelDirFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelDirLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                            .addComponent(jLabelDirBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDirBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelFormLayout.createSequentialGroup()
                                .addComponent(jComboBoxYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxDay, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldDirLastName)
                            .addComponent(jTextFieldDirFirstName)
                            .addComponent(jTextFieldDirBirthPlace)))
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addComponent(jButtonCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonOK)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanelFormLayout.setVerticalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDirFirstName)
                    .addComponent(jTextFieldDirFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDirLastName)
                    .addComponent(jTextFieldDirLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDirBirth)
                    .addComponent(jComboBoxYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDirBirthPlace)
                    .addComponent(jTextFieldDirBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOK)
                    .addComponent(jButtonCancel))
                .addContainerGap(173, Short.MAX_VALUE))
        );

        jPanelTrailer.setBackground(new java.awt.Color(255, 255, 255));

        jLabelinformation.setText("*  mező kitöltése kötelező");

        javax.swing.GroupLayout jPanelTrailerLayout = new javax.swing.GroupLayout(jPanelTrailer);
        jPanelTrailer.setLayout(jPanelTrailerLayout);
        jPanelTrailerLayout.setHorizontalGroup(
            jPanelTrailerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrailerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelinformation)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTrailerLayout.setVerticalGroup(
            jPanelTrailerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTrailerLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabelinformation)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelTabNewLayout = new javax.swing.GroupLayout(jPanelTabNew);
        jPanelTabNew.setLayout(jPanelTabNewLayout);
        jPanelTabNewLayout.setHorizontalGroup(
            jPanelTabNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelTrailer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelTabNewLayout.setVerticalGroup(
            jPanelTabNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTabNewLayout.createSequentialGroup()
                .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTrailer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPaneMain.addTab("Új rendező", null, jPanelTabNew, "");

        jPanelTabModify.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTabModify.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanelTabModifyFocusGained(evt);
            }
        });
        jPanelTabModify.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanelTabModifyAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanelTab2Header.setBackground(new java.awt.Color(255, 255, 255));

        jLabelmodifyDirector.setText("Rendező módosítása");

        javax.swing.GroupLayout jPanelTab2HeaderLayout = new javax.swing.GroupLayout(jPanelTab2Header);
        jPanelTab2Header.setLayout(jPanelTab2HeaderLayout);
        jPanelTab2HeaderLayout.setHorizontalGroup(
            jPanelTab2HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTab2HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelmodifyDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelTab2HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTab2HeaderLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelTab2HeaderLayout.setVerticalGroup(
            jPanelTab2HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTab2HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelmodifyDirector)
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(jPanelTab2HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTab2HeaderLayout.createSequentialGroup()
                    .addContainerGap(29, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)))
        );

        jPanelTab2Form.setBackground(new java.awt.Color(255, 255, 255));

        jLabelModifiedFName.setText("Keresztnév: *");

        jLabelModifiedLName.setText("Családnév: *");

        jLabelModifiedBirth.setText("Születési idő: *");

        jLabelModifiedBPlace.setText("Születési hely: *");

        jButtonModifyOK.setText("Kész");
        jButtonModifyOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifyOKActionPerformed(evt);
            }
        });

        jButtonModifyCancel.setText("Vissza");
        jButtonModifyCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifyCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTab2FormLayout = new javax.swing.GroupLayout(jPanelTab2Form);
        jPanelTab2Form.setLayout(jPanelTab2FormLayout);
        jPanelTab2FormLayout.setHorizontalGroup(
            jPanelTab2FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTab2FormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTab2FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTab2FormLayout.createSequentialGroup()
                        .addComponent(jLabelModifiedBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTab2FormLayout.createSequentialGroup()
                        .addGroup(jPanelTab2FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTab2FormLayout.createSequentialGroup()
                                .addComponent(jLabelModifiedFName, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addGap(28, 28, 28)
                                .addComponent(jTextFieldModifiedFName, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTab2FormLayout.createSequentialGroup()
                                .addGroup(jPanelTab2FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelModifiedBPlace)
                                    .addComponent(jLabelModifiedLName, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(jPanelTab2FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldModifiedLName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelTab2FormLayout.createSequentialGroup()
                                        .addComponent(jComboBoxModifiedYear, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxModifiedMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxModifiedDay, 0, 1, Short.MAX_VALUE))
                                    .addComponent(jTextFieldModifiedBPlace)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTab2FormLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonModifyCancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonModifyOK)))
                        .addGap(37, 37, 37))))
        );
        jPanelTab2FormLayout.setVerticalGroup(
            jPanelTab2FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTab2FormLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanelTab2FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelModifiedFName)
                    .addComponent(jTextFieldModifiedFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTab2FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelModifiedLName)
                    .addComponent(jTextFieldModifiedLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTab2FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelModifiedBirth)
                    .addComponent(jComboBoxModifiedYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxModifiedMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxModifiedDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelTab2FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelModifiedBPlace)
                    .addComponent(jTextFieldModifiedBPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanelTab2FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonModifyOK)
                    .addComponent(jButtonModifyCancel))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jLabelModifiedDirecName.setText("Módosítani kívánt rendező neve: *");

        jButtonModifiedFill.setText("Kitölt");
        jButtonModifiedFill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifiedFillActionPerformed(evt);
            }
        });

        jLabelInformation2.setText("*  mező kitöltése kötelező");

        javax.swing.GroupLayout jPanelTabModifyLayout = new javax.swing.GroupLayout(jPanelTabModify);
        jPanelTabModify.setLayout(jPanelTabModifyLayout);
        jPanelTabModifyLayout.setHorizontalGroup(
            jPanelTabModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTab2Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelTab2Form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelTabModifyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTabModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTabModifyLayout.createSequentialGroup()
                        .addComponent(jLabelModifiedDirecName, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxModifiedDirecName, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonModifiedFill))
                    .addComponent(jLabelInformation2))
                .addContainerGap())
        );
        jPanelTabModifyLayout.setVerticalGroup(
            jPanelTabModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTabModifyLayout.createSequentialGroup()
                .addComponent(jPanelTab2Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTabModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelModifiedDirecName)
                    .addComponent(jComboBoxModifiedDirecName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonModifiedFill))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTab2Form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jLabelInformation2)
                .addContainerGap())
        );

        jTabbedPaneMain.addTab("Módosítás", jPanelTabModify);

        jPanelTabList.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanelTabListFocusGained(evt);
            }
        });

        jTextFieldSearch.setToolTipText("Keressen a rendezők között név alapján");
        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyPressed(evt);
            }
        });

        jTableDirectors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableDirectors);

        jButtonDelete.setText("Törlés");
        jButtonDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDeleteMouseClicked(evt);
            }
        });

        jButtonCancel3.setText("Vissza");
        jButtonCancel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCancel3MouseClicked(evt);
            }
        });
        jButtonCancel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancel3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTabListLayout = new javax.swing.GroupLayout(jPanelTabList);
        jPanelTabList.setLayout(jPanelTabListLayout);
        jPanelTabListLayout.setHorizontalGroup(
            jPanelTabListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTabListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTabListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelTabListLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCancel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDelete))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                    .addComponent(jTextFieldSearch))
                .addGap(19, 19, 19))
        );
        jPanelTabListLayout.setVerticalGroup(
            jPanelTabListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTabListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanelTabListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonCancel3))
                .addContainerGap())
        );

        jTabbedPaneMain.addTab("Rendezők listája", null, jPanelTabList, "");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneMain, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneMain)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        String fName = jTextFieldDirFirstName.getText().trim();
        String lName = jTextFieldDirLastName.getText().trim();
        String bPlace = jTextFieldDirBirthPlace.getText().trim();
        
        //Hibaellenőrzés
        if( fName.equals("") || lName.equals("") || bPlace.equals("") ) {
            JOptionPane.showMessageDialog(rootPane, "Minden adat kitöltése kötelező!", "Kitöltetlen mezők!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        GregorianCalendar gCalendar;
        gCalendar = new GregorianCalendar( (int)jComboBoxYear.getSelectedItem(), jComboBoxMonth.getSelectedIndex(), (int)jComboBoxDay.getSelectedItem());
        XMLGregorianCalendar birth = null;
        try {
             birth = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);                 
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(DirectorFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Sikertelen felvétel. Ellenőrizze a megadott születési dátumot!", "Hibás dátum!", JOptionPane.WARNING_MESSAGE);
        }
        
        logic.insertDirector(lName,fName, birth, bPlace);
        model.updateTable();
        this.dispose();
        
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonModifyCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifyCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonModifyCancelActionPerformed

    private void jPanelTabModifyAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanelTabModifyAncestorAdded
        List<DirectorItem> directors = logic.getDirectorsList();
        jComboBoxModifiedDirecName.removeAllItems();
        try {
            for( int i=0; i<directors.size(); i++) {
                jComboBoxModifiedDirecName.addItem(directors.get(i).getFirstname()+" "+directors.get(i).getLastname());
            }    
        } catch( Exception ex) {
        
        }
        
    }//GEN-LAST:event_jPanelTabModifyAncestorAdded

    private void jButtonModifiedFillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifiedFillActionPerformed
        
        
            String name = (String)jComboBoxModifiedDirecName.getSelectedItem();
            DirectorItem director;
            director = logic.getDirectorByName( name );
            
            if( director != null) {
                jTextFieldModifiedFName.setText(director.getFirstname());
                jTextFieldModifiedLName.setText(director.getLastname());
                int year = director.getBirth().getYear();
                int month = director.getBirth().getMonth();
                int day = director.getBirth().getDay();
                jComboBoxModifiedYear.setSelectedItem(year);
                jComboBoxModifiedMonth.setSelectedIndex(month-1);
                jComboBoxModifiedDay.setSelectedItem(day);
                jTextFieldModifiedBPlace.setText(director.getBirthplace());
            }
    }//GEN-LAST:event_jButtonModifiedFillActionPerformed

    private void jButtonModifyOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifyOKActionPerformed
        
        String fName = jTextFieldModifiedFName.getText().trim();
        String lName = jTextFieldModifiedLName.getText().trim();
        String bPlace = jTextFieldModifiedBPlace.getText().trim();
        
        //Hibaellenőrzés
        if( fName.equals("") || lName.equals("") || bPlace.equals("") || jComboBoxModifiedDirecName.getItemCount()==0) {
            JOptionPane.showMessageDialog(rootPane, "Minden adat kitöltése kötelező!", "Kitöltetlen mezők", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //Dátum létrehozása
        XMLGregorianCalendar birth = null;
        try {
            GregorianCalendar gC;
            gC = new GregorianCalendar( (int)jComboBoxModifiedYear.getSelectedItem(), jComboBoxModifiedMonth.getSelectedIndex(), (int)jComboBoxModifiedDay.getSelectedItem());
            birth = DatatypeFactory.newInstance().newXMLGregorianCalendar(gC);
            
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(DirectorFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Ellenőrizze, hogy helyesen adta-e meg a születési dátumot!", "Dátum megadási hiba ", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Van-e ilyen rendezőnk - ha igen akkor végrehajtjuk a  módosítást 
        Integer directorId = logic.getDirectorIDbyName( (String)jComboBoxModifiedDirecName.getSelectedItem());
        if ( directorId != null ) {
            //van ilyen rendező
            logic.updateDirector( directorId, 
                                    fName, 
                                        lName, 
                                            birth,
                                            bPlace);
            this.dispose();
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "A módosítani kívánt rendező nem létezik.", "Nem létező rendező", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
        
        
    }

    public JTabbedPane getjTabbedPaneMain() {
        return jTabbedPaneMain;
    }

    public void setjTabbedPaneMain(JTabbedPane jTabbedPaneMain) {
        this.jTabbedPaneMain = jTabbedPaneMain;
    }

    public JPanel getjPanelTab1() {
        return jPanelTabNew;
    }

    public void setjPanelTab1(JPanel jPanelTab1) {
        this.jPanelTabNew = jPanelTab1;
    }

    public JPanel getjPanelTab2() {
        return jPanelTabModify;
    }

    public void setjPanelTab2(JPanel jPanelTab2) {
        this.jPanelTabModify = jPanelTab2;
    }//GEN-LAST:event_jButtonModifyOKActionPerformed

    private void jTextFieldSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyPressed
        char ch = evt.getKeyChar();
        if( ch == '\n' ){
            logic.filterDirectors(jTextFieldSearch.getText().toLowerCase().trim().replace("'", "''"));
            model.updateTable();
        }
    }//GEN-LAST:event_jTextFieldSearchKeyPressed

    private void jButtonDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDeleteMouseClicked
        int[] toDeleteView = jTableDirectors.getSelectedRows(); //jtable nézeti indexek
        if( toDeleteView.length!=0 ) {
            int[] toDeleteModel = new int[ toDeleteView.length ];   //jtable háttér tablemodell indexek
            for( int i=0; i<toDeleteView.length; i++) {
                toDeleteModel[i] = jTableDirectors.convertRowIndexToModel(toDeleteView[i]);
            }
            int reply = JOptionPane.showOptionDialog(rootPane, "Biztosan törölni kívánja a kijelölt rendező(ke)t?", "Törlés Megerősítése", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"Igen","Nem"}, "default");
            if(reply == 0 ) {
                logic.deleteDirectors( toDeleteModel );
            }
            model.updateTable();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nincs kijelölt rendező.", "Nincs kijelölt rendező", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDeleteMouseClicked

    private void jButtonCancel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancel3MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButtonCancel3MouseClicked

    private void jPanelTabModifyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanelTabModifyFocusGained
        if( logic.getDirectorsCount()==0 ) {
            jButtonModifiedFill.setEnabled(false);
            jButtonModifyOK.setEnabled(false);
        } else {
            jButtonModifiedFill.setEnabled(true);
            jButtonModifyOK.setEnabled(true);
        }
    }//GEN-LAST:event_jPanelTabModifyFocusGained

    private void jPanelTabListFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanelTabListFocusGained
        logic.updateDirectorsList();
        model.updateTable();
        if( logic.getDirectorsCount()==0 ) {
            jButtonDelete.setEnabled(false);
            jTextFieldSearch.setEnabled(false);
        } else {
            jButtonDelete.setEnabled(true);
            jTextFieldSearch.setEnabled(true);
        }
    }//GEN-LAST:event_jPanelTabListFocusGained

    private void jButtonCancel3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancel3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancel3ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonCancel3;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonModifiedFill;
    private javax.swing.JButton jButtonModifyCancel;
    private javax.swing.JButton jButtonModifyOK;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JComboBox jComboBoxDay;
    private javax.swing.JComboBox jComboBoxModifiedDay;
    private javax.swing.JComboBox jComboBoxModifiedDirecName;
    private javax.swing.JComboBox jComboBoxModifiedMonth;
    private javax.swing.JComboBox jComboBoxModifiedYear;
    private javax.swing.JComboBox jComboBoxMonth;
    private javax.swing.JComboBox jComboBoxYear;
    private javax.swing.JLabel jLabelDirBirth;
    private javax.swing.JLabel jLabelDirBirthPlace;
    private javax.swing.JLabel jLabelDirFirstName;
    private javax.swing.JLabel jLabelDirLastName;
    private javax.swing.JLabel jLabelInformation2;
    private javax.swing.JLabel jLabelModifiedBPlace;
    private javax.swing.JLabel jLabelModifiedBirth;
    private javax.swing.JLabel jLabelModifiedDirecName;
    private javax.swing.JLabel jLabelModifiedFName;
    private javax.swing.JLabel jLabelModifiedLName;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelinformation;
    private javax.swing.JLabel jLabelmodifyDirector;
    private javax.swing.JPanel jPanelForm;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelTab2Form;
    private javax.swing.JPanel jPanelTab2Header;
    private javax.swing.JPanel jPanelTabList;
    private javax.swing.JPanel jPanelTabModify;
    private javax.swing.JPanel jPanelTabNew;
    private javax.swing.JPanel jPanelTrailer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPaneMain;
    private javax.swing.JTable jTableDirectors;
    private javax.swing.JTextField jTextFieldDirBirthPlace;
    private javax.swing.JTextField jTextFieldDirFirstName;
    private javax.swing.JTextField jTextFieldDirLastName;
    private javax.swing.JTextField jTextFieldModifiedBPlace;
    private javax.swing.JTextField jTextFieldModifiedFName;
    private javax.swing.JTextField jTextFieldModifiedLName;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
}
