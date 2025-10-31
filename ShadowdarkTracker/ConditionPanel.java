package ShadowdarkTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConditionPanel extends SDTPanel implements ActionListener
{
   public static final double SMALL_ELEMENT_WIDTH = .1;
   public static final int MAX_CHECK_BOXES = 10;
   public static final Insets BUTTON_MARGINS = new Insets(1, 1, 1, 1);
   
   private JButton clearB;
   private JTextField aspectF;
   private JButton addUseB;
   private JButton removeUseB;
   private JCheckBox[] checkBoxArr;
   private int curCheckBoxes;
   
   public ConditionPanel()
   {
      super();
      curCheckBoxes = 0;
      clearB = new JButton("X");
      aspectF = new JTextField("");
      addUseB = new JButton("+");
      removeUseB = new JButton("-");
      checkBoxArr = new JCheckBox[MAX_CHECK_BOXES];
      for(int i = 0; i < MAX_CHECK_BOXES; i++)
      {
         checkBoxArr[i] = new JCheckBox();
      }
      
      setVisible(true);
      
      clearB.setMargin(BUTTON_MARGINS);
      addUseB.setMargin(BUTTON_MARGINS);
      removeUseB.setMargin(BUTTON_MARGINS);
      
      add(clearB);
      add(aspectF);
      add(addUseB);
      add(removeUseB);
      
      addUseB.addActionListener(this);
      removeUseB.addActionListener(this);
      clearB.addActionListener(this);
      for(int i = 0; i < MAX_CHECK_BOXES; i++)
      {
         this.add(checkBoxArr[i]);
      }
      
      arrangeElements();
   }
   
   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource() == addUseB)
      {
         if(curCheckBoxes < MAX_CHECK_BOXES)
            curCheckBoxes++;
      }
      if(ae.getSource() == removeUseB)
      {
         if(curCheckBoxes > 0)
            curCheckBoxes--;
      }
      if(ae.getSource() == clearB)
      {
         clear();
      }
      arrangeElements();
   }
   
   public void clear()
   {
      curCheckBoxes = 0;
      aspectF.setText("");
      for(int i = 0; i < MAX_CHECK_BOXES; i++)
      {
         checkBoxArr[i].setSelected(false);
      }
      arrangeElements();
   }
   
   private String serializeCheckBoxes()
   {
      String str = "";
      for(JCheckBox box : checkBoxArr)
      {
         if(box.isSelected())
            str += "t";
         else
            str += "f";
      }
      return str;
   }
   
   public String serialize()
   {
      return aspectF.getText() + " " + DELIMITER + curCheckBoxes + DELIMITER + serializeCheckBoxes();
   }
   
   public void deserialize(String str)
   {
      String[] strArr = str.split(DELIMITER);
      aspectF.setText(strArr[0].strip());
      curCheckBoxes = Integer.parseInt(strArr[1]);
      for(int i = 0; i < MAX_CHECK_BOXES; i++)
      {
         if(strArr[2].charAt(i) == 't')
            checkBoxArr[i].setSelected(true);
         else
            checkBoxArr[i].setSelected(false);
      }
      arrangeElements();
   }
   
   public void arrangeElements()
   {
      double aspectFieldWidth = 1.0 - (SMALL_ELEMENT_WIDTH * 2) - (SMALL_ELEMENT_WIDTH * curCheckBoxes);
      double aspectFieldXInset = SMALL_ELEMENT_WIDTH;
      arrangeElement(clearB,     0.0, 0.0, SMALL_ELEMENT_WIDTH, 1.0);
      arrangeElement(aspectF,    aspectFieldXInset, 0.0, aspectFieldWidth, 1.0);
      arrangeElement(addUseB,    1.0 - SMALL_ELEMENT_WIDTH, 0, SMALL_ELEMENT_WIDTH, .5);
      arrangeElement(removeUseB, 1.0 - SMALL_ELEMENT_WIDTH, .5, SMALL_ELEMENT_WIDTH, .5);
      
      for(int i = 0; i < MAX_CHECK_BOXES; i++)
      {
         double xLoc = -1.0;
         double yLoc = -1.0;
         if(i < curCheckBoxes)
         {
            xLoc = aspectFieldWidth + aspectFieldXInset + (SMALL_ELEMENT_WIDTH * i);
            yLoc = 0.0;
         }
         arrangeElement(checkBoxArr[i], xLoc, yLoc, SMALL_ELEMENT_WIDTH, 1.0);
      }
   }
}