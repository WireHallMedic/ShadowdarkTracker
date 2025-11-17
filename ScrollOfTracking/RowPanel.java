package ScrollOfTracking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RowPanel extends SoTPanel
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
      setBackground(Color.WHITE);
      add(conditionF);
   }
   
   public void clearAll()
   {
      characterPanel.clear();
      conditionF.setText("");
   }
   
   public void newRound()
   {
      characterPanel.newRound();
   }
   
   public void arrangeElements()
   {
      arrangeElement(characterPanel, 0.0, 0.0, CHARACTER_PANEL_WIDTH, 1.0);
      arrangeElement(conditionF, CHARACTER_PANEL_WIDTH, 0.0, 1.0 - CHARACTER_PANEL_WIDTH, 1.0);
   }
   
   @Override
   public void setBackground(Color c)
   {
      super.setBackground(c);
      if(characterPanel != null)
         characterPanel.setBackground(c);
   }
   
   public String serialize()
   {
      String outStr = characterPanel.serialize();
      // extra space so there's something after the delimiter for blank fields
      outStr += DELIMITER + conditionF.getText() + " ";
      return outStr;
   }
   
   public void deserialize(String str)
   {
      characterPanel.deserialize(str);
      String[] strList = str.split(DELIMITER);
      conditionF.setText(strList[strList.length - 1].trim());
   }
}