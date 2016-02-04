package tu_berlin.alexei.cis_tu_berlin;

import java.util.ArrayList;

/**
 * Created by Alexei on 04.02.2016.
 */
public class GetInfoPersonChain {
    private ArrayList<String> argParent = new ArrayList<String>();
    private ArrayList<Object> argChildOne = new ArrayList<Object>();
    private ArrayList<Object> argChildTwo = new ArrayList<Object>();
    private ArrayList<Object> argChildThree = new ArrayList<Object>();

    public GetInfoPersonChain(){
    }

    public void setChildToParent(AddChildToParent arg, String[] argMain, String[][] personTitle, String[][] personEmail, String[][] personPhone){
        argParent = arg.getRoomNumber(argMain);
        argChildOne = arg.getLecName(personTitle);
        argChildTwo = arg.getLecSemester(personEmail);
        argChildThree = arg.getLecProfessor(personPhone);
    }

    public void findFloorNumberForPerson(int floorNumber, int numberOfPerson, int indexZone){
        // floorNumber finds the floor number by mac address, see getFloorByMac() in MainActivity
        switch (floorNumber){
            case 5:
                findIndexZoneAndPerson(numberOfPerson, indexZone);
                break;
            case 6:
                findIndexZoneAndPerson(numberOfPerson, indexZone);
                break;
        }
    }


