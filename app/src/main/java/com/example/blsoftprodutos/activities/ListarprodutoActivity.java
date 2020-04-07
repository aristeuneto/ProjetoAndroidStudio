package com.example.blsoftprodutos.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.blsoftprodutos.R;
import com.example.blsoftprodutos.adapters.AdapterListaProdutos;
import com.example.blsoftprodutos.controller.ProdutoController;
import com.example.blsoftprodutos.dbHelper.ConexaoSQLite;
import com.example.blsoftprodutos.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ListarprodutoActivity extends AppCompatActivity {

    private ListView lvsProdutos;
    private List<Produto> produtoList;
    private AdapterListaProdutos adapterListaProdutos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listarproduto);

        //TODO buscar os produtos do banco
        ProdutoController produtoController = new ProdutoController(ConexaoSQLite.getInstancia(ListarprodutoActivity.this));
        produtoList = produtoController.getListaProdutosController();


     //   this.produtoList = new ArrayList<>();

        this.lvsProdutos = (ListView) findViewById(R.id.lsvProdutos);
        this.adapterListaProdutos  = new AdapterListaProdutos(ListarprodutoActivity.this, this.produtoList);
        this.lvsProdutos.setAdapter(this.adapterListaProdutos);
    }
}
