import jarras.Jarra;

public class EjemploUsoJarras1 {

	public static void main(String[]args) {
		Jarra j1=new Jarra(7);
		Jarra j2=new Jarra(4);
		
		//System.out.println(jarraA+" , "+jarraB); //J(7,0) , J(4,0)
		
		j1.llena();
		System.out.println(j1+" , "+j2); //J(7,7) , J(4,0)
		
		j2.llenaDesde(j1);
		System.out.println(j1+" , "+j2); //J(7,3) , J(4,4)
		
		j2.vacia();
		System.out.println(j1+" , "+j2);//J(7,3) , J(4,0)
		
		j2.llenaDesde(j1);
		System.out.println(j1+" , "+j2);//J(7,0) , J(4,3)
	}

}
