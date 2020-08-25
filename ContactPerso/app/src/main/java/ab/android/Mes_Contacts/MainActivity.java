package ab.android.Mes_Contacts;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView maListe = (ListView) this.findViewById(R.id.myListView);
        ArrayList<Personne> mesContacts = new ArrayList<>();

        mesContacts.add(new Personne("Pikachu", "025", this.getDrawable(R.drawable.pika)));
        mesContacts.add(new Personne("Salameche", "004", this.getDrawable(R.drawable.salameche)));
        mesContacts.add(new Personne("Carapuce", "007", this.getDrawable(R.drawable.carapuce)));
        mesContacts.add(new Personne("Bulbizarre", "001", this.getDrawable(R.drawable.bulbizarre)));

        maListe.setAdapter(new PersonneArrayAdapter(this, mesContacts));
    }
}