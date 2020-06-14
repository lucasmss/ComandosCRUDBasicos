package com.lucas.projetocrud.controller;

import com.lucas.projetocrud.model.Produto;
import com.lucas.projetocrud.model.User;
import com.lucas.projetocrud.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> findALL(){

        List<Produto> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/{codigo}")
    public ResponseEntity<Optional<Produto>> findById(@PathVariable Integer codigo){

        Optional<Produto> produto = service.findById(codigo);

        return ResponseEntity.ok().body(produto);

    }

    @PostMapping
    public ResponseEntity<Produto> addProduto(@RequestBody Produto produto){

        Produto produtos = service.addProd(produto);

        return ResponseEntity.ok().body(produtos);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Produto> updateProduto(@RequestBody Produto produtos, @PathVariable Integer codigo){

        service.update(codigo, produtos);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Produto> delete(@PathVariable Integer codigo){

        service.delete(codigo);

        return ResponseEntity.noContent().build();
    }

}
