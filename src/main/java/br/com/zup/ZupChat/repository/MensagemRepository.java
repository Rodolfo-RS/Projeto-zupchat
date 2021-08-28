package br.com.zup.ZupChat.repository;

import br.com.zup.ZupChat.models.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long> {

    @Query("SELECT COUNT(msg) FROM Mensagem msg LEFT JOIN msg.contato contato WHERE contato.email = :email")
    Integer countMensagemPorEmail(@Param("email") String email);
}
