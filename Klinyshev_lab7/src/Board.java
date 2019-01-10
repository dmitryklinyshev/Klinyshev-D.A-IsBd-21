import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private Transport ship;

    void setShip(Transport transport) {
        ship = transport;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (ship != null) {
            ship.drawTransport((Graphics2D) g);
        }
    }
}
