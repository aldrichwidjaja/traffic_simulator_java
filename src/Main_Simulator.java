import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TimerTask;
import java.util.Timer;

public class Main_Simulator implements ActionListener, Runnable {

    JFrame frame = new JFrame("Traffic Simulation");

    Road_Straight straight;

    Container south = new Container();
    Container west = new Container();

    JButton start = new JButton(("Start"));
    JButton stop = new JButton(("Stop"));
    JLabel throughput = new JLabel("SPAWNED VEHICLE: 0");

    JButton car = new JButton("car");
    JButton bus = new JButton("bus");
    JButton motorbike = new JButton("motorbike");


    int carcount =  0;
    long start_time = 0;

    boolean running = false;


    public Main_Simulator() {
        frame.setSize(  800,800);
        frame.setLayout(new BorderLayout());

        straight = new Road_Straight();
        frame.add(straight, BorderLayout.CENTER);

        //SOUTH THINGSSSS
        south.setLayout(new GridLayout(1,3));
        south.add(start);
        start.addActionListener(this);
        south.add(stop);
        stop.addActionListener(this);
        south.add(throughput);
        frame.add(south, BorderLayout.SOUTH);

        //WEST THINGSSSS
        west.setLayout(new GridLayout(3,1));
        west.add(car);
        car.addActionListener(this);
        west.add(bus);
        bus.addActionListener(this);
        west.add(motorbike);
        motorbike.addActionListener(this);
        frame.add(west, BorderLayout.WEST);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        new Main_Simulator();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(start)) {
            if (running == false) {
                running = true;
                Thread t2 = new Thread(this);
                t2.start();
            }
        }
        if (event.getSource().equals(stop)) {
            running = false;
        }
        if (event.getSource().equals(car)) {
            Vehicle_Car car = new Vehicle_Car(0, 20);
            straight.addCar(car);
            carcount++;
            throughput.setText("SPAWNED VEHICLE: "+carcount);
            for (int x = 0; x < straight.ROAD_WIDTH; x = x + 20) {
                for (int y = 20; y < 160; y = y + 80) {
                    car.setX(x);
                    car.setY(y);
                    if (straight.collision(x, y, car) == false) {
                        frame.repaint();
                        return;
                    }
                }
            }
        }
        if (event.getSource().equals(bus)) {
            Vehicle_Bus bus = new Vehicle_Bus(0, 20);
            straight.addCar(bus);
            carcount++;
            throughput.setText("SPAWNED VEHICLE: "+carcount);
            for (int x = 0; x < straight.ROAD_WIDTH; x = x + 20) {
                for (int y = 20; y < 160; y = y + 80) {
                    bus.setX(x);
                    bus.setY(y);
                    if (straight.collision(x, y, bus) == false) {
                        frame.repaint();
                        return;
                    }
                }
            }
        }
        if (event.getSource().equals(motorbike)) {
            Vehicle_Motorbike motorbike = new Vehicle_Motorbike(0, 20);
            straight.addCar(motorbike);
            carcount++;
            throughput.setText("SPAWNED VEHICLE: "+carcount);
            for (int x = 0; x < straight.ROAD_WIDTH; x = x + 20) {
                for (int y = 20; y < 160; y = y + 80) {
                    motorbike.setX(x);
                    motorbike.setY(y);
                    if (straight.collision(x, y, motorbike) == false) {
                        frame.repaint();
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void run() {
        while (running == true) {
            straight.step();
            frame.repaint();
            try {
                Thread.sleep(100);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
