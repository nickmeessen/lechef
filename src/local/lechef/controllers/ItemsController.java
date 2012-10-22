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

import local.lechef.models.ItemsModel;
import local.lechef.views.ItemsView;
import local.mvc.Controller;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class ItemsController extends MouseAdapter implements Controller, ActionListener {

    private ItemsModel itemsModel;
    private ItemsView itemsView;

    public ItemsController() {

        itemsModel = new ItemsModel();
        itemsView = new ItemsView();


        // @todo foreachen, from xml file?

            ItemController item1 = new ItemController();
            ItemController item2 = new ItemController();
            ItemController item3 = new ItemController();
            ItemController item4 = new ItemController();
            ItemController item5 = new ItemController();
            ItemController item6 = new ItemController();


            item1.getModel().setLabel("Eitjes");
            item1.getModel().setIcon(new ImageIcon("icns/eggs.png"));
            item1.getModel().setSound(new File("audio/atty/eitjes.aiff"));

            item1.updateView();


            item3.getModel().setLabel("Broodjes");
            item3.getModel().setIcon(new ImageIcon("icns/bread.png"));
            item3.getModel().setSound(new File("audio/atty/broodjes.aiff"));

            item3.updateView();


            item4.getModel().setLabel("Eten");
            item4.getModel().setIcon(new ImageIcon("icns/food.png"));
            item4.getModel().setSound(new File("audio/atty/eten.aiff"));

            item4.updateView();


            item2.getModel().setLabel("Aardappels");
            item2.getModel().setIcon(new ImageIcon("icns/potatoes.png"));
            item2.getModel().setSound(new File("audio/atty/aardappels.aiff"));

            item2.updateView();

            item5.getModel().setLabel("Cake");
            item5.getModel().setIcon(new ImageIcon("icns/cake.png"));
            item5.getModel().setSound(new File("audio/atty/cake.aiff"));

            item5.updateView();

            item6.getModel().setLabel("Vlees");
            item6.getModel().setIcon(new ImageIcon("icns/meat.png"));
            item6.getModel().setSound(new File("audio/atty/vlees.aiff"));

            item6.updateView();
        

            itemsModel.addItem("Eitjes", item1);
            itemsModel.addItem("Broodjes", item3);
//            itemsModel.addItem("Aardappels", item2);
            itemsModel.addItem("Eten", item4);
            itemsModel.addItem("Cake", item5);
            itemsModel.addItem("Vlees", item6);


        // @todo end

        itemsView.update(itemsModel);

        itemsView.getSelectButton().addActionListener(this);
        itemsView.getCancelButton().addActionListener(this);
        itemsView.getNewAlarmPane().addMouseListener(this);
    }


    public ItemsModel getModel() {
        return itemsModel;
    }

    public ItemsView getView() {
        return itemsView;
    }

    public void updateView() {

        itemsView.update(itemsModel);
        MainController.getStatusController().updateView();

    }

    public void deselectAll() {

        for(ItemController item : itemsModel.getItems()) {

            item.getModel().setSelected(false);
            item.updateView();

        }

    }

    public void actionPerformed(ActionEvent ev) {


        if (ev.getSource().equals(itemsView.getSelectButton())) {

            itemsView.setVisible(false);

            itemsModel.setCurrentItem(itemsView.getSelectedItem());
            itemsModel.setShutdownEnabled(itemsView.getShutdownValue());

            updateView();


        } else if (ev.getSource().equals(itemsView.getCancelButton())) {

            itemsView.setVisible(false);

            updateView();

        }


    }

    public void mousePressed(MouseEvent ev) {
        itemsView.getNewAlarmPane().setBackground(Color.decode("#CCCCCC"));
    }

    public void mouseReleased(MouseEvent ev) {

        // @todo fix xd

        itemsView.getNewAlarmPane().setBackground(Color.decode("#DDDDDD"));

        JFileChooser soundChooser = new JFileChooser();

        soundChooser.setCurrentDirectory(new File("audio/"));

        soundChooser.setDialogTitle("Choose an AlertSound (AIFF or WAV)..");
        soundChooser.setDialogType(JFileChooser.FILES_ONLY);

        soundChooser.setAcceptAllFileFilterUsed(false);
        soundChooser.setFileFilter(new FileFilter() {

            public boolean accept(File path) {

                if (path.isDirectory()) {

                    return true;

                } else {

                    String ext = path.getName().substring(path.getName().lastIndexOf(".") + 1);

                    if (ext.equalsIgnoreCase("aiff") || ext.equalsIgnoreCase("wav")) {

                        return true;

                    } else {

                        return false;
                    }

                }

            }

            @Override
            public String getDescription() {
                return "WAV or AIFF files.";
            }

        }
        );


        if (soundChooser.showOpenDialog(MainController.getStatusController().getView().getChooseButton()) == JFileChooser.APPROVE_OPTION) {
            // @todo process new item
        }

    }

}