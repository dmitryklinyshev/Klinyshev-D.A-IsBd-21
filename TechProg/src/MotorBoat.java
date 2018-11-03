import java.awt.*;


public class MotorBoat extends Boat{

    private Color MainColor;
    private Color DopColor;

    public MotorBoat(int maxSpeed, float weight, Color mainColor, Color dopColor) {
        super(maxSpeed, weight, mainColor, dopColor);
    }



    @Override
    public void DrawBoat(Graphics g)
    {
        g.setColor(MainColor);
        g.fillRect(_startPosX+40, _startPosY+40, 120, 40);
        g.setColor(Color.BLACK);

        Graphics2D g1 = (Graphics2D) g;
        g1.setStroke(new BasicStroke(2.0f));  // толщина равна 10


        g1.drawLine(_startPosX + 160, _startPosY + 40, _startPosX + 100, _startPosY + 20);
        g1.drawLine(_startPosX + 100, _startPosY + 20, _startPosX + 100, _startPosY + 40);
        g1.drawArc(_startPosX-40, _startPosY + 40, 90, 85, 15, 75);

        Graphics2D g2 = (Graphics2D) g;

        g2.setStroke(new BasicStroke(6.0f));  // толщина равна 10
        g2.drawLine(_startPosX + 90,_startPosY + 30, _startPosX + 55,_startPosY + 100);








        g.setColor(DopColor);
        g.fillRect(_startPosX+35, _startPosY+30, 20, 15);
        g.fillRect(_startPosX+5, _startPosY+40, 15, 15);

        Graphics2D g4 = (Graphics2D) g;
        g4.setStroke(new BasicStroke(3.0f));  // толщина равна 10

        g4.drawLine(_startPosX + 160, _startPosY + 40, _startPosX + 180, _startPosY + 50);
        g4.drawLine(_startPosX + 160, _startPosY + 60, _startPosX + 180, _startPosY + 50);



    }
}

