package residentes;

public class DNI {
	private static final char[] LETTERS = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B',
			'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };

	public static boolean esValido(String dni) {
		boolean res= false;
		if(dni.length()==9) {
			int num;
			try {
				num=Integer.parseInt(dni.substring(0,8));
			} catch (NumberFormatException e) {
				throw new ExcepcionResidente("Deben ser 8 números y una letra");
			}
			char letra = dni.charAt(8);
			
			if(letra==LETTERS[num%23]) {
				res = true;
			}
		}else {
			throw new ExcepcionResidente("Longitud de dni inválida");
		}
		
		return res;
		
	}

}
