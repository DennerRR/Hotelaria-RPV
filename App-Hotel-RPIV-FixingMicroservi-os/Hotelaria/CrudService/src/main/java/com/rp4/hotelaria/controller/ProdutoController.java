package com.rp4.hotelaria.controller;

import com.rp4.hotelaria.interfaces.IProdutoService;
import com.rp4.hotelaria.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
/*@RestController
@RequestMapping("/api/estoque")*/

public class ProdutoController {

   @Autowired
   private IProdutoService produtoService;

   @RequestMapping(value = "/salvarProduto", method = RequestMethod.GET)
    public String form(){
       return "/produtos/formProduto";
    }

    @RequestMapping(value = "/salvarProduto", method = RequestMethod.POST)
    public String form(Produto produto){
       produtoService.salvarProduto(produto);
        return "redirect:/verProdutos";
    }

    @RequestMapping(value = "/verProdutos")
    public ModelAndView listaProdutos(){
        ModelAndView mv = new ModelAndView("produtos/produto");
        Iterable<Produto> produtos = produtoService.pegarTodosProdutos();
        mv.addObject("produto",produtos);
        return mv;
    }

        @Autowired
        public ProdutoController(IProdutoService produto) { this.produtoService = produto;
        }

        /*@GetMapping("/produto/{id}")
        @ApiOperation(value = "Retornar produto")
        public ResponseEntity<?> pegarProdutoPeloId(@PathVariable("id") Long id) {
            Produto produto = produtoService.getProdutoById(id);
            return new ResponseEntity<>(produto, HttpStatus.OK);
        }*/

        @RequestMapping("/deletarProdutos")
        public String deleteProduto(@PathVariable("id") long id){
            Produto produto = produtoService.getProdutoById(id);
            produtoService.excluirProduto(id);
            return "redirect:/verProdutos";

        }
        /*@PutMapping("/produto/atualizar")
        @ApiOperation(value = "Atualizar Produto")
        public Produto atualizarProduto(@RequestBody Produto produto) {
            return produtoService.atualizarProduto(produto);
        }

        @DeleteMapping("/produto/excluir/{id}")
        @ApiOperation(value = "Deletar estoque")
        public void deleteProduto(@PathVariable("id") Long id) {
            produtoService.excluirProduto(id);
        }
*/
        /*@GetMapping("/todos")
        @ApiOperation(value = "Retornar uma lista de produtos")
        public List<Produto> pegarTodosProdutos() {
            List<Produto> produtos = produtoService.pegarTodosProdutos();
            return produtos;
        }*/

    }

