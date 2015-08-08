package Hotel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.print.*;
import java.io.*;
import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.image.BufferedImage;

public class Main extends JFrame implements Maininterface, InternalFrameListener{
	
	
	splash_frame splash = new splash_frame();
	
	/*try {
		URL mapUrl = new URL("http://maps.googleapis.com/maps/api/staticmap?center=modena+fonte+d'abisso&zoom=17&scale=1&size=600x300&maptype=roadmap&format=png&visual_refresh=true");
	
		BufferedImage mapImage = ImageIO.read(mapUrl);
	}
	catch (IOException e) {
		e.printStackTrace();

	}*/
	
	
    public Main() {
    	
        super("Title"); 
        try {
    		URL mapUrl = new URL("http://maps.googleapis.com/maps/api/staticmap?center=modena+fonte+d'abisso&zoom=17&scale=1&size=600x300&maptype=roadmap&format=png&visual_refresh=true");
    	
    		BufferedImage mapImage = ImageIO.read(mapUrl);
    	}
    	catch (IOException e) {
    		e.printStackTrace();

    	}
        
        splash();
        int inset = 0;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((screenSize.width-100), (screenSize.height-100));
        
        //per disattivare il ridimensionamento della finestra e risolvere il problema dell'adattamento dell'immagine
        setResizable(false); 

        
        setIconImage(getToolkit().getImage("Icon.jpg"));
		
        //Quit this app when the big window closes.
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
               
		
		/*
		//to enable the enter key
		UIManager.getDefaults().put("Button.focusInputMap", new
		UIDefaults.LazyInputMap(new Object[] {
		"ENTER", "pressed",
		"released ENTER", "released"
		}));*/

        setContentPane(desktop);
       	
       	USERName.setFont (new Font ("Pristina", Font.PLAIN, 40));
       	USERName.setForeground(Color.black);
        USERName.setBounds(300,50,1000,50);
        desktop.add(USERName);
        
//        add.setEnabled(false);
        rooms.setEnabled(true);
        restaurant.setEnabled(false);
        
        setJMenuBar(createMenuBar());
		int paintx = (screenSize.width);
		int painty = (screenSize.height);
		
		rooms.setBounds((paintx/2)-200 , (painty/2)-150,
	 		300,100);
		//per combinare più stili insieme     f = new Font("Symbol", Font.BOLD+Font.ITALIC, 12);
		rooms.setFont(new Font("Georgia", Font.BOLD ,35));
		
		// per modificare il colore alla casella rooms.setBackground(Color.darkGray);
		//per nascondere la casella, se voglio farla uscire soltanto dopo il login rooms.setVisible(false);
		restaurant.setBounds((paintx/2)-200 , (painty/2)-10,
			300,100);
		restaurant.setFont(new Font("Georgia", Font.BOLD ,35));

		desktop.add(rooms);
		desktop.add(restaurant);
		
		ImageIcon imageIcon = new ImageIcon("Sfondo.jpg");
//		Image image = imageIcon.getImage(); // transform it 
//		Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
//		imageIcon = new ImageIcon(newimg);  // transform it back
	
		
	
		
		
        logo.setIcon( accLogo );
              
    	logo.setBounds( 0, 0, paintx, painty);
		
		desktop.add(logo);
		
		//desktop.setBackground(Color.gray);
		
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                /*try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }*/

              
            }
        });

		
		
    }
    
    
    
    public void getPassword()
	{
	    desktop.add( app );
		try
		{
			app.setSelected( true );
		}
		catch( java.beans.PropertyVetoException pvex )
		{
		}
	}
	
    protected JMenuBar createMenuBar() {
    	        
        menu.setMnemonic(KeyEvent.VK_F);
        
//        add.setMnemonic(KeyEvent.VK_L);
//        rtn.setMnemonic(KeyEvent.VK_W);
//        report.setMnemonic(KeyEvent.VK_R);
        help.setMnemonic(KeyEvent.VK_H);
        
        //items for help
       menuItemhelp1.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F1, ActionEvent.CTRL_MASK));
               
       //da modificare per visualizzare l'immagine
       menuItemhelp1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JFrame frame = new JFrame();
            	
                JPanel panel = new JPanel();

                panel.setLayout(new BorderLayout());
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon("hotelMap.png"));
                panel.add(label, BorderLayout.PAGE_START);
                label.setHorizontalAlignment(SwingConstants.CENTER);

                JTextArea textArea = new JTextArea(
                        "\nVia fonte d'abisso, 14\n"
                        + "Tel. 1111111111 Fax. 1111111111\n"
                        + "email \n"
                        + "4. Messaggio4'",
                        6,
                        50);
               
                Font font = new Font("Arial", Font.BOLD, 12);
                textArea.setFont(font);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setOpaque(false);
                textArea.setEditable(false);
                textArea.setLocation(50, 200);
                //modificare il layout del testo
                panel.add(textArea, BorderLayout.PAGE_END);
              //  panel.add(textArea);

                // display the jpanel in a joptionpane dialog, using showMessageDialog
                JOptionPane.showMessageDialog(frame, panel);
            }});
                /*JOptionPane.showMessageDialog(null, 
 				"\n1. To Add a record, fill in all the fields and click on Add." +
 				"\n\n2. To Update A Record, Search for the record first and click on Save." + 
 				"\n\n3. To Delete A Record, Search for the record and click Delete." + 
 				"\n\n4. To Clear Fields, click on Clear." + 
 				"\n\n5. To Exit this module, click on Close." +
 				"\n\n6. To View the report, click on report." +
 				"\n\n7. To change the Skin, selected skin under window menu. " +
 				"\n\n8. For More help Please Contact us at dh002211@ex.apiit.edu.my.");
            
            }
        });*/
              
       /*menuItemhelp2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createSplash();
            
            }
        });*/
        /*
       menuItemhelp3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
         	aboutUs aboutus = new aboutUs();
         	aboutus.setVisible(true);
        	desktop.add(aboutus);
        	try {
            	aboutus.setSelected(true);
        	} catch (java.beans.PropertyVetoException ex) {}
            
            }
        });
        
  */      
       //items for file
        menuItem3.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        menuItem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.show();  
            }
        });
        
        menuItem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             getPassword();                        
            }
        });
        
        menuItem6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, 
			"Are you sure want to Log Out?", 
			"Log Out", 
			JOptionPane.YES_NO_OPTION);
 				
 			if( confirm == JOptionPane.YES_OPTION )
 			{
// 				add.setEnabled(false);
 				
 				rooms.setEnabled(false);
 				restaurant.setEnabled(false);
 				
 				menuItem6.setEnabled(false);
 				menuItem3.setEnabled(true);
 		
 				USERName.setText("Welcome to Anacleto hotel, please login to your account");
 				

 				
 				}
                        
            }
        });
        
                      
        menuItem5.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        
        menuItem5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int confirm = JOptionPane.showConfirmDialog(null, 
			"Are you sure want to exit?", 
			"Exit Application", 
			JOptionPane.YES_NO_OPTION);
 				
 			if( confirm == JOptionPane.YES_OPTION )
 			{
// 				JOptionPane.showMessageDialog( null, 
// 				"Thanks for using our System");
 				dispose();
 				System.exit(0);
 				
 			}
            }
        });        
                       
                
        //items for return
