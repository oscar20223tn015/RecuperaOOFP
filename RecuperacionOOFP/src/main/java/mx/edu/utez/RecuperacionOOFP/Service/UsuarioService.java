package mx.edu.utez.RecuperacionOOFP.Service;

import mx.edu.utez.RecuperacionOOFP.Model.Usuario;
import mx.edu.utez.RecuperacionOOFP.Model.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario crearUsuario(Usuario usuario) {
        usuario.generarPasswordAleatoria();
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> obtenerUsuarioPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public Usuario actualizarUsuario(Long id, Usuario nuevoUsuario) {
        if (usuarioRepository.existsById(id)) {
            nuevoUsuario.setId(id);
            return usuarioRepository.save(nuevoUsuario);
        } else {
            throw new NoSuchElementException("Usuario no encontrado");
        }
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

}
