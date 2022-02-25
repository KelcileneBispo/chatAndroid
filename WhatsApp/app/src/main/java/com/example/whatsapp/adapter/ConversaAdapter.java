package com.example.whatsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.whatsapp.R;
import com.example.whatsapp.model.Conversa;

import java.util.ArrayList;

public class ConversaAdapter extends ArrayAdapter<Conversa> {

    private ArrayList<Conversa> conversas;
    private Context context;

    public ConversaAdapter(@NonNull Context c,@NonNull ArrayList<Conversa> objects) {
        super(c,0, objects);
        this.context = c;
        this.conversas = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = null;

        //Verifica se a lista esta preenchida
        if(conversas != null){

            //inicializa objeto para a montagem da view
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            //Monta view a partir do xml
            view = inflater.inflate(R.layout.lista_conversas, parent, false);

            //Recuperar elemento para exibicao
            TextView nome = view.findViewById(R.id.tv_titulo);
            TextView ultraMensagem = view.findViewById(R.id.tv_subtitulo);

            Conversa conversa = conversas.get(position);
            nome.setText(conversa.getNome());
            ultraMensagem.setText(conversa.getMensagem());
        }
        return view;
    }
}
