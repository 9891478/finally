package io.esur.nvx;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class EntityMainAdapter extends RecyclerView.Adapter<EntityMainAdapter.EntityMainHolder> {

    private final Context context;
    private List<EntityMain> entityMainList;
    private EntityMainAdapterListener mListener;

    interface EntityMainAdapterListener {
        void onButtonPressed(int position, String tag);
        void onButtonLongPressed(int position, String tag);
    }

    class EntityMainHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        ImageView entityMainLogo;
        TextView entityMainDescription;
        ImageButton entityMainButton;
        EntityThumbImageAdapter entityThumbImageAdapter;

        EntityMainHolder(final View itemView) {
            super(itemView);

            entityMainLogo = (ImageView) itemView.findViewById(R.id.entity_main_logo);
            entityMainDescription = (TextView) itemView.findViewById(R.id.entity_main_description);
            entityMainButton = (ImageButton) itemView.findViewById(R.id.entity_main_button);

            entityMainDescription.setOnClickListener(this);
            entityMainButton.setOnClickListener(this);
            entityMainButton.setOnLongClickListener(this);

            initEntityImageRV(itemView);
        }

        void initEntityImageRV(View itemView) {
            RecyclerView entityImageRV = (RecyclerView) itemView.findViewById(R.id.entity_image_rv);

            LinearLayoutManager entityImageLM = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);

            // @@@ recyclers listener rivals. wont work. redesign.
//            LinearLayoutManager entityImageLM = new LinearLayoutManager(context);
//
//            if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
//                entityImageLM.setOrientation(LinearLayoutManager.HORIZONTAL);
//            } else {
//                entityImageLM.setOrientation(LinearLayoutManager.VERTICAL);
//            }

            entityImageRV.setLayoutManager(entityImageLM);

            SnapHelper snapHelper = new PagerSnapHelper();
            snapHelper.attachToRecyclerView(entityImageRV);

            entityThumbImageAdapter = new EntityThumbImageAdapter((EntityThumbImageAdapter.EntityThumbImageAdapterListener) mListener);
            entityImageRV.setAdapter(entityThumbImageAdapter);
        }

        // dagger2...
        @Override
        public void onClick(View v) {
            mListener.onButtonPressed(getAdapterPosition(), v.getTag().toString());
        }

        @Override
        public boolean onLongClick(View v) {
            mListener.onButtonLongPressed(getAdapterPosition(), v.getTag().toString());
            return true;
        }
    }

    EntityMainAdapter(Context context, List<EntityMain> entityList, EntityMainAdapterListener mListener) {
        this.context = context;
        this.mListener = mListener;

        if (entityList != null)
            entityMainList = new ArrayList<>(entityList);
        else entityMainList = new ArrayList<>();
    }

    @Override
    public EntityMainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.entity_main_cv, parent, false);
        return new EntityMainHolder(v);
    }

    @Override
    public void onBindViewHolder(EntityMainHolder holder, final int position) {
        holder.entityMainLogo.setImageResource(entityMainList.get(position).getEntityMainDescriptionLogo());
        holder.entityMainDescription.setText(entityMainList.get(position).getEntityMainDescription());

//        holder.entityMainComments.setText(entityMainList.get(position).getEntityMainComments());
        holder.entityThumbImageAdapter.setImage(entityMainList.get(position).getEntityImageList());
    }

    @Override
    public int getItemCount() {
        return entityMainList.size();
    }
}