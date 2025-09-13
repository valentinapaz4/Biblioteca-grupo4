package abstractfactory;

public class EnvioNormal implements MetodoEnvio {
    @Override
    public void enviar() {
        System.out.println("Envío normal - Entrega en 5-7 días");
    }
}