/*        returnItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              try {
            		desktop.getSelectedFrame().setClosed(true);
        		} catch (java.beans.PropertyVetoException pve) {}
            }
        });
        
        returnItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JInternalFrame Frames[] = desktop.getAllFrames(); // get all open frames

				for(int FrameLoop=0; FrameLoop < Frames.length; FrameLoop++)
				{
					try
					{
				 		Frames[FrameLoop].setClosed(true); // close the frame
					}
					catch (Exception CloseExc)
					{
						// if we can't close it then we have a problem
						JOptionPane.showMessageDialog(null, CloseExc);
					}
				}
            }
        });
        
        //items for library
        bk_mast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 add.setEnabled(false);
              createBookMaster();
            }
        });
        
        bk_loan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	add.setEnabled(false);
              createBookLoan();
            }
        });
        
        bk_ret.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	add.setEnabled(false);
              createFrame3();
            }
        });
       
        j_master.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	add.setEnabled(false);
              createJournal();
            }
        });
        
        j_loan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	add.setEnabled(false);
              createBookLoan();
            }
        });
        
        j_ret.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	add.setEnabled(false);
              createFrame3();
            }
        });
        
        v_master.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	add.setEnabled(false);
              createVideo();
            }
        });
        
        v_loan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	add.setEnabled(false);
              createBookLoan();
            }
        });
        
        v_ret.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	add.setEnabled(false);
              createFrame3();
            }
        });
        
        pt_mast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	add.setEnabled(false);
              createFrame2();
            }
        });
        
        //items for report
        reportItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              patronReport rep = new patronReport();
            }
        });
        
        reportItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              bookReport rep = new bookReport();
              //reateReport();
            }
        });
        
        
        
        ItemHandler handler = new ItemHandler();
        	for( int i = 0; i < radio.length ; i++ )
		{
			radio[i] = new JRadioButtonMenuItem( strings[i] );
			radio[i].setMnemonic( mne[i] );
			radio[i].addItemListener( handler );
			group.add( radio[i] );
			returnItem3.add( radio[i] );
		}
		
		returnItem4.addActionListener(
			new ActionListener()
			{
				public void actionPerformed( ActionEvent e )
				{
					Color color = new Color( 86,1,46 );
					color = JColorChooser.showDialog( main.this,
						"Choose background color", color );
					
					if( color == null )
						color = Color.gray;
					desktop.setBackground( color );
					menuBar.setBackground( color);
					menu.setBackground( color);
					add.setBackground( color);
					rtn.setBackground( color);
					report.setBackground( color);
					help.setBackground( color);
					bk_loan.setBackground(color);
					desktop.repaint();
					menuBar.repaint();
					menu.repaint();
					add.repaint();
					rtn.repaint();
					report.repaint();
					help.repaint();
					bk_loan.repaint();
        			bk_mast.setBackground(color);
        			bk_ret.setBackground(color);
        			j_master.setBackground(color);
        			j_loan.setBackground(color);
        			j_ret.setBackground(color);
        			v_master.setBackground(color);
        			v_loan.setBackground(color);
        			v_ret.setBackground(color);
        			pt_mast.setBackground(color);
        			menuItem3.setBackground(color);
        			menuItem6.setBackground(color);
        			menuItem5.setBackground(color);
        			returnItem1.setBackground(color);
  					returnItem2.setBackground(color);
        			returnItem3.setBackground(color);
        			returnItem4.setBackground(color);
        			reportItem1.setBackground(color);
        			reportItem2.setBackground(color);
        			menuItemhelp1.setBackground(color);
        			menuItemhelp2.setBackground(color);
        			menuItemhelp3.setBackground(color);
        			menuBar.setBackground(color);
        			menu.setBackground(color);
        			add.setBackground(color);
        			report.setBackground(color);
        			rtn.setBackground(color);
        			help.setBackground(color);
        			for( int i = 0; i < radio.length; i++ ){
					radio[i].setBackground(color);	
					}
				}
			});
        
        
        //items for reports
        
        //add items for library
        
        add.add(bk_mast);
        bk_mast.setBackground(Color.gray);
        //add.addSeparator();
        add.add(bk_loan);
        bk_loan.setBackground(Color.gray);
        //add.addSeparator();
        add.add(bk_ret);
        bk_ret.setBackground(Color.gray);
        add.addSeparator();
        add.add(j_master);
        j_master.setBackground(Color.gray);
        //add.addSeparator();
        add.add(j_loan);
        j_loan.setBackground(Color.gray);
        //add.addSeparator();
        add.add(j_ret);
        j_ret.setBackground(Color.gray);
        add.addSeparator();
        add.add(v_master);
        v_master.setBackground(Color.gray);
        //add.addSeparator();
        add.add(v_loan);
        v_loan.setBackground(Color.gray);
        //add.addSeparator();
        add.add(v_ret);
        v_ret.setBackground(Color.gray);
        //add.addSeparator();
        add.addSeparator();
        add.add(pt_mast);
        pt_mast.setBackground(Color.gray);
*/ 
        
        //add items for menu
        
        menu.add(menuItem3);
        menuItem3.setBackground(Color.gray);
        //menu.addSeparator();
        menu.add(menuItem6);
        menuItem6.setBackground(Color.gray);
        menu.addSeparator();
        menu.add(menuItem5);
        menuItem5.setBackground(Color.gray);
                       
        //add items for window
