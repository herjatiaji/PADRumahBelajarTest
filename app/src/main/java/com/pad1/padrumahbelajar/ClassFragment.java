package com.pad1.padrumahbelajar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pad1.padrumahbelajar.databinding.FragmentClassBinding;
import com.pad1.padrumahbelajar.kelas.KelasAdapter;
import com.pad1.padrumahbelajar.model.KelasData;
import com.pad1.padrumahbelajar.model.KelasResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ClassFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private FragmentClassBinding binding;
    FloatingActionButton fab, fabAddClass;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;
    boolean isOpen = false;
    Button btn;
    BaseApiService mApiService;
//    KelasData kelas;
    RecyclerView recyclerView;
    KelasAdapter kelasAdapter;


    private String mParam1;
    private String mParam2;

    public ClassFragment() {
        // Required empty public constructor
    }

    public static ClassFragment newInstance(String param1, String param2) {
        ClassFragment fragment = new ClassFragment();
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

    private void animateFab(){
        if(isOpen){
            fab.startAnimation(rotateBackward);
            fabAddClass.startAnimation(fabClose);
            fabAddClass.setClickable(false);
            isOpen = false;

        }
        else{
            fab.startAnimation(rotateForward);
            fabAddClass.startAnimation(fabOpen);
            fabAddClass.setClickable(true);
            isOpen = true;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        return inflater.inflate(R.layout.fragment_class, container, false);

        binding = FragmentClassBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = root.findViewById(R.id.rv_kelas);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        btn = root.findViewById(R.id.btn);
        fab = root.findViewById(R.id.fab);
        fabAddClass = root.findViewById(R.id.fabAddClass);

        fabOpen = AnimationUtils.loadAnimation(getContext(),R.anim.tab_open);
        fabClose = AnimationUtils.loadAnimation(getContext(),R.anim.tab_close);

        rotateForward = AnimationUtils.loadAnimation(getContext(),R.anim.rotate_forward);
        rotateBackward = AnimationUtils.loadAnimation(getContext(),R.anim.rotate_backward);

        mApiService.kelasRequest()
                .enqueue(new Callback<KelasResponse>() {
                    @Override
                    public void onResponse(Call<KelasResponse> call, Response<KelasResponse> response) {
                        if (response.isSuccessful()) {
//                            loading.dismiss();
                            KelasResponse kelasResponse = response.body();
                            ArrayList<KelasData> kelasData = kelasResponse.getData();
                            List<KelasData> listKelas = new ArrayList<>();
                            Log.e("getSuccess", "onFailure: ERROR > " + kelasResponse.getStatus().toString());
                            for (int i = 0; i<kelasData.size();i++){
                                KelasData kelass = kelasData.get(i);
                                listKelas.add(kelass);

                            }
                            String Kelas = kelasData.get(0).getNama_kelas().toString();
                            Log.d("getsucces",Kelas);
//                            }
                            kelasAdapter = new KelasAdapter(listKelas);


//                            Toast.makeText(mContext, kelasResponse.getStatus(), Toast.LENGTH_SHORT).show();
                        } else {
//                            loading.dismiss();
                        }


                    }

                    @Override
                    public void onFailure(Call<KelasResponse> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
//                        Toast.makeText(mContext,"FAIL", Toast.LENGTH_SHORT).show();
                    }
                });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"CLICKED!!",Toast.LENGTH_SHORT).show();

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFab();

            }
        });
        fabAddClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"CLICKED!!",Toast.LENGTH_SHORT).show();
            }
        });

        return inflater.inflate(R.layout.fragment_class, container, false);
    }
}