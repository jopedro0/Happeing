package br.com.Happeing.controllers;

import br.com.Happeing.models.Organizador;
import br.com.Happeing.services.OrganizadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizadores")
public class OrganizadorController {
    private final OrganizadorService service;

    public OrganizadorController(OrganizadorService service) {
        this.service = service;
    }

    @PostMapping("/organizadores")
    public ResponseEntity<Organizador> criar(@RequestBody Organizador organizador){
        var aux = service.save(organizador);
        return ResponseEntity.ok(aux);
    }

    @GetMapping
    public ResponseEntity<List<Organizador>> buscarTodos(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<Organizador> buscarPorCnpj(@PathVariable String cnpj){
        var aux = service.findByCnpj(cnpj);
        return ResponseEntity.ok(aux);
    }

    @PutMapping("/{cnpj}")
    public ResponseEntity<Organizador> atualizar(@PathVariable String cnpj, @RequestBody Organizador organizador){
        var aux = service.update(organizador, cnpj);
        return ResponseEntity.ok(aux);
    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity<Void> deletar(@PathVariable String cnpj){
        service.delete(cnpj);
        return ResponseEntity.noContent().build();
    }

}
