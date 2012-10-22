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

package local.lechef.views;

import com.explodingpixels.macwidgets.BottomBar;
import com.explodingpixels.macwidgets.BottomBarSize;
import com.explodingpixels.macwidgets.MacButtonFactory;
import local.lechef.controllers.ItemController;
import local.lechef.controllers.MainController;
import local.lechef.models.ItemsModel;
import local.mvc.Model;
import local.mvc.View;

import javax.swing.*;
import java.awt.*;

public class ItemsView implements View {

    private JFrame chooserFrame;
    private JCheckBox shutdownBox;

    private JPanel itemsList;
    private JPanel newAlarmPane;

    private JButton selectButton;
    private JButton cancelButton;

    public ItemsView() {

        chooserFrame = new JFrame();

        JPanel contentPane = new JPanel(new BorderLayout());
        JPanel bottomPane = new JPanel(new BorderLayout());

        JScrollPane itemsFrame = new JScrollPane(itemsList = new JPanel());

        itemsFrame.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        itemsList.setBackground(Color.decode("#EDEDED"));

        itemsList.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        itemsList.setLayout(new BoxLayout(itemsList, BoxLayout.PAGE_AXIS));

        JToolBar shutdownBar = new JToolBar();

        shutdownBar.setFloatable(false);

        shutdownBar.add(Box.createHorizontalGlue());
        shutdownBar.add(shutdownBox = new JCheckBox("Shutdown System", false));
        shutdownBar.add(Box.createHorizontalGlue());

        shutdownBox.setFocusPainted(false);
        shutdownBox.setFont(MacButtonFactory.makeUnifiedToolBarButton(new JButton("0")).getFont());

        
        // Shutdown function is Windows only, Mac OS & Linux need SU permissions ;)
        if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            bottomPane.add(shutdownBar, BorderLayout.CENTER);
        }

        BottomBar bb = new BottomBar(BottomBarSize.LARGE);

        bb.addComponentToCenter(MacButtonFactory.makeUnifiedToolBarButton(selectButton = new JButton("Select")));
        bb.addComponentToCenter(MacButtonFactory.makeUnifiedToolBarButton(new JButton("|")));
        bb.addComponentToCenter(MacButtonFactory.makeUnifiedToolBarButton(cancelButton = new JButton("Cancel")));

        bottomPane.add(bb.getComponent(), BorderLayout.SOUTH);

        contentPane.add(itemsFrame, BorderLayout.CENTER);
        contentPane.add(bottomPane, BorderLayout.SOUTH);

        chooserFrame.setSize(300, 400);
        chooserFrame.setTitle("Choose Alert..");
        chooserFrame.setContentPane(contentPane);

        chooserFrame.setLocationRelativeTo(null);

    }

    public JButton getSelectButton() {
        return selectButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JPanel getNewAlarmPane() {
        return newAlarmPane;
    }

    public ItemController getSelectedItem() {

        ItemController selectedItem = null;

        for(ItemController item : MainController.getItemsController().getModel().getItems()) {

            if( item.getModel().getSelected() ) {
                selectedItem = item;

                break;
            }

        }

        return selectedItem;

    }

    public boolean getShutdownValue() {
        return shutdownBox.isSelected();
    }

    public void update(Model model) {

        ItemsModel itemsModel = (ItemsModel) model;

        shutdownBox.setSelected(itemsModel.getShutdownEnabled());

        itemsList.removeAll(); 

        for(ItemController item : itemsModel.getItems()) {
            itemsList.add(item.getView());
        }

        newAlarmPane = new JPanel(new FlowLayout(FlowLayout.LEFT));

        newAlarmPane.add(new JLabel(new ImageIcon(getClass().getResource("/local/lechef/img/plus.png"))));
        newAlarmPane.add(new JLabel("<html><b>&nbsp;New Alarm</b></html>"));

        newAlarmPane.setBackground(Color.decode("#DDDDDD"));
        newAlarmPane.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.decode("#EDEDED"), 2), BorderFactory.createEtchedBorder()));

//        @todo (fix before & after tag xd)
//        itemsList.add(newAlarmPane);

        itemsModel.getCurrentItem().getModel().setSelected(true);
        itemsModel.getCurrentItem().updateView();

    }


    public void setVisible(boolean b) {
        chooserFrame.setVisible(b);
    }
}
