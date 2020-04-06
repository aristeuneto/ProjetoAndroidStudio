package com.example.blsoftprodutos.controller;

import com.example.blsoftprodutos.DAO.ProdutoDAO;
import com.example.blsoftprodutos.dbHelper.ConexaoSQLite;
import com.example.blsoftprodutos.model.Produto;

public class ProdutoController {

    private final ProdutoDAO produtoDAO;

    public ProdutoController(ConexaoSQLite conexaoSQLite) {
        produtoDAO = new ProdutoDAO(conexaoSQLite);
    }

    public long salvarProdutoController(Produto produto) {
        return this.produtoDAO.salvarProdutoDAO(produto);

    }
}
