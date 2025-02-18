package wat.edu.pl.visitapp.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil
{
    public static void shortToast(Context context, String message)
    {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void longToast(Context context, String message)
    {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
