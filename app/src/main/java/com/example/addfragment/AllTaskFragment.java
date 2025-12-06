package com.example.addfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.RecoverySystem;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class AllTaskFragment extends Fragment {

    private RecyclerView rvAllTask;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_task, container, false);
    }

    FirebaseServices fbs;


    public ArrayList<Task> getTasks() {
        ArrayList<Task> tasks = new ArrayList<>();

        try {
            tasks.clear();
            fbs.getFire().collection("tasks")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull com.google.android.gms.tasks.Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    tasks.add(document.toObject(Task.class));
                                }

                                MyAdapter adapter = new MyAdapter(tasks);
                                rvAllTask.setAdapter(adapter);
                                //addUserToCompany(companies, user);
                            } else {
                                //Log.e("AllRestActivity: readData()", "Error getting documents.", task.getException());
                            }
                        }
                    });
        } catch (Exception e) {
            Log.e("getCompaniesMap(): ", e.getMessage());
        }

        return tasks;
    }
}