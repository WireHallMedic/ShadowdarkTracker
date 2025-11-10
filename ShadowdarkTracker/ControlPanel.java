package ShadowdarkTracker;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ControlPanel extends SDTPanel implements ActionListener
{
   private JButton newRoundB;
   private JButton clearAllB;
   private JButton saveB;
   private JButton loadB;
   
   public ControlPanel()
   {
      super();
      newRoundB = new JButton("New Round");
      add(newRoundB);
      clearAllB = new JButton("Clear All");
      add(clearAllB);
      saveB = new JButton("Save");
      add(saveB);
      loadB = new JButton("Load");
      add(loadB);
   }
   
   public void arrangeElements()
   {
      arrangeElement(newRoundB, .025, 0.1, .2, .8);
      arrangeElement(clearAllB, .275, 0.1, .2, .8);
      arrangeElement(saveB, .515, 0.1, .2, .8);
      arrangeElement(loadB, .775, 0.1, .2, .8);
   }
   
   public void actionPerformed(ActionEvent ae)
   {

   }
}