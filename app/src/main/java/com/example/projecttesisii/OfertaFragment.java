package com.example.projecttesisii;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OfertaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OfertaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OfertaFragment() {
        // Required empty public constructor
    }

    public static OfertaFragment newInstance(String param1, String param2) {
        OfertaFragment fragment = new OfertaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private ListView listProductOnSale;
    FirebaseDatabase rootNode;
    DatabaseReference referenceCat,referenceProduct;
    List<Producto> listProduct = new ArrayList<Producto>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_oferta, container, false);
        listProductOnSale = v.findViewById(R.id.listProductOnSale);

        rootNode = FirebaseDatabase.getInstance();
        referenceCat = rootNode.getReference().child("Categorias");
        referenceProduct = rootNode.getReference().child("Ofertas");

        final AdapterListView adapter = new AdapterListView(getContext(),listProduct);

        listProductOnSale.setAdapter(adapter);
        System.out.println("OFerta");
        referenceCat.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){

                    Categoria categoria =  snapshot.getValue(Categoria.class);

                    if(categoria.getEstado().equals("1")){

                        final String categoriaId = categoria.getId();

                        referenceProduct.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                listProduct.clear();
                                for(DataSnapshot snapshot: dataSnapshot.getChildren()){

                                    Producto producto =  snapshot.getValue(Producto.class);

                                    if(producto.getCategoriaId().equals(categoriaId)){
                                        listProduct.add(producto);
                                    }
                                }

                                adapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                        break;
                    }
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });


        return v;
    }

    public interface OnFragmentInteractionListener {
    }
}