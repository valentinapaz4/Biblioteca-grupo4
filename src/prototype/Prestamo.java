package prototype;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@Getter
@Setter
@ToString
public class Prestamo implements Cloneable {
    private String libro;
    private String usuario;
    private Date fechaInicio;
    private Date fechaFin;

    public Prestamo(String libro, String usuario, Date fechaInicio, Date fechaFin) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    @Override
    public Prestamo clone() {
        try {
            return (Prestamo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}