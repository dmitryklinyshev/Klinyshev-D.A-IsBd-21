
import javax.swing.*;
        import java.awt.*;
public class PanelForPaint extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (Program.window.plane != null) {
            Program.window.plane.DrawBoat(g);
        }
    }
}