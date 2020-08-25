package ab.android.mycompteur;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class OnCLickDecListener implements View.OnClickListener {

    TextView textToManip;

    public OnCLickDecListener(TextView _textToManip){
        textToManip = _textToManip;
    }
    @Override
    public void onClick(View view) {
        int value = Integer.parseInt(textToManip.getText().toString());
        value--;
        textToManip.setText(Integer.toString(value));
    }
}
