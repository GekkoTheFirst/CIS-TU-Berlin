package tu_berlin.alexei.cis_tu_berlin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


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
        switch (position) {
            case 0:
                // Spinner if student
                spinnerFaculty = (Spinner) findViewById(R.id.spinnerFaculty);
                String[] itemsFaculty = new String[]{"Msc Geodesy ang GIS", "Mathematical"};
                ArrayAdapter<String> adapterFaculty = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, itemsFaculty);
                spinnerFaculty.setAdapter(adapterFaculty);
                spinnerFaculty.setVisibility(View.VISIBLE);
                break;
            case 1:
                // Spinner if Pedagogue (Professor)
                spinnerRooms = (Spinner) findViewById(R.id.spinnerRooms);
                String[] itemsRooms = new String[]{"Msc Geodesy ang GIS", "Mathematical"};
                ArrayAdapter<String> adapterRooms = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, itemsRooms);
                spinnerRooms.setAdapter(adapterRooms);
                spinnerFaculty.setVisibility(View.VISIBLE);

                break;
        }
    }

    public void facultySwitch(int i){
        switch (i){
            case 0:
                spinnerGeodesySpecialization = (Spinner) findViewById(R.id.spinnerGeodesySpecialization);
                String[] itemsGeodesySpecialization = new String[]{"GIS", "EGA", "SGN", "CV"};
                ArrayAdapter<String> adapterGeodesySpecialization = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, itemsGeodesySpecialization);
                spinnerGeodesySpecialization.setAdapter(adapterGeodesySpecialization);
                spinnerGeodesySpecialization.setVisibility(View.VISIBLE);
                break;
            case 1:
                spinnerMathSpecialization = (Spinner) findViewById(R.id.spinnerMathSpecialization);
                String[] itemsMathSpecialization = new String[]{"Algebra", "History", "Theory"};
                ArrayAdapter<String> adapterMathSpecialization = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, itemsMathSpecialization);
                spinnerMathSpecialization.setAdapter(adapterMathSpecialization);
                spinnerMathSpecialization.setVisibility(View.VISIBLE);
                break;
        }
    }
}
