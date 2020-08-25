package ab.android.mycompteur;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    Button inc;
    Button dec;
    Button quit;
    TextView textToManip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {

            setContentView(R.layout.horizontal_main);

        } else {

            setContentView(R.layout.activity_main);

            textToManip = findViewById(R.id.textToManipulate);
            inc = findViewById(R.id.inc);
            dec = findViewById(R.id.dec);
            quit = findViewById(R.id.quit);

            if(savedInstanceState == null){
                textToManip.setText("0");
            }
            else{
                textToManip.setText(savedInstanceState.getString("value"));
            }


            inc.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int value = Integer.parseInt(textToManip.getText().toString());
                    value++;
                    textToManip.setText(Integer.toString(value));
                }
            }));

            dec.setOnClickListener(new OnCLickDecListener(textToManip));
        }



    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        //outState.putString("value", textToManip.getText().toString());
    }

    public void onClickButton(View v){
        finish();
    }
}