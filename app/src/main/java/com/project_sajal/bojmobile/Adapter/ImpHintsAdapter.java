package com.project_sajal.bojmobile.Adapter;

import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project_sajal.bojmobile.R;

import java.util.List;

public class ImpHintsAdapter extends RecyclerView.Adapter<ImpHintsAdapter.ImpHintsHolder>{

    private List<Integer> imagelist ;

    public ImpHintsAdapter(List<Integer>imagelist){
        this.imagelist = imagelist;
    }
    @NonNull
    @Override
    public ImpHintsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hints_layout,parent,false);
        return new ImpHintsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImpHintsHolder holder, int position) {
        holder.mImageView.setImageResource(imagelist.get(position));

    }

    @Override
    public int getItemCount() {
        return imagelist.size();
    }

    public class ImpHintsHolder extends RecyclerView.ViewHolder{

        private ImageView mImageView;
        public ImpHintsHolder(@NonNull View itemView){
            super(itemView);

            mImageView = itemView.findViewById(R.id.imageView1);

        }
    }
}
