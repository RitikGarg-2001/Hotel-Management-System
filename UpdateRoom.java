

package hotelmanagementproject;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateRoom extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JTextField tfroom, tfavailable, tfstatus, tfpaid, tfpanding;
    JButton check, update, back;
    
    UpdateRoom(){
    
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma", Font.BOLD,25));
        text.setBounds(70,20,280,30);
        add(text);
        
        JLabel lblid = new JLabel("Customer ID");
        lblid.setBounds(30,80,100,20);
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(200,80,180,25);
        add(ccustomer);
        
        try{
            Conn conn = new Conn();
            ResultSet rs  = conn.s.executeQuery("select * from customer");
            
            while(rs.next()) {
                ccustomer.add(rs.getString("document_number"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30,130,100,20);
        add(lblroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(200,130,180,25);
        add(tfroom);
        
        JLabel lblavailable = new JLabel("Availability");
        lblavailable.setBounds(30,180,100,20);
        add(lblavailable);
        
        tfavailable = new JTextField();
        tfavailable.setBounds(200,180,180,25);
        add(tfavailable);
        
        JLabel lblstatus = new JLabel("Cleaning Status");
        lblstatus.setBounds(30,230,100,20);
        add(lblstatus);
        
        tfstatus = new JTextField();
        tfstatus.setBounds(200,230,180,25);
        add(tfstatus);
        
        
        check = new JButton("Check");
        check.setBounds(30,300,100,30);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBounds(150,300,100,30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(270,300,100,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);
        
        setBounds(100,200,900,420);
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
        
        if(ae.getSource() == check) {
            String id = ccustomer.getSelectedItem();
            try {
                Conn conn = new Conn();
                
                ResultSet rs  = conn.s.executeQuery("select * from customer where document_number = '"+id+"'");
                
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                }
                
                ResultSet rs2  = conn.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
                while(rs2.next()){
                    tfavailable.setText(rs2.getString("availabilty"));
                    tfstatus.setText(rs2.getString("status"));
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == update) {
            String room = tfroom.getText();
            String available = tfavailable.getText();
            String status = tfstatus.getText();
            
            try{
                Conn conn = new Conn();
                conn.s.executeUpdate("update room set availabilty = '"+available+"', status = '"+status+"' where roomnumber = '"+room+"'");
                
                JOptionPane.showMessageDialog(null, "Data Updated Successfully.");
                
                setVisible(false);
                new Dashboard();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource() == back) {
            setVisible(false);
            new Dashboard();
        }
        
    }
    
    public static void main(String[] args){
        new UpdateRoom();
    }
}

