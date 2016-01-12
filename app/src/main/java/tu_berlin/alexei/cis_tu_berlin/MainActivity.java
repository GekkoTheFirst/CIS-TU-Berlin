package tu_berlin.alexei.cis_tu_berlin;



import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.esri.android.map.LocationDisplayManager;
import com.esri.android.map.MapOptions;
import com.esri.android.map.MapView;
import com.esri.android.map.ags.ArcGISDynamicMapServiceLayer;
import com.esri.android.map.event.OnStatusChangedListener;
import com.esri.core.geometry.Polygon;


public class MainActivity extends AppCompatActivity {

    // MAC ADDRESS of the floors Fl - Floor L - Left, M - Middle, R - Right
    private String FAKE = "01:80:c2:00:00:03";
    // 6th
    private static final String TAG = "NB:";
    private String BSSID6FlLL = "a0:cf:5b:3d:df:32";
    private String BSSID6FlLR = "a0:cf:5b:fa:43:e2";
    private String BSSID6FlLR2 = "a0:cf:5b:3d:dd:62"; // !?
    private String BSSID6FlML = "a0:cf:5b:3f:eb:02"; // !?
    private String BSSID6FlMR = "a0:cf:5b:3f:da:f2";
    // 5th
    private String BSSID5FlLL = "a0:cf:5b:0e:35:52";
    private String BSSID5FlLR = "a0:cf:5b:3d:dd:62"; // ?!
    private String BSSID5FlML = "a0:cf:5b:3d:d7:d2"; // ?!
    private String BSSID5FlMR = "a0:cf:5b:0e:34:72"; // ?!

    // Map
    private MapView mMapView = null;
    private Polygon mCurrentMapExtent = null;
    private ArcGISDynamicMapServiceLayer mDynamicServiceLayer;

    // The basemap switching menu items.
    private MenuItem mStreetsMenuItem = null;
    private MenuItem mTopoMenuItem = null;
    private MenuItem mHybridBasemapItem = null;
    private MenuItem mOSMBasemapItem = null;

    // Create MapOptions for each type of basemap.
    private final MapOptions mTopoBasemap = new MapOptions(MapOptions.MapType.TOPO);
    private final MapOptions mStreetsBasemap = new MapOptions(MapOptions.MapType.STREETS);
    private final MapOptions mHybridBasemap = new MapOptions(MapOptions.MapType.HYBRID);
    private final MapOptions mOSMBasemap = new MapOptions(MapOptions.MapType.OSM);

    public void getPos(MapView mMapView) {
        LocationDisplayManager loc = mMapView.getLocationDisplayManager();
        loc.setAutoPanMode(LocationDisplayManager.AutoPanMode.LOCATION);
        loc.start();
    }

    public int getIndex() {
        int index = 0;
        double longitude = LocationMgr.getInstance(getApplicationContext()).getLong(getApplicationContext());
        double latitude = LocationMgr.getInstance(getApplicationContext()).getLat(getApplicationContext());
        // Order Lat Lon && Lat Lon
        if(52.511874 < latitude && 13.325517 < longitude && 52.512440 > latitude && 13.326027 > longitude){
            //Log.i("test"," result = "+longitude);
            // Zone 1 (left side of left part)
            index = 1;
        } else if((52.511906 < latitude && 13.326167 < longitude) && (52.512450 > latitude && 13.326585 > longitude)){
            // Zone 2 (right side of left part)
            index = 2;
        } else if((52.511981 < latitude && 13.326660 < longitude) && (52.512450 > latitude && 13.326940 > longitude)){
            // Zone 3 (left side of middle part)
            index = 3;
        } else if((52.511968 < latitude && 13.327034 < longitude) && (52.512520 > latitude && 13.327325 > longitude)){
            // Zone 4 (right side of middle part)
            index = 4;
        } else if((52.512007 < latitude && 13.327380 < longitude) && (52.512578 > latitude && 13.327756 > longitude)){
            // Zone 5 (left side of right part)
            index = 5;
        } else if((52.512062 < latitude && 13.327938 < longitude) && (52.512616 > latitude && 13.328459 > longitude)){
            // Zone 6 (right side of right part)
            index = 6;
        } else {
            index = 7;
        }
        return index;
    }

