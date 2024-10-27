package hotelmanagementproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class Pickup extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    Choice  typeofcar;
    JCheckBox available;
    
    Pickup(){
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);

    
        JLabel text =new JLabel("Pickup Services");
        text.setFont(new Font("serif",Font.BOLD,20));
        text.setBounds(400,30,200,30);
        add(text);


        JLabel lblbed =new JLabel("Type Of car");
        lblbed.setFont(new Font("serif",Font.BOLD,18));
        lblbed.setBounds(50,95,100,30);
        add(lblbed);


        typeofcar= new Choice();
        typeofcar.setBounds(150,100,200,25);
        add(typeofcar);

        try{
          Conn c=new Conn();
          ResultSet rs=c.s.executeQuery("select * from driver");
          while(rs.next()){
            typeofcar.add(rs.getString("company"));
          }



        }catch(Exception e){
          e.printStackTrace();
        }



      JLabel k1=new JLabel("Name");
      k1.setBounds(30,160,100,20);
      add(k1);
      
        JLabel k2=new JLabel("Age");
      k2.setBounds(130,160,100,20);
      add(k2);
      
       JLabel k3=new JLabel(" Gender");
        k3.setBounds(210,160,100,20);
      add(k3);
      
        JLabel mobile=new JLabel("Mobile No");
        mobile.setBounds(295,160,100,20);
        add(mobile);
        
        JLabel email=new JLabel("Email id");
        email.setBounds(395,160,100,20);
        add(email);
      
       JLabel k4=new JLabel("Expression");
      k4.setBounds(480,160,100,20);
      add(k4);
        
        JLabel sal=new JLabel("Salary");
        sal.setBounds(575,160,100,20);
        add(sal);
      
       JLabel k5=new JLabel("Company");
      k5.setBounds(660,160,100,20);
      add(k5);
      
        JLabel k61=new JLabel("Car Number");
        k61.setBounds(750,160,100,20);
        add(k61);
      
       JLabel k6=new JLabel("Availability");
      k6.setBounds(840,160,100,20);
      add(k6);
      
       JLabel k7=new JLabel("Location");
      k7.setBounds(930,160,100,20);
      add(k7);
      
      
      
      table = new JTable();
      table.setBounds(10, 200, 1000, 300);
      add(table);
      
      try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
	}
	catch(Exception e){
	       e.printStackTrace();
	                   }
		
      submit=new JButton("Submit");
      submit.setBounds(300,520,100,30);
      submit.setForeground(Color.WHITE);
      submit.setBackground(Color.BLACK);
      submit.addActionListener(this);
      add(submit);
	


      back=new JButton("Back");
      back.setBounds(500,520,100,30);
      back.setForeground(Color.WHITE);
      back.setBackground(Color.BLACK);
      back.addActionListener(this);
      add(back);


      setBounds(300,200,1000,600);
      setVisible(true);

    }
    
   
    public void actionPerformed(ActionEvent ae){
     if(ae.getSource()==submit){
      try{
        String query1="select * from driver where company ='"+typeofcar.getSelectedItem()+"'";
       
       Conn conn = new Conn();
       ResultSet rs;

             

                rs=conn.s.executeQuery(query1);
                
       table.setModel(DbUtils.resultSetToTableModel(rs));

          }catch(Exception e){
        e.printStackTrace();
                            }
        
     }else{
        
        setVisible(false);
        new Dashboard();
        
              } 
    }

    public static void main(String[] args) {
        new Pickup();

    }

 
}