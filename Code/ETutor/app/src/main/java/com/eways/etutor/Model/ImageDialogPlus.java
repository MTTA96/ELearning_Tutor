package com.eways.etutor.Model;

/**
 * Created by ADMIN on 4/23/2018.
 */

public class ImageDialogPlus {
    int idSelected;
    int image;
    String content;

    public ImageDialogPlus(int idSelected, int image, String content) {
        this.idSelected = idSelected;
        this.image = image;
        this.content = content;
    }

    public int getIdSelected() {
        return idSelected;
    }

    public void setIdSelected(int idSelected) {
        this.idSelected = idSelected;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
