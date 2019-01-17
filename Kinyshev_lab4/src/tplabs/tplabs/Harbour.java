package tplabs;

import java.awt.*;
import java.util.SortedMap;
import java.util.TreeMap;

public class Harbour<T extends Transport> {
    private SortedMap<Integer, T> places;

    private int maxCount;

    private int pictureWidth;

    private int pictureHeight;

    private int placeSizeWidth = 210;

    private int placeSizeHeight = 80;

    public Harbour(int sizes, int pictureWidth, int pictureHeight) {
        maxCount = sizes;
        places = new TreeMap<Integer, T>();
        this.pictureWidth = pictureWidth;
        this.pictureHeight = pictureHeight;
    }

    public int addTransport(T ship) {
        if (places.size() == maxCount) {
            return -1;
        }
        for (int i = 0; i < maxCount; i++) {
            if (checkFreePlace(i)) {
                places.put(i, ship);
                places.get(i).setPosition(10 + i / 5 * placeSizeWidth + 5,
                        i % 5 * placeSizeHeight + 15, pictureWidth, pictureHeight);
                return i;
            }
        }
        return -1;
    }

    public T removeTransport(int index) {
        if (!checkFreePlace(index)) {
            T ship = places.get(index);
            places.remove(index);
            return ship;
        }
        return null;
    }

    private boolean checkFreePlace(int index) {
        return !places.containsKey(index);
    }

    public void draw(Graphics2D g) {
        drawMarking(g);
        for (T transport : places.values()) {
            transport.drawTransport(g);
        }
    }

    private void drawMarking(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, pictureWidth, pictureHeight);
        g.setColor(new Color(255, 165, 0));
        g.setStroke(new BasicStroke(5));
        //границы праковки
        g.drawRect(0, 0, (maxCount / 5) * placeSizeWidth, 480);
        for (int i = 0; i < maxCount / 5; i++) {
            for (int j = 0; j < 6; ++j) {
                g.drawLine(5 + i * placeSizeWidth, 5 + j * placeSizeHeight,
                        5 + i * placeSizeWidth + 115, 5 + j * placeSizeHeight);
            }
            g.drawLine(5 + i * placeSizeWidth + 115, 5, 5 + i * placeSizeWidth + 115, 405);
            g.drawLine(5 + i * placeSizeWidth, 5, 5 + i * placeSizeWidth, 405);
        }
    }
}
