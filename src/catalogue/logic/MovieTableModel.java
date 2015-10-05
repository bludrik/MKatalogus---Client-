package catalogue.logic;

import catalogue.endpoint.MovieSubItem;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.table.AbstractTableModel;


/**
 * TableModell osztály a filmeket tartalmazó táblázathoz.
 * @author Ludrik Balazs
 */
public class MovieTableModel extends AbstractTableModel {
    
    
    
    /**
     * Az alkalmazás vezérlését végző objektum.
     */
    private CatalogueLogic logic;
    /**
     * Az oszlopok feliratai
     */
    private String[] columnNames ={"Azonosító","Cím","Kiadás", "Adathordozó"};
    
    /**
     * Visszaadja a táblázat által használt modellt.
     * @return 
     */
    public MovieTableModel getModel() {
        return this;
    }
    
    /**
     * Konstruktor
     * @param logic     az alkalmazás logikáját reprezentáló objektum 
     */
    public MovieTableModel(CatalogueLogic logic) {
        this.logic = logic;
    }
    
    /**
     * Visszaadja a táblázat sorainak számát.
     * @return 
     */
    @Override
    public int getRowCount() {
        return logic.getMoviesCount();
    }

    /**
     * Visszadja a táblázat oszlopainak számát.
     * @return 
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * Visszaadja a paraméterben kapott sorszámú oszlop nevét.
     * @param column
     * @return 
     */
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    /**
     * Visszaadja a paraméterek által meghatározott cella értékét.
     * @param rowIndex
     * @param columnIndex
     * @return 
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MovieSubItem movie = logic.getMovie( rowIndex );
        if( movie== null) {
            return null;
        }
            switch (columnIndex) {

                case 0:
                    return movie.getId();
                case 1:
                    return movie.getTitleHU();
                case 2:
                    return movie.getYear();
                case 3:
                    BufferedImage image = null;
                    try {
                        URL imageURL = this.getClass().getClassLoader().getResource(movie.getType().toLowerCase()+".png");
                        image = ImageIO.read(imageURL);                    
                    } catch (IOException e) {
                        try {
                            URL imageURL = this.getClass().getClassLoader().getResource("disk.png");
                            image = ImageIO.read(imageURL);
                        } catch (IOException ex) {
                            logic.sendMsgToUser("Hiba történt a képek betöltésekor", Color.red);
                        }
                    } catch( Exception ex) {
                        return null;
                    }
                    return image;
                default:
                    return null;
            }
      
    }
    
    /**
     * A tábla módosulását jelzi a figyelőknek.
     */
    public void updateTable() throws NullPointerException{
        if(logic.getMoviesCount()>0) {    
            fireTableDataChanged();       
        }
        else {
            fireTableRowsDeleted(0, 0);
        }
    }
    
    /**
     * Visszaadja az adott oszlop típusát.
     * @param c     az oszlop sorszáma
     * @return      az adott oszlop típusa
     */
    public Class<? extends Object> getColumnClass(int c) {
        if (getRowCount() == 0) {
            return null;
        } else if( c<5) {
            return getValueAt(0, c).getClass();
        }
        return null;
    }
    
    /**
     * Visszaadja a paraméterek által meghatározott cella szerkeszthetőségét.
     * @param rowIndex
     * @param ColumnIndex
     * @return 
     */
    @Override
    public boolean isCellEditable(int rowIndex, int ColumnIndex) {
        return false;
    }
    
}
