package hotelmanagementproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener {
   
    JTable table;
    JButton back;
    
    Department(){
       
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(180,20,100,20);
        add(l3);
        
        JLabel l1 = new JLabel("Department");
        l1.setBounds(350,20,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Salary");
        l2.setBounds(550,20,80,20);
        add(l2);
        
        
        table = new JTable();
        table.setBounds(120,50,550,350);
        add(table);
        
        try{
            
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select name,job, salary from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch(Exception e) {
            
            e.printStackTrace();
        
        }
        
        back = new JButton("Back");
        back.setBounds(680,300,100,50);
        back.addActionListener(this);
        add(back);
        
        
        
        setBounds(400,200,800,400);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
    
        setVisible(false);
        new AdminDashboard();
        
    }
    
    public static void main(String[] args){
        new Department();
    }
    
}

