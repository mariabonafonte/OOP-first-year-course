package notas;

import java.util.List;

public class AsignaturaMedias extends Asignatura {

    public AsignaturaMedias(String nombre, String[] datosEstudiantes) {
        super(nombre, datosEstudiantes);
    }

    public double getMedia(CalculoMedia calc) throws EstudianteException {
        return calc.calcular(getEstudiantes());
    }

    @Override
    public double getMedia() throws EstudianteException {
        return getMedia(new MediaAritmetica());
    }
}
