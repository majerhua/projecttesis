package com.example.projecttesisii;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

public class AdapterListView extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context context;
    List<Producto> listProduct;

    public AdapterListView(Context context,List<Producto> pListProduct){
        this.context = context;
        this.listProduct = pListProduct;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent){

        final View vista = inflater.inflate(R.layout.row_listview,null);

        ImageView imgProduct = vista.findViewById(R.id.imgProduct);
        TextView txtNameProduct = vista.findViewById(R.id.txtNameProduct);
        TextView txtPriceProduct = vista.findViewById(R.id.txtPriceProduct);
        TextView txtPriceProductOferta = vista.findViewById(R.id.txtPriceProductOferta);

        txtNameProduct.setText(listProduct.get(i).getNombre());
        txtPriceProduct.setText("S/"+listProduct.get(i).getPrecio());
        txtPriceProductOferta.setText("S/"+listProduct.get(i).getPrecioOferta() +" (Oferta)");

        Picasso.with(context).load(listProduct.get(i).getUrl()).into(imgProduct);

        return vista;
    }

    @Override
    public int getCount(){
        return listProduct.size();
    }

    @Override
    public Object getItem(int position){
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


}
