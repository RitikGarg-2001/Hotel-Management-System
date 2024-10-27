package hotelmanagementproject;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public  class AddCustomer extends JFrame implements ActionListener{
    
    JComboBox comboid;
    JTextField tfnumber,tfname ,tfcountry,tfdeposit;
    JRadioButton rmale,rfemale;
    Choice croom;
    JLabel chekintime;
    JButton add,back;
    AddCustomer(){
   
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/customer.png"));
        Image i3 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(480,10,300,500);
        add(l1);

        JLabel text= new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("serif",Font.BOLD,20));
        add(text);

        JLabel lblid= new JLabel("ID");
        lblid.setBounds(35,80,100,20);
        lblid.setFont(new Font("serif",Font.PLAIN,18));
        add(lblid);

        String optionid[]= {"Aadhar Card","Passport","Driving Licence","Voter Id","Ration Card"};
         comboid=new JComboBox(optionid);
        comboid.setBounds(200,80,150,20);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel lblnumber= new JLabel("Number");
        lblnumber.setBounds(35,120,100,25);
        lblnumber.setFont(new Font("serif",Font.PLAIN,18));
        add(lblnumber);


        tfnumber=new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);


        JLabel lblname= new JLabel("Name");
        lblname.setBounds(35,160,100,25);
        lblname.setFont(new Font("serif",Font.PLAIN,18));
        add(lblname);


        tfname=new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);


        JLabel lblgender= new JLabel("Gender");
        lblgender.setBounds(35,200,100,25);
        lblgender.setFont(new Font("serif",Font.PLAIN,18));
        add(lblgender);


        rmale=new JRadioButton("Male");
        rmale.setBounds(200,200,60,25);
        add(rmale);

        rfemale=new JRadioButton("Female");
        rfemale.setBounds(270,200,80,25);
        add(rfemale);


        JLabel lblcounry= new JLabel("Country");
        lblcounry.setBounds(35,240,100,25);
        lblcounry.setFont(new Font("serif",Font.PLAIN,18));
        add(lblcounry);


        tfcountry=new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);


        JLabel lblroom= new JLabel("Allocated Room number");
        lblroom.setBounds(35,280,150,25);
        lblroom.setFont(new Font("serif",Font.PLAIN,18));
        add(lblroom);

        croom= new Choice();
        try{
            Conn conn=new Conn();
            String query = "select * from room where availabilty = 'Available'";
            ResultSet rs = conn.s.executeQuery(query);

            while(rs.next()){
                croom.add(rs.getString("roomnumber"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        croom.setBounds(200,280,150,25);
        add(croom);

        JLabel lbltime= new JLabel("Chekin Time");
        lbltime.setBounds(35,320,150,25);
        lbltime.setFont(new Font("serif",Font.PLAIN,18));
        add(lbltime);

        Date date=new Date(); 
        chekintime= new JLabel("" +date);
        chekintime.setBounds(200,320,150,25);
        chekintime.setFont(new Font("serif",Font.PLAIN,12));
        add(chekintime);

        JLabel lbldeposite= new JLabel("Deposit");
        lbldeposite.setBounds(35,360,100,25);
        lbldeposite.setFont(new Font("serif",Font.PLAIN,18));
        add(lbldeposite);

        tfdeposit=new JTextField();
        tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);

        add=new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.setBounds(50,410,120,30);
        add.addActionListener(this);
        add(add);

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(200,410,120,30);
        back.addActionListener(this);
        add(back);

        setBounds(350,200,800,550);
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

        if(ae.getSource()==add){
            String id =(String) comboid.getSelectedItem();
            String number =tfnumber.getText();
            String name = tfname.getText();
            String gender=null;
            if(rmale.isSelected()){
                gender = "Male";
            }else{
                gender="Female";
            }
            String country=tfcountry.getText();
            String room=croom.getSelectedItem();
            String time= chekintime.getText();
            String deposit=tfdeposit.getText();
            
             try{
                Conn conn=new Conn();
                String str = "insert into customer values('"+id+"', '"+number+"','"+name+"','"+gender+"' ,'"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String str2 = "update room set availabilty = 'Occupied' where roomnumber='"+room+"'";
                conn.s.executeUpdate(str);
                conn.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null, "Customer Added Successfully");
                setVisible(false);
                new Dashboard();
            }catch(Exception e){
                e.printStackTrace();
            }
             
        }else if(ae.getSource()==back){
            
            setVisible(false);
            new Dashboard();

        }

    }

     public static void main(String[] args) {
        new AddCustomer();
        
    }
     
}
