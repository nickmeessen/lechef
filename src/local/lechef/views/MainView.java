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

import com.explodingpixels.widgets.WindowUtils;
import local.lechef.controllers.MainController;
import local.mvc.Model;
import local.mvc.View;

import javax.swing.*;
import java.awt.*;

public class MainView implements View {

    private JFrame mainFrame;

    public MainView() {

        mainFrame = new JFrame();

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel bottomPanel = new JPanel(new BorderLayout());

        bottomPanel.add(MainController.getControlsController().getView().getComponent(), BorderLayout.NORTH);
        bottomPanel.add(MainController.getStatusController().getView().getComponent(), BorderLayout.SOUTH);

        mainPanel.add(MainController.getClockController().getView(), BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        mainFrame.setContentPane(mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(380, 170);
        mainFrame.setTitle("LeChef - Cooking Timer");
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);

        WindowUtils.installJComponentRepainterOnWindowFocusChanged(mainFrame.getRootPane());

    }

    public void update(Model model) {
    }

}
