package ShadowdarkTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CharacterTitlePanel extends SDTPanel
{
   public static final double SMALL_ELEMENT_WIDTH = CharacterPanel.SMALL_ELEMENT_WIDTH;
   public static final double MEDIUM_ELEMENT_WIDTH = CharacterPanel.MEDIUM_ELEMENT_WIDTH;
   
   private JLabel nameL;
   private JLabel luckL;
   private JLabel initL;
   private JLabel actedL;
   
   public CharacterTitlePanel()
   {
      super();
      nameL = new JLabel("Name", SwingConstants.CENTER);
      add(nameL);
      luckL = new JLabel("Luck", SwingConstants.CENTER);
      add(luckL);
      initL = new JLabel("Init", SwingConstants.CENTER);
      add(initL);
      actedL = new JLabel("Acted", SwingConstants.CENTER);
      add(actedL);
      
      arrangeElements();
   }
   
   
   public void arrangeElements()
   {
      double xInset = 0.0;
      double nameFWidth = 1.0 - ((SMALL_ELEMENT_WIDTH + MEDIUM_ELEMENT_WIDTH) * 2) - MEDIUM_ELEMENT_WIDTH;
      xInset += SMALL_ELEMENT_WIDTH;
      arrangeElement(nameL,         xInset, 0.0, nameFWidth, 1.0);
      xInset += nameFWidth;
      arrangeElement(luckL,         xInset, 0, MEDIUM_ELEMENT_WIDTH + SMALL_ELEMENT_WIDTH, 1.0);
      xInset += MEDIUM_ELEMENT_WIDTH + SMALL_ELEMENT_WIDTH;
      arrangeElement(initL,         xInset, 0, MEDIUM_ELEMENT_WIDTH, 1.0);
      xInset += MEDIUM_ELEMENT_WIDTH;
      arrangeElement(actedL,        xInset, 0.0, MEDIUM_ELEMENT_WIDTH, 1.0);
   }
   
   @Override
   public int calcFontSize(JComponent c)
   {
      int pixelSize = Math.min(c.getWidth(), c.getHeight());
      if(c instanceof JButton)
         pixelSize = (int)(pixelSize * (BUTTON_FONT_SCALE * .75));
      else
         pixelSize = (int)(pixelSize * (TEXT_FONT_SCALE * .75));
      return pixelSize;
   }
}