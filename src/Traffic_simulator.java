import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;

public class Traffic_simulator extends JFrame implements Runnable,ActionListener {
	//Define vehicles and traffic and city for running
	private Vehicle vehicle[]=new Vehicle[30]; 
	private Create_new_city new_city[]=new Create_new_city[5];
	int city=0;

	//get city file
	private City_map map =new City_map();
	private Traffic_light current_traffic_light;
	private JPanel whole_content_screen;
	private boolean program_run =false;
	boolean open =false;
	int index=0;
	int i=0;

	//define run stop button label for simulation mode
	private JLabel label=new JLabel("");
	JButton run_button = new JButton("Run\r\n");
	JButton stop_button = new JButton("Stop");
	private int total=0;
	int count=0;

	//set main function to run the whole program
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Traffic_simulator frame = new Traffic_simulator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//create frame layout for the whole program
	public Traffic_simulator() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1058, 629);

		//set layout whole
		whole_content_screen = new JPanel();
		whole_content_screen.setBackground(Color.white);

		//set layout of screen
		whole_content_screen.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(whole_content_screen);
		whole_content_screen.setLayout(null);
		whole_content_screen.add(map);

		//set signal and button size
		addSignal(-10,0);
		stop_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		stop_button.setBounds(40, 217, 89, 23);
		stop_button.addActionListener(this);
		whole_content_screen.add(stop_button);
		
		//set font and button size
		run_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		run_button.setBounds(40, 154, 89, 23);
		run_button.addActionListener(this);

		whole_content_screen.add(run_button);

		//set button for city editing simulation mode
		JButton open_city_button = new JButton("Open\r\n");

		//set button component
		open_city_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		open_city_button.setBounds(40, 271, 89, 23);
		open_city_button.setVisible(false);
		whole_content_screen.add(open_city_button);

		//set button for edit simulation mode
		JButton edit_city_button = new JButton("Edit");
		//set button component
		edit_city_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		edit_city_button.setBounds(40, 217, 89, 23);
		edit_city_button.setVisible(false);
		whole_content_screen.add(edit_city_button);

		//set button for create simulation mode
		JButton create_city_button = new JButton("Create");

		//set button component
		create_city_button.setFont(new Font("Tahoma", Font.BOLD, 15));
		create_city_button.setBounds(40, 154, 89, 23);
		whole_content_screen.add(create_city_button);

		//set title menu
		JLabel TOP_LABEL_LABEL = new JLabel("TRAFFIC");
		TOP_LABEL_LABEL.setBounds(56, 11, 99, 35);
		TOP_LABEL_LABEL.setFont(new Font("Tahoma", Font.BOLD, 20));
		TOP_LABEL_LABEL.setForeground(Color.BLACK);
		whole_content_screen.add(TOP_LABEL_LABEL);

		//set city button
		JButton city_mode_button = new JButton("City\r\n");

		//set city button component
		city_mode_button.setBounds(15, 81, 150, 23);
		city_mode_button.setFont(new Font("Tahoma", Font.BOLD, 20));
		whole_content_screen.add(city_mode_button);

		//set simulation mode button
		JButton simulation_mode_button = new JButton("Simulation");

		//set simulation mode button component
		simulation_mode_button.setBounds(15, 105, 150, 23);
		simulation_mode_button.setFont(new Font("Tahoma", Font.BOLD, 20));
		whole_content_screen.add(simulation_mode_button);

		//set label for getting mode information
		JLabel mode_labeling = new JLabel("Mode: Simulator");
		mode_labeling.setForeground(Color.BLACK);
		mode_labeling.setFont(new Font("Tahoma", Font.BOLD, 20));
		mode_labeling.setBounds(10, 388, 170, 23);
		whole_content_screen.add(mode_labeling);

		//set status label
		JLabel Status_label = new JLabel("Status:");
		Status_label.setForeground(Color.BLACK);
		Status_label.setFont(new Font("Tahoma", Font.BOLD, 20));
		Status_label.setBounds(10, 432, 119, 23);
		whole_content_screen.add(Status_label);

		//set current city status
		JLabel current_city_status = new JLabel("City: Default");
		current_city_status.setForeground(Color.BLACK);
		current_city_status.setFont(new Font("Tahoma", Font.BOLD, 16));
		current_city_status.setBounds(31, 466, 108, 23);
		whole_content_screen.add(current_city_status);

		//set vehicles count label
		JLabel vehicles_count = new JLabel("Vehicles:");
		vehicles_count.setForeground(Color.BLACK);
		vehicles_count.setFont(new Font("Tahoma", Font.BOLD, 16));
		vehicles_count.setBounds(31, 500, 99, 23);
		whole_content_screen.add(vehicles_count);

		//change every time vehicles spawn in
		label.setText(String.valueOf(total));
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(104, 500, 67, 23);
		whole_content_screen.add(label);

		//open city button listener
		open_city_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//create checking for current city
				if(city>0) {
					String name=JOptionPane.showInputDialog("Enter city name");
					for(int i=0;i<city;i++) {

						if(new_city[i].name.equalsIgnoreCase(name)) {
							//set visible of buttons
							open=true;
							index= new_city[i].roads;
							i=i;
							new_city[i].setVisible(true);
							run_button.setVisible(true);
							stop_button.setVisible(true);

							open_city_button.setVisible(false);
							edit_city_button.setVisible(false);
							create_city_button.setVisible(false);
							mode_labeling.setText("Mode: Sim");
							current_city_status.setText("City:"+ new_city[i].name);
							current_city_status.setVisible(true);
							vehicles_count.setVisible(true);
							label.setVisible(true);
							total=0;

						}
					}

				}
				else {
					JOptionPane.showMessageDialog(whole_content_screen, "No Cities Found!");
				}
			}
		});

		//add action listener for button press simulation mode
		simulation_mode_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//set visible of simulation buttons
				run_button.setVisible(true);
				stop_button.setVisible(true);
				open_city_button.setVisible(false);
				edit_city_button.setVisible(false);
				create_city_button.setVisible(false);
				mode_labeling.setText("Mode: Sim");
				current_city_status.setVisible(true);
				vehicles_count.setVisible(true);
				label.setVisible(true);
				map.setVisible(true);
				
			}
		});

		//set city mode button button listener
		city_mode_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				run_button.setVisible(false);
				stop_button.setVisible(false);
			
				open_city_button.setVisible(true);
				edit_city_button.setVisible(true);
				create_city_button.setVisible(true);
				Status_label.setVisible(false);
				mode_labeling.setText("Mode: City");
				current_city_status.setVisible(false);
				vehicles_count.setVisible(false);
				label.setVisible(false);
			}
		});

		
		//set edit city button listener
		edit_city_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open_city_button.setVisible(false);
				edit_city_button.setVisible(false);
				run_button.setVisible(false);
				stop_button.setVisible(false);
				create_city_button.setVisible(false);
				JOptionPane j=new JOptionPane();
				if(city!=0) {
				String name=j.showInputDialog("Enter city name");
				int i=0;

				//initialize when click
				while(i!=city) {
					if(new_city[i].name.equalsIgnoreCase(name)) {
						int roads=Integer.parseInt(j.showInputDialog("Enter no of Roads "));
						new_city[i].roads=roads;
						JOptionPane.showMessageDialog(whole_content_screen, new_city[i].name+" Edited succesfully!");
						for(int m=0;m<city;m++) {
							new_city[m].setVisible(false);
						}
						new_city[i].s.clear();
						addSignal(roads,i);	
						new_city[i].setVisible(true);
					}
					i++;
				}
				
				}
				else {
					JOptionPane.showMessageDialog(whole_content_screen, "No Cities Found!");
					
				}
				open_city_button.setVisible(true);
				edit_city_button.setVisible(true);
				create_city_button.setVisible(true);
			}
			
		});

		//set city button listener to create city
		create_city_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(city<5) {
					map.setVisible(true);
					open_city_button.setVisible(false);
					edit_city_button.setVisible(false);
					create_city_button.setVisible(false);
					JOptionPane j=new JOptionPane();
					String name=j.showInputDialog("Enter city name");
					int roads=Integer.parseInt(j.showInputDialog("Enter no of Roads"));

					run_button.setVisible(false);
					stop_button.setVisible(false);
					open_city_button.setVisible(true);
					edit_city_button.setVisible(true);
					create_city_button.setVisible(true);
					Status_label.setVisible(false);
					mode_labeling.setText("Mode: City");
					current_city_status.setVisible(false);
					vehicles_count.setVisible(false);
					label.setVisible(false);

					//call function of creating new city
					Create_new_city create=new Create_new_city(name,roads);
					new_city[city]=create;
					j.showMessageDialog(whole_content_screen, "You have created a city "+name+".");
					map.setVisible(false);
					whole_content_screen.add(new_city[city]);
					for(int i=0;i<city;i++) {
						new_city[i].setVisible(false);
					}
					addSignal(new_city[city].roads,city);
					new_city[city].setVisible(true);
					city++;

				}
				else {
					JOptionPane.showMessageDialog(whole_content_screen, "NO CITIES MORE THAN 5");
				}


			}
		});

		
	}

	//checking function
	public void check() {
		for(int j=0;j<total;j++) {

			if(vehicle[j].check==true) {
				for(int k=j;k<total;k++) {
					vehicle[k]=vehicle[k+1];
				}
				total--;
			}
			
		}
	}

	//add traffic light signal
	public void addSignal(int index,int i) {
		if(index>0 & index<=2) {
			//NO TRAFFIC LIGHT FOR ROAD UNDER 2 ROADS
		}
		else if(index>2 & index<=4) {
			//set traffic light for 2-4 roads
			new_city[i].addSignal(new Traffic_light(true,false,false,310, 117,true));
			new_city[i].addSignal(new Traffic_light(true,false,false,372, 60,false));
			new_city[i].addSignal(new Traffic_light(true,false,false,372, 150,false));
			new_city[i].addSignal(new Traffic_light(true,false,false,395, 117,true));
		}
		else if(index>4 & index<=6) {
			//set traffic light for 4-6 roads
			new_city[i].addSignal(new Traffic_light(true,false,false,310, 117,true));
			new_city[i].addSignal(new Traffic_light(true,false,false,372, 60,false));
			new_city[i].addSignal(new Traffic_light(true,false,false,372, 150,false));
			new_city[i].addSignal(new Traffic_light(true,false,false,395, 117,true));
			new_city[i].addSignal(new Traffic_light(true,false,false,372, 445,false));
		}
		else if(index>6 &  index<=8) {
			//set traffic light for 6-8 roads
			current_traffic_light =new Traffic_light(true,false,false,310, 117,true);
			new_city[i].addSignal(current_traffic_light);
			current_traffic_light =new Traffic_light(true,false,false,372, 60,false);
			new_city[i].addSignal(current_traffic_light);
			current_traffic_light =new Traffic_light(true,false,false,372, 150,false);
			new_city[i].addSignal(current_traffic_light);
			current_traffic_light =new Traffic_light(true,false,false,395, 117,true);
			new_city[i].addSignal(current_traffic_light);
			current_traffic_light =new Traffic_light(true,false,false,170, 445,false);
			new_city[i].addSignal(current_traffic_light);
			current_traffic_light =new Traffic_light(true,false,false,372, 445,false);
			new_city[i].addSignal(current_traffic_light);
			current_traffic_light =new Traffic_light(true,false,false,672, 445,false);
			new_city[i].addSignal(current_traffic_light);
		}
	else {
		//adding traffic light
		map.addSignal(new Traffic_light(true,false,false,310, 117,true));
		map.addSignal(new Traffic_light(true,false,false,372, 60,false));
		map.addSignal(new Traffic_light(true,false,false,372, 150,false));
		map.addSignal(new Traffic_light(true,false,false,395, 117,true));
		map.addSignal(new Traffic_light(true,false,false,170, 445,false));
		map.addSignal(new Traffic_light(true,false,false,372, 445,false));
		map.addSignal(new Traffic_light(true,false,false,672, 445,false));}
	}
	public void addVehicle(int index,int i) {
		if(index>0 & index<=2) {
			//add vehicle function for road under 2
			vehicle[total]=new Vehicle_bus(804, 135);
			vehicle[total].turn3();
			new_city[i].addVehicle(vehicle[total]);
			total++;
		}
		else if(index>2 & index<=4) {
			//add vehicle function for road under 4
			int spawn_chance=(int) (Math.random() * 3);
			if(spawn_chance==0) {

				vehicle[total]=new Vehicle_bus(804, 135);
				vehicle[total].turn3();
				new_city[i].addVehicle(vehicle[total]);
				total++;}
		
			else if(spawn_chance==1) {
				vehicle[total]=new Vehicle_car(354, 0);
				vehicle[total].turn1();
				new_city[i].addVehicle(vehicle[total]);
				total++;}
		}
		else if(index>4 & index<=6) {
			//add vehicle function for road under 2
			int spawn_chance=(int) (Math.random() * 5);
			if(spawn_chance==0) {
				vehicle[total]=new Vehicle_bus(804, 135);
				vehicle[total].turn3();
				new_city[i].addVehicle(vehicle[total]);
				total++;}
		
			else if(spawn_chance==1) {
				vehicle[total]=new Vehicle_car(354, 0);
				vehicle[total].turn1();
				new_city[i].addVehicle(vehicle[total]);
				total++;}
		
			else if(spawn_chance==2) {
			vehicle[total]=new Vehicle_bike(385, 580);
			vehicle[total].turn2();
			new_city[i].addVehicle(vehicle[total]);
			total++;}
			else if(spawn_chance==3) {
			
			vehicle[total]=new Vehicle_car(0, 404);

			new_city[i].addVehicle(vehicle[total]);
			total++;}
		}
		else if(index>6 &  index<=8) {
		//add vehicle function for road under 8
			int spawn_chance=(int) (Math.random() * 5);
			if(spawn_chance==0) {
				vehicle[total]=new Vehicle_bus(804, 135);
				vehicle[total].turn3();
				new_city[i].addVehicle(vehicle[total]);
				total++;}
		
			else if(spawn_chance==1) {
				vehicle[total]=new Vehicle_car(354, 0);
				vehicle[total].turn1();
				new_city[i].addVehicle(vehicle[total]);
				total++;}
		
			else if(spawn_chance==2) {
			vehicle[total]=new Vehicle_bike(385, 580);
			vehicle[total].turn2();
			new_city[i].addVehicle(vehicle[total]);
			total++;}
			else if(spawn_chance==3) {
			
			vehicle[total]=new Vehicle_car(0, 404);

			new_city[i].addVehicle(vehicle[total]);
			total++;}
			else if(spawn_chance==4) {
				vehicle[total]=new Vehicle_bike(185, 580);
				vehicle[total].turn2();
				map.addVehicle(vehicle[total]);
				total++;}
			else if(spawn_chance==5) {
				vehicle[total]=new Vehicle_bike(685, 580);
				vehicle[total].turn2();
				map.addVehicle(vehicle[total]);
				total++;}
		}
		

		else {
			int spawn_chance=(int) (Math.random() * 5);
			if(spawn_chance==0) {
				//chance to spawn bike
			vehicle[total]=new Vehicle_bike(185, 580);
			vehicle[total].turn2();
			map.addVehicle(vehicle[total]);
			total++;}
		
			else if(spawn_chance==1) {
				//chance to spawn car
			vehicle[total]=new Vehicle_car(385, 580);
			vehicle[total].turn2();
			map.addVehicle(vehicle[total]);
			total++;}
		
			else if(spawn_chance==2) {
				//chance to spawn bike
			vehicle[total]=new Vehicle_bike(685, 580);
			vehicle[total].turn2();
			map.addVehicle(vehicle[total]);
			total++;}
			else if(spawn_chance==3) {
				//chance to add car
			vehicle[total]=new Vehicle_car(354, 0);
			vehicle[total].turn1();
			map.addVehicle(vehicle[total]);
			total++;}
			
			else if(spawn_chance==4) {
				//chance fo spawn bus
				vehicle[total]=new Vehicle_bus(810, 135);
				vehicle[total].TURN_3 =true;
				map.addVehicle(vehicle[total]);
				
				total++;}
			
			else {
			vehicle[total]=new Vehicle_bus(0, 404);
			map.addVehicle(vehicle[total]);
			total++;	}
		}
	}

	//running function and adding new vehicles for every set of time
	public void run() {
		while(program_run ==true & open==false) {
			//set map repainting for every time
			map.step();
			map.repaint();
			check();
			label.setText(String.valueOf(total));
			if(count==10 & total!=29) {
				addVehicle(-10,0);
				count=0;
			}
			count++;

			try {
				Thread.sleep(500);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

		while(program_run ==true & open==true) {
			
			new_city[i].step();
			new_city[i].repaint();
			check();
			label.setText(String.valueOf(total));
			if(count==10 & total!=29) {
				addVehicle(index,i);
				count=0;
				
			}

			count++;
			
			
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {
				e.printStackTrace();
			}}
		}

	//set threading for the simulation to start
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(run_button)) {
			
			if(program_run ==false) {
				program_run =true;
				Thread t=new Thread(this);
				t.start();
			}
			}
		if(event.getSource().equals(stop_button)) {
			program_run =false;
		}
	}
	
	
}

