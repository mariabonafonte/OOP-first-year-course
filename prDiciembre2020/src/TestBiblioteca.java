import bibliotecas.Libro;
import bibliotecas.Biblioteca;
import bibliotecas.BibliotecaException;

public class TestBiblioteca {
	public static void main(String[] args) {
		try {
			Biblioteca b = new Biblioteca("libros.txt");
			// Inteligencia Artificial: un enfoque moderno%Stuart Russell,Peter Norvig%842054003X%2013%2
			System.out.println("Sobre el titulo: \"Inteligencia Artificial: un enfoque moderno\"");
			Libro p = b.getLibro("Inteligencia Artificial: un enfoque moderno", 2013);
			System.out.println(p);
			int copias = b.disponibles(p);
			System.out.println("Copias : " + copias == null ? 0 : copias);
			while (copias > 0) {
				b.prestar(p);
				copias = b.disponibles(p);
				System.out.println("Libro \"Inteligencia Artificial: un enfoque moderno\" prestado");
			}
			System.out.println("Libro \"Inteligencia Artificial: un enfoque moderno\" no disponible");
			System.out.println(b);
			b.devolver(p); // Se devuelve una copia
			System.out.println("Libro \"Inteligencia Artificial: un enfoque moderno\" devuelto");
			System.out.println(b);
			System.out.println("Libros de Andrew Tanenbaum:");
			for (Libro ppp : b.librosDeAutor("Andrew Tanenbaum")) 
				System.out.println(ppp);
			System.out.println(b.indiceDeAutores());
		} catch (BibliotecaException ee) {
			System.err.println(ee.getMessage());
		}
	}
}

