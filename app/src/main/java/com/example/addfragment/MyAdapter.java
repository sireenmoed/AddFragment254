package com.example.addfragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        private ArrayList<Task> mDataset;
        private Context context;
        private FirebaseServices fbs;
    private AdapterView.OnItemClickListener itemClickListener;


        public static class MyViewHolder  extends RecyclerView.ViewHolder {

            public TextView tvSubject, tvStarTime, tvDuration;
            public MyViewHolder(View v){
                super(v);
                tvSubject = v.findViewById(R.id.tvSubjectTaskRow);
                tvStarTime = v.findViewById(R.id.tvStarTime);
                tvDuration = v.findViewById(R.id.tvDuration);
            }


        }
        //public MyAdapter(ArrayList<Task> myDataset){
           // mDataset = myDataset;
        //}

        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_row, parent, false);

            return new MyViewHolder(v);
        }

        public void onBindViewHolder(MyViewHolder holder, int position){
            holder.tvSubject.setText(mDataset.get(position).getTitle());
            holder.tvStarTime.setText(mDataset.get(position).getStart());
            holder.tvDuration.setText(mDataset.get(position).getDur());
        }

        public int getItemCount() {
            return mDataset.size();
        }

    public MyAdapter(Context context, ArrayList<Task> mDataset) {
        this.context = context;
        this.mDataset = mDataset;
        this.fbs = FirebaseServices.getInstance();
        this.itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Bundle args = new Bundle();
                args.putParcelable("task", mDataset.get(position)); // or use Parcelable for better performance
                TaskDetailsFragment cd = new TaskDetailsFragment();
                cd.setArguments(args);
                FragmentTransaction ft= ((MainActivity)context).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.main,cd);
                ft.commit();
            }
            public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position){

                Task task= mDataset.get(position);


                holder.tvSubject.setText(task.getTitle());
                holder.tvStarTime.setText(task.getStart());
                holder.tvEndTime.setText(task.getEnd());
                holder.tvSubject.setOnClickListener(v -> {
                    if (itemClickListener != null) {
                        itemClickListener.onItemClick(position);
                    }
                });


        } ;


    };
    }}