package Hotel;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.EventListener.*;
import java.text.*;
import java.io.*; 

public class Password extends JInternalFrame implements PasswordInterface, Maininterface
{
	private Container c;
	public String uname,pass,usname;
	public int ctr = 0;
	public CheckBoxHandler handler = new CheckBoxHandler();
	public boolean rem;
	public JFrame frame;

	int day[] = new int[31];
	
	
	String[] month = {"Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"};
	
	String[] year = {};
	
    public JComboBox dayCombo = new JComboBox();
	public JComboBox monthCombo = new JComboBox(month);
	public JComboBox yearCombo = new JComboBox();
	
	public Password() 
    {
        
        super("Password", 
              false, //resizable
              false, //closable
              false, //maximizable
              false);//iconifiable
		
		rem = false;
		c = getContentPane();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       
 		int paintx = (screenSize.width);
		int painty = (screenSize.height);
		setBounds( (paintx/2)-200 , (painty/2)-150,
						 300,220);
				
		c.setLayout( null );
		
	    user.setBounds( 20,15,80,20 );
        user.setForeground(Color.black);
        c.add( user );
        
        passwod.setBounds( 20,40,80,20 );
        passwod.setForeground(Color.black);
        c.add( passwod ); 
        
        registrazione.setBounds(20, 115, 180, 20);
        registrazione.setForeground(Color.black);
        c.add( registrazione );
        
        reg.setBounds(20, 135, 150, 25);
        c.add( reg );
        
        usersName.setBounds( 100,15,170,20 );
        c.add( usersName );
        
        userPassword.setBounds( 100,40,170,20 );
        c.add( userPassword );
        
       	okButton.setBounds( 75,80,70,25 );
		c.add( okButton );
        
        closeButton.setBounds( 155,80,70,25 );
        c.add( closeButton );
        
        chk.setBounds(100, 60,170,20);
        chk.setBackground(Color.gray);
        chk.addItemListener(handler);
        c.add(chk);
        

        
        reg.addActionListener(new ActionListener()
        		{

					public void actionPerformed(ActionEvent e) {
						JFrame frame = new JFrame("Registrazione");
						int paintx = (screenSize.width);
						int painty = (screenSize.height);
						frame.setBounds((paintx/2)-200 , (painty/2)-150,
								 300,220);
						
						frame.setLayout( null );
						
						
						
					    userReg.setBounds( 20,15,80,20 );
				        userReg.setForeground(Color.black);
				        frame.add( userReg );
				        
				        passwodReg.setBounds( 20,40,80,20 );
				        passwodReg.setForeground(Color.black);
				        frame.add( passwodReg ); 
				        
				        confpasswod.setBounds(20, 65, 80, 20);
				        confpasswod.setForeground(Color.black);
				        frame.add(confpasswod);
				        
				        email.setBounds(20, 90, 80, 20);
				        email.setForeground(Color.black);
				        frame.add(email);
				        
				        usersNameReg.setBounds( 100,15,170,20 );
				        frame.add( usersNameReg );
				        
				        userPasswordReg.setBounds( 100,40,170,20 );
				        frame.add( userPasswordReg );
				        
				        userConfpasswod.setBounds( 100,65,170,20 );
				        frame.add( userConfpasswod );
				        
				        userEmail.setBounds( 100,90,170,20 );
				        frame.add( userEmail );
				        
				       	okButtonReg.setBounds( 115,115,70,25 );
						frame.add( okButtonReg );
				        
				      
				        
						frame.setVisible(true);
				        				       				
					}
				}
       	
        );
        
        okButtonReg.addActionListener( new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
			}}
        );
        
        okButton.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e )
 			{
 				usname = usersName.getText();
 				String uspasswd = userPassword.getText();
 				boolean checked = false;
 				PasswordSQL passql = new PasswordSQL(usname, uspasswd, checked);
 				checked = passql.check();
 				
 				if (checked == true)
 				{
 				JOptionPane.showMessageDialog(null, "Welcome, " + usname );
// 				add.setEnabled(true);
 				
 				rooms.setEnabled(false);
 				restaurant.setEnabled(false);
 				
 				String dd;
				dd = formatter.format(currentDate);
        		USERName.setText("Welcome " + usname + " today is " + dd);
        		menuItem3.setEnabled(false);
        		menuItem6.setEnabled(true);
 				dispose();	
 				}
 				
 				else {
 					JOptionPane.showMessageDialog(null, "Login Failed. Please Try again");
 					ctr = ctr + 1;
 					System.out.println(ctr);
 					if (ctr > 3)
 					{
 						JOptionPane.showMessageDialog(null, "Please, Contact the Administrator");
 						ctr = 0;
 						dispose();
 					}
 					PasswordSQL passq = new PasswordSQL(usname, uspasswd, checked);
 					checked = passq.check();
 					}
 					
 					if (rem == false) 
 					{
 						usersName.setText("");
 						userPassword.setText("");
 					}
 			dispose();		
 			}
 			
 		});
        		
				
		closeButton.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e )
 			{			
 					
 					dispose(); 				
 			}
 		});
 		dispose();
 		
 		
 		}
 		private class CheckBoxHandler implements ItemListener {
 		
 		public void itemStateChanged(ItemEvent e)
 		{
 		if (e.getSource() == chk)
 		{
 			if(e.getStateChange() == ItemEvent.SELECTED)
 			{
 			rem = true;
 			}
 			else
 			rem = false;
    	}
 		}
    	
	}	
}
