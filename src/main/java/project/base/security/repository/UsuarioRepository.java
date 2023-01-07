package project.base.security.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.base.security.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByEmail(String email);

    Usuario findByPasivoIsFalseAndActivoIsTrueAndEmail(String email);

    Page<Usuario> findAllByPasivoIsFalse(Pageable pageable);

    Usuario findByPasivoIsFalseAndActivoIsTrueAndTelefono(String phone);

    Usuario findByPasivoIsFalseAndId(Integer id);

    Usuario findByPasivoIsFalseAndActivoIsTrueAndTelefonoOrEmail(String phone, String email);

    @Query(value = "select id from usuario where pasivo = false and activo = true and id = ?1", nativeQuery = true)
    Integer obtenerId(Integer id);

    Usuario findByPasivoIsFalseAndActivoIsTrueAndId(Integer id);
}
