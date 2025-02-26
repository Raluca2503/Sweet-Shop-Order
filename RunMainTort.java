package J2025_M08;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

public class RunMainTort {
	public static void main(String[] args) throws CloneNotSupportedException {
		
	//creem obiecte de tip tort cu ajutorul constructorilor din clasele ce mostenesc clasa abstracta
	Tort tvanilie=new TortVanilie();
	Tort tcioco=new TortCiocolata();
	Tort tcps=new TortCapsuni();
	Tort tlamaie=new TortLamaie();
	Tort ttiramisu=new TortTiramisu();
	Tort tor=new TortOreo();
	
	//lista in care punem obiectele de baza de orice tip
	List<Tort>originale=new ArrayList<>();
	originale.add(tvanilie);
	originale.add(tcioco);
	originale.add(tcps);
	originale.add(tlamaie);
	originale.add(ttiramisu);
	originale.add(tor);
	
	//"pornirea" interfetei in aceasta clasa
	EventQueue.invokeLater(() -> { //editare pt Run Configurations pt a specifica faptul ca aici este main ul pt interfata
        try {
            InterfataJ frame = new InterfataJ(originale);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    });
}
}
