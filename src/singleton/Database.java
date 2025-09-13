package singleton;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static Database instance;

    @Getter
    private List<String> libros;

    private Database() {
        libros = new ArrayList<>();
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void agregarLibro(String libro) {
        libros.add(libro);
    }
}