package com.example.blsoftprodutos.adapters;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.blsoftprodutos.R;
import com.example.blsoftprodutos.model.Produto;

import java.util.List;

public class AdapterListaProdutos extends BaseAdapter {

    private Context context;
    private List<Produto> produtoList;

    public AdapterListaProdutos(Context context, List<Produto> produtoList) {
        this.context = context;
        this.produtoList = produtoList;
    }

    @Override
    public int getCount() {
        return this.produtoList.size();
    }

    @Override
    public Object getItem(int posicao) {
        return this.produtoList.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return posicao;
    }

    public void removerProduto(int posicao){
        this.produtoList.remove(posicao);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int posicao, View convertView, ViewGroup parent) {

        View view = View.inflate(this.context, R.layout.layout_produto, null);

        TextView tvNomeProduto = (TextView) view.findViewById(R.id.tvNomeProduto);
        TextView tvPrecoProduto = (TextView) view.findViewById(R.id.tvPrecoProduto);
        TextView tvEstoqueProduto = (TextView) view.findViewById(R.id.tvEstoqueProduto);

        tvNomeProduto.setText(this.produtoList.get(posicao).getNome());
        tvPrecoProduto.setText(String.valueOf(this.produtoList.get(posicao).getPreco()));
        tvEstoqueProduto.setText(String.valueOf(this.produtoList.get(posicao).getQuantidadeEmEstoque()));
        return view;
    }
}
