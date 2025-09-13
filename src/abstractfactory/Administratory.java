package abstractfactory;

public class Administratory implements AbstractFactory {
    @Override
    public InterfazUI crearInterfazUI() {
        return new AdminUI();
    }

    @Override
    public MetodoEnvio crearMetodoEnvio() {
        return new EnvioExpress();
    }
}