package br.com.Happeing.services;


import br.com.Happeing.models.Usuario;
import br.com.Happeing.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario findById(Long id){
        var aux = usuarioRepository.findById(id);
        Usuario usuario = null;
        if(aux.isPresent()){
            usuario = aux.get();
        }
        return usuario;

    }


    public void delete(Long id){
        usuarioRepository.deleteById(id);
    }

    public Usuario update(Usuario usuario, Long id){
        var aux = findById(id);
        if (usuario.getId() != null){
            aux.setId(usuario.getId());
        }
        if (usuario.getNome() != null){
            aux.setNome(usuario.getNome());
        }
        if (usuario.getEmail() != null){
            aux.setEmail(usuario.getEmail());
        }
        return usuarioRepository.save(aux);
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

}
