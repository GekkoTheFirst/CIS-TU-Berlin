package tu_berlin.alexei.cis_tu_berlin;


import android.app.*;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

/**
 * Created by Alexei on 15.01.2016.
 */
public class ProfessorCriteria extends InfoDisplayActivity{
    public static String professorCriterion;


   /* @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){


        builder.setView(view)
                .setPositiveButton(R.string.dialog_ok_btn, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        switch (professorCriterion){
                            case "room":

                                break;
                            case "assistant":
                                break;
                            case "phd":
                                break;
                            default:
                                Toast.makeText(getActivity().getApplication(), "Select Criterion", Toast.LENGTH_LONG).show();
                                break;
                        }
                    }
                })
                .setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dismiss();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }*/

    public GradientDrawable backgroundWithBorder(int color) {
        GradientDrawable gdDefault = new GradientDrawable();
        gdDefault.setStroke(4, color);
        gdDefault.setCornerRadii(new float[]{10, 10, 10, 10, 10, 10, 10, 10});
        return gdDefault;
    }

    /*public void profSelectedCriteria(String switchID, String[] lecture, String[] lectureLink, String[] prof, String[] profLink){
        String[] lectureArray = lecture;
        String[] lLink = lectureLink;
        String[] profArray = prof;
        String[] pLink = profLink;

        int limit = lectureArray.length;
        CharSequence[] finalLecLink = new CharSequence[limit];
        CharSequence[] finalProfLink = new CharSequence[limit];
        String[] fLL = new String[limit];
        String[] fPL = new String[limit];
        for(int i = 0; i < limit; i++ ) {
            finalLecLink[i] = Html.fromHtml("<a href='http://www.lsf.tu-berlin.de/qisserver/servlet/de.his.servlet.RequestDispatcherServlet?state=verpublish&status=init&vmfile=no&publishid=" + lLink[i] + "&moduleCall=webInfo&publishConfFile=webInfo&publishSubDir=veranstaltung'>" + lectureArray[i] + "</a>");
            //fLL[i] = finalLecLink.toString();
            finalProfLink[i] = Html.fromHtml("<a href='http://www.lsf.tu-berlin.de/qisserver/servlet/de.his.servlet.RequestDispatcherServlet?state=verpublish&status=init&vmfile=no&moduleCall=webInfo&publishConfFile=webInfoPerson&publishSubDir=personal&keep=y&personal.pid=" + pLink[i] + "'>" + profArray[i] + "</a>");
            //fPL[i] = finalProfLink.toString();
        }

        int newLimit = limit * 2;
        CharSequence[] finalList = new CharSequence[newLimit];

        for (int j = 0; j < limit; j++){ // int limit requires because one for loop gives two outputs!
            int even = j * 2, odd = even + 1;
            finalList[even] = finalLecLink[j];
            finalList[odd] = finalProfLink[j];
        }
*//*
        String[] s = new String[newLimit];
        for(int a = 0; a < newLimit; a++){
            s[a] = finalList[a].toString();
        }*//*

        final ListView textPrintList = (ListView) getActivity().findViewById(R.id.listOutput);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(getActivity(), android.R.layout.simple_list_item_2, finalList);

        //textPrintList.setAdapter(adapter);
        //TextView textPrintArray = (TextView) getActivity().findViewById(R.id.);
        //textPrintArray.setMovementMethod(LinkMovementMethod.getInstance());

        switch (switchID){
            case "assistant":
                textPrintList.setAdapter(adapter);
                break;
            case "phd":
                textPrintList.setAdapter(adapter);
                break;
        }

    }


    public int getLectureByDay(String s){
        int index = 0;
        Calendar sCalendar = Calendar.getInstance();
        int dayName = sCalendar.get(Calendar.DAY_OF_WEEK);
        switch (s) {
            case "GIS":
                if (Calendar.MONDAY == dayName) {

                } else if (Calendar.TUESDAY == dayName) {

                } else if (Calendar.WEDNESDAY == dayName) {

                } else if (Calendar.THURSDAY == dayName) {

                } else if (Calendar.FRIDAY == dayName) {
                    // Order is important
                    String[] lectureName = {"Geoinformation Technology", "Satellite"};
                    String[] lecLinkName = {"172632", "173068"};
                    String[] profName = {"Kada,", " Schuh"};
                    String[] profLinkName = {"22664", "18247"};
                    setLectureProfSemester(lectureName, lecLinkName, profName, profLinkName);
                } else {
                    String[] lectureName = {"Geoinformation Technology", "Satellite"};
                    String[] lecLinkName = {"172632", "173068"};
                    String[] profName = {"Kada,", " Schuh"};
                    String[] profLinkName = {"22664", "18247"};
                    setLectureProfSemester(lectureName, lecLinkName, profName, profLinkName);
                    *//*TextView weekend = (TextView) findViewById(R.id.)
                            weekend.setT*//*
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
                    String[] profName = {"Oberst"};
                    String[] profLinkName ={"5522"};
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
        StringBuilder builder = new StringBuilder();

        int limit = lectureArray.length;
        String[] finalLecLink = new String[limit];
        String[] finalProfLink = new String[limit];

        for(int ii = 0; ii < limit; ii++ ) {
            finalLecLink[ii] = "<a href='http://www.lsf.tu-berlin.de/qisserver/servlet/de.his.servlet.RequestDispatcherServlet?state=verpublish&status=init&vmfile=no&publishid=" + lLink[ii] + "&moduleCall=webInfo&publishConfFile=webInfo&publishSubDir=veranstaltung'>" + lectureArray[ii] + "</a>";
            finalProfLink[ii] = "<a href='http://www.lsf.tu-berlin.de/qisserver/servlet/de.his.servlet.RequestDispatcherServlet?state=verpublish&status=init&vmfile=no&moduleCall=webInfo&publishConfFile=webInfoPerson&publishSubDir=personal&keep=y&personal.pid=" + pLink[ii] + "'>" + profArray[ii] + "</a>";
        }

        int newLimit = limit * 2;
        String[] finalList = new String[newLimit];

        for (int j = 0; j < limit; j++){
            int even = j * 2, odd = even + 1;
            finalList[odd] = finalLecLink[j];
            finalList[even] = finalProfLink[j];
        }

        //ListView textPrintList = (ListView) getActivity().findViewById(R.id.textOutput);
        *//*TextView textPrintArray = (TextView) findViewById(R.id.textOutput);
        textPrintArray.setMovementMethod(LinkMovementMethod.getInstance());
        textPrintArray.setClickable(true);
        textPrintArray.setTextSize(14);
        for(String s: finalList) {
            textPrintArray.setText(Html.fromHtml(s));
        }*//*
        //textPrint.setTextSize(12);
        //textPrint.setText(Html.fromHtml(finalProfLink));

        //linearLayout.addView(textLecture);
            *//*textProf.setText(profArray[ii]);
            linearLayout.addView(textProf);*//*

        *//*TextView textView =(TextView)findViewById(R.id.textView);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='http://www.google.com'> Google </a>";
        textView.setText(Html.fromHtml(text));*//*
    }*/

}
