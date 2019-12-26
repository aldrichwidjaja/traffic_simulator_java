import java.awt.*;

public class Vehicle_Bus extends Vehicle{

    public Vehicle_Bus(int newx, int newy) {
        super(newx, newy);
        width = 120;
        height = 50;
    }

    public void paintMe(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);
    }

}
