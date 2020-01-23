import java.awt.Color;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.util.ArrayList;

public class Create_new_city extends JPanel {
	int roads=0;
	String name="";
	int laneHeight=300;
	ArrayList<Vehicle> v=new ArrayList<Vehicle>();
	ArrayList<Traffic_light> s=new ArrayList<Traffic_light>();
	public Create_new_city(String n, int roads) {
		setBackground(Color.DARK_GRAY);
		setForeground(Color.DARK_GRAY);
		setBounds(187, 0, 855, 590);
		setLayout(null);
		setVisible(true);
		this.name=n;
		this.roads=roads;
	}
	public void addVehicle(Vehicle vehicle) {
		v.add(vehicle);
	}
	public void addSignal(Traffic_light signal) {
		s.add(signal);

	}
	public void paint(Graphics g) {

		super.paintComponent(g);
		
		if(roads<=2) {

			g.setColor(Color.GRAY);
			g.fillRect(0, 100, 870, 50);
			
			g.setColor(Color.WHITE);
			for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
				for(int b=0;b<getWidth();b+=40) {
					g.fillRect(b, 120, 30, 5);
				}
			}
		}
	
//R2 and R3
		else if(roads<=4) {

			g.setColor(Color.GRAY);
			g.fillRect(0, 100, 870, 50);
			
			g.setColor(Color.WHITE);
			for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
				for(int b=0;b<getWidth();b+=40) {
					g.fillRect(b, 120, 30, 5);
				}
			}
		g.setColor(Color.GRAY);
		g.fillRect(350, 0, 50, 600);
		
		g.setColor(Color.WHITE);
		for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
			for(int b=0;b<getHeight();b+=40) {
				g.fillRect(375, b, 5, 30);
			}
		}}
		
		
		
		
		
		
		else if(roads<=6) {
			g.setColor(Color.GRAY);
			g.fillRect(0, 100, 870, 50);
			
			g.setColor(Color.WHITE);
			for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
				for(int b=0;b<getWidth();b+=40) {
					g.fillRect(b, 120, 30, 5);
				}
			}
		g.setColor(Color.GRAY);
		g.fillRect(350, 0, 50, 600);
		
		g.setColor(Color.WHITE);
		for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
			for(int b=0;b<getHeight();b+=40) {
				g.fillRect(375, b, 5, 30);
			}
		}
		g.setColor(Color.GRAY);
		g.fillRect(0, 400, 870, 50);
		
		g.setColor(Color.WHITE);
		for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
			for(int b=0;b<getWidth();b+=40) {
				g.fillRect(b, 420, 30, 5);
			}
		}
		}
		
		else if(roads<=10) {
			g.setColor(Color.GRAY);
			g.fillRect(0, 100, 870, 50);
			
			g.setColor(Color.WHITE);
			for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
				for(int b=0;b<getWidth();b+=40) {
					g.fillRect(b, 120, 30, 5);
				}
			}
		g.setColor(Color.GRAY);
		g.fillRect(350, 0, 50, 600);
		
		g.setColor(Color.WHITE);
		for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
			for(int b=0;b<getHeight();b+=40) {
				g.fillRect(375, b, 5, 30);
			}
		}
		g.setColor(Color.GRAY);
		g.fillRect(0, 400, 870, 50);
		
		g.setColor(Color.WHITE);
		for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
			for(int b=0;b<getWidth();b+=40) {
				g.fillRect(b, 420, 30, 5);
			}
		}
		g.setColor(Color.GRAY);
		g.fillRect(150, 400, 50, 600);
		
		g.setColor(Color.WHITE);
		for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
			for(int b=430;b<getHeight();b+=40) {
				g.fillRect(173, b, 5, 30);
			}
		}
		
		
		
		g.setColor(Color.GRAY);
		g.fillRect(650, 400, 50, 600);
		
		g.setColor(Color.WHITE);
		for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
			for(int b=430;b<getHeight();b+=40) {
				g.fillRect(673, b, 5, 30);
			}
		}}
//		signal(372, 60,g,false,false,true,false);
//		signal(310, 117,g,false,false,true,true);
//		signal(372, 150,g,false,true,true,false);
//		signal(372, 360,g,false,true,true,false);
//		signal(395, 117,g,false,false,true,true);
//		signal(170, 445,g,true,false,true,false);
//		signal(372, 445,g,true,false,true,false);
//		signal(670, 445,g,true,false,true,false);	
		
//		s=new Signal(true,false,false,372, 60,false);
//		s.setSignal(false, true, false);

//		signal(310, 117,g,true,false,false,true);
//		signal(372, 150,g,true,false,false,false);
//		signal(372, 360,g,true,false,false,false);
//		signal(395, 117,g,true,false,false,true);
//		signal(170, 445,g,true,false,false,false);
//		signal(372, 445,g,true,false,false,false);
//		signal(670, 445,g,true,false,false,false);	
		
		for(int a=0;a<s.size();a++) {
			s.get(a).paint_component(g);
		}

		for(int a=0;a<v.size();a++) {
			v.get(a).paint_component(g);
		}
	}
	public void step() {
		for(int i=0;i<v.size();i++) {
			Vehicle vehicle=v.get(i);
			
			
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
					if(s.size()!=0) {
					if(count==0) {
						s.get(count).set_signal_color(false, false, true);
						
					}
					else {
						if(s.size()==5 & count==5) {s.get(count-2).set_signal_color(true, false, false);
						s.get(count-1).set_signal_color(false, false, true);}
						else {
							s.get(count-1).set_signal_color(true, false, false);
							s.get(count).set_signal_color(false, false, true);
						}
						
					}}
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
	public void setSignal(int i,boolean r,boolean y,boolean g) {
		s.get(i).set_signal_color(r, y, g);
	}
}
