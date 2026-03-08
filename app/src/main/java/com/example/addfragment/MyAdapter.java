package com.example.addfragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        private ArrayList<Task> mDataset;
        private Context context;
        private FirebaseServices fbs;
    private MyAdapter.OnItemClickListener itemClickListener;


        public static class MyViewHolder  extends RecyclerView.ViewHolder {

            public TextView tvSubject, tvStarTime, tvDuration;
            public MyViewHolder(View v){
                super(v);
                tvSubject = v.findViewById(R.id.tvSubjectTaskRow);
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

        public int getItemCount() {
            return mDataset.size();
        }

    public MyAdapter(Context context, ArrayList<Task> mDataset) {
        this.context = context;
        this.mDataset = mDataset;
        this.fbs = FirebaseServices.getInstance();
        this.itemClickListener = new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                /*
                String selectedItem = filteredList.get(position).getNameCar();
                Toast.makeText(getActivity(), "Clicked: " + selectedItem, Toast.LENGTH_SHORT).show(); */
                Bundle args = new Bundle();
                args.putParcelable("task", MyAdapter.get(position)); // or use Parcelable for better performance
                TaskDetailsFragment cd = new TaskDetailsFragment();
                cd.setArguments(args);
                FragmentTransaction ft= ((MainActivity)context).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout,cd);
                ft.commit();
            }
        } ;
    }
    }

