/*
 * LeChef - Cooking Timer
 * Copyright (C) 2010
 * Nick Meessen (http://nickmeessen.nl)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * ----------------------------------------------------------------------------
 */

package local.lechef.controllers;

import local.lechef.models.ItemModel;
import local.lechef.views.ItemView;
import local.mvc.Controller;
import local.mvc.Model;
import local.mvc.View;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ItemController extends MouseAdapter implements Controller {

    private ItemModel itemModel;
    private ItemView itemView;

    public ItemController() {

        itemModel = new ItemModel();
        itemView = new ItemView();

        itemView.addMouseListener(this);

    }

    public ItemModel getModel() {
        return itemModel;
    }

    public ItemView getView() {
        return itemView;
    }

    public void updateView() {
        itemView.update(itemModel);
    }

    public void mouseReleased(MouseEvent ev) {

        MainController.getItemsController().deselectAll();

        itemModel.setSelected(true);

        updateView();

    }

}
