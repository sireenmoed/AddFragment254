package com.example.addfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;


public class AddTaskFragment extends Fragment {

    private EditText etTitle, etDes, etStart, etEnd, etDuration;
    private Button btnAdd;
    private FirebaseServices fbs;

    @Override
    public void onStart() {
        super.onStart();
        connectComponets();
    }

    private void connectComponets() {
        etTitle = getActivity().findViewById(R.id.etTitleTask);
        etDes = getActivity().findViewById(R.id.etDesTask);
        etStart = getActivity().findViewById(R.id.etStartTask);
        etEnd = getActivity().findViewById(R.id.etEndTask);
        etDuration = getActivity().findViewById(R.id.etDuration);
        btnAdd = getActivity().findViewById(R.id.btnAddAddTask);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title, des, start, end, dur;
                title = etTitle.getText().toString();
                des = etDes.getText().toString();
                start = etStart.getText().toString();
                end = etEnd.getText().toString();
                dur = etDuration.getText().toString();


                if (title.trim().isEmpty() || des.trim().isEmpty() || start.trim().isEmpty()
                        || end.trim().isEmpty() || dur.trim().isEmpty()) {
                    Toast.makeText(getActivity(), "some fields are empty!", Toast.LENGTH_SHORT).show();
                    return;
                }


                Task task = new Task(title, des, start, end, dur);

                // TODO: add to firebase firestore
                fbs.getFire().collection("tasks").add(task).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        gotoAllTasksFragment();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // TODO: toast message
                        Toast.makeText(getActivity(),"failed to add task", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_task, container, false);
    }

    private void gotoAllTasksFragment() {
        FragmentTransaction ft=getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main,new AllTaskFragment());
        ft.commit();

    }
}
