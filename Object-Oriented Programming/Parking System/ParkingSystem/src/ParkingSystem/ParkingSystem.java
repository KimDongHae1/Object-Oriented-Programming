package ParkingSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class ParkingSystem
{
    public Car CarInParking(){
        Scanner sc = new Scanner(System.in);
        int Number;
        do{
            Number = sc.nextInt();
        }while (Number < 1000 || Number > 9999);

        Time time = new Time(0,0,0,0,0);
        Car car = new Car(Number,time);
        System.out.println("입차시간을 입력하세요!");
        time.InParking();
        return car;
    }

    public BigBus BigBusParking(){
        Scanner sc = new Scanner(System.in);
        int Number;
        do{
            Number = sc.nextInt();
        }while (Number < 1000 || Number > 9999);

        Time time = new Time(0,0,0,0,0);
        BigBus bigBus = new BigBus(Number,time);
        System.out.println("입차시간을 입력하세요!");
        time.InParking();
        return bigBus;
    }
    public MiddleBus MiddleBusParking(){
        Scanner sc = new Scanner(System.in);
        int Number;
        do{
            Number = sc.nextInt();
        }while (Number < 1000 || Number > 9999);

        Time time = new Time(0,0,0,0,0);
        MiddleBus middleBus = new MiddleBus(Number,time);
        System.out.println("입차시간을 입력하세요!");
        time.InParking();
        return middleBus;
    }
    public SmallBus SmallBusParking(){
        Scanner sc = new Scanner(System.in);
        int Number;
        do{
            Number = sc.nextInt();
        }while (Number < 1000 || Number > 9999);

        Time time = new Time(0,0,0,0,0);
        SmallBus smallBus = new SmallBus(Number,time);
        System.out.println("입차시간을 입력하세요!");
        time.InParking();
        return smallBus;
    }
    public BigTruck BigTruckParking(){
        Scanner sc = new Scanner(System.in);
        int Number;
        do{
            Number = sc.nextInt();
        }while (Number < 1000 || Number > 9999);

        Time time = new Time(0,0,0,0,0);
        BigTruck bigTruck = new BigTruck(Number,time);
        System.out.println("입차시간을 입력하세요!");
        time.InParking();
        return bigTruck;
    }
    public MiddleTruck MiddleTruckParking(){
        Scanner sc = new Scanner(System.in);
        int Number;
        do{
            Number = sc.nextInt();
        }while (Number < 1000 || Number > 9999);
        Time time = new Time(0,0,0,0,0);
        MiddleTruck middleTruck = new MiddleTruck(Number,time);
        System.out.println("입차시간을 입력하세요!");
        time.InParking();
        return middleTruck;
    }
    public SmallTruck SmallTruckParking(){
        Scanner sc = new Scanner(System.in);
        int Number;
        do{
            Number = sc.nextInt();
        }while (Number < 1000 || Number > 9999);
        Time time = new Time(0,0,0,0,0);
        SmallTruck smallTruck = new SmallTruck(Number,time);
        System.out.println("입차시간을 입력하세요!");
        time.InParking();
        return smallTruck;
    }

}
