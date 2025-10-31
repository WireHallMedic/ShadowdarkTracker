package ShadowdarkTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CharacterPanel extends SDTPanel implements ActionListener, KeyListener
{
   public static final double SMALL_ELEMENT_WIDTH = .05;
   public static final double MEDIUM_ELEMENT_WIDTH = SMALL_ELEMENT_WIDTH * 2;
   public static final int MAX_CHECK_BOXES = 10;
   public static final Insets BUTTON_MARGINS = new Insets(1, 1, 1, 1);
   
   private JButton clearB;
   private JTextField nameF;
   private JTextField luckPointsF;
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
         clear();
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
      double nameFWidth = 1.0 - ((SMALL_ELEMENT_WIDTH + MEDIUM_ELEMENT_WIDTH) * 2);
      arrangeElement(clearB,        0.0, 0.0, SMALL_ELEMENT_WIDTH, 1.0);
      arrangeElement(nameF,         SMALL_ELEMENT_WIDTH, 0.0, nameFWidth, 1.0);
      arrangeElement(luckPointsF,   SMALL_ELEMENT_WIDTH + nameFWidth, 0, MEDIUM_ELEMENT_WIDTH, 1.0);
      arrangeElement(addFPB,        1.0 - (MEDIUM_ELEMENT_WIDTH + SMALL_ELEMENT_WIDTH), 0.0, SMALL_ELEMENT_WIDTH, .5);
      arrangeElement(removeFPB,     1.0 - (MEDIUM_ELEMENT_WIDTH + SMALL_ELEMENT_WIDTH), .5, SMALL_ELEMENT_WIDTH, .5);
      arrangeElement(hasActedCB,    1.0 - MEDIUM_ELEMENT_WIDTH, 0.0, MEDIUM_ELEMENT_WIDTH, 1.0);
   }
}