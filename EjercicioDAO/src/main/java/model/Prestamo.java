package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Prestamo {
    private int id;
    private String fechaInicio;
    private String fechaFin; //reciba un int indicando las semanas
    private int idUsuario;
    private int idLibro;

    public Prestamo() {}
    public Prestamo(int id, int cantidadSemanasPrestamo, int idUsuario, int idLibro) {
        this.id = id;
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        this.fechaInicio = fechaActual.format(dateTimeFormatter);
        this.fechaFin = fechaActual.plusWeeks(cantidadSemanasPrestamo).format(dateTimeFormatter);
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String toString() {
        return "ID=" + id + ", FechaInicio='" + fechaInicio + "' FechaFin='" + fechaFin + "' idUsuario=" + idUsuario + " idLibro=" + idLibro;
    }
}
