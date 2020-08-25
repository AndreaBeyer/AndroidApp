package ab.android.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] myContact = new String[]{"Mon contact 1", "Mon contact 2", "Mon contact 1", "Mon contact 4"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, myContact);
        ListView list = (ListView) this.findViewById(R.id.myListView);
        list.setAdapter(arrayAdapter);
    }
}