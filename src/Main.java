import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main{
	
	static String modell;
	static String motor;
	static String antrib;
	static String sitze;
	static String farbe;
	static String grosse;
	
	static String vorname;
	static String nachname;
	static String strasse;
	static String plz;
	static String ort;
	static String land;
	static String tele;
	
	static View1 view1=new View1();
	static View2 view2=new View2();
	static View3 view3=new View3();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	public static void clearViewOneData() {
		modell="";
		motor="";
		antrib="";
		sitze="";
		farbe="";
		grosse="";
	}
	
	public static void clearViewTwoData() {
		vorname="";
		nachname="";
		strasse="";
		plz="";
		ort="";
		tele="";
		land="";
	}



	public static void setViewOneData(String mod, String ant, String mot, String sit, String far,int gro) {
		modell=mod;
		motor=mot;
		antrib=ant;
		sitze=sit;
		farbe=far;
		grosse=gro+"";
		
	}



	public static void setViewTwoData(String var, String nac, String str, String plz, String ort,
			String lan, String tel) {
		vorname=var;
		nachname=nac;
		strasse=str;
		Main.plz=plz;
		Main.ort=ort;
		tele=tel;
		land=lan;
		
	}



	public static String[] getListData() {
		// TODO Auto-generated method stub
		String[] listData= {"Modell:","  "+modell,"Antrieb:","  "+antrib,"Motor:","  "+motor,"Sitze:","  "+sitze,"Farbe:","  "+farbe,"Grosse:","  "+grosse};
		return listData;
	}



	public static String getAutoData() {
		String data="- - - - - Auto Details - - - - -\nModell: "+modell+"\nAntrieb: "+antrib+"\nMotor: "+motor+"\nSitze: "+sitze+"\nFarbe: "+farbe+"\nGrosse: "+grosse
				+"\n\n- - - - - Cusotmer Details - - - - -\nVorname: "+vorname+"\nNachname: "+nachname+"\nStrasse und Hausnummer: "+strasse+"\nPLZ: "+plz
				+"\nOrt: "+ort+"\nLand: "+land+"\nTelefonnummer: "+tele+"\n";
		return data;
		
	}
	
	
	
	

}
