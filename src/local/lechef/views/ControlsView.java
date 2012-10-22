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
import local.mvc.Model;
import local.mvc.View;

import javax.swing.*;

public class ControlsView extends BottomBar implements View {

    private JButton increaseHoursLeft;
    private JButton increaseHoursRight;

    private JButton increaseMinutesLeft;
    private JButton increaseMinutesRight;

    private JButton increaseSecondsLeft;
    private JButton increaseSecondsRight;

    public ControlsView() {

        super(BottomBarSize.SMALL);

        increaseHoursLeft = (JButton) MacButtonFactory.makeUnifiedToolBarButton(new JButton(MacIcons.PLUS));
        increaseHoursRight = (JButton) MacButtonFactory.makeUnifiedToolBarButton(new JButton(MacIcons.PLUS));

        increaseMinutesLeft = (JButton) MacButtonFactory.makeUnifiedToolBarButton(new JButton(MacIcons.PLUS));
        increaseMinutesRight = (JButton) MacButtonFactory.makeUnifiedToolBarButton(new JButton(MacIcons.PLUS));

        increaseSecondsLeft = (JButton) MacButtonFactory.makeUnifiedToolBarButton(new JButton(MacIcons.PLUS));
        increaseSecondsRight = (JButton) MacButtonFactory.makeUnifiedToolBarButton(new JButton(MacIcons.PLUS));


        addComponentToLeft(MacWidgetFactory.createSpacer(40, 1));

        addComponentToLeft(increaseHoursLeft);

        addComponentToLeft(MacWidgetFactory.createSpacer(18, 1));

        addComponentToLeft(increaseHoursRight);


        addComponentToCenter(increaseMinutesLeft);

        addComponentToCenter(MacWidgetFactory.createSpacer(18, 1));

        addComponentToCenter(increaseMinutesRight);


        addComponentToRight(increaseSecondsLeft);

        addComponentToRight(MacWidgetFactory.createSpacer(18, 1));

        addComponentToRight(increaseSecondsRight);

        addComponentToRight(MacWidgetFactory.createSpacer(40, 1));

        WindowUtils.installJComponentRepainterOnWindowFocusChanged(getComponent());

    }

    public void update(Model model) {

        if (MainController.getStatusController().getModel().getUIenabled()) {

            increaseHoursLeft.setEnabled(true);
            increaseHoursRight.setEnabled(true);
            increaseMinutesLeft.setEnabled(true);
            increaseMinutesRight.setEnabled(true);
            increaseSecondsLeft.setEnabled(true);
            increaseSecondsRight.setEnabled(true);

        } else {

            increaseHoursLeft.setEnabled(false);
            increaseHoursRight.setEnabled(false);
            increaseMinutesLeft.setEnabled(false);
            increaseMinutesRight.setEnabled(false);
            increaseSecondsLeft.setEnabled(false);
            increaseSecondsRight.setEnabled(false);

        }

    }

    public JButton getIncreaseHoursLeft() {
        return increaseHoursLeft;
    }

    public JButton getIncreaseHoursRight() {
        return increaseHoursRight;
    }

    public JButton getIncreaseMinutesLeft() {
        return increaseMinutesLeft;
    }

    public JButton getIncreaseMinutesRight() {
        return increaseMinutesRight;
    }

    public JButton getIncreaseSecondsLeft() {
        return increaseSecondsLeft;
    }

    public JButton getIncreaseSecondsRight() {
        return increaseSecondsRight;
    }

}
