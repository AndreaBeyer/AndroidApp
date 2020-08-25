package ab.android.Mes_Contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PersonneArrayAdapter extends ArrayAdapter<Personne> {

    private ArrayList<Personne> listPersonnes;

    public PersonneArrayAdapter(@NonNull Context context, ArrayList<Personne> listPersonnes) {
        super(context, R.layout.tiemperso, listPersonnes);
        this.listPersonnes = listPersonnes;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;

        if(v == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.tiemperso, null);
        }
        Personne myPersonne = (Personne) listPersonnes.get(position);

        if(myPersonne != null){
            TextView nomView  =(TextView) v.findViewById(R.id.contactNom);
            TextView prenomView  =(TextView) v.findViewById(R.id.contactPrenom);
            ImageView numView = (ImageView) v.findViewById(R.id.contactPhoto);

            if(nomView != null){
                nomView.setText("Nom : " + myPersonne.getNom());
            }

            if(prenomView != null){
                prenomView.setText("Numero : " + myPersonne.getNumero());
            }

            if(numView != null){
                numView.setImageDrawable(myPersonne.getPhoto());
            }
        }

        return v;
    }
}
