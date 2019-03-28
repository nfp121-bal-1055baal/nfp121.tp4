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
        boutonA.addActionListener(new JButtonObserver("jbo1",contenu));
        boutonA.addActionListener(new JButtonObserver("jbo2",contenu));
        boutonA.addActionListener(new JButtonObserver("jbo3",contenu));
        //addition des ActionListeners du bouton B
        boutonB.addActionListener(new JButtonObserver("jbo1",contenu));
        boutonB.addActionListener(new JButtonObserver("jbo2",contenu));
        //addition de l'ActionListeners du bouton C
        boutonC.addActionListener(new JButtonObserver("jbo1",contenu));
        // à compléter pour la question 2_2 (JMouseObserver)
        boutonA.addMouseListener(new JMouseObserver("jmo1",contenu));
        boutonB.addMouseListener(new JMouseObserver("jmo1",contenu));
        boutonC.addMouseListener(new JMouseObserver("jmo1",contenu));
        
    }
    
     public static void main(String[] args){
        new IHMQuestion2_1();
        new IHMQuestion2_2();
    }


}
