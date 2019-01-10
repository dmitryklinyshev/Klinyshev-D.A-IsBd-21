import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FormShip {
    private JPanel mainPanel;
    private JButton buttonCreateShip;
    private JButton buttonLeft;
    private JButton buttonRight;
    private JButton buttonDown;
    private JButton buttonUp;
    private Board drawPanel;
    private JButton buttonCreateBasicShip;
    private Transport ship;

    public FormShip() {
        JFrame frame = new JFrame();
        frame.setContentPane(mainPanel);
        frame.setSize(640, 480);
        frame.setResizable(false);
        frame.setVisible(true);

        buttonCreateShip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rnd = new Random();
                ship = new Ship(rnd.nextInt(200) + 100, 1000, Color.ORANGE,
                        Color.RED, true, true, true, 10);
                ship.setPosition(rnd.nextInt(60) + 40, rnd.nextInt(60) + 40, drawPanel.getWidth(),
                        drawPanel.getHeight());
                drawPanel.setShip(ship);
                drawPanel.repaint();
            }
        });

        buttonUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ship.moveTransport(Direction.Up);
                drawPanel.repaint();
            }
        });

        buttonRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ship.moveTransport(Direction.Right);
                drawPanel.repaint();
            }
        });

        buttonDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ship.moveTransport(Direction.Down);
                drawPanel.repaint();
            }
        });

        buttonLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ship.moveTransport(Direction.Left);
                drawPanel.repaint();
            }
        });
        buttonCreateBasicShip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rnd = new Random();
                ship = new BasicShip(rnd.nextInt(200) + 100, rnd.nextInt(1000) + 1000, Color.YELLOW);
                ship.setPosition(rnd.nextInt(60) + 40, rnd.nextInt(60) + 40, drawPanel.getWidth(),
                        drawPanel.getHeight());
                drawPanel.setShip(ship);
                drawPanel.repaint();
            }
        });
    }

    private void createUIComponents() {
        drawPanel = new Board();
    }

}
