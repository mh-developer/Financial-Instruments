
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mh7860
 */
public class Naloga14 {
    public static void main(String[] args) {
        
        
        JFrame okno = new JFrame("Swing okno");
        okno.setLayout(null);
        
        JPanel p = new JPanel();
        
        JButton b = new JButton("+5");
        JTextField f = new JTextField("0");
        
        
        b.setLocation(50, 50);
        b.setSize(100, 50);
        
        okno.add(b);
        
        
        f.setLocation(200, 50);
        f.setSize(100, 50);
        okno.add(f);
        
        okno.setSize(400, 400);
        okno.setVisible(true);
        
    }
}
