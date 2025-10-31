package ShadowdarkTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SDTFrame extends JFrame implements ActionListener
{
   private TimerPanel timerPanel;
   private CharacterPanel[] characterPanel;
   private SDTPanel controlPanel;
   private javax.swing.Timer timer;
   
   public static final int CHARACTER_PANELS = 13;
   
   public SDTFrame()
   {
      super();
      setSize(800, 500);
      setTitle("ShadowdarkTracker");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      timer = new javax.swing.Timer(1000, null);
      timer.start();
      
      setLayout(new GridLayout(CHARACTER_PANELS + 2, 1));
      timerPanel = new TimerPanel(timer);
      add(timerPanel);
      
      characterPanel = new CharacterPanel[CHARACTER_PANELS];
      for(CharacterPanel curPanel : characterPanel)
      {
         curPanel = new CharacterPanel();
         add(curPanel);
      }
      
      
      setVisible(true);
   }
   
   public void actionPerformed(ActionEvent ae)
   {
   
   }
}