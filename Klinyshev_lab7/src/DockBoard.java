import javax.swing.*;
import java.awt.*;

public class DockBoard extends JPanel {
    private MultiLevelDock dock;

    private final int countLevel = 5;

    private JList listLevels;

    public MultiLevelDock getDock() {
        return dock;
    }

    public void setListLevels(JList listLevels) {
        this.listLevels = listLevels;
    }

    public DockBoard() {
        dock = new MultiLevelDock(countLevel, 1024, 1024);
    }

    public void paint(Graphics g) {
        super.paint(g);
        int selectedLevel = listLevels.getSelectedIndex();
        if (selectedLevel != -1) {
            if (dock != null) {
                dock.getDock(selectedLevel).draw((Graphics2D) g);
            }
        }
    }
}
