package service;

import dao.UsuarioDAO;
import model.Usuario;

import java.util.List;

public class UsuarioService {
    private final UsuarioDAO usuarioDAO;

    public UsuarioService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public void registrarUsuario(String nombre) {
        try {
            Usuario usuario = new Usuario(0, nombre);
            usuarioDAO.addUsuario(usuario);
        } catch (Exception e) {
            System.err.println("Error al registrar usuario: " + e.getMessage());
        }
    }

    public List<Usuario> listarUsuarios() {
        try {
            return usuarioDAO.getAllUsuarios();
        } catch (Exception e) {
            System.err.println("Error al listar usuarios: " + e.getMessage());
            return List.of();
        }
    }

    public void cambiarNombre(int id, String nuevoNombre) {
        try {
            Usuario usuario = usuarioDAO.getUsuarioById(id);
            if (usuario != null) {
                usuario.setNombre(nuevoNombre);
                usuarioDAO.updateUsuario(usuario);
            } else {
                System.out.println("Service: No se encontró el usuario con id=" + id);
            }
        } catch (Exception e) {
            System.err.println("Error al actualizar usuario: " + e.getMessage());
        }
    }

    public void eliminarUsuario(int id) {
        try {
            usuarioDAO.deleteUsuario(id);
        } catch (Exception e) {
            System.err.println("Error al eliminar usuario: " + e.getMessage());
        }
    }
}
