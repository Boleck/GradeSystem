package view;

import javafx.scene.canvas.Canvas;
import models.ActivityEntity;

public class ScheduleView {
    ScheduleView(Canvas canvas){
        //draw basic stuff, like vertical lines between days, colors etc.
    }
    void addActivitySubject(ActivityEntity activityEntity){
        activityEntity.getBegin();
        activityEntity.getDay();
    }

    private int getXByDay(int day){
        return 0;
    }
    private int getYByTime(int hour, int minutes){
        return 0;
    }
    private int getHByDuration(int duration){
        return 0;
    }
}
