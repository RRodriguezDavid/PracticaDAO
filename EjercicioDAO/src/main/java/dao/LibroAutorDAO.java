package dao;

import model.LibroAutor;

import java.util.List;

public interface LibroAutorDAO {
    void addLibroAutor(LibroAutor libroAutor) throws Exception;
    List<LibroAutor> getAllLibroAutores() throws Exception;
    LibroAutor getLibroAutorByIds(int idLibro, int idAutor) throws Exception;
    void updateLibroAutor(LibroAutor libroAutor) throws Exception;
    void deleteLibroAutor(int idLibro, int idAutor) throws Exception;
}
