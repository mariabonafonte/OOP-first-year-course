package residentes;

public class DNI {
	private static final char[] LETTERS = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
			'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
	// https://www.interior.gob.es/opencms/es/servicios-al-ciudadano/tramites-y-gestiones/dni/calculo-del-digito-de-control-del-nif-nie/

	public static boolean esValido(String dni) {
		boolean res = false;
		if (dni != null && dni.length() == 9) {

			String numerosString = dni.substring(0, 8);

			try {
				// Comprobamos que sea una letra.
				char letra = dni.charAt(8);
				// Para comprobar, si no explota, son números.
				int numeros = Integer.parseInt(numerosString);
				char letraNumeros = LETTERS[numeros % 23];
				res = letraNumeros == letra;

			} catch (NumberFormatException e) {
				throw new ExcepcionResidente("DNI inválido " + dni);

			}
		}
		return res;
	}

}
