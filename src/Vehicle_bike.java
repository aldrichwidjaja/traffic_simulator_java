import java.awt.Graphics;
import java.awt.Color;

public class Vehicle_bike extends Vehicle{

	public Vehicle_bike(int x, int y) {
		super(x, y);
		//set width height speed
		width=15;
		height=10;
		speed=20;
	}

	public void paint_component(Graphics g) {
		//set color of vehicle bike
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}
	

}
