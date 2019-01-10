package tplabs;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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

    private JList listLevels;

    private DefaultListModel model;

    private JLabel levelsLabel;

    MultiLevelDock dock;

    private final int countLevel = 5;


    public FormDock() {
        JFrame frame = new JFrame();
        frame.setContentPane(mainPanel);
        frame.setSize(1024, 480);
        frame.setResizable(false);
        frame.setVisible(true);
        dock = drawPanel.getDock();
        model = new DefaultListModel();
        for (int i = 0; i < countLevel; i++) {
            model.addElement("Уровень " + i);
        }
        listLevels.setModel(model);
        listLevels.setSelectedIndex(0);
        drawPanel.setListLevels(listLevels);

        buttonParkBasicShip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listLevels.getSelectedIndex() > -1) {

                    Color mainColor = JColorChooser.showDialog(null, "Choose a color",
                            Color.RED);
                    var ship = new BasicShip(100, 1000, mainColor);
                    int place = dock.getDock(listLevels.getSelectedIndex()).addTransport(ship);
                    if (place != -1) {
                        drawPanel.repaint();
                    }
                }
            }
        });

        buttonParkShip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listLevels.getSelectedIndex() > -1) {

                    Color mainColor = JColorChooser.showDialog(null, "Choose a color",
                            Color.RED);
                    Color secondaryColor = JColorChooser.showDialog(null, "Choose a color",
                            Color.RED);
                    var ship = new MotorBoat(100, 1000, mainColor, secondaryColor,
                            true, true, true, 10);
                    int place = dock.getDock(listLevels.getSelectedIndex()).addTransport(ship);
                    if (place != -1) {
                        drawPanel.repaint();
                    }
                }
            }
        });

        buttonRemoveTransport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listLevels.getSelectedIndex() > -1) {
                    if (!removeTransportTextField.getText().equals("")) {
                        var ship = dock.getDock(listLevels.getSelectedIndex()).removeTransport(Integer.parseInt(removeTransportTextField.getText()));
                        if (ship != null) {
                            ship.setPosition(5, 5, shipDrawPanel.getWidth(), shipDrawPanel.getHeight());
                            shipDrawPanel.setShip(ship);
                            shipDrawPanel.repaint();
                        } else {
                            shipDrawPanel.setShip(null);
                            shipDrawPanel.repaint();
                        }
                        drawPanel.repaint();
                    }
                }
            }
        });
        listLevels.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                drawPanel.repaint();
            }
        });
    }

    private void createUIComponents() {
        drawPanel = new DockBoard();
        drawPanel.repaint(0);
    }
}
