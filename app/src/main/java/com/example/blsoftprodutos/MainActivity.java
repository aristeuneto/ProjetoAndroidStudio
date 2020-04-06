package com.example.blsoftprodutos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.blsoftprodutos.activities.ActivityProduto;
import com.example.blsoftprodutos.controller.ProdutoController;
import com.example.blsoftprodutos.dbHelper.ConexaoSQLite;
import com.example.blsoftprodutos.model.Produto;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastroProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexaoSQLite conexaoSQLite = ConexaoSQLite.getInstancia(this);
/*
        //Produto na mão
        Produto produto1 = new Produto();
        produto1.setId(12346);
        produto1.setNome("Computador");
        produto1.setQuantidadeEmEstoque(2);
        produto1.setPreco(1500);

        ProdutoController produtoController = new ProdutoController(conexaoSQLite);
        long resultado = produtoController.salvarProdutoController(produto1);
        System.out.println("O resultado é: " + resultado);*/


        this.btnCadastroProdutos = (Button) findViewById(R.id.btnCadastroProdutos);

        this.btnCadastroProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Executado ao clicar no botão

                //Intenção de mudar de activity
                Intent intent = new Intent(MainActivity.this, ActivityProduto.class);
                startActivity(intent);
            }
        });
    }
}
