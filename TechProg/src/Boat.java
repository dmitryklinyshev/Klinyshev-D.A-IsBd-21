
import java.awt.*;
 public class Boat extends Ship {
    //
    protected int _startPosX ;
    protected int _startPosY;
    //

    //
    protected final int boatWidth = 175;
    protected final int boatHeight = 100;
    //
    private int MaxSpeed;
    private float Weight;
    private Color MainColor;
    private Color DopColor;
    public int getMaxSpeed() {
        return MaxSpeed;
    }
    public float getWeight() {
        return Weight;
    }
    public Color getMainColor() {
        return MainColor;
    }
    public Color getDopColor() {
        return DopColor;
    }

    //
    public Boat(int maxSpeed, float weight, Color mainColor, Color dopColor)
    {

        MaxSpeed = maxSpeed; //maxSpeed;
        Weight = weight;
        MainColor = mainColor;
         DopColor = dopColor;
    }

    //

   @Override
public void MoveTransport(Direction direction)
    {
        float step = MaxSpeed * 100 / Weight;
        switch (direction)
        {
            case Left:
            {
                if (_startPosX - step > 0)
                {
                    _startPosX -= step;
                }
                break;
            }
            case Right:
            {
                if (_startPosX + step + boatWidth < _pictureWidth)
                {
                    _startPosX += step;
                }
                break;
            }
            case Up:
            {
                if (_startPosY - step > 0)
                {
                    _startPosY -= step;
                }
                break;
            }
            case Down:
            {
                if (_startPosY + step + boatHeight < _pictureHeight)
                {
                    _startPosY += step;
                }
                break;
            }
        }
    }


     public void DrawBoat(Graphics g)
    {
        //
        g.setColor(MainColor);
        g.fillRect(_startPosX+40, _startPosY+40, 120, 40);
        g.setColor(Color.BLACK);



        g.drawLine(_startPosX + 160, _startPosY + 40, _startPosX + 100, _startPosY + 20);
        g.drawLine(_startPosX + 100, _startPosY + 20, _startPosX + 100, _startPosY + 40);
        g.drawArc(_startPosX-40, _startPosY + 40, 90, 85, 15, 75);
        g.setColor(Color.GRAY);
        g.fillRect(_startPosX+5, _startPosY+40, 15, 15);
        g.setColor(DopColor);
        g.fillRect(_startPosX+35, _startPosY+30, 20, 15);

        Graphics2D g2 = (Graphics2D) g;

        g2.setStroke(new BasicStroke(6.0f));  // толщина равна 10
        g2.drawLine(_startPosX + 90,_startPosY + 30, _startPosX + 55,_startPosY + 100);


    }


}