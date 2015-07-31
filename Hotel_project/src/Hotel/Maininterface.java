package Hotel;

import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.util.*;

public interface Maininterface
{

	public Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	public JDesktopPane desktop = new JDesktopPane(); 
    public boolean open = false;
    public  String passwd = "";
    public JMenu menu = new JMenu("File"); 
    public JButton rooms = new JButton ("Rooms");
    public JButton restaurant = new JButton ("Restaurant");
 //   public JMenu add = new JMenu("Library"); 
 //   public JMenu rtn = new JMenu("Window"); 
 //   public JMenu report = new JMenu("Reports"); 
 //   public JMenu help = new JMenu("Help"); 
    public JMenuBar menuBar = new JMenuBar();
//    public JMenuItem menuItemhelp1 = new JMenuItem("Help Contents...", new ImageIcon("help.gif"));
//    public JMenuItem menuItemhelp2 = new JMenuItem("Splash screen...");
//    public JMenuItem menuItemhelp3 = new JMenuItem("About us...", new ImageIcon("about.gif"));
    public JMenuItem menuItem3 = new JMenuItem("Login...", new ImageIcon("login.gif"));
    public JMenuItem menuItem6 = new JMenuItem("Logoff...", new ImageIcon("logout.gif"));
    public JMenuItem menuItem5 = new JMenuItem("Exit...", new ImageIcon("quit.gif"));
//    public JMenuItem returnItem1 = new JMenuItem("Close...", new ImageIcon("close.gif"));
//    public JMenuItem returnItem2 = new JMenuItem("Close All...", new ImageIcon("closeall.gif"));
//    public JMenuItem returnItem3 = new JMenu("Skin");
//    public JMenuItem returnItem4 = new JMenuItem("Background Color");
//    public JMenuItem bk_mast = new JMenuItem("Book Master...");
//    public JMenuItem bk_loan = new JMenuItem("Book Loan...");
//    public JMenuItem bk_ret = new JMenuItem("Book Return...");
//    public JMenuItem j_master = new JMenuItem("Journal Master...");
//    public JMenuItem j_loan = new JMenuItem("Journal Loan...");
//    public JMenuItem j_ret = new JMenuItem("Journal Return...");
//    public JMenuItem v_master = new JMenuItem("Video Master...");
//    public JMenuItem v_loan = new JMenuItem("Video Loan...");
//    public JMenuItem v_ret = new JMenuItem("Video Return...");
//    public JMenuItem pt_mast = new JMenuItem("Patron Master...");
//    public JMenuItem reportItem1 = new JMenuItem("Patron Inventory...");
//    public JMenuItem reportItem2 = new JMenuItem("Item Inventory...");
    public Password app = new Password();
//    public aboutUs aboutus = new aboutUs();
    public JLabel USERName = new JLabel("Welcome to Anacleto Hotel, please login to your account");
	public JLabel logo = new JLabel();
	public Icon accLogo = new ImageIcon("Sfondo.jpg");
	public String userName = "";
//	public String strings[] = { "1. Metal", "2. Motif", "3. Windows" };
	public UIManager.LookAndFeelInfo looks[] = UIManager.getInstalledLookAndFeels();
	public ButtonGroup group = new ButtonGroup();
//	public JRadioButtonMenuItem radio[] = new JRadioButtonMenuItem[ strings.length ];
//	public char mne[] ={ '1', '2', '3' };
	public java.util.Date currentDate = new java.util.Date();
	public SimpleDateFormat formatter = new SimpleDateFormat ("MMMM dd yyyy", Locale.getDefault());
}