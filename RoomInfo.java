
package hotelmanagementproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class RoomInfo extends JFrame implements ActionListener {
   
    JTable table;
    JButton back;
    
    RoomInfo(){
       
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/room2.jpg"));
        Image i2  = i1.getImage().getScaledInstance(550,550,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(520,20,500,530);
        add(image);
        
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(7,20,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Availablity");
        l2.setBounds(120,20,80,20);
        add(l2);
        
        JLabel l3 = new JLabel("Status");
        l3.setBounds(220,20,80,20);
        add(l3);
        
        JLabel l4 = new JLabel("Price");
        l4.setBounds(320,20,80,20);
        add(l4);
        
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(410,20,90,20);
        add(l5);
        
        table = new JTable();
        table.setBounds(0,40,500,400);
        add(table);
        
        try{
            
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch(Exception e) {
            
            e.printStackTrace();
        
        }
        
        back = new JButton("Back");
        back.setBounds(380,498,120,30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setBounds(300,120,1050,600);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
    
        setVisible(false);
        new Dashboard();
        
    }
    
    public static void main(String[] args){
        new RoomInfo();
    }
    
}
