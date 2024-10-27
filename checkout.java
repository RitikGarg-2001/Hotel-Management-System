package hotelmanagementproject;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class Checkout extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JLabel lblroomnumber, lblcheckintime, lblcheckouttime, lblpandingamount, lblpaidamount;
    JButton checkout, back, ok;
    
    Checkout(){
    
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("Checkout");
        text.setFont(new Font("Tahoma", Font.BOLD, 25));
        text.setBounds(350,20,150,30);
        add(text);
        
        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,80,100,30);
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(200,80,180,25);
        add(ccustomer);    
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);
        
        lblroomnumber = new JLabel("");
        lblroomnumber.setBounds(200,130,180,30);
        lblroomnumber.setForeground(Color.blue);        
        add(lblroomnumber);
        
        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(30,180,100,30);
        add(lblcheckin);
        
        lblcheckintime = new JLabel("");
        lblcheckintime.setBounds(200,180,180,30);
        lblcheckintime.setForeground(Color.blue);
        add(lblcheckintime);
        
        JLabel lblcheckout = new JLabel("Checkout Time");
        lblcheckout.setBounds(30,230,100,30);
        add(lblcheckout);
        
        Date date = new Date();
        lblcheckouttime = new JLabel(""+date);
        lblcheckouttime.setBounds(200,230,180,30);
        lblcheckouttime.setForeground(Color.blue);
        add(lblcheckouttime);
        
        
        JLabel lblpaid = new JLabel("Paid Amount");
        lblpaid.setBounds(30,280,100,30);
        add(lblpaid);
        
        lblpaidamount = new JLabel("");
        lblpaidamount.setBounds(200,280,180,30);
        lblpaidamount.setForeground(Color.blue);        
        add(lblpaidamount);
        
        JLabel lblpanding = new JLabel("Panding Amount");
        lblpanding.setBounds(30,330,100,30);
        add(lblpanding);
        
        lblpandingamount = new JLabel("");
        lblpandingamount.setBounds(200,330,180,30);
        lblpandingamount.setForeground(Color.blue);        
        add(lblpandingamount);
         
        try{
            Conn conn = new Conn();
            ResultSet rs  = conn.s.executeQuery("select * from customer");
            
            while(rs.next()) {
                ccustomer.add(rs.getString("document_number"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        ok = new JButton("Ok");
        ok.setBounds(380, 80,50,20);
        ok.addActionListener(this);
        add(ok);
        
        checkout = new JButton("Checkout");
        checkout.setBounds(30, 380,120,30);
        checkout.addActionListener(this);
        add(checkout);
        
        
        back = new JButton("Back");
        back.setBounds(200, 380,120,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon p1 = new ImageIcon(ClassLoader.getSystemResource("icons/out.jpg"));
        Image p2 = p1.getImage().getScaledInstance(350, 320, Image.SCALE_DEFAULT);
        ImageIcon p3 = new ImageIcon(p2);
        JLabel image1 = new JLabel(p3);
        image1.setBounds(450,75,330,320);
        add(image1);
        
        setBounds(300,200,800,480);
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
        
            if(ae.getSource() == checkout) {
                String query1 = "delete from customer where number = '"+ccustomer.getSelectedItem()+"'";
                String query2 = "update room set availabilty = 'Available' where roomnumber = '"+lblroomnumber.getText()+"'";
                try{
                    Conn c = new Conn();
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Checkout Done.");
                    
                    setVisible(false);
                    new Dashboard();
                   
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if(ae.getSource() == ok){
                String id = ccustomer.getSelectedItem();
                try{
                    Conn conn = new Conn();
                
                    ResultSet rs  = conn.s.executeQuery("select * from customer where document_number = '"+id+"'");

                    while(rs.next()){
                        lblroomnumber.setText(rs.getString("room"));
                        lblcheckintime.setText(rs.getString("checkintime"));
                        lblpaidamount.setText(rs.getString("deposite"));
                    }
                    
                    ResultSet rs2  = conn.s.executeQuery("select * from room where roomnumber = '"+lblroomnumber.getText()+"'");
                    while(rs2.next()){
                        String price  = rs2.getString("price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(lblpaidamount.getText());
                        lblpandingamount.setText(""+amountPaid);
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            } 
            else {
                setVisible(false);
                new Dashboard();
            }
                
    }
    
    public static void main(String[] args){
    
        new  Checkout();
        
    }
}
