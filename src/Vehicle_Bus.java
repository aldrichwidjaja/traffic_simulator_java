import java.awt.Graphics;
import java.awt.Color;


public class Vehicle_bus extends Vehicle{

	public Vehicle_bus(int x, int y) {
		//set widht height speed of vehicle bus
		super(x, y);
		width=45;
		height=10;
		speed=7;
	}
	public void paint_component(Graphics g) {
		//set color of vehicle bus
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
	}

}
