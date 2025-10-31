package ShadowdarkTracker;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TimerPanel extends SDTPanel implements ActionListener
{
	private int curTime;
	private int maxTime;
	private boolean runF;
	private JTextField timeF;
	private JButton runB;
	private JButton resetB;
   private javax.swing.Timer timer;
   private static final int BASE_RED = 0xFF;
   private static final int BASE_GREEN = 0xD7;
   private static final int BASE_BLUE = 0x00;


	public int getCurTime(){return curTime;}
	public int getMaxTime(){return maxTime;}
	public boolean isRunF(){return runF;}
	public JTextField getTimeF(){return timeF;}
	public JButton getRunB(){return runB;}
	public JButton getResetB(){return resetB;}


	public void setCurTime(int c){curTime = c;}
	public void setMaxTime(int m){maxTime = m;}
	public void setRunF(boolean r){runF = r;}
	public void setTimeF(JTextField t){timeF = t;}
	public void setRunB(JButton r){runB = r;}
	public void setResetB(JButton r){resetB = r;}

   public TimerPanel(javax.swing.Timer t)
   {
      maxTime = 30;//60*60;
      runF = false;
      timeF = new JTextField("");
      timeF.setHorizontalAlignment(SwingConstants.CENTER);
      runB = new JButton("Start");
      resetB = new JButton("Reset");
      add(timeF);
      add(runB);
      runB.addActionListener(this);
      add(resetB);
      resetB.addActionListener(this);
      arrangeElements();
      timer = t;
      timer.addActionListener(this);
      resetTime();
      displayTime();
   }
   
   public void resetTime()
   {
      curTime = maxTime;
   }
   
   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource() == timer)
      {
         if(runF)
         {
            curTime = Math.max(curTime - 1, 0);
         }
      }
      if(ae.getSource() == runB)
      {
         runF = !runF;
         if(runF)
         {
            curTime = getTimeInt();
            runB.setText("Pause");
         }
         else
            runB.setText("Start");
      }
      if(ae.getSource() == resetB)
      {
         resetTime();
         displayTime();
      }
      if(runF)
         displayTime();
   }
   
   public void displayTime()
   {
      timeF.setText(getTimeString());
      this.setBackground(getLightColor());
   }
   
   public Color getLightColor()
   {
      double intensity = 0.0;
      // use the first quarter of cosine to stay light longer
      if(curTime > 0)
      {
         intensity = 1.0 - ((double)curTime / (double)maxTime);
         intensity = Math.cos(intensity * Math.PI / 2.0);
         // shut off the lights at the end, smooth is dark too soon
         if(curTime > 0)
            intensity = Math.min(1.0, intensity + .25);
      }
      int r = (int)(BASE_RED * intensity);
      int g = (int)(BASE_GREEN * intensity);
      int b = (int)(BASE_BLUE * intensity);
      return new Color(r, g, b);
   }
   
   public void arrangeElements()
   {
      arrangeElement(timeF, .15, 0.1, .2, .8);
      arrangeElement(runB, .4, 0.1, .2, .8);
      arrangeElement(resetB, .65, 0.1, .2, .8);
   }
   
   public String getTimeString()
   {
      int min = curTime / 60;
      int sec = curTime % 60;
      return String.format("%d:%02d", min, sec);
   }
   
   public int getTimeInt()
   {
      try
      {
         int min = Integer.parseInt(timeF.getText().split(":")[0]);
         int sec = Integer.parseInt(timeF.getText().split(":")[1]);
         return (min * 60) + sec;
      }
      catch(Exception ex){}
      return maxTime;
   }
}