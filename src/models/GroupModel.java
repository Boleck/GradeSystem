package models;

import entity.StudentEntity;

import java.util.HashSet;

public class GroupModel {
    String id;
    HashSet<StudentEntity> students;
    String name;//
    int year; //1-8
    int scheduleId;
}
