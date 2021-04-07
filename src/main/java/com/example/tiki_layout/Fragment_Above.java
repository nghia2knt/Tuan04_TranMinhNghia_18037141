package com.example.tiki_layout;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Above#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Above extends Fragment {
    private int qualify;
    SendingData sendingData;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        sendingData = (SendingData) context;
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_Above() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Above.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Above newInstance(String param1, String param2) {
        Fragment_Above fragment = new Fragment_Above();
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

        View view= inflater.inflate(R.layout.fragment__above, container, false);
        ImageView imgAdd= view.findViewById(R.id.imgAdd);
        ImageView imgDec= view.findViewById(R.id.imgDec);
        final TextView tvQualify = view.findViewById(R.id.tvQualify);
        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qualify++;
                tvQualify.setText(String.valueOf(qualify));
                sendingData.sendData(String.valueOf(qualify));
            }
        });
        imgDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (qualify>0) qualify--;
                tvQualify.setText(String.valueOf(qualify));
                sendingData.sendData(String.valueOf(qualify));
            }
        });
        return view;
    }
}