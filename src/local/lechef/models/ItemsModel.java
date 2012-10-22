package local.lechef.models;

import local.lechef.controllers.ItemController;
import local.mvc.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class ItemsModel implements Model {

    private HashMap<String, ItemController> listItems;
    private ItemController currentItem;
    private boolean shutdownEnabled;

    public ItemsModel() {

        currentItem = null;
        shutdownEnabled = false;
        listItems = new HashMap<String, ItemController>();
    }

    public ItemsModel(ItemController currentItem, boolean shutdownEnabled) {

        this.currentItem = currentItem;
        this.shutdownEnabled = shutdownEnabled;
        listItems = new HashMap<String, ItemController>();

    }

    public ItemController getCurrentItem() {
        return currentItem;
    }

    public void setCurrentItem(ItemController item) {
        currentItem = item;
    }

    public boolean getShutdownEnabled() {
        return shutdownEnabled;
    }

    public void setShutdownEnabled(boolean b) {
        shutdownEnabled = b;
    }

    public void addItem(String label, ItemController item) {

        if (currentItem == null) {
            currentItem = item;
            item.getModel().setSelected(true);
        }

        listItems.put(label, item);
    }

    public Collection<ItemController> getItems() {
        return listItems.values();
    }

    public ItemController getItem(String label) {
        return listItems.get(label);
    }

}
