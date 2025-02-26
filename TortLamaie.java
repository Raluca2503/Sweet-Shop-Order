package J2025_M08;

public class TortLamaie extends Tort {
	public TortLamaie() {
		super("Tort cu lamaie",85); //apelare constructor de baza din clasa abstracta
		//adaugare ingrediente specifice tipului de tort
		addingrediente("faina");
		addingrediente("zahar margaritar");
		addingrediente("oua");
		addingrediente("lamaie");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String descriere() {
		return super.descriere();
		
	}
}
