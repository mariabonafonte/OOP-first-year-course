package personal;

public class Pdi extends Persona {
	private AreaConocimiento area;
	private CategoriaPDI categoria;

	public Pdi(String nombreApellidos, String dNI, int edad) {
		super(nombreApellidos, dNI, edad);
		area = AreaConocimiento.LSI;
		categoria = CategoriaPDI.AYD;
	}

	public Pdi(String nombreApellidos, String dNI, int edad, AreaConocimiento area, CategoriaPDI categoria) {
		super(nombreApellidos, dNI, edad);
		this.area = area;
		this.categoria = categoria;
	}

	public AreaConocimiento getArea() {
		return area;
	}

	public void setArea(AreaConocimiento area) {
		this.area = area;
	}

	public CategoriaPDI getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaPDI categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "[" + area + ", " + categoria + ", " + getNombreApellidos()
				+ ", " + getDNI() + ", " + getEdad() + "]";
	}
	
	public void promocionar () {
		CategoriaPDI actual = getCategoria();
		if(actual == CategoriaPDI.AYD) {
			setCategoria(CategoriaPDI.CTD);
		} else if (actual == CategoriaPDI.CTD) {
			setCategoria(CategoriaPDI.TU);
		} else if (actual == CategoriaPDI.TU) {
			setCategoria(CategoriaPDI.CU);
		}else {
			throw new ExcepcionesPersona("No puede promocionar mas");
		}
	}
	
	private AreaConocimiento string2area (String area) {
		try {
			return AreaConocimiento.valueOf(area.toUpperCase());
			} catch (IllegalArgumentException e) {
				throw new ExcepcionesPersona("Área de conocimiento no válida");
		    }
		}
	
	private CategoriaPDI string2cat (String cat) {
		try {
			return CategoriaPDI.valueOf(cat.toUpperCase());
			} catch (IllegalArgumentException e) {
				throw new ExcepcionesPersona("Categoría no válida");
		    }
		}
	
	public Pdi toPDI(String codificacion) {
	    String[] partes = codificacion.split(";");
	    Pdi nuevoPdi;

	    try {
	        if (partes.length == 5) {
	            String nombre = partes[0];
	            String dni = partes[1];
	            int edad = Integer.parseInt(partes[2]);
	            AreaConocimiento area = string2area(partes[3]);
	            CategoriaPDI categoria = string2cat(partes[4]);
	            nuevoPdi = new Pdi(nombre, dni, edad, area, categoria);

	        } else if (partes.length == 3) {
	            String nombre = partes[0];
	            String dni = partes[1];
	            int edad = Integer.parseInt(partes[2]);
	            nuevoPdi = new Pdi(nombre, dni, edad);
	        } else {
	            throw new ExcepcionesPersona("Formato incorrecto. Se esperaban 3 o 5 campos.");
	        }

	    } catch (Exception e) {
	        throw new ExcepcionesPersona("Error al crear el pDI ");
	    }

	    return nuevoPdi;
	}
	
	
	
	
	

}
