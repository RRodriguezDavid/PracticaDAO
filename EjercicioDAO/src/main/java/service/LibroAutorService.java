package service;

import dao.LibroAutorDAO;
import model.LibroAutor;

import java.util.List;

public class LibroAutorService {
    private final LibroAutorDAO libroAutorDAO;

    public LibroAutorService(LibroAutorDAO libroAutorDAO) {
        this.libroAutorDAO = libroAutorDAO;
    }

    public void registrarlibroAutor(int idLibro, int idAutor) {
        try {
            LibroAutor libroAutor = new LibroAutor(idLibro, idAutor);
            libroAutorDAO.addLibroAutor(libroAutor);
        } catch (Exception e) {
            System.err.println("Error al registrar libroAutor: " + e.getMessage());
        }
    }

    public List<LibroAutor> listarLibroAutores() {
        try {
            return libroAutorDAO.getAllLibroAutores();
        } catch (Exception e) {
            System.err.println("Error al listar libroAutores: " + e.getMessage());
            return List.of();
        }
    }

    public void cambiarIDs(int idLibro, int idAutor) {
        try {
            LibroAutor libroAutor = libroAutorDAO.getLibroAutorByIds(idLibro, idAutor);
            if (libroAutor != null) {
                libroAutor.setIdLibro(idLibro);
                libroAutor.setIdAutor(idAutor);
                libroAutorDAO.updateLibroAutor(libroAutor);
            } else {
                System.out.println("Service: No se encontró el libroAutor con idLibro=" + idLibro + ", idAutor=" + idAutor);
            }
        } catch (Exception e) {
            System.err.println("Error al actualizar libroAutor: " + e.getMessage());
        }
    }

    public void eliminarLibroAutor(int idLibro, int idAutor) {
        try {
            libroAutorDAO.deleteLibroAutor(idLibro, idAutor);
        } catch (Exception e) {
            System.err.println("Error al eliminar libroAutor: " + e.getMessage());
        }
    }
}
