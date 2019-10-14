/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burcedb;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author 2ndyrGroupC
 */
public class Burcedb {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner input = new Scanner(System.in);
        Accounts account = new Accounts();
        PersonalInformation PersonalInfo = new PersonalInformation();

        account.connect();
        boolean flag = true;
        while (flag) {
            System.out.println("+++++Student Enrollment+++++\nSelect an option: \n1 = CREATE ACCOUNT\n2 = RETRIEVE\n3 = UPDATE\n4 = DELETE\n5 = SEARCH\n6 = SAVE\n7 = Exit");
            int optionAns = input.nextInt();
            switch (optionAns) {
                case 1:
                    System.out.println("-----------------Creating an account!-----------------");
                    account.createUserPass();
                    System.out.println("You want to add personal information?\npress 1 if yes\npress 2 if no");
                    int Pynoption = input.nextInt();
                    switch (Pynoption) {
                        case 1:
                            PersonalInfo.personalInformation();
                            break;
                        case 2:
                            break;
                    }
                    System.out.println("You want to add schedule?\npress 1 if yes\npress 2 if no");
                    int Synoption = input.nextInt();
                    switch (Synoption) {
                        case 1:
                            PersonalInfo.personalInformation();
                            break;
                        case 2:
                            break;
                    }
//                    courseUnitSched();
//                    System.out.println(Accounts1);
                    break;
                case 2:
                    System.out.println("SHOW/RETRIEVE:\n[1] ACCOUNTS\n[2] PERSONAL INFORMATION\n[3] SCHEDULES\n");
                    int retrieveOptionAns = input.nextInt();
                    switch (retrieveOptionAns) {
                        case 1:
//                            this.retrieveAccounts();
                            break;
                        case 2:
//                            this.retrievePInfo();
                            break;
                        case 3:
//                            this.retrieveSchedules();
                            break;
                    }

                    break;
                case 3:
                    System.out.println("Update:\n[1] PERSONAL INFORMATION\n[2] SCHEDULES\n");
                    int updateOptionAns = input.nextInt();
                    switch (updateOptionAns) {
                        case 1:
                            System.out.println("Press 1 : update personal Information\nPress 2: Add new personal Information");
                            int ar = input.nextInt();
                            switch (ar) {
                                case 1:
//                                    this.updatePInfo();
                                    break;
                                case 2:
//                                    this.addDataOnExistingAccountSched();
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("Press 1 : update schedule\nPress 2: Add new schedule");
                            int a = input.nextInt();
                            switch (a) {
                                case 1:
//                                    this.updateSchedules();
                                    break;
                                case 2:
//                                    this.addDataOnExistingAccountSched();
                                    break;
                            }
                            break;

                    }
                    break;
                case 4:
                    System.out.println("REMOVE:\n[1] PERSONAL INFORMATION\n[2] SCHEDULES\n");
                    int deleteOps = input.nextInt();
                    switch (deleteOps) {

                        case 1:
//                            this.removePInfo();
                            break;
                        case 2:
//                            this.removeSchedule();
                            break;
                    }
                    break;
                case 5:
                    System.out.println("SEARCH:\n[1] ACCOUNTS\n[2] PERSONAL INFORMATION\n[3] SCHEDULES\n");
                    int searchOptionAns = input.nextInt();
                    switch (searchOptionAns) {
                        case 1:
//                            this.searchAccounts();
                            break;
                        case 2:
//                            this.searchPInfo();
                            break;
                        case 3:
//                            this.searchDataInFileSchedule();
                            break;
                    }
                    break;
                case 6:
                    account.save();
                    account.getAcc_id();
                    PersonalInfo.saveinfo();
                    break;
                case 7:
                    System.out.println("thank you for using!!!");
                    flag = false;

            }
        }
        account.createUserPass();

    }//end main
}//end FirstExample

