package J2025_M08;

public class TortTiramisu extends Tort {
	public TortTiramisu() {
		super("Tort tiramisu",120); //apelare constructor de baza din clasa abstracta
		//adaugare ingrediente specifice tipului de tort
		addingrediente("zahar pudra");
		addingrediente("mascarpone");
		addingrediente("oua");
		addingrediente("cafea");
		addingrediente("piscoturi");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String descriere() {
		return super.descriere();
		
	}
}
