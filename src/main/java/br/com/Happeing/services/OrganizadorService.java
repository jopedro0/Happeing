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
        if(organizadorRepository.existsById(organizador.getCnpj())) {
            throw new RuntimeException("cnpj já em uso");
        }
        if(organizador.getNome() == null){
            throw new RuntimeException("O nome esta vazio");
        }
        if (organizadorRepository.existsByEmail(organizador.getEmail())){
            throw new RuntimeException("Email já em uso");
        }
        return organizadorRepository.save(organizador);
    }

    public Organizador findById(String cnpj){
        var aux = organizadorRepository.findById(cnpj);
        if (aux.isEmpty()){
            throw new RuntimeException("Não existe um organizador cadastrada com este cnpj");
        }
        return aux.get();
    }

    public void delete(String id){
        organizadorRepository.deleteById(id);
    }

    public Organizador update(Organizador organizador, String cnpj){
        var aux = findById(cnpj);
        if (organizador.getNome() != null){
            aux.setNome(organizador.getNome());
        }
        if (organizador.getEmail() != null){
            aux.setEmail(organizador.getEmail());
        }
        if (organizador.getTelefone() != null){
            aux.setTelefone(organizador.getTelefone());
        }
        return organizadorRepository.save(aux);
    }

    public List<Organizador> findAll(){
        return organizadorRepository.findAll();
    }

}
