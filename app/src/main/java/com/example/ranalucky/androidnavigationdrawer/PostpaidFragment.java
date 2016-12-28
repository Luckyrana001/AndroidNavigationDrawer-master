package com.example.ranalucky.androidnavigationdrawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Rana lucky on 12/14/2016.
 */

public class PostpaidFragment extends Fragment {

    public PostpaidFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.prepaid_tab_layout, container, false);
    }



    /**
     * @desc this is the fragment life cycle method , mainly used to initialize layout variables
     * @param   view - help in attaching the view to xml ids
     * @param  savedInstanceState :: is used to extract the value of objects from saved state if have any
     * @return null
     */
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initLayout(view);

        setValue();

    }

    private void setValue() {

    }

    private void initLayout(View view) {

    }

}
