package Controladores;

import Modelos.*;
import Vistas.VistaGeneral;
import conexion.ConexionBD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class Controlador {
    private VistaGeneral vista = new VistaGeneral();
    private ArrayList<Monoplaza> monoplazas = new ArrayList<>();
    private ArrayList<Equipo> equipos = new ArrayList<>();
    private ArrayList<Piloto> pilotos = new ArrayList<>();
    private ArrayList<Puntaje> puntajes = new ArrayList<>();
    private ArrayList<Penalizacion> penalizacions = new ArrayList<>();
    private ArrayList<GranPremio> granPremios = new ArrayList<>();
    private ArrayList<Carrera> carreras = new ArrayList<>();
    private ArrayList<Parrilla> parrillas = new ArrayList<>();



    public Controlador() {
    }

    public void iniciar() throws SQLException {
        monoplazaBD();
        equipoBD();
        pilotoBD();
        puntajeBD();
        pealizacionBD();
        granPremioBD();
        carreraBD();
        parrillaBD();

        int opcion=vista.mostrarMenuPrincipal();
        while (opcion!=0){
            switch (opcion) {
                case 1:
                    menuRegistrar();
                    break;
                case 2:
                    menuMostrar();

                    break;

                default:
                    vista.mostrarMensaje("Opcion incorrecta.");
                    break;
            }

            opcion=vista.mostrarMenuPrincipal();
        }
    }

    public void menuRegistrar() throws SQLException {

        int opcion=vista.mostrarMenuRegistrar();
        while (opcion!=0){
            switch (opcion) {
                case 1:
                    registrarMonoplaza();
                    break;
                case 2:
                    registrarEquipo();
                    break;
                case 3:
                    registrarPiloto();
                    break;
                case 4:
                    registrarGranPremio();
                    break;
                case 5:
                    registrarCarrera();
                    break;
                case 6:
                    registrarParrilla();
                    break;
                case 7:
                    registrarPuntaje();
                    break;
                case 8:
                    registrarPenalizacion();
                    break;
                default:
                    vista.mostrarMensaje("Opcion incorrecta.");
                    break;
            }

            opcion=vista.mostrarMenuRegistrar();
        }
    }

    public void menuMostrar() {

        int opcion=vista.mostrarMenuMostrar();
        while (opcion!=0){
            switch (opcion) {
                case 1:
                    mostrarMonoplazas();
                    break;
                case 2:
                    mostrarEquipos();
                    break;
                case 3:
                    mostrarPilotos();
                    break;
                case 4:
                    mostrarGranPremios();
                    break;
                case 5:
                    mostrarCarreras();
                    break;
                case 6:
                    mostrarParrillas();
                    break;
                case 7:
                    mostrarPuntajes();
                    break;
                case 8:
                    mostrarPenalizaciones();
                    break;
                default:
                    vista.mostrarMensaje("Opcion incorrecta.");
                    break;
            }

            opcion=vista.mostrarMenuMostrar();
        }
    }











    public void registrarMonoplaza() throws SQLException {
        int codigo = ThreadLocalRandom.current().nextInt(1, 1001);;
        String modelo = vista.pedirString("Ingresa el modelo del monoplaza");
        double peso = vista.pedirDouble("Ingresa el peso del monoplaza");
        int potencia = vista.pedirInt("Ingresa la potencia del monoplaza");
        int velocidad = vista.pedirInt("Ingresa la velocidad del monoplaza");
        monoplazas.add(new Monoplaza(codigo,modelo,peso,potencia,velocidad));

        try (Connection conn = ConexionBD.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO monoplaza (codigo,modelo, peso, potencia, velocidad) VALUES (?, ?, ?, ?,?)");
            stmt.setInt(1,codigo);
            stmt.setString(2, modelo);
            stmt.setDouble(3, peso);
            stmt.setInt(4, potencia);
            stmt.setInt(5, velocidad);
            stmt.executeUpdate();
        }
    }

    public void mostrarMonoplazas(){
        vista.mostrarMensaje("Lista de monoplazas");
        for (Monoplaza m : monoplazas){
            vista.mostrarMensaje(m.toString());
        }
    }

    private Monoplaza buscarMonoplaza(int codigo) {
        for (Monoplaza m : monoplazas) {
            if (m.getCodigo()==codigo) {
                return m;
            }
        }
        return null;
    }

    public void registrarEquipo() throws SQLException {
        int codigo = ThreadLocalRandom.current().nextInt(1, 1001);
        String nombre = vista.pedirString("Ingrese el nombre del equipo");
        String nacionalidad = vista.pedirString("Ingrese la nacionalidad del equipo");
        mostrarMonoplazas();
        Monoplaza monoplaza = buscarMonoplaza(vista.pedirInt("Ingresa el codigo del monoplaza"));
        if (monoplaza != null){
            equipos.add(new Equipo(codigo,nombre,nacionalidad,monoplaza));
            try (Connection conn = ConexionBD.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO equipo (codigo,nombre,nacionalidad, cod_monoplaza) VALUES (?, ?, ?, ?)");
                stmt.setInt(1,codigo);
                stmt.setString(2, nombre);
                stmt.setString(3, nacionalidad);
                stmt.setInt(4, monoplaza.getCodigo());
                stmt.executeUpdate();
            }
        }
        else {
            vista.mostrarMensaje("Monoplaza no encontrado");
        }
    }

    public void mostrarEquipos(){
        vista.mostrarMensaje("Lista de equipos");
        for (Equipo e : equipos){
            vista.mostrarMensaje(e.toString());
        }
    }

    private Equipo buscarEquipo(int codigo) {
        for (Equipo e : equipos) {
            if (e.getCodigo()==codigo) {
                return e;
            }
        }
        return null;
    }

    public void registrarPiloto() throws SQLException {
        int codigo = ThreadLocalRandom.current().nextInt(1, 1001);
        String nombre = vista.pedirString("Ingrese el nombre del piloto");
        String apellido = vista.pedirString("Ingrese el apellido del piloto");
        String fechaNacimineto = vista.pedirString("Ingrese la fecha de nacimiento");
        String nacionalidad = vista.pedirString("Ingrese la nacionalidad del piloto");
        mostrarEquipos();
        Equipo equipo = buscarEquipo(vista.pedirInt("Ingresa el codigo del equipo"));
        if (equipo != null){
            pilotos.add(new Piloto(codigo,nombre,apellido,fechaNacimineto,nacionalidad,equipo));
            try (Connection conn = ConexionBD.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO piloto (codigo,nombre,apellido, fecha_nacimiento,nacionalidad,cod_equipo) VALUES (?, ?, ?, ?,?,?)");
                stmt.setInt(1,codigo);
                stmt.setString(2, nombre);
                stmt.setString(3, apellido);
                stmt.setString(4, fechaNacimineto);
                stmt.setString(5,nacionalidad);
                stmt.setInt(6,equipo.getCodigo());
                stmt.executeUpdate();
            }
        }
        else {
            vista.mostrarMensaje("Equipo no encontrado");
        }
    }

    public void mostrarPilotos(){
        vista.mostrarMensaje("Lista de pilotos");
        for (Piloto p : pilotos){
            vista.mostrarMensaje(p.toString());
        }
    }

    private Piloto buscarPiloto(int codigo) {
        for (Piloto p : pilotos) {
            if (p.getCodigo()==codigo) {
                return p;
            }
        }
        return null;
    }

    public void registrarPuntaje() throws SQLException {
        int codigo = ThreadLocalRandom.current().nextInt(1, 1001);
        mostrarPilotos();
        Piloto piloto = buscarPiloto(vista.pedirInt("Ingrese el codigo del piloto"));
        int puntos = vista.pedirInt("Ingrese los puntos");
        if (piloto != null){
            puntajes.add(new Puntaje(codigo,piloto,puntos));
            try (Connection conn = ConexionBD.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO puntaje (codigo,cod_piloto,puntos) VALUES (?, ?, ?)");
                stmt.setInt(1,codigo);
                stmt.setInt(2, piloto.getCodigo());
                stmt.setInt(3, puntos);
                stmt.executeUpdate();
            }
        }
        else {
            vista.mostrarMensaje("Piloto no encontrado");
        }
    }

    public void mostrarPuntajes(){
        vista.mostrarMensaje("Lista de puntajes");
        for (Puntaje p : puntajes){
            vista.mostrarMensaje(p.toString());
        }
    }

    private Piloto buscarPuntaje(int codigo) {
        for (Piloto p : pilotos) {
            if (p.getCodigo()==codigo) {
                return p;
            }
        }
        return null;
    }


    public void registrarPenalizacion() throws SQLException {
        int codigo = ThreadLocalRandom.current().nextInt(1, 1001);
        mostrarPilotos();
        Piloto piloto = buscarPiloto(vista.pedirInt("Ingrese el codigo del piloto"));
        String fecha = vista.pedirString("Ingrese la fecha de la penalizacion");
        int sancion = vista.pedirInt("Ingrese la sancion de la penalizacion");
        if (piloto != null){
            penalizacions.add(new Penalizacion(codigo,piloto,fecha,sancion));
            try (Connection conn = ConexionBD.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO penalizacion (codigo,cod_piloto,fecha,sancion) VALUES (?, ?, ?,?)");
                stmt.setInt(1,codigo);
                stmt.setInt(2, piloto.getCodigo());
                stmt.setString(3, fecha);
                stmt.setInt(4,sancion);
                stmt.executeUpdate();
            }
        }
        else {
            vista.mostrarMensaje("Piloto no encontrado");
        }
    }

    public void mostrarPenalizaciones(){
        vista.mostrarMensaje("Lista de penalizaciones");
        for (Penalizacion p : penalizacions){
            vista.mostrarMensaje(p.toString());
        }
    }

    private Penalizacion buscarPenalizacion(int codigo) {
        for (Penalizacion p : penalizacions) {
            if (p.getCodigo()==codigo) {
                return p;
            }
        }
        return null;
    }

    public void registrarGranPremio() throws SQLException {
        int codigo = ThreadLocalRandom.current().nextInt(1, 1001);
        String nombre = vista.pedirString("Ingrese el nombre del gran premio");
        String pais = vista.pedirString("Ingrese el pais del gran premio");
        String ciudad = vista.pedirString("Ingrese la ciudad del gran premio");
        int cantidadVueltas = vista.pedirInt("Ingrese la cantidad de vueltas del gran premio");
        String fecha = vista.pedirString("Ingrese la fecha del gram premio");
        granPremios.add(new GranPremio(codigo,nombre,pais,ciudad,cantidadVueltas,fecha));
        try (Connection conn = ConexionBD.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO gran_premio (codigo,nombre,pais,ciudad,cantidad_vueltas,fecha) VALUES (?, ?, ?,?,?,?)");
            stmt.setInt(1,codigo);
            stmt.setString(2, nombre);
            stmt.setString(3, pais);
            stmt.setString(4,ciudad);
            stmt.setInt(5,cantidadVueltas);
            stmt.setString(6,fecha);
            stmt.executeUpdate();
        }
    }


    public void mostrarGranPremios(){
        vista.mostrarMensaje("Lista de gran premios");
        for (GranPremio g : granPremios){
            vista.mostrarMensaje(g.toString());
        }
    }

    private GranPremio buscarGranPremio(int codigo) {
        for (GranPremio g : granPremios) {
            if (g.getCodigo()==codigo) {
                return g;
            }
        }
        return null;
    }

    public void registrarCarrera() throws SQLException {
        int codigo = ThreadLocalRandom.current().nextInt(1, 1001);
        mostrarGranPremios();
        GranPremio granPremio = buscarGranPremio(vista.pedirInt("Ingrese el codigo del gran premio"));
        mostrarPilotos();
        Piloto piloto = buscarPiloto(vista.pedirInt("Ingrese el codigo del piloto"));
        int posicion = vista.pedirInt("Ingrese la posicion de la carrera");
        String tiempo = vista.pedirString("Ingrese el tiempo de la carrera");
        if (piloto != null){
           if (granPremio != null){

               carreras.add(new Carrera(codigo,granPremio,piloto,posicion,tiempo));
               try (Connection conn = ConexionBD.getConnection()) {
                   PreparedStatement stmt = conn.prepareStatement("INSERT INTO carrera (codigo,cod_gran_premio,cod_piloto,posicion,tiempo) VALUES (?, ?, ?,?,?)");
                   stmt.setInt(1,codigo);
                   stmt.setInt(2, granPremio.getCodigo());
                   stmt.setInt(3, piloto.getCodigo());
                   stmt.setInt(4,posicion);
                   stmt.setString(5,tiempo);
                   stmt.executeUpdate();
               }
           }
           else { vista.mostrarMensaje("Gran premio no encontrado");}
        }
        else {
            vista.mostrarMensaje("Piloto no encontrado");
        }
    }

    public void mostrarCarreras(){
        vista.mostrarMensaje("Lista de carreras");
        for (Carrera c : carreras){
            vista.mostrarMensaje(c.toString());
        }
    }

    private Carrera buscarCarrera(int codigo) {
        for (Carrera c : carreras) {
            if (c.getCodigo()==codigo) {
                return c;
            }
        }
        return null;
    }

    public void registrarParrilla() throws SQLException {
        int codigo = ThreadLocalRandom.current().nextInt(1, 1001);
        int posicion = vista.pedirInt("Ingrese la posicion de la carrera");
        mostrarPilotos();
        Piloto piloto = buscarPiloto(vista.pedirInt("Ingrese el codigo del piloto"));
        mostrarGranPremios();
        GranPremio granPremio = buscarGranPremio(vista.pedirInt("Ingrese el codigo del gran premio"));


        if (piloto != null){
            if (granPremio != null){

                parrillas.add(new Parrilla(codigo,posicion,piloto,granPremio));
                try (Connection conn = ConexionBD.getConnection()) {
                    PreparedStatement stmt = conn.prepareStatement("INSERT INTO parrilla (codigo,posicion,cod_piloto,cod_gran_premio) VALUES (?, ?, ?,?)");
                    stmt.setInt(1,codigo);
                    stmt.setInt(2, posicion);
                    stmt.setInt(3, piloto.getCodigo());
                    stmt.setInt(4,granPremio.getCodigo());
                    stmt.executeUpdate();
                }
            }
            else { vista.mostrarMensaje("Gran premio no encontrado");}
        }
        else {
            vista.mostrarMensaje("Piloto no encontrado");
        }
    }

    public void mostrarParrillas(){
        vista.mostrarMensaje("Lista de parrillas");
        for (Parrilla p : parrillas){
            vista.mostrarMensaje(p.toString());
        }
    }

    private Parrilla buscarParrilla(int codigo) {
        for (Parrilla p : parrillas) {
            if (p.getCodigo()==codigo) {
                return p;
            }
        }
        return null;
    }


    private void monoplazaBD() throws SQLException {

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM monoplaza");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String modelo = rs.getString("modelo");
                double peso = rs.getDouble("peso");
                int potencia = rs.getInt("potencia");
                int velocidad = rs.getInt("velocidad");
                
                monoplazas.add(new Monoplaza(codigo, modelo, peso, potencia, velocidad));
            }

        }
    }

    private void equipoBD() throws SQLException {

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM equipo");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nombre = rs.getString("nombre");
                String nacionalidad = rs.getString("nacionalidad");
                int cod_monoplaza = rs.getInt("cod_monoplaza");
                Monoplaza monoplaza = buscarMonoplaza(cod_monoplaza);

                    equipos.add(new Equipo(codigo, nombre, nacionalidad, monoplaza));
            }

        }
    }

    private void pilotoBD() throws SQLException {

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM piloto");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String fechaNacimiento = rs.getString("fecha_nacimiento");
                String nacionalidad = rs.getString("nacionalidad");
                int cod_equipo = rs.getInt("cod_equipo");
                Equipo equipo = buscarEquipo(cod_equipo);

                pilotos.add(new Piloto(codigo,nombre,apellido,fechaNacimiento,nacionalidad,equipo));
            }

        }
    }

    private void puntajeBD() throws SQLException {

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM puntaje");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                int cod_piloto = rs.getInt("cod_piloto");
                int puntos = rs.getInt("puntos");
                Piloto piloto = buscarPiloto(cod_piloto);

                puntajes.add(new Puntaje(codigo,piloto,puntos));
            }

        }
    }

    private void pealizacionBD() throws SQLException {

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM penalizacion");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                int cod_piloto = rs.getInt("cod_piloto");
                String fecha = rs.getString("fecha");
                int sancion = rs.getInt("sancion");
                Piloto piloto = buscarPiloto(cod_piloto);

                penalizacions.add(new Penalizacion(codigo,piloto,fecha,sancion));
            }

        }
    }

    private void granPremioBD() throws SQLException {

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM gran_premio");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nombre = rs.getString("nombre");
                String pais = rs.getString("pais");
                String ciudad = rs.getString("ciudad");
                int cantidadVueltas = rs.getInt("cantidad_vueltas");
                String fecha = rs.getString("fecha");

                granPremios.add(new GranPremio(codigo,nombre,pais,ciudad,cantidadVueltas,fecha));
            }

        }
    }

    private void carreraBD() throws SQLException {

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM carrera");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                int cod_gran_premio = rs.getInt("cod_gran_premio");
                int cod_piloto = rs.getInt("cod_piloto");
                int posicion = rs.getInt("posicion");
                String fecha = rs.getString("tiempo");
                GranPremio granPremio = buscarGranPremio(cod_gran_premio);
                Piloto piloto = buscarPiloto(cod_piloto);

                carreras.add(new Carrera(codigo,granPremio,piloto,posicion,fecha));
            }

        }
    }

    private void parrillaBD() throws SQLException {

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM parrilla");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                int posicion = rs.getInt("posicion");
                int cod_piloto = rs.getInt("cod_piloto");
                int cod_gran_premio = rs.getInt("cod_gran_premio");
                GranPremio granPremio = buscarGranPremio(cod_gran_premio);
                Piloto piloto = buscarPiloto(cod_piloto);

                parrillas.add(new Parrilla(codigo,posicion,piloto,granPremio));
            }

        }
    }











}
