package Izpit.resitve;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author tomaz
 */
public class Naloga14 {

  public static void main(String[] args) {
    JFrame okno = new JFrame("Swing okno");

    JButton gumb1 = new JButton("+5");
    final JTextField jtf = new JTextField("0");
    jtf.setColumns(10);

    JPanel p1 = new JPanel();
    p1.add(gumb1);
    p1.add(jtf);

    final JPanel p2 = new JPanel();
    p2.setBorder(BorderFactory.createTitledBorder("Premikanje miške"));

    okno.add(p1, BorderLayout.PAGE_START);
    okno.add(p2);

    gumb1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        jtf.setText(Integer.toString(Integer.parseInt(jtf.getText()) + 5));
      }
    });

    p2.addMouseMotionListener(new MouseAdapter() {
      @Override
      public void mouseMoved(MouseEvent e) {
        int x = p2.getWidth();
        if (e.getX() < x / 3) {
          p2.setBackground(Color.green);
        } else if (e.getX() < 2 * x / 3) {
          p2.setBackground(Color.blue);
        } else {
          p2.setBackground(Color.red);
        }
      }
    });

    okno.setSize(300, 300);
    okno.setLocation(500, 500);
    okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    okno.setVisible(true);
  }

}
