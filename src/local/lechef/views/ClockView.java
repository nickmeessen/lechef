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

import com.explodingpixels.macwidgets.MacWidgetFactory;
import local.lechef.models.ClockModel;
import local.mvc.Model;
import local.mvc.View;

import javax.swing.*;
import java.awt.*;

public class ClockView extends JPanel implements View {

    private JLabel hoursL;
    private JLabel hoursR;

    private JLabel minutesL;
    private JLabel minutesR;

    private JLabel secondsL;
    private JLabel secondsR;


    public ClockView() {

        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBackground(Color.LIGHT_GRAY);


        JLabel sepL = MacWidgetFactory.createEmphasizedLabel(" : ");
        JLabel sepR = MacWidgetFactory.createEmphasizedLabel(" : ");

        sepL.setFont(sepL.getFont().deriveFont(40.0f));
        sepR.setFont(sepR.getFont().deriveFont(40.0f));

        hoursL = new JLabel("");
        hoursR = new JLabel("");

        hoursL.setFont(hoursL.getFont().deriveFont(60.0f));
        hoursR.setFont(hoursR.getFont().deriveFont(60.0f));


        minutesL = new JLabel("");
        minutesR = new JLabel("");

        minutesL.setFont(minutesL.getFont().deriveFont(60.0f));
        minutesR.setFont(minutesR.getFont().deriveFont(60.0f));


        secondsL = new JLabel("");
        secondsR = new JLabel("");

        secondsL.setFont(secondsL.getFont().deriveFont(60.0f));
        secondsR.setFont(secondsR.getFont().deriveFont(60.0f));

        add(Box.createHorizontalGlue());

        add(hoursL);
        add(Box.createHorizontalStrut(2));
        add(hoursR);

        add(sepL);

        add(minutesL);
        add(Box.createHorizontalStrut(2));
        add(minutesR);

        add(sepR);

        add(secondsL);
        add(Box.createHorizontalStrut(2));
        add(secondsR);

        add(Box.createHorizontalGlue());

    }

    public void update(Model model) {

        ClockModel clockModel = (ClockModel) model;

        setClockHours(clockModel.getClockHours());
        setClockMinutes(clockModel.getClockMinutes());
        setClockSeconds(clockModel.getClockSeconds());

    }


    public void setClockHours(Integer clockHours) {

        if (clockHours < 10) {

            hoursL.setText("0");
            hoursR.setText(clockHours.toString());

        } else {

            String hrs = clockHours.toString();

            hoursL.setText(hrs.substring(0, 1));
            hoursR.setText(hrs.substring(1, 2));

        }

    }

    public void setClockMinutes(Integer clockMinutes) {

        if (clockMinutes < 10) {

            minutesL.setText("0");
            minutesR.setText(clockMinutes.toString());

        } else {

            String mins = clockMinutes.toString();

            minutesL.setText(mins.substring(0, 1));
            minutesR.setText(mins.substring(1, 2));

        }

    }

    public void setClockSeconds(Integer clockSeconds) {

        if (clockSeconds < 10) {

            secondsL.setText("0");
            secondsR.setText(clockSeconds.toString());

        } else {

            String secs = clockSeconds.toString();

            secondsL.setText(secs.substring(0, 1));
            secondsR.setText(secs.substring(1, 2));

        }

    }

    public void flash() {


        setBackground(Color.DARK_GRAY);


        try {
            Thread.sleep(150);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setBackground(Color.LIGHT_GRAY);

    }

}
