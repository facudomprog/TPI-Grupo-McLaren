import Controladores.Controlador;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Controlador controlador = new Controlador();
        controlador.iniciar();
    }
}
