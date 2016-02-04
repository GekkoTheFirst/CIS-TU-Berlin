package tu_berlin.alexei.cis_tu_berlin;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;


public class InfoDisplayActivity extends AppCompatActivity {

    private static String CRITERION;
    private int indexZone = MainActivity.getINDEX();
    private int floorNumber = MainActivity.getFLOOR();
    private Calendar calendar = Calendar.getInstance();
    private int day = calendar.get(Calendar.DAY_OF_WEEK);
    private int numberOfAcademician;

    private boolean clicked = true;
    private GetInfoLectureChain infoLectureChain = new GetInfoLectureChain();
    private GetInfoPersonChain infoPersonChain = new GetInfoPersonChain();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_display);

        final Button btn_search = (Button) findViewById(R.id.btn_first_element);
        final ObjectAnimator mover = ObjectAnimator.ofFloat(btn_search, "translationY", 0, 110);
        final ObjectAnimator moverBack = ObjectAnimator.ofFloat(btn_search, "translationY", 110, 0);

        final ExpandableListView expListView = (ExpandableListView) findViewById(R.id.expandable_list_view);

        // Spinners Chevron
        final ImageView chevron1 = (ImageView) findViewById(R.id.spinner_chevron_main);
        chevron1.getDrawable().setColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY);

        final ImageView chevron2 = (ImageView) findViewById(R.id.spinner_chevron2);
        chevron2.getDrawable().setColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY);

        // First Criteria
        final Spinner spinnerMain = (Spinner) findViewById(R.id.spinnerMain);
        String[] itemsRow_1 = new String[]{"Select Criteria:", "Student", "Academicians"};
        ArrayAdapter<String> adapterOne = new ArrayAdapter<String>(this, R.layout.spinner_layout, itemsRow_1);
        spinnerMain.setAdapter(adapterOne);

        // Second Criteria
        final Spinner spinnerSecondOne = (Spinner) findViewById(R.id.spinnerProf_2_1);
        String[] itemsRow_2_1 = new String[]{"Select Criteria:", "Lectures by room", "Lectures by today", "Academicians by room"};
        final Spinner spinnerSecondTwo = (Spinner) findViewById(R.id.spinnerProf_2_2);
        String[] itemsRow_2_2 = new String[]{"Select Criteria:", "Lectures by room", "Assistants by room", "PhD by room"};

        ArrayAdapter<String> adapterTwoOne = new ArrayAdapter<String>(this, R.layout.spinner_layout, itemsRow_2_1);
        spinnerSecondOne.setAdapter(adapterTwoOne);
        ArrayAdapter<String> adapterTwoTwo = new ArrayAdapter<String>(this, R.layout.spinner_layout, itemsRow_2_2);
        spinnerSecondTwo.setAdapter(adapterTwoTwo);

        spinnerMain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        CRITERION = "STUDENT";
                        spinnerMain.setBackground(backgroundWithBorder(getResources().getColor(R.color.greenCheck))); //setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                        spinnerSecondTwo.setVisibility(View.GONE);
                        spinnerSecondOne.setVisibility(View.VISIBLE);
                        chevron2.setVisibility(View.VISIBLE);
                        mover.start();

                        if(expListView.getVisibility() == View.VISIBLE){
                            expListView.setVisibility(View.GONE);
                            clicked = true;
                        }

                        Toast.makeText(parent.getContext(), " Selected: " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        CRITERION = "ACADEMICIAN";
                        spinnerMain.setBackground(backgroundWithBorder(getResources().getColor(R.color.greenCheck)));
                        spinnerSecondOne.setVisibility(View.GONE);
                        spinnerSecondTwo.setVisibility(View.VISIBLE);
                        chevron2.setVisibility(View.VISIBLE);
                        mover.start();
                        if(expListView.getVisibility() == View.VISIBLE){
                            expListView.setVisibility(View.GONE);
                            clicked = true;
                        }

                        Toast.makeText(parent.getContext(), " Selected: " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
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
                        spinnerSecondOne.setBackground(backgroundWithBorder(getResources().getColor(R.color.greenCheck))); //setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);

                        Toast.makeText(parent.getContext(), " Selected: " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        CRITERION = "specialDay";
                        spinnerSecondOne.setBackground(backgroundWithBorder(getResources().getColor(R.color.greenCheck)));

                        Toast.makeText(parent.getContext(), " Selected: " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        CRITERION = "allAcademicians";
                        spinnerSecondOne.setBackground(backgroundWithBorder(getResources().getColor(R.color.greenCheck)));

                        Toast.makeText(parent.getContext(), " Selected: " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
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
                        spinnerSecondTwo.setBackground(backgroundWithBorder(getResources().getColor(R.color.greenCheck))); //setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);

                        Toast.makeText(parent.getContext(), " Selected: " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        CRITERION = "academician";
                        spinnerSecondTwo.setBackground(backgroundWithBorder(getResources().getColor(R.color.greenCheck))); //setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);

                        Toast.makeText(parent.getContext(), " Selected: " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        CRITERION = "phd";
                        spinnerSecondTwo.setBackground(backgroundWithBorder(getResources().getColor(R.color.greenCheck)));

                        Toast.makeText(parent.getContext(), " Selected: " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        spinnerSecondTwo.setBackground(backgroundWithBorder(getResources().getColor(R.color.redDarkMain)));

                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {        }
        });

        btn_search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplication(), "CLICK", Toast.LENGTH_LONG).show();
                if(CRITERION == "allDays"){
                    day = 0;
                } else if (CRITERION == "allAcademicians"){
                    numberOfAcademician = 100;
                } else if (CRITERION == "academician"){
                    numberOfAcademician = 10;
                } else if (CRITERION == "phd"){
                    numberOfAcademician = 0;
                }
                if(CRITERION != null){
                    if(clicked) {
                        moverBack.start();
                        spinnerSecondOne.setVisibility(View.INVISIBLE);
                        spinnerSecondTwo.setVisibility(View.INVISIBLE);
                        chevron2.setVisibility(View.INVISIBLE);
                        spinnerMain.setSelection(0);
                        spinnerSecondOne.setSelection(0);
                        spinnerSecondTwo.setSelection(0);
                        // Main methods
                        if(CRITERION == "allDays" || CRITERION == "specialDay") {
                            getInfo(CRITERION, floorNumber, day, indexZone);
                        } else {
                            getInfo(CRITERION, floorNumber, numberOfAcademician, indexZone);
                        }

                        expListView.setVisibility(View.VISIBLE);
                        clicked = false;
                        CRITERION = null;
                    } else {
                        Toast.makeText(getApplication(), "You've clicked, Reload window", Toast.LENGTH_SHORT).show();
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

    public void getInfo(String criterion, int floorNumber, int dayTypeOrPersonNumber, int indexZone){
        // criterion shows result of user clicking on spinners in onCreate method
        switch (criterion){
            case "allDays":
                infoLectureChain.findFloorNumberForLectureDay(floorNumber, dayTypeOrPersonNumber, indexZone);
                break;
            case "specialDay":
                infoLectureChain.findFloorNumberForLectureDay(floorNumber, dayTypeOrPersonNumber, indexZone);
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