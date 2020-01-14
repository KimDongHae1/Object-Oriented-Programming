package ParkingSystem;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main{
    @SuppressWarnings("unchecked")
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("주차장의 크기를 선택하시오!");
        int size = sc.nextInt();
        ArrayList <Vehicle> Parking = new ArrayList(size);
        int set; // 기능을 선택한다.
        int TotalMoney = 0;
        boolean SystemSet = true;
        ParkingSystem parkingSystem = new ParkingSystem();

        while (SystemSet){
            System.out.println("원하는 기능을 선택하세요!");
            System.out.println("1. 입차");
            System.out.println("2. 출차");
            System.out.println("3. 주차 차량 보기");
            System.out.println("4. 오늘 총 수입 보기");
            System.out.println("5. 종료");
            boolean continueLoop = true;
            int base;
            do {
                try {
                    set = sc.nextInt();
                   if (set > 0 && set < 6 )
                       continueLoop = false;
                }
                catch (InputMismatchException inputMismatchException ){
                    System.err.printf("%nException: %s%n", inputMismatchException);
                    sc.nextLine();
                    set= sc.nextInt();
                }
                if (set > 5)
                {
                    System.out.println("범위 안의 숫자가 아닙니다. 다시 입력하세요");
                }
            } while (continueLoop);  // 1~5까지만 출력 가능하게 함.

            switch (set) {
                case 1: // 입차를 하는 부분.
                    System.out.println("차량 종류 및 용량을 입력하세요!");
                    char CarType;
                    do{
                            CarType = sc.next().charAt(0);
                    }while (CarType != 'c' && CarType != 't' && CarType != 'b');

                    int CarVolume = sc.nextInt();

                    if (CarType == 'c' && CarVolume == 0) {
                        System.out.println("차량번호를 입력하세요");
                        Parking.add(parkingSystem.CarInParking());
                        break;
                    }
                    else if (CarType == 'b' && CarVolume > 40){
                        System.out.println("차량번호를 입력하세요");
                        Parking.add(parkingSystem.BigBusParking());
                        break;
                    }
                    else if (CarType == 'b' && CarVolume < 40 && CarVolume > 24)
                    {
                        System.out.println("차량번호를 입력하세요");
                        Parking.add(parkingSystem.MiddleBusParking());
                        break;
                    }
                    else if (CarType == 'b' && CarVolume < 24 ){
                        System.out.println("차량번호를 입력하세요");
                        Parking.add(parkingSystem.SmallBusParking());
                        break;
                    }
                    else if(CarType == 't' && CarVolume > 10){
                        System.out.println("차량번호를 입력하세요");
                        Parking.add(parkingSystem.BigTruckParking());
                        break;
                    }
                    else if (CarType == 't' && CarVolume < 10 && CarVolume > 5){
                        System.out.println("차량번호를 입력하세요");
                        Parking.add(parkingSystem.MiddleTruckParking());
                        break;
                    }
                    else if (CarType == 't' && CarVolume < 5){
                        System.out.println("차량번호를 입력하세요");
                        Parking.add(parkingSystem.SmallTruckParking());
                        break;
                    } // 각 종류에 따라 차량을 넣는다. ArrayList의 add 사용.
                    break;
                case 2:
                    if (Parking.isEmpty() == false) // ArrayList에 차량이 있는 경우 차량번호 입력.
                    {
                        Boolean bool = true;
                        while (bool) {
                            System.out.println("출차할 차량번호를 입력하세요!");
                            int CarNumber = sc.nextInt();
                            for (int i = 0; i < Parking.size(); i++) {
                                if (Parking.get(i).getVehicleNumber() == CarNumber) { // 입력받은 차량번호가 주차장의 차량번호와 일치하는 게 있는지.
                                    Parking.get(i).getTime().OutParking();
                                    Parking.get(i).toString1();
                                    System.out.println("주차 사용 요금 : " + Parking.get(i).getFair());
                                    TotalMoney += Parking.get(i).getFair();
                                    Parking.remove(i); // 돈 계산을 한 후 ArrayList.remove를 이용해 제거.
                                    bool = false;
                                }
                            }
                        }
                    } 
                    else // ArrayList에 차량이 없는 경우 출차할 차량이 없다고 출력.
                    {
                        System.out.println("출차할 차량이 없습니다.");
                    }
                    break;
                case 3:
                    if(Parking.isEmpty()) // 주차장에 차량이 있나 본다.
                    {
                        System.out.println("주차장에 주차된 차량이 없습니다! ");
                    }
                    else{ // 있을 경우 모든 차량 출력.
                    	DescendingObj descending = new DescendingObj();
                    	Collections.sort(Parking, descending);
	
                    	for (int i = 0; i < Parking.size(); i++) {
                            if(Parking.get(i).getType() == 1) {
                            	 System.out.println(Parking.get(i).toString());
                            }
                        }
                        for (int i = 0; i < Parking.size(); i++) {
                            if(Parking.get(i).getType() == 2) {
                                System.out.println(Parking.get(i).toString());
                            }
                        }
                        for (int i = 0; i < Parking.size(); i++) {
                            if(Parking.get(i).getType() == 3) {
                                System.out.println(Parking.get(i).toString());
                            }
                        }
                        for (int i = 0; i < Parking.size(); i++) {
                            if(Parking.get(i).getType() == 4) {
                                System.out.println(Parking.get(i).toString());
                            }
                        }
                        for (int i = 0; i < Parking.size(); i++) {
                            if(Parking.get(i).getType() == 5) {
                                System.out.println(Parking.get(i).toString());
                            }
                        }
                        for (int i = 0; i < Parking.size(); i++) {
                            if(Parking.get(i).getType() == 6) {
                                System.out.println(Parking.get(i).toString());
                            }
                        }
                        for (int i = 0; i < Parking.size(); i++) {
                            if(Parking.get(i).getType() == 7) {
                                System.out.println(Parking.get(i).toString());
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("오늘 하루 총 수입 : " +TotalMoney);
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
// 이 클래스는 차량을 정렬할 때 사용하는 클래스이다.
class DescendingObj implements Comparator<Vehicle>
{

	@Override
	public int compare(Vehicle o1, Vehicle o2) {
		if (o1.getTime().getYear() != o2.getTime().getYear()) {
			return o1.getTime().getYear()  - o2.getTime().getYear();
		}
		else {
			if (o1.getTime().getMonth() != o2.getTime().getMonth()) {
				return o1.getTime().getMonth() - o2.getTime().getMonth();
			}
			else {
				if (o1.getTime().getDay() != o2.getTime().getDay()) {
					return o1.getTime().getDay() - o2.getTime().getDay();
				}
				else {
					if (o1.getTime().getHour() != o2.getTime().getHour()) {
						return o1.getTime().getHour() - o2.getTime().getHour();
					}
					else {
						if(o1.getTime().getMinute() != o2.getTime().getMinute()) {
							return o1.getTime().getMinute() - o2.getTime().getMinute();
						}
					}
				}	
			}
		}
		return o1.getTime().getYear()  - o2.getTime().getYear();
	}
	
}
