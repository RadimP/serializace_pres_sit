/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network_serialization;

import java.io.Serializable;

/**
 *
 * @author Director itSTEP
 */
class Timespan implements Serializable {

    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    public Timespan() {

    }

    public Timespan(Timespan ts) {
        this.second = ts.getSeconds();
        this.minute = ts.getminutes();
        this.hour = ts.getHours();

    }

    public Timespan(int seconds) throws Exception {

        this(seconds / 60, seconds % 60);
    }

    public Timespan(int minute, int seconds) throws Exception {

        this(minute / 60, minute % 60, seconds);
    }

    public Timespan(int hour, int minute, int seconds) throws Exception {
        this.setTime(hour, minute, seconds);

    }

    public void setTime(int hours, int minutes, int seconds) throws Exception {

        if (seconds >= 0 && seconds < 60) {

            this.second = seconds;
            if (minutes >= 0 && minutes < 60) {
                this.minute = minutes;
                if (hours >= 0) {
                    this.hour = hours;
                } else {
                    throw new Exception("Bad hours!");
                }

            } else {
                throw new Exception("Bad minutes!");
            }
        } else {
            throw new Exception("Bad seconds!");
        }

    }

    public int getSeconds() {

        return this.second;
    }

    public int getminutes() {

        return this.minute;
    }

    public int getHours() {

        return this.hour;
    }

    public int getTotalSecond() {

        return this.hour * 3600 + this.minute * 60 + this.second;
    }

    public int compareTo(Object o) {

        return this.getTotalSecond() - ((Timespan) o).getTotalSecond();
    }
    
    @Override
 public String toString() {
 return hour + " h, " + minute +" min, " + second +" s";
 }    
    
}
