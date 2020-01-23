import java.awt.Graphics;

public class Vehicle {
	//define variables for getting each type of vehicles speed width height
		int x;
		int y;
		int speed;
		int width;
		int height;
		int VEHICLE_POSITION =0;

	//set road and signal
		String TRAFFIC_ROAD;
		String TRAFFIC_SIGNAL ="";

	//Get turn event
		boolean current=false;
		boolean TURN_1 =false;
		boolean TURN_2 =false;
		boolean TURN_3 =false;
		int BOOM_1 =0;
		int BOOM_2 =0;
		int BOOM_3;
		boolean check=false;
		
		//set class for vehicle to get current place of road
		String PREVIOUS_VEHICLE;
		public Vehicle(int x,int y) {
			//set x y boom
			this.x=x;
			this.y=y;
			this.BOOM_3 =0;
			if(x>=0 & x<=305 & y==104 || y==135 & x>=0 & x<=310) {
				//set road signal
				this.TRAFFIC_ROAD ="r1";
				this.TRAFFIC_SIGNAL ="s1";
				
				
			}
			else if(y>=0 & y<=55 & x==354 || x==385 & y>=0 & y<=60) {
				//set road signal
				this.TRAFFIC_ROAD ="r2";
				this.TRAFFIC_SIGNAL ="s2";
				
				
				
			}
			else if(y<=370 & y>=165 & x==385 ||x==354 & y<=365 & y>=150) {
				//set road signal
				this.TRAFFIC_ROAD ="r3";
				this.TRAFFIC_SIGNAL ="s3";
				
			
			}
			else if(x>=395 & x<=820 & y==135 || x>=395 & x<=820 & y==104) {
				//set road signal
				this.TRAFFIC_ROAD ="r4";
				this.TRAFFIC_SIGNAL ="s4";
				
				
			}
			else if(y<=580 & y>=445 & x==185 || x==155 & y<=580 & y>=445) {
				//set road signal
				this.TRAFFIC_ROAD ="r5";
				this.TRAFFIC_SIGNAL ="s5";
			
			}
			else if(y<=580 & y>=445 & x==385 || y<=580 & y>=445 & x==355 ) {
				//set road signal
				this.TRAFFIC_ROAD ="r6";
				this.TRAFFIC_SIGNAL ="s6";
				
				
			}
			else if(y<=580 & y>=445 & x==685 || y<=580 & y>=445 & x==655) {
				this.TRAFFIC_ROAD ="r7";
				this.TRAFFIC_SIGNAL ="s7";
				
				
			}
			else if(x>=0 & x<=820 & y==404 || x>=0 & x<=820 & y==432 ) {
				this.TRAFFIC_ROAD ="main";
				this.TRAFFIC_SIGNAL ="main";
			
				
			}
			
		}
		public void paint_component(Graphics g) {
			//set paint component but take super
		}
		public void setVEHICLE_POSITION(int p) {
			//setposition vehicle
			this.VEHICLE_POSITION =p;
		}
		
		public int getSpeed() {
			return speed;
		}
		
