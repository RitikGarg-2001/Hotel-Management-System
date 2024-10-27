package hotelmanagementproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    
    JButton admin, newCustomer, rooms, checkout, update, roomStatus, pickup, searchRoom, logout;
    
    Dashboard() {
    
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        admin = new JButton("Admin"); 
        admin.setBounds(10,20,200,90);
        admin.setFont(new Font("Times New Romes", Font.BOLD,50));
        admin.addActionListener(this);
        add(admin);
        
        newCustomer = new JButton("New Customer Form"); 
        newCustomer.setBounds(10,130,200,90);
        newCustomer.addActionListener(this);
        add(newCustomer);
        
        rooms = new JButton("Rooms"); 
        rooms.setBounds(10,230,200,30);
        rooms.addActionListener(this);
        add(rooms);
        
        checkout = new JButton("Checkout"); 
        checkout.setBounds(10,270,200,30);
        checkout.addActionListener(this);
        add(checkout);
        
        update = new JButton("Update Status"); 
        update.setBounds(10,310,200,30);
        update.addActionListener(this);
        add(update);
        
        roomStatus = new JButton("Update Room Status"); 
        roomStatus.setBounds(10,350,200,30);
        roomStatus.addActionListener(this);
        add(roomStatus);
        
        pickup = new JButton("Pickup Service"); 
        pickup.setBounds(10,390,200,30);
        pickup.addActionListener(this);
        add(pickup);
        
        searchRoom = new JButton("Search Room"); 
        searchRoom.setBounds(10,430,200,30);
        searchRoom.addActionListener(this);
        add(searchRoom);
        
        logout = new JButton("Log Out"); 
        logout.setBounds(10,470,200,30);
        logout.addActionListener(this);
        add(logout);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/reception.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,570,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(215,0,600,570);
        add(image);
 
        
        setBounds(400,100,800,570);
        setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == newCustomer) {
            setVisible(false);
            new AddCustomer();
        }  else if(ae.getSource() == admin) {
            setVisible(false);
            new AdminPage();
        }  else if(ae.getSource() == rooms) {
            setVisible(false);
            new RoomInfo();
        }   else if(ae.getSource() == searchRoom) {
            setVisible(false);
            new SearchRoom();
        }   else if(ae.getSource() == update) {
            setVisible(false);
            new UpdateCustomerInfo();
        }   else if(ae.getSource() == roomStatus) {
            setVisible(false);
            new UpdateRoom();
        }   else if(ae.getSource() == checkout) {
            setVisible(false);
            new Checkout();
        }   else if(ae.getSource() == pickup) {
            setVisible(false);
            new Pickup();
        }   else if(ae.getSource() == logout) {
            System.exit(0);
        }
    }
    
    public static void main(String[] args){
    
        new Dashboard();
        
    }
    
}

