package br.com.zup.ZupChat.service;

import br.com.zup.ZupChat.models.Contato;
import br.com.zup.ZupChat.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public Contato salvaContato(Contato contato){
        return contatoRepository.save(contato);
    }
}
