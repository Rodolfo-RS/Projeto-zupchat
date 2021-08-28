package br.com.zup.ZupChat.controller;

import br.com.zup.ZupChat.models.Mensagem;
import br.com.zup.ZupChat.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class MensagemController {

    @Autowired
    public MensagemService mensagemService;

    @PostMapping("/chat")
    public Mensagem postMensagem(@RequestBody Mensagem mensagem){
        return mensagemService.insereMensagem(mensagem);
    }

    @GetMapping("/usuario/perfil/{emailUsuario}")
    public Integer countMensagensPorEmail(@PathVariable("emailUsuario") String email){
        return mensagemService.countMensagensPorEmail(email);
    }

    @PatchMapping("/ler/{idMensagem}")
    public Mensagem marcaComoLidaMensagem(@PathVariable("idMensagem") Long idMensagem){
        return mensagemService.marcaComoLidaMensagem(idMensagem);
    }

}
