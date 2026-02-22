package apredendo_spring.business;

import apredendo_spring.infastructure.entity.Usuario;
import apredendo_spring.infastructure.exceptions.ConflictException;
import apredendo_spring.infastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuaropRepository;

    public Usuario salvaUsuario(Usuario usuario) {
        try{
            emailExiste(usuario.getEmail());
            return usuaropRepository.save(usuario);
        } catch (ConflictException e) {
            throw new ConflictException("Email já cadastrado", e.getCause());
        }
    }

    public void emailExiste(String email) {
        try{
            boolean existe = usuaropRepository.existsByEmail(email);
            if(!existe){
                throw new ConflictException("Email já cadastrado" + email);
            }
        } catch (ConflictException e) {
            throw new ConflictException("Email já cadastrado", e.getCause());
        }
    }

    public boolean verificarEmailExistente(String email) {
        return usuaropRepository.existsByEmail(email);
    }

}
