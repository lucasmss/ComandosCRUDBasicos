package com.lucas.projetocrud.service;

import com.lucas.projetocrud.model.Produto;
import com.lucas.projetocrud.model.User;
import com.lucas.projetocrud.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repo;

    public List<Produto> findAll(){

        return repo.findAll();
    }

    public Optional<Produto> findById(Integer codigo) {

        Optional<Produto> produto = repo.findById(codigo);

        return produto;
    }

    public Produto addProd(Produto produto){

        return repo.save(produto);
    }

    public Produto update(Integer codigo, Produto produto){

        findById(codigo);

        return repo.save(produto);
    }

    public void delete(Integer codigo){

        findById(codigo);

        repo.deleteById(codigo);
    }

}
