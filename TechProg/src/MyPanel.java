import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    private ITransport boat;

    public void setBoat(ITransport boat) {
        this.boat = boat;
    }

    public MyPanel(ITransport boat) {
        this.boat = boat;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (boat != null) {
            boat.DrawBoat(g);
        }
    }
}