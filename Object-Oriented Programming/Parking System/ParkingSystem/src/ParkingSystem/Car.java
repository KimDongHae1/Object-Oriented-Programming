package ParkingSystem;

public class Car extends Vehicle {

    private int AdditionalCost = 0;
    private int BasicCost = 1000;
    public Car(int VehicleNumber,Time time)
    {
        super(VehicleNumber,time);
    }

    public double GetAdditionalCost() //Car Class의 추가 비용 계산.
        {
            if (this.getTime().getYear() == 0 && this.getTime().getMonth() == 0 && this.getTime().getDay() == 0 &&
            		this.getTime().getHour() == 0 && this.getTime().getMinute() < 30) {
                return 0;
            }
            else if(this.getTime().getMinute()%10 == 0)
            {
               AdditionalCost =  this.getTime().getDay() * 72000 + this.getTime().getHour() * 3000 + ((this.getTime().getMinute()- 30)/10 * 500);
               return AdditionalCost;
            }
            else{
                AdditionalCost =  this.getTime().getDay() * 72000 + this.getTime().getHour() * 3000 + ((this.getTime().getMinute()-30)/10+1)*500;
                return AdditionalCost;
            }
        }
    @Override
    public double getFair() // 차량의 전체 요금 계산.
    {
        double fair = BasicCost + this.GetAdditionalCost();
        return fair;
    }
    public String toString()
    {
        String string = "차량 종류 : 승용차" + ", 차량번호 : " + this.getVehicleNumber() + ", 입차 시간 : " + this.getTime().getYear()
                + "/" + this.getTime().getMonth() + "/" + this.getTime().getDay() +
                "  " + this.getTime().getHour() + ":" + this.getTime().getMinute();
        return string;
    }
    public void toString1(){
        String sys;
        if(this.getTime().getMinute()%10 == 0) {
             System.out.println("주차 시간은 "+this.getTime().getDay()+ " 일 " + this.getTime().getHour() + " 시간 " + this.getTime().getMinute() + " 분 입니다.");
        }
        else {
            System.out.println("주차 시간은 " + this.getTime().getDay()+" 일 " +this.getTime().getHour() + " 시간 " + (this.getTime().getMinute()/10+1)*10 + " 분 입니다.");
        }

    }
    public int getType() {
    	return 1;
    }


}
