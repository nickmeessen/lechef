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

import local.lechef.views.ControlsView;
import local.mvc.Controller;
import local.mvc.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlsController implements Controller, ActionListener {

    private ControlsView controlsView;

    public ControlsController() {

        controlsView = new ControlsView();

        controlsView.getIncreaseHoursLeft().addActionListener(this);
        controlsView.getIncreaseHoursRight().addActionListener(this);

        controlsView.getIncreaseMinutesLeft().addActionListener(this);
        controlsView.getIncreaseMinutesRight().addActionListener(this);

        controlsView.getIncreaseSecondsLeft().addActionListener(this);
        controlsView.getIncreaseSecondsRight().addActionListener(this);

    }

    public Model getModel() {
        return null;
    }

    public ControlsView getView() {
        return controlsView;
    }

    public void updateView() {
        controlsView.update(null);
    }

    public void actionPerformed(ActionEvent ev) {

        if (ev.getSource().equals(controlsView.getIncreaseHoursLeft())) {
            MainController.getClockController().getModel().setClockHours(MainController.getClockController().getModel().getClockHours() + 10);
        }

        if (ev.getSource().equals(controlsView.getIncreaseHoursRight())) {
            MainController.getClockController().getModel().setClockHours(MainController.getClockController().getModel().getClockHours() + 1);
        }


        if (ev.getSource().equals(controlsView.getIncreaseMinutesLeft())) {
            MainController.getClockController().getModel().setClockMinutes(MainController.getClockController().getModel().getClockMinutes() + 10);
        }

        if (ev.getSource().equals(controlsView.getIncreaseMinutesRight())) {
            MainController.getClockController().getModel().setClockMinutes(MainController.getClockController().getModel().getClockMinutes() + 1);
        }


        if (ev.getSource().equals(controlsView.getIncreaseSecondsLeft())) {
            MainController.getClockController().getModel().setClockSeconds(MainController.getClockController().getModel().getClockSeconds() + 10);
        }

        if (ev.getSource().equals(controlsView.getIncreaseSecondsRight())) {
            MainController.getClockController().getModel().setClockSeconds(MainController.getClockController().getModel().getClockSeconds() + 1);
        }


        MainController.getClockController().updateView();

    }
}
