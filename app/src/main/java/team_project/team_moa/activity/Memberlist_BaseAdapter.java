package team_project.team_moa.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import team_project.team_moa.R;

/**
 * Created by LUCY on 2016-06-05.
 */
@SuppressLint("ViewHolder")
public class Memberlist_BaseAdapter extends BaseAdapter{
    public Context context;
    ArrayList<Memberlist_GetSet> MemberList;

    public Memberlist_BaseAdapter(Context context, ArrayList<Memberlist_GetSet> MemberList){
        this.context = context;
        this.MemberList = MemberList;
    }

    @Override
    public int getCount(){
        return MemberList.size();
    }

    @Override
    public Object getItem(int position){
        return MemberList.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = null;
        int row = 0;
        if(convertView == null){
            row = R.layout.member_list;
        }
        convertView = inflater.inflate(row, parent, false);

        ImageView Member_user_image = (ImageView)convertView.findViewById(R.id.user_Image);
        TextView Member_user_name = (TextView)convertView.findViewById(R.id.User_Name);
        TextView Member_user_job = (TextView)convertView.findViewById(R.id.User_job);
        ImageButton Favorite_button = (ImageButton)convertView.findViewById(R.id.favorite_bt);

        Member_user_name.setText(MemberList.get(position).getName());
        Member_user_job.setText(MemberList.get(position).getDevel());

        return convertView;
    }
}
