package hotelmanagementproject;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCustomerInfo extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JTextField tfroom, tfname, tfchekin, tfpaid, tfpanding;
    JButton check, update, back;
    
    UpdateCustomerInfo(){
    
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma", Font.BOLD,25));
        text.setBounds(90,20,200,30);
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
        lblroom.setBounds(30,120,100,20);
        add(lblroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(200,120,180,25);
        add(tfroom);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,160,100,20);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,160,180,25);
        add(tfname);
        
        JLabel lblchekin = new JLabel("Checkin Time");
        lblchekin.setBounds(30,200,100,20);
        add(lblchekin);
        
        tfchekin = new JTextField();
        tfchekin.setBounds(200,200,180,25);
        add(tfchekin);
        
        JLabel lblpaid = new JLabel("Amount Paid");
        lblpaid.setBounds(30,240,100,20);
        add(lblpaid);
        
        tfpaid = new JTextField();
        tfpaid.setBounds(200,240,180,25);
        add(tfpaid);
        
        JLabel lblpanding = new JLabel("Panding Amount");
        lblpanding.setBounds(30,280,100,20);
        add(lblpanding);
        
        tfpanding = new JTextField();
        tfpanding.setBounds(200,280,180,25);
        add(tfpanding);
        
        check = new JButton("Check");
        check.setBounds(30,340,100,30);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBounds(150,340,100,30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(270,340,100,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/update.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(380,50,500,300);
        add(image);
        
        setBounds(250,200,900,500);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == check) {
            String id = ccustomer.getSelectedItem();
            try {
                Conn conn = new Conn();
                
                ResultSet rs  = conn.s.executeQuery("select * from customer where document_number = '"+id+"'");
                
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                    tfname.setText(rs.getString("name"));
                    tfchekin.setText(rs.getString("checkintime"));
                    tfpaid.setText(rs.getString("deposite"));
                }
                
                ResultSet rs2  = conn.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
                while(rs2.next()){
                    String price  = rs2.getString("price");
                    int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
                    tfpanding.setText(""+amountPaid);
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == update) {
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String checkin = tfchekin.getText();
            String deposite = tfpaid.getText();
            
            try{
                Conn conn = new Conn();
                conn.s.executeUpdate("update customer set room = '"+room+"', name = '"+name+"', checkintime = '"+checkin+"', deposite = '"+deposite+"' where number = '"+number+"'");
                
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
        new UpdateCustomerInfo();
    }
}
