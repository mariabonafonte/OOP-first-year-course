package paciente;

public enum Especialidad {
	CARDIOLOGIA("Cardiología"),
    NEUROLOGIA("Neurología"),
    PEDIATRIA("Pediatría"),
    DERMATOLOGIA("Dermatología"),
    ONCOLOGIA("Oncología"),
    ORTOPEDIA("Ortopedia"),
    GINECOLOGIA("Ginecología"),
    PSIQUIATRIA("Psiquiatría"),
    RADIOLOGIA("Radiología"),
    URGENCIAS("Urgencias"),
    MEDICINA_GENERAL("Medicina General"),
    ANESTESIOLOGIA("Anestesiología"),
    ENDOCRINOLOGIA("Endocrinología"),
    NEUMOLOGIA("Neumología"),
    OFTALMOLOGIA("Oftalmología");

    private final String nombre;

    Especialidad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
