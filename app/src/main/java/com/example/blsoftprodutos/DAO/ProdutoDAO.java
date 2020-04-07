package com.example.blsoftprodutos.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.blsoftprodutos.dbHelper.ConexaoSQLite;
import com.example.blsoftprodutos.model.Produto;

import java.util.ArrayList;
import java.util.List;

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

            long idProutoInserido = db.insert("produto", null, values);

            return idProutoInserido;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.close();
            }
        }

        return 0;
    }

    public List<Produto> getListaProdutosDAO() {

        List<Produto> listaProdutos = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor;

        String query = "SELECT * FROM produto;";

        try {
            db = this.conexaoSQLite.getReadableDatabase();
            cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()) {
                Produto produtoTemporario = null;
                do {
                    produtoTemporario = new Produto();
                    produtoTemporario.setId(cursor.getLong(0));
                    produtoTemporario.setNome(cursor.getString(1));
                    produtoTemporario.setQuantidadeEmEstoque(cursor.getInt(2));
                    produtoTemporario.setPreco(cursor.getDouble(3));

                    listaProdutos.add(produtoTemporario);

                }while (cursor.moveToNext());

            }


        } catch (Exception e) {
            Log.d("ERRO LISTA PRODUTOS", "Erro ao retornar os produtos");
            return null;

        } finally {
            if (db != null) {
                db.close();
            }
        }

        return listaProdutos;
    }
}
