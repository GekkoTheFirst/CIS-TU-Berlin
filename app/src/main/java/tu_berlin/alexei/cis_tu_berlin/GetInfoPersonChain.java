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
    private ArrayList<Object> argChildFour = new ArrayList<Object>();

    public GetInfoPersonChain(){
    }

    public void setChildToParent(AddChildToParent arg, String[] argMain, String[][] personTitle, String[][] personEmail, String[][] personPhone, String[][] personImage){
        argParent = arg.getRoomNumber(argMain);
        argChildOne = arg.getLecName(personTitle);
        argChildTwo = arg.getLecSemester(personEmail);
        argChildThree = arg.getLecProfessor(personPhone);
        argChildFour = arg.getImgProfessor(personImage);
    }

    public void findFloorNumberForPerson(int floorNumber, int numberOfPerson, int indexZone){
        // floorNumber finds the floor number by mac address, see getFloorByMac() in MainActivity
        switch (floorNumber){
            case 5:
                findIndexZoneAndPerson5(numberOfPerson, indexZone);
                break;
            case 6:
                findIndexZoneAndPerson6(numberOfPerson, indexZone);
                break;
        }
    }

    public void findIndexZoneAndPerson5(int numberOfPerson, int indexZone) {
        if(numberOfPerson == 100) { // All Person
            switch (indexZone){
                case 3:
                    String[] r3 = {"H5129", "H5128"};
                    String[][] n3 = {{"Thomas Adolphi"},
                            {"Andreas Wichmann"}};
                    String[][] e3 = {{"thomas.becker@tu-berlin.de"},
                            {"andreas.wichmann@tu-berlin.de"}};
                    String[][] t3 = {{"+4930 314-24332"},
                            {"+4930 314-29498"}};
                    String[][] i3 = {{"http://www.gis.tu-berlin.de/fileadmin/fg227/Bilder/Mitarbeiter/gross/becker.jpg"},
                            {""}};
                    AddChildToParent three = new AddChildToParent();
                    setChildToParent(three, r3, n3, e3, t3, i3);
                    break;
                case 4:
                    String[] r4 = {"5121"};
                    String[][] n4 = {{"Prof. Jürgen Oberst"}};
                    String[][] e4 = {{"juergen.oberst@tu-berlin.de"}};
                    String[][] t4 = {{"+4930 314-79701"}};
                    String[][] i4 = {{""}};
                    AddChildToParent four = new AddChildToParent();
                    setChildToParent(four, r4, n4, e4, t4, i4);
                    break;
            }
        } else if (numberOfPerson == 10){
            switch (indexZone) {
                case 3:
                    String[] r3 = {"H5129"};
                    String[][] n3 = {{"Thomas Adolphi"}};
                    String[][] e3 = {{"thomas.becker@tu-berlin.de"}};
                    String[][] t3 = {{"+4930 314-24332"}};
                    String[][] i3 = {{"http://www.gis.tu-berlin.de/fileadmin/fg227/Bilder/Mitarbeiter/gross/becker.jpg"}};
                    AddChildToParent three = new AddChildToParent();
                    setChildToParent(three, r3, n3, e3, t3, i3);
                    break;
            }
        } else if(numberOfPerson == 0){
            switch (indexZone) {
                case 3:
                    String[] r3 = {};
                    String[][] n3 = {{""}};
                    String[][] e3 = {{""}};
                    String[][] t3 = {{""}};
                    String[][] i3 = {{""}};
                    AddChildToParent three = new AddChildToParent();
                    setChildToParent(three, r3, n3, e3, t3, i3);
                    break;
            }
        }
    }

    public void findIndexZoneAndPerson6(int numberOfPerson, int indexZone){
        if(numberOfPerson == 100) { // All Person
            // indexZone finds a zone number of geo fence, see findIndex() in MainActivity
            switch (indexZone) {
                case 1:
                    String[] r1 = {"H6133"};
                    String[][] n1 = {{"Gerth König"}};
                    String[][] e1 = {{"gerhard.koenig@tu-berlin.de"}};
                    String[][] t1 = {{"+4930 314-23338"}};
                    String[][] i1 = {{"http://www.gis.tu-berlin.de/fileadmin/fg227/Bilder/Mitarbeiter/gross/gert.jpg"}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, n1, e1, t1, i1);
                    break;
                case 2:
                    String[] r2 = {"H6128","H6130","H6158","H6159","H6160","H6161","H6163","H6164","H6165"};
                    String[][] n2 = {{"Hartmut Lehmann"},
                            {"Javier Herreruela"},
                            {"Daniel Wujanz"},
                            {"Jinpeng Feng ", "Georgios Malissiovas", "Cheng-Chieh Wu", "Anastasia Pasioti"},
                            {"Sven Weisbrich"},
                            {"Anastasios Margonis", "Ender Tasdelen"},
                            {"Philipp Gläser", "Isabel Haase"},
                            {"Friedrich Damme", "Konrad Willner"},
                            {"Omar Al-Juboori", "Steffi Burmeister", "Fabian Lüdicke"}};
                    String[][] e2 = {{"h.lehmann@tu-berlin.de"},
                            {"javier.herreruela@tu-berlin.de"},
                            {"daniel.wujanz@tu-berlin.de"},
                            {"jinpeng.feng@mailbox.tu-berlin.de", "georgios.malissiovas@tu-berlin.de", "cheng-chieh.wu@bam.de", "anastasia.pasioti@mailbox.tu-berlin.de"},
                            {"s.weisbrich@tu-berlin.de"},
                            {"anastasios.margonis@tu-berlin.de", "ender.tasdelen@tu-berlin.de"},
                            {"philipp.glaser@tu-berlin.de", "isabel.haase@tu-berlin.de"},
                            {"friedrich.damme@tu-berlin.de","konrad.willner@tu-berlin.de"},
                            {"omar-juboori@tu-berlin.de", "steffi.burmeister@tu-berlin.de", "fabian.luedicke@tu-berlin.de"}};
                    String[][] t2 = {{"+4930 314-27500"},
                            {"+4930 314-27501"},
                            {"+4930 314-24148"},
                            {"+4930 314-24147", "+4930 314-24147", "+4930 314-24147", "+4930 314-24147"},
                            {"+4930 314-24146"},
                            {"+4930 314-29897", "+4930 314-29897"},
                            {"+4930 314-28828", "+4930 314-28828"},
                            {"+4930 314-28840", "+4930 314-28840"},
                            {"+4930 314-23331", "+4930 314-23331", "+4930 314-23331"}};
                    String[][] i2 = {{"https://www.gis.tu-berlin.de/fileadmin/fg227/Bilder/Mitarbeiter/klein/1632_c.jpg"},
                            {"https://www.gis.tu-berlin.de/fileadmin/fg227/Bilder/Mitarbeiter/klein/javier.jpg"},
                            {"http://www.geodesy.tu-berlin.de/fileadmin/fg261/Bilder/wujanz.jpg"},
                            {"","","",""},
                            {"http://www.geodesy.tu-berlin.de/fileadmin/fg261/Bilder/weisbrich.jpg"},
                            {"",""},{"",""},{"",""},{"","",""}};
                    AddChildToParent two = new AddChildToParent();
                    setChildToParent(two, r2, n2, e2, t2, i2);
                    break;
                case 3:
                    String[] r3 = {"H6116"};
                    String[][] n3 = {{"Marija Čokrlić", "Kinga Węzka"}};
                    String[][] e3 = {{"maria@tu-berlin.de", "kinga@tu-berlin.de"}};
                    String[][] t3 = {{"maria", "kinga"}};
                    String[][] i3 = {{"",""}};
                    AddChildToParent three = new AddChildToParent();
                    setChildToParent(three, r3, n3, e3, t3, i3);
                    break;
                case 4:
                    String[] r4 = {"H6110", ""};
                    String[][] n4 = {{"Prof. Frank Neitzel"}, {""}};
                    String[][] e4 = {{"neitzel@tu-belin.de"}, {""}};
                    String[][] t4 = {{"prof"}, {""}};
                    String[][] i4 = {{""},{""}};
                    AddChildToParent four = new AddChildToParent();
                    setChildToParent(four, r4, n4, e4, t4, i4);
                    break;
                case 5:
                    String[] r5 = {""};
                    String[][] n5 = {{""}};
                    String[][] e5 = {{""}};
                    String[][] t5 = {{""}};
                    String[][] i5 = {{""}};
                    AddChildToParent five = new AddChildToParent();
                    setChildToParent(five, r5, n5, e5, t5, i5);
                    break;
                case 6:
                    String[] r6 = {""};
                    String[][] n6 = {{""}};
                    String[][] e6 = {{""}};
                    String[][] t6 = {{""}};
                    String[][] i6 = {{""}};
                    AddChildToParent six = new AddChildToParent();
                    setChildToParent(six, r6, n6, e6, t6, i6);
                    break;
            }
        } else if(numberOfPerson == 10){ // Only Academicians 
            switch (indexZone) {
                case 1:
                    String[] r1 = {"H6133"};
                    String[][] n1 = {{"Gerth König"}};
                    String[][] e1 = {{"gerhard.koenig@tu-berlin.de"}};
                    String[][] t1 = {{"+4930 314-23338"}};
                    String[][] i1 = {{"http://www.gis.tu-berlin.de/fileadmin/fg227/Bilder/Mitarbeiter/gross/gert.jpg"}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, n1, e1, t1, i1);
                    break;
                case 2:
                    String[] r2 = {"H6128","H6130","H6158","H6160","H6163","H6164","H6165"};
                    String[][] n2 = {{"Hartmut Lehmann"},{"Javier Herreruela"},{"Daniel Wujanz"},{"Sven Weisbrich"},{"Philipp Gläser", "Isabel Haase"},{"Friedrich Damme", "Konrad Willner"},
                            {"Omar Al-Juboori", "Steffi Burmeister", "Fabian Lüdicke"}};
                    String[][] e2 = {{"h.lehmann@tu-berlin.de"},
                            {"javier.herreruela@tu-berlin.de"},
                            {"daniel.wujanz@tu-berlin.de"},
                            {"s.weisbrich@tu-berlin.de"},
                            {"philipp.glasser@tu-berlin.de", "isabel.haase@tu-berlin.de"},
                            {"friedrich.damme@tu-berlin.de", "konrad.willner@tu-berlin.de"},
                            {"omar-juboori@tu-berlin.de", "steffi.burmeister@tu-berlin.de", "fabian.luedicke@tu-berlin.de"}};
                    String[][] t2 = {{"+4930 314-27500"},
                            {"+4930 314-27501"},
                            {"+4930 314-24148"},
                            {"+4930 314-23204"},
                            {"+4930 314-28828", "+4930 314-28828"},
                            {"+4930 314-28840", "+4930 314-28840"},
                            {"+4930 314-23331", "+4930 314-23331", "+4930 314-23331"}};
                    String[][] i2 = {{"https://www.gis.tu-berlin.de/fileadmin/fg227/Bilder/Mitarbeiter/klein/1632_c.jpg"},
                            {"https://www.gis.tu-berlin.de/fileadmin/fg227/Bilder/Mitarbeiter/klein/javier.jpg"},
                            {"http://www.geodesy.tu-berlin.de/fileadmin/fg261/Bilder/wujanz.jpg"},
                            {"http://www.geodesy.tu-berlin.de/fileadmin/fg261/Bilder/weisbrich.jpg"},
                            {"",""},{"",""},{"","",""}};
                    AddChildToParent two = new AddChildToParent();
                    setChildToParent(two, r2, n2, e2, t2, i2);
                    break;
                case 3:
                    String[] r3 = {""};
                    String[][] n3 = {{""}};
                    String[][] e3 = {{""}};
                    String[][] t3 = {{""}};
                    String[][] i3 = {{""}};
                    AddChildToParent three = new AddChildToParent();
                    setChildToParent(three, r3, n3, e3, t3, i3);
                    break;
                case 4:
                    String[] r4 = {"H6110"};
                    String[][] n4 = {{"Prof. Frank Neitzel"}};
                    String[][] e4 = {{"frank.neitzel@tu-belin.de"}};
                    String[][] t4 = {{"+4930 314-22375"}};
                    String[][] i4 = {{"http://www.geodesy.tu-berlin.de/fileadmin/fg261/Bilder/Neitzel1.jpg"}};
                    AddChildToParent four = new AddChildToParent();
                    setChildToParent(four, r4, n4, e4, t4, i4);
                    break;
                case 5:
                    String[] r5 = {""};
                    String[][] n5 = {{""}};
                    String[][] e5 = {{""}};
                    String[][] t5 = {{""}};
                    String[][] i5 = {{""}};
                    AddChildToParent five = new AddChildToParent();
                    setChildToParent(five, r5, n5, e5, t5, i5);
                    break;
                case 6:
                    String[] r6 = {""};
                    String[][] n6 = {{""}};
                    String[][] e6 = {{""}};
                    String[][] t6 = {{""}};
                    String[][] i6 = {{""}};
                    AddChildToParent six = new AddChildToParent();
                    setChildToParent(six, r6, n6, e6, t6, i6);
                    break;
            }
        } else if(numberOfPerson == 0){ // Phd student
            switch (indexZone) {
                case 1:
                    String[] r1 = {};
                    String[][] n1 = {{""}};
                    String[][] e1 = {{""}};
                    String[][] t1 = {{""}};
                    String[][] i1 = {{""}};
                    AddChildToParent one = new AddChildToParent();
                    setChildToParent(one, r1, n1, e1, t1, i1);
                    break;
                case 2:
                    String[] r2 = {"H6158","H6161"};
                    String[][] n2 = {{"Jinpeng Feng ", "Georgios Malissiovas", "Cheng-Chieh Wu", "Anastasia Pasioti"},
                            {"Anastasios Margonis", "Ender Tasdelen"}};
                    String[][] e2 = {{"jinpeng.feng@mailbox.tu-berlin.de", "georgios.malissiovas@tu-berlin.de", "cheng-chieh.wu@bam.de", "anastasia.pasioti@mailbox.tu-berlin.de"},
                            {"anastasios.margonis@tu-berlin.de", "ender.tasdelen@tu-berlin.de"}};
                    String[][] t2 = {{"+4930 314-24147", "+4930 314-24147", "+4930 314-24147", "+4930 314-24147"},
                            {"+4930 314-29897", "+4930 314-29897"}};
                    String[][] i2 = {{"","","",""},{"",""}};
                    AddChildToParent two = new AddChildToParent();
                    setChildToParent(two, r2, n2, e2, t2, i2);
                    break;
                case 3:
                    String[] r3 = {"H6116"};
                    String[][] n3 = {{"Maria Cockric", "Kinga"}};
                    String[][] e3 = {{"maria@tu-berlin.de", "kinga@tu-berlin.de"}};
                    String[][] t3 = {{"maria", "kinga"}};
                    String[][] i3 = {{"",""}};
                    AddChildToParent three = new AddChildToParent();
                    setChildToParent(three, r3, n3, e3, t3, i3);
                    break;
                case 4:
                    String[] r4 = {""};
                    String[][] n4 = {{""}};
                    String[][] e4 = {{""}};
                    String[][] t4 = {{""}};
                    String[][] i4 = {{""}};
                    AddChildToParent four = new AddChildToParent();
                    setChildToParent(four, r4, n4, e4, t4, i4);
                    break;
                case 5:
                    String[] r5 = {"", ""};
                    String[][] n5 = {{""}, {""}};
                    String[][] e5 = {{""}, {""}};
                    String[][] t5 = {{""}, {""}};
                    String[][] i5 = {{""}, {""}};
                    AddChildToParent five = new AddChildToParent();
                    setChildToParent(five, r5, n5, e5, t5, i5);
                    break;
                case 6:
                    String[] r6 = {"", ""};
                    String[][] n6 = {{""}, {""}};
                    String[][] e6 = {{""}, {""}};
                    String[][] t6 = {{""}, {""}};
                    String[][] i6 = {{""}, {""}};
                    AddChildToParent six = new AddChildToParent();
                    setChildToParent(six, r6, n6, e6, t6, i6);
                    break;
            }
        }
    }

    public ArrayList<String> getParent(){
        return argParent;
    }

    public ArrayList<Object> getChildOne(){
        return argChildOne;
    }

    public ArrayList<Object> getChildTwo(){
        return argChildTwo;
    }

    public ArrayList<Object> getChildThree(){
        return argChildThree;
    }

    public ArrayList<Object> getChildFour(){
        return argChildFour;
    }

}
