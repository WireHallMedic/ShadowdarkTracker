package ShadowdarkTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RowPanel extends SDTPanel
{
   private CharacterPanel characterPanel;
   private JTextField conditionF;
   public static final double CHARACTER_PANEL_WIDTH = .5;
   
   public RowPanel()
   {
      super();
      characterPanel = new CharacterPanel(this);
      add(characterPanel);
      conditionF = new JTextField();
      add(conditionF);
   }
   
   public void clearAll()
   {
      characterPanel.clear();
      conditionF.setText("");
   }
   
   public void arrangeElements()
   {
      arrangeElement(characterPanel, 0.0, 0.0, CHARACTER_PANEL_WIDTH, 1.0);
      arrangeElement(conditionF, CHARACTER_PANEL_WIDTH, 0.0, 1.0 - CHARACTER_PANEL_WIDTH, 1.0);
   }
}