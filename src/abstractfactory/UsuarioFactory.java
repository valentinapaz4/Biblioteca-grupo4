package abstractfactory;

public class UsuarioFactory implements AbstractFactory {
    @Override
    public InterfazUI crearInterfazUI() {
        return new UsuarioUI();
    }

    @Override
    public MetodoEnvio crearMetodoEnvio() {
        return new EnvioNormal();
    }
}