import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class DialogConfig extends JDialog {

    Transport ship = null;
    Board shipPanel;
    boolean succes;

    public DialogConfig(JFrame parent) {
        super(parent, true);
        main();
    }

    public boolean isSuccessful() {
        setVisible(true);
        return succes;
    }

    public void main() {
        this.getContentPane().setBackground(SystemColor.controlHighlight);
        this.setBounds(100, 100, 420, 300);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);

        JLabel labelBasicShip = new JLabel("Лодка");
        labelBasicShip.setHorizontalAlignment(SwingConstants.CENTER);
        labelBasicShip.setBounds(10, 29, 89, 24);
        labelBasicShip.setBorder(border);
        getContentPane().add(labelBasicShip);

        JLabel labelShip = new JLabel("Катер");
        labelShip.setHorizontalAlignment(SwingConstants.CENTER);
        labelShip.setBounds(10, 64, 89, 24);
        labelShip.setBorder(border);
        getContentPane().add(labelShip);

        JLabel labelMainColor = new JLabel("Основной цвет");
        labelMainColor.setHorizontalAlignment(SwingConstants.CENTER);
        labelMainColor.setBounds(146, 149, 122, 30);
        labelMainColor.setBorder(border);
        getContentPane().add(labelMainColor);

        JLabel labelSecondColor = new JLabel("Доп. цвет");
        labelSecondColor.setHorizontalAlignment(SwingConstants.CENTER);
        labelSecondColor.setBounds(146, 193, 122, 30);
        labelSecondColor.setBorder(border);
        getContentPane().add(labelSecondColor);

        shipPanel = new Board();
        shipPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        FlowLayout flowLayout = (FlowLayout) shipPanel.getLayout();
        shipPanel.setBounds(126, 29, 153, 110);
        this.getContentPane().add(shipPanel);

        MouseListener ml = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JComponent jc = (JComponent) e.getSource();
                TransferHandler th = jc.getTransferHandler();
                th.exportAsDrag(jc, e, TransferHandler.COPY);
            }
        };

        labelBasicShip.addMouseListener(ml);
        labelShip.addMouseListener(ml);
        labelShip.setTransferHandler(new TransferHandler("text"));
        labelBasicShip.setTransferHandler(new TransferHandler("text"));

        shipPanel.setDropTarget(new DropTarget() {

            public void drop(DropTargetDropEvent e) {

                try {

                    for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
                        if (e.getTransferable().getTransferData(df) == "Лодка") {
                            ship = new BasicShip(10, 10, Color.YELLOW);
                            shipPanel.setShip(ship);
                            ship.setPosition(20, 20, shipPanel.getWidth(), shipPanel.getHeight());
                        } else if (e.getTransferable().getTransferData(df) == "Катер") {
                            ship = new Ship(30, 2, Color.YELLOW, Color.RED, true, true,
                                    true, 10);
                            shipPanel.setShip(ship);
                            ship.setPosition(20, 20, shipPanel.getWidth(), shipPanel.getHeight());
                        }
                        shipPanel.repaint();
                    }
                } catch (Exception ex) {
                }

            }

            public void dragEnter(DropTargetDragEvent e) {
                for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
                    try {
                        if (e.getTransferable().getTransferData(df) instanceof String)
                            e.acceptDrag(DnDConstants.ACTION_COPY);
                        else
                            e.acceptDrag(DnDConstants.ACTION_NONE);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        JPanel panelYellow = new JPanel();
        panelYellow.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelYellow.setName("yellow");
        panelYellow.setBackground(Color.YELLOW);
        panelYellow.setBounds(347, 83, 31, 39);
        this.getContentPane().add(panelYellow);

        JPanel panelWhite = new JPanel();
        panelWhite.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelWhite.setName("white");
        panelWhite.setBackground(Color.WHITE);
        panelWhite.setBounds(306, 29, 31, 39);
        this.getContentPane().add(panelWhite);

        JPanel panelBlue = new JPanel();
        panelBlue.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelBlue.setName("blue");
        panelBlue.setBackground(Color.BLUE);
        panelBlue.setBounds(347, 29, 31, 39);
        this.getContentPane().add(panelBlue);

        JPanel panelRed = new JPanel();
        panelRed.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelRed.setName("red");
        panelRed.setBackground(Color.RED);
        panelRed.setBounds(347, 187, 31, 39);
        this.getContentPane().add(panelRed);

        JPanel panelGreen = new JPanel();
        panelGreen.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelGreen.setName("green");
        panelGreen.setBackground(Color.GREEN);
        panelGreen.setBounds(306, 133, 31, 39);
        this.getContentPane().add(panelGreen);

        JPanel panelGrey = new JPanel();
        panelGrey.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelGrey.setName("gray");
        panelGrey.setBackground(Color.GRAY);
        panelGrey.setBounds(306, 83, 31, 39);
        this.getContentPane().add(panelGrey);

        JPanel panelBlack = new JPanel();
        panelBlack.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelBlack.setName("black");
        panelBlack.setBackground(Color.BLACK);
        panelBlack.setBounds(306, 187, 31, 39);
        this.getContentPane().add(panelBlack);

        JPanel panelOrange = new JPanel();
        panelOrange.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelOrange.setName("orange");
        panelOrange.setBackground(Color.ORANGE);
        panelOrange.setBounds(347, 133, 31, 39);
        this.getContentPane().add(panelOrange);

        panelWhite.addMouseListener(ml);
        panelWhite.setTransferHandler(new TransferHandler("name"));

        panelBlue.addMouseListener(ml);
        panelBlue.setTransferHandler(new TransferHandler("name"));

        panelRed.addMouseListener(ml);
        panelRed.setTransferHandler(new TransferHandler("name"));

        panelGrey.addMouseListener(ml);
        panelGrey.setTransferHandler(new TransferHandler("name"));

        panelBlack.addMouseListener(ml);
        panelBlack.setTransferHandler(new TransferHandler("name"));

        panelOrange.addMouseListener(ml);
        panelOrange.setTransferHandler(new TransferHandler("name"));

        panelYellow.addMouseListener(ml);
        panelYellow.setTransferHandler(new TransferHandler("name"));

        panelGreen.addMouseListener(ml);
        panelGreen.setTransferHandler(new TransferHandler("name"));

        JButton btnAdd = new JButton("Добавить");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                succes = true;
                dispose();
            }
        });
        btnAdd.setBounds(10, 133, 106, 23);
        this.getContentPane().add(btnAdd);

        JButton btnCancell = new JButton("\u041E\u0442\u043C\u0435\u043D\u0430");
        btnCancell.setBounds(10, 187, 106, 23);
        this.getContentPane().add(btnCancell);
        btnCancell.addActionListener((ActionEvent e) -> {
            succes = false;
            dispose();
        });

        labelMainColor.setDropTarget(new DropTarget() {
            public void drop(DropTargetDropEvent e) {
                if (ship != null) {
                    try {
                        for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
                            ship.setMainColor(e.getTransferable().getTransferData(df).toString());
                            shipPanel.setShip(ship);
                            shipPanel.repaint();
                        }
                    } catch (Exception ex) {
                    }
                }
            }

            public void dragEnter(DropTargetDragEvent e) {
                for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
                    try {
                        if (e.getTransferable().getTransferData(df) instanceof String)
                            e.acceptDrag(DnDConstants.ACTION_COPY);
                        else
                            e.acceptDrag(DnDConstants.ACTION_NONE);
                    } catch (UnsupportedFlavorException | IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        labelSecondColor.setDropTarget(new DropTarget() {
            public void drop(DropTargetDropEvent e) {
                if (ship != null) {
                    try {
                        for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
                            ((Ship) ship).setSecondaryColor(e.getTransferable().getTransferData(df).toString());
                            shipPanel.setShip(ship);
                            shipPanel.repaint();
                        }
                    } catch (Exception ex) {
                    }
                }
            }

            public void dragEnter(DropTargetDragEvent e) {
                for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
                    try {
                        if (e.getTransferable().getTransferData(df) instanceof String)
                            e.acceptDrag(DnDConstants.ACTION_COPY);
                        else
                            e.acceptDrag(DnDConstants.ACTION_NONE);
                    } catch (UnsupportedFlavorException | IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }

    public Transport getShip() {
        return ship;
    }
}