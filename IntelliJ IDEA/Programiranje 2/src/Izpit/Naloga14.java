package Izpit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Naloga14 {
    public static void main(String[] args) {
        JFrame okno = new JFrame("Swing naloga");

        okno.setLayout(null);

        JButton gumb = new JButton("+5");
        JTextField polje = new JTextField("0");
        JPanel list = new JPanel();

        gumb.setSize(100, 40);
        gumb.setLocation(100, 25);
        okno.add(gumb);

        polje.setSize(200, 40);
        polje.setLocation(210, 25);
        okno.add(polje);


        gumb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Integer stevec = Integer.parseInt(polje.getText());
                polje.setText((stevec += 5).toString());
            }
        });


        list.setSize(500, 400);
        list.setLocation(0, 75);
        list.setBorder(BorderFactory.createTitledBorder("Premikanje miške"));
        list.setBackground(Color.GREEN);
        okno.add(list);

        list.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                if (mouseEvent.getX() < 166) {
                    list.setBackground(Color.GREEN);
                } else if (166 < mouseEvent.getX() && mouseEvent.getX() < 166 * 2) {
                    list.setBackground(Color.BLUE);
                } else {
                    list.setBackground(Color.RED);
                }
            }
        });

        okno.setSize(500, 500);
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setLocation(800, 100);
        okno.setVisible(true);
    }
}
