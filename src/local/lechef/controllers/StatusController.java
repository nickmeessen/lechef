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

import local.lechef.models.StatusModel;
import local.lechef.views.StatusView;
import local.mvc.Controller;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class StatusController implements ActionListener, Controller {

    private StatusView statusView;
    private StatusModel statusModel;

    public StatusController() {

        statusModel = new StatusModel();
        statusView = new StatusView();

        statusView.getStartButton().addActionListener(this);
        statusView.getResetButton().addActionListener(this);
        statusView.getChooseButton().addActionListener(this);
    }

    public StatusModel getModel() {
        return statusModel;
    }

    public StatusView getView() {
        return statusView;
    }

    public void updateView() {
        statusView.update(statusModel);
    }

    public void ring() {

        if (MainController.getItemsController().getModel().getShutdownEnabled()) {

            try {
                Runtime.getRuntime().exec("shutdown -s -t 00 -f");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else {

            statusModel.setUIenabled(false);

            updateView();

            MainController.getControlsController().updateView();

            int i = 3;

            while (i != 0) {


                MainController.getClockController().getView().flash();

                try {

                    Clip clip = AudioSystem.getClip();

                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(MainController.getItemsController().getModel().getCurrentItem().getModel().getSound());
                    
                    clip.open(inputStream);
                    clip.start();

                    Thread.sleep(clip.getMicrosecondLength() / 1000);

                } catch (FileNotFoundException ex) {

                    JOptionPane.showMessageDialog(statusView.getComponent(), "The chosen sound file (" + MainController.getItemsController().getModel().getCurrentItem().getModel().getSound().getAbsolutePath() + ") wasn't found!", "File Error!", JOptionPane.ERROR_MESSAGE);

                    break;

                } catch (Exception ex) {

                    ex.printStackTrace();

                    JOptionPane.showMessageDialog(statusView.getComponent(), "Something went wrong with playing the chosen file.", "Error!", JOptionPane.ERROR_MESSAGE);

                    break;

                }

                i--;

            }

            statusModel.setUIenabled(true);

            updateView();

            MainController.getControlsController().updateView();

        }

    }


    public void actionPerformed(ActionEvent ev) {

        if (ev.getSource().equals(statusView.getStartButton())) {

            if (MainController.getClockController().getCounting()) {
                MainController.getClockController().setCounting(false);
            } else {
                MainController.getClockController().setCounting(true);
            }

        } else if (ev.getSource().equals(statusView.getResetButton())) {

            MainController.getClockController().setCounting(false);

            MainController.getClockController().getModel().setClockHours(0);
            MainController.getClockController().getModel().setClockMinutes(0);
            MainController.getClockController().getModel().setClockSeconds(0);

            MainController.getClockController().updateView();

        } else if (ev.getSource().equals(statusView.getChooseButton())) {

            MainController.getItemsController().getView().setVisible(true);
        }

        updateView();

    }
}
