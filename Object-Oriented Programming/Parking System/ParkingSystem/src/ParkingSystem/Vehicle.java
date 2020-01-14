package ParkingSystem;

import java.util.*;

public abstract class Vehicle // 기본적으로 차에 대한 정보들 이
{
    private int VehicleNumber;// 각 차에대한 차량 번호.
    private Time time;
    private double fair;


    public Vehicle(int VehicleNumber,Time time){
        this.VehicleNumber = VehicleNumber;
        this.time = time;

    }
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getVehicleNumber() {
        return VehicleNumber;
    }
    public void setVehicleNumber(int vehicleNumber) {
        this.VehicleNumber = vehicleNumber;
    }
    public double getFair(){
        return fair;
    }
    public abstract void toString1();
    public abstract double GetAdditionalCost();
    public abstract int getType();

}
