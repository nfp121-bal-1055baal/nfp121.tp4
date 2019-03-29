
package question3;

import question3.tp3.PileI;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Décrivez votre classe Controleur ici.
 * 
 * @Antonio Semaan (votre nom)
 * @29-3-2019 (un numéro de version ou une date)
 */
public class Controleur extends JPanel {

    private JButton push, add, sub, mul, div, clear;
    private PileModele<Integer> pile;
    private JTextField donnee;

    public Controleur(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);

        this.push = new JButton("push");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");

        setLayout(new GridLayout(2, 1));
        add(donnee);
        donnee.addActionListener(null /* null est à remplacer */);
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
        boutons.add(push);  push.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    
                    pile.empiler(new Integer(Integer.parseInt(donnee.getText().toString())));
                    
                    toggleButtons();
                }
                catch(PilePleineException ex){
                    ex.printStackTrace();
                }
                catch(NumberFormatException ex){
                    ex.printStackTrace();
                }
            }
        });
        boutons.add(add);   add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    pile.empiler(pile.depiler() + pile.depiler());
                    toggleButtons();
                }
                catch(PileVideException ex1){
                    ex1.printStackTrace();
                }
                catch(PilePleineException ex2){
                    ex2.printStackTrace();
                }
            }
        });
        add.setEnabled(false);
        boutons.add(sub);   sub.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    Integer i1 = pile.depiler();
                    Integer i2 = pile.depiler();
                    pile.empiler(i2 - i1);
                    toggleButtons();
                }
                catch(PileVideException ex1){
                    ex1.printStackTrace();
                }
                catch(PilePleineException ex2){
                    ex2.printStackTrace();
                }
            }
        });
        sub.setEnabled(false);
        boutons.add(mul);   mul.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    pile.empiler(pile.depiler() * pile.depiler());
                    toggleButtons();
                }
                catch(PileVideException ex1){
                    ex1.printStackTrace();
                }
                catch(PilePleineException ex2){
                    ex2.printStackTrace();
                }
            }
        });
        mul.setEnabled(false);
        boutons.add(div);   div.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    Integer i1 = pile.depiler();
                    Integer i2 = pile.depiler();
                    if(i1==0){
                        pile.empiler(i2);
                        pile.empiler(i1);
                    }else{
                        pile.empiler(i2/i1);
                    }
                    toggleButtons();
                }
                catch(PileVideException ex1){
                    ex1.printStackTrace();
                }
                catch(PilePleineException ex2){
                    ex2.printStackTrace();
                }
            }
        });
        div.setEnabled(false);
        boutons.add(clear); clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    int taille=pile.taille();
                    for(int i=0;i<taille;i++)
                        pile.depiler();
                    toggleButtons();
                }
                catch(PileVideException ex){
                    ex.printStackTrace();
                }
            }
        });
        add(boutons);
        boutons.setBackground(Color.red);
        actualiserInterface();
    }

    public void actualiserInterface() {
        // à compléter
    }

    private Integer operande() throws NumberFormatException {
        return Integer.parseInt(donnee.getText());
    }

    // à compléter
    // en cas d'exception comme division par zéro, 
    // mauvais format de nombre suite à l'appel de la méthode operande
    // la pile reste en l'état (intacte)
    private void toggleButtons(){
        if(pile.taille()<2){
            add.setEnabled(false);
            sub.setEnabled(false);
            mul.setEnabled(false);
            div.setEnabled(false);
        }else{
            add.setEnabled(true);
            sub.setEnabled(true);
            mul.setEnabled(true);
            div.setEnabled(true);
        }
    }
}
