package tu_berlin.alexei.cis_tu_berlin;

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
    
    public void findFloorNumberForLectureDay(int floorNumber, int dayType, int indexZone){
        // floorNumber finds the floor number by mac address, see getFloorByMac() in MainActivity
        switch (floorNumber){
            case 5:
                findIndexZoneAndLectureDay(dayType, indexZone);
                break;
            case 6:
                findIndexZoneAndLectureDay(dayType, indexZone);
                break;
        }
    }


    public void findIndexZoneAndLectureDay(int dayType, int indexZone){
        if(dayType == 0) {
            // indexZone finds a zone number of geo fence, see findIndex() in MainActivity
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
                    String[] r2 = {"R", "R2"};
                    String[][] l2 = {{"Adjustment Calculation I", "Basics in Engineering Surveys"}, {"Adjustment Calculation", "Adjustment Calculation II", "Adjustment Calculation III"}};
                    String[][] s2 = {{"WS", "WS2"}, {"SS1", "SS2", "SS3"}};
                    String[][] p2 = {{"P1", "P2"}, {"P1", "P2", "P3"}};
                    AddChildToParent two = new AddChildToParent();
                    setChildToParent(two, r2, l2, s2, p2);
                    break;
                case 3:
                    String[] r3 = {"", ""};
                    String[][] l3 = {{"L1", "L2"}, {"L11", "L12", "L13"}};
                    String[][] s3 = {{"SS", "WS2"}, {"SS1", "SS2", "SS3"}};
                    String[][] p3 = {{"P1", "P2"}, {"P1", "P2", "P3"}};
                    AddChildToParent three = new AddChildToParent();
                    setChildToParent(three, r3, l3, s3, p3);
                    break;
                case 4:
                    String[] r4 = {"", ""};
                    String[][] l4 = {{"L1", "L2"}, {"L11", "L12", "L13"}};
                    String[][] s4 = {{"ss", "WS2"}, {"SS1", "SS2", "SS3"}};
                    String[][] p4 = {{"P1", "P2"}, {"P1", "P2", "P3"}};
                    AddChildToParent four = new AddChildToParent();
                    setChildToParent(four, r4, l4, s4, p4);
                    break;
                case 5:
                    String[] r5 = {"", ""};
                    String[][] l5 = {{"L1", "L2"}, {"L11", "L12", "L13"}};
                    String[][] s5 = {{"ss", "WS2"}, {"SS1", "SS2", "SS3"}};
                    String[][] p5 = {{"P1", "P2"}, {"P1", "P2", "P3"}};
                    AddChildToParent five = new AddChildToParent();
                    setChildToParent(five, r5, l5, s5, p5);
                    break;
                case 6:
                    String[] r6 = {"", ""};
                    String[][] l6 = {{"L1", "L2"}, {"L11", "L12", "L13"}};
                    String[][] s6 = {{"ss", "WS2"}, {"SS1", "SS2", "SS3"}};
                    String[][] p6 = {{"P1", "P2"}, {"P1", "P2", "P3"}};
                    AddChildToParent six = new AddChildToParent();
                    setChildToParent(six, r6, l6, s6, p6);
                    break;
            }
        } else if(dayType == 1){ // Sunday
            switch (indexZone) {
                case 1:
                    String[] r1 = {"H6131", "H6134"};
                    String[][] l1 = {{"No Lecture during weekends"}, {"No Lecture during weekends"}};
                    String[][] s1 = {{" "}, {" "}};
                    String[][] p1 = {{"Keep calm and do homework"}, {"Keep calm and do homework"}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
                case 2:
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
                    break;
            }
        } else if(dayType == 4){ // Wednesday
            switch (indexZone) {
                case 1:
                    String[] r1 = {"H6131", "H6134"};
                    String[][] l1 = {{"Wednesday"}, {"Wednesday"}};
                    String[][] s1 = {{" "}, {" "}};
                    String[][] p1 = {{"Keep calm and do thesis"}, {"Keep calm and do thesis"}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
            }
        } else if(dayType == 5){ // Thursday
            switch (indexZone) {
                case 1:
                    String[] r1 = {"H6131", "H6134"};
                    String[][] l1 = {{"Thursday"}, {"Thursday"}};
                    String[][] s1 = {{" "}, {" "}};
                    String[][] p1 = {{"Keep calm and do thesis"}, {"Keep calm and do thesis"}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
            }
        } else if(dayType == 6){ // Friday
            switch (indexZone) {
                case 1:
                    String[] r1 = {"H6131", "H6134"};
                    String[][] l1 = {{"Friday"}, {"Friday"}};
                    String[][] s1 = {{""}, {""}};
                    String[][] p1 = {{"Keep calm and do thesis"}, {"Keep calm and do thesis"}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
            }
        } else if(dayType == 7){ // Saturday
            switch (indexZone) {
                case 1:
                    String[] r1 = {"H6131", "H6134"};
                    String[][] l1 = {{"No Lecture during weekends"}, {"No Lecture during weekends"}};
                    String[][] s1 = {{""}, {""}};
                    String[][] p1 = {{"Keep calm and do homework"}, {"Keep calm and do homework"}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, l1, s1, p1);
                    break;
                case 2:
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
