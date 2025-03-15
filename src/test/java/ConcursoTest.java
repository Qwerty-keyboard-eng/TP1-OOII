import org.example.Concursante;
import org.example.Concurso;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTest {
    @Test
    public void inscribirTest() {
        Concursante c = new Concursante("Matias");
        Concursante c1 = new Concursante("Julio");
        Concurso i = new Concurso(LocalDate.now(), LocalDate.now().plusDays(2), "Concurso1");
        i.inscribir(c);
        assertEquals(1, i.cantidadInscriptos());
        assertTrue(i.estaInscripto(c));
        assertFalse(i.estaInscripto(c1));
    }

    @Test
    public void inscribirPrimDia() {
        Concursante c = new Concursante("Matias");
        Concurso i = new Concurso(LocalDate.now(), LocalDate.now().plusDays(2), "Concurso1");
        i.inscribir(c);
        assertEquals(10, c.verPuntos());
    }

    @Test
    public void inscribirFueraFecha() {
        Concursante c = new Concursante("Matias");
        Concurso i = new Concurso(LocalDate.now().minusDays(3), LocalDate.now().minusDays(1), "Concurso1");
        i.inscribir(c);
    }
}
