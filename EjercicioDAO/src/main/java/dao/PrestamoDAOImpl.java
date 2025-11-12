package dao;


import model.Prestamo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class PrestamoDAOImpl implements PrestamoDAO {

    @Override
    public void addPrestamo(Prestamo prestamo) throws Exception {
        String sql = "INSERT INTO Prestamo (titulo) VALUES (?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, prestamo.getFechaInicio());
            ps.setString(2, prestamo.getFechaFin());
            ps.setInt(3, prestamo.getIdUsuario());
            ps.setInt(4, prestamo.getIdLibro());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) prestamo.setId(rs.getInt(1));
            }

            System.out.println("DAO: Libro insertado -> " + prestamo);
        }
    }

    @Override
    public List<Prestamo> getAllPrestamos() throws Exception {
        return List.of();
    }

    @Override
    public Prestamo getPrestamoById(int id) throws Exception {
        return null;
    }

    @Override
    public void updatePrestamo(Prestamo prestamo) throws Exception {

    }

    @Override
    public void deletePrestamo(int id) throws Exception {

    }
}

