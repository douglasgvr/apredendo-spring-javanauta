package apredendo_spring.business;

import apredendo_spring.infastructure.entity.Usuario;
import apredendo_spring.infastructure.exceptions.ConflictException;
import apredendo_spring.infastructure.exceptions.ResourceNotFoundException;
import apredendo_spring.infastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario salvaUsuario(Usuario usuario) {
        try{
            emailExiste(usuario.getEmail());
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            return usuarioRepository.save(usuario);
        } catch (ConflictException e) {
            throw new ConflictException("Email já cadastrado", e.getCause());
        }
    }

    public void emailExiste(String email) {
        try{
            boolean existe = usuarioRepository.existsByEmail(email);
            if(existe){
                throw new ConflictException("Email já cadastrado" + email);
            }
        } catch (ConflictException e) {
            throw new ConflictException("Email já cadastrado", e.getCause());
        }
    }

    public boolean verificarEmailExistente(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public Usuario buscaUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Email não encontrado" + email));
    }

    public void deletarUsuarioPorEmail(String email) {
        usuarioRepository.deleteByEmail(email);
    }

}