    public void findIndexZoneAndPerson(int numberOfPerson, int indexZone){
        if(numberOfPerson == 100) { // All Person
            // indexZone finds a zone number of geo fence, see findIndex() in MainActivity
            switch (indexZone) {
                case 1:
                    String[] r1 = {"H6130", "H6133"};
                    String[][] n1 = {{"Javier Herreruela"},
                            // next
                            {"Gerth König"}};
                    String[][] e1 = {{"javier.herreruela@tu-berlin.de"},
                            // next
                            {"gerhard.koenig@tu-berlin.de"}};
                    String[][] t1 = {{"+4930 314-27501"},
                            // next
                            {"+4930 314-23338"}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, n1, e1, t1);
                    break;
                case 2:
                    String[] r2 = {"R", "R2"};
                    String[][] n2 = {{""}, {""}};
                    String[][] e2 = {{""}, {""}};
                    String[][] t2 = {{""}, {""}};
                    AddChildToParent two = new AddChildToParent();
                    setChildToParent(two, r2, n2, e2, t2);
                    break;
                case 3:
                    String[] r3 = {"H5129", "H5128"};
                    String[][] n3 = {{"Thomas Adolphi"},
                            // next
                            {""}};
                    String[][] e3 = {{"Andreas Wichmann"},
                            // next
                            {"andreas.wichmann@tu-berlin.de"}};
                    String[][] t3 = {{"+4930 314-24332"},
                            // next
                            {"+4930 314-29498"}};
                    AddChildToParent three = new AddChildToParent();
                    setChildToParent(three, r3, n3, e3, t3);
                    break;
                case 4:
                    String[] r4 = {"", ""};
                    String[][] n4 = {{"L1", "L2"}, {"L11", "L12", "L13"}};
                    String[][] e4 = {{"ss", "WS2"}, {"SS1", "SS2", "SS3"}};
                    String[][] t4 = {{"P1", "P2"}, {"P1", "P2", "P3"}};
                    AddChildToParent four = new AddChildToParent();
                    setChildToParent(four, r4, n4, e4, t4);
                    break;
                case 5:
                    String[] r5 = {"", ""};
                    String[][] n5 = {{"L1", "L2"}, {"L11", "L12", "L13"}};
                    String[][] e5 = {{"ss", "WS2"}, {"SS1", "SS2", "SS3"}};
                    String[][] t5 = {{"P1", "P2"}, {"P1", "P2", "P3"}};
                    AddChildToParent five = new AddChildToParent();
                    setChildToParent(five, r5, n5, e5, t5);
                    break;
                case 6:
                    String[] r6 = {"", ""};
                    String[][] n6 = {{"L1", "L2"}, {"L11", "L12", "L13"}};
                    String[][] e6 = {{"ss", "WS2"}, {"SS1", "SS2", "SS3"}};
                    String[][] t6 = {{"P1", "P2"}, {"P1", "P2", "P3"}};
                    AddChildToParent six = new AddChildToParent();
                    setChildToParent(six, r6, n6, e6, t6);
                    break;
            }
        } else if(numberOfPerson == 10){ // Only Academicians 
            switch (indexZone) {
                case 1:
                    String[] r1 = {"H6130", "H6133"};
                    String[][] n1 = {{"Javier Herreruela"},
                            // next
                            {"Gerth König"}};
                    String[][] e1 = {{"javier.herreruela@tu-berlin.de"},
                            // next
                            {"gerhard.koenig@tu-berlin.de"}};
                    String[][] t1 = {{"+4930 314-27501"},
                            // next
                            {"+4930 314-23338"}};
                    break;
                case 2:
                    String[] r2 = {"R", "R2"};
                    String[][] n2 = {{"No Lecture during weekends"}, {"No Lecture during weekends"}};
                    String[][] e2 = {{""}, {""}};
                    String[][] t2 = {{"Keep calm and do homework"}, {"Keep calm and do homework"}};
                    AddChildToParent two = new AddChildToParent();
                    setChildToParent(two, r2, n2, e2, t2);
                    break;
                case 3:
                    String[] r3 = {"", ""};
                    String[][] n3 = {{"No Lecture during weekends"}, {"No Lecture during weekends"}};
                    String[][] e3 = {{""}, {""}};
                    String[][] t3 = {{"Keep calm and do homework"}, {"Keep calm and do homework"}};
                    AddChildToParent three = new AddChildToParent();
                    setChildToParent(three, r3, n3, e3, t3);
                    break;
                case 4:
                    String[] r4 = {"", ""};
                    String[][] n4 = {{"No Lecture during weekends"}, {"No Lecture during weekends"}};
                    String[][] e4 = {{""}, {""}};
                    String[][] t4 = {{"Keep calm and do homework"}, {"Keep calm and do homework"}};
                    AddChildToParent four = new AddChildToParent();
                    setChildToParent(four, r4, n4, e4, t4);
                    break;
                case 5:
                    String[] r5 = {"", ""};
                    String[][] n5 = {{"No Lecture during weekends"}, {"No Lecture during weekends"}};
                    String[][] e5 = {{""}, {""}};
                    String[][] t5 = {{"Keep calm and do homework"}, {"Keep calm and do homework"}};
                    AddChildToParent five = new AddChildToParent();
                    setChildToParent(five, r5, n5, e5, t5);
                    break;
                case 6:
                    String[] r6 = {"", ""};
                    String[][] n6 = {{"No Lecture during weekends"}, {"No Lecture during weekends"}};
                    String[][] e6 = {{""}, {""}};
                    String[][] t6 = {{"Keep calm and do homework"}, {"Keep calm and do homework"}};
                    AddChildToParent six = new AddChildToParent();
                    setChildToParent(six, r6, n6, e6, t6);
                    break;
            }
        } else if(numberOfPerson == 0){ // Phd student
            switch (indexZone) {
                case 1:
                    String[] r1 = {"H6131", "H6134"};
                    String[][] n1 = {{"No Lecture during weekends"}, {"No Lecture during weekends"}};
                    String[][] e1 = {{" "}, {" "}};
                    String[][] t1 = {{"Keep calm and do homework"}, {"Keep calm and do homework"}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, n1, e1, t1);
                    break;
                case 2:
                    String[] r2 = {"R", "R2"};
                    String[][] n2 = {{"No Lecture during weekends"}, {"No Lecture during weekends"}};
                    String[][] e2 = {{""}, {""}};
                    String[][] t2 = {{"Keep calm and do homework"}, {"Keep calm and do homework"}};
                    AddChildToParent two = new AddChildToParent();
                    setChildToParent(two, r2, n2, e2, t2);
                    break;
                case 3:
                    String[] r3 = {"", ""};
                    String[][] n3 = {{"No Lecture during weekends"}, {"No Lecture during weekends"}};
                    String[][] e3 = {{""}, {""}};
                    String[][] t3 = {{"Keep calm and do homework"}, {"Keep calm and do homework"}};
                    AddChildToParent three = new AddChildToParent();
                    setChildToParent(three, r3, n3, e3, t3);
                    break;
                case 4:
                    String[] r4 = {"", ""};
                    String[][] n4 = {{"No Lecture during weekends"}, {"No Lecture during weekends"}};
                    String[][] e4 = {{""}, {""}};
                    String[][] t4 = {{"Keep calm and do homework"}, {"Keep calm and do homework"}};
                    AddChildToParent four = new AddChildToParent();
                    setChildToParent(four, r4, n4, e4, t4);
                    break;
                case 5:
                    String[] r5 = {"", ""};
                    String[][] n5 = {{"No Lecture during weekends"}, {"No Lecture during weekends"}};
                    String[][] e5 = {{""}, {""}};
                    String[][] t5 = {{"Keep calm and do homework"}, {"Keep calm and do homework"}};
                    AddChildToParent five = new AddChildToParent();
                    setChildToParent(five, r5, n5, e5, t5);
                    break;
                case 6:
                    String[] r6 = {"", ""};
                    String[][] n6 = {{"No Lecture during weekends"}, {"No Lecture during weekends"}};
                    String[][] e6 = {{""}, {""}};
                    String[][] t6 = {{"Keep calm and do homework"}, {"Keep calm and do homework"}};
                    AddChildToParent six = new AddChildToParent();
                    setChildToParent(six, r6, n6, e6, t6);
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
