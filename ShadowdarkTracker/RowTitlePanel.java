package ShadowdarkTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RowTitlePanel extends SDTPanel
{
   private CharacterTitlePanel characterTitlePanel;
   private JLabel conditionL;
   public static final double CHARACTER_PANEL_WIDTH = RowPanel.CHARACTER_PANEL_WIDTH;
   
   public RowTitlePanel()
   {
      super();
      characterTitlePanel = new CharacterTitlePanel();
      add(characterTitlePanel);
      conditionL = new JLabel("Conditions, Notes, Etc.");
      add(conditionL);
   }
   
   public void arrangeElements()
   {
      arrangeElement(characterTitlePanel, 0.0, 0.0, CHARACTER_PANEL_WIDTH, 1.0);
      arrangeElement(conditionL, CHARACTER_PANEL_WIDTH, 0.0, 1.0 - CHARACTER_PANEL_WIDTH, 1.0);
   }
   
   @Override
   public int calcFontSize(JComponent c)
   {
      int pixelSize = Math.min(c.getWidth(), c.getHeight());
      if(c instanceof JButton)
         pixelSize = (int)(pixelSize * BUTTON_FONT_SCALE);
      else
         pixelSize = (int)(pixelSize * (TEXT_FONT_SCALE / 2));
      return pixelSize;
   }
}