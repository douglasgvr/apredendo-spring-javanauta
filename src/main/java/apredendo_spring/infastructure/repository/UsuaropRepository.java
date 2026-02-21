package apredendo_spring.infastructure.repository;

import apredendo_spring.infastructure.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuaropRepository extends JpaRepository<Usuario, Long> {
}
