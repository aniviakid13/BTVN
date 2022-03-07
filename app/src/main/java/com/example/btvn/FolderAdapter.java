package com.example.btvn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.ViewHolder>{
    private FolderListener folderListener;
   private Context context;
   private ArrayList<FolderModel> folderModels;

    public FolderAdapter(Context context, ArrayList<FolderModel> folderModels,FolderListener folderListener) {
        this.context = context;
        this.folderModels = folderModels;
        this.folderListener = folderListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.folder,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNameFolder.setText(folderModels.get(position).nameFolder);
        holder.tvContent.setText(folderModels.get(position).content);

        // su kien click item trong recycleview
        holder.itemView.setOnClickListener(v->{
            folderListener.onItemSelected(position);
        });
    }

    @Override
    public int getItemCount() {
        return folderModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFolder;
        TextView tvNameFolder, tvContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFolder = itemView.findViewById(R.id.img_folder);
            tvNameFolder = itemView.findViewById(R.id.tv_name_folder);
            tvContent = itemView.findViewById(R.id.tv_content_folder);
        }
    }

    public interface FolderListener{
        void onItemSelected(int index);

    }
}
