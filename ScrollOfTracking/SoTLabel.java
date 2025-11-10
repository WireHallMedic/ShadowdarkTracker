package ShadowdarkTracker;

import javax.swing.*;
import java.awt.*;

public class SDLabel extends JLabel
{
   public SDLabel(){this("", SwingConstants.CENTER);}
   public SDLabel(String str){this(str, SwingConstants.CENTER);}
   
   SDLabel(String str, int horizAlign)
   {
      super(str, horizAlign);
      setForeground(Color.WHITE);
      setBackground(Color.BLACK);
      setOpaque(true);
   }
}