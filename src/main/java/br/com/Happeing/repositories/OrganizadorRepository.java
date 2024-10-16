package br.com.Happeing.repositories;

import br.com.Happeing.models.Organizador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizadorRepository extends JpaRepository<Organizador, String> {
    boolean existsByEmail(String email);
}
