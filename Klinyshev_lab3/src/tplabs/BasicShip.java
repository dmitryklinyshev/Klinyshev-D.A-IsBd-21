package tplabs;

import java.awt.*;

public class BasicShip extends WaterTransport {
    protected final int shipWidth = 120;

    protected final int shipHeight = 50;

    protected float startPosX;

    protected float startPosY;

    protected int pictureWidth;

    protected int pictureHeight;

    protected int maxSpeed;

    protected float weight;

    protected Color mainColor;

    protected boolean initlized = false;

    protected int getMaxSpeed() {
        return maxSpeed;
    }

    protected void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public float getWeight() {
        return weight;
    }

    protected void setWeight(float weight) {
        this.weight = weight;
    }

    public Color getMainColor() {
        return mainColor;
    }

    protected void setMainColor(Color mainColor) {
        this.mainColor = mainColor;
    }

    public void setPosition(int x, int y, int width, int height) {
        startPosX = x;
        startPosY = y;
        pictureWidth = width;
        pictureHeight = height;
    }

    public BasicShip(int maxSpeed, float weight, Color mainColor) {
        setMaxSpeed(maxSpeed);
        setWeight(weight);
        setMainColor(mainColor);
        initlized = true;
    }

    @Override
    public void moveTransport(Direction direction) {
        float step = maxSpeed * 100 / weight;
        switch (direction) {
            // вправо
            case Right:
                if (startPosX + step < pictureWidth - shipWidth) {
                    startPosX += step;
                }
                break;
            //влево
            case Left:
                if (startPosX - step > 0) {
                    startPosX -= step;
                }
                break;
            //вверх
            case Up:
                if (startPosY - step > 0) {
                    startPosY -= step;
                }
                break;
            //вниз
            case Down:
                if (startPosY + step < pictureHeight - shipHeight) {
                    startPosY += step;
                }
                break;
        }
    }

    @Override
    public void drawTransport(Graphics2D g) {
        g.setColor(mainColor);
        var x = new int[4];
        var y = new int[4];
        x[0] = (int) startPosX;
        y[0] = (int) startPosY + 10;
        x[1] = (int) startPosX + 140;
        y[1] = (int) startPosY + 10;
        x[2] = (int) startPosX + 80;
        y[2] = (int) startPosY + 35;
        x[3] = (int) startPosX;
        y[3] = (int) startPosY + 35;
        g.fillPolygon(new Polygon(x, y, x.length));
        //Кабина
        g.setColor(Color.BLACK);
        g.drawRect((int) startPosX + 29, (int) startPosY - 1, 41, 11);
        g.setColor(Color.BLUE);
        g.fillRect((int) startPosX + 30, (int) startPosY, 40, 10);
    }
}
