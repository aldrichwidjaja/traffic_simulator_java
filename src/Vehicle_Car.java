import java.awt.*;

public class Vehicle_Car extends Vehicle{

    public Vehicle_Car(int newx, int newy) {
        super(newx, newy);
        width = 80;
        height = 40;
    }

    public void paintMe(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

}
