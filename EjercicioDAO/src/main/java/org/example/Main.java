
package org.example;

import dao.*;
import service.AutorService;
import service.LibroService;
import service.PrestamoService;
import service.UsuarioService;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    static LibroDAO libroDAO = new LibroDAOImpl();
    static UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
    static AutorDAO autorDAO = new AutorDAOImpl();
    static PrestamoDAO prestamoDAO = new PrestamoDAOImpl();

    static LibroService servicioLibro = new LibroService(libroDAO);
    static AutorService servicioAutor = new AutorService(autorDAO);
    static PrestamoService servicioPrestamo = new PrestamoService(prestamoDAO);
    static UsuarioService servicioUsuario = new UsuarioService(usuarioDAO);

    public static void main(String[] args) {

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
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    servicioLibro.registrarLibro(titulo);
                }
                case 2 -> servicioLibro.listarLibros().forEach(System.out::println);
                case 3 -> {
                    System.out.print("ID del libro: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Nuevo título: ");
                    String nuevo = sc.nextLine();
                    servicioLibro.cambiarTitulo(id, nuevo);
                }
                case 4 -> {
                    System.out.print("ID del libro a eliminar: ");
                    int id = sc.nextInt(); sc.nextLine();
                    servicioLibro.eliminarLibro(id);
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida");
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
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    servicioAutor.registrarAutor(titulo);
                }
                case 2 -> servicioAutor.listarLibros().forEach(System.out::println);
                case 3 -> {
                    System.out.print("ID del libro: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Nuevo título: ");
                    String nuevo = sc.nextLine();
                    servicioAutor.cambiarTitulo(id, nuevo);
                }
                case 4 -> {
                    System.out.print("ID del libro a eliminar: ");
                    int id = sc.nextInt(); sc.nextLine();
                    servicioAutor.eliminarLibro(id);
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida");
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
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    servicioPrestamo.registrarAutor(titulo);
                }
                case 2 -> servicioPrestamo.listarLibros().forEach(System.out::println);
                case 3 -> {
                    System.out.print("ID del libro: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Nuevo título: ");
                    String nuevo = sc.nextLine();
                    servicioPrestamo.cambiarTitulo(id, nuevo);
                }
                case 4 -> {
                    System.out.print("ID del libro a eliminar: ");
                    int id = sc.nextInt(); sc.nextLine();
                    servicioPrestamo.eliminarLibro(id);
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida");
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
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    servicioAutor.registrarAutor(titulo);
                }
                case 2 -> servicioAutor.listarLibros().forEach(System.out::println);
                case 3 -> {
                    System.out.print("ID del libro: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Nuevo título: ");
                    String nuevo = sc.nextLine();
                    servicioAutor.cambiarTitulo(id, nuevo);
                }
                case 4 -> {
                    System.out.print("ID del libro a eliminar: ");
                    int id = sc.nextInt(); sc.nextLine();
                    servicioAutor.eliminarLibro(id);
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida");
            }
        }
    }

}
