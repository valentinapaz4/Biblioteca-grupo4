package builder;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import java.util.Date;

@Getter
@ToString
@Builder
public class Usuario {
    private String nombre;
    private String email;
    private String direccion;
    private String telefono;
    private Date fechaNacimiento;
}