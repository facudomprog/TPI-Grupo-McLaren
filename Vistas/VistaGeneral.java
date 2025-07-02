package Vistas;

import java.util.Scanner;

public class VistaGeneral {

    private Scanner scanner = new Scanner(System.in);

    public VistaGeneral() {
    }

    public int mostrarMenuPrincipal() {
        System.out.println("\nSeleccione una opcion");
        System.out.println("1 - Registrar ");
        System.out.println("2 - Mostrar");
        System.out.println("0 - Salir");
        return scanner.nextInt();
    }




    public int mostrarMenuRegistrar() {
        System.out.println("\nSeleccione una opcion");
        System.out.println("1 - Registrar Monoplaza");
        System.out.println("2 - Registrar Equipo");
        System.out.println("3 - Registrar Piloto");
        System.out.println("4 - Registrar Gran Premio");
        System.out.println("5 - Registrar Carrera");
        System.out.println("6 - Registrar Parrilla");
        System.out.println("7 - Registrar Puntaje");
        System.out.println("8 - Registrar Penalizacion");
        System.out.println("0 - Salir");
        return scanner.nextInt();
    }


    public int mostrarMenuMostrar() {
        System.out.println("\nSeleccione una opcion");
        System.out.println("1 - Mostrar Monoplazas");
        System.out.println("2 - Mostrar Equipos");
        System.out.println("3 - Mostrar Pilotos");
        System.out.println("4 - Mostrar Gran Premios");
        System.out.println("5 - Mostrar Carreras");
        System.out.println("6 - Mostrar Parrillas");
        System.out.println("7 - Mostrar Puntajes");
        System.out.println("8 - Mostrar Penalizacions");
        System.out.println("0 - Salir");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String pedirString(String mensaje){
        System.out.println(mensaje);
        return scanner.next();
    }

    public int pedirInt(String mensaje){
        System.out.println(mensaje);
        return scanner.nextInt();
    }

    public double pedirDouble(String mensaje){
        System.out.println(mensaje);
        return scanner.nextDouble();
    }
}
