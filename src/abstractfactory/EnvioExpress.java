package abstractfactory;

public class EnvioExpress implements MetodoEnvio {
    @Override
    public void enviar() {
        System.out.println("Envío express - Entrega en 24-48 horas");
    }
}