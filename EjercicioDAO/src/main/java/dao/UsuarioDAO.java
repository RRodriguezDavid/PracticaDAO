package dao;

public interface UsuarioDAO {
    void addUsuario(Libro libro) throws Exception;
    List<Libro> getAllUsuarios() throws Exception;
    Libro getUsuarioById(int id) throws Exception;
    void updateUsuario(Libro libro) throws Exception;
    void deleteUsuario(int id) throws Exception;
}
