package ab.android.Mes_Contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;

public class AddActivity extends AppCompatActivity {

    ImageView iv;
    Bitmap currentBM;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_layout);

    }

    public void onClickValid(View view) {

        Intent intent = this.getIntent();
        EditText nameEd = findViewById(R.id.inputForName);
        EditText numEd = findViewById(R.id.inputForNumber);
        iv = findViewById(R.id.imageView);

        if(nameEd.getText().toString() != null && numEd.getText().toString() != null && imageUri != null){

            getApplicationContext().grantUriPermission(getCallingPackage(),
                    imageUri, Intent.FLAG_GRANT_READ_URI_PERMISSION);

            Personne p = new Personne(nameEd.getText().toString(), Integer.parseInt(numEd.getText().toString()), imageUri.toString());

            intent.putExtra("pers", p);

            setResult(RESULT_OK, intent);
        }
        else{
            setResult(RESULT_CANCELED, intent);
        }

        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 2 && resultCode == RESULT_OK){
            imageUri = data.getData();
            try {
                currentBM = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                ImageView iv = this.findViewById(R.id.imageView);
                iv.setImageBitmap(currentBM);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void onClickImage(View view){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery,2);
    }
}