package com.rp4.evolucaodb.controller;

import com.rp4.evolucaodb.dto.CidadeNewDTO;
import com.rp4.evolucaodb.interfaces.ICidadeNewService;
import com.rp4.evolucaodb.interfaces.ICidadeService;
import com.rp4.evolucaodb.model.Cidade;
import com.rp4.evolucaodb.model_new.CidadeNew;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/Cidades")

@Api(value = "API Rest Cidades")

//Liberar todos domínios para acessar essa API
@CrossOrigin(origins = "*")
public class CidadeController {
    private ICidadeNewService cidadeNewService;
    private ICidadeService cidadeService;
    private List<CidadeNew> cidadesNew;
    private List<Cidade> cidades;

    public CidadeController(ICidadeService cidadeService, ICidadeNewService cidadeNewService) {
        this.cidadeNewService = cidadeNewService;
        this.cidadeService = cidadeService;
        this.cidades = pegarTodasCidades();
        this.cidadesNew = new ArrayList<>();

        for (Cidade cidade: cidades){
            transformObject(cidade);
        }
        salvarTodas(this.cidadesNew);

    }

    // Transformação do objeto
    public boolean transformObject(Cidade cidade){
        CidadeNew cidadeNew = new CidadeNew();
        try {
            cidadeNew = new CidadeNew();
            cidadeNew.setId(cidade.getId());
            cidadeNew.setDdd(cidade.getDdd());
            cidadeNew.setNome(cidade.getNome());
            this.cidadesNew.add(cidadeNew);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean salvarTodas(List<CidadeNew> cidadesNew){
        for (CidadeNew cidadeNew : cidadesNew){
            try{
                salvarCidade(cidadeNew);
            }catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }


    @PostMapping("/salvar")
    @ApiOperation(value = "Salvar uma cidade")
    public void salvarCidade(@RequestBody CidadeNew cidadeNew){
        cidadeNewService.saveCidade(cidadeNew);
    }

    @GetMapping("/todas/cidades")
    @ApiOperation(value = "Retorna uma lista de Cidades")
    public List<Cidade> pegarTodasCidades(){
        List<Cidade> cidades = cidadeService.findAllCidade();
        return cidades;
    }
}