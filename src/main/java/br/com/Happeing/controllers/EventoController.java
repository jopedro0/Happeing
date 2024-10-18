package br.com.Happeing.controllers;


import br.com.Happeing.models.Evento;
import br.com.Happeing.services.EventoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    private final EventoService service;

    public EventoController(EventoService service) {
        this.service = service;
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Evento> criar(@RequestBody Evento evento){
        var aux = service.save(evento);
        return ResponseEntity.ok(aux);
    }

    @GetMapping
    public ResponseEntity<List<Evento>> buscarTodos() {
        return ResponseEntity.ok(service.FindAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> buscarPorId(@PathVariable Long id) {
        var aux = service.findById(id);
        return ResponseEntity.ok(aux);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> atualizar(@PathVariable Long id, @RequestBody Evento evento) {
        var aux = service.update(evento, id);
        return ResponseEntity.ok(aux);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
