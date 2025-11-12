package dao;

public interface PrestamoDAO {
    void addPrestamo(Libro libro) throws Exception;
    List<Libro> getAllPrtesamos() throws Exception;
    Libro getPrestamoById(int id) throws Exception;
    void updatePrestamo(Libro libro) throws Exception;
    void deletePrestamo(int id) throws Exception;
}