		public void setSpeed(int speed) {
			this.speed = speed;
		}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
		
		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		//setter for road
		public void setRoad(int x,int y) {
			if(x>=-40 & x<=305 & y==104 || y==135 & x>=0 & x<=310) {
				//set road condition 1
				this.TRAFFIC_ROAD ="r1";
				this.TRAFFIC_SIGNAL ="s1";
				this.current=false;
				this.PREVIOUS_VEHICLE =this.TRAFFIC_ROAD;
				if(x<-20) {
					check=true;
				}
				
			}
			else if(y>=0 & y<=55 & x==354 || x==385 & y>-30 & y<=60) {
				//set road condition 2
				this.TRAFFIC_ROAD ="r2";
				this.TRAFFIC_SIGNAL ="s2";
				this.current=false;
				this.PREVIOUS_VEHICLE =this.TRAFFIC_ROAD;
				if(y<-20) {
					check=true;
				}
				
			}
			else if(y<=370 & y>=165 & x==385 ||x==354 & y<=355 & y>=150) {
				//set road condition 3
				this.TRAFFIC_ROAD ="r3";
				this.TRAFFIC_SIGNAL ="s3";
				this.current=false;
				this.PREVIOUS_VEHICLE =this.TRAFFIC_ROAD;
			}
			else if(x>=409 & x<=820 & y==135 || x>=390 & x<=890 & y==104) {
				//set road condition 4
				this.TRAFFIC_ROAD ="r4";
				this.TRAFFIC_SIGNAL ="s4";
				this.current=false;
				this.PREVIOUS_VEHICLE =this.TRAFFIC_ROAD;
				if(x>870) {
					check=true;
				}
				
			}
			else if(y<=560 & y>=465 & x==185 || x==155 & y<=560 & y>=445) {
				//set road condition 5
				this.TRAFFIC_ROAD ="r5";
				this.TRAFFIC_SIGNAL ="s5";
				this.current=false;
				this.PREVIOUS_VEHICLE =this.TRAFFIC_ROAD;
			}
			else if(y<=560 & y>=465 & x==385 || y<=560 & y>=445 & x==355 ) {
				//set road condition 6
				this.TRAFFIC_ROAD ="r6";
				this.TRAFFIC_SIGNAL ="s6";
				this.current=false;
				this.PREVIOUS_VEHICLE =this.TRAFFIC_ROAD;
			}
			else if(y<=560 & y>=465 & x==685 || y<=560 & y>=445 & x==655) {
				//set road condition 7
				this.TRAFFIC_ROAD ="r7";
				this.TRAFFIC_SIGNAL ="s7";
				this.current=false;
				this.PREVIOUS_VEHICLE =this.TRAFFIC_ROAD;
			}
			else if(x>=0 & x<=820 & y==404 || x>=0 & x<=850 & y==432 ) {
				//set road condition 8
				this.TRAFFIC_ROAD ="main";
				this.PREVIOUS_VEHICLE =this.TRAFFIC_ROAD;
				this.TRAFFIC_SIGNAL ="main";
				if(this.x>780) {
					this.check=true;
				}
			}
			else {
				this.TRAFFIC_ROAD ="in";
				if(this.BOOM_3 >=3) {
					this.current=true;
				if(this.BOOM_1 >=3) {
					if(this.PREVIOUS_VEHICLE.equals("r1")) {
						//previous vehicle
						this.y=59;
						this.x=385;
						turn2();
						this.TURN_1 =false;
						this.TURN_3 =false;
						this.TRAFFIC_ROAD ="r2";
						this.PREVIOUS_VEHICLE =this.TRAFFIC_ROAD;
						BOOM_1 =0;
						
						
					}
					else if(this.PREVIOUS_VEHICLE.equals("r2")) {
						if(BOOM_1 ==3 & BOOM_2 ==0) {
							//previous vehicle
							this.TURN_2 =false;
							this.TURN_1 =false;
							this.TURN_3 =false;
							this.TRAFFIC_ROAD ="in";
							turn();
							BOOM_1 =0;
							
						}
						if(BOOM_2 ==1) {
							//previous vehicle
							this.y=104;
							this.x=392;
							this.TRAFFIC_ROAD ="r4";
							BOOM_2 =0;
							this.PREVIOUS_VEHICLE =this.TRAFFIC_ROAD;
							
						}
						BOOM_2++;
						
					}
					else if(this.TRAFFIC_ROAD.equals("r3")) {
						//previous vehicle
					
					}
					else if(this.TRAFFIC_ROAD.equals("r4")) {
						//previous vehicle
					}
					else if(this.PREVIOUS_VEHICLE.equals("r5")) {
						//previous vehicle

						this.y=404;
						this.x=190;
						this.TURN_2 =false;
						this.TURN_1 =false;
						this.TURN_3 =false;
						this.TRAFFIC_ROAD ="main";
						BOOM_1 =0;
						turn();
					}
					else if(this.PREVIOUS_VEHICLE.equals("r6")) {
						//previous vehicle
						this.y=404;
						this.x=390;
						this.TURN_2 =false;
						this.TURN_1 =false;
						this.TURN_3 =false;
						this.TRAFFIC_ROAD ="main";
						BOOM_1 =0;
						turn();
					}
					else if(this.PREVIOUS_VEHICLE.equals("r7")) {
						//previous vehicle
						this.y=404;
						this.x=690;
						this.TURN_2 =false;
						this.TURN_1 =false;
						this.TURN_3 =false;
						this.TRAFFIC_ROAD ="main";
						BOOM_1 =0;
						turn();
						
					}
				}
				BOOM_1++;
			}
				this.BOOM_3++;}
		}

		//set turn method for getting turn 1 or turn 2 or turn 3
		public void turn() {
			int t=this.width;
			this. width=this.height;
			this.height=t;
		}
		
		public void turn1() {
			if(this.TURN_1 ==false) {
			int t=0;
			t=this.height;
			this.height=this.width;
			this.width=t;
			this.TURN_1 =true;
			
			}
			else {
				int t=0;
				t=this.height;
				this.height=this.width;
				this.width=t;
				this.TURN_1 =false;
			}
		}
		public void turn2() {
			if(this.TURN_2 ==false) {
			int t=0;
			t=this.height;
			this.height=this.width;
			this.width=t;
			this.TURN_2 =true;
			
			}
			else {
				int t=0;
				t=this.height;
				this.height=this.width;
				this.width=t;
				this.TURN_2 =false;
			}
		}
		public void turn3() {
			if(this.TURN_3 ==false) {
				this.TURN_3 =true;
			
			}
			else {
				this.TURN_3 =false;
			}
		}
	}

