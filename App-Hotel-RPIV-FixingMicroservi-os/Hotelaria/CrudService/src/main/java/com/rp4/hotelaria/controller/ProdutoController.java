package com.rp4.hotelaria.controller;

import com.rp4.hotelaria.dto.ProdutoDTO;

import com.rp4.hotelaria.interfaces.IProdutoService;
import com.rp4.hotelaria.model.Produto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/api/estoque")

    public class ProdutoController {
        private IProdutoService produtoService;

        @Autowired
        public ProdutoController(IProdutoService produto) { this.produtoService = produto;
        }

        @PostMapping("/salvar")
        @ApiOperation(value = "Salvar produto")
        public void saveEstoque(@RequestBody ProdutoDTO produtoDTO) {
            Produto produto = new Produto();
            produto.setId(produtoDTO.getId());
            produto.setNome(produtoDTO.getNome());
            produto.setQuantidade(produtoDTO.getQuantidade());
            produto.setValor(produtoDTO.getValor());

            produtoService.salvarProduto(produto);
        }

        @GetMapping("/produto/{id}")
        @ApiOperation(value = "Retornar produto")
        public ResponseEntity<?> pegarProdutoPeloId(@PathVariable("id") Long id) {
            Produto produto = produtoService.getProdutoById(id);
            return new ResponseEntity<>(produto, HttpStatus.OK);
        }

        @PutMapping("/produto/atualizar")
        @ApiOperation(value = "Atualizar Produto")
        public Produto atualizarProduto(@RequestBody Produto produto) {
            return produtoService.atualizarProduto(produto);
        }

        @DeleteMapping("/produto/excluir/{id}")
        @ApiOperation(value = "Deletar estoque")
        public void deleteProduto(@PathVariable("id") Long id) {
            produtoService.excluirProduto(id);
        }

        @GetMapping("/todos")
        @ApiOperation(value = "Retornar uma lista de produtos")
        public List<Produto> pegarTodosProdutos() {
            List<Produto> produtos = produtoService.pegarTodosProdutos();
            return produtos;
        }

    }

