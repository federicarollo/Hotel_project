package Hotel;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.EventListener.*;
import java.text.*;
import java.io.*; 

public class Password extends JInternalFrame implements PasswordInterface, Maininterface, RoomsInterface
{
	private Container c;
	public String uname,pass,usname;
	public int ctr = 0;
	public CheckBoxHandler handler = new CheckBoxHandler();
	public boolean rem;
	public JFrame frameReg;
	public JFrame frameRegRepaint = new JFrame("Registrazione");
	//private JLabel label;
	private int selectedItemDay=1;
	private String selectedItemMonth;
	private int selectedItemYear=1945;
	private int i, j;
	
	public JFrame Rooms;
	private int k,h;
	private int selectedItemAdulti;
	private String selectedItemType;
	String CurrentType;
	JLabel result;
	
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
						frameReg = new JFrame("Registrazione");
						
						int paintx = (screenSize.width);
						int painty = (screenSize.height);
						System.out.println(paintx);
						System.out.println(painty);
						
						frameReg.setBounds((paintx/2)-200 , (painty/2)-150,
								 400,280);
						
						frameReg.setLayout( null );
										
					    userReg.setBounds( 20,15,80,20 );
				        userReg.setForeground(Color.black);
				        frameReg.add( userReg );
				        
				        
				        passwodReg.setBounds( 20,40,80,20 );
				        passwodReg.setForeground(Color.black);
				        frameReg.add( passwodReg ); 			        
				        
				        confpasswod.setBounds(20, 65, 150, 20);
				        confpasswod.setForeground(Color.black);
				        frameReg.add(confpasswod);
				        
				        
				        email.setBounds(20, 90, 80, 20);
				        email.setForeground(Color.black);
				        frameReg.add(email);				        
				        
				        birthday.setBounds(20, 115, 120, 20);
				        birthday.setForeground(Color.black);
				        frameReg.add(birthday);
				        
				        
				        usersNameReg.setBounds( 170,15,200,20 );
				        frameReg.add( usersNameReg );
				        				        
				        userPasswordReg.setBounds( 170,40,200,20 );
				        frameReg.add( userPasswordReg );
				        				        
				        userConfpasswod.setBounds( 170,65,200,20 );
				        frameReg.add( userConfpasswod );
				        				        			        
				        userEmail.setBounds( 170,90,200,20 );
				        frameReg.add( userEmail );
				        				        					
				        int i, j;
						
				        int[] dayint = new int[31];
						for(i=0; i<31; i++){
							dayint[i]=i+1;
						}
						
						Vector day = new Vector();
						for(j=0; j<i; j++){
							day.add(dayint[j]);
						}
						
						JComboBox dayCombo = new JComboBox(day);
						
					    ActionListener selectionListenerDay = new SelectionListenerDay(); 
					    dayCombo.addActionListener(selectionListenerDay);
					  //  label = new JLabel();
						
					  //  label.setBounds(20, 195, 150, 20);
					 //   frameReg.add(label);
					    
						String[] month = {"Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"};
						
						JComboBox monthCombo = new JComboBox(month);
						
						ActionListener selectionListenerMonth = new SelectionListenerMonth(); 
					    monthCombo.addActionListener(selectionListenerMonth);
					    
						int anno=1945;
						int[] yearint = new int[53];
						for(i=0; i<53 && anno<1998; i++){
							yearint[i]=anno;
							anno++;
						}

						Vector year = new Vector();
						for(j=0; j<i; j++){
							year.add(yearint[j]);
						}
						
						JComboBox yearCombo = new JComboBox(year);
						
						ActionListener selectionListenerYear = new SelectionListenerYear(); 
					    yearCombo.addActionListener(selectionListenerYear);


						dayCombo.setBounds(170, 115, 50, 20);
				        dayCombo.setForeground(Color.black);
				        frameReg.add(dayCombo);
						
				        monthCombo.setBounds(220, 115, 80, 20);
				        monthCombo.setForeground(Color.black);
				        frameReg.add(monthCombo);
				        
				        yearCombo.setBounds(300, 115, 60, 20);
				        yearCombo.setForeground(Color.black);
				        frameReg.add(yearCombo);
				        
				       	okButtonReg.setBounds( 400/2-70/2,150,70,25 );
						frameReg.add( okButtonReg );
											
