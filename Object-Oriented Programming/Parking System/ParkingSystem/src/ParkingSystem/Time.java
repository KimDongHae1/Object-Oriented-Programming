package ParkingSystem;

import java.util.Scanner;
/*
입차 시간과 출차 시간을 입력 받는 클래스.
 */
public class Time {
    Scanner sc = new Scanner(System.in);
    private int year, month, day, hour, minute;

    public Time(int year, int month, int day, int hour, int minute) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void InParking() {
        int InYear, InMonth, InDay, InHour, InMinute;
        InYear = sc.nextInt();
        InMonth = sc.nextInt();
        InDay = sc.nextInt();
        InHour = sc.nextInt();
        InMinute = sc.nextInt();
        this.year = InYear;
        this.month = InMonth;
        this.day = InDay;
        this.hour = InHour;
        this.minute = InMinute;

    } // 입차 시간을 입력받고 차량의 입차 시간을 저장하는 메소드.

    public void OutParking() // 출차에 대한 모든 것을 나타내는 메소드.
    {
        System.out.println("출차 시간을 입력하세요!");
        Boolean bool = true;
        while (bool) {
            int OutYear, OutMonth, OutDay, OutHour, OutMinute;
            OutYear = sc.nextInt();
            OutMonth = sc.nextInt();
            OutDay = sc.nextInt();
            OutHour = sc.nextInt();
            OutMinute = sc.nextInt();
            if (OutYear - this.getYear() < 0) {
                System.out.println("입차 시간이 출차 시간보다 늦을 수 없습니다. 다시 입력하세요!");
            } else if (OutYear - this.getYear() == 0 && OutMonth - this.getMonth() < 0) {
                System.out.println("입차 시간이 출차 시간보다 늦을 수 없습니다. 다시 입력하세요!");
            } else if (OutYear - this.getYear() == 0 && OutMonth - this.getMonth() == 0 && OutDay - this.getDay() < 0) {
                System.out.println("입차 시간이 출차 시간보다 늦을 수 없습니다. 다시 입력하세요!");
            } else if (OutYear - this.getYear() == 0 && OutMonth - this.getMonth() == 0 && OutDay - this.getDay() == 0 && OutHour - this.getMonth() < 0) {
                System.out.println("입차 시간이 출차 시간보다 늦을 수 없습니다. 다시 입력하세요!");
            } else if (OutYear - this.getYear() == 0 && OutMonth - this.getMonth() == 0 && OutDay - this.getDay() == 0 && OutHour - this.getMonth() == 0
                    && OutMinute - this.getMinute() < 0) {
                System.out.println("입차 시간이 출차 시간보다 늦을 수 없습니다. 다시 입력하세요!");
            } else if (OutYear - this.getYear() == 1 && OutMonth + 11 - this.getMonth() > 1 && OutDay + 29 - this.getDay() > 0) {
                System.out.println("30일 이상 주차할 수 없습니다. 출차시간을 다시 입력하세요! ");
            } else if (OutYear - this.getYear() > 1 || OutMonth - this.getMonth() > 1 || OutDay - this.getDay() > 30) {
                System.out.println("30일 이상 주차할 수 없습니다. 출차시간을 다시 입력하세요! ");
            } else if (OutMonth - this.getMonth() >= 1 && OutDay - this.getDay() >= 1) {
                System.out.println("30일 이상 주차할 수 없습니다. 출차시간을 다시 입력하세요! ");
            } else {
                if(this.getMonth() == 1 || this.getMonth() == 3 || this.getMonth() == 5 || this.getMonth() == 7 || this.getMonth() == 8 ||
                this.getMonth() ==  10 || this.getMonth() == 12) {
                    this.setYear(OutYear - this.getYear());
                    this.setMonth(OutMonth - this.getMonth());
                    this.setDay(OutDay - this.getDay());
                    this.setHour(OutHour - this.getHour());
                    this.setMinute(OutMinute - this.getMinute());

                    this.OverTimeMinute();
                    this.OverTimeHour();
                    this.OverTimeDay();
                    this.OverTimeMonth();
                }
                else if (this.getMonth() == 2){
                    this.setYear(OutYear - this.getYear());
                    this.setMonth(OutMonth - this.getMonth());
                    this.setDay(OutDay - this.getDay());
                    this.setHour(OutHour - this.getHour());
                    this.setMinute(OutMinute - this.getMinute());

                    this.OverTimeMinute();
                    this.OverTimeHour();
                    this.OverTimeDay2();
                    this.OverTimeMonth();
                }
                else{
                    this.setYear(OutYear - this.getYear());
                    this.setMonth(OutMonth - this.getMonth());
                    this.setDay(OutDay - this.getDay());
                    this.setHour(OutHour - this.getHour());
                    this.setMinute(OutMinute - this.getMinute());

                    this.OverTimeMinute();
                    this.OverTimeHour();
                    this.OverTimeDay3();
                    this.OverTimeMonth();
                }

                bool = false;
            }

        }

    }
/*
 * 시간 계산에서 올림이 필요할때 사용할 메소드들.
 */
    public void OverTimeMinute() {
        if (this.minute < 0) {
            this.hour -= 1;
            this.minute += 60;
        }
    }
    public void OverTimeHour(){
        if(this.hour < 0) {
            this.day -= 1;
            this.hour += 24;
        }
    }
    public void OverTimeDay(){
        if(this.day < 0) {
            this.month -= 1;
            this.day += 31;
        }
    }
    public void OverTimeMonth(){
        if(this.month < 0) {
            this.year -= 1;
            this.month += 12;
        }
    }
    public void OverTimeDay2(){
        if(this.day < 0) {
            this.month -= 1;
            this.day += 28;
        }
    }
    public void OverTimeDay3(){
        if(this.day < 0) {
            this.month -= 1;
            this.day += 30;
        }
    }

}

