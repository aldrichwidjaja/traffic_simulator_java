import java.awt.*;

public class Road_Straight extends Road {

    public Road_Straight() {
        LANE_HEIGHT = 80;
        ROAD_WIDTH = 800;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(0,0,this.getWidth(), this.getHeight());
        g.setColor(Color.black);
        for (int a = LANE_HEIGHT; a  < LANE_HEIGHT * 3; a = a + LANE_HEIGHT) { //which lane
            for (int i = 0; i < getWidth(); i = i +50) { // which line
                g.fillRect(i, a, 30, 5);
            }
        }

        //draw cars
        for (int a = 0; a < cars.size(); a++) {
            cars.get(a).paintMe(g);
        }

    }


}
