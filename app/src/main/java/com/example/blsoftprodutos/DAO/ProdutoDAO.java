package com.example.blsoftprodutos.DAO;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.blsoftprodutos.dbHelper.ConexaoSQLite;
import com.example.blsoftprodutos.model.Produto;

public class ProdutoDAO {

    private final ConexaoSQLite conexaoSQLite;

    public ProdutoDAO(ConexaoSQLite conexaoSQLite) {
        this.conexaoSQLite = conexaoSQLite;
    }

    public long salvarProdutoDAO(Produto produto) {

        SQLiteDatabase db = conexaoSQLite.getWritableDatabase();

        try {

            ContentValues values = new ContentValues();
            values.put("id", produto.getId());
            values.put("nome", produto.getNome());
            values.put("quantidade_em_estoque", produto.getQuantidadeEmEstoque());
            values.put("preco", produto.getPreco());

            long idProutoInserido =  db.insert("produto", null, values);

            return idProutoInserido;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
