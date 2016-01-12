package tu_berlin.alexei.cis_tu_berlin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class InfoDisplayActivity extends AppCompatActivity {
    private Spinner spinnerWho, spinnerFaculty, spinnerGeodesySpecialization, spinnerMathSpecialization, spinnerRooms;
    private String[] itemsWho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_display);

        String output = TUUtils.getBBSID(getApplicationContext());
        double longitude = LocationMgr.getInstance(getApplicationContext()).getLong(getApplicationContext());
        double latitude = LocationMgr.getInstance(getApplicationContext()).getLat(getApplicationContext());

        TextView itemLoco = (TextView) findViewById(R.id.textLoco);
        itemLoco.setText("BBSID: " + output + " Lon: " + longitude + "Lat: " + latitude);

        spinnerWho = (Spinner) findViewById(R.id.spinnerRole);
        itemsWho = new String[]{"Student", "Pedagogue"};
        ArrayAdapter<String> adapterWho = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsWho);
        spinnerWho.setAdapter(adapterWho);
        spinnerWho.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int index = 0;
        switch (position) {
            case 1:
                // Spinner if student
                spinnerFaculty = (Spinner) findViewById(R.id.spinnerFaculty);
                String[] itemsFaculty = new String[]{"Msc Geodesy ang GIS", "Mathematical"};
                ArrayAdapter<String> adapterFaculty = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, itemsFaculty);
                spinnerFaculty.setAdapter(adapterFaculty);
                spinnerFaculty.setVisibility(View.VISIBLE);
                index = 1;
                break;
            case 2:
                // Spinner if Pedagogue (Professor)
                spinnerRooms = (Spinner) findViewById(R.id.spinnerRooms);
                String[] itemsRooms = new String[]{"", ""};
                ArrayAdapter<String> adapterRooms = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, itemsRooms);
                spinnerRooms.setAdapter(adapterRooms);
                spinnerFaculty.setVisibility(View.VISIBLE);
                index = 2;
                break;
        }
        // Second switch
        specializationSwitch(index);
        // Third switch
        String index2 = specializationSwitch(index);
        // Forth switch
        //int index3 = semesterSwitch();
        lectureSwitch(index2);
    }

    public String specializationSwitch(int i){
        String index = "";
        switch (i){
            case 1:
                spinnerGeodesySpecialization = (Spinner) findViewById(R.id.spinnerGeodesySpecialization);
                String[] itemsGeodesySpecialization = new String[]{"GIS", "EGA", "SGN", "CV"};
                ArrayAdapter<String> adapterGeodesySpecialization = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, itemsGeodesySpecialization);
                spinnerGeodesySpecialization.setAdapter(adapterGeodesySpecialization);
                spinnerGeodesySpecialization.setVisibility(View.VISIBLE);
                break;
            case 2:
                spinnerMathSpecialization = (Spinner) findViewById(R.id.spinnerMathSpecialization);
                String[] itemsMathSpecialization = new String[]{"Algebra", "History", "Theory"};
                ArrayAdapter<String> adapterMathSpecialization = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, itemsMathSpecialization);
                spinnerMathSpecialization.setAdapter(adapterMathSpecialization);
                spinnerMathSpecialization.setVisibility(View.VISIBLE);
                break;
        }

        String textGeodesySelect = spinnerGeodesySpecialization.getSelectedItem().toString();
        if(textGeodesySelect.equals("GIS")){
            index = "GIS";
        } else if(textGeodesySelect.equals("EGA")){
            index = "EGA";
        } else if(textGeodesySelect.equals("SGN")){
            index = "SGN";
        } else {
            index = "CV";
        }

        String textMathSelect = spinnerMathSpecialization.getSelectedItem().toString();
        if(textMathSelect.equals("Algebra")){
            index = "Algebra";
        } else if(textMathSelect.equals("History")){
            index = "History";
        } else {
            index = "Theory";
        }

        return index;
    }

  /*  public int semesterSwitch(int i){
        int index = 0;
        switch(i){
            case 1:
                index = 1; break;
            case 2:
                index = 2; break;
            case 3:
                index = 3; break;
            case 4:
                index = 4; break;
        }
        return index;
    }*/

    public int lectureSwitch(String s){
        int index = 0;
        Calendar sCalendar = Calendar.getInstance();
        int dayName = sCalendar.get(Calendar.DAY_OF_WEEK);
        switch (s) {
            case "GIS":
                    if (Calendar.MONDAY == dayName) {
                        // Order is important
                        String[] lectureName = {"Geoinformation Technology"};
                        String[] lecLinkName = {"172632"};
                        String[] profName = {"Kada/", " Adolphi/", "  König"};
                        String[] profLinkName = {"22664", "8658", "404"};
                        setLectureProfSemester(lectureName, lecLinkName, profName, profLinkName);
                    } else if (Calendar.TUESDAY == dayName) {

                    } else if (Calendar.WEDNESDAY == dayName) {

                    } else if (Calendar.THURSDAY == dayName) {

                    } else if (Calendar.FRIDAY == dayName) {

                    } else {

                    }
                break;
            case "EGA": // EGA
                if(Calendar.MONDAY == dayName){

                }else if(Calendar.TUESDAY == dayName){

                }else if(Calendar.WEDNESDAY == dayName){

                }else if(Calendar.THURSDAY == dayName){

                }else if(Calendar.FRIDAY == dayName){

                }else{

                }
                break;
            case "SGN": // SGN
                if(Calendar.MONDAY == dayName){
                    String[] lectureName = {"Introduction to Satellite Geodesy"};
                    String[] lecLinkName = {"173068"};
                    String[] profName = {"Oberst/", " Flechtner/",  " Schuh"};
                    String[] profLinkName ={"5522", "18331", "18247"};
                            setLectureProfSemester(lectureName, lecLinkName, profName, profLinkName);
                }else if(Calendar.TUESDAY == dayName){

                }else if(Calendar.WEDNESDAY == dayName){

                }else if(Calendar.THURSDAY == dayName){

                }else if(Calendar.FRIDAY == dayName){

                }else{

                }
                break;
            case "CV": // CV
                if(Calendar.MONDAY == dayName){

                }else if(Calendar.TUESDAY == dayName){

                }else if(Calendar.WEDNESDAY == dayName){

                }else if(Calendar.THURSDAY == dayName){

                }else if(Calendar.FRIDAY == dayName){

                }else{

                }
                break;
        }
        return index;
    }

    private void setLectureProfSemester(String[] lecture, String[] lectureLink, String[] prof, String[] profLink){
        String[] lectureArray = lecture;
        String[] lLink = lectureLink;
        String[] profArray = prof;
        String[] pLink = profLink;

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.textOutput);
        setContentView(linearLayout);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        for(int ii = 0; ii < profArray.length; ii++ ){
            TextView textLecture = (TextView) findViewById(R.id.textSchedule);
            textLecture.setClickable(true);
            textLecture.setMovementMethod(LinkMovementMethod.getInstance());
            String finalLecLink = "<a href='http://www.lsf.tu-berlin.de/qisserver/servlet/de.his.servlet.RequestDispatcherServlet?state=verpublish&status=init&vmfile=no&publishid=" + lLink[ii] + "&moduleCall=webInfo&publishConfFile=webInfo&publishSubDir=veranstaltung'>" + lectureArray[ii] + "</a>";
            textLecture.setText(Html.fromHtml(finalLecLink));
            linearLayout.addView(textLecture);

            TextView textProf = (TextView) findViewById(R.id.textSchedule);
            textProf.setClickable(true);
            textProf.setMovementMethod(LinkMovementMethod.getInstance());
            String finalProfLink = "<a href='http://www.lsf.tu-berlin.de/qisserver/servlet/de.his.servlet.RequestDispatcherServlet?state=verpublish&status=init&vmfile=no&moduleCall=webInfo&publishConfFile=webInfoPerson&publishSubDir=personal&keep=y&personal.pid=" + pLink[ii] + "'>" + profArray[ii] + "</a>";
            textProf.setText(Html.fromHtml(finalProfLink));
            linearLayout.addView(textLecture);
            /*textProf.setText(profArray[ii]);
            linearLayout.addView(textProf);*/
        }
        /*TextView textView =(TextView)findViewById(R.id.textView);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='http://www.google.com'> Google </a>";
        textView.setText(Html.fromHtml(text));*/
    }
}
