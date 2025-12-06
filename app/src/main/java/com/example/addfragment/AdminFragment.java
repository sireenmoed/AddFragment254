package com.example.addfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class AdminFragment extends Fragment {

    private Button btnAllFragment, btnAddFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        init();
    }

    private void init() {
        btnAddFragment = getActivity().findViewById(R.id.btnAddFragment);
        btnAllFragment = getActivity().findViewById(R.id.btnAllFragment);
        btnAddFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: goto add fragment
            }
        });

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin, container, false);
    }

}