    public void getButton (){
        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        final Button nextButton = (Button) findViewById(R.id.i_btn);
        nextButton.setVisibility(View.VISIBLE);
        nextButton.setAnimation(animAlpha);
        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent infoIntent = new Intent(MainActivity.this, InfoDisplayActivity.class);
                startActivity(infoIntent);
                nextButton.setVisibility(View.GONE);
            }
        });
    }

    public void getFloorByMac(int index, MapView x, String s) {
        switch(index) {
            case 1:
                if (s.equals(BSSID5FlLL) || s.equals(BSSID5FlLR) || s.equals(BSSID5FlML) || s.equals(BSSID5FlMR)) {
                    getButton();
                    getHBuildingFloor5(x);
                } else {
                    Toast.makeText(getApplicationContext(), "OUT OF TEST AREA", Toast.LENGTH_LONG).show();
                }
                break;
            case 2:
                if (s.equals(BSSID6FlLL) || s.equals(BSSID6FlLR) || s.equals(BSSID6FlML) || s.equals(BSSID6FlMR) || s.equals(BSSID6FlLR2) || s.equals(FAKE)) {
                    getButton();
                    getHBuildingFloor6(x);
                } else {
                    Toast.makeText(getApplicationContext(), "OUT OF TEST AREA", Toast.LENGTH_LONG).show();
                }
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 7:
            default:
                Toast.makeText(getApplicationContext(), "OUT OF MAIN BUILDING", Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check WiFi status
        checkWifiStatus();

        // Create basemap
        mMapView = (MapView) findViewById(R.id.map);
        // Make method return next variable
        mDynamicServiceLayer = new ArcGISDynamicMapServiceLayer(getResources().getString(R.string.map_service_url));
        // Draw H-building contour
        getHBuildingContour(mMapView);


        FloatingActionButton positionDetectionBtn = (FloatingActionButton)findViewById(R.id.buttonPosition);
        positionDetectionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If WiFi is connected, MacAddress will be obtained and map will be shown
                checkGPSStatus();

                getPos(mMapView);
                int index = getIndex();
                String wifiMac = TUUtils.getBBSID(getApplicationContext());
                getFloorByMac(index, mMapView, wifiMac);
            }
        });

        // Set a listener for map status changes; this will be called when switching basemaps.
        mMapView.setOnStatusChangedListener(new OnStatusChangedListener() {

            private static final long serialVersionUID = 1L;

            public void onStatusChanged(Object source, STATUS status) {
                // Set the map extent once the map has been initialized, and the basemap is added
                // or changed; this will be indicated by the layer initialization of the basemap layer. As there is only
                // a single layer, there is no need to check the source object.
                if (STATUS.LAYER_LOADED == status) {
                    mMapView.setExtent(mCurrentMapExtent);
                }
            }
        });

    }

    public void checkGPSStatus(){
        LocationDisplayManager loc = mMapView.getLocationDisplayManager();
        if(!loc.isAllowNetworkLocation()){
            FragmentManager fm = getFragmentManager();
            DialogFragment gpsAlert = new GPSDialogFragment();
            gpsAlert.show(fm, "GPSDialogFragment");
        }
    }

    public void checkWifiStatus(){
        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (!mWifi.isConnected()) {
            FragmentManager fm = getFragmentManager();
            DialogFragment wifiAlert = new WifiDialogFragment();
            wifiAlert.show(fm, "WifiDialogFragment");
        }
    }

    public String getServerUrl(){
        String url = getResources().getString(R.string.map_service_url);
        return url;
    }

    public void getHBuildingContour(MapView x) {
        int[] i = {6};
        x.addLayer(new ArcGISDynamicMapServiceLayer(getServerUrl(), i));
    }

    public void getHBuildingFloor5(MapView x) {
        int[] i = {0, 1, 2, 3, 4};
        x.addLayer(new ArcGISDynamicMapServiceLayer(getServerUrl(), i));
    }

    public void getHBuildingFloor6(MapView x) {
        int[] i = {0, 1, 2, 3, 5};
        x.addLayer(new ArcGISDynamicMapServiceLayer(getServerUrl(), i));
    }

    public ArcGISDynamicMapServiceLayer getLayer(){
        return mDynamicServiceLayer;
    }

    // OptionMenu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);

        // Get the basemap switching menu items.
        mStreetsMenuItem = menu.getItem(2);
        mStreetsMenuItem.setChecked(true);
        mTopoMenuItem = menu.getItem(3);
        mHybridBasemapItem = menu.getItem(4);
        mOSMBasemapItem = menu.getItem(5);
        return true;
    }

    // Basemaps Option list
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Save the current extent of the map before changing the map.
        mCurrentMapExtent = mMapView.getExtent();

        switch (item.getItemId()) {
            case R.id.legend:
                new LegendDialogFragment().show(getFragmentManager(), LegendDialogFragment.TAG);
                return true;
            case R.id.World_Street_Map:
                mMapView.setMapOptions(mStreetsBasemap);
                mStreetsMenuItem.setChecked(true);
                Toast.makeText(this, "Map is being changed to \"streets\"", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.World_Topo:
                mMapView.setMapOptions(mTopoBasemap);
                mTopoMenuItem.setChecked(true);
                Toast.makeText(this, "Map is being changed to \"topo\"", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.World_Hybrid:
                mMapView.setMapOptions(mHybridBasemap);
                mHybridBasemapItem.setChecked(true);
                Toast.makeText(this, "Map is being changed to \"hybrid\"", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.OSM:
                mMapView.setMapOptions(mOSMBasemap);
                mOSMBasemapItem.setChecked(true);
                Toast.makeText(this, "Map is being changed to \"OSM\"", Toast.LENGTH_SHORT).show();
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Call MapView.pause to suspend map rendering while the activity is paused, which can save battery usage.
        if (mMapView != null)
        {
            mMapView.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Call MapView.unpause to resume map rendering when the activity returns to the foreground.
        if (mMapView != null)
        {
            mMapView.unpause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
