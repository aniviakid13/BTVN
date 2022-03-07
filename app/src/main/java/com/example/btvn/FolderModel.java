package com.example.btvn;

import java.io.Serializable;

public class FolderModel {
    String nameFolder;
    String content;

    public FolderModel(String nameFolder, String content) {
        this.nameFolder = nameFolder;
        this.content = content;
    }

    public FolderModel() {
    }

}
