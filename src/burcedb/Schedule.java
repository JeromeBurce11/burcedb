/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burcedb;

import java.util.Scanner;

/**
 *
 * @author 2ndyrGroupC
 */
public class Schedule {
    Scanner input = new Scanner(System.in);

    private int id;
    private int accId;
    private String course;
    private int year;
    private int units;
    private String schedule;
    private String subject;

    public Schedule() {
    }

    public Schedule(int id, int accId, String course, String schedule, int units) {
        this.id = id;
        this.accId = accId;
        this.course = course;

        this.units = units;
        this.schedule = schedule;

    }

    public Schedule(int id, int AccountId, String course, int units, String schedule) {
        this.id = id;
        this.accId = AccountId;
        this.course = course;
        this.units = units;
        this.schedule = schedule;
        //To change body of generated methods, choose Tools | Templates.
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public String getSubject() {
        return subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String toString() {
        return String.format("%d\t%d\t%s\t%d\t%s", this.id, this.accId, this.course, this.units, this.schedule);
    }

    public void courseUnitSched() {

        while (true) {
            System.out.println("You want to add a subject?\nPress 1 = if yes\nPress 0 = if no");
            int ans = input.nextInt();
            try {
                if (ans == 1) {
                    System.out.print("Course: ");
                    String course = input.next();
                    checkUnit();
                    System.out.print("Schedule: ");
                    String schedule = input.next();

                } else {
                    break;
                }
            } catch (Exception e) {
                break;
            }

        }
        System.out.println("Your schedule was been saved.");

    }

    public void checkUnit() {

        String unit;
        while (true) {
            try {
                while (true) {
                    System.out.println("Unit: ");
                    Scanner units = new Scanner(System.in);
                    unit = units.nextLine();
                    int convert = Integer.parseInt(unit);
                    if (convert == 0) {
                        System.out.println("unit must not equal to 0 !");
                    } else {
                        break;
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("Unit must be an integer!");
            }
        }
        this.units = Integer.parseInt(unit);
    }

}
