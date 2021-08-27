package br.com.zup.ZupChat.service;

import br.com.zup.ZupChat.models.Mensagem;
import br.com.zup.ZupChat.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {

    @Autowired
    private MensagemRepository mensagemRepository;

    public Mensagem insereMensagem(Mensagem mensagem){
        return mensagemRepository.save(mensagem);
    }
}
