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

package local.lechef.models;

import local.mvc.Model;

public class ClockModel implements Model {

    private Integer clockHours;
    private Integer clockMinutes;
    private Integer clockSeconds;

    public ClockModel(Integer hours, Integer minutes, Integer seconds) {

        clockHours = hours;
        clockMinutes = minutes;
        clockSeconds = seconds;

    }


    public Integer getClockHours() {
        return clockHours;
    }

    public void setClockHours(Integer clockHours) {

        if (clockHours > 99) {
            clockHours = 0;
        }

        this.clockHours = clockHours;
    }

    public Integer getClockMinutes() {
        return clockMinutes;
    }

    public void setClockMinutes(Integer clockMinutes) {

        if (clockMinutes > 59) {
            clockMinutes = 0;
        }

        this.clockMinutes = clockMinutes;
    }

    public Integer getClockSeconds() {
        return clockSeconds;
    }

    public void setClockSeconds(Integer clockSeconds) {

        if (clockSeconds > 59) {
            clockSeconds = 0;
        }

        this.clockSeconds = clockSeconds;
    }
}
