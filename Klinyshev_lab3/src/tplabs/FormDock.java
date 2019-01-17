package tplabs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormDock {
    private JPanel mainPanel;
    private JButton buttonParkBasicShip;
    private JButton buttonParkShip;
    private JLabel removeTransportLabel;
    private JTextField removeTransportTextField;
    private JButton buttonRemoveTransport;
    private DockBoard drawPanel;
    private Board shipDrawPanel;
    Harbour<Transport> harbour;

    public FormDock() {
        JFrame frame = new JFrame();
        frame.setContentPane(mainPanel);
        frame.setSize(1024, 480);
        frame.setResizable(false);
        frame.setVisible(true);
        harbour = drawPanel.getDock();
        buttonParkBasicShip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color mainColor = JColorChooser.showDialog(null, "Choose a color",
                        Color.RED);
                var ship = new BasicShip(100, 1000, mainColor);
                int place = harbour.addTransport(ship);
                drawPanel.repaint();

            }
        });

        buttonParkShip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color mainColor = JColorChooser.showDialog(null, "Choose a color",
                        Color.RED);
                Color secondaryColor = JColorChooser.showDialog(null, "Choose a color",
                        Color.RED);
                var ship = new MotorBoat(100, 1000, mainColor, secondaryColor,
                        true, true, true, 10);
                int place = harbour.addTransport(ship);
                drawPanel.repaint();
            }
        });

        buttonRemoveTransport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!removeTransportTextField.getText().equals("")) {
                    var ship = harbour.removeTransport(Integer.parseInt(removeTransportTextField.getText()));
                    if (ship != null) {
                        ship.setPosition(5, 5, shipDrawPanel.getWidth(), shipDrawPanel.getHeight());
                        shipDrawPanel.setShip(ship);
                        shipDrawPanel.repaint();
                        drawPanel.repaint();
                    } else {
                        shipDrawPanel.setShip(null);
                        shipDrawPanel.repaint();
                    }
                }
            }
        });
    }

    private void createUIComponents() {
        drawPanel = new DockBoard();
        drawPanel.repaint();
    }
}
