package tplabs;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;

public class FormDock {
    private JPanel mainPanel;

    private JButton buttonParkShip;

    private JLabel removeTransportLabel;

    private JTextField removeTransportTextField;

    private JButton buttonRemoveTransport;

    private DockBoard drawPanel;

    private Board shipDrawPanel;

    private JList listLevels;

    private DefaultListModel model;

    private JLabel levelsLabel;

    private JMenuBar menuBar;

    MultiLevelDock dock;

    JFrame frame;

    Transport ship;

    private final int countLevel = 5;


    public FormDock() {
        frame = new JFrame();
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

        buttonParkShip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listLevels.getSelectedIndex() > -1) {
                    DialogConfig dConfig = new DialogConfig(frame);
                    if (dConfig.isSuccessful()) {
                        ship = dConfig.getShip();
                        int i = dock.getDock(listLevels.getSelectedIndex()).addTransport(ship);
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

        Font font = new Font("Verdana", Font.PLAIN, 11);
        menuBar = new JMenuBar();
        menuBar.setFont(font);

        JMenu newMenu = new JMenu("Файл");
        newMenu.setFont(font);
        menuBar.add(newMenu);

        JMenuItem saveFileItem = new JMenuItem("Сохранить");
        saveFileItem.setFont(font);
        newMenu.add(saveFileItem);

        JMenuItem loadFileItem = new JMenuItem("Загрузить");
        loadFileItem.setFont(font);
        newMenu.add(loadFileItem);

        saveFileItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChoser = new JFileChooser();
                fileChoser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
                int ret = fileChoser.showDialog(null, "Сохранить файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileChoser.getSelectedFile();
                    if (dock.saveData(file.getAbsolutePath())) {
                        JOptionPane.showMessageDialog(frame, "Сохранение прошло успешно");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Произошла ошибка");
                    }
                }
            }
        });

        loadFileItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChoser = new JFileChooser();
                fileChoser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
                int ret = fileChoser.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileChoser.getSelectedFile();
                    if (dock.loadData(file.getAbsolutePath())) {
                        JOptionPane.showMessageDialog(frame, "Загрузка прошло успешно");
                        drawPanel.repaint();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Произошла ошибка");
                    }
                }
            }
        });

        frame.setJMenuBar(menuBar);
    }

    private void createUIComponents() {
        drawPanel = new DockBoard();
        drawPanel.repaint(0);
    }

}
