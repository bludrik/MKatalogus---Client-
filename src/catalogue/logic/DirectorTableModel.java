package catalogue.logic;

import catalogue.endpoint.DirectorItem;
import java.text.SimpleDateFormat;
import javax.swing.table.AbstractTableModel;

/**
 * Rendezőket tartalmazó tábla modellje.
 * @author Balazs
 */
public class DirectorTableModel extends AbstractTableModel {

    /**
     * Az alkalmazás vezérlését végző objektum.
     */
    private CatalogueLogic logic;
    /**
     * Az oszlopok feliratai
     */
    private String[] columnNames ={"Név ","Születési hely "," Születési idő"};
    /**
     * Születési idő formázáshoz használt dateformat.
     */
    SimpleDateFormat fmt = new SimpleDateFormat("EEE, d  MMM  yyyy");
    
    public DirectorTableModel(CatalogueLogic logic) {
        this.logic = logic;
        
    }
    
    /**
     * Visszaadja a táblázat modelljét
     * @return 
     */
    public DirectorTableModel getModel() {
        return this;
    }
    
    /**
     * Visszadja a táblázat sorainak számát.
     * @return 
     */
    @Override
    public int getRowCount() {
        return logic.getDirectorsCount();
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
     * A tábla módosulását jelzi a figyelőknek.
     */
    public void updateTable() {
        fireTableDataChanged();
    }
    
    /**
     * Visszaadja a paraméterek által meghatározott cella értékét.
     * @param rowIndex
     * @param columnIndex
     * @return 
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DirectorItem d = logic.getDirector(rowIndex);
        switch (columnIndex) {
            
            case 0:
                return d.getFirstname().concat(" ").concat(d.getLastname());
            case 1:
                return d.getBirthplace();
            case 2:
                return fmt.format(d.getBirth().toGregorianCalendar().getTime());
            default:
                return null;
        }
        
    }
    
//    @Override
//    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//        DirectorItem director= logic.getDirector(rowIndex);
//       
//        switch (columnIndex) {
//            case 0: 
//                break;
//            case 1:
//                break;
//            case 2:
//                break;
//            case 3:   
//                break;
//        }
//        fireTableCellUpdated(rowIndex, columnIndex);
//    }
//    
    /**
     * Visszadja a paraméterek által meghatározott cella szerkeszthetőségét.
     * @param rowIndex
     * @param ColumnIndex
     * @return 
     */
    @Override
    public boolean isCellEditable(int rowIndex, int ColumnIndex) {
        return false;
    }
}
