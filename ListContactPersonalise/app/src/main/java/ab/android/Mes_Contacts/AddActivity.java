package ab.android.Mes_Contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_layout);

    }

    public void onClickValid(View view) {

        Intent intent = this.getIntent();
        EditText nameEd = findViewById(R.id.inputForName);
        EditText numEd = findViewById(R.id.inputForNumber);
        intent.putExtra("nom", nameEd.getText().toString());
        intent.putExtra("number", numEd.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}