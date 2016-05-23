package team_project.team_moa.activity;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;

import team_project.team_moa.R;

/**
 * Created by user on 2015-12-11.
 */
public class CustomProgressDialog extends Dialog {
    public CustomProgressDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //
        setContentView(R.layout.custom_progress_dialog);
    }
}
