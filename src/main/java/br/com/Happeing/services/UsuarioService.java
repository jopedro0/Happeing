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
        if (usuarioRepository.existsByEmail(usuario.getEmail())){
            throw new RuntimeException("Email já cadastrado");
        }
        if(usuario.getNome() == null){
            throw new RuntimeException("O nome está vazio");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario findById(Long id){
        var aux = usuarioRepository.findById(id);
        if(aux.isEmpty()){
            throw new RuntimeException("Esse usuário não existe ");
        }
        return aux.get();

    }


    public void delete(Long id){
        usuarioRepository.deleteById(id);
    }

    public Usuario update(Usuario usuario, Long id){
        var aux = findById(id);
        if (usuario.getNome() != null){
            aux.setNome(usuario.getNome());
        }
        if(usuario.getEndereco() != null) {
            aux.setEndereco(usuario.getEndereco());
        }
        return usuarioRepository.save(aux);
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

}
