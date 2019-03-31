package question2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IHMQuestion2_2 extends JFrame {

    private JButton boutonA = new JButton("A");
    private JButton boutonB = new JButton("B");
    private JButton boutonC = new JButton("C");

    private TextArea contenu = new TextArea(30, 80);

    private static int i=0;
 
    public IHMQuestion2_2() {
        super("IHM Question2_2");
        JPanel enHaut = new JPanel();
        enHaut.add(boutonA);
        enHaut.add(boutonB);
        enHaut.add(boutonC);
        setLayout(new BorderLayout(5, 5));
        add("North", enHaut);
        add("Center", contenu); // contenu sera transmis aux observateurs, voir
                                // la description des constructeurs
        setLocation(150,150);pack();show();
        enHaut.setBackground(Color.magenta);
        

        //addition des ActionListeners du bouton A
        JButtonObserver jbo1 = new JButtonObserver("jbo1",contenu);
        JButtonObserver jbo2 = new JButtonObserver("jbo2",contenu);
        JButtonObserver jbo3 = new JButtonObserver("jbo3",contenu);
        //addition des ActionListeners du bouton A
        boutonA.addActionListener(jbo1);
        boutonA.addActionListener(jbo2);
        boutonA.addActionListener(jbo3);
        //addition des ActionListeners du bouton B
        boutonB.addActionListener(jbo1);
        boutonB.addActionListener(jbo2);
        //addition de l'ActionListeners du bouton C
        boutonC.addActionListener(jbo1);
        // à compléter pour la question 2_2 (JMouseObserver)
        JMouseObserver jmo1 = new JMouseObserver("jmo1",contenu);
        boutonA.addMouseListener(jmo1);
        boutonB.addMouseListener(jmo1);
        boutonC.addMouseListener(jmo1);
        
    }
    
     public static void main(String[] args){
        new IHMQuestion2_1();
        new IHMQuestion2_2();
    }


}
