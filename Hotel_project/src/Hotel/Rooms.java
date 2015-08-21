/*package Hotel;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.EventListener.*;
import java.text.*;
import java.io.*; 

public class Rooms extends JInternalFrame implements PasswordInterface, Maininterface, RoomsInterface
{
	
	
	 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	rooms.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            roomsPressed();
	        }
	        
	      
		private void roomsPressed() {
			// TODO Auto-generated method stub
		
			JFrame Rooms = new JFrame("Rooms");
			int paintx = (screenSize.width);
			int painty = (screenSize.height);
			Rooms.setBounds((paintx/2)-200 , (painty/2)-150,
					 500,300);
			
			//frame.setLayout( null );
			//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		   // window.setBounds(0,0,500,250);
		    Rooms.setVisible(true);
		    
		    
		    nome.setBounds( 5,2,20,10 );
	        nome.setForeground(Color.black);
	        Rooms.add( nome );
	         
	     //   userRooms.setBounds(5, 14, 30, 10);
	     //   Rooms.add( userRooms );
	        
	        
		}
		


		});

}
*/