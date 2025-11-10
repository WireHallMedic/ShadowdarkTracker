package ShadowdarkTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SDTFrame extends JFrame implements ActionListener
{
   private TimerPanel timerPanel;
   private RowPanel[] rowPanel;
   private SDTPanel controlPanel;
   private JPanel backgroundPanel;
   private javax.swing.Timer timer;
   public static final Insets INSETS = new Insets(2, 2, 2, 2);
   
   public static final int CHARACTER_PANELS = 13;
   
   public SDTFrame()
   {
      super();
      setSize(1400, 800);
      setTitle("ShadowdarkTracker");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      timer = new javax.swing.Timer(1000, null);
      
      backgroundPanel = new JPanel();
      add(backgroundPanel);
      backgroundPanel.setLayout(new GridLayout(CHARACTER_PANELS + 3, 1));
      timerPanel = new TimerPanel(timer);
      backgroundPanel.add(timerPanel);
      
      backgroundPanel.add(new RowTitlePanel());
      
      rowPanel = new RowPanel[CHARACTER_PANELS];
      for(RowPanel curPanel : rowPanel)
      {
         curPanel = new RowPanel();
         backgroundPanel.add(curPanel);
      }
      
      timer.start();
      setPanelBackgrounds(Color.WHITE);
      setVisible(true);
   }
   
   public void setPanelBackgrounds(Color c)
   {
      if(backgroundPanel != null)
         backgroundPanel.setBackground(c);
      for(RowPanel curPanel : rowPanel)
         if(curPanel != null)
            curPanel.setBackground(c);
   }
   
   public void actionPerformed(ActionEvent ae)
   {
   
   }
}