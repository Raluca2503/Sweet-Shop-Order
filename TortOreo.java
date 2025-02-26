package J2025_M08;

public class TortOreo extends Tort {
	public TortOreo() {
		super("Tort cu oreo",95); //apelare constructor de baza din clasa abstracta
		//adaugare ingrediente specifice tipului de tort
		addingrediente("faina");
		addingrediente("zahar brun");
		addingrediente("oua");
		addingrediente("oreo");
		addingrediente("cacao");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String descriere() {
		return super.descriere();
		
	}
}
