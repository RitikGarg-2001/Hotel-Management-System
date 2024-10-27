package hotelmanagementproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {
   
    JTable table;
    JButton back, submit;
    JComboBox bedType;
    JCheckBox available;
    
    SearchRoom(){
       
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("Search for Room");
        text.setFont(new Font("Tahoma", Font.BOLD,25));
        text.setBounds(400,30,300,30);
        add(text);
        
        JLabel text2 = new JLabel("Bed Type");
        text2.setBounds(50,100,100,25);
        add(text2);
        
        bedType = new JComboBox(new String[] {"Single Bed", "Double Bed"});
        bedType.setBounds(150,100,150,25);
        bedType.setBackground(Color.white);
        add(bedType);
        
        available = new JCheckBox("Only Display Available");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.white);
        add(available);
        
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(50,180,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Availablity");
        l2.setBounds(270,180,80,20);
        add(l2);
        
        JLabel l3 = new JLabel("Status");
        l3.setBounds(470,180,80,20);
        add(l3);
        
        JLabel l4 = new JLabel("Price");
        l4.setBounds(670,180,80,20);
        add(l4);
        
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(870,180,90,20);
        add(l5);
        
        table = new JTable();
        table.setBounds(0,200,1000,400);
        add(table);
        
        try{
            
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch(Exception e) {
            
            e.printStackTrace();
        
        }
        
        back = new JButton("Back");
        back.setBounds(10,10,120,30);
        back.addActionListener(this);
        add(back);
        
        submit = new JButton("Submit");
        submit.setBounds(870,10,120,30);
        submit.addActionListener(this);
        add(submit);
                
        setBounds(300,100,1010,600);
        setVisible(true);
        
        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource() == submit) {
            
            try{
                String query1 = "select * from room where bed_type = '"+bedType.getSelectedItem()+"'";
                String query2 = "select * from room where availabilty = 'Available' AND bed_type = '"+bedType.getSelectedItem()+"'";
                
                Conn conn = new Conn();
                ResultSet rs;
                
                if(available.isSelected()){
                    rs = conn.s.executeQuery(query2);
                 } else {
                    rs = conn.s.executeQuery(query1); 
                 }
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch(Exception e) {
                e.printStackTrace();
            }
            
        } else {
            setVisible(false);
            new Dashboard();
        }
        
    }
    
    public static void main(String[] args){
        new SearchRoom();
    }
    
}
