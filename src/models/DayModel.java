package models;

public class DayModel {
    public static DayModel Monday = new DayModel(0);
    public static DayModel Tuesday = new DayModel(1);
    public static DayModel Wednesday = new DayModel(2);
    public static DayModel Thursday = new DayModel(3);
    public static DayModel Friday = new DayModel(4);
    public static DayModel Satrusday = new DayModel(5);
    private final int dayNumber;

    private int getDayNumber() {
        return dayNumber;
    }

    private DayModel(int dayNumber){
        this.dayNumber = dayNumber;
    }

    @Override
    public boolean equals(Object obj) {
        return dayNumber == ((DayModel)obj).getDayNumber();
    }

}
