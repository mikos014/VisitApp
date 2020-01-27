package wat.edu.pl.visitapp.control;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DataControl
{
    public int getSex(RadioGroup radioGroup, View view)
    {
        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = view.findViewById(radioButtonId);
        String radioButtonText = radioButton.getText().toString();

        if(radioButtonText.equals("Kobieta"))
            return 0;
        else
            return 1;
    }
}
