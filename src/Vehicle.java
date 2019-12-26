import java.awt.*;

public class Vehicle {

    int x;
    int y;
    int width= 0;
    int height= 0;

    public Vehicle(int newx, int newy) {
        x = newx;
        y = newy;
    }

    public void paintMe(Graphics g) {

    }

    public int getX() {
        return x;
    }

    public void setX(int newx) {
        x = newx;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public void setY(int newy) {
        y = newy;
    }

}
