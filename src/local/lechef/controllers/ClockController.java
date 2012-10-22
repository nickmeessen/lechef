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

import local.lechef.models.ClockModel;
import local.lechef.views.ClockView;
import local.mvc.Controller;

public class ClockController extends Thread implements Controller {

    private ClockModel clockModel;
    private ClockView clockView;

    private boolean clockCounting;

    public ClockController() {

        clockModel = new ClockModel(0, 0, 0);
        clockView = new ClockView();

        clockCounting = false;

        updateView();

    }

    public ClockModel getModel() {
        return clockModel;
    }

    public ClockView getView() {
        return clockView;
    }

    public void updateView() {
        clockView.update(clockModel);
    }

    public boolean getCounting() {
        return clockCounting;
    }

    public void setCounting(boolean b) {
        clockCounting = b;
    }


    public void run() {

        while (true) {

            if (clockCounting) {

                Integer clockTime = (clockModel.getClockHours() * 3600) + (clockModel.getClockMinutes() * 60) + clockModel.getClockSeconds();

                if (clockTime <= 0) {

                    MainController.getStatusController().ring();
                    MainController.getStatusController().getView().getStartButton().setText("start");

                    clockCounting = false;

                }


                clockTime -= 1;

                Integer hours = clockTime / 3600;

                clockTime -= 3600 * hours;

                Integer minutes = clockTime / 60;

                clockTime -= 60 * minutes;

                Integer seconds = clockTime;

                if (seconds < 0) {
                    seconds = 0;
                }

                clockModel.setClockHours(hours);
                clockModel.setClockMinutes(minutes);
                clockModel.setClockSeconds(seconds);

                updateView();

            }

            try {
                sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

    }

}
