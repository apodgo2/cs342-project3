/*
 * Project 3 - RSA Algorithm
 * By Nick Zakharov and Andrew Podgorski
 * CS 342 - UIC - Spring 2016
 * ---
 * Main Window Class
 * This class is the main class for our program and includes all necessary functions to initialize GUI and RSA algorithm.
 */

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class MainWindow {

	private JFrame frame;
	private JTextField txtPrivateKeyPath;
	private JTextField txtPublicKeyPath;
	private JTextField txtInputTextPath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
		
		JPanel keypair_panel = new JPanel();
		keypair_panel.setToolTipText("Keypair Generation");
		frame.getContentPane().add(keypair_panel);
		keypair_panel.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblPrivateKeyFile = new JLabel("Private Key File: ");
		keypair_panel.add(lblPrivateKeyFile);
		
		txtPrivateKeyPath = new JTextField();
		txtPrivateKeyPath.setText("Private Key Path");
		keypair_panel.add(txtPrivateKeyPath);
		txtPrivateKeyPath.setColumns(10);
		
		JLabel lblPublicKeyFile = new JLabel("Public Key File: ");
		keypair_panel.add(lblPublicKeyFile);
		
		txtPublicKeyPath = new JTextField();
		txtPublicKeyPath.setText("Public Key Path");
		keypair_panel.add(txtPublicKeyPath);
		txtPublicKeyPath.setColumns(10);
		
		JLabel lblKeypairHelpText = new JLabel("Please enter file paths to load, or generate a new key pair.");
		keypair_panel.add(lblKeypairHelpText);
		
		JPanel keypair_button_panel = new JPanel();
		keypair_panel.add(keypair_button_panel);
		
		JButton btnNewKeypair = new JButton("New Keypair");
		btnNewKeypair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createKeypairDialog();
			}
		});
		keypair_button_panel.add(btnNewKeypair);
		
		JButton btnLoadKeypair = new JButton("Load Keypair");
		keypair_button_panel.add(btnLoadKeypair);
		
		JPanel blocking_panel = new JPanel();
		frame.getContentPane().add(blocking_panel);
		blocking_panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTextPane txtpnBlocktext = new JTextPane();
		txtpnBlocktext.setText("Write your message to be encrypted here, or paste an encrypted and blocked file here to decrypt with the specified private/public keys.");
		blocking_panel.add(txtpnBlocktext);
		
		JPanel function_panel = new JPanel();
		blocking_panel.add(function_panel);
		function_panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInputTextPath = new JLabel("Input Text File Path: ");
		function_panel.add(lblInputTextPath);
		
		txtInputTextPath = new JTextField();
		txtInputTextPath.setText("Insert path to textfile here");
		function_panel.add(txtInputTextPath);
		txtInputTextPath.setColumns(10);
		
		JButton btnEncryptTextFile = new JButton("Encrypt Text File");
		function_panel.add(btnEncryptTextFile);
		
		JButton btnDecryptTextFile = new JButton("Decrypt Text File");
		function_panel.add(btnDecryptTextFile);
		
		JButton btnEncryptTextInput = new JButton("Encrypt Text Input");
		function_panel.add(btnEncryptTextInput);
		
		JButton btnDecryptTextInput = new JButton("Decrypt Text Input");
		function_panel.add(btnDecryptTextInput);
	}
	
	private KeypairDialog createKeypairDialog() {
		KeypairDialog dialog = null;
		try {
			dialog = new KeypairDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dialog;
	}

}