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
        if(evento.getNome() == null){
            throw new RuntimeException("evento sem nome definido");
        }
        if (evento.getDataEvento() == null){
            throw new RuntimeException("evento sem data definida");
        }
        if (evento.getEndereco() == null){
            throw new RuntimeException("evento sem endereço definido");
        }
        return eventoRepository.save(evento);
    }

    public Evento findById(Long id){
        var aux = eventoRepository.findById(id);
        if (aux.isEmpty()){
            throw new RuntimeException("esse evento não existe");
        }
        return aux.get();
    }

    public void delete(Long id){
        eventoRepository.deleteById(id);
    }

    public Evento update(Evento evento, Long id){
        var aux = findById(id);
        if ((evento.getEndereco() != null)){
            aux.setEndereco(evento.getEndereco());
        }
        if(evento.getDataEvento() != null){
            aux.setDataEvento(evento.getDataEvento());
        }
        if(evento.getNome() != null){
            aux.setNome(evento.getNome());
        }
        if(evento.getOrganizador() != null){
            aux.setOrganizador(evento.getOrganizador());
        }
        return eventoRepository.save(aux);
    }

    public List<Evento> FindAll(){
        return eventoRepository.findAll();
    }
}
