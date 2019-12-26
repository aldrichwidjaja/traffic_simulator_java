import java.awt.*;

public class Vehicle_Motorbike extends Vehicle{

    public Vehicle_Motorbike(int newx, int newy) {
        super(newx, newy);
        width = 40;
        height = 30;
    }

    public void paintMe(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }

}
