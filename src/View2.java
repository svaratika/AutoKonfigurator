import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View2 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldVorname;
	private JTextField textFieldNachname;
	private JTextField textFieldStrasse;
	private JTextField textFieldPlz;
	private JTextField textFieldOrt;
	private JTextField textFieldTele;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View2 frame = new View2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View2() {
		setTitle("Auto Konfigurator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelMain = new JPanel();
		contentPane.add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(null);
		
		JLabel lblTitle = new JLabel("Personliche Informationen");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 14));
		lblTitle.setBounds(10, 11, 200, 25);
		panelMain.add(lblTitle);
		
		JLabel lblVorname = new JLabel("Vorname    :");
		lblVorname.setHorizontalAlignment(SwingConstants.LEFT);
		lblVorname.setFont(new Font("Arial", Font.PLAIN, 14));
		lblVorname.setBounds(20, 47, 100, 25);
		panelMain.add(lblVorname);
		
		JComboBox comboBoxLand = new JComboBox();
		comboBoxLand.setModel(new DefaultComboBoxModel(new String[] {"Schweiz", "Deutschland", "Frankreich"}));
		comboBoxLand.setSelectedIndex(0);
		comboBoxLand.setBounds(130, 227, 200, 25);
		panelMain.add(comboBoxLand);
		
		textFieldVorname = new JTextField();
		textFieldVorname.setBounds(130, 47, 200, 25);
		panelMain.add(textFieldVorname);
		textFieldVorname.setColumns(10);
		
		JLabel lblNachname = new JLabel("Nachname  :");
		lblNachname.setHorizontalAlignment(SwingConstants.LEFT);
		lblNachname.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNachname.setBounds(20, 83, 100, 25);
		panelMain.add(lblNachname);
		
		textFieldNachname = new JTextField();
		textFieldNachname.setColumns(10);
		textFieldNachname.setBounds(130, 83, 200, 25);
		panelMain.add(textFieldNachname);
		
		JLabel lblStrasse = new JLabel("Strasse und Hausnummer :");
		lblStrasse.setHorizontalAlignment(SwingConstants.LEFT);
		lblStrasse.setFont(new Font("Arial", Font.PLAIN, 14));
		lblStrasse.setBounds(20, 119, 200, 25);
		panelMain.add(lblStrasse);
		
		textFieldStrasse = new JTextField();
		textFieldStrasse.setColumns(10);
		textFieldStrasse.setBounds(20, 155, 310, 25);
		panelMain.add(textFieldStrasse);
		
		JLabel lblPlz = new JLabel("PLZ");
		lblPlz.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlz.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPlz.setBounds(20, 191, 35, 25);
		panelMain.add(lblPlz);
		
		textFieldPlz = new JTextField();
		textFieldPlz.setColumns(10);
		textFieldPlz.setBounds(65, 191, 100, 25);
		panelMain.add(textFieldPlz);
		
		JLabel lblOrt = new JLabel("Ort");
		lblOrt.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrt.setFont(new Font("Arial", Font.PLAIN, 14));
		lblOrt.setBounds(185, 191, 35, 25);
		panelMain.add(lblOrt);
		
		textFieldOrt = new JTextField();
		textFieldOrt.setColumns(10);
		textFieldOrt.setBounds(230, 191, 100, 25);
		panelMain.add(textFieldOrt);
		
		JLabel lblLand = new JLabel("Land :");
		lblLand.setHorizontalAlignment(SwingConstants.LEFT);
		lblLand.setFont(new Font("Arial", Font.PLAIN, 14));
		lblLand.setBounds(20, 227, 100, 25);
		panelMain.add(lblLand);
		
		JLabel lblTele = new JLabel("Telefonnummer :");
		lblTele.setHorizontalAlignment(SwingConstants.LEFT);
		lblTele.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTele.setBounds(20, 263, 115, 25);
		panelMain.add(lblTele);
		
		textFieldTele = new JTextField();
		textFieldTele.setColumns(10);
		textFieldTele.setBounds(130, 263, 200, 25);
		panelMain.add(textFieldTele);
		
		JButton btnLoschen = new JButton("L\u00F6schen");
		btnLoschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldVorname.setText("");
				textFieldNachname.setText("");
				textFieldStrasse.setText("");
				textFieldPlz.setText("");
				textFieldOrt.setText("");
				textFieldTele.setText("");
				comboBoxLand.setSelectedIndex(0);
				Main.clearViewTwoData();
				
			}
		});
		btnLoschen.setFont(new Font("Arial", Font.PLAIN, 14));
		btnLoschen.setBounds(10, 342, 89, 23);
		panelMain.add(btnLoschen);
		
		JButton btnWeiter = new JButton("Weiter");
		btnWeiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setViewTwoData(
						textFieldVorname.getText(),
						textFieldNachname.getText(),
						textFieldStrasse.getText(),
						textFieldPlz.getText(),
						textFieldOrt.getText(),
						comboBoxLand.getSelectedItem().toString(),
						textFieldTele.getText()
						);
				Main.view2.setVisible(false);
				new View3().setVisible(true);
			}
		});
		btnWeiter.setFont(new Font("Arial", Font.PLAIN, 14));
		btnWeiter.setBounds(241, 342, 89, 23);
		panelMain.add(btnWeiter);
		
		JButton btnZuruck = new JButton("Zuruck");
		btnZuruck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.view2.setVisible(false);
				Main.view1.setVisible(true);
			}
		});
		btnZuruck.setFont(new Font("Arial", Font.PLAIN, 14));
		btnZuruck.setBounds(130, 342, 89, 23);
		panelMain.add(btnZuruck);
	}
}
