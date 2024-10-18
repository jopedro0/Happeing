package br.com.Happeing.controllers;

import br.com.Happeing.models.Usuario;
import br.com.Happeing.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario){
        var aux = service.save(usuario);
        return ResponseEntity.ok(aux);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodos(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){
        var aux = service.findById(id);
        return ResponseEntity.ok(aux);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario){
        var aux = service.update(usuario, id);
        return ResponseEntity.ok(aux);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
