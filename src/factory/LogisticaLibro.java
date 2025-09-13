package factory;

public class LogisticaLibro {
    public static Libro crearLibro(String tipo) {
        switch (tipo.toLowerCase()) {
            case "fisico":
                return new LibroFisico();
            case "digital":
                return new LibroDigital();
            default:
                throw new IllegalArgumentException("Tipo de libro no válido: " + tipo);
        }
    }
}