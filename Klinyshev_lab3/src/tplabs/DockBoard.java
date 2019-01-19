package tplabs;

import javax.swing.*;
import java.awt.*;

public class DockBoard extends JPanel {
    private Harbour<Transport> dock;

    public Harbour<Transport> getDock() {
        return dock;
    }

    public DockBoard() {
        dock = new Harbour<>(20, 1024, 1024);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (dock != null) {
            dock.draw((Graphics2D) g);
        }
    }
}
