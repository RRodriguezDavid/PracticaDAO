package dao;

import model.LibroAutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LibroAutorDAOImpl implements LibroAutorDAO {
    @Override
    public void addLibroAutor(LibroAutor libroAutor) throws Exception {
        String sql = "INSERT INTO LibroAutor (idUsuario, idAutor) VALUES (?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, libroAutor.getIdLibro());
            ps.setInt(2, libroAutor.getIdAutor());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    libroAutor.setIdLibro(rs.getInt(1));
                    libroAutor.setIdAutor(rs.getInt(2));
                }
            }

            System.out.println("DAO: LibroAutor insertado -> " + libroAutor);
        }
    }

    @Override
    public List<LibroAutor> getAllLibroAutores() throws Exception {
        String sql = "SELECT idLibro, idAutor FROM LibroAutor ORDER BY idLibro";
        List<LibroAutor> lista = new ArrayList<>();

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new LibroAutor(rs.getInt("idLibro"), rs.getInt("idAutor")));
            }
        }
        return lista;
    }

    @Override
    public LibroAutor getLibroAutorByIds(int idLibro, int idAutor) throws Exception {
        String sql = "SELECT idLibro, idAutor FROM Autor WHERE idLibro = ? and idAutor = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idLibro);
            ps.setInt(2, idAutor);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new LibroAutor(rs.getInt("idLibro"), rs.getInt("idAutor"));
                }
            }
        }
        return null;
    }

    @Override
    public void updateLibroAutor(LibroAutor libroAutor) throws Exception {
        String sql = "UPDATE LibroAutor SET idLibro=?, idAutor=? WHERE idLibro=? and idAutor=?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, libroAutor.getIdLibro());
            ps.setInt(2, libroAutor.getIdAutor());
            ps.setInt(3, libroAutor.getIdLibro());
            ps.setInt(4, libroAutor.getIdAutor());
            ps.executeUpdate();
            System.out.println("DAO: Autor actualizado -> " + libroAutor);
        }
    }

    @Override
    public void deleteLibroAutor(int idLibro, int idAutor) throws Exception {
        String sql = "DELETE FROM LibroAutor WHERE idLibro=? and idAutor=?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idLibro);
            ps.setInt(2, idAutor);
            ps.executeUpdate();
            System.out.println("DAO: Autor eliminado (idLibro=" + idLibro + ", idAutor=" + idAutor + ")");
        }
    }
}
