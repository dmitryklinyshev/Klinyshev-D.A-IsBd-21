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

    @Override
    public void setMainColor(String colorName) {
        switch (colorName) {
            case "yellow":
                mainColor = Color.YELLOW;
                break;
            case "blue":
                mainColor = Color.BLUE;
                break;
            case "red":
                mainColor = Color.RED;
                break;
            case "green":
                mainColor = Color.GREEN;
                break;
            case "black":
                mainColor = Color.BLACK;
                break;
            case "orange":
                mainColor = Color.ORANGE;
                break;
            case "gray":
                mainColor = Color.GRAY;
                break;
            case "white":
                mainColor = Color.WHITE;
                break;
        }
    }

    @Override
    public String colorToString(Color color) {
        if (color.equals(Color.WHITE)) {
            return "white";
        } else if (color.equals(Color.BLACK)) {
            return "black";
        } else if (color.equals(Color.RED)) {
            return "red";
        } else if (color.equals(Color.YELLOW)) {
            return "yellow";
        } else if (color.equals(Color.ORANGE)) {
            return "orange";
        } else if (color.equals(Color.BLUE)) {
            return "blue";
        } else if (color.equals(Color.GRAY)) {
            return "gray";
        } else if (color.equals(Color.GREEN)) {
            return "green";
        }
        return "white";
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
