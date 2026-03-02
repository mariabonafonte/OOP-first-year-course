import genes.ADN;
import genes.ADNcorrupto;
import genes.AnalizadorGenes;
import genes.AnalizadorGenesCorruptos;
import genes.RequisitoSemejanza;
import genes.RequisitoNucleotidos;
import genes.TipoADN;

import java.io.PrintWriter;
import java.util.List;

public class PruebaGenesCorruptos {

	public static void main(String[] args) {
		try{
			AnalizadorGenes ag = new AnalizadorGenesCorruptos();
			ag.incluyeGenes("datos.txt", "[;]+");
			ag.escribeGenes("fichSalida.txt");
			ag.escribeGenes(new PrintWriter(System.out, true));
			ADN secuenciaReferencia = new ADN ("AT??ggctT",TipoADN.ANIMAL);
			List<ADN> resContiene = ag.buscar(new RequisitoSemejanza(secuenciaReferencia,66.0,100));
			System.out.println("Las muestras con más del 66% de semejanza con " + secuenciaReferencia + " son " + resContiene);
			int numNucleotidos = 10;
			List<ADN> resNucleotidos = ag.buscar(new RequisitoNucleotidos(numNucleotidos));
			System.out.println("Las muestras con al menos " + numNucleotidos + " nucleótidos son " + resNucleotidos);
			ADNcorrupto muestraADN = new ADNcorrupto("AT??ggctT",TipoADN.DESCONOCIDO);
			System.out.println("Número de elementos válidos de " + muestraADN.getSecuencia()
								+ ":" + muestraADN.numeroNucleotidos());
			System.out.println("Número de elementos incorrectos de " 
								+ muestraADN.getSecuencia() + ":" + muestraADN.numNucleotidosDesconocidos());
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
	GTAC--A-CTT(A)
	ATT---GC---(D)
	ATTAGGCTA(D)
2000:
	TTTGGGAACTA(V)
Las muestras con más del 66% de semejanza con AT??GGCTT(A) son [ATTAGGCTA(D)]
Las muestras con al menos 10 nucleótidos son [AGTCAAGGTTCC(A), AAAGGGTGCTA(D), TTTGGGAACTA(V)]
Número de elementos válidos de AT--GGCTT:7
Número de elementos incorrectos de AT--GGCTT:2
*/