						avviso.setBounds( 20, 175, 200, 20);
						frameReg.add(avviso);


				        
						frameReg.setVisible(true);
				        				       									
					}			
					
			        class SelectionListenerDay implements ActionListener {
						public void actionPerformed(ActionEvent e){
							JComboBox cb = (JComboBox)e.getSource(); 
					        int selectedItemDay = (int)cb.getSelectedItem();
					      //  label.setText("Selezionato: " + selectedItemDay);
					        System.out.println(selectedItemDay);

							}
					        	
						}
			        
			        class SelectionListenerMonth implements ActionListener {
						public void actionPerformed(ActionEvent e){
							JComboBox cb1 = (JComboBox)e.getSource(); 
					        String selectedItemMonth = (String)cb1.getSelectedItem();
					       // label.setText("Selezionato: " + selectedItemMonth);
					        System.out.println(selectedItemMonth);
							if(selectedItemMonth.equals("Aprile") || selectedItemMonth.equals("Giugno") || selectedItemMonth.equals("Settembre") || selectedItemMonth.equals("Novembre")){
								frameReg.setVisible(false);
								
								frameRegRepaint = new JFrame("Registrazione");
								frameRegRepaint.setBounds((1366/2)-200 , (768/2)-150,
										 400,280);
								frameRegRepaint.setLayout( null );
						        frameRegRepaint.add( userReg );
						        frameRegRepaint.add( passwodReg );
						        frameRegRepaint.add(confpasswod);
						        frameRegRepaint.add(email);
						        frameRegRepaint.add(birthday);				        
						        frameRegRepaint.add( usersNameReg );
						        frameRegRepaint.add( userPasswordReg );
						        frameRegRepaint.add( userConfpasswod );
						        frameRegRepaint.add( userEmail );	
						        //frameRegRepaint.add(monthCombo);
						        //frameRegRepaint.add(yearCombo);
								frameRegRepaint.add( okButtonReg );
								frameRegRepaint.add(avviso);	
																
								int[] dayint = new int[31];
								
								for(i=1; i<31; i++){
									dayint[i]=i;
								}
																								
								Vector<Integer> day = new Vector<Integer>();
								for(j=0; j<i; j++){
									day.add(dayint[j]);
								}
								/*for(i=0; i<30; i++){
									dayint[i]=i+1;
								}
								
								Vector day = new Vector();
								for(j=0; j<i; j++){
									day.add(dayint[j]);
								}*/
																
								JComboBox dayCombo = new JComboBox(day);
							    
								/*ActionListener selectionListenerDay = new SelectionListenerDay(); 
							    dayCombo.addActionListener(selectionListenerDay);*/
								
								dayCombo.setBounds(170, 115, 50, 20);
						        dayCombo.setForeground(Color.black);
						        frameRegRepaint.add(dayCombo);
						        
						      //  String[] month = {"Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"};
								
						        if(selectedItemMonth.equals("Aprile")){
						        	String[] month = {"Aprile", "Gennaio", "Febbraio", "Marzo", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"};
						        	JComboBox monthCombo = new JComboBox(month);
									monthCombo.setBounds(220, 115, 80, 20);
							        monthCombo.setForeground(Color.black);
							        frameRegRepaint.add(monthCombo);
						        }
						        
						        if(selectedItemMonth.equals("Giugno")){
						        	String[] month = {"Giugno", "Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"};
						        	JComboBox monthCombo = new JComboBox(month);
									monthCombo.setBounds(220, 115, 80, 20);
							        monthCombo.setForeground(Color.black);
							        frameRegRepaint.add(monthCombo);
						        }
						        if(selectedItemMonth.equals("Settembre")){
						        	String[] month = {"Settembre", "Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Ottobre", "Novembre", "Dicembre"};
						        	JComboBox monthCombo = new JComboBox(month);
									monthCombo.setBounds(220, 115, 80, 20);
							        monthCombo.setForeground(Color.black);
							        frameRegRepaint.add(monthCombo);
						        }
						        if(selectedItemMonth.equals("Novembre")){
						        	String[] month = {"Novembre", "Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Dicembre"};
						        	JComboBox monthCombo = new JComboBox(month);
									monthCombo.setBounds(220, 115, 80, 20);
							        monthCombo.setForeground(Color.black);
							        frameRegRepaint.add(monthCombo);
						        }
							    
								int anno=1945;
								int[] yearint = new int[54];
								
								yearint[0]=selectedItemYear;
								for(i=1; i<54 && anno<1998; i++){
									yearint[i]=anno;
									anno++;
								}

								Vector year = new Vector();
								for(j=0; j<i; j++){
									year.add(yearint[j]);
								}
								/*for(i=0; i<53 && anno<1998; i++){
									yearint[i]=anno;
									anno++;
								}

								Vector year = new Vector();
								for(j=0; j<i; j++){
									year.add(yearint[j]);
								}*/
								
								JComboBox yearCombo = new JComboBox(year);
					        
								/*ActionListener selectionListenerYear = new SelectionListenerYear(); 
							    yearCombo.addActionListener(selectionListenerYear);*/
							    
						        yearCombo.setBounds(300, 115, 60, 20);
						        yearCombo.setForeground(Color.black);
						        frameRegRepaint.add(yearCombo);
						        
						        frameRegRepaint.setVisible(true);

							}

							
							
							if(selectedItemMonth.equals("Febbraio")){
								//ridisegno il frameReg
								frameReg.setVisible(false);
								
								frameRegRepaint = new JFrame("Registrazione");
								frameRegRepaint.setBounds((1366/2)-200 , (768/2)-150,
										 400,280);
								frameRegRepaint.setLayout( null );
						        frameRegRepaint.add( userReg );
						        frameRegRepaint.add( passwodReg );
						        frameRegRepaint.add(confpasswod);
						        frameRegRepaint.add(email);
						        frameRegRepaint.add(birthday);				        
						        frameRegRepaint.add( usersNameReg );
						        frameRegRepaint.add( userPasswordReg );
						        frameRegRepaint.add( userConfpasswod );
						        frameRegRepaint.add( userEmail );	
						        //frameRegRepaint.add(monthCombo);
						        //frameRegRepaint.add(yearCombo);
								frameRegRepaint.add( okButtonReg );
								frameRegRepaint.add(avviso);	
																
								int[] dayint = new int[30];
								
								dayint[0]=selectedItemDay;
								for(i=1; i<30; i++){
									dayint[i]=i;
								}
								
								Vector day = new Vector();
								for(j=0; j<i; j++){
									day.add(dayint[j]);
								}
								
								/*for(i=0; i<29; i++){
									dayint[i]=i+1;
								}
								
								Vector day = new Vector();
								for(j=0; j<i; j++){
									day.add(dayint[j]);
								}*/
								
								JComboBox dayCombo = new JComboBox(day);
								
								/*ActionListener selectionListenerDay = new SelectionListenerDay(); 
							    dayCombo.addActionListener(selectionListenerDay);*/
							    
								dayCombo.setBounds(170, 115, 50, 20);
						        dayCombo.setForeground(Color.black);
						        frameRegRepaint.add(dayCombo);
						        
						        String[] month = {"Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"};
								
								JComboBox monthCombo = new JComboBox(month);
								
								/*ActionListener selectionListenerMonth = new SelectionListenerMonth(); 
							    monthCombo.addActionListener(selectionListenerMonth);*/
								
								monthCombo.setBounds(220, 115, 80, 20);
						        monthCombo.setForeground(Color.black);
						        frameRegRepaint.add(monthCombo);
							    
								int anno=1945;
								int[] yearint = new int[54];
								
								yearint[0]=selectedItemYear;
								for(i=1; i<54 && anno<1998; i++){
									yearint[i]=anno;
									anno++;
								}

								Vector year = new Vector();
								for(j=0; j<i; j++){
									year.add(yearint[j]);
								}
								
								/*for(i=0; i<53 && anno<1998; i++){
									yearint[i]=anno;
									anno++;
								}

								Vector year = new Vector();
								for(j=0; j<i; j++){
									year.add(yearint[j]);
								}*/
								
								JComboBox yearCombo = new JComboBox(year);
								
								ActionListener selectionListenerYear = new SelectionListenerYear(); 
							    yearCombo.addActionListener(selectionListenerYear);
					        
						        yearCombo.setBounds(300, 115, 60, 20);
						        yearCombo.setForeground(Color.black);
						        frameRegRepaint.add(yearCombo);
						        
						        frameRegRepaint.setVisible(true);
						        frameRegRepaint.validate();
						        c.validate();

							}

						}
			        }
			        
			        class SelectionListenerYear implements ActionListener {
						public void actionPerformed(ActionEvent e){
							JComboBox cb2 = (JComboBox)e.getSource(); 
					        selectedItemYear = (int)cb2.getSelectedItem();
					       // label.setText("Selezionato: " + selectedItemYear);
					        System.out.println(selectedItemYear);
							if((selectedItemYear % 4)==1){
								if(selectedItemMonth.equals("Febbraio")){
									//anno non bisestile, elimino il giorno 29 da febbraio
									frameReg.setVisible(false);
									
									frameRegRepaint = new JFrame("Registrazione");
									frameRegRepaint.setBounds((1366/2)-200 , (768/2)-150,
											 400,280);
									frameRegRepaint.setLayout( null );
							        frameRegRepaint.add( userReg );
							        frameRegRepaint.add( passwodReg );
							        frameRegRepaint.add(confpasswod);
							        frameRegRepaint.add(email);
							        frameRegRepaint.add(birthday);				        
							        frameRegRepaint.add( usersNameReg );
							        frameRegRepaint.add( userPasswordReg );
							        frameRegRepaint.add( userConfpasswod );
							        frameRegRepaint.add( userEmail );	
									frameRegRepaint.add( okButtonReg );
									frameRegRepaint.add(avviso);	
																	
									int[] dayint = new int[29];
									
									dayint[0]=selectedItemDay;
									for(i=1; i<29; i++){
										dayint[i]=i;
									}
									
									Vector day = new Vector();
									for(j=0; j<i; j++){
										day.add(dayint[j]);
									}
									/*for(i=0; i<28; i++){
										dayint[i]=i+1;
									}
									
									Vector day = new Vector();
									for(j=0; j<i; j++){
										day.add(dayint[j]);
									}*/
									
									JComboBox dayCombo = new JComboBox(day);
									
									/*ActionListener selectionListenerDay = new SelectionListenerDay(); 
								    dayCombo.addActionListener(selectionListenerDay);*/
								    
									dayCombo.setBounds(170, 115, 50, 20);
							        dayCombo.setForeground(Color.black);
							        frameRegRepaint.add(dayCombo);
							        
							        String[] month = {"Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"};
									
									JComboBox monthCombo = new JComboBox(month);
									
									/*ActionListener selectionListenerMonth = new SelectionListenerMonth(); 
								    monthCombo.addActionListener(selectionListenerMonth);*/
								    
									monthCombo.setBounds(220, 115, 80, 20);
							        monthCombo.setForeground(Color.black);
							        frameRegRepaint.add(monthCombo);
							        
								    
									int anno=1945;
									int[] yearint = new int[54];
									
									yearint[0]=selectedItemYear;
									for(i=1; i<54 && anno<1998; i++){
										yearint[i]=anno;
										anno++;
									}

									Vector year = new Vector();
									for(j=0; j<i; j++){
										year.add(yearint[j]);
									}
									/*for(i=0; i<53 && anno<1998; i++){
										yearint[i]=anno;
										anno++;
									}

									Vector year = new Vector();
									for(j=0; j<i; j++){
										year.add(yearint[j]);
									}*/
									
									JComboBox yearCombo = new JComboBox(year);
						        
									/*ActionListener selectionListenerYear = new SelectionListenerYear(); 
								    yearCombo.addActionListener(selectionListenerYear);*/
								    
							        yearCombo.setBounds(300, 115, 60, 20);
							        yearCombo.setForeground(Color.black);
							        frameRegRepaint.add(yearCombo);
							        
							        frameRegRepaint.setVisible(true);

								}
							}	
						}
			        }
 					
				}
       	
        );
        

		
        
        okButtonReg.addActionListener( new ActionListener()
        {
			public void actionPerformed(ActionEvent e) 
			{
				//controllo userPasswordReg == userConfpasswod
		        if(!((userPasswordReg.getText()).equals(userConfpasswod.getText()))){
		        	//visualizzo una finestra d'errore
		        	JOptionPane.showMessageDialog(null, "Error. Please retype password");
		        }
		        else
			        //controllo campi obbligatori
			        if((usersNameReg.getText()).isEmpty()){
			        	JOptionPane.showMessageDialog(null, "Error. Username is empty");
			        }
			        else
			        	
			        if((userPasswordReg.getText()).isEmpty()){
			        	JOptionPane.showMessageDialog(null, "Error. Password is empty");
			        }
			        else
			        /*if((userConfpasswod.getText()).isEmpty()){
			        	JOptionPane.showMessageDialog(null, "Error. Password is empty");
			        }*/
			        if((userEmail.getText()).isEmpty()){
			        	JOptionPane.showMessageDialog(null, "Error. Email is empty");
			        }
			        
			        else{
			        String usnamereg = usersNameReg.getText();
			        String uspasswd = userPasswordReg.getText();
			       
			        //costruisco la data nel formato gg/mm/aaaa
		        	//String dayString = new String();
					//String yearString = new String();
					String month = new String();
					//dayString = Integer.toString(selectedItemDay);
					if(selectedItemMonth.equals("Gennaio")) month="01";
					if(selectedItemMonth.equals("Febbraio")) month="02";
					if(selectedItemMonth.equals("Marzo")) month="03";
					if(selectedItemMonth.equals("Aprile")) month="04";
					if(selectedItemMonth.equals("Maggio")) month="05";
					if(selectedItemMonth.equals("Giugno")) month="06";
					if(selectedItemMonth.equals("Luglio")) month="07";
					if(selectedItemMonth.equals("Agosto")) month="08";
					if(selectedItemMonth.equals("Settembre")) month="09";
					if(selectedItemMonth.equals("Ottobre")) month="10";
					if(selectedItemMonth.equals("Novembre")) month="11";
					if(selectedItemMonth.equals("Dicembre")) month="12";
					//String monthString=Integer.toString(monthint);
					//yearString = Integer.toString(selectedItemYear);
					String data = new String();
//					System.out.println("Giorno selezionato: " + dayString);
//					System.out.println("Mese selezionato: " + selectedItemMonth);
//					System.out.println("Anno selezionato: " + yearString);
					
					data=Integer.toString(selectedItemDay).concat("/").concat(month).concat("/").concat(Integer.toString(selectedItemYear));
					System.out.println("Data selezionata: " + data);
			    	boolean checkedreg = false;
			    	
			        //inserisco i dati nel db e controllo che lo username non esista già
			        RegistrazioneSQL regsql = new RegistrazioneSQL(usnamereg, uspasswd, checkedreg);
			        checkedreg = regsql.check();
			        
			        if(checkedreg == false){
			        	JOptionPane.showMessageDialog(null, "Existing username. Please retype username");
			        	
			        }
			        else {
			        	//JOptionPane.showMessageDialog(null, "OK");
			        	
			        	//inserisco i dati nel db
			        	regsql.insert(usnamereg, uspasswd, userEmail.getText(), data);
			        	//chiudi la finestra
			        	frameReg.setVisible(false);
			        	if(frameRegRepaint.isVisible()==true)	frameRegRepaint.setVisible(false);
			        	//cancello il contenuto delle jtextfield
			        	usersNameReg.setText("");
			        	userPasswordReg.setText("");
			        	userConfpasswod.setText("");
			        	userEmail.setText("");
			        }
			        }
			}
		        
			}
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
 				
 				rooms.setEnabled(true);
 				restaurant.setEnabled(true);
 				
 				
 	//codice per collegamento con bottoni del menù principali
 				
 				
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
								 400,300);
						
						//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					   // window.setBounds(0,0,500,250);
					    Rooms.setVisible(true);
					    
					    JLabel sfondo_rooms = new JLabel(new ImageIcon("rooms.png"));
					    

					    //assegno la label al frame
					    Rooms.add(sfondo_rooms);

					    Rooms.setBounds(300,300,400,100);
					    Rooms.setVisible(true);
					    
					    Rooms.setLayout(null);
					   					    
					    nome.setBounds( 5,75,150,20 );
				        nome.setForeground(Color.black);
				        Rooms.add( nome );
				       
				        dataArrivo.setBounds( 5,100,150,20 );
				        dataArrivo.setForeground(Color.black);
				        Rooms.add( dataArrivo );
				        
				        dataPartenza.setBounds( 5,125,150,20 );
				        dataPartenza.setForeground(Color.black);
				        Rooms.add( dataPartenza );
				        
				        tipologia.setBounds( 5,150,150,20 );
				        tipologia.setForeground(Color.black);
				        Rooms.add( tipologia );
				        
				        adulti.setBounds( 5,175,150,20 );
				        adulti.setForeground(Color.black);
				        Rooms.add( adulti );
				        
				        bambini.setBounds( 5,200,150,20 );
				        bambini.setForeground(Color.black);
				        Rooms.add( bambini );			        
				        
				        
				        emailRooms.setBounds( 5,225,150,20 );
				        emailRooms.setForeground(Color.black);
				        Rooms.add( emailRooms );
				        
				   
				         
				        userRooms.setBounds(170, 75, 200, 20);
				        Rooms.add(userRooms);
				        
				        dayArrivo.setBounds(170, 100, 55, 20);
				        dayArrivo.setForeground(Color.black);
				        Rooms.add(dayArrivo);
				        
				        monthArrivo.setBounds(220, 100, 85, 20);
				        monthArrivo.setForeground(Color.black);
				        Rooms.add(monthArrivo);
				        
				        yearArrivo.setBounds(300, 100, 70, 20);
				        yearArrivo.setForeground(Color.black);
				        Rooms.add(yearArrivo);
				        
				        dayPartenza.setBounds(170, 125, 55, 20);
				        dayPartenza.setForeground(Color.black);
				        Rooms.add(dayPartenza);
				        
				        monthPartenza.setBounds(220, 125, 85, 20);
				        monthPartenza.setForeground(Color.black);
				        Rooms.add(monthPartenza);
				        
				        yearPartenza.setBounds(300, 125, 70, 20);
				        yearPartenza.setForeground(Color.black);
				        Rooms.add(yearPartenza);
				        
				        tipologiaCamera.setBounds(170, 150, 200, 20 );
						Rooms.add(tipologiaCamera);
				        
						// JFrame frame = new JFrame("Combo Box Demo");
						   // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						   // frame.setSize(200, 200);
						    Rooms.setLayout(new BorderLayout());

						    String[] comboBoxItems = {"Singola", "Doppia", "Tripla", "Matrimoniale", "Suite"};
						    
						    final DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
						    JComboBox comboBox = new JComboBox(model);
						    Rooms.add(comboBox);


						    Rooms.setVisible(true);
				      
				      /*  String[] type = {"Singola", "Doppia", "Tripla", "Matrimoniale", "Suite"};
						
				        CurrentType=type[0];
				        
						JComboBox typeCombo = new JComboBox(type);	
						

					        
				        class SelectionListenerType implements ActionListener {
							public void actionPerformed(ActionEvent e){
								JComboBox cbType = (JComboBox)e.getSource(); 
						        String selectedItemType = (String)cbType.getSelectedItem();
						        CurrentType=selectedItemType;
						      //  reformat();
						       // label.setText("Selezionato: " + selectedItemType);
						       // System.out.println(selectedItemDay);

								}
						        	
							}
				        
				        ActionListener selectionListenerType = new SelectionListenerType(); 
				        typeCombo.addActionListener(selectionListenerType);
				        
				        */
				        int h, k;
						
				        int nrAdulti [] = new int[15];
						for(h=0; h<15; h++){
							nrAdulti[h]=h+1;
						}
												
						
						Vector Adulti = new Vector();
						for(k=0; k<h; k++){
							Adulti.add(nrAdulti[k]);
						}
						
						JComboBox AdultiCombo = new JComboBox(Adulti);
						
						class SelectionListenerAdulti implements ActionListener {
							public void actionPerformed(ActionEvent e){
								JComboBox cbAdulti = (JComboBox)e.getSource(); 
						        int selectedItemAdulti = (int)cbAdulti.getSelectedItem();
						       // label.setText("Selezionato: " + selectedItemAdulti);
						       // System.out.println(selectedItemAdulti);

								}
						        	
							}
						
						ActionListener selectionListenerAdulti = new SelectionListenerAdulti();
					    AdultiCombo.addActionListener(selectionListenerAdulti);
						
						
						
						
				        nadulti.setBounds(170, 175, 200, 20 );
						Rooms.add(nadulti);
						    
						nbambini.setBounds(170, 200, 200, 20 );
						Rooms.add(nbambini );
				        
					    EmailRooms.setBounds(170, 225, 200, 20 );
						Rooms.add(EmailRooms );
						
						
						Rooms.setVisible(true);
						
				        
				        
					}


					

 				});
 				
 				
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
