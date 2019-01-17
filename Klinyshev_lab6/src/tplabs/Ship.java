package tplabs;

import java.awt.*;

public class Ship extends BasicShip {
    private Color secondaryColor;

    public boolean getStrip() {
        return strip;
    }

    private void setStrip(boolean strip) {
        this.strip = strip;
    }

    public boolean getLifebuoy() {
        return lifebuoy;
    }

    private void setLifebuoy(boolean lifebuoy) {
        this.lifebuoy = lifebuoy;
    }

    public boolean getFlag() {
        return flag;
    }

    private void setFlag(boolean flag) {
        this.flag = flag;
    }

    private boolean strip;

    private boolean lifebuoy;

    private boolean flag;

    private int enginePower;

    private void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public void setSecondaryColor(String colorName) {
        switch (colorName) {
            case "yellow":
                secondaryColor = Color.YELLOW;
                break;
            case "blue":
                secondaryColor = Color.BLUE;
                break;
            case "red":
                secondaryColor = Color.RED;
                break;
            case "green":
                secondaryColor = Color.GREEN;
                break;
            case "black":
                secondaryColor = Color.BLACK;
                break;
            case "orange":
                secondaryColor = Color.ORANGE;
                break;
            case "gray":
                secondaryColor = Color.GRAY;
                break;
            case "white":
                secondaryColor = Color.WHITE;
                break;
        }

    }

    public Ship(int maxSpeed, float weight, Color mainColor, Color secondaryColor,
                boolean strip, boolean lifebuoy, boolean flag, int enginePower) {
        super(maxSpeed, weight, mainColor);
        this.secondaryColor = secondaryColor;
        setStrip(strip);
        setLifebuoy(lifebuoy);
        setFlag(flag);
        setEnginePower(enginePower);
    }

    public Ship(String info) {
        super(info);
        String[] parameters = info.split(";");
        if (parameters.length == 8) {
            maxSpeed = Integer.parseInt(parameters[0]);
            weight = Integer.parseInt(parameters[1]);
            setMainColor(parameters[2]);
            setSecondaryColor(parameters[3]);
            strip = Boolean.parseBoolean(parameters[4]);
            lifebuoy = Boolean.parseBoolean(parameters[5]);
            flag = Boolean.parseBoolean(parameters[6]);
            enginePower = Integer.parseInt(parameters[7]);
            initlized = true;
        }
    }

    public String toString() {
        return (super.toString() + ";" + colorToString(secondaryColor) + ";" + strip + ";"
                + lifebuoy + ";" + flag + ";" + enginePower);
    }

    @Override
    public void drawTransport(Graphics2D g) {
        super.drawTransport(g);
        if (flag) {
            g.setColor(new Color(139, 69, 19));
            g.fillRect((int) startPosX + 10, (int) startPosY, 2, 10);
            g.setColor(Color.RED);

            g.fillRect((int) startPosX + 12, (int) startPosY, 5, 5);
        }
        if (strip) {
            g.setColor(secondaryColor);
            var stripX = new int[4];
            var stripY = new int[4];
            stripX[0] = (int) startPosX;
            stripY[0] = (int) startPosY + 15;
            stripX[1] = (int) startPosX + 95;
            stripY[1] = (int) startPosY + 15;
            stripX[2] = (int) startPosX + 90;
            stripY[2] = (int) startPosY + 20;
            stripX[3] = (int) startPosX;
            stripY[3] = (int) startPosY + 20;
            g.fillPolygon(new Polygon(stripX, stripY, stripX.length));
        }
        if (lifebuoy) {
            g.setColor(new Color(255, 165, 0));
            g.setStroke(new BasicStroke(4));
            g.drawOval((int) startPosX + 20, (int) startPosY + 22, 10, 10);
        }
        if (enginePower > 0) {
            g.setColor(new Color(169, 169, 169));
            g.fillRect((int) startPosX - 2, (int) startPosY + 25, 15, 11);
            var enginePointsX1 = new int[3];
            var enginePointsY1 = new int[3];
            enginePointsX1[0] = (int) startPosX + 3;
            enginePointsY1[0] = (int) startPosY + 22;
            enginePointsX1[1] = (int) startPosX - 5;
            enginePointsY1[1] = (int) startPosY + 22;
            enginePointsX1[2] = (int) startPosX - 2;
            enginePointsY1[2] = (int) startPosY + 30;
            var enginePointsX2 = new int[3];
            var enginePointsY2 = new int[3];
            enginePointsX2[0] = (int) startPosX - 2;
            enginePointsY2[0] = (int) startPosY + 30;
            enginePointsX2[1] = (int) startPosX - 5;
            enginePointsY2[1] = (int) startPosY + 38;
            enginePointsX2[2] = (int) startPosX + 3;
            enginePointsY2[2] = (int) startPosY + 38;
            g.setColor(Color.BLACK);
            g.fillPolygon(new Polygon(enginePointsX1, enginePointsY1, enginePointsX1.length));
            g.fillPolygon(new Polygon(enginePointsX2, enginePointsY2, enginePointsX2.length));

        }
    }
}
