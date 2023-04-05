package com.example.linkage;

import com.linkage.MyApplication;
import com.linkage.mapper.AdMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
@SpringBootTest(classes = MyApplication.class)
public class testForDate {
    @Autowired
    AdMapper adMapper;
    @Test
    public void test1(){
        String[] weekDays={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        String[] months={"January","February","March","April","May","June","July","August","September","October","November","December"};
//        Date date=adMapper.test1();
        String res="";
        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
        System.out.println(cal.getWeekYear());
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
        System.out.println(cal.get(Calendar.MONTH));
        boolean isFirstSunday = cal.getFirstDayOfWeek()==Calendar.SUNDAY;
        int weekDay=cal.get(Calendar.DAY_OF_WEEK);
        if(isFirstSunday){
            weekDay=weekDay-1;
            if(weekDay==0){
                weekDay=7;
            }
        }
        int day=cal.get(Calendar.DAY_OF_MONTH);
        int month=cal.get(Calendar.MONTH);
        int year=cal.getWeekYear();
        res=res.concat(weekDays[weekDay-1]+", "+day+" "+months[month]+" "+year);
        System.out.println(res);
    }


}
