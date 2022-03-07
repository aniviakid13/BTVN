package com.example.btvn;


import static com.example.btvn.ActivityFolder.Key_Content;
import static com.example.btvn.ActivityFolder.Key_Name;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityAdd extends AppCompatActivity {
     EditText edtNameFolder, edtContentFolder;
     TextView tvCancel, tvAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_folder);

        edtNameFolder = findViewById(R.id.edt_name);
        edtContentFolder = findViewById(R.id.edt_content);

        tvCancel = findViewById(R.id.tv_cancel)   ;
        tvAdd = findViewById(R.id.tv_save);

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameFolder = edtNameFolder.getText().toString();
                String contentFolder = edtContentFolder.getText().toString();
                Intent intent = new Intent();
                intent.putExtra(Key_Name,nameFolder);
                intent.putExtra(Key_Content,contentFolder);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}