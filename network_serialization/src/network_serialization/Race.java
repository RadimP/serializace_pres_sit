/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network_serialization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Director itSTEP
 */
public class Race implements Serializable {

    private int lenght = 0;//v metech
    private ArrayList<Car> cars = new ArrayList<Car>();
    private ArrayList<RaceResult> raceResults = new ArrayList<RaceResult>();
    private boolean ready = false;

    public Race(int lenght) {

        this.lenght = lenght;
    }

    public void addRacingCar(Car car) {
        if (!ready) {
            this.cars.add(car);
        }
    }

    public String getWinner() {
        if (ready) {
            return this.raceResults.get(0).car.toString();
        } else {
            return null;
        }
    }

    public void getResult() throws Exception {
        if (!ready) {
            ready = true;

            for (int i = 0; i < this.cars.size(); i++) {
                try {
                    this.raceResults.add(
                            new RaceResult(this.cars.get(i),
                                    new Timespan(
                                            this.lenght / this.cars.get(i).getSpeed()
                                    )
                            )
                    );
                } catch (ArithmeticException e) {
                    System.out.println("You can't divide a length by zero speed. Enter new postive value by " + this.cars.get(i).getnanufacture() + " " + this.cars.get(i).getmodelName() + " " + this.cars.get(i).getYear());
                    this.cars.get(i).setNewSpeed();
                    i--;
                } catch (NumberFormatException e) {
                    System.out.println("Number format exception occurred by " + this.cars.get(i).getnanufacture() + " " + this.cars.get(i).getmodelName() + " " + this.cars.get(i).getYear() + " or by" + this.lenght);
                } catch (Exception e) {
                    if (this.lenght < 0) {
                        System.out.println("Bad lenght! It cannot be less than zero. Enter new postive value!");
                        setNewLenght();
                    } else if (this.cars.get(i).getSpeed() < 0) {
                        System.out.println("Bad speed! It cannot be less than zero. Enter new postive value by " + this.cars.get(i).getnanufacture() + " " + this.cars.get(i).getmodelName() + " " + this.cars.get(i).getYear());
                        this.cars.get(i).setNewSpeed();
                    }
                    i--;
                }

            }
            Collections.sort(this.raceResults);

        }

    }

    public void printresultsList() {
        System.out.println("Seznam výsledků");
        int i = 1;
        for (RaceResult value : this.raceResults) {
            System.out.println(i + ". " + value);
            i++;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Délka dráhy závodu: " + this.lenght + "\n" + "Počet aut: " + this.cars.size() + "\n";

    }

    public void printListofCars() {
        System.out.println("Seznam aut (v pořadí zápisu)");
        int i = 1;
        for (Car value : this.cars) {
            System.out.println(i + ". " + this.cars.get(i - 1).getnanufacture() + " " + this.cars.get(i - 1).getmodelName() + " " + this.cars.get(i - 1).getYear());
            i++;
        }
        System.out.println();
    }

    public void setNewLenght() {
        while (this.lenght < 0) {
            Scanner sc = new Scanner(System.in);
            int newlenght = sc.nextInt();
            this.lenght = newlenght;
        }
        
    }
}
