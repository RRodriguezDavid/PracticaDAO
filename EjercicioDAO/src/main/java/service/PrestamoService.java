package service;

import dao.PrestamoDAO;
import model.Prestamo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PrestamoService {
    private final PrestamoDAO prestamoDAO;

    public PrestamoService(PrestamoDAO prestamoDAO) {
        this.prestamoDAO = prestamoDAO;
    }

    public void registrarPrestamo(int cantidadSemanas, int idUsuario, int idLibro) {
        try {
            Prestamo prestamo = new Prestamo(0, cantidadSemanas, idUsuario, idLibro);
            prestamoDAO.addPrestamo(prestamo);
        } catch (Exception e) {
            System.err.println("Error al registrar préstamo: " + e.getMessage());
        }
    }

    public List<Prestamo> listarPrestamos() {
        try {
            return prestamoDAO.getAllPrestamos();
        } catch (Exception e) {
            System.err.println("Error al listar préstamos: " + e.getMessage());
            return List.of();
        }
    }

    //Comprobar en el main que la fecha no sea menor a la fecha actual
    public void cambiarFechaFin(int id, String anyo, String mes, String dia) {
        try {
            Prestamo prestamo = prestamoDAO.getPrestamoById(id);
            if (prestamo != null) {
                int anno = Integer.parseInt(anyo);
                int mess = Integer.parseInt(mes);
                int diaa = Integer.parseInt(dia);
                LocalDate fechaActual = LocalDate.of(anno, mess, diaa);
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                String fechaActualizada = fechaActual.format(dateTimeFormatter);
                prestamo.setFechaFin(fechaActualizada);
                prestamoDAO.updatePrestamo(prestamo);
            } else {
                System.out.println("Service: No se encontró el préstamo con id=" + id);
            }
        } catch (Exception e) {
            System.err.println("Error al actualizar préstamo: " + e.getMessage());
        }
    }

    public void eliminarPrestamo(int id) {
        try {
            prestamoDAO.deletePrestamo(id);
        } catch (Exception e) {
            System.err.println("Error al eliminar préstamo: " + e.getMessage());
        }
    }
}