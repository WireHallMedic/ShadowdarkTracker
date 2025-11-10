package ShadowdarkTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RowTitlePanel extends SDTPanel
{
   private CharacterTitlePanel characterTitlePanel;
   private SDLabel conditionL;
   public static final double CHARACTER_PANEL_WIDTH = RowPanel.CHARACTER_PANEL_WIDTH;
   
   public RowTitlePanel()
   {
      super();
      characterTitlePanel = new CharacterTitlePanel();
      add(characterTitlePanel);
      conditionL = new SDLabel("Conditions, Notes, Etc.");
      add(conditionL);
      setBackground(Color.BLACK);
   }
   
   public void arrangeElements()
   {
      arrangeElement(characterTitlePanel, 0.0, 0.0, CHARACTER_PANEL_WIDTH, 1.0);
      arrangeElement(conditionL, CHARACTER_PANEL_WIDTH, 0.0, 1.0 - CHARACTER_PANEL_WIDTH, 1.0);
   }
   
}