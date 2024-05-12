package view;

import model.Persona;

import java.util.List;
import java.util.Scanner;

public class VistaPersona {
    public Scanner scanner;

    public VistaPersona() {
        scanner = new Scanner(System.in);
    }

    public void mostrarPersonas(List<Persona> personas) {
        System.out.println("Lista de Personas:");
        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }

    public Persona crearPersona() {
        System.out.println("Introduce el DNI:");
        String dni = scanner.nextLine();
        System.out.println("Introduce el nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce el apellido:");
        String apellido = scanner.nextLine();
        System.out.println("Introduce la edad:");
        int edad = Integer.parseInt(scanner.nextLine());

        return new Persona(dni, nombre, apellido, edad);
    }

    public String obtenerDniAEliminar() {
        System.out.println("Introduce el DNI de la persona a eliminar:");
        return scanner.nextLine();
    }

    public Persona obtenerDatosActualizados() {
        System.out.println("Introduce el nuevo nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce el nuevo apellido:");
        String apellido = scanner.nextLine();
        System.out.println("Introduce la nueva edad:");
        int edad = Integer.parseInt(scanner.nextLine());

        return new Persona("", nombre, apellido, edad); // DNI no es necesario para actualizar
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String obtenerDni() {
        System.out.println("Introduce el DNI de la persona:");
        return scanner.nextLine();
    }
    //muestra los datos de la persona
    public void mostrarPersona(Persona persona) {
        if(persona!=null)
            System.out.println(persona);
        else
            System.out.println("La persona no existe");
    }

    // Otros métodos de la vista...
}

