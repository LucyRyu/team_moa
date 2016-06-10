package team_project.team_moa.activity;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import team_project.team_moa.R;

/**
 * Created by LUCY on 2016-06-05.
 */
public class Memberlist_DBAdapter extends CursorAdapter {

    public Memberlist_DBAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor){
        final ImageView user_image = (ImageView)view.findViewById(R.id.user_Image);
        final TextView user_name = (TextView)view.findViewById(R.id.User_Name);
        final TextView user_job = (TextView)view.findViewById(R.id.User_job);
        final ImageButton favorite_bt = (ImageButton)view.findViewById(R.id.favorite_bt);

        user_image.setImageResource(R.drawable.ic_profile);
        user_name.setText("이름:"+cursor.getString(cursor.getColumnIndex("name")));
        user_job.setText("담당:"+cursor.getString(cursor.getColumnIndex("PM")));
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.member_list, parent, false);
        return v;
    }
}
