package io.esur.nvx;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class EntityMainFragment extends Fragment implements EntityMainAdapter.EntityMainAdapterListener
                                                            ,EntityThumbImageAdapter.EntityThumbImageAdapterListener // ? multi interface
{
    public EntityMainFragment() {}

    private ArrayList<String> entityMainNameList;
    private List<EntityMain> entityMainList;
    private OnEntityMainFragmentInteractionListener mListener;
    private int entityMainAdapterPosition;

    interface OnEntityMainFragmentInteractionListener {
        void onButtonPressed(int position, String tag);
        void onButtonLongPressed(int position, String tag);
    }

    @Override
    public void onButtonPressed(int position, String tag) {
        if (mListener != null) {
            entityMainAdapterPosition = position;
            mListener.onButtonPressed(position, tag);
        }
    }

    @Override
    public void onButtonLongPressed(int position, String tag) {
        if (mListener != null) {
            entityMainAdapterPosition = position;
            mListener.onButtonLongPressed(position, tag);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("entityMainAdapterPosition", entityMainAdapterPosition);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            entityMainAdapterPosition = 0;
        } else {
            entityMainAdapterPosition = savedInstanceState.getInt("entityMainAdapterPosition", 0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.entity_main_rv, container, false);

        getEntityHeaders();
        createEntity();

        // ? gc
        RecyclerView entityMainRV = (RecyclerView) view.findViewById(R.id.entity_main_rv);
        entityMainRV.setHasFixedSize(true);

        RecyclerView.LayoutManager entityMainLM = new LinearLayoutManager(this.getActivity());
        entityMainRV.setLayoutManager(entityMainLM);

        RecyclerView.Adapter entityMainAdapter = new EntityMainAdapter(this.getActivity(), entityMainList, this);
        entityMainRV.setAdapter(entityMainAdapter);

        return view;
    }

    private void createEntity() {
        entityMainList = new ArrayList<>();

        for (String item : entityMainNameList) {
            entityMainList.add(new EntityMain(item, this.getContext()));
        }
    }

    // mock
    public void getEntityHeaders() {
        entityMainNameList = new ArrayList<>();

        entityMainNameList.add("mock1");
        entityMainNameList.add("mock2");
        entityMainNameList.add("mock3");
        entityMainNameList.add("mock4");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnEntityMainFragmentInteractionListener) {
            mListener = (OnEntityMainFragmentInteractionListener) context;
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
}