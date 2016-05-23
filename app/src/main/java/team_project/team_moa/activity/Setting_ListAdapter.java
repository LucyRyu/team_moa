package team_project.team_moa.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by user on 2016-05-19.
 */
public class Setting_ListAdapter extends BaseAdapter {

    private Context mContext;

    private List<Setting_Item> mItems = new ArrayList<Setting_Item>();

    public Setting_ListAdapter(Context context) {
        mContext = context;
    }

    public void addItem(Setting_Item it) {
        mItems.add(it);
    }

    public void setListItems(List<Setting_Item> lit) {
        mItems = lit;
    }

    public int getCount() {
        return mItems.size();
    }

    public Object getItem(int position) {
        return mItems.get(position);
    }

    public boolean areAllItemsSelectable() {
        return false;
    }

    public boolean isSelectable(int position) {
        try {
            return mItems.get(position).isSelectable();
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Setting_View itemView;
        if (convertView == null) {
            itemView = new Setting_View(mContext, mItems.get(position));
        } else {
            itemView = (Setting_View) convertView;

            itemView.setIcon(mItems.get(position).getIcon());
            itemView.setText(0, mItems.get(position).getData(0));
            itemView.setText(1, mItems.get(position).getData(1));
            itemView.setText(2, mItems.get(position).getData(2));
        }

        return itemView;
    }

}
