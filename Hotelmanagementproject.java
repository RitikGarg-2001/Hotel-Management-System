package hotelmanagementproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Hotelmanagementproject extends JFrame implements ActionListener {
    
    Hotelmanagementproject(){
    
        setBounds(70,100,1400,600);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/image1.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1400,600);
        add(image);
        
        JLabel text = new JLabel("Hotel Management System");
        text.setBounds(350,50,800,100);
        text.setForeground(Color.white);
        text.setFont(new Font("chiller",Font.PLAIN,100));
        image.add(text);
        
        JButton next = new JButton("Next");
        next.setBounds(1245,432,140,130);
        next.setFont(new Font("Arial", Font.PLAIN, 45));
        next.addActionListener(this);
        image.add(next);
        
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
        try{
        
            setVisible(false);
            new LoginPage();
            
        } catch(Exception e){
            e.printStackTrace();
        }
       
        
    }

    public static void main(String[] args) {
        new Hotelmanagementproject();
    }
    
}
