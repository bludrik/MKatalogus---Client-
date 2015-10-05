package catalogue.logic;

import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Képet megjelenítő egyéni cellaformázó osztály. A Táblázatban való képmegjelenítéshez szükséges.
 * @author Balázs
 */
public class ImageColumnRenderer extends DefaultTableCellRenderer{
    
    JLabel label = new JLabel();

    @Override
    public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected,boolean hasFocus, int row, int column)
    {
        if (value!=null) {
            label.setHorizontalAlignment(JLabel.CENTER);
            //value is parameter which filled by byteOfImage
            label.setIcon(new ImageIcon((Image)value));   
        }
        return label;
    }

}
