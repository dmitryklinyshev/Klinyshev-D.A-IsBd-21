package tplabs;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormDock form = new FormDock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
