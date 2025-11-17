package ScrollOfTracking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class SoTFrame extends JFrame
{
   private TimerPanel timerPanel;
   private RowPanel[] rowPanel;
   private JPanel backgroundPanel;
   private ControlPanel controlPanel;
   private javax.swing.Timer timer;
   public static final Insets INSETS = new Insets(2, 2, 2, 2);
   public static final String FILE_NAME = "SoT.dat";
   
   public static final int CHARACTER_PANELS = 13;
   
   public SoTFrame()
   {
      super();
      setSize(1400, 800);
      setTitle("Scroll of Tracking");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      timer = new javax.swing.Timer(1000, null);
      
      backgroundPanel = new JPanel();
      add(backgroundPanel);
      backgroundPanel.setLayout(new GridLayout(CHARACTER_PANELS + 3, 1));
      timerPanel = new TimerPanel(timer, this);
      backgroundPanel.add(timerPanel);
      
      backgroundPanel.add(new RowTitlePanel());
      
      rowPanel = new RowPanel[CHARACTER_PANELS];
      for(int i = 0; i < CHARACTER_PANELS; i++)
      {
         rowPanel[i] = new RowPanel();
         backgroundPanel.add(rowPanel[i]);
      }
      
      controlPanel = new ControlPanel(this);
      backgroundPanel.add(controlPanel);
      
      timer.start();
      setPanelBackgrounds(Color.WHITE);
      setVisible(true);
   }
   
   public void newRound()
   {
      for(int i = 0; i < CHARACTER_PANELS; i++)
      {
         rowPanel[i].newRound();
      }
   }
   
   public void clearAll()
   {
      for(int i = 0; i < CHARACTER_PANELS; i++)
      {
         rowPanel[i].clearAll();
      }
   }
   
   public void setPanelBackgrounds(Color c)
   {
      if(backgroundPanel != null)
         backgroundPanel.setBackground(c);
      if(rowPanel != null)
      {
         for(RowPanel curPanel : rowPanel)
         {
            if(curPanel != null)
            {
               curPanel.setBackground(c);
               curPanel.repaint();
            }
         }
      }
      if(controlPanel != null)
         controlPanel.setBackground(c);
      repaint();
   }
   
   public void save()
   {
      String[] output = new String[CHARACTER_PANELS + 1];
      output[0] = timerPanel.serialize();
      for(int i = 0; i < CHARACTER_PANELS; i++)
         output[i + 1] = rowPanel[i].serialize();
      write(output);
   }
   
   public void load()
   {
   
   }
   
  public static void write(String[] output)
	{
		PrintWriter outFile = null;
		try
		{
			outFile = new PrintWriter(FILE_NAME);
		}
		catch(Exception ex)
		{
			String errorMessage = "Error: Cannot write to " + FILE_NAME;
			JOptionPane.showMessageDialog(null, errorMessage, "Exception Occured", JOptionPane.ERROR_MESSAGE);
		}
		
		for(String line : output)
			outFile.println(line);
			
		outFile.close();
	}
}