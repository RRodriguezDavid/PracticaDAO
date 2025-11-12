
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
                    System.out.println("");
                    crudLibro();
                }
                case 2 ->{
                    System.out.print("Autor: ");
                    System.out.println("");
                    crudAutor();
                }
                case 3 -> {
                    System.out.print("Uusario:");
                    System.out.println("");
                    crudUsuario();
                }
                case 4 -> {
                    System.out.print("Prestamo ");
                    System.out.println("");
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
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    servicioUsuario.registrarUsuario(nombre);
                }
                case 2 -> servicioUsuario.listarUsuarios().forEach(System.out::println);
                case 3 -> {
                    System.out.print("ID usuario: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nuevo = sc.nextLine();
                    servicioUsuario.cambiarNombre(id, nuevo);
                }
                case 4 -> {
                    System.out.print("ID del usuario a eliminar: ");
                    int id = sc.nextInt(); sc.nextLine();
                    servicioUsuario.eliminarUsuario(id);
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
                    int cantidasSemanas = sc.nextInt(); sc.nextLine();
                    System.out.println("id Usuario: ");
                    int idUsuario = sc.nextInt(); sc.nextLine();
                    System.out.println("id Libro: ");
                    int idLibro = sc.nextInt(); sc.nextLine();
                    servicioPrestamo.registrarPrestamo(cantidasSemanas, idUsuario, idLibro);
                }
                case 2 -> servicioPrestamo.listarPrestamos().forEach(System.out::println);
                case 3 -> {
                    System.out.print("ID del libro: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Año: ");
                    String anno = sc.nextLine();
                    System.out.println("Mes");
                    String mes = sc.nextLine();
                    System.out.println("Dia");
                    String dia = sc.nextLine();
                    servicioPrestamo.cambiarFechaFin(id,anno,mes,dia );
                }
                case 4 -> {
                    System.out.print("ID del libro a eliminar: ");
                    int id = sc.nextInt(); sc.nextLine();
                    servicioPrestamo.eliminarPrestamo(id);
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
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    servicioAutor.registrarAutor(nombre);
                }
                case 2 -> servicioAutor.listarAutores().forEach(System.out::println);
                case 3 -> {
                    System.out.print("ID del Autor: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nuevo = sc.nextLine();
                    servicioAutor.cambiarNombre(id, nuevo);
                }
                case 4 -> {
                    System.out.print("ID del Autor a eliminar: ");
                    int id = sc.nextInt(); sc.nextLine();
                    servicioAutor.eliminarAutor(id);
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida");
            }
        }
    }
}
