import java.awt.*;

public abstract class Ship implements ITransport {

    protected int _startPosX ;
    protected int _startPosY;
    //
    protected int _pictureWidth;
    protected int _pictureHeight;

    //

    //
    private int MaxSpeed;
    private float Weight;
    protected Color MainColor;
    protected  Color DopColor;
    public int getMaxSpeed() {
        return MaxSpeed;
    }
    public float getWeight() {
        return Weight;
    }
    protected void setWeight(float weight) {
        Weight = weight;
    }
    public Color getMainColor() {
        return MainColor;
    }
    public Color getDopColor() {
        return DopColor;
    }

    protected void setMaxSpeed(int maxSpeed) {
        MaxSpeed = maxSpeed;
    }
    @Override
    public void SetPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }

    @Override
    public abstract void MoveTransport(Direction direction);
    @Override
    public abstract void DrawBoat(Graphics g);
}
