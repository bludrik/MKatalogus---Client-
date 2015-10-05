package catalogue.logic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 * Saját Scrollbar UI osztály.
 * @author Balazs
 */
public class MyScrollBarUI extends BasicScrollBarUI 
{
    
        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            super.thumbColor = new Color(245,245,245);
            super.trackColor = new Color(204,204,204);
            super.scrollBarWidth = 12;
            super.thumbDarkShadowColor = new Color(155,155,155);
            
            super.paintThumb(g, c, thumbBounds);      
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
            super.paintTrack(g, c, trackBounds);
        }
    
}
