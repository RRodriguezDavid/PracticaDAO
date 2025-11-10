
package org.example;

import dao.LibroDAO;
import dao.LibroDAOImpl;
import model.Libro;
import service.BibliotecaService;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        LibroDAO libroDAO = new LibroDAOImpl();
        BibliotecaService servicio = new BibliotecaService(libroDAO);
        int opcion;

        do {
            System.out.print("""
                    +-------------------------------+
                    |===== MENÚ BIBLIOTECA =====    |    
                    |    1. Libro                   |
                    |    2. Autor                   |
                    |    3. Usuario                 |
                    |    4. Préstamo                |
                    |    0. Salir                   |
                    |    Opción:                    |
                    +-------------------------------+
                    | Opción: 
                    """);
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Libro: ");
                    crudLibro();

                }
                case 2 ->{
                    System.out.print("Autor: ");
                    crudAutor();
                }
                case 3 -> {
                    System.out.print("Uusario:");
                    crudUsuario();
                }
                case 4 -> {
                    System.out.print("Prestamo ");
                    crudPrestamo();
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }

    private static void crudLibro() {

        while (true) {
            System.out.print("""
                +-----------------------------------------------+
                |=======Opciones disponibles para libros =======|
                |       1.Añadir Libro                          |
                |       2.Leer Libro                            |
                |       3.Actualizar Libro                      |
                |       4.Borrar Libro                          |
                |       0.Salir                                 |
                +-----------------------------------------------+
                """);
            int eleccion =  sc.nextInt(); sc.nextLine();
            switch (eleccion) {
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {

                }
                case 0 ->{
                    System.out.println("Saliendo...");
                    break;
                }
                default -> System.out.println("Opcion no valida");
            }
        }
    }
    private static void crudUsuario() {
        while (true) {
            System.out.print("""
                +-----------------------------------------------+
                |=======Opciones disponibles para Usuarios======|
                |       1.Añadir Usuarios                       |
                |       2.Leer Usuarios                         |
                |       3.Actualizar Usuarios                   |
                |       4.Borrar Usuarios                       |
                |       0.Salir                                 |
                +-----------------------------------------------+
                """);
            int eleccion =  sc.nextInt(); sc.nextLine();
            switch (eleccion) {
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {

                }
                case 0 ->{
                    System.out.println("Saliendo...");
                    break;
                }
                default -> System.out.println("Opcion no valida");
            }
        }
    }
    private static void crudPrestamo() {
        while (true) {
            System.out.print("""
                +-----------------------------------------------+
                |=======Opciones disponibles para Prestamo======|
                |       1.Añadir Prestamo                       |
                |       2.Leer Prestamo                         |
                |       3.Actualizar Prestamo                   |
                |       4.Borrar Prestamo                       |
                |       0.Salir                                 |
                +-----------------------------------------------+
                """);
            int eleccion =  sc.nextInt(); sc.nextLine();
            switch (eleccion) {
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {

                }
                case 0 ->{
                    System.out.println("Saliendo...");
                    break;
                }
                default -> System.out.println("Opcion no valida");
            }
        }
    }
    private static void crudAutor() {
        while (true) {
            System.out.print("""
                +---------------------------------------------+
                |=======Opciones disponibles para Autor=======|
                |       1.Añadir Autor                        |
                |       2.Leer Autor                          |
                |       3.Actualizar Autor                    |
                |       4.Borrar Autor                        |
                |       0.Salir                               |
                +---------------------------------------------+
                """);
            int eleccion =  sc.nextInt(); sc.nextLine();
            switch (eleccion) {
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {

                }
                case 0 ->{
                    System.out.println("Saliendo...");
                    break;
                }
                default -> System.out.println("Opcion no valida");
            }
        }
    }

}
