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
class ServiceBook implements Serializable {

    private Car car;
    private String[] serviceRecords;
    private int count;

    public ServiceBook(Car car) {
        this.car = car;
        serviceRecords = new String[10];
        count = 0;
        car.setSb(this);
    }

    public Car getCar() {

        return this.car;
    }
    
    @Override
    public String toString() {
        String tmp = "";
        for (int i = 0; i < count; i++) {
            tmp += serviceRecords[i] + "\n";
        }
        return tmp;

    }

    public void addRecord(String record) {
        if (count < serviceRecords.length) {
            serviceRecords[count] = record;
            count++;
        }
    }
}
