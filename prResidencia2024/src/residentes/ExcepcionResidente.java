package residentes;

public class ExcepcionResidente extends RuntimeException{

	public ExcepcionResidente() {
		super();
	}
	
	public ExcepcionResidente(String m) {
		super(m);
	}

}
