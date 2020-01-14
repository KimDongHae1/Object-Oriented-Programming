package ParkingSystem;

public class SmallBus extends Vehicle {

    private int AdditionalCost = 0;
    private int BasicCost = 2000;
    public SmallBus( int VehicleNumber,Time time)
    {
        super(VehicleNumber,time);
    }

    public double GetAdditionalCost()
    {
        if (this.getTime().getYear() == 0 && this.getTime().getMonth() == 0 && 
        		this.getTime().getHour() == 0 && this.getTime().getMinute() < 60) {
            return 0;
        }
        else if(this.getTime().getYear() == 0 && this.getTime().getMonth() == 0 &&
        		this.getTime().getHour() == 1 && this.getTime().getMinute() == 0){
            return 0;
        }
        else if(this.getTime().getMinute()/30 == 0 && this.getTime().getMinute() == 0)
        {
            AdditionalCost =  this.getTime().getDay() * 48000 + (this.getTime().getHour()-1) * 2000;
            return AdditionalCost;
        }
        else if (this.getTime().getMinute()/30 == 0 && this.getTime().getMinute() != 0){
            AdditionalCost =  this.getTime().getDay() * 48000 + (this.getTime().getHour()-1) * 2000 + 1000;
            return AdditionalCost;
        }
        else if(this.getTime().getMinute()/30 == 1){
            AdditionalCost =  this.getTime().getDay() * 48000 + this.getTime().getHour() * 2000 + 2000;
            return AdditionalCost;
        }
        return 0;
    }
    @Override
    public double getFair() {
        double fair = BasicCost + this.GetAdditionalCost();
        return fair;
    }
    public String toString()
    {
        String string = "차량 종류 : 소형 버스" + ", 차량번호 : " + this.getVehicleNumber() + ", 입차 시간 : " + this.getTime().getYear()
                + "/" + this.getTime().getMonth() + "/" + this.getTime().getDay() +
                "  " + this.getTime().getHour() + ":" + this.getTime().getMinute();
        return string;
    }
    public void toString1(){
        if(this.getTime().getHour() == 0 && this.getTime().getMinute() < 60){
            System.out.println("주차 시간은 1시간 00 분 입니다.");
        }
        else if(this.getTime().getHour() == 1 && this.getTime().getMinute() == 0){
            System.out.println("주차 시간은 1시간 00 분 입니다.");
        }
        else if (this.getTime().getHour()!=0 && this.getTime().getMinute() == 0){
            System.out.println("주차 시간은 " + this.getTime().getDay() +" 일 " + this.getTime().getHour() + " 시간 " + "00분 입니다.");
        }
        else if(this.getTime().getHour() != 0 && this.getTime().getMinute() < 30){
            System.out.println("주차 시간은" + this.getTime().getHour() + " 시간 " + "30분 입니다.");
        }
        else {
            System.out.println("주차 시간은 " + (this.getTime().getHour()+1) + " 시간 " + "00분 입니다.");
        }

    }
    public int getType() {
    	return 4;
    }

}

