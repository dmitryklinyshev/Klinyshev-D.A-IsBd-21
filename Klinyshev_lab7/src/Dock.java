import java.awt.*;
import java.util.SortedMap;
import java.util.TreeMap;

public class Dock<T extends Transport> {
    private SortedMap<Integer, T> places;

    private int maxCount;

    private int pictureWidth;

    private int pictureHeight;

    private int placeSizeWidth = 210;

    private int placeSizeHeight = 80;

    public Dock(int sizes, int pictureWidth, int pictureHeight) {
        maxCount = sizes;
        places = new TreeMap<Integer, T>();
        this.pictureWidth = pictureWidth;
        this.pictureHeight = pictureHeight;
    }

    public int addTransport(T ship) throws DockOverflowException {
        if (places.size() == maxCount) {
            throw new DockOverflowException();
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

    public T removeTransport(int index) throws DockNotFoundException {
        if (!checkFreePlace(index)) {
            T ship = places.get(index);
            places.remove(index);
            return ship;
        }
        throw new DockNotFoundException(index);
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
        g.setColor(Color.white);
        g.fillRect(0, 0, pictureWidth, pictureHeight);
        g.setColor(new Color(133, 56, 210));
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

    public T getTrasport(int ind) throws DockNotFoundException {
        if (places.containsKey(ind)) {
            return places.get(ind);
        }
        throw new DockNotFoundException(ind);
    }

    public void setTrasport(int ind, T t) throws DockOccupiedPlaceException {
        if (checkFreePlace(ind)) {
            places.put(ind, t);
            places.get(ind).setPosition(10 + ind / 5 * placeSizeWidth + 5,
                    ind % 5 * placeSizeHeight + 15, pictureWidth, pictureHeight);
        }
        throw new DockOccupiedPlaceException(ind);
    }
}
