package br.com.zup.ZupChat.controller;

import br.com.zup.ZupChat.models.Contato;
import br.com.zup.ZupChat.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping
    public Contato criaContato(@Valid @RequestBody Contato contato){
        return contatoService.salvaContato(contato);
    }
}
