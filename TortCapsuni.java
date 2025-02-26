package J2025_M08;

public class TortCapsuni extends Tort {
	public TortCapsuni() {
		super("Tort cu capsuni",60); //apelare constructor de baza din clasa abstracta
		//adaugare ingrediente specifice tipului de tort
		addingrediente("faina"); 
		addingrediente("zahar pudra");
		addingrediente("oua");
		addingrediente("vanilie");
		addingrediente("capsuni");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String descriere() {
		return super.descriere();
		
	}

}
