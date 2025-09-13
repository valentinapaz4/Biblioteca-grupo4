import factory.LogisticaLibro;
import singleton.Database;
import factory.Libro;
import abstractfactory.*;
import builder.Usuario;
import prototype.Prestamo;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE BIBLIOTECA ONLINE ===\n");

        // 1. Singleton
        System.out.println("1. PATRÓN SINGLETON");
        Database db1 = Database.getInstance();
        Database db2 = Database.getInstance();

        System.out.println("¿Misma instancia? " + (db1 == db2));

        db1.agregarLibro("El Señor de los Anillos - J.R.R. Tolkien");
        db2.agregarLibro("Cien años de soledad - Gabriel García Márquez");
        db1.agregarLibro("1984 - George Orwell");

        System.out.println("Libros en la base de datos:");
        for (String libro : db1.getLibros()) {
            System.out.println("   📚 " + libro);
        }
        System.out.println();

        // 2. Factory Method
        System.out.println("2. PATRÓN FACTORY METHOD");
        Libro libroFisico = LogisticaLibro.crearLibro("fisico");
        Libro libroDigital = LogisticaLibro.crearLibro("digital");

        System.out.print("Libro físico: ");
        libroFisico.mostrarInfo();

        System.out.print("Libro digital: ");
        libroDigital.mostrarInfo();
        System.out.println();

        // 3. Abstract Factory
        System.out.println("3. PATRÓN ABSTRACT FACTORY");
        AbstractFactory adminFactory = new Administratory();
        AbstractFactory usuarioFactory = new UsuarioFactory();

        System.out.println("-- Administrador --");
        InterfazUI adminUI = adminFactory.crearInterfazUI();
        MetodoEnvio adminEnvio = adminFactory.crearMetodoEnvio();
        adminUI.render();
        adminEnvio.enviar();

        System.out.println("-- Usuario Normal --");
        InterfazUI usuarioUI = usuarioFactory.crearInterfazUI();
        MetodoEnvio usuarioEnvio = usuarioFactory.crearMetodoEnvio();
        usuarioUI.render();
        usuarioEnvio.enviar();
        System.out.println();

        // 4. Builder
        System.out.println("4. PATRÓN BUILDER");
        Usuario usuario1 = Usuario.builder()
                .nombre("Ana García")
                .email("ana@email.com")
                .build();

        Usuario usuario2 = Usuario.builder()
                .nombre("Carlos López")
                .email("carlos@email.com")
                .direccion("Av. Principal 123")
                .telefono("555-1234")
                .fechaNacimiento(new Date())
                .build();

        System.out.println("Usuario 1: " + usuario1);
        System.out.println("Usuario 2: " + usuario2);
        System.out.println();

        // 5. Prototype
        System.out.println("5. PATRÓN PROTOTYPE");
        Prestamo prestamoOriginal = new Prestamo(
                "1984 - George Orwell",
                "Ana García",
                new Date(),
                new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000) // +7 días
        );

        Prestamo prestamoClon1 = prestamoOriginal.clone();
        prestamoClon1.setUsuario("Carlos López");

        Prestamo prestamoClon2 = prestamoOriginal.clone();
        prestamoClon2.setLibro("El Señor de los Anillos - J.R.R. Tolkien");
        prestamoClon2.setFechaFin(new Date(System.currentTimeMillis() + 14 * 24 * 60 * 60 * 1000)); // +14 días

        System.out.println("Original: " + prestamoOriginal);
        System.out.println("Clon 1: " + prestamoClon1);
        System.out.println("Clon 2: " + prestamoClon2);
        System.out.println("¿Clon1 es igual al original? " + (prestamoClon1 == prestamoOriginal));

        System.out.println("\n=== FIN DEL SISTEMA ===");
    }
}