package ifrs.com.br.aula.repository;

import ifrs.com.br.aula.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
