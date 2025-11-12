package dao;

import model.Libro;

import java.util.List;

public interface AutorDAO {
    void addAutor(Libro libro) throws Exception;
    List<Libro> getAllAutores() throws Exception;
    Libro getAutorById(int id) throws Exception;
    void updateAutor(Libro libro) throws Exception;
    void deleteAutor(int id) throws Exception;
}
