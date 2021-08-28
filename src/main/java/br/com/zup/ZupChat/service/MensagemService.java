package br.com.zup.ZupChat.service;

import br.com.zup.ZupChat.models.Contato;
import br.com.zup.ZupChat.models.Mensagem;
import br.com.zup.ZupChat.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MensagemService {

    @Autowired
    private MensagemRepository mensagemRepository;

    @Autowired
    private EnviaMensagemFeign enviaMensagemFeign;

    public Mensagem insereMensagem(Mensagem mensagem){

        Contato contato = new Contato();
        contato.setEmail(mensagem.getDestino());
        mensagem.setContato(contato);

        return mensagemRepository.save(mensagem);
    }

    public Integer countMensagensPorEmail(String email){
        return mensagemRepository.countMensagemPorEmail(email);
    }

    public Mensagem marcaComoLidaMensagem(Long idMensagem){

        Optional<Mensagem> mensagemOptional = mensagemRepository.findById(idMensagem);

        if(mensagemOptional.isEmpty()){
            return null;
        }

        Mensagem mensagem = this.salvaMensagem(mensagemOptional.get());

        this.enviaMensagem(mensagem.getOrigem(), mensagem.getDestino());

        return mensagem;
    }

    private Mensagem salvaMensagem(Mensagem mensagem){
        mensagem.setLida(true);
        mensagem.setDataLeitura(LocalDateTime.now());
        return mensagemRepository.save(mensagem);
    }

    private void enviaMensagem(String origem, String destino){
        Mensagem mensagemClient = new Mensagem();
        mensagemClient.setOrigem("sistema@email.com");
        mensagemClient.setDestino(origem);
        mensagemClient.setMensagem(String.format("O {nomeDoDestino} leu sua mensagem. Talvez ele ignore ou não", destino));
        enviaMensagemFeign.enviaMensagem(mensagemClient);
    }
}
