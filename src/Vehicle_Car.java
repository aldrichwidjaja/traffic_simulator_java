import java.awt.Graphics;
import java.awt.Color;

public class Vehicle_car extends Vehicle{

	public Vehicle_car(int x, int y) {
		super(x, y);
		//set width height speed of vehicle car
		width=30;
		height=10;
		speed=15;
	}

	public void setRate(int r) {
		//to set speed of car when traffic light change
		this.speed=r;
	}

	public void paint_component(Graphics g) {
		//set color of the vehicle car
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	

}
