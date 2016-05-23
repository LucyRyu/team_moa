package team_project.team_moa.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import team_project.team_moa.R;

/**
 * Created by LUCY on 2016-05-09.
 */
public class FavoriteMemberFragment extends Fragment {
    public FavoriteMemberFragment() {
        // Required empty public constructor
    }

    // Array of strings storing country names
    String[] memberName = new String[] {
            "유저1",
            "유저2",
            "유저3",
            "유저4",
            "유저5"
    };

    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] img = new int[]{
            R.drawable.ic_profile,
            R.drawable.ic_profile,
            R.drawable.ic_profile,
            R.drawable.ic_profile,
            R.drawable.ic_profile
    };

    // Array of strings to store currencies
    String[] memberjob = new String[]{
            "Indian Rupee",
            "Pakistani Rupee",
            "Sri Lankan Rupee",
            "Renminbi",
            "korea"
    };

    int[] star = new int[]{
            R.drawable.e_star,
            R.drawable.e_star,
            R.drawable.e_star,
            R.drawable.e_star,
            R.drawable.e_star
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        /*
        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<10;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt", memberName[i]);
            hm.put("cur", memberjob[i]);
            hm.put("img", Integer.toString(img[i]) );
            hm.put("star", Integer.toString(star[i]) );
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "img","txt","cur","star" };

        // Ids of views in listview_layout
        int[] to = { R.id.user_Image,R.id.User_Name,R.id.User_job,R.id.favorite_bt};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        //SimpleAdapter adapter = new SimpleAdapter(getActivity(), aList, R.layout.fragment_favoritemember, from, to);

        // Getting a reference to listview of main.xml layout file
        ListView listView = (ListView) getActivity().findViewById(R.id.favoritelist);

        // Setting the adapter to the listView
        //listView.setAdapter(adapter);
        */
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favoritemember, container, false);


        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
