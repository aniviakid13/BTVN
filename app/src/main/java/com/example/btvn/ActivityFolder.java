package com.example.btvn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivityFolder extends AppCompatActivity {

    private static final int Key_Add = 101;
    private static final int Key_Edit = 102;

    public static final String Key_Name = "add_name_folder";
    public static final String Key_Content = "add_content_folder";

    ArrayList<FolderModel> folderModels;
    FolderAdapter folderAdapter;

    ImageButton btnBack;
    TextView tvAdd;
    int itemSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.folder_manager);

        folderModels = new ArrayList<>();
        folderModels.add(new FolderModel("Tổng hợp tin tức thời sự", "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các ..."));
        folderModels.add(new FolderModel("Do It Your Self", "Sơn tùng MTP quá đẹp trai hát hay"));
        folderModels.add(new FolderModel("Cảm hứng sáng tạo", "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các ..."));
        folderModels.add(new FolderModel("Tổng hợp tin tức thời sự", "Sơn tùng MTP quá đẹp trai hát hay"));
        folderModels.add(new FolderModel("Cảm hứng sáng tạo", "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các ..."));
        folderModels.add(new FolderModel("Tổng hợp tin tức thời sự", "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các ..."));

        folderAdapter = new FolderAdapter(this, folderModels, index -> {
            itemSelected = index;
            Intent intent = new Intent(ActivityFolder.this, ActivityAdd.class);
            intent.putExtra(Key_Name, folderModels.get(index).nameFolder);
            intent.putExtra(Key_Content, folderModels.get(index).content);
            startActivityForResult(intent, Key_Edit);

        });

        RecyclerView recyclerView = findViewById(R.id.rv_folder);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(folderAdapter);

        btnBack = findViewById(R.id.btn_back);
        tvAdd = findViewById(R.id.tv_add);

        btnBack.setOnClickListener(view -> finish());
        tvAdd.setOnClickListener(view -> {
            // phan luu bach tu B ve A
//                String nameFolder = "abc";
//                String contentFolder = "xyz";
//                Intent intent = new Intent();
//                intent.putExtra("EXTRA_NANE_FOLDER",nameFolder);
//                intent.putExtra("EXTRA_CONTENT_FOLDER",contentFolder);
//                setResult(Activity.RESULT_OK,intent);

            startActivityForResult(new Intent(this, ActivityAdd.class), Key_Add);
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Key_Add && resultCode == Activity.RESULT_OK) {
            String nameFolder = data.getStringExtra(Key_Name);
            String contentFolder = data.getStringExtra(Key_Content);
            FolderModel folderModel = new FolderModel(nameFolder, contentFolder);
            folderModels.add(folderModel);
            folderAdapter.notifyDataSetChanged();
        } else if (requestCode == Key_Edit && resultCode == Activity.RESULT_OK) {
            // get du lieu tra ve tu man C edit
            // gan lai gia tri data cho index da duoc chon
            // update lai vi tri torng recycleview
            String nameFolder = data.getStringExtra(Key_Name);
            String contentFolder = data.getStringExtra(Key_Content);
            folderModels.get(itemSelected).nameFolder = nameFolder;
            folderModels.get(itemSelected).content = contentFolder;
            folderAdapter.notifyItemChanged(itemSelected);
        }
    }
}