package J2025_M08;

public class TortCiocolata extends Tort {
	public TortCiocolata() {
		super("Tort cu ciocolata",80); //apelare constructor de baza din clasa abstracta
		//adaugare ingrediente specifice tipului de tort
		addingrediente("faina");
		addingrediente("zahar brun");
		addingrediente("oua");
		addingrediente("ciocolata");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String descriere() {
		return super.descriere();
		
	}


}
