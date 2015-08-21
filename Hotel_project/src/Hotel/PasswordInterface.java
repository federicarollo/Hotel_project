package Hotel;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public interface PasswordInterface
{
	public JLabel user = new JLabel("User Name");
	public JLabel passwod = new JLabel("Password");
	public JLabel registrazione = new JLabel("Non hai un account?");
	public JButton reg = new JButton("Registrati!");
	public JTextField usersName = new JTextField(20);
	public JPasswordField userPassword = new JPasswordField(20);
	public JButton okButton = new JButton("Ok");
	public JButton closeButton = new JButton("Close");
	public JCheckBox chk = new JCheckBox("Remember Password");
	
	//interfaccia per la registrazione
	public JLabel userReg = new JLabel("Username*");
	public JLabel passwodReg = new JLabel("Password*");
	public JLabel confpasswod = new JLabel("Conferma password*");
	public JLabel email = new JLabel("Email*");
	
	public JLabel birthday = new JLabel("Data di nascita");
	public JComboBox<Integer> dayCombo = new JComboBox<>();
	public JComboBox<String> monthCombo = new JComboBox<>();
	public JComboBox<Integer> yearCombo = new JComboBox<>();
	
	public JLabel avviso = new JLabel("* i campi sono obbligatori");

	public JTextField usersNameReg = new JTextField(20);
	public JPasswordField userPasswordReg = new JPasswordField(20);
	public JPasswordField userConfpasswod = new JPasswordField(20);
	public JTextField userEmail = new JTextField(20);
	public JButton okButtonReg = new JButton("OK");
		
}