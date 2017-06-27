package io.esur.nvx;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

class EntityImageAdapter extends RecyclerView.Adapter<EntityImageAdapter.EntityImageHolder> {

    //private final Context context;
    private List<EntityImage> entityImageList;
    private EntityImageAdapterListener mListener;

    interface EntityImageAdapterListener {
        void onButtonPressed(int position);
    }

    class EntityImageHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView entityImage;

        EntityImageHolder(final View itemView) {
            super(itemView);
            //Context context = itemView.getContext();

            entityImage = (ImageView) itemView.findViewById(R.id.entity_image_cv_image);
            entityImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onButtonPressed(getAdapterPosition());
        }
    }

   EntityImageAdapter(Context context, List<EntityImage> entityList, EntityImageAdapterListener mListener) {
//    EntityImageAdapter(List<EntityImage> entityList, EntityImageAdapterListener mListener) {
//        this.context = context;
        this.mListener = mListener;

        if (entityList != null)
            this.entityImageList = new ArrayList<>(entityList);
        else this.entityImageList = new ArrayList<>();
    }

    @Override
    public EntityImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.entity_image_cv, parent, false);
        return new EntityImageHolder(v);
    }

    @Override
    public void onBindViewHolder(EntityImageHolder holder, final int position) {
        holder.entityImage.setImageResource(entityImageList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return entityImageList.size();
    }
}