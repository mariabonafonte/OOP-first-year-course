package residentes;

public class DNI {
	private static final char[] LETTERS = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B',
			'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };

	public static boolean esValido(String dni){
		boolean res = false;
		if(dni.length()==9) {
			int numeros = Integer.parseInt(dni.substring(0,8));
			char letra = dni.charAt(dni.length()-1);
			if(LETTERS[numeros%23]==letra) {
				res=true;
			}
		}
		return res;
	}

}
