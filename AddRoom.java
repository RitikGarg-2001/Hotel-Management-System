
package hotelmanagementproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRoom extends JFrame implements ActionListener{
    
    JButton add,cancel;
    JTextField tfroom,tfprice;
    JComboBox typecombo,availablecombo,cleancombo;
    
    AddRoom(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text =new JLabel("Add Room");
        text.setFont(new Font("serif",Font.BOLD,18));
        text.setBounds(150,20,200,20);
        add(text);

        JLabel lblroomno =new JLabel(" Room Number");
        lblroomno.setFont(new Font("serif",Font.PLAIN,16));
        lblroomno.setBounds(60,80,120,30);
        add(lblroomno);

         tfroom=new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);
       
        JLabel lblavailable =new JLabel("Available");
        lblavailable.setFont(new Font("serif",Font.PLAIN,16));
        lblavailable.setBounds(60,130,120,30);
        add(lblavailable);

        String availableoption[]={"Available","Occupied"};
         availablecombo=new  JComboBox(availableoption);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);

        JLabel lblclean =new JLabel("Cleaning status");
        lblclean.setFont(new Font("serif",Font.PLAIN,16));
        lblclean.setBounds(60,180,120,30);
        add(lblclean);

        String cleanoption[]={"Cleaned","Dirty"};
         cleancombo=new  JComboBox(cleanoption);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);

        JLabel lblprice =new JLabel(" Rooms Price");
        lblprice.setFont(new Font("serif",Font.PLAIN,16));
        lblprice.setBounds(60,230,120,30);
        add(lblprice);

         tfprice=new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);

        JLabel lbltype =new JLabel("Bed Type");
        lbltype.setFont(new Font("serif",Font.PLAIN,16));
        lbltype.setBounds(60,280,120,30);
        add(lbltype);

        String typeoption[]={"Single Bed","Double Bed"};
         typecombo=new  JComboBox(typeoption);
        typecombo.setBounds(200,280,150,30);
        typecombo.setBackground(Color.WHITE);
        add(typecombo);

         add=new JButton("Add Room");
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);
        
        
         cancel=new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/room.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 320, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(400,30,500,320);
        add(image);

        setBounds(330,200,940,470);
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
   
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add){
            String roomnumber= tfroom.getText();
            String availability=(String) availablecombo.getSelectedItem();
            String status =(String) cleancombo.getSelectedItem();
            String price=tfprice.getText();
            String type = (String)typecombo.getSelectedItem();

            try{
                Conn conn=new Conn();
                String str="insert into room values('"+roomnumber+"', '"+availability+"','"+status+"' ,'"+price+"','"+type+"')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Room Added Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }


        }else{
            setVisible(false);
            new AdminDashboard();
        }
        
    }
    
    public static void main(String[] args ){
        new AddRoom();
    }

}
