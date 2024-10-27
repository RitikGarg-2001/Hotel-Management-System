package hotelmanagementproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminDashboard extends JFrame implements ActionListener {
    JButton addEmp, addRoom, addDriver, addTransport, managerInfo, department, allEmp, customers, back, quit;
    
    
    AdminDashboard(){
    
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("Welcome, Admin");
        text.setFont(new Font("serif", Font.BOLD,25));
        text.setBounds(20,10,200,30);
        add(text);
        
        addEmp = new JButton("Add Employee");
        addEmp.setBackground(Color.black);
        addEmp.setForeground(Color.white);
        addEmp.setBounds(50,60,120,30);
        addEmp.addActionListener(this);
        add(addEmp);
        
        addRoom = new JButton("Add Room");
        addRoom.setBackground(Color.black);
        addRoom.setForeground(Color.white);
        addRoom.setBounds(50,100,120,30);
        addRoom.addActionListener(this);
        add(addRoom);
        
        addTransport = new JButton("Add Driver");
        addTransport.setBackground(Color.black);
        addTransport.setForeground(Color.white);
        addTransport.setBounds(50,140,120,30);
        addTransport.addActionListener(this);
        add(addTransport);
        
        department = new JButton("Department");
        department.setBackground(Color.black);
        department.setForeground(Color.white);
        department.setBounds(50,180,120,30);
        department.addActionListener(this);
        add(department);
        
        allEmp = new JButton("Employee Info"); 
        allEmp.setBackground(Color.black);
        allEmp.setForeground(Color.white);
        allEmp.setBounds(50,220,120,30);
        allEmp.addActionListener(this);
        add(allEmp);
         
        customers = new JButton("Customer Info"); 
        customers.setBackground(Color.black);
        customers.setForeground(Color.white);
        customers.setBounds(50,260,120,30);
        customers.addActionListener(this);
        add(customers);
        
        managerInfo = new JButton("Manager Info"); 
        managerInfo.setBackground(Color.black);
        managerInfo.setForeground(Color.white);
        managerInfo.setBounds(50,300,120,30);
        managerInfo.addActionListener(this);
        add(managerInfo);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(50,340,120,30);
        back.addActionListener(this);
        add(back);
        
        quit = new JButton("Quit");
        quit.setBackground(Color.black);
        quit.setForeground(Color.white);
        quit.setBounds(50,380,120,30);
        quit.addActionListener(this);
        add(quit);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550,450,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(200,0,620,450);
        add(image);
        
        setBounds(400,150,800,470);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back) {
            setVisible(false);
            new Dashboard();
        } else if(ae.getSource() == quit){
            System.exit(0);
        } else if(ae.getSource() == addEmp){
            setVisible(false);
            new AddEmployee();
        } else if(ae.getSource() == addRoom){
            setVisible(false);
            new AddRoom();
       } else if(ae.getSource() == addTransport){
            setVisible(false);
            new AddDriver();
        } else if(ae.getSource() == managerInfo){
            setVisible(false);
            new ManagerInfo();
        } else if(ae.getSource() == customers){
            setVisible(false);
            new CustomerInfo();
        } else if(ae.getSource() == department){
            setVisible(false);
            new Department();
        } else if(ae.getSource() == allEmp){
            setVisible(false);
            new AllEmp();
        }
    }
    
    public static void main(String[] args){
        new AdminDashboard();
    }
}