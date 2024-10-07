package br.com.Happeing.services;

import br.com.Happeing.models.Organizador;
import br.com.Happeing.repositories.OrganizadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizadorService {
    private final OrganizadorRepository organizadorRepository;

    OrganizadorService(OrganizadorRepository organizadorRepository){
        this.organizadorRepository = organizadorRepository;
    }

    public Organizador save(Organizador organizador){
        return organizadorRepository.save(organizador);
    }

    public Organizador findById(String cnpj){
        var aux = organizadorRepository.findById(cnpj);
        Organizador organizador = null;
        if (aux.isPresent()){
            organizador = aux.get();
        }
        return organizador;
    }

    public void delete(String id){
        organizadorRepository.deleteById(id);
    }

    public Organizador update(Organizador organizador, String cnpj){
        var aux = findById(cnpj);
        if (organizador.getCnpj() != null){
            aux.setCnpj(organizador.getCnpj());
        }
        if (organizador.getNome() != null){
            aux.setNome(organizador.getNome());
        }
        if (organizador.getEmail() != null){
            aux.setEmail(organizador.getEmail());
        }
        return organizadorRepository.save(aux);
    }

    public List<Organizador> findAll(){
        return organizadorRepository.findAll();
    }

}
