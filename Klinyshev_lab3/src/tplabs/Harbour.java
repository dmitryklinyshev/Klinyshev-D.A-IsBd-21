package tplabs;

import java.awt.*;
import java.util.ArrayList;

public class Harbour<T extends Transport> {
    private ArrayList<T> places;

    private int pictureWidth;

    private int pictureHeight;

    private int placeSizeWidth = 210;

    private int placeSizeHeight = 80;

    public Harbour(int size, int pictureWidth, int pictureHeight) {
        places = new ArrayList<T>();
        this.pictureWidth = pictureWidth;
        this.pictureHeight = pictureHeight;
        for (int i = 0; i < size; i++) {
            places.add(null);
        }
    }

    public int addTransport(T ship) {
        for (int i = 0; i < places.size(); i++) {
            if (checkFreePlace(i)) {
                places.add(i, ship);
                places.get(i).setPosition(10 + i / 5 * placeSizeWidth + 5,
                        i % 5 * placeSizeHeight + 15, pictureWidth, pictureHeight);
                return i;
            }
        }
        return -1;
    }

    public T removeTransport(int index) {
        if (index < 0 || index > places.size()) {
            return null;
        }
        if (!checkFreePlace(index)) {
            T ship = places.get(index);
            places.set(index, null);
            return ship;
        }
        return null;
    }

    private boolean checkFreePlace(int index) {
        return places.get(index) == null;
    }

    public void draw(Graphics2D g) {
        drawMarking(g);
        for (int i = 0; i < places.size(); i++) {
            if (!checkFreePlace(i)) {
                places.get(i).drawTransport(g);
            }
        }
    }

    private void drawMarking(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, pictureWidth, pictureHeight);
        g.setColor(new Color(55, 5, 228));
        g.setStroke(new BasicStroke(7));
        //границы праковки
        g.drawRect(0, 0, (places.size() / 5) * placeSizeWidth, 480);
        for (int i = 0; i < places.size() / 5; i++) {
            for (int j = 0; j < 6; ++j) {
                g.drawLine(5 + i * placeSizeWidth, 5 + j * placeSizeHeight,
                        5 + i * placeSizeWidth + 115, 5 + j * placeSizeHeight);
            }
            g.drawLine(5 + i * placeSizeWidth + 115, 5, 5 + i * placeSizeWidth + 115, 405);
            g.drawLine(5 + i * placeSizeWidth, 5, 5 + i * placeSizeWidth, 405);
        }
    }
}
