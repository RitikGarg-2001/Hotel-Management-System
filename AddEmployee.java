package hotelmanagementproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public  class AddEmployee extends JFrame implements ActionListener{
    
    
    JTextField tfname,tfemail,tfphone,tfage,tfsalary,tfaadhar,gender;
    JRadioButton rbmale,rbfemale;
    JButton submit, cencel;
    JComboBox cbjob;
    
    AddEmployee(){
        
        setLayout(null);
        
        
        JLabel text =new JLabel("Add Employee");
        text.setFont(new Font("serif",Font.BOLD,18));
        text.setBounds(150,2,200,20);
        add(text);
        
        JLabel lblname=new JLabel("NAME");  
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("serif",Font.PLAIN,17));
        add(lblname);

         tfname=new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);

        JLabel lblage=new JLabel("AGE");  
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("serif",Font.PLAIN,17));
        add(lblage);

         tfage=new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);

        JLabel lblgender=new JLabel("GENDER");  
        lblgender.setBounds(60,130,120,30);
        lblage.setFont(new Font("serif",Font.PLAIN,17));
        add(lblgender);

         rbmale =new JRadioButton("Male");
        rbmale.setBounds(200,130,70,30);
        rbmale.setFont(new Font("serif",Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale =new JRadioButton("Female");
        rbfemale.setBounds(280,130,70,30);
        rbfemale.setFont(new Font("serif",Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        ButtonGroup bg=new ButtonGroup();
        bg.add(rbfemale);
        bg.add(rbmale);

        JLabel lbljob=new JLabel("JOB");  
        lbljob.setBounds(60,180,120,30);
        lblname.setFont(new Font("serif",Font.PLAIN,17));
        add(lbljob);

        String str[]={"Fronters Desk Clerks","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiter","Manager","Accountent","Security"};
        cbjob=new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);

        JLabel lblsalary=new JLabel("SALARY");  
        lblsalary.setBounds(60,230,120,30);
        lblsalary.setFont(new Font("serif",Font.PLAIN,17));
        add(lblsalary);

         tfsalary=new JTextField();
        tfsalary.setBounds(200,230,150,30);
        add(tfsalary);

        JLabel lblphone=new JLabel("PHONE No.");  
        lblphone.setBounds(60,280,120,30);
        lblphone.setFont(new Font("serif",Font.PLAIN,17));
        add(lblphone);

         tfphone=new JTextField();
        tfphone.setBounds(200,280,150,30);
        add(tfphone);

        JLabel lblaadhar=new JLabel("AADHAR");  
        lblaadhar.setBounds(60,330,120,30);
        lblaadhar.setFont(new Font("serif",Font.PLAIN,17));
        add(lblaadhar);

         tfaadhar=new JTextField();
         tfaadhar.setBounds(200,330,150,30);
        add(tfaadhar);

        JLabel lblemail=new JLabel("EMAIL");  
        lblemail.setBounds(60,380,120,30);
        lblemail.setFont(new Font("serif",Font.PLAIN,17));
        add(lblemail);

         tfemail=new JTextField();
         tfemail.setBounds(200,380,150,30);
        add(tfemail);


        submit=new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(50,430,150,30);
        submit.addActionListener(this);
        add(submit);
        
        cencel=new JButton("CENCAL");
        cencel.setBackground(Color.BLACK);
        cencel.setForeground(Color.WHITE);
        cencel.setBounds(210,430,150,30);
        cencel.addActionListener(this);
        add(cencel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/employee.jpg"));
        Image i2=i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);



        getContentPane().setBackground(Color.white);
        setBounds(350,200,850,540);
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
        if(ae.getSource() == submit){
        
            String name=tfname.getText();
            String age=tfage.getText();
            String salary=tfsalary.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String aadhar=tfaadhar.getText();

            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name Should not be empty");
                return;
            }

            String gender="Male";
            if(rbfemale.isSelected()){
                gender="Male";
            }else if(rbfemale.isSelected()){
                gender="Female";
            }

            String job =(String) cbjob.getSelectedItem();

            try{
                Conn conn=new Conn();
                String query="insert into employee values('"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"','"+phone+"','"+email+"', '"+aadhar+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee added Successfully.");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        } else {
            setVisible(false);
            new AdminDashboard();
        }

    }

    public static void main(String[] args){
        new AddEmployee();
    }   
}