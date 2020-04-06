package com.example.blsoftprodutos.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.blsoftprodutos.R;
import com.example.blsoftprodutos.controller.ProdutoController;
import com.example.blsoftprodutos.dbHelper.ConexaoSQLite;
import com.example.blsoftprodutos.model.Produto;

public class ActivityProduto extends AppCompatActivity {

    private EditText edtIdProduto; // Código de barras do produto
    private EditText edtNomeProduto;
    private EditText edtQuantidadeProduto;
    private EditText edtPrecoProduto;
    private Button btnSalvarProduto;
    private Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        edtIdProduto = (EditText) findViewById(R.id.edtIdProduto);
        edtNomeProduto = (EditText) findViewById(R.id.edtNomeProduto);
        edtPrecoProduto = (EditText) findViewById(R.id.edtPrecoProduto);
        edtQuantidadeProduto = (EditText) findViewById(R.id.edtQuantidadeProduto);
        btnSalvarProduto = (Button) findViewById(R.id.btnCadastroProdutos);

        this.clickNoBotaoSalvarLinester();
    }

    public void clickNoBotaoSalvarLinester(){

    this.btnSalvarProduto.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Produto produtoACadastrar = getDadosProdutoFormulario();

            if(produtoACadastrar != null){

                ProdutoController produtoController = new ProdutoController(ConexaoSQLite.getInstancia(ActivityProduto.this));
                long idProduto = produtoController.salvarProdutoController(produtoACadastrar);

                if (idProduto > 0){
                    Toast.makeText(ActivityProduto.this, "Produto salvo com sucesso!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(ActivityProduto.this, "Produto não pode ser salvo!", Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(ActivityProduto.this, "Todos os campos são obrigatórios!", Toast.LENGTH_LONG).show();
            }
        }
    });

    }


    private Produto getDadosProdutoFormulario() {

        this.produto = new Produto();

        if (edtIdProduto.getText().toString().isEmpty() == false) {

            produto.setId(Integer.parseInt(edtIdProduto.getText().toString()));
        } else {
            return null;
        }

        if (edtNomeProduto.getText().toString().isEmpty() == false) {
            //Pode ser feito assim: this.edtNomeProduto.getText().toString.isEmpty == true

            produto.setNome(edtNomeProduto.getText().toString());
        } else {
            return null;
        }

        if (edtPrecoProduto.getText().toString().isEmpty() == false) {
            Double precoProduto = Double.parseDouble(edtPrecoProduto.getText().toString());
            produto.setPreco(precoProduto);
        } else {

            return null;
        }

        if (edtQuantidadeProduto.getText().toString().isEmpty() == false) {

            produto.setQuantidadeEmEstoque(Integer.parseInt(edtQuantidadeProduto.getText().toString()));
        } else {
            return null;
        }

        return produto;
    }
}
