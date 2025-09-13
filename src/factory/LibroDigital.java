package factory;

import lombok.Getter;

@Getter
public class LibroDigital implements Libro {
    @Override
    public String getTipo() {
        return "Libro Digital";
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Tipo: Libro Digital - Disponible para descarga");
    }
}