//        rtn.add(returnItem1);
//        returnItem1.setBackground(Color.gray);
  		//rtn.addSeparator();
//        rtn.add(returnItem2);
//        returnItem2.setBackground(Color.gray);
        
//        rtn.addSeparator();
//        rtn.add(returnItem3);
//        returnItem3.setBackground(Color.gray);
        //rtn.addSeparator();
//        rtn.add(returnItem4);
//        returnItem4.setBackground(Color.gray);
        
        //add items for report
//        report.add(reportItem1);
//        reportItem1.setBackground(Color.gray);
        //report.addSeparator();
//        report.add(reportItem2);
//        reportItem2.setBackground(Color.gray);
        
        //add items for help
        help.add(menuItemhelp1);
        menuItemhelp1.setBackground(Color.gray);
        //help.addSeparator();
//        help.add(menuItemhelp2);
//        menuItemhelp2.setBackground(Color.gray);
//        help.addSeparator();
//        help.add(menuItemhelp3);
//        menuItemhelp3.setBackground(Color.gray);
        
        
//        add.setEnabled(false);
        menuBar.setBackground(Color.gray);
        menu.setBackground(Color.gray);
//        add.setBackground(Color.gray);
//        report.setBackground(Color.gray);
//        rtn.setBackground(Color.gray);
//        help.setBackground(Color.gray);
        
