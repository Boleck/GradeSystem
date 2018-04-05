package models;

import java.util.Vector;

public class ActivityEntity {
    SubjectModel subject;
    int duration = 45;
    int[] begin = {9,15};
    DayModel day;
    RoomModel room;
    TeacherModel teacher;
    GroupModel students;
}
