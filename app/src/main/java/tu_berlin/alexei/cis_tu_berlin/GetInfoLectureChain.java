package tu_berlin.alexei.cis_tu_berlin;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

/**
 * Created by Alexei on 03.02.2016.
 */
public class GetInfoLectureChain {
    private ArrayList<String> argParent = new ArrayList<String>();
    private ArrayList<Object> argChildOne = new ArrayList<Object>();
    private ArrayList<Object> argChildTwo = new ArrayList<Object>();
    private ArrayList<Object> argChildThree = new ArrayList<Object>();


    public GetInfoLectureChain(){
    }

    public void setChildToParent(AddChildToParent arg, String[] argMain, String[][] lecTitle, String[][] lecSemester, String[][] lecProfessor){
        argParent = arg.getRoomNumber(argMain);
        argChildOne = arg.getLecName(lecTitle);
        argChildTwo = arg.getLecSemester(lecSemester);
        argChildThree = arg.getLecProfessor(lecProfessor);
    }
    
    public void findFloorNumberForLectureDay(int floorNumber, int dayType, String subDepartment, int indexZone){
        // floorNumber finds the floor number by mac address, see getFloorByMac() in MainActivity
        switch (floorNumber){
            case 5:
                findIndexZoneAndDepartmentByDay(dayType, subDepartment, indexZone);
                break;
            case 6:
                findIndexZoneAndDepartmentByDay(dayType, subDepartment, indexZone);
                break;
        }
    }

    private void findIndexZoneAndDepartmentByDay(int dayType, String subDepartment, int indexZone){
        switch (dayType){
            case 0: // All Days
                if(subDepartment.equals("NoSubDepartment")) {
                    findIndexZoneForAllDaysWithoutSubDep(indexZone);
                } else {
                    findIndexZoneForAllDaysWithSubDep(subDepartment, indexZone);
                }
                break;
            case 2: // Monday
                if(subDepartment.equals("NoSubDepartment")) {
                    findIndexZoneForMonWithoutSubDep(indexZone);
                } else {
                    findIndexZoneForMonWithSubDep(subDepartment, indexZone);
                }
                break;
            case 3: // Tuesday
                if(subDepartment.equals("NoSubDepartment")) {
                    findIndexZoneForTueWithoutSubDep(indexZone);
                } else {
                    findIndexZoneForTueWithSubDep(subDepartment, indexZone);
                }
                break;
            case 4: // Wednesday
                if(subDepartment.equals("NoSubDepartment")) {
                    findIndexZoneForWedWithoutSubDep(indexZone);
                } else {
                    findIndexZoneForWedWithSubDep(subDepartment, indexZone);
                }
                break;
            case 5: // Thursday
                if(subDepartment.equals("NoSubDepartment")) {
                    findIndexZoneForThuWithoutSubDep(indexZone);
                } else {
                    findIndexZoneForThuWithSubDep(subDepartment, indexZone);
                }
                break;
            case 6: // Friday
                if(subDepartment.equals("NoSubDepartment")) {
                    findIndexZoneForFriWithoutSubDep(indexZone);
                } else {
                    findIndexZoneForFriWithSubDep(subDepartment, indexZone);
                }
                break;
            case 1: // Sunday
            case 7: // Saturday
            default:
                break;
        }
    }

