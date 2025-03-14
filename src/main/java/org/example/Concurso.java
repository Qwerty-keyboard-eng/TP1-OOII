package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    public List<Concursante> concursantes;
    private LocalDate fechainicio;
    private LocalDate fechafin;


    public Concurso(LocalDate fi, LocalDate ff) {
        fechainicio = fi;
        fechafin = ff;
    }

    public void inscribir(Concursante c) {
        if (c == null) {
            throw new IllegalArgumentException("Debe ingresar un concursante existente");
        }
        LocalDate fechahoy = LocalDate.now();
        if (fechahoy.isAfter(fechafin)) {
            throw new IllegalArgumentException("Error: La inscripción está fuera de fecha.");
        }
        concursantes.add(c);
        if (fechainicio.isEqual(fechahoy)) {
            c.sumarPuntos(10);
        }

    }

    public List<Concursante> obtenerConcursantes() {
        return new ArrayList<>(concursantes);
    }

}
