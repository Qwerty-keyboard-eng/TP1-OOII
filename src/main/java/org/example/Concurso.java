package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    public List<Concursante> concursantes;
    public String nombre;
    private LocalDate fechainicio;
    private LocalDate fechafin;


    public Concurso(LocalDate fi, LocalDate ff, String n) {
        nombre = n;
        fechainicio = fi;
        fechafin = ff;
        concursantes = new ArrayList<>();
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


    public int cantidadInscriptos() {
        return this.concursantes.size();
    }

    public boolean estaInscripto(Concursante c) {
        return this.concursantes.contains(c);
    }
}
