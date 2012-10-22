package local.lechef.models;

import local.mvc.Model;

import javax.swing.*;
import java.io.File;

public class ItemModel implements Model {

    public String itemLabel;
    public ImageIcon itemIcon;
    public File itemSound;
    public boolean itemSelected;

    public ItemModel() {
    }

    public ItemModel(String itemLabel, ImageIcon itemIcon, File itemSound) {

        this.itemLabel = itemLabel;
        this.itemIcon = itemIcon;
        this.itemSound = itemSound;
        this.itemSelected = false;

    }

    public String getLabel() {
        return itemLabel;
    }

    public void setLabel(String label) {
        itemLabel = label;
    }

    public ImageIcon getIcon() {
        return itemIcon;
    }

    public void setIcon(ImageIcon icn) {
        itemIcon = icn;
    }

    public File getSound() {
        return itemSound;
    }

    public void setSound(File f) {
        itemSound = f;
    }

    public boolean getSelected() {
        return itemSelected;
    }

    public void setSelected(boolean b) {
        itemSelected = b;
    }

}
