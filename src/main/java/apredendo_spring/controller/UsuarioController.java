package apredendo_spring.controller;

import apredendo_spring.business.UsuarioService;
import apredendo_spring.infastructure.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private UsuarioService usuarioService;

    @PostMapping
    public Usuario salvarUsuario(Usuario usuario) {
       return usuarioService.salvaUsuario(usuario);
    }
}
