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

import local.lechef.views.MainView;
import local.mvc.Controller;
import local.mvc.Model;

public class MainController implements Controller {

    private static ClockController clockController;
    private static ControlsController controlsController;
    private static ItemsController itemsController;
    private static StatusController statusController;

    private static MainView mainView;

    public MainController() {

        clockController = new ClockController();
        controlsController = new ControlsController();
        itemsController = new ItemsController();
        statusController = new StatusController();

        mainView = new MainView();

        MainController.getClockController().start();

    }

    public static ClockController getClockController() {
        return clockController;
    }

    public static ControlsController getControlsController() {
        return controlsController;
    }

    public static StatusController getStatusController() {
        return statusController;
    }

    public static ItemsController getItemsController() {
        return itemsController;
    }

    public Model getModel() {
        return null;
    }

    public MainView getView() {
        return mainView;
    }

    public void updateView() {
    }
}