    // All Days
    private void findIndexZoneForAllDaysWithoutSubDep(int indexZone) {
        switch (indexZone) {
            case 1:
                String[] r1 = {"H6131", "H6134"};
                String[][] l1 = {{"Geoinformation Technology", "Introduction to Satellite Geodesy", "Geo Databases", "Adjustment Calculation I", "Transformation of Geodetic Networks", "Selected Topics in Planetary Science", "Planetary and Space Science Project",
                        "Geodetic Colloquium", "Statistic Test Procedures and Analysis of Stochastic Processes", "Engineering Geodesy and Adjustment Calculation Project", "Geodetic Basics and Monitoring Measurements"},
                        // Next
                        {"GIS Project", "Web Cartography"}};
                String[][] s1 = {{"WS (1)", "WS (1)", "WS (1)", "WS (1)", "WS (3)", "WS (1)", "WS (3)",
                        "Special", "WS (3)", "WS (3)", "WS (3)"},
                        //
                        {"WS (3)", "WS (3)"}};
                String[][] p1 = {{"Kada/Becker/König", "Oberst/Flechtner/Schuh/Galas/Heinkelmann", "König", "Neitzel/Weisbrich", "Neitzel/Weisbrich", "Hussmann", "Oberst/Flechtner/Schuh",
                        "Neitzel/H.G.Becker", "Neitzel/Weisbrich", "Neitzel/Weisbrich", "Neitzel/Wujanz"},
                        //
                        {"Kada", "Kada"}};
                AddChildToParent one = new AddChildToParent();
                setChildToParent(one, r1, l1, s1, p1);
                break;
            case 2:
                String[] r2 = {"R2221", "R2222"};
                String[][] l2 = {{"Adjustment Calculation I", "Basics in Engineering Surveys"}, {"Adjustment Calculation", "Adjustment Calculation II", "Adjustment Calculation III"}};
                String[][] s2 = {{"WS", "WS2"}, {"SS1", "SS2", "SS3"}};
                String[][] p2 = {{"P1", "P2"}, {"P1", "P2", "P3"}};
                AddChildToParent two = new AddChildToParent();
                setChildToParent(two, r2, l2, s2, p2);
                break;
            case 3:
                String[] r3 = {"R3331", "R3332"};
                String[][] l3 = {{"L1", "L2"}, {"L11", "L12", "L13"}};
                String[][] s3 = {{"SS", "WS2"}, {"SS1", "SS2", "SS3"}};
                String[][] p3 = {{"P1", "P2"}, {"P1", "P2", "P3"}};
                AddChildToParent three = new AddChildToParent();
                setChildToParent(three, r3, l3, s3, p3);
                break;
            case 4:
                String[] r4 = {"R4441", "R4442"};
                String[][] l4 = {{"L1", "L2"}, {"L11", "L12", "L13"}};
                String[][] s4 = {{"ss", "WS2"}, {"SS1", "SS2", "SS3"}};
                String[][] p4 = {{"P1", "P2"}, {"P1", "P2", "P3"}};
                AddChildToParent four = new AddChildToParent();
                setChildToParent(four, r4, l4, s4, p4);
                break;
            case 5:
                String[] r5 = {"R5551", "R5552"};
                String[][] l5 = {{"L1", "L2"}, {"L11", "L12", "L13"}};
                String[][] s5 = {{"ss", "WS2"}, {"SS1", "SS2", "SS3"}};
                String[][] p5 = {{"P1", "P2"}, {"P1", "P2", "P3"}};
                AddChildToParent five = new AddChildToParent();
                setChildToParent(five, r5, l5, s5, p5);
                break;
            case 6:
                String[] r6 = {"R6661", "R6662"};
                String[][] l6 = {{"L1", "L2"}, {"L11", "L12", "L13"}};
                String[][] s6 = {{"ss", "WS2"}, {"SS1", "SS2", "SS3"}};
                String[][] p6 = {{"P1", "P2"}, {"P1", "P2", "P3"}};
                AddChildToParent six = new AddChildToParent();
                setChildToParent(six, r6, l6, s6, p6);
                break;
        }
    }
    public void findIndexZoneForAllDaysWithSubDep(String subDepartment, int indexZone){
            // indexZone finds a zone number of geo fence, see findIndex() in MainActivity
        if(subDepartment.equals("GIS")){
            switch (indexZone) {
                case 1:
                    String[] r1 = {"H6131", "H6134"};
                    String[][] l1 = {{"No Lectures"},
                            // Next
                            {"GIS Project", "Web Cartography"}};
                    String[][] s1 = {{""},
                            // Next
                            {"WS (3)", "WS (3)"}};
                    String[][] p1 = {{""},
                            // Next
                            {"Kada", "Kada"}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
                case 2:
                    String[] r2 = {"R21", "R22"};
                    String[][] l2 = {{"Zone2 GIS Lectures"}, {"Zone2 GIS Lectures"}};
                    String[][] s2 = {{""}, {""}};
                    String[][] p2 = {{"P21"}, {"P22"}};
                    AddChildToParent two = new AddChildToParent();
                    setChildToParent(two, r2, l2, s2, p2);
                    break;
                case 3:
                    String[] r3 = {"R31", "R32"};
                    String[][] l3 = {{"Zone3 GIS Lectures"}, {"Zone3 GIS Lectures"}};
                    String[][] s3 = {{""}, {""}};
                    String[][] p3 = {{""}, {""}};
                    AddChildToParent three = new AddChildToParent();
                    setChildToParent(three, r3, l3, s3, p3);
                    break;
                case 4:
                    String[] r4 = {"R41", "R42"};
                    String[][] l4 = {{"Zone4 GIS Lectures"}, {"Zone4 GIS Lectures"}};
                    String[][] s4 = {{""}, {""}};
                    String[][] p4 = {{""}, {""}};
                    AddChildToParent four = new AddChildToParent();
                    setChildToParent(four, r4, l4, s4, p4);
                    break;
                case 5:
                    String[] r5 = {"R51", "R52"};
                    String[][] l5 = {{"Zone5 GIS Lectures"}, {"Zone5 GIS Lectures"}};
                    String[][] s5 = {{""}, {""}};
                    String[][] p5 = {{""}, {""}};
                    AddChildToParent five = new AddChildToParent();
                    setChildToParent(five, r5, l5, s5, p5);
                    break;
                case 6:
                    String[] r6 = {"R61", "R62"};
                    String[][] l6 = {{"Zone6 GIS Lectures"}, {"Zone6 GIS Lectures"}};
                    String[][] s6 = {{""}, {""}};
                    String[][] p6 = {{""}, {""}};
                    AddChildToParent six = new AddChildToParent();
                    setChildToParent(six, r6, l6, s6, p6);
                    break;
            }
        } else if(subDepartment.equals("CV")){
            switch (indexZone) {
                case 1:
                    String[] r1 = {"H6131"};
                    String[][] l1 = {{"Zone1 CV Lectures"}};
                    String[][] s1 = {{""}};
                    String[][] p1 = {{"CV Profs"}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
            }
        } else if(subDepartment.equals("EGA")){
            switch (indexZone) {
                case 1:
                    String[] r1 = {"H6131", "H6134"};
                    String[][] l1 = {{"Zone1 EGA Lectures"}, {"Zone1 EGA Lectures"}};
                    String[][] s1 = {{""}, {""}};
                    String[][] p1 = {{""}, {""}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
            }
        } else if(subDepartment.equals("SGN")){
            switch (indexZone) {
                case 1:
                    String[] r1 = {"H6131", "H6134"};
                    String[][] l1 = {{"Zone1 SGN Lectures"}, {"Zone1 SGN Lectures"}};
                    String[][] s1 = {{""}, {""}};
                    String[][] p1 = {{"SGN Prof1"}, {"SGN Prof2"}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
                /*case 2:
                    String[] r2 = {"R", "R2"};
                    String[][] l2 = {{"No Lecture during weekends"}, {"No Lecture during weekends"}};
                    String[][] s2 = {{""}, {""}};
                    String[][] p2 = {{"Keep calm and do homework"}, {"Keep calm and do homework"}};
                    AddChildToParent two = new AddChildToParent();
                    setChildToParent(two, r2, l2, s2, p2);
                    break;
                case 3:
                    String[] r3 = {"", ""};
                    String[][] l3 = {{"No Lecture during weekends"}, {"No Lecture during weekends"}};
                    String[][] s3 = {{""}, {""}};
                    String[][] p3 = {{"Keep calm and do homework"}, {"Keep calm and do homework"}};
                    AddChildToParent three = new AddChildToParent();
                    setChildToParent(three, r3, l3, s3, p3);
                    break;
                case 4:
                    String[] r4 = {"", ""};
                    String[][] l4 = {{"No Lecture during weekends"}, {"No Lecture during weekends"}};
                    String[][] s4 = {{""}, {""}};
                    String[][] p4 = {{"Keep calm and do homework"}, {"Keep calm and do homework"}};
                    AddChildToParent four = new AddChildToParent();
                    setChildToParent(four, r4, l4, s4, p4);
                    break;
                case 5:
                    String[] r5 = {"", ""};
                    String[][] l5 = {{"No Lecture during weekends"}, {"No Lecture during weekends"}};
                    String[][] s5 = {{""}, {""}};
                    String[][] p5 = {{"Keep calm and do homework"}, {"Keep calm and do homework"}};
                    AddChildToParent five = new AddChildToParent();
                    setChildToParent(five, r5, l5, s5, p5);
                    break;
                case 6:
                    String[] r6 = {"", ""};
                    String[][] l6 = {{"No Lecture during weekends"}, {"No Lecture during weekends"}};
                    String[][] s6 = {{""}, {""}};
                    String[][] p6 = {{"Keep calm and do homework"}, {"Keep calm and do homework"}};
                    AddChildToParent six = new AddChildToParent();
                    setChildToParent(six, r6, l6, s6, p6);
                    break;*/
            }
        }
    }
    // Monday
    private void findIndexZoneForMonWithoutSubDep(int indexZone){
        switch (indexZone) {
            case 1:
                String[] r1 = {"H6131"};
                String[][] l1 = {{"GIS Project", "Introduction to Satellite Geodesy"}};
                String[][] s1 = {{"WS (3)", "WS (1)"}};
                String[][] p1 = {{"Kada", "Oberst/Flechtner/Heinkelmann"}};
                AddChildToParent one = new AddChildToParent();
                setChildToParent(one, r1, l1, s1, p1);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }
    private void findIndexZoneForMonWithSubDep(String subDepartment, int indexZone){
        if(subDepartment.equals("GIS")) {
            switch (indexZone) {
                case 1:
                    String[] r1 = {"H6131"};
                    String[][] l1 = {{"GIS Project"},
                            // Next
                            {""}};
                    String[][] s1 = {{"WS (3)"},
                            // Next
                            {""}};
                    String[][] p1 = {{"Kada"},
                            // Next
                            {""}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        } else if(subDepartment.equals("CV")){
            switch (indexZone) {
                case 1:
                    String[] r1 = {"Mon"};
                    String[][] l1 = {{"CVLectures"},
                            // Next
                            {""}};
                    String[][] s1 = {{""},
                            // Next
                            {""}};
                    String[][] p1 = {{""},
                            // Next
                            {""}};
            }
        }
        else if(subDepartment.equals("EGA")){
            switch (indexZone) {
                case 1:
                    String[] r1 = {"Mon"};
                    String[][] l1 = {{"EGALectures"},
                            // Next
                            {""}};
                    String[][] s1 = {{""},
                            // Next
                            {""}};
                    String[][] p1 = {{""},
                            // Next
                            {""}};
            }
        }
        else if(subDepartment.equals("SGN")){
            switch (indexZone){
                case 1:
                    String[] r1 = {"H6131"};
                    String[][] l1 = {{"Introduction to Satellite Geodesy"},
                            // Next
                            {""}};
                    String[][] s1 = {{"WS (1)"},
                            // Next
                            {""}};
                    String[][] p1 = {{"Oberst/Flechtner/Heinkelmann"},
                            // Next
                            {""}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
            }
        }
    }
    // Tuesday
    private void findIndexZoneForTueWithoutSubDep(int indexZone){
        switch (indexZone) {
            case 1:
                String[] r1 = {"Tuesday"};
                String[][] l1 = {{"AllLectures"},
                        // Next
                        {""}};
                String[][] s1 = {{""},
                        // Next
                        {""}};
                String[][] p1 = {{""},
                        // Next
                        {""}};
                AddChildToParent one = new AddChildToParent();
                setChildToParent(one, r1, l1, s1, p1);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }
    private void findIndexZoneForTueWithSubDep(String subDepartment, int indexZone){
        if(subDepartment.equals("GIS")) {
            switch (indexZone) {
                case 1:
                    String[] r1 = {"Tue"};
                    String[][] l1 = {{"GISLectures"},
                            // Next
                            {""}};
                    String[][] s1 = {{""},
                            // Next
                            {""}};
                    String[][] p1 = {{""},
                            // Next
                            {""}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
            }
        } else if(subDepartment.equals("CV")){
            switch (indexZone) {
                case 1:
                    String[] r1 = {"Tue"};
                    String[][] l1 = {{"CVLectures"},
                            // Next
                            {""}};
                    String[][] s1 = {{""},
                            // Next
                            {""}};
                    String[][] p1 = {{""},
                            // Next
                            {""}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
            }
        }
        else if(subDepartment.equals("EGA")){
            switch (indexZone) {
                case 1:
                    String[] r1 = {"Tue"};
                    String[][] l1 = {{"EGALectures"},
                            // Next
                            {""}};
                    String[][] s1 = {{""},
                            // Next
                            {""}};
                    String[][] p1 = {{""},
                            // Next
                            {""}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
            }
        }
        else if(subDepartment.equals("SGN")){
            switch (indexZone){
                case 1:
                    String[] r1 = {"Tue"};
                    String[][] l1 = {{"SGNLectures"},
                            // Next
                            {""}};
                    String[][] s1 = {{""},
                            // Next
                            {""}};
                    String[][] p1 = {{""},
                            // Next
                            {""}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
            }

        }
    }
    // Wednesday
    private void findIndexZoneForWedWithoutSubDep(int indexZone){
        switch (indexZone) {
            case 1:
                String[] r1 = {"Wednesday"};
                String[][] l1 = {{"AllLectures"},
                        // Next
                        {""}};
                String[][] s1 = {{""},
                        // Next
                        {""}};
                String[][] p1 = {{""},
                        // Next
                        {""}};
                AddChildToParent one = new AddChildToParent();
                setChildToParent(one, r1, l1, s1, p1);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }
    private void findIndexZoneForWedWithSubDep(String subDepartment, int indexZone){
        if(subDepartment.equals("GIS")) {
            switch (indexZone) {
                case 1:
                    String[] r1 = {"Wednesday"};
                    String[][] l1 = {{"GISLectures"},
                            // Next
                            {""}};
                    String[][] s1 = {{""},
                            // Next
                            {""}};
                    String[][] p1 = {{""},
                            // Next
                            {""}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
            }
        } else if(subDepartment.equals("CV")){
            switch (indexZone) {
                case 1:
                    String[] r1 = {"Wednesday"};
                    String[][] l1 = {{"CVLectures"},
                            // Next
                            {""}};
                    String[][] s1 = {{""},
                            // Next
                            {""}};
                    String[][] p1 = {{""},
                            // Next
                            {""}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
            }
        }
        else if(subDepartment.equals("EGA")){
            switch (indexZone) {
                case 1:
                    String[] r1 = {"Wednesday"};
                    String[][] l1 = {{"EGALectures"},
                            // Next
                            {""}};
                    String[][] s1 = {{""},
                            // Next
                            {""}};
                    String[][] p1 = {{""},
                            // Next
                            {""}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
            }
        }
        else if(subDepartment.equals("SGN")){
            switch (indexZone){
                case 1:
                    String[] r1 = {"Wednesday"};
                    String[][] l1 = {{"SGNLectures"},
                            // Next
                            {""}};
                    String[][] s1 = {{""},
                            // Next
                            {""}};
                    String[][] p1 = {{""},
                            // Next
                            {""}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
            }

        }
    }
    // Thursday
    private void findIndexZoneForThuWithoutSubDep(int indexZone){
        switch (indexZone) {
            case 1:
                String[] r1 = {"Thursday"};
                String[][] l1 = {{"AllLectures"},
                        // Next
                        {""}};
                String[][] s1 = {{""},
                        // Next
                        {""}};
                String[][] p1 = {{""},
                        // Next
                        {""}};
                AddChildToParent one = new AddChildToParent();
                setChildToParent(one, r1, l1, s1, p1);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }
    private void findIndexZoneForThuWithSubDep(String subDepartment, int indexZone){
        if(subDepartment.equals("GIS")) {
            switch (indexZone) {
                case 1:
                    String[] r1 = {"Thursday"};
                    String[][] l1 = {{"GISLectures"},
                            // Next
                            {""}};
                    String[][] s1 = {{""},
                            // Next
                            {""}};
                    String[][] p1 = {{""},
                            // Next
                            {""}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
            }
        } else if(subDepartment.equals("CV")){
            switch (indexZone) {
                case 1:
                    String[] r1 = {"Thursday"};
                    String[][] l1 = {{"CVLectures"},
                            // Next
                            {""}};
                    String[][] s1 = {{""},
                            // Next
                            {""}};
                    String[][] p1 = {{""},
                            // Next
                            {""}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
            }
        }
        else if(subDepartment.equals("EGA")){
            switch (indexZone) {
                case 1:
                    String[] r1 = {"Thursday"};
                    String[][] l1 = {{"EGALectures"},
                            // Next
                            {""}};
                    String[][] s1 = {{""},
                            // Next
                            {""}};
                    String[][] p1 = {{""},
                            // Next
                            {""}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
            }
        }
        else if(subDepartment.equals("SGN")){
            switch (indexZone){
                case 1:
                    String[] r1 = {"Thursday"};
                    String[][] l1 = {{"SGNLectures"},
                            // Next
                            {""}};
                    String[][] s1 = {{""},
                            // Next
                            {""}};
                    String[][] p1 = {{""},
                            // Next
                            {""}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
            }

        }
    }
    // Friday
    private void findIndexZoneForFriWithoutSubDep(int indexZone){
        switch (indexZone) {
            case 1:
                String[] r1 = {"Friday"};
                String[][] l1 = {{"AllLectures"},
                        // Next
                        {""}};
                String[][] s1 = {{""},
                        // Next
                        {""}};
                String[][] p1 = {{""},
                        // Next
                        {""}};
                AddChildToParent one = new AddChildToParent();
                setChildToParent(one, r1, l1, s1, p1);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }
    private void findIndexZoneForFriWithSubDep(String subDepartment, int indexZone){
        if(subDepartment.equals("GIS")) {
            switch (indexZone) {
                case 1:
                    String[] r1 = {"Friday"};
                    String[][] l1 = {{"GISLectures"},
                            // Next
                            {""}};
                    String[][] s1 = {{""},
                            // Next
                            {""}};
                    String[][] p1 = {{""},
                            // Next
                            {""}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
            }
        } else if(subDepartment.equals("CV")){
            switch (indexZone) {
                case 1:
                    String[] r1 = {"Friday"};
                    String[][] l1 = {{"CVLectures"},
                            // Next
                            {""}};
                    String[][] s1 = {{""},
                            // Next
                            {""}};
                    String[][] p1 = {{""},
                            // Next
                            {""}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
            }
        }
        else if(subDepartment.equals("EGA")){
            switch (indexZone) {
                case 1:
                    String[] r1 = {"Friday"};
                    String[][] l1 = {{"EGALectures"},
                            // Next
                            {""}};
                    String[][] s1 = {{""},
                            // Next
                            {""}};
                    String[][] p1 = {{""},
                            // Next
                            {""}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
            }
        }
        else if(subDepartment.equals("SGN")){
            switch (indexZone){
                case 1:
                    String[] r1 = {"Friday"};
                    String[][] l1 = {{"SGNLectures"},
                            // Next
                            {""}};
                    String[][] s1 = {{""},
                            // Next
                            {""}};
                    String[][] p1 = {{""},
                            // Next
                            {""}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
            }

        }
    }



    public ArrayList<String> getParent(){
        return argParent;
    }

    public ArrayList<Object> geChildOne(){
        return argChildOne;
    }

    public ArrayList<Object> geChildTwo(){
        return argChildTwo;
    }

    public ArrayList<Object> geChildThree(){
        return argChildThree;
    }
}
