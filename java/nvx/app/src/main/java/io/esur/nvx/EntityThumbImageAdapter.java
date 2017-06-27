package io.esur.nvx;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;

class EntityThumbImageAdapter extends RecyclerView.Adapter<EntityThumbImageAdapter.EntityImageHolder> {

    private List<EntityImage> entityImageList;
    private EntityThumbImageAdapterListener mListener;

    interface EntityThumbImageAdapterListener {
        void onButtonPressed(int position, String tag);
    }

    EntityThumbImageAdapter (EntityThumbImageAdapterListener mListener) {
        this.mListener = mListener ;
    }

    void setImage(List<EntityImage> imageList) {
        if (entityImageList != imageList) {
            entityImageList = imageList;
            notifyDataSetChanged();
        }
    }

    class EntityImageHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView entityImage;

        EntityImageHolder(View itemView) {
            super(itemView);

            entityImage = (ImageView) itemView.findViewById(R.id.entity_image_cv_image);
            entityImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onButtonPressed(getAdapterPosition(), v.getTag().toString());
        }
    }

    @Override
    public EntityImageHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.entity_image_cv, parent, false);

        return new EntityImageHolder(v);
    }

    @Override
    public void onBindViewHolder(EntityImageHolder holder, int position) {
        holder.entityImage.setImageResource(entityImageList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        // why this list sometimes null ?
        if (entityImageList != null) {
            return entityImageList.size();
        } else return 0;
    }
}