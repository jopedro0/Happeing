package br.com.Happeing.services;


import br.com.Happeing.models.Evento;
import br.com.Happeing.repositories.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {
    private final EventoRepository eventoRepository;

    EventoService(EventoRepository eventoRepository){
        this.eventoRepository = eventoRepository;
    }

    public Evento save(Evento evento){
        return eventoRepository.save(evento);
    }

    public Evento findById(Long id){
        var aux = eventoRepository.findById(id);
        Evento evento = null;
        if (aux.isPresent()){
            evento = aux.get();
        }
        return evento;
    }

    public void delete(Long id){
        eventoRepository.deleteById(id);
    }

    public Evento update(Evento evento, Long id){
        var aux = findById(id);
        if (evento.getId() != null){
            aux.setId(evento.getId());
        }
        if(evento.getDataEvento() != null){
            aux.setDataEvento(evento.getDataEvento());
        }
        return eventoRepository.save(aux);
    }

    public List<Evento> FindAll(){
        return eventoRepository.findAll();
    }
}
