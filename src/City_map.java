import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class City_map extends JPanel {
	final int lane_height =300;
	final int bound1=50;
	final int bound2=650;
	ArrayList<Vehicle> VEHICLE_LIST =new ArrayList<Vehicle>();
	ArrayList<Traffic_light> TRAFFIC_LIGHT_LIST =new ArrayList<Traffic_light>();

	public City_map() {
		//SET COLOR FOR BACKGROUND OF CITY
		setBackground(Color.BLUE);
		setForeground(Color.BLUE);

		//SET MAXIMUM BOUND OF THE CITY
		setBounds(187, 0, 855, 590);
		setLayout(null);
		setVisible(true);
	}

	public void addVehicle(Vehicle vehicle) {
		//adding new vehicle spawn
		VEHICLE_LIST.add(vehicle);
	}

	public void addSignal(Traffic_light signal_light) {
		//adding new traffic light
		TRAFFIC_LIGHT_LIST.add(signal_light);

	}

	public void paint(Graphics g) {
		super.paintComponent(g);

		//set color of road
		g.setColor(Color.gray);
		g.fillRect(350, 0, 50, 600);
		
		g.setColor(Color.BLACK);
		for(int a = lane_height; a< lane_height *4; a=a+ lane_height) {
			for(int b=0;b<getHeight();b+=40) {
				g.fillRect(375, b, 5, 30);
			}
		}
		//set color of road
		g.setColor(Color.gray);
		g.fillRect(0, 100, 870, 50);
		
		g.setColor(Color.BLACK);
		for(int a = lane_height; a< lane_height *4; a=a+ lane_height) {
			for(int b=0;b<getWidth();b+=40) {
				g.fillRect(b, 120, 30, 5);
			}
		}
		
		
		
		g.setColor(Color.gray);
		g.fillRect(0, 400, 870, 50);
		
		g.setColor(Color.BLACK);
		for(int a = lane_height; a< lane_height *4; a=a+ lane_height) {
			for(int b=0;b<getWidth();b+=40) {
				g.fillRect(b, 420, 30, 5);
			}
		}
		
		
		g.setColor(Color.gray);
		g.fillRect(150, 400, 50, 600);
		
		g.setColor(Color.BLACK);
		for(int a = lane_height; a< lane_height *4; a=a+ lane_height) {
			for(int b=430;b<getHeight();b+=40) {
				g.fillRect(173, b, 5, 30);
			}
		}
		
		
		
		g.setColor(Color.gray);
		g.fillRect(650, 400, 50, 600);
		
		g.setColor(Color.BLACK);
		for(int a = lane_height; a< lane_height *4; a=a+ lane_height) {
			for(int b=430;b<getHeight();b+=40) {
				g.fillRect(673, b, 5, 30);
			}
		}
		
		for(int a = 0; a< VEHICLE_LIST.size(); a++) {
			VEHICLE_LIST.get(a).paint_component(g);
		}
		for(int a = 0; a< TRAFFIC_LIGHT_LIST.size(); a++) {
			TRAFFIC_LIGHT_LIST.get(a).paint_component(g);
		}
		
	}
	
	public void step() {
		for(int i = 0; i< VEHICLE_LIST.size(); i++) {
			Vehicle vehicle= VEHICLE_LIST.get(i);
			
			
			if(vehicle.turn1==true & !vehicle.road.equals("in") ) {
				vehicle.setY(vehicle.getY()+vehicle.getSpeed() );
				vehicle.setPosition(vehicle.getY()+vehicle.getSpeed());
				vehicle.setRoad(vehicle.getX(), vehicle.getY());
				
				
				
			}
			else if(vehicle.turn2==true & !vehicle.road.equals("in")){
				vehicle.setY(vehicle.getY()-vehicle.getSpeed());
				vehicle.setPosition(vehicle.getY()-vehicle.getSpeed());
				vehicle.setRoad(vehicle.getX(), vehicle.getY());
			
				
				}
			else if(vehicle.turn3==true & !vehicle.road.equals("in")){
				vehicle.setX(vehicle.getX()-vehicle.getSpeed());
				vehicle.setPosition(vehicle.getX()-vehicle.getSpeed());
				vehicle.setRoad(vehicle.getX(), vehicle.getY());
				
			
			}
			else if(vehicle.turn3==false & vehicle.turn3==false & vehicle.turn3==false & !vehicle.road.equals("in")) {
				vehicle.setX(vehicle.getX()+vehicle.getSpeed());
				vehicle.setPosition(vehicle.getX()+vehicle.getSpeed());
				vehicle.setRoad(vehicle.getX(), vehicle.getY());
				
			
			}
			else {
				if(vehicle.current==true) {
					
					int count=0;
					if(vehicle.signal.equals("s1")) {count=0;}
					else if(vehicle.signal.equals("s2")) {count=1;}
					else if(vehicle.signal.equals("s3")) {count=2;}
					else if(vehicle.signal.equals("s4")) {count=3;}
					else if(vehicle.signal.equals("s5")) {count=4;}
					else if(vehicle.signal.equals("s6")) {count=5;}
					else if(vehicle.signal.equals("s7")) {count=6;}
					else if(vehicle.signal.equals("s8")) {count=7;}
					
					if(count==0) {
						TRAFFIC_LIGHT_LIST.get(count).set_signal_color(false, false, true);
						
					}
					else {
						TRAFFIC_LIGHT_LIST.get(count-1).set_signal_color(true, false, false);
						TRAFFIC_LIGHT_LIST.get(count).set_signal_color(false, false, true);
					}
					if(vehicle.turn1==true) {
						vehicle.setY(vehicle.getY()+vehicle.getSpeed() );
						vehicle.setRoad(vehicle.getX(), vehicle.getY());	
					}
					else if(vehicle.turn2==true){
						vehicle.setY(vehicle.getY()-vehicle.getSpeed());
						
						vehicle.setRoad(vehicle.getX(), vehicle.getY());
					
						
						}
					else if(vehicle.turn3==true ){
						vehicle.setX(vehicle.getX()-vehicle.getSpeed());
						vehicle.setRoad(vehicle.getX(), vehicle.getY());
						
					
					}
					else if(vehicle.turn3==false & vehicle.turn3==false & vehicle.turn3==false ) {
						vehicle.setX(vehicle.getX()+vehicle.getSpeed());
						vehicle.setRoad(vehicle.getX(), vehicle.getY());
						
					
					}
				}
				else {
					vehicle.setRoad(vehicle.getX(), vehicle.getY());
				}
				
			}	
		}
		}
	public void set_traffic_light(int i, boolean r, boolean y, boolean g) {
		//set current traffic
		TRAFFIC_LIGHT_LIST.get(i).set_signal_color(r, y, g);
	}
	
	
	
	}

	


