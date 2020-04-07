package com.example.blsoftprodutos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.blsoftprodutos.activities.ActivityProduto;
import com.example.blsoftprodutos.activities.ListarprodutoActivity;
import com.example.blsoftprodutos.controller.ProdutoController;
import com.example.blsoftprodutos.dbHelper.ConexaoSQLite;
import com.example.blsoftprodutos.model.Produto;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastroProdutos;
    private Button btnListarProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexaoSQLite conexaoSQLite = ConexaoSQLite.getInstancia(this);

        this.btnCadastroProdutos = (Button) findViewById(R.id.btnCadastroProdutos);
        this.btnListarProdutos = (Button) findViewById(R.id.btnListarProdutos);

        this.btnCadastroProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Executado ao clicar no botão

                //Intenção de mudar de activity
                Intent intent = new Intent(MainActivity.this, ActivityProduto.class);
                startActivity(intent);
            }
        });

        this.btnListarProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListarprodutoActivity.class);
                startActivity(intent);
            }
        });
    }
}
