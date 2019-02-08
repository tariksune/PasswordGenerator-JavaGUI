package passwordGeneratorJavaGui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

public class passwordGenerator {

	private JFrame frmStrngpwrd;
	private JTextField txtPassword;
	private String characterList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789~`!@#$%^&*()-_+={}[]|\\;:\"<>,./?";
	private JTextField getNumFromUser;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					passwordGenerator window = new passwordGenerator();
					window.frmStrngpwrd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public passwordGenerator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStrngpwrd = new JFrame();
		frmStrngpwrd.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bella\\Downloads\\iconfinder_lock_299105.png"));
		frmStrngpwrd.getContentPane().setBackground(Color.BLACK);
		frmStrngpwrd.setTitle("str0ngP455w0rd");
		frmStrngpwrd.setBounds(100, 100, 320, 351);
		frmStrngpwrd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStrngpwrd.getContentPane().setLayout(null);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setForeground(Color.GREEN);
		btnGenerate.setBackground(Color.BLACK);
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int length = Integer.parseInt(getNumFromUser.getText());
				StringBuilder string = new StringBuilder();
				for (int i = 0; i < length; i++) {
					int num = random();
					char character = characterList.charAt(num);
					string.append(character);
				}
				txtPassword.setText(string.toString());
			}
			private int random() {
				int randomNumber=0;
				Random randomCreate = new Random();
				randomNumber = randomCreate.nextInt(characterList.length());
				if (randomNumber -1 == -1) {
					return randomNumber;
				} else {
					return randomNumber-1;
				}
			}
		});
		btnGenerate.setFont(new Font("Arial Narrow", Font.BOLD, 17));
		btnGenerate.setBounds(104, 160, 101, 29);
		frmStrngpwrd.getContentPane().add(btnGenerate);
		
		JButton btnCopy = new JButton("Copy");
		btnCopy.setFont(new Font("Arial Narrow", Font.BOLD, 17));
		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtPassword.copy();
				StringSelection stringSelection = new StringSelection (txtPassword.getText());
				Clipboard clipboard = Toolkit.getDefaultToolkit ().getSystemClipboard ();
				clipboard.setContents (stringSelection, null);
			}
		});
		btnCopy.setForeground(Color.GREEN);
		btnCopy.setBackground(Color.BLACK);
		btnCopy.setBounds(104, 252, 101, 29);
		frmStrngpwrd.getContentPane().add(btnCopy);
		
		JLabel headLabel = new JLabel("str0NgP455w0Rd");
		headLabel.setForeground(Color.GREEN);
		headLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headLabel.setFont(new Font("Courier New", Font.BOLD, 25));
		headLabel.setBounds(10, 27, 280, 29);
		frmStrngpwrd.getContentPane().add(headLabel);
		
		JLabel infoLabel = new JLabel("Enter the Number of Characters");
		infoLabel.setForeground(Color.GREEN);
		infoLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel.setBounds(10, 74, 280, 23);
		frmStrngpwrd.getContentPane().add(infoLabel);
		
		JLabel tariksuneLabel = new JLabel("tariksune.com");
		tariksuneLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Desktop masaustu = Desktop.getDesktop();
				try {
					masaustu.browse(new URI("https://www.tariksune.com/"));
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Hata! Tekrar Deneyiniz.");
				}
			}
		});
		tariksuneLabel.setFont(new Font("Courier New", Font.PLAIN, 12));
		tariksuneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tariksuneLabel.setForeground(Color.GREEN);
		tariksuneLabel.setBounds(10, 293, 280, 16);
		frmStrngpwrd.getContentPane().add(tariksuneLabel);
		
		txtPassword = new JTextField();
		txtPassword.setForeground(Color.GREEN);
		txtPassword.setBackground(Color.DARK_GRAY);
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setFont(new Font("Arial Narrow", Font.BOLD, 17));
		txtPassword.setBounds(10, 206, 280, 34);
		frmStrngpwrd.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		getNumFromUser = new JTextField();
		getNumFromUser.setForeground(Color.GREEN);
		getNumFromUser.setBackground(Color.DARK_GRAY);
		getNumFromUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e2) {
				char c = e2.getKeyChar();
				if(!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
					e2.consume();
				}
			}
		});
		getNumFromUser.setFont(new Font("Dialog", Font.PLAIN, 16));
		getNumFromUser.setHorizontalAlignment(SwingConstants.CENTER);
		getNumFromUser.setBounds(104, 119, 101, 29);
		frmStrngpwrd.getContentPane().add(getNumFromUser);
		getNumFromUser.setColumns(10);
		
		
		
	}
	
}
