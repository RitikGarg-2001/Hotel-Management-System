package hotelmanagementproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddDriver extends JFrame implements ActionListener{
    
    JButton add,cancel;
    JTextField tfname,tfage ,tfcname,tfcnumber,tflocation, tfsal, tfexp, tfemail, tfmobile;
    JComboBox gendercombo, availablecombo;
    
    AddDriver(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text =new JLabel("Add Drivers");
        text.setFont(new Font("serif",Font.BOLD,18));
        text.setBounds(130,20,200,20);
        add(text);

        JLabel lblname =new JLabel(" Name");
        lblname.setFont(new Font("serif",Font.PLAIN,16));
        lblname.setBounds(60,70,120,30);
        add(lblname);

        tfname=new JTextField();
        tfname.setBounds(200,70,150,30);
        add(tfname);
       
        JLabel lblage =new JLabel("Age");
        lblage.setFont(new Font("serif",Font.PLAIN,16));
        lblage.setBounds(60,110,120,30);
        add(lblage);

        tfage=new JTextField();
        tfage.setBounds(200,110,150,30);
        add(tfage);
       
        
        JLabel lblgender =new JLabel("Gender");
        lblgender.setFont(new Font("serif",Font.PLAIN,16));
        lblgender.setBounds(60,150,120,30);
        add(lblgender);

        
        String ageeoption[]={"Male","Female"};
        gendercombo=new  JComboBox(ageeoption);
        gendercombo.setBackground(Color.WHITE);
        gendercombo.setBounds(200,150,150,30); 
        add(gendercombo);

        JLabel lblmobile =new JLabel("Mobile No.");
        lblmobile.setFont(new Font("serif",Font.PLAIN,16));
        lblmobile.setBounds(60,190,120,30);
        add(lblmobile);

        tfmobile=new JTextField();
        tfmobile.setBounds(200,190,150,30);
        add(tfmobile);
        
        JLabel lblemail =new JLabel("Email");
        lblemail.setFont(new Font("serif",Font.PLAIN,16));
        lblemail.setBounds(60,230,120,30);
        add(lblemail);

        tfemail=new JTextField();
        tfemail.setBounds(200,230,150,30);
        add(tfemail);
        
        JLabel lblexp =new JLabel("Expression");
        lblexp.setFont(new Font("serif",Font.PLAIN,16));
        lblexp.setBounds(60,270,120,30);
        add(lblexp);

        tfexp=new JTextField();
        tfexp.setBounds(200,270,150,30);
        add(tfexp);
        
        JLabel lblsal =new JLabel("Salary");
        lblsal.setFont(new Font("serif",Font.PLAIN,16));
        lblsal.setBounds(60,310,120,30);
        add(lblsal);

        tfsal=new JTextField();
        tfsal.setBounds(200,310,150,30);
        add(tfsal);
      
        JLabel lblcname =new JLabel("Car Name");
        lblcname.setFont(new Font("serif",Font.PLAIN,16));
        lblcname.setBounds(60,350,120,30);
        add(lblcname);

        tfcname=new JTextField();
        tfcname.setBounds(200,350,150,30);
        add(tfcname);
        
        JLabel lblcnumber =new JLabel("Car Number");
        lblcnumber.setFont(new Font("serif",Font.PLAIN,16));
        lblcnumber.setBounds(60,390,120,30);
        add(lblcnumber);

        tfcnumber=new JTextField();
        tfcnumber.setBounds(200,390,150,30);
        add(tfcnumber);
        
        JLabel lblAvailable =new JLabel("Available");
        lblAvailable.setFont(new Font("serif",Font.PLAIN,16));
        lblAvailable.setBounds(60,430,120,30);
        add(lblAvailable);
        
        String drivereoption[]={"Available ","Busy"};
        availablecombo=new  JComboBox(drivereoption);
        availablecombo.setBackground(Color.WHITE);
        availablecombo.setBounds(200,430,150,30); 
        add(availablecombo); 
        
        JLabel lbllocation =new JLabel("Location");
        lbllocation.setFont(new Font("serif",Font.PLAIN,16));
        lbllocation.setBounds(60,470,120,30);
        add(lbllocation);

        tflocation=new JTextField();
        tflocation.setBounds(200,470,150,30);
        add(tflocation);
      

        add=new JButton("Add Driver");
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.setBounds(60,510,130,30);
        add.addActionListener(this);
        add(add);
        
        
        cancel=new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.setBounds(220,510,130,30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/driver.jpg"));
        Image i2=i1.getImage().getScaledInstance(530, 450, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,60,530,450);
        add(image);

        setBounds(300,100,980,600);
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
            String name= tfname.getText();
            String age=tfage.getText();
            String gender =(String) gendercombo.getSelectedItem();
            String salary = tfsal.getText();
            String exp = tfexp.getText();
            String email = tfemail.getText();
            String mobile = tfmobile.getText();
            String cname=tfcname.getText();
            String number = tfcnumber.getText();
            String available=(String)availablecombo.getSelectedItem();
            String location=tflocation.getText();
            try{
                Conn conn=new Conn();
                String str="insert into driver values('"+name+"', '"+age+"','"+gender+"','"+mobile+"','"+email+"','"+exp+"','"+salary+"','"+cname+"','"+number+"','"+available+"','"+location+"')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Driver Added Successfully");
                setVisible(false);
                new AdminDashboard();
            }catch(Exception e){
                e.printStackTrace();
            }


        }else{
            setVisible(false);
            new AdminDashboard();
        }

    }


    public static void main(String[] args ){
        new AddDriver();
    }

   
}
