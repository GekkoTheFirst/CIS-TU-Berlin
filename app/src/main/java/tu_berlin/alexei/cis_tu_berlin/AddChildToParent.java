package tu_berlin.alexei.cis_tu_berlin;

import java.util.ArrayList;

/**
 * Created by Alexei on 02.02.2016.
 */
public class AddChildToParent {
    private ArrayList<String> parentArray = new ArrayList<String>();
    private ArrayList<Object> childArrayOne = new ArrayList<Object>();
    private ArrayList<Object> childArrayTwo = new ArrayList<Object>();
    private ArrayList<Object> childArrayThree = new ArrayList<Object>();

    public AddChildToParent(){
    }

    public ArrayList<String> getRoomNumber(String[] _setRoomParent){
        // Parent - Room Number (name)
        for(String parent : _setRoomParent){
            parentArray.add(parent);
        }
        return parentArray;
    }

    public ArrayList<Object> getLecName(String[][] _setLecName){
        // Child - Lecture Name
        ArrayList<String> child = new ArrayList<String>();
        for(int i = 0; i < _setLecName.length; i++){
            if(i != 0) {
                child = new ArrayList<String>();
            }
            for(int c = 0; c < _setLecName[i].length; c++){
                child.add(_setLecName[i][c]);
            }
            childArrayOne.add(child);
        }
        return childArrayOne;
    }

    public ArrayList<Object> getLecSemester(String[][] _setLecSemester){
        // Child - Semester Number
        ArrayList<String> child = new ArrayList<String>();
        for(int i = 0; i < _setLecSemester.length; i++){
            if(i != 0) {
                child = new ArrayList<String>();
            }
            for(int c = 0; c < _setLecSemester[i].length; c++){
                child.add(_setLecSemester[i][c]);
            }
            childArrayTwo.add(child);
        }
        return childArrayTwo;
    }

    public ArrayList<Object> getLecProfessor(String[][] _setLecProf){
        // Child - Professor Name
        ArrayList<String> child = new ArrayList<String>();
        for(int i = 0; i < _setLecProf.length; i++){
            if(i != 0) {
                child = new ArrayList<String>();
            }
            for(int c = 0; c < _setLecProf[i].length; c++){
                child.add(_setLecProf[i][c]);
            }
            childArrayThree.add(child);
        }
        return childArrayThree;
    }
}
