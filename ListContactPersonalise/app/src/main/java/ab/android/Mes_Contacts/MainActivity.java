package ab.android.Mes_Contacts;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView maListe;
    ArrayList<Personne> mesContacts = new ArrayList<>();


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        maListe = (ListView) this.findViewById(R.id.myListView);

        mesContacts.add(new Personne("Pikachu", "025", this.getDrawable(R.drawable.pika)));
        mesContacts.add(new Personne("Salameche", "004", this.getDrawable(R.drawable.salameche)));
        mesContacts.add(new Personne("Carapuce", "007", this.getDrawable(R.drawable.carapuce)));
        mesContacts.add(new Personne("Bulbizarre", "001", this.getDrawable(R.drawable.bulbizarre)));

        maListe.setAdapter(new PersonneArrayAdapter(this, mesContacts));
        registerForContextMenu(maListe);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.pers_lv_context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        PersonneArrayAdapter paa = (PersonneArrayAdapter) maListe.getAdapter();

        boolean success = false;

        switch (item.getItemId()) {

            case R.id.copie:
                Toast.makeText(getApplicationContext(), "Copie: ID " + menuInfo.id + "Poition " + menuInfo.position, Toast.LENGTH_SHORT).show();
                Personne personneACopier = paa.getItem(menuInfo.position);
                Personne personneCLone = new Personne(personneACopier.getNom(), personneACopier.getNumero(), personneACopier.getPhoto());

                paa.add(personneCLone);
                paa.notifyDataSetChanged();
                success = true;
                break;

            case R.id.delete:
                Toast.makeText(getApplicationContext(), "Delete: ID " + menuInfo.id + "Poition " + menuInfo.position, Toast.LENGTH_SHORT).show();
                Personne personneADlete = paa.getItem(menuInfo.position);
                paa.remove(personneADlete);
                paa.notifyDataSetChanged();
                success = true;
                break;

        }

        return success;
    }


    public void onClickAdd(View view) {
        startActivityForResult(new Intent(this, AddActivity.class), 1);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK){
            Personne persToAdd= new Personne(data.getStringExtra("nom"), data.getStringExtra("number"), this.getDrawable(R.drawable.pika));
            PersonneArrayAdapter paa = (PersonneArrayAdapter) maListe.getAdapter();
            paa.add(persToAdd);
            paa.notifyDataSetChanged();
        }
    }
}