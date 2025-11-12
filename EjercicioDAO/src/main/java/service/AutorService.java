package service;

import dao.AutorDAO;
import model.Autor;

import java.util.List;

public class AutorService {
    private final AutorDAO autorDAO;

    public AutorService(AutorDAO autorDAO) {
        this.autorDAO = autorDAO;
    }

    public void registrarAutor(String nombre) {
        try {
            Autor autor = new Autor(0, nombre);
            autorDAO.addAutor(autor);
        } catch (Exception e) {
            System.out.println("Error al registrar autor: " + e.getMessage());
        }
    }

    public List<Autor> listarAutores() {
        try {
            return autorDAO.getAllAutores();
        } catch (Exception e) {
            System.err.println("Error al listar autores: " + e.getMessage());
            return List.of();
        }
    }

    public void cambiarNombre(int id, String nuevoNombre) {
        try {
            Autor autor = autorDAO.getAutorById(id);
            if (autor != null) {
                autor.setNombre(nuevoNombre);
                autorDAO.updateAutor(autor);
            } else {
                System.out.println("Service: No se encontró el autor con id=" + id);
            }
        } catch (Exception e) {
            System.err.println("Error al actualizar autor: " + e.getMessage());
        }
    }

    public void eliminarAutor(int id) {
        try {
            autorDAO.deleteAutor(id);
        } catch (Exception e) {
            System.err.println("Error al eliminar autor: " + e.getMessage());
        }
    }
}