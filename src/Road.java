import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Road extends JPanel {

    int LANE_HEIGHT = 0;
    int ROAD_WIDTH = 0;
    ArrayList<Vehicle> cars = new ArrayList<Vehicle>();


    public Road() {
    }

    public void addCar(Vehicle v) {
        Collections.shuffle(cars);
        cars.add(v);
    }



    public void paintComponent(Graphics g) {
    }

    public void step() {
        for (int i = 0; i < cars.size(); i++) {
            Vehicle v = cars.get(i);
            if (collision(v.getX() + 20, v.getY(), v) == false) { //NO COLLISION HERE
                v.setX(v.getX() + 20);
                if (v.getX() > ROAD_WIDTH) {
                    if (collision(0, v.getY(), v) == false) {
                        removeAll();
                    }
                }
            } else { //CAR AHEAD
                if ((v.getY() > 20)  &&
                        (collision(v.getX(), v.getY()-LANE_HEIGHT, v) == false)) {
                        v.setY(v.getY() - LANE_HEIGHT);
                    }
                else if ((v.getY() > 20 + 3*LANE_HEIGHT)  &&
                            (collision(v.getX(), v.getY()+LANE_HEIGHT, v) == false)) {
                        v.setY(getY() + LANE_HEIGHT);
                    }
                }
            }
        }

    public boolean collision(int x, int y, Vehicle v) {
        boolean collide = false;
        for( int i = 0; i < cars.size(); i++) {
            Vehicle u = cars.get(i);
            if (y == u.getY()) { // if in the same lane
                if ( u.equals(v) == false) { // IF NOT CHECKING SELF
                    if (v.getX() < u.getX() + u.getWidth() &&  //
                            x + v.getWidth() > u.getX()) {
                        collide = true;
                    }
                }
            }
        }
        return collide;
    }


}
