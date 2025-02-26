package J2025_M08;

public class TortVanilie extends Tort{

	public TortVanilie() {
		super("Tort cu vanilie",100); //apelare constructor de baza din clasa abstracta
		//adaugare ingrediente specifice tipului de tort
		addingrediente("faina");
		addingrediente("zahar fin");
		addingrediente("oua");
		addingrediente("pastaie de vanilie");
		addingrediente("frisca");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String descriere() {
		return super.descriere();
		
	}

}