/*        for( int i = 0; i < radio.length; i++ ){
				radio[i].setBackground(Color.gray);
			
		}
*/  
        
        menuBar();   
        return menuBar;
    }
    public void menuBar() {
		menuItem6.setEnabled(false);
//    	add.setEnabled( false );

		rooms.setEnabled(false);
		restaurant.setEnabled(false);
		menuBar.add(menu);
//        menuBar.add(add);
//        menuBar.add(report);
//        menuBar.add(rtn);
        menuBar.add(help);
         
    }
    
/*      
    protected void createFrame2() {
    	General_frame frame2 = new General_frame();
        desktop.add(frame2);
        frame2.addInternalFrameListener( this ); 
        try {
            frame2.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }
    
    protected void createFrame3() {
        ReturnMain frame3 = new ReturnMain();
        frame3.setVisible(true);
        desktop.add(frame3);
        frame3.addInternalFrameListener( this ); 
        try {
            frame3.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }
    */
    protected void createSplash() {
        splash.setVisible(true);
        desktop.add(splash);
        try {
            splash.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }
/*
	protected void createBookMaster() {
		book_master master = new book_master();
        master.setVisible(true);
        desktop.add(master);
        master.addInternalFrameListener( this );  
        try {
            master.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }
    
    protected void createBookLoan() {
    	book_loan loan = new book_loan();
        loan.setVisible(true);
        desktop.add(loan);
        loan.addInternalFrameListener( this );        
        try {
            loan.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }
    
    protected void createJournal() {
    	journal jor = new journal();
        jor.setVisible(true);
        desktop.add(jor);
        jor.addInternalFrameListener( this );
        try {
            jor.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }
    
    protected void createVideo() {
    	video vid = new video();
        vid.setVisible(true);
        desktop.add(vid);
        vid.addInternalFrameListener( this );
        try {
            vid.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }
*/          
    public void internalFrameClosing(InternalFrameEvent e) {
//    	System.out.println(splash.getX());
    
//    	add.setEnabled(true);
   
    	rooms.setEnabled(false);
    	restaurant.setEnabled(false);
    	
    }

    public void internalFrameClosed(InternalFrameEvent e) {
//    	System.out.println(splash.getX());
      
//    	add.setEnabled(true);
  
    	rooms.setEnabled(false);
    	restaurant.setEnabled(false);
    
    }

    public void internalFrameOpened(InternalFrameEvent e) {
//    	System.out.println(splash.getX());
            
    }

    public void internalFrameIconified(InternalFrameEvent e) {
//    	System.out.println(splash.getX());
        
    }

    public void internalFrameDeiconified(InternalFrameEvent e) {
//    	System.out.println(splash.getX());
        
    }

    public void internalFrameActivated(InternalFrameEvent e) {
    	
//    	System.out.println(splash.getX());
        
    }

    public void internalFrameDeactivated(InternalFrameEvent e) {
//    	System.out.println(splash.getX());
        
    }
    
	private static void splash()
	{
		th.start(); // I sleep to let the thread startup and display the window
			while (splash3.getWindow() == null || !splash3.getWindow().isShowing())
			{ 
				try { 
					Thread.sleep(2000);
					} 
				catch (InterruptedException e){} 
			}
			 
	}
	
	
    public void changeTheLookAndFeel( int value )
	{
		try
		{
			UIManager.setLookAndFeel
			( looks[value].getClassName() );
			SwingUtilities.updateComponentTreeUI( this );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}
    
/*    	public class ItemHandler implements ItemListener
	{
		public void itemStateChanged( ItemEvent e )
		{
			for( int i = 0; i < radio.length; i++ )
				if( radio[i].isSelected() )
					{
						
						changeTheLookAndFeel( i );
					}
		}
	}
*/	
    
    public static class TestPane extends JPanel {

        public static final long RUNNING_TIME = 2000;

        private BufferedImage inImage;
        private BufferedImage outImage;

        private float alpha = 0f;
        private long startTime = -1;

        public TestPane() {
            try {
                inImage = ImageIO.read(new File("Sfondo.jpg"));
                outImage = ImageIO.read(new File("Sfondo1.jpg"));
            } catch (IOException exp) {
                exp.printStackTrace();
            }

            final Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (startTime < 0) {
                        startTime = System.currentTimeMillis();
                    } else {

                        long time = System.currentTimeMillis();
                        long duration = time - startTime;
                        if (duration >= RUNNING_TIME) {
                            startTime = -1;
                            ((Timer) e.getSource()).stop();
                            alpha = 0f;
                        } else {
                            alpha = 1f - ((float) duration / (float) RUNNING_TIME);
                        }
                        repaint();
                    }
                }
            });
            addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    alpha = 0f;
                    BufferedImage tmp = inImage;
                    inImage = outImage;
                    outImage = tmp;
                    timer.start();
                }

            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(
                            Math.max(inImage.getWidth(), outImage.getWidth()), 
                            Math.max(inImage.getHeight(), outImage.getHeight()));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setComposite(AlphaComposite.SrcOver.derive(alpha));
            int x = (getWidth() - inImage.getWidth()) / 2;
            int y = (getHeight() - inImage.getHeight()) / 2;
            g2d.drawImage(inImage, x, y, this);

            g2d.setComposite(AlphaComposite.SrcOver.derive(1f - alpha));
            x = (getWidth() - outImage.getWidth()) / 2;
            y = (getHeight() - outImage.getHeight()) / 2;
            g2d.drawImage(outImage, x, y, this);
            g2d.dispose();
        }

    }

    
    public static void main(String[] args) {
    	Main frame = new Main();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TestPane());
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        splash3.getWindow().dispose();
        
    }
}