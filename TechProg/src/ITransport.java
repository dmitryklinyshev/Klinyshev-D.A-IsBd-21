import java.awt.*;

public interface ITransport {

     void DrawBoat(Graphics g);

     void MoveTransport(Direction direction);

    void SetPosition(int i, int i1, int width, int height);
}
