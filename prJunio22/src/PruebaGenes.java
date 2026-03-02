import genes.ADN;
import genes.AnalizadorGenes;
import genes.RequisitoSemejanza;
import genes.RequisitoNucleotidos;
import genes.TipoADN;

import java.io.PrintWriter;
import java.util.List;

public class PruebaGenes {

	public static void main(String[] args) {
		try{
			AnalizadorGenes ag = new AnalizadorGenes();
			ag.incluyeGenes("datos.txt", "[;]+");
			ag.escribeGenes("fichSalida.txt");
			ag.escribeGenes(new PrintWriter(System.out, true));
			ADN secuenciaReferencia = new ADN ("AT??ggctT",TipoADN.ANIMAL);
			List<ADN> resContiene = ag.buscar(new RequisitoSemejanza(secuenciaReferencia,66.0,100));
			System.out.println("Las muestras con ms del 66% de semejanza con " + secuenciaReferencia + " son " + resContiene);
			int numNucleotidos = 10;
			List<ADN> resNucleotidos = ag.buscar(new RequisitoNucleotidos(numNucleotidos));
			System.out.println("Las muestras con al menos " + numNucleotidos + " nucle�tidos son " + resNucleotidos);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
/*
1997:
	AGTCAAGGTTCC(A)
	AAAGGGTGCTA(D)
1998:
	GTAC??ABCTT(A)
	ATT-<-GCZZZ(D)
	ATTAGGCTA(D)
2000:
	TTTGGGAACTA(V)
Las muestras con m�s del 66% de semejanza con AT??GGCTT(A) son [ATTAGGCTA(D)]
Las muestras con al menos 10 nucle�tidos son [AGTCAAGGTTCC(A), AAAGGGTGCTA(D), TTTGGGAACTA(V)]
*/
