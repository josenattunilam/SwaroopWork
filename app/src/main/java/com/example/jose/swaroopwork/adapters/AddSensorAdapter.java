package com.example.jose.swaroopwork.adapters;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.jose.swaroopwork.MainActivity;
import com.example.jose.swaroopwork.R;
import com.example.jose.swaroopwork.fragments.SaveSensorFragment;
import com.example.jose.swaroopwork.interfaces.CustomClickListner;
import com.example.jose.swaroopwork.model.SensorAdd;

import java.util.List;

/**
 * Created by HP on 23-10-2017.
 */

public class AddSensorAdapter extends RecyclerView.Adapter<AddSensorAdapter.MyViewHolder>{
    CustomClickListner clickListner;
    private List<SensorAdd> sensorAddList;
    Context mContext;
    SensorAdd sensorAdd;



    public AddSensorAdapter(CustomClickListner clickListner, List<SensorAdd> sensorAddList,Context mContext) {
        this.clickListner = clickListner;
        this.sensorAddList = sensorAddList;
        this.mContext = mContext;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout,parent,false);
        final MyViewHolder mViewholder = new MyViewHolder(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListner.onItemClick(v, mViewholder.getPosition());
            }
        });
        return mViewholder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position) {

         sensorAdd = sensorAddList.get(position);
        holder.id.setText(String.valueOf(sensorAdd.getSensorId()));
        holder.title.setText(sensorAdd.getSensorName());
        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragmentJump();

            }
        });

    }

    private void fragmentJump() {
        SaveSensorFragment  mFragment = new SaveSensorFragment();
        Bundle mBundle = new Bundle();
       /* mBundle.putParcelable("item_selected_key", position);
        mFragment.setArguments(mBundle);*/
        switchContent(R.id.container, mFragment);
    }

    public void switchContent(int id, Fragment fragment) {
        if (mContext == null)
            return;
        if (mContext instanceof MainActivity) {
            MainActivity mainActivity = (MainActivity) mContext;
            Fragment frag = fragment;
            mainActivity.switchContent(id, frag);
        }

    }

    @Override
    public int getItemCount() {
        return sensorAddList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title,id;
        private Button btnAdd;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.txt_card_sensor_name);
            id =(TextView)itemView.findViewById(R.id.txt_card_sensor_id);
            btnAdd =(Button)itemView.findViewById(R.id.btn_card_add);


        }
    }
}
