package alturas;

import java.util.Objects;

public class Pais implements Comparable<Pais> {
    private String nombre;
    private String continente;
    private double altura;

    public Pais(String nombre, String continente, double altura) {
        this.nombre = nombre;
        this.continente = continente;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContinente() {
        return continente;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pais)) return false;
        Pais pais = (Pais) o;
        return Objects.equals(nombre, pais.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public int compareTo(Pais o) {
        return this.nombre.compareTo(o.nombre);
    }

    @Override
    public String toString() {
        return String.format("Pais(%s, %s, %.3f)", nombre, continente, altura);
    }
}
