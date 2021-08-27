package br.com.zup.ZupChat.controller;

import br.com.zup.ZupChat.models.Mensagem;
import br.com.zup.ZupChat.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {

    @Autowired
    public MensagemService mensagemService;

    @PostMapping
    public Mensagem postMensagem(@RequestBody Mensagem mensagem){
        return mensagemService.insereMensagem(mensagem);
    }

}
