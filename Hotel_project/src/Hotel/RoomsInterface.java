package Hotel;

import javax.swing.*;

import org.apache.commons.lang.CharSet;

public interface RoomsInterface {

	public JLabel nome = new JLabel("Nome e Cognome");
	public JLabel dataArrivo = new JLabel("Data di arrivo");
	public JLabel dataPartenza = new JLabel("Data di partenza");
	public JLabel tipologia = new JLabel("Tipologia di camera");
	public JLabel emailRooms = new JLabel("La vostra Email");
	public JLabel bambini = new JLabel("Bambini");
	
	public JComboBox<Integer> dayArrivo = new JComboBox<>();
	public JComboBox<String> monthArrivo = new JComboBox<>();
	public JComboBox<Integer> yearArrivo = new JComboBox<>();
	
	public JComboBox<Integer> dayPartenza = new JComboBox<>();
	public JComboBox<String> monthPartenza = new JComboBox<>();
	public JComboBox<Integer> yearPartenza = new JComboBox<>();
	
	public JComboBox<Integer> nbambini = new JComboBox<>();
	
	public JComboBox<CharSet> tipologiaCamera = new JComboBox<>();
	
	

	public JTextField userRooms = new JTextField(20);
	//public JPasswordField userPasswordReg = new JPasswordField(20);
	//public JPasswordField userConfpasswod = new JPasswordField(20);
	public JTextField EmailRooms = new JTextField(20);
	public JButton okButtonRooms = new JButton("Ok");
	
	
}
