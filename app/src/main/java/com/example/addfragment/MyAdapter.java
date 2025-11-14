package com.example.addfragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        private String[] mDataset;

        public static class MyViewHolder  extends RecyclerView.ViewHolder {

            public TextView tvSubject, tvStarTime, tvDuration;
            public MyViewHolder(View v){
                super(v);
                tvSubject = v.findViewById(R.id.tvSubject);
                tvStarTime = v.findViewById(R.id.tvStarTime);
                tvDuration = v.findViewById(R.id.tvDuration);
            }


        }
        public MyAdapter(String[] myDataset){
            mDataset = myDataset;
        }

        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_row, parent, false);

            return new MyViewHolder(v);
        }

        public void onBindViewHolder(MyViewHolder holder, int position){
            holder..setText(mDataset[position]);
        }

        public int getItemCount(){
            return mDataset.length;
        }
    }

