import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class View3 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View3 frame = new View3();
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
	public View3() {
		setTitle("Auto Konfigurator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelMain = new JPanel();
		panelMain.setLayout(null);
		contentPane.add(panelMain, BorderLayout.CENTER);
		
		JLabel lblPerson = new JLabel("Personliche Informationen");
		lblPerson.setFont(new Font("Arial", Font.BOLD, 14));
		lblPerson.setBounds(10, 11, 200, 25);
		panelMain.add(lblPerson);
		
		JLabel lblTitle = new JLabel("lhre Konfiguration:");
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTitle.setBounds(20, 47, 310, 25);
		panelMain.add(lblTitle);
		
		JButton btnLoschen = new JButton("L\u00F6schen");
		btnLoschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.clearViewOneData();
				Main.clearViewTwoData();
				Main.view1=new View1();
				Main.view2=new View2();
				Main.view1.setVisible(true);
				setVisible(false);
			}
		});
		btnLoschen.setFont(new Font("Arial", Font.PLAIN, 14));
		btnLoschen.setBounds(10, 342, 89, 23);
		panelMain.add(btnLoschen);
		
		JButton btnAbsenden = new JButton("Absenden");
		btnAbsenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File dir = null;
				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int resp = fc.showOpenDialog(null);
				if (resp == JFileChooser.APPROVE_OPTION) {
				    dir = fc.getSelectedFile();
				    File file = new File(dir, "Data-File.txt");
				    FileWriter fw = null;
				    try {
				        fw = new FileWriter(file);
				        fw.write(Main.getAutoData());
				        fw.flush();
				        JOptionPane.showMessageDialog(null, "Data Successfully saved to Data-File.txt at\n"+dir.getAbsolutePath());
				        
				        Main.clearViewOneData();
						Main.clearViewTwoData();
						Main.view1=new View1();
						Main.view2=new View2();
						Main.view1.setVisible(true);
						setVisible(false);
						
				    } catch (IOException ex) {
				        ex.printStackTrace();
				    } finally {
				        if(fw != null) {
				            try {
				                fw.close();
				            } catch (IOException ex) {
				            }
				        }
				    }
				}
			}
		});
		btnAbsenden.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAbsenden.setBounds(241, 342, 97, 23);
		panelMain.add(btnAbsenden);
		
		JButton btnZuruck = new JButton("Zuruck");
		btnZuruck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Main.view2.setVisible(true);
			}
		});
		btnZuruck.setFont(new Font("Arial", Font.PLAIN, 14));
		btnZuruck.setBounds(130, 342, 89, 23);
		panelMain.add(btnZuruck);
		
		JScrollPane scrollPaneKonfiguration = new JScrollPane();
		scrollPaneKonfiguration.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneKonfiguration.setBounds(20, 83, 225, 248);
		panelMain.add(scrollPaneKonfiguration);
		
		JList listKonfiguration = new JList();
		listKonfiguration.setVisibleRowCount(12);
		listKonfiguration.setListData(Main.getListData());
		scrollPaneKonfiguration.setViewportView(listKonfiguration);
	}
}
