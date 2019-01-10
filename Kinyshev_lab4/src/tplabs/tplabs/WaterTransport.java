package tplabs;

import java.awt.*;

public abstract class WaterTransport implements Transport {
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

    public abstract void drawTransport(Graphics2D g);

    public abstract void moveTransport(Direction direction);
}