/*
 * SALIDA:

Sobre el titulo: "Inteligencia Artificial: un enfoque moderno"
[Inteligencia Artificial: un enfoque moderno, [Stuart Russell, Peter Norvig], 842054003X, 2013]
2
Libro "Inteligencia Artificial: un enfoque moderno" prestado
Libro "Inteligencia Artificial: un enfoque moderno" prestado
Libro "Inteligencia Artificial: un enfoque moderno" no disponible
Libros:
[Computer Networks, [Andrew Tanenbaum, David Wetherall], 0132126958, 2010]
	 Disponibles: 2 Prestados: 2
[Computer Organization and Design: the Hardware/Software interface, [David Patterson, John Hennessy], 0123747503, 2011]
	 Disponibles: 3 Prestados: 3
[Cómo programar en C, [Paul Deitel, Harvey Deitel], 9688804711, 1995]
	 Disponibles: 3 Prestados: 3
[Discrete Mathematics and its Applications, [Kenneth Rosen], 0072899050, 1998]
	 Disponibles: 2 Prestados: 2
[Fundamentals of Database Systems, [Ramez Elmasri, Shamkant Navathe], 1292097612, 2016]
	 Disponibles: 4 Prestados: 4
[Inteligencia Artificial: un enfoque moderno, [Stuart Russell, Peter Norvig], 842054003X, 2013]
	 Disponibles: 0 Prestados: 2
[Introduction to Algorithms, [Thomas Corment, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein], 9780262033848, 2009]
	 Disponibles: 3 Prestados: 3
[Modern Operating Systems, [Andrew Tanenbaum, Herbert Bos], 013359162X, 2014]
	 Disponibles: 1 Prestados: 1
[Operating System Concepts, [Abraham Silverschatz], 0470128720, 2008]
	 Disponibles: 3 Prestados: 3
[Starting Out With C++ : From Control Structures Through Objects, [Tony Gaddis], 9780134498379, 2017]
	 Disponibles: 2 Prestados: 2
Libro "Inteligencia Artificial: un enfoque moderno" devuelto
Libros:
[Computer Networks, [Andrew Tanenbaum, David Wetherall], 0132126958, 2010]
	 Disponibles: 2 Prestados: 2
[Computer Organization and Design: the Hardware/Software interface, [David Patterson, John Hennessy], 0123747503, 2011]
	 Disponibles: 3 Prestados: 3
[Cómo programar en C, [Paul Deitel, Harvey Deitel], 9688804711, 1995]
	 Disponibles: 3 Prestados: 3
[Discrete Mathematics and its Applications, [Kenneth Rosen], 0072899050, 1998]
	 Disponibles: 2 Prestados: 2
[Fundamentals of Database Systems, [Ramez Elmasri, Shamkant Navathe], 1292097612, 2016]
	 Disponibles: 4 Prestados: 4
[Inteligencia Artificial: un enfoque moderno, [Stuart Russell, Peter Norvig], 842054003X, 2013]
	 Disponibles: 1 Prestados: 1
[Introduction to Algorithms, [Thomas Corment, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein], 9780262033848, 2009]
	 Disponibles: 3 Prestados: 3
[Modern Operating Systems, [Andrew Tanenbaum, Herbert Bos], 013359162X, 2014]
	 Disponibles: 1 Prestados: 1
[Operating System Concepts, [Abraham Silverschatz], 0470128720, 2008]
	 Disponibles: 3 Prestados: 3
[Starting Out With C++ : From Control Structures Through Objects, [Tony Gaddis], 9780134498379, 2017]
	 Disponibles: 2 Prestados: 2
Libros de Andrew Tanenbaum:
[Computer Networks, [Andrew Tanenbaum, David Wetherall], 0132126958, 2010]
[Modern Operating Systems, [Andrew Tanenbaum, Herbert Bos], 013359162X, 2014]
{Abraham Silverschatz=[[Operating System Concepts, [Abraham Silverschatz], 0470128720, 2008]], Andrew Tanenbaum=[[Modern Operating Systems, [Andrew Tanenbaum, Herbert Bos], 013359162X, 2014], [Computer Networks, [Andrew Tanenbaum, David Wetherall], 0132126958, 2010]], Charles E. Leiserson=[[Introduction to Algorithms, [Thomas Corment, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein], 9780262033848, 2009]], Clifford Stein=[[Introduction to Algorithms, [Thomas Corment, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein], 9780262033848, 2009]], David Patterson=[[Computer Organization and Design: the Hardware/Software interface, [David Patterson, John Hennessy], 0123747503, 2011]], David Wetherall=[[Computer Networks, [Andrew Tanenbaum, David Wetherall], 0132126958, 2010]], Harvey Deitel=[[Cómo programar en C, [Paul Deitel, Harvey Deitel], 9688804711, 1995]], Herbert Bos=[[Modern Operating Systems, [Andrew Tanenbaum, Herbert Bos], 013359162X, 2014]], John Hennessy=[[Computer Organization and Design: the Hardware/Software interface, [David Patterson, John Hennessy], 0123747503, 2011]], Kenneth Rosen=[[Discrete Mathematics and its Applications, [Kenneth Rosen], 0072899050, 1998]], Paul Deitel=[[Cómo programar en C, [Paul Deitel, Harvey Deitel], 9688804711, 1995]], Peter Norvig=[[Inteligencia Artificial: un enfoque moderno, [Stuart Russell, Peter Norvig], 842054003X, 2013]], Ramez Elmasri=[[Fundamentals of Database Systems, [Ramez Elmasri, Shamkant Navathe], 1292097612, 2016]], Ronald L. Rivest=[[Introduction to Algorithms, [Thomas Corment, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein], 9780262033848, 2009]], Shamkant Navathe=[[Fundamentals of Database Systems, [Ramez Elmasri, Shamkant Navathe], 1292097612, 2016]], Stuart Russell=[[Inteligencia Artificial: un enfoque moderno, [Stuart Russell, Peter Norvig], 842054003X, 2013]], Thomas Corment=[[Introduction to Algorithms, [Thomas Corment, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein], 9780262033848, 2009]], Tony Gaddis=[[Starting Out With C++ : From Control Structures Through Objects, [Tony Gaddis], 9780134498379, 2017]]}

 */