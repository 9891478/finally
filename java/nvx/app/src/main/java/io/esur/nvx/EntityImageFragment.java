package io.esur.nvx;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class EntityImageFragment extends Fragment implements EntityImageAdapter.EntityImageAdapterListener {

    private ArrayList<Integer> entityImageNameList;
    private List<EntityImage> entityImageList;
    private EntityImageFragment.OnEntityImageFragmentInteractionListener mListener;
    private int entityImageAdapterPosition;

    public EntityImageFragment() {}

    interface OnEntityImageFragmentInteractionListener {
        void onEntityImageFragmentInteraction(int position);
    }

    @Override
    public void onButtonPressed(int position) {
        //Toast.makeText(getActivity(), "click ok button at " + position, Toast.LENGTH_SHORT).show();
        if (mListener != null) {
            entityImageAdapterPosition = position;
            mListener.onEntityImageFragmentInteraction(position);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            entityImageAdapterPosition = 0;
        } else {
            entityImageAdapterPosition = savedInstanceState.getInt("entityImageAdapterPosition", 0);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("entityMainAdapterPosition", entityImageAdapterPosition);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.entity_image_rv, container, false);

        getImageSet();
        makeImageSet();

        RecyclerView entityImageRV = (RecyclerView) view.findViewById(R.id.entity_image_rv);
        entityImageRV.setHasFixedSize(true);

        RecyclerView.LayoutManager entityImageLM = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        entityImageRV.setLayoutManager(entityImageLM);

        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(entityImageRV);

        EntityImageAdapter entityImageAdapter = new EntityImageAdapter(getActivity(), entityImageList, this);
        entityImageRV.setAdapter(entityImageAdapter);

        return view;
    }

    private void makeImageSet() {
        entityImageList = new ArrayList<>();

        for (Integer item : entityImageNameList) {
            entityImageList.add(new EntityImage(item));
        }
    }

    // mock - pre rx
    private void getImageSet() {
        entityImageNameList = new ArrayList<>();

        entityImageNameList.add(R.drawable.house);
        entityImageNameList.add(R.drawable.hitman);
        entityImageNameList.add(R.drawable.zoe);
        entityImageNameList.add(R.drawable.rage);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof EntityImageFragment.OnEntityImageFragmentInteractionListener) {
            mListener = (EntityImageFragment.OnEntityImageFragmentInteractionListener) context;
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
