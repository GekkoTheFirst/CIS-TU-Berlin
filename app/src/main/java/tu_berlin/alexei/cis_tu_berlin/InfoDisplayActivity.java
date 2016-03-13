package tu_berlin.alexei.cis_tu_berlin;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class InfoDisplayActivity extends AppCompatActivity {

    private static String CRITERION;
    private Handler handler = new Handler();
    private int indexZone = MainActivity.getINDEX();
    private int floorNumber = MainActivity.getFLOOR();
    private Calendar calendar = Calendar.getInstance();
    private int day;
    private int numberOfAcademician;
    private String subDepartment;
    
    private GetInfoLectureChain infoLectureChain = new GetInfoLectureChain();
    private GetInfoPersonChain infoPersonChain = new GetInfoPersonChain();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_display);

        // Search Btn
        final Button btn_search = (Button) findViewById(R.id.btn_first_element);
        // Animation
        final ObjectAnimator moverOne = ObjectAnimator.ofFloat(btn_search, "translationY", 0, 110).setDuration(600);
        final ObjectAnimator moverTwo = ObjectAnimator.ofFloat(btn_search, "translationY", 110, 220).setDuration(600);
        final ObjectAnimator moverOneBack = ObjectAnimator.ofFloat(btn_search, "translationY", 110, 0).setDuration(600);
        //final ObjectAnimator moverTwoBack = ObjectAnimator.ofFloat(btn_search, "translationY", 220, 0).setDuration(600);
        // ExpandableList
        final ExpandableListView expListView = (ExpandableListView) findViewById(R.id.expandable_list_view);
        // WeekendText
        final TextView textWeekend = (TextView) findViewById(R.id.textWeekend);

        // Spinners Chevron
        final ImageView chevron1 = (ImageView) findViewById(R.id.spinner_chevron_main);
        chevron1.getDrawable().setColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY);
        final ImageView chevron2 = (ImageView) findViewById(R.id.spinner_chevron2);
        chevron2.getDrawable().setColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY);
        final ImageView chevron3 = (ImageView) findViewById(R.id.spinner_chevron3);
        chevron3.getDrawable().setColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY);

        // First Criteria
        final Spinner spinnerMain = (Spinner) findViewById(R.id.spinnerMain);
        String[] itemsRow_1 = new String[]{"Select Criteria:", "Student", "Academicians"};
        ArrayAdapter<String> adapterOne = new ArrayAdapter<String>(this, R.layout.spinner_layout, itemsRow_1);
        spinnerMain.setAdapter(adapterOne);

        // Second Criteria
        final Spinner spinnerSecondOne = (Spinner) findViewById(R.id.spinner_2_1);
        String[] itemsRow_2_1 = new String[]{"Select Criteria:", "Lectures by room", "Lectures by today", "Academicians by room"};
        final Spinner spinnerSecondTwo = (Spinner) findViewById(R.id.spinner_2_2);
        String[] itemsRow_2_2 = new String[]{"Select Criteria:", "Lectures by room", "Assistants by room", "PhD by room"};

        // Third Criteria
        final Spinner spinnerThirdOne = (Spinner) findViewById(R.id.spinner_3_1);
        String[] itemsRow_3_1 = new String[]{"Select Criteria:", "GIS", "CV", "EGA", "SGN"};

        ArrayAdapter<String> adapterTwoOne = new ArrayAdapter<String>(this, R.layout.spinner_layout, itemsRow_2_1);
        spinnerSecondOne.setAdapter(adapterTwoOne);
        ArrayAdapter<String> adapterTwoTwo = new ArrayAdapter<String>(this, R.layout.spinner_layout, itemsRow_2_2);
        spinnerSecondTwo.setAdapter(adapterTwoTwo);
        ArrayAdapter<String> adapterThreeOne = new ArrayAdapter<String>(this, R.layout.spinner_layout, itemsRow_3_1);
        spinnerThirdOne.setAdapter(adapterThreeOne);

        spinnerMain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        CRITERION = "STUDENT";
                        subDepartment = null;
                        spinnerMain.setBackground(backgroundWithBorder(getResources().getColor(R.color.greenCheck))); //setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                        spinnerSecondOne.setSelection(0);
                        spinnerSecondTwo.setSelection(0);
                        spinnerSecondOne.setVisibility(View.VISIBLE);
                        spinnerSecondTwo.setVisibility(View.GONE);
                        chevron2.setVisibility(View.VISIBLE);
                        spinnerThirdOne.setSelection(0);
                        spinnerThirdOne.setVisibility(View.GONE);
                        chevron3.setVisibility(View.GONE);
                        moverOne.start();

                        if (expListView.getVisibility() == View.VISIBLE || textWeekend.getVisibility() == View.VISIBLE) {
                            expListView.setVisibility(View.GONE);
                            textWeekend.setVisibility(View.GONE);
                        }

                        //Toast.makeText(parent.getContext(), " Selected: " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        CRITERION = "ACADEMICIAN";
                        subDepartment = null;
                        spinnerMain.setBackground(backgroundWithBorder(getResources().getColor(R.color.greenCheck)));
                        spinnerSecondOne.setSelection(0);
                        spinnerSecondTwo.setSelection(0);
                        spinnerSecondOne.setVisibility(View.GONE);
                        spinnerSecondTwo.setVisibility(View.VISIBLE);
                        chevron2.setVisibility(View.VISIBLE);
                        spinnerThirdOne.setSelection(0);
                        spinnerThirdOne.setVisibility(View.GONE);
                        chevron3.setVisibility(View.GONE);
                        moverOne.start();;

                        if (expListView.getVisibility() == View.VISIBLE || textWeekend.getVisibility() == View.VISIBLE) {
                            expListView.setVisibility(View.GONE);
                            textWeekend.setVisibility(View.GONE);
                        }

                        //Toast.makeText(parent.getContext(), " Selected: " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        spinnerMain.setBackground(backgroundWithBorder(getResources().getColor(R.color.redDarkMain)));
                        break;
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerSecondOne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                switch (position) {
                    case 1:
                        CRITERION = "allDays";
                        subDepartment = "NoSubDepartment";
                        spinnerSecondOne.setBackground(backgroundWithBorder(getResources().getColor(R.color.greenCheck))); //setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                        spinnerThirdOne.setVisibility(View.GONE);
                        spinnerThirdOne.setVisibility(View.VISIBLE);
                        chevron3.setVisibility(View.VISIBLE);
                        moverTwo.start();
                        break;
                    case 2:
                        CRITERION = "specialDay";
                        subDepartment = "NoSubDepartment";
                        spinnerSecondOne.setBackground(backgroundWithBorder(getResources().getColor(R.color.greenCheck)));
                        spinnerThirdOne.setVisibility(View.GONE);
                        spinnerThirdOne.setVisibility(View.VISIBLE);
                        chevron3.setVisibility(View.VISIBLE);
                        moverTwo.start();
                        break;
                    case 3:
                        CRITERION = "allAcademicians";
                        subDepartment = "";
                        spinnerSecondOne.setBackground(backgroundWithBorder(getResources().getColor(R.color.greenCheck)));
                        break;
                    default:
                        spinnerSecondOne.setBackground(backgroundWithBorder(getResources().getColor(R.color.redDarkMain)));
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        spinnerSecondTwo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                switch (position) {
                    case 1:
                        CRITERION = "allDays";
                        subDepartment = "NoSubDepartment";
                        spinnerSecondTwo.setBackground(backgroundWithBorder(getResources().getColor(R.color.greenCheck))); //setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                        spinnerThirdOne.setVisibility(View.GONE);
                        spinnerThirdOne.setVisibility(View.VISIBLE);
                        chevron3.setVisibility(View.VISIBLE);
                        moverTwo.start();
                        break;
                    case 2:
                        CRITERION = "academician";
                        subDepartment = "";
                        spinnerSecondTwo.setBackground(backgroundWithBorder(getResources().getColor(R.color.greenCheck))); //setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                        break;
                    case 3:
                        CRITERION = "phd";
                        subDepartment = "";
                        spinnerSecondTwo.setBackground(backgroundWithBorder(getResources().getColor(R.color.greenCheck)));
                        break;
                    default:
                        spinnerSecondTwo.setBackground(backgroundWithBorder(getResources().getColor(R.color.redDarkMain)));
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {        }
        });

        spinnerThirdOne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                switch (position) {
                    case 1:
                        subDepartment = "GIS";
                        spinnerThirdOne.setBackground(backgroundWithBorder(getResources().getColor(R.color.greenCheck))); //setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                        break;
                    case 2:
                        subDepartment = "CV";
                        spinnerThirdOne.setBackground(backgroundWithBorder(getResources().getColor(R.color.greenCheck))); //setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                        break;
                    case 3:
                        subDepartment = "EGA";
                        spinnerThirdOne.setBackground(backgroundWithBorder(getResources().getColor(R.color.greenCheck)));
                        break;
                    case 4:
                        subDepartment = "SGN";
                        spinnerThirdOne.setBackground(backgroundWithBorder(getResources().getColor(R.color.greenCheck)));
                        break;
                    default:
                        spinnerThirdOne.setBackground(backgroundWithBorder(getResources().getColor(R.color.redDarkMain)));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btn_search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(getApplication(), "CLICK", Toast.LENGTH_LONG).show();
                Handler handler = new Handler();
                final FrameLayout loadingFrame = (FrameLayout) findViewById(R.id.whiteLoadingFrame);
                loadingFrame.getBackground().setAlpha(128);
                loadingFrame.setVisibility(View.VISIBLE);
                final RotateAnimation rotateInfoAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateInfoAnimation.setInterpolator(new LinearInterpolator());
                rotateInfoAnimation.setDuration(500);
                rotateInfoAnimation.setRepeatCount(1);
                final ImageView imageWaitView = (ImageView) findViewById(R.id.loadingInfoView);
                imageWaitView.startAnimation(rotateInfoAnimation);
                imageWaitView.setVisibility(View.VISIBLE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageWaitView.setVisibility(View.GONE);
                        loadingFrame.setVisibility(View.GONE);
                    }
                }, 1000);

                if (CRITERION != null) {
                    switch (CRITERION){
                        case "allDays":
                            day = 0;
                            break;
                        case "specialDay":
                            day = calendar.get(Calendar.DAY_OF_WEEK);
                            break;
                        case "allAcademicians":
                            numberOfAcademician = 100;
                            day = 0;
                            break;
                        case "academician":
                            numberOfAcademician = 10;
                            day = 0;
                            break;
                        case "phd":
                            numberOfAcademician = 0;
                            day = 0;
                            break;
                    }

                    if (CRITERION.equals("STUDENT") || CRITERION.equals("ACADEMICIAN")) {
                        Toast.makeText(getApplication(), "Select Next Criterion", Toast.LENGTH_SHORT).show();
                        CRITERION = null;
                    } else {
                        // Main methods
                        if (CRITERION.equals("allDays") || CRITERION.equals("specialDay")) {
                            /*if (subDepartment.equals("GIS") || subDepartment.equals("CV") || subDepartment.equals("EGA") || subDepartment.equals("SGN")){
                                moverTwoBack.start();
                            } else {
                                moverOneBack.start();
                            }*/
                            moverOneBack.start();
                            spinnerSecondOne.setVisibility(View.INVISIBLE);
                            spinnerSecondTwo.setVisibility(View.INVISIBLE);
                            spinnerThirdOne.setVisibility(View.INVISIBLE);
                            chevron2.setVisibility(View.INVISIBLE);
                            chevron3.setVisibility(View.INVISIBLE);
                            spinnerMain.setSelection(0);
                            spinnerSecondOne.setSelection(0);
                            spinnerSecondTwo.setSelection(0);
                            spinnerThirdOne.setSelection(0);

                            getInfo(CRITERION, floorNumber, day, subDepartment, indexZone);
                        } else {
                            moverOneBack.start();
                            spinnerSecondOne.setVisibility(View.INVISIBLE);
                            spinnerSecondTwo.setVisibility(View.INVISIBLE);
                            spinnerThirdOne.setVisibility(View.INVISIBLE);
                            chevron2.setVisibility(View.INVISIBLE);
                            chevron3.setVisibility(View.INVISIBLE);
                            spinnerMain.setSelection(0);
                            spinnerSecondOne.setSelection(0);
                            spinnerSecondTwo.setSelection(0);
                            spinnerThirdOne.setSelection(0);

                            getInfo(CRITERION, floorNumber, numberOfAcademician, subDepartment, indexZone);
                        }
                    // Show Expandable List or Weekend announcement
                    if(day == 1 || day == 7) {
                        textWeekend.setVisibility(View.VISIBLE);
                    } else {
                        expListView.setVisibility(View.VISIBLE);
                    }
                    CRITERION = null;
                    subDepartment = null;
                    }
                } else {
                    Toast.makeText(getApplication(), "Please Select Criteria", Toast.LENGTH_SHORT).show();
                }
            }
        });
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public GradientDrawable backgroundWithBorder(int color) {
        GradientDrawable gdDefault = new GradientDrawable();
        gdDefault.setStroke(4, color);
        gdDefault.setCornerRadii(new float[]{10, 10, 10, 10, 10, 10, 10, 10});
        return gdDefault;
    }

    public void getInfo(String criterion, int floorNumber, int dayTypeOrPersonNumber, String subDepartment, int indexZone){
        // criterion shows result of user clicking on spinners in onCreate method
        switch (criterion){
            case "allDays":
                infoLectureChain.findFloorNumberForLectureDay(floorNumber, dayTypeOrPersonNumber, subDepartment, indexZone);
                break;
            case "specialDay":
                infoLectureChain.findFloorNumberForLectureDay(floorNumber, dayTypeOrPersonNumber, subDepartment, indexZone);
                break;
            case "allAcademicians":
                infoPersonChain.findFloorNumberForPerson(floorNumber, dayTypeOrPersonNumber, indexZone);
                break;
            case "academician":
                infoPersonChain.findFloorNumberForPerson(floorNumber, dayTypeOrPersonNumber, indexZone);
                break;
            case "phd":
                infoPersonChain.findFloorNumberForPerson(floorNumber, dayTypeOrPersonNumber, indexZone);
                break;
        }
        getRoomAdapter(criterion);
    }

    public void getRoomAdapter(String adapterType) {
        Display newDisplay = getWindowManager().getDefaultDisplay();
        int width = newDisplay.getWidth();

        ExpandableListView listView = (ExpandableListView) findViewById(R.id.expandable_list_view); // you can use (ExpandableListView) findViewById(R.id.list)
        listView.setDividerHeight(2);
        listView.setGroupIndicator(null);
        listView.setClickable(true);
        listView.setGroupIndicator(getResources().getDrawable(R.drawable.group_chevron_indicator));
        listView.setIndicatorBounds(width - GetDipsFromPixel(48), width - GetDipsFromPixel(0));

        switch (adapterType) {
            case "allDays":
                LectureExtendAdapter adapterAllDays = new LectureExtendAdapter(infoLectureChain.getParent(),infoLectureChain.geChildOne(), infoLectureChain.geChildTwo(), infoLectureChain.geChildThree());
                adapterAllDays.setInflater((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE), this);
                listView.setAdapter(adapterAllDays);
                break;
            case "specialDay":
                LectureExtendAdapter adapterDays = new LectureExtendAdapter(infoLectureChain.getParent(),infoLectureChain.geChildOne(), infoLectureChain.geChildTwo(), infoLectureChain.geChildThree());
                adapterDays.setInflater((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE), this);
                listView.setAdapter(adapterDays);
                break;
            case "allAcademicians":
                PersonExtendAdapter adapterAllAcademicians = new PersonExtendAdapter(infoPersonChain.getParent(),infoPersonChain.geChildOne(), infoPersonChain.geChildTwo(), infoPersonChain.geChildThree());
                adapterAllAcademicians.setInflater((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE), this);
                listView.setAdapter(adapterAllAcademicians);
                break;
            case "academician":
                PersonExtendAdapter adapterAcademician = new PersonExtendAdapter(infoPersonChain.getParent(),infoPersonChain.geChildOne(), infoPersonChain.geChildTwo(), infoPersonChain.geChildThree());
                adapterAcademician.setInflater((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE), this);
                listView.setAdapter(adapterAcademician);
                break;
            case "phd":
                PersonExtendAdapter adapterPhd = new PersonExtendAdapter(infoPersonChain.getParent(),infoPersonChain.geChildOne(), infoPersonChain.geChildTwo(), infoPersonChain.geChildThree());
                adapterPhd.setInflater((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE), this);
                listView.setAdapter(adapterPhd);
                break;
        }
    }

    private int GetDipsFromPixel(float pixels){
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }

}