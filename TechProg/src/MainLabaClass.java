
import java.awt.*;
public class MainLabaClass {
    //
    private int _startPosX ;
    private int _startPosY;
    //
    private int _pictureWidth;
    private int _pictureHeight;
    //
    private final int planeWidth = 150;
    private final int planeHeight = 100;
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
    public MainLabaClass(int maxSpeed, float weight, Color mainColor, Color dopColor)
    {

        MaxSpeed = 1000; //maxSpeed;
        Weight = weight;
        MainColor = mainColor;
        DopColor = dopColor;
    }
    //
    public void SetPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }
    //
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
                if (_startPosX + step + planeWidth < _pictureWidth)
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
                if (_startPosY + step + planeHeight < _pictureHeight)
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
        g.fillRect(_startPosX+40, _startPosY+40, planeWidth-30, planeHeight-60);
//        g.fillRect(_startPosX+30, _startPosY+20, planeWidth-120, planeHeight-40);
        g.setColor(Color.BLACK);

        g.drawLine(_startPosX + 160, _startPosY + 40, _startPosX + 100, _startPosY + 20);
        g.drawLine(_startPosX + 100, _startPosY + 20, _startPosX + 100, _startPosY + 40);
        g.drawArc(_startPosX-40, _startPosY + 40, 90, 85, 15, 75);
        g.setColor(Color.GRAY);
        g.fillRect(_startPosX+5, _startPosY+40, planeWidth-135, planeHeight-85);




        g.setColor(DopColor);
        g.fillRect(_startPosX+35, _startPosY+30, planeWidth-130, planeHeight-85);

    }
}