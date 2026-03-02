package residentes;

public class ExcepcionResidente extends RuntimeException{

	public ExcepcionResidente() {
		super();
	}
	public ExcepcionResidente(String message) {
		super(message);
	}

}
