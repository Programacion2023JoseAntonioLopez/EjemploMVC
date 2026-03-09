package view;

import db.PersonaDAO;
import model.Persona;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class VistaPersona {
    public Scanner scanner;

    public VistaPersona() {
        scanner = new Scanner(System.in);
    }

    public void mostrarPersonas(List<Persona> personas) {
        System.out.println("Lista de Personas:");
        // Cabecera
        System.out.printf("%-5s %-12s %-15s %-15s %-5s\n","ID","DNI", "Nombre", "Apellidos","Edad");

        System.out.println("---------------------------------------------------------------------");

        personas.forEach(System.out::println);

    }

    public Persona crearPersona() {
        boolean entradaValida = false;
        //comprobamos que no exista una persona con el mismo DNI
        String dni="";
        while (!entradaValida) {
            System.out.println("Introduce el DNI:");
            dni = scanner.nextLine().toUpperCase();
            try {
                Persona personaDuplicada = PersonaDAO.getInstance().getPersonaByDni(dni);
                if (personaDuplicada==null)//no existe
                    entradaValida = true;
                else
                     System.out.println("Error: la persona ya existe.");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Introduce el nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce el apellido:");
        String apellido = scanner.nextLine();
        int edad = 0;

        entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.println("Introduce la edad:");
                edad = Integer.parseInt(scanner.nextLine());
                entradaValida = true; // si se convierte correctamente, salimos del bucle
            } catch (NumberFormatException e) {
                System.out.println("Error: debes introducir un número válido.");
            }
        }

        return new Persona(dni, nombre, apellido, edad);
    }

    public String obtenerDniAEliminar() {
        System.out.println("Introduce el DNI de la persona a eliminar:");
        return scanner.nextLine();
    }

    public Persona obtenerDatosActualizados() {
        System.out.println("Introduce el DNI:");
        String dni = scanner.nextLine();
        System.out.println("Introduce el nuevo nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce el nuevo apellido:");
        String apellido = scanner.nextLine();
        System.out.println("Introduce la nueva edad:");
        int edad = Integer.parseInt(scanner.nextLine());

        return new Persona(dni, nombre, apellido, edad);
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
        if (persona != null)
            System.out.println(persona);
        else
            System.out.println("La persona no existe");
    }

    // Otros métodos de la vista...
}

