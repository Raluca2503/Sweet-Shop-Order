package J2025_M08;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class InterfataJ extends JFrame {
	private List<Tort> originale;

	//clasa pentru creare unor Panel care au drept background o imagine de tip jpeg
	 private static class BackgroundPanel extends JPanel {
	        private BufferedImage backgroundImage;
	        //constructor pentru creare utilizand adresa imaginii
	        public BackgroundPanel(String imagePath) {
	            try {
	                File file = new File(imagePath);
	              //  System.out.println("Incercare incarcare imag " + file.getAbsolutePath());
	                if (!file.exists()) { 
	                //    System.out.println("Eroare: NU EXISTA!");
	                } else {
	                    backgroundImage = ImageIO.read(file);
	                  //  System.out.println("Imagine incarcata cu succes");
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }

	        @Override
	        protected void paintComponent(Graphics g) { //metoda apelata automat de Java pt a "picta" fundalul unui JPanel
	            super.paintComponent(g); //metoda din clasa de baza
	            if (backgroundImage != null) { //daca este gasita imaginea
	                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	            }
	        }
	    }
	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public InterfataJ(List<Tort> originale) { //interfata primeste drept parametru o lista cu obiecte de tip Tort
		setTitle("Prototype Pattern");
		this.originale=originale; //se transmit obiectele de baza din main prin intermediul listei primite ca parametru
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//panel creat folosind clasa personalizata de mai sus
		JPanel panelComanda = new BackgroundPanel("src/J2025_M08/fundal.jpeg");
		panelComanda.setBorder(new TitledBorder(null, "Comanda", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelComanda.setBounds(410, 10, 369, 458);
		contentPane.add(panelComanda);
		
		JTextArea detaliiComanda = new JTextArea();
        detaliiComanda.setBounds(10, 26, 329, 422);
        panelComanda.add(detaliiComanda);
        //editarea JTextArea astfel incat fundalul si marginile sa fie transparente
        detaliiComanda.setOpaque(false);
        detaliiComanda.setBorder(null);
        detaliiComanda.setEditable(false);
        detaliiComanda.setLineWrap(true);
        
		
        //panel creat folosind clasa personalizata de mai sus
		JPanel panelTorturi = new BackgroundPanel("src/J2025_M08/raft.jpeg");
		panelTorturi.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Cofetarie", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 250, 250)));
		panelTorturi.setBounds(10, 10, 367, 458);
		contentPane.add(panelTorturi);
		panelTorturi.setLayout(null);
	
		//creare buton 
		JButton btnVanilie=new JButton();
		btnVanilie.setBounds(216, 194, 108, 97);
		//personalizarea butonului
		//creem o variablia care primeste imaginea pe care o dorim
		ImageIcon icon = new ImageIcon("src/J2025_M08/vanilie.png");
		//imaginea este redimensionata pentru a se incadra limitelor dorite, SCALE_SMOOTH ajuta la producerea unei imagini mai clare
		Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		//butonul va afisa imaginea in locul textului implicit
        btnVanilie.setIcon(new ImageIcon(scaledImage));
        //nu mai apare un chenar atunci cand suntem cu mouseu-ul pe buton
        btnVanilie.setFocusPainted(false);
        //nu mai apare bordura butonului
        btnVanilie.setBorderPainted(false);
        //face ca fundalul butonului sa fie transparent
        btnVanilie.setContentAreaFilled(false);
        
        btnVanilie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tort tvanilie=originale.get(0); //preiau tortul deja existent
				try {
					Tort tclona=tvanilie.clone(); //creem un obiect nou prin clonarea unuia deja existent
					//in textArea se adauga descrierea componentelor obiectului clonat
					detaliiComanda.setText(detaliiComanda.getText()+"\nClona tort Vanilie:\n"+tclona.descriere()+"\n");
				}
				catch (CloneNotSupportedException ex) {
			        ex.printStackTrace();
				}	
			}
		});
        
        JButton btnCiocolata=new JButton();
        btnCiocolata.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Tort tcioco=originale.get(1); //preiau tortul deja existent
				try {
					Tort tclona=tcioco.clone(); //creem un obiect nou prin clonarea unuia deja existent
					//in textArea se adauga descrierea componentelor obiectului clonat
					detaliiComanda.setText(detaliiComanda.getText()+"\nClona tort Ciocolata:\n"+tclona.descriere()+"\n");
				}
				catch (CloneNotSupportedException ex) {
			        ex.printStackTrace();
				}	
        	}
        });
        
		btnCiocolata.setBounds(216, 60, 108, 97);
		//personalizarea butonului
		//creem o variablia care primeste imaginea pe care o dorim
		ImageIcon icon1 = new ImageIcon("src/J2025_M08/ciocolata.png");
		//imaginea este redimensionata pentru a se incadra limitelor dorite, SCALE_SMOOTH ajuta la producerea unei imagini mai clare
		Image scaledImage1 = icon1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		//butonul va afisa imaginea in locul textului implicit
        btnCiocolata.setIcon(new ImageIcon(scaledImage1));
        //editam butonul astfel incat sa nu mai aiba bordura si fundal
        btnCiocolata.setFocusPainted(false);
        btnCiocolata.setBorderPainted(false);
        btnCiocolata.setFocusPainted(false);
        btnCiocolata.setContentAreaFilled(false);
        
        
        JButton btnCapsuni=new JButton();
        btnCapsuni.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Tort tcapsuni=originale.get(2); //preiau tortul deja exsitent
				try {
					Tort tclona=tcapsuni.clone(); //creem un obiect nou prin clonarea unuia deja existent
					//in textArea se adauga descrierea componentelor obiectului clonat
					detaliiComanda.setText(detaliiComanda.getText()+"\nClona tort Capsuni:\n"+tclona.descriere()+"\n");
				}
				catch (CloneNotSupportedException ex) {
			        ex.printStackTrace();
				}	
        	}
        });
		
        btnCapsuni.setBounds(58, 60, 108, 97);
		//personalizarea butonului
		//creem o variablia care primeste imaginea pe care o dorim
		ImageIcon icon2 = new ImageIcon("src/J2025_M08/capsuni.png");
		//imaginea este redimensionata pentru a se incadra limitelor dorite, SCALE_SMOOTH ajuta la producerea unei imagini mai clare
		Image scaledImage2 = icon2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		//butonul va afisa imaginea in locul textului implicit
		btnCapsuni.setIcon(new ImageIcon(scaledImage2));
		 //editam butonul astfel incat sa nu mai aiba bordura si fundal
        btnCapsuni.setBorderPainted(false);
        btnCapsuni.setFocusPainted(false);
        btnCapsuni.setContentAreaFilled(false);
        
        JButton btnLamaie=new JButton();
        btnLamaie.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Tort tlamaie=originale.get(3); //preiau tortul deja exsitent
				try {
					Tort tclona=tlamaie.clone(); //creem un obiect nou prin clonarea unuia deja existent
					//in textArea se adauga descrierea componentelor obiectului clonat
					detaliiComanda.setText(detaliiComanda.getText()+"\nClona tort Lamaie:\n"+tclona.descriere()+"\n");
				}
				catch (CloneNotSupportedException ex) {
			        ex.printStackTrace();
				}	
        	}
        });
        
		btnLamaie.setBounds(235, 351, 108, 97);
		//personalizarea butonului
		//creem o variablia care primeste imaginea pe care o dorim
		ImageIcon icon3 = new ImageIcon("src/J2025_M08/lamaie.png");
		//imaginea este redimensionata pentru a se incadra limitelor dorite, SCALE_SMOOTH ajuta la producerea unei imagini mai clare
		Image scaledImage3 = icon3.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		//butonul va afisa imaginea in locul textului implicit
		btnLamaie.setIcon(new ImageIcon(scaledImage3));
		//editam butonul astfel incat sa nu mai aiba bordura si fundal
		btnLamaie.setFocusPainted(false);
        btnLamaie.setBorderPainted(false);
        btnLamaie.setFocusPainted(false);
        btnLamaie.setContentAreaFilled(false);
        
        JButton btnTiramisu=new JButton();
        btnTiramisu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Tort ttiramisu=originale.get(4); //preiau tortul deja exsitent
				try {
					Tort tclona=ttiramisu.clone(); //creem un obiect nou prin clonarea unuia deja existent
					//in textArea se adauga descrierea componentelor obiectului clonat
					detaliiComanda.setText(detaliiComanda.getText()+"\nClona tort Tiramisu:\n"+tclona.descriere()+"\n");
				}
				catch (CloneNotSupportedException ex) {
			        ex.printStackTrace();
				}	
        	}
        });
        
		btnTiramisu.setBounds(58, 351, 108, 97);
		//personalizarea butonului
		//creem o variablia care primeste imaginea pe care o dorim
		ImageIcon icon4 = new ImageIcon("src/J2025_M08/tiramisu.png");
		//imaginea este redimensionata pentru a se incadra limitelor dorite, SCALE_SMOOTH ajuta la producerea unei imagini mai clare
		Image scaledImage4 = icon4.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		//butonul va afisa imaginea in locul textului implicit
		btnTiramisu.setIcon(new ImageIcon(scaledImage4));
		//editam butonul astfel incat sa nu mai aiba bordura si fundal
		btnTiramisu.setFocusPainted(false);
        btnTiramisu.setBorderPainted(false);
        btnTiramisu.setFocusPainted(false);
        btnTiramisu.setContentAreaFilled(false);
        
        
        JButton btnOreo=new JButton();
        btnOreo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Tort tOreo=originale.get(5); //preiau tortul deja exsitent
				try {
					Tort tclona=tOreo.clone(); //creem un obiect nou prin clonarea unuia deja existent
					//in textArea se adauga descrierea componentelor obiectului clonat
					detaliiComanda.setText(detaliiComanda.getText()+"\nClona tort Oreo:\n"+tclona.descriere()+"\n");
				}
				catch (CloneNotSupportedException ex) {
			        ex.printStackTrace();
				}	
        	}
        });
        
		btnOreo.setBounds(34, 194, 108, 97);
		//personalizarea butonului
		//creem o variablia care primeste imaginea pe care o dorim
		ImageIcon icon5 = new ImageIcon("src/J2025_M08/oreo.png");
		//imaginea este redimensionata pentru a se incadra limitelor dorite, SCALE_SMOOTH ajuta la producerea unei imagini mai clare
		Image scaledImage5 = icon5.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		//butonul va afisa imaginea in locul textului implicit
		btnOreo.setIcon(new ImageIcon(scaledImage5));
		//editam butonul astfel incat sa nu mai aiba bordura si fundal
		btnOreo.setFocusPainted(false);
        btnOreo.setBorderPainted(false);
        btnOreo.setFocusPainted(false);
        btnOreo.setContentAreaFilled(false);
        
        //adaugam butoanele in panoul din stanga
        panelTorturi.add(btnVanilie);
        panelTorturi.add(btnCiocolata);
        panelTorturi.add(btnLamaie);
        panelTorturi.add(btnCapsuni);
        panelTorturi.add(btnTiramisu);
        panelTorturi.add(btnOreo);
        panelComanda.setLayout(null);
        
        //creem un obiect de tip scrollPane care va contine un obiect de tip JTextArea, detaliiComanda in cazul acesta
        JScrollPane scrollPane = new JScrollPane(detaliiComanda);
        //alegem ca bara de derulare verticala sa fie vizibila mereu
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        //alegem ca bara de derulare orizontala sa fie vizibila doar la nevoie
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
        scrollPane.setBounds(10, 26, 349, 422);  
        //eliminarea marginii pentru bara
        scrollPane.setBorder(null);
        //background transparent
        scrollPane.setOpaque(false);
        //zona de vizualizare a continutului este transparenta
        scrollPane.getViewport().setOpaque(false);
        //adaugam obiectul la pandoul din dreapta
        panelComanda.add(scrollPane);
        
        //buton pentru resetarea JTextArea
        JButton btnClear = new JButton("Comanda noua");
        btnClear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		detaliiComanda.setText(null); //la apasare este sters tot continutul din panoul din drepata
        	}
        });
        btnClear.setBounds(584, 477, 149, 21);
        //adaugam butonl pe frame
        contentPane.add(btnClear);
		
	}
}
