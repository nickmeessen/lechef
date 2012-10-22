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

import com.explodingpixels.macwidgets.*;
import com.explodingpixels.widgets.WindowUtils;
import local.lechef.controllers.MainController;
import local.lechef.models.StatusModel;
import local.mvc.Model;
import local.mvc.View;

import javax.swing.*;

public class StatusView extends BottomBar implements View {

    private JButton startButton;
    private JButton resetButton;
    private JButton chooseButton;
    private JButton chosenSound;

    public StatusView() {

        super(BottomBarSize.LARGE);


        addComponentToLeft(MacWidgetFactory.createSpacer(5, 1));
        addComponentToLeft(MacButtonFactory.makeUnifiedToolBarButton(chosenSound = new JButton("Eitjes")));
        addComponentToLeft(MacButtonFactory.makeUnifiedToolBarButton(new JButton("|")));
        addComponentToLeft(MacButtonFactory.makeUnifiedToolBarButton(chooseButton = new JButton("Choose..")));

        addComponentToRight(MacButtonFactory.makeUnifiedToolBarButton(startButton = new JButton("start")));
        addComponentToRight(MacButtonFactory.makeUnifiedToolBarButton(new JButton("|")));
        addComponentToRight(MacButtonFactory.makeUnifiedToolBarButton(resetButton = new JButton("reset")));

        addComponentToRight(MacWidgetFactory.createSpacer(5, 1));

        getComponent().setEnabled(false);

        WindowUtils.installJComponentRepainterOnWindowFocusChanged(getComponent());
    }

    public void update(Model model) {

        StatusModel statusModel = (StatusModel) model;

        chosenSound.setText(MainController.getItemsController().getModel().getCurrentItem().getModel().getLabel());

        if (MainController.getClockController().getCounting()) {
            startButton.setText("pause");
        } else {
            startButton.setText("start");
        }

        if (statusModel.getUIenabled()) {

            chooseButton.setEnabled(true);
            chosenSound.setEnabled(true);
            startButton.setEnabled(true);
            resetButton.setEnabled(true);

        } else {

            chooseButton.setEnabled(false);
            chosenSound.setEnabled(false);
            startButton.setEnabled(false);
            resetButton.setEnabled(false);

        }

        getComponent().repaint();

    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public JButton getChooseButton() {
        return chooseButton;
    }

}
