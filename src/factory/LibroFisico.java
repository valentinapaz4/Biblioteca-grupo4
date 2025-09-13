package factory;

import lombok.Getter;

@Getter
public class LibroFisico implements Libro {
    @Override
    public String getTipo() {
        return "Libro Físico";
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Tipo: Libro Físico - Disponible para préstamo físico");
    }
}