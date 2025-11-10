package ShadowdarkTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CharacterPanel extends SDTPanel implements ActionListener, KeyListener
{
   public static final double SMALL_ELEMENT_WIDTH = .05;
   public static final double MEDIUM_ELEMENT_WIDTH = SMALL_ELEMENT_WIDTH * 2;
   public static final Insets BUTTON_MARGINS = new Insets(1, 1, 1, 1);
   
   private JButton clearB;
   private JTextField nameF;
   private JTextField luckPointsF;
   private JTextField initF;
   private JButton addFPB;
   private JButton removeFPB;
   private JCheckBox hasActedCB;
   private int luckPoints;
   private RowPanel parent;
   
   public CharacterPanel(RowPanel rowPanel)
   {
      super();
      luckPoints = 0;
      clearB = new JButton("X");
      nameF = new JTextField("");
      luckPointsF = new JTextField("0");
      luckPointsF.setHorizontalAlignment(JTextField.CENTER);
      luckPointsF.setEditable(false);
      addFPB = new JButton("+");
      removeFPB = new JButton("-");
      initF = new JTextField("");
      add(initF);
      hasActedCB = new JCheckBox();
      hasActedCB.setHorizontalAlignment(JTextField.CENTER);
      parent = rowPanel;
      
      setVisible(true);
      
      clearB.setMargin(BUTTON_MARGINS);
      addFPB.setMargin(BUTTON_MARGINS);
      removeFPB.setMargin(BUTTON_MARGINS);
      
      add(clearB);
      add(nameF);
      add(luckPointsF);
      add(addFPB);
      add(removeFPB);
      add(hasActedCB);
      
      addFPB.addActionListener(this);
      removeFPB.addActionListener(this);
      clearB.addActionListener(this);
      nameF.addKeyListener(this);
      
      arrangeElements();
   }
   
   @Override
   public void setBackground(Color c)
   {
      super.setBackground(c);
      if(hasActedCB != null)
         hasActedCB.setBackground(c);
   }
   
   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource() == addFPB)
      {
         luckPoints++;
      }
      if(ae.getSource() == removeFPB)
      {
         if(luckPoints > 0)
            luckPoints--;
      }
      if(ae.getSource() == clearB)
      {
         parent.clearAll();
      }
      arrangeElements();
   }
   
   public void keyPressed(KeyEvent ke){}
   public void keyTyped(KeyEvent ke){}
   public void keyReleased(KeyEvent ke)
   {
      updateFatePointsField();
   }
   
   public void clear()
   {
      luckPoints = 0;
      nameF.setText("");
      initF.setText("");
      newRound();
      arrangeElements();
   }
   
   public void newRound()
   {
      hasActedCB.setSelected(false);
   }
   
   public void updateFatePointsField()
   {
      if(nameF.getText().equals(""))
      {
         luckPointsF.setText("");
      }
      else
      {
         luckPointsF.setText("" + luckPoints);
      }
   }
   
   public String serialize()
   {
      String name = nameF.getText();
      String hasActed = "f";
      if(hasActedCB.isSelected())
         hasActed = "t";
      return name + DELIMITER + luckPoints + DELIMITER + hasActed;
   }
   
   public void deserialize(String str)
   {
      String[] strArr = str.split(DELIMITER);
      nameF.setText(strArr[0]);
      luckPoints = Integer.parseInt(strArr[1]);
      if(strArr[2].equals("t"))
         hasActedCB.setSelected(true);
      else
         hasActedCB.setSelected(false);
      arrangeElements();
   }
   
   public void arrangeElements()
   {
      updateFatePointsField();
      double xInset = 0.0;
      double nameFWidth = 1.0 - ((SMALL_ELEMENT_WIDTH * 2) + (MEDIUM_ELEMENT_WIDTH * 3));
      arrangeElement(clearB,        0.0, 0.0, SMALL_ELEMENT_WIDTH, 1.0);
      xInset += SMALL_ELEMENT_WIDTH;
      arrangeElement(nameF,         xInset, 0.0, nameFWidth, 1.0);
      xInset += nameFWidth;
      arrangeElement(luckPointsF,   xInset, 0, MEDIUM_ELEMENT_WIDTH, 1.0);
      xInset += MEDIUM_ELEMENT_WIDTH;
      arrangeElement(addFPB,        xInset, 0.0, SMALL_ELEMENT_WIDTH, .5);
      arrangeElement(removeFPB,     xInset, .5, SMALL_ELEMENT_WIDTH, .5);
      xInset += SMALL_ELEMENT_WIDTH;
      arrangeElement(initF,   xInset, 0, MEDIUM_ELEMENT_WIDTH, 1.0);
      xInset += MEDIUM_ELEMENT_WIDTH;
      arrangeElement(hasActedCB,    xInset, 0.0, MEDIUM_ELEMENT_WIDTH, 1.0);
   }
}