package br.com.zup.ZupChat.service;

import br.com.zup.ZupChat.models.Mensagem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "enviaMensagemClient", url = "${mensagem.url}")
public interface EnviaMensagemFeign {

    @PostMapping("/chat")
    Mensagem enviaMensagem(@RequestBody Mensagem mensagem);
}
