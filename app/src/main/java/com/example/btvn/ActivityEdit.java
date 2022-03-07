package com.example.btvn;


import static com.example.btvn.ActivityFolder.Key_Content;
import static com.example.btvn.ActivityFolder.Key_Name;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityEdit extends AppCompatActivity {

    private EditText edtName, edtFolder;
    private String nameFolder, contentFolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_folder);
        nameFolder = getIntent().getStringExtra(Key_Name);
        contentFolder = getIntent().getStringExtra(Key_Content);

        edtName = findViewById(R.id.edt_name);
        edtFolder = findViewById(R.id.edt_content);

        edtName.setText(nameFolder);
        edtFolder.setText(contentFolder);

        findViewById(R.id.tv_cancel).setOnClickListener(v -> {

        });

        findViewById(R.id.tv_add).setOnClickListener(v -> {
            // get data tu ban phim
            // save vao intent
            // go back A
            String nameFolder = edtName.getText().toString();
            String contentFolder = edtFolder.getText().toString();
            Intent intent = new Intent();
            intent.putExtra(Key_Name, nameFolder);
            intent.putExtra(Key_Content, contentFolder);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });

    }
}