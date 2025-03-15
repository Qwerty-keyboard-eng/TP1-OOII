package org.example;

import java.util.Objects;

public class Concursante {
    private String nombre;
    private int puntos;

    public Concursante(String n) {
        if (n == null || n.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni estar vacio");
        }
        nombre = n;
        puntos = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Concursante that = (Concursante) o;
        return Objects.equals(nombre, that.nombre);
    }


    void sumarPuntos(int sp) {
        puntos += sp;
    }

    public int verPuntos() {
        return puntos;
    }
}
