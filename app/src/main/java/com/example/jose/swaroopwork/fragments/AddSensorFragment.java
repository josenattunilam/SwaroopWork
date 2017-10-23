package com.example.jose.swaroopwork.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jose.swaroopwork.R;
import com.example.jose.swaroopwork.adapters.AddSensorAdapter;
import com.example.jose.swaroopwork.interfaces.CustomClickListner;
import com.example.jose.swaroopwork.model.SensorAdd;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddSensorFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddSensorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddSensorFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View mView;
    private RecyclerView recyclerViewAddSensor;
    private RecyclerView.LayoutManager mlayoutManager;
    List<SensorAdd> sensorAddList = new ArrayList<>();
    AddSensorAdapter addSensorAdapter ;

    private OnFragmentInteractionListener mListener;

    public AddSensorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddSensorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddSensorFragment newInstance(String param1, String param2) {
        AddSensorFragment fragment = new AddSensorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_add_sensor, container, false);
        initialise();
        sensorAddInit();
        return mView;
    }

    private void sensorAddInit() {
      SensorAdd  sensorAdd = new SensorAdd("first",1);
        sensorAddList.add(sensorAdd);
        sensorAdd = new SensorAdd("second",2);
        sensorAddList.add(sensorAdd);
        sensorAdd = new SensorAdd("Third",3);
        sensorAddList.add(sensorAdd);
        sensorAdd = new SensorAdd("Forth",4);
        sensorAddList.add(sensorAdd);
        sensorAdd = new SensorAdd("Fifth",5);
        sensorAddList.add(sensorAdd);
        sensorAdd = new SensorAdd("Sixth",6);
        sensorAddList.add(sensorAdd);
        sensorAdd = new SensorAdd("Seventh",7);
        sensorAddList.add(sensorAdd);
        addSensorAdapter.notifyDataSetChanged();
    }

    private void initialise() {
        recyclerViewAddSensor = (RecyclerView)mView.findViewById(R.id.recycler_add_sensor);
        mlayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerViewAddSensor.setLayoutManager(mlayoutManager);
        recyclerViewAddSensor.setHasFixedSize(true);
        addSensorAdapter = new AddSensorAdapter(new CustomClickListner() {
            @Override
            public void onItemClick(View v, int position) {


            }
        },sensorAddList,getActivity());
        recyclerViewAddSensor.setAdapter(addSensorAdapter);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
