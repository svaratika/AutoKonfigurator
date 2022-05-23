import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View1 extends JFrame {

	private JPanel contentPane;
	View2 view2=new View2();
	View3 view3=new View3();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View1 frame = new View1();
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
	public View1() {
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
		
		JLabel lblTitle = new JLabel("Auto Zusammensellung");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 14));
		lblTitle.setBounds(10, 11, 200, 25);
		panelMain.add(lblTitle);
		
		JLabel lblModell = new JLabel("Modell    :");
		lblModell.setHorizontalAlignment(SwingConstants.LEFT);
		lblModell.setFont(new Font("Arial", Font.PLAIN, 14));
		lblModell.setBounds(20, 47, 100, 25);
		panelMain.add(lblModell);
		
		JComboBox comboBoxModell = new JComboBox();
		comboBoxModell.setModel(new DefaultComboBoxModel(new String[] {"A-Klasse", "B-Klasse", "C-Klasse", "Citan", "CLA", "CLS", "E-Klasse", "EQA"}));
		comboBoxModell.setSelectedIndex(0);
		comboBoxModell.setBounds(130, 47, 200, 25);
		panelMain.add(comboBoxModell);
		
		JComboBox comboBoxAntrieb = new JComboBox();
		comboBoxAntrieb.setModel(new DefaultComboBoxModel(new String[] {"Vorderradantrieb", "Hinterradantrieb", "Allrad"}));
		comboBoxAntrieb.setSelectedIndex(0);
		comboBoxAntrieb.setBounds(130, 83, 200, 25);
		panelMain.add(comboBoxAntrieb);
		
		JLabel lblAntrieb = new JLabel("Antrieb   :");
		lblAntrieb.setHorizontalAlignment(SwingConstants.LEFT);
		lblAntrieb.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAntrieb.setBounds(20, 83, 100, 25);
		panelMain.add(lblAntrieb);
		
		JComboBox comboBoxMotor = new JComboBox();
		comboBoxMotor.setModel(new DefaultComboBoxModel(new String[] {"Dreizylinder", "Vierzylinder", "Sechszylinder", "Achtzylinder", "V6", "V8", "V12"}));
		comboBoxMotor.setSelectedIndex(0);
		comboBoxMotor.setBounds(130, 119, 200, 25);
		panelMain.add(comboBoxMotor);
		
		JLabel lblMotor = new JLabel("Motor     :");
		lblMotor.setHorizontalAlignment(SwingConstants.LEFT);
		lblMotor.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMotor.setBounds(20, 119, 100, 25);
		panelMain.add(lblMotor);
		
		JComboBox comboBoxSitze = new JComboBox();
		comboBoxSitze.setModel(new DefaultComboBoxModel(new String[] {"2", "5", "7"}));
		comboBoxSitze.setSelectedIndex(0);
		comboBoxSitze.setBounds(130, 155, 200, 25);
		panelMain.add(comboBoxSitze);
		
		JLabel lblSitze = new JLabel("Sitze      : ");
		lblSitze.setHorizontalAlignment(SwingConstants.LEFT);
		lblSitze.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSitze.setBounds(20, 155, 100, 25);
		panelMain.add(lblSitze);
		
		JComboBox comboBoxFarbe = new JComboBox();
		comboBoxFarbe.setModel(new DefaultComboBoxModel(new String[] {"Weiss", "Black", "Red", "Orange", "Green", "Blue"}));
		comboBoxFarbe.setBounds(130, 191, 200, 25);
		panelMain.add(comboBoxFarbe);
		
		JLabel lblFarbe = new JLabel("Farbe    :");
		lblFarbe.setHorizontalAlignment(SwingConstants.LEFT);
		lblFarbe.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFarbe.setBounds(20, 191, 100, 25);
		panelMain.add(lblFarbe);
		
		JLabel lblGrosse = new JLabel("Gr\u00F6sse  :");
		lblGrosse.setHorizontalAlignment(SwingConstants.LEFT);
		lblGrosse.setFont(new Font("Arial", Font.PLAIN, 14));
		lblGrosse.setBounds(20, 227, 100, 25);
		panelMain.add(lblGrosse);
		
		JSlider sliderGrosse = new JSlider();
		sliderGrosse.setMinorTickSpacing(1);
		sliderGrosse.setMajorTickSpacing(1);
		sliderGrosse.setPaintTicks(true);
		sliderGrosse.setPaintLabels(true);
		sliderGrosse.setMinimum(1);
		sliderGrosse.setMaximum(15);
		sliderGrosse.setValue(0);
		sliderGrosse.setBounds(20, 265, 310, 35);
		panelMain.add(sliderGrosse);
		
		JButton btnLoschen = new JButton("L\u00F6schen");
		btnLoschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxAntrieb.setSelectedIndex(0);
				comboBoxFarbe.setSelectedIndex(0);
				comboBoxModell.setSelectedIndex(0);
				comboBoxSitze.setSelectedIndex(0);
				comboBoxMotor.setSelectedIndex(0);
				sliderGrosse.setValue(0);
				Main.clearViewOneData();
				JOptionPane.showMessageDialog(null, "Data Reset");
			}
			
		});
		btnLoschen.setFont(new Font("Arial", Font.PLAIN, 14));
		btnLoschen.setBounds(10, 342, 89, 23);
		panelMain.add(btnLoschen);
		
		JButton btnWeiter = new JButton("Weiter");
		btnWeiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setViewOneData(
						comboBoxModell.getSelectedItem().toString(),
						comboBoxAntrieb.getSelectedItem().toString(),
						comboBoxMotor.getSelectedItem().toString(),
						comboBoxSitze.getSelectedItem().toString(),
						comboBoxFarbe.getSelectedItem().toString(),
						sliderGrosse.getValue()
						);
				Main.view2.setVisible(true);
				Main.view1.setVisible(false);
				
			}
		});
		btnWeiter.setFont(new Font("Arial", Font.PLAIN, 14));
		btnWeiter.setBounds(241, 342, 89, 23);
		panelMain.add(btnWeiter);
		
		
	}

	
}
