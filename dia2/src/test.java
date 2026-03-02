import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import humanos.Estudiante;

class test {

    Estudiante e;

    @BeforeEach
    void setUp() throws Exception {
        e = new Estudiante(23, "Joaquín", "Ballesteros");
    }

    @Test
    void mismoApellido() {
        assertFalse(e.mismoApellido(new Estudiante(23, "Carlos", "Ballesteros")));
        assertFalse(e.mismoApellido(new Estudiante(23, "Joaquín", "Gomez")));
        assertTrue(e.mismoApellido(new Estudiante(28, "Joaquín", "Ballesteros")));
    }

}
