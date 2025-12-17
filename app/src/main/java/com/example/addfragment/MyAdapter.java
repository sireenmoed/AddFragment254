package com.example.addfragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        private ArrayList<Task> mDataset;

        public static class MyViewHolder  extends RecyclerView.ViewHolder {

            public TextView tvSubject, tvStarTime, tvDuration;
            public MyViewHolder(View v){
                super(v);
                tvSubject = v.findViewById(R.id.tvSubject);
                tvStarTime = v.findViewById(R.id.tvStarTime);
                tvDuration = v.findViewById(R.id.tvDuration);
            }


        }
        public MyAdapter(ArrayList<Task> myDataset){
            mDataset = myDataset;
        }

        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_row, parent, false);

            return new MyViewHolder(v);
        }

        public void onBindViewHolder(MyViewHolder holder, int position){
            holder.tvSubject.setText(mDataset.get(position).getTitle());
            holder.tvStarTime.setText(mDataset.get(position).getStart());
            holder.tvDuration.setText(mDataset.get(position).getDur());
        }

        public int getItemCount(){
            return mDataset.size();
        }
    }

