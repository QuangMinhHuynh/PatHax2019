package pat.hacks.lifemanager;

import android.util.Log;

import java.util.HashMap;

public class TimeFormated {
    public TimeFormated(){};






    private long timeSec =  System.currentTimeMillis() / 1000L;
    private long timeHour = (((timeSec-(3600*4)) /3600)%24);
    private long timeMinute = (((timeSec-(3600*4))/60)%1440)%60;
    private long dayWeek = (((((timeSec-(3600*4))/86400)+4)%7));

    public String getYear(){
        int yearsSince = (((int)timeSec-(3600*4))/31557600);

        int currentYear = yearsSince+1970;
        return (Integer.toString(currentYear));
    }




    public String getTimeHour(){
        if(timeMinute<10){
            return (Integer.toString((int)timeHour)+":0"+timeMinute);
        }else{
            return (Integer.toString((int)timeHour)+":"+timeMinute);
        }
    }



    public int getDate(){

        int tempCount =0;

        int dayCount = 0;

        int countYear = 1970;


        int leapCount = 0;


        HashMap<Integer, Integer> monthsOfYear= new HashMap<Integer, Integer>();

        monthsOfYear.put(1,31);
        monthsOfYear.put(2,28);
        monthsOfYear.put(3,31);
        monthsOfYear.put(4,30);
        monthsOfYear.put(5,31);
        monthsOfYear.put(6,30);
        monthsOfYear.put(7,31);
        monthsOfYear.put(8,31);
        monthsOfYear.put(9,30);
        monthsOfYear.put(10,31);
        monthsOfYear.put(11,30);
        monthsOfYear.put(12,31);

        while(true){
            if (dayCount ==(timeSec-(3600*4))/86400) {
                int month = (tempCount + 1) % 12;

                int count = 0;
                for(int i =1; i<month;i++){
                    count+=monthsOfYear.get(i);
                }
                return tempCount+1-count;
            }
            if(tempCount == 365 & countYear % 4 !=0){
                tempCount=0;
                countYear++;

            }else if (tempCount == 366 ) {
                tempCount = 0;
                countYear++;
            }else{
                dayCount++;
                tempCount++;
            }
        }

    }


    public String getMonth(){
        int tempCount =0;

        int dayCount = 0;

        int countYear = 1970;


        int leapCount = 0;


        HashMap<Integer, String> monthsOfYear= new HashMap<Integer, String>();

        monthsOfYear.put(1,"Januayr");
        monthsOfYear.put(2,"Febuary");
        monthsOfYear.put(3,"March");
        monthsOfYear.put(4,"April");
        monthsOfYear.put(5,"May");
        monthsOfYear.put(6,"June");
        monthsOfYear.put(7,"July");
        monthsOfYear.put(8,"August");
        monthsOfYear.put(9,"September");
        monthsOfYear.put(10,"October");
        monthsOfYear.put(11,"November");
        monthsOfYear.put(12,"December");

        while(true){
            if (dayCount ==(timeSec-(3600*4))/86400){
                int month = (tempCount+1)%12;
                return monthsOfYear.get(month);
            }


            if(tempCount == 365 & countYear % 4 !=0){
                tempCount=0;
                countYear++;

            }else if (tempCount == 366 ) {
                tempCount = 0;
                countYear++;
            }else{
                dayCount++;
                tempCount++;
            }
        }

    }


    public String dayWeek(){
        HashMap<Integer, String> daysOfWeek = new HashMap<Integer, String>();

        daysOfWeek.put(0,"Sunday");
        daysOfWeek.put(1,"Monday");
        daysOfWeek.put(2,"Tuesday");
        daysOfWeek.put(3,"Wednesday");
        daysOfWeek.put(4,"Thursday");
        daysOfWeek.put(5,"Friday");
        daysOfWeek.put(6,"Saturday");

        return daysOfWeek.get((int)dayWeek);
    }



}
