package ab.android.Mes_Contacts;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.location.LocationListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView maListe;
    ArrayList<Personne> mesContacts = new ArrayList<>();
    PersonneArrayAdapter paa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        maListe = (ListView) this.findViewById(R.id.myListView);

        mesContacts.add(new Personne("Pikachu", 25, "android.resource://"+BuildConfig.APPLICATION_ID+"/" +  R.drawable.pika));
        mesContacts.add(new Personne("Salameche", 4, "android.resource://"+BuildConfig.APPLICATION_ID+"/" + R.drawable.salameche));
        mesContacts.add(new Personne("Carapuce", 7, "android.resource://"+BuildConfig.APPLICATION_ID+"/" + R.drawable.carapuce));
        mesContacts.add(new Personne("Bulbizarre", 1, "android.resource://"+BuildConfig.APPLICATION_ID+"/" + R.drawable.bulbizarre));

        maListe.setAdapter(new PersonneArrayAdapter(this, mesContacts));
        paa = (PersonneArrayAdapter) maListe.getAdapter();
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
        boolean success = false;

        switch (item.getItemId()) {

            case R.id.copie:
                updateList();
                Toast.makeText(getApplicationContext(), "Copie réussie", Toast.LENGTH_SHORT).show();
                Personne personneACopier = paa.getItem(menuInfo.position);
                Personne personneCLone = new Personne(personneACopier);
                this.grantUriPermission("com.android.Mes_Contacts", Uri.parse(personneACopier.getPhoto()), Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);

                paa.add(personneCLone);
                updateList();

                success = true;
                break;

            case R.id.delete:
                Toast.makeText(getApplicationContext(), "Suppression effectuée", Toast.LENGTH_SHORT).show();
                Personne personneADlete = paa.getItem(menuInfo.position);
                paa.remove(personneADlete);
                updateList();
                success = true;
                break;

        }

        return success;
    }


    public void onClickAdd(View view) {
        startActivityForResult(new Intent(this, AddActivity.class), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK){
            Personne persToAdd = data.getParcelableExtra("pers");

            Personne p = new Personne(persToAdd);
            PersonneArrayAdapter paa = (PersonneArrayAdapter) maListe.getAdapter();
            paa.add(p);
            updateList();
        }
    }

    private void updateList(){

        mesContacts = new ArrayList<>();
        for(int i = 0; i < paa.getSize(); i++){
            mesContacts.add(paa.getItem(i));
        }
        paa.notifyDataSetChanged();
    }
}