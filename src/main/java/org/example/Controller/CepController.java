package org.example.Controller;

import org.example.Models.Endereco;
import org.example.Service.CepService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cep")
public class CepController {
    private final CepService cepService;
    public CepController(CepService cepService) {
        this.cepService = cepService;
    }
    @GetMapping("/{cep}")
    public Endereco buscarEndereco(@PathVariable String cep) {
        return cepService.buscarEnderecoPorCep(cep);
    }
}
