package genes;

public class AnalizadorGenesCorruptos extends AnalizadorGenes {

	public AnalizadorGenesCorruptos() {
		super();
	}

	@Override
	public void incluye(int year, String nucleotidos, TipoADN tipo) {
		ADNcorrupto adn = new ADNcorrupto(nucleotidos, tipo);
		incluye(year, adn);
	}
	
	

}
