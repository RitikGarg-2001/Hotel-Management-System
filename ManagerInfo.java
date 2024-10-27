package hotelamanagementproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class ManagerInfo extends JFrame implements ActionListener {
   
    JTable table;
    JButton back;
    
    ManagerInfo(){
       
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel name = new JLabel("Name");
        name.setBounds(50,20,100,20);
        add(name);
        
        JLabel age = new JLabel("Age");
        age.setBounds(180,20,100,20);
        add(age);
        
        JLabel gender = new JLabel("Gander");
        gender.setBounds(290,20,100,20);
        add(gender);
        
        JLabel job = new JLabel("Job");
        job.setBounds(420,20,80,20);
        add(job);
        
        JLabel sal = new JLabel("Salary");
        sal.setBounds(530,20,80,20);
        add(sal);
        
        JLabel mobile = new JLabel("Mobile No.");
        mobile.setBounds(640,20,80,20);
        add(mobile);
        
        JLabel email = new JLabel("Email id");
        email.setBounds(760,20,80,20);
        add(email);
        
        JLabel addhar = new JLabel("Addhar No.");
        addhar.setBounds(885,20,80,20);
        add(addhar);
        
        table = new JTable();
        table.setBounds(10,50,970,350);
        add(table);
        
        try{
            
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from employee where job = 'Manager'");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch(Exception e) {
            
            e.printStackTrace();
        
        }
        
        back = new JButton("Back");
        back.setBounds(880,500,100,50);
        back.addActionListener(this);
        add(back);
        
        
        
        setBounds(300,75,1000,600);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
    
        setVisible(false);
        new AdminDashboard();
        
    }
    
    public static void main(String[] args){
        new ManagerInfo();
    }
    
}
