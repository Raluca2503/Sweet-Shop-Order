package J2025_M08;

import java.util.ArrayList;
import java.util.List;

abstract class Tort implements Cloneable {
	private String nume;
	private List<String> ingrediente;
	private double pret;

    public Tort(String nume, double pret) {//constructor pt asignarea numelui retetei si initializarea listei cu ingrediente
        this.nume = nume;
        this.ingrediente=new ArrayList<>();
        this.pret=pret;
    }

    public String getNume() { //fct pt preluarea numelui retetei
        return nume;
    }

    public List<String> getingrediente() {
        return ingrediente;
    }

    public void addingrediente(String ingredient) { //fct pt adaugarea unui ingredient in lista
        ingrediente.add(ingredient);
    }
    public double getPret() {
    	return pret;
    }

    // Fct clone() pt Prototype Pattern(specifica)
    @Override
    public Tort clone()throws CloneNotSupportedException {

        	Tort tortClona=(Tort) super.clone();
        	tortClona.ingrediente=new ArrayList<>(this.ingrediente);
        	return tortClona;
    }
    
    public String descriere() { //suprascrisa pt a returna numele tortului+ingrediente, usor de folosit pt Interfata
        return nume+"\ningrediente: "+ingrediente+"\npret: "+pret+" RON"+"\n";
    }
	

}
