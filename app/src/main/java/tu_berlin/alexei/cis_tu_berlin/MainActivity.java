package tu_berlin.alexei.cis_tu_berlin;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.esri.android.map.Layer;
import com.esri.android.map.LocationDisplayManager;
import com.esri.android.map.MapOptions;
import com.esri.android.map.MapView;
import com.esri.android.map.ags.ArcGISDynamicMapServiceLayer;
import com.esri.android.map.event.OnStatusChangedListener;
import com.esri.core.geometry.Polygon;


public class MainActivity extends AppCompatActivity {

    // Static variables
    private static int INDEX;
    private static int FLOOR;
    public static final String TAG = "NB:";
    // Map
    private MapView mMapView = null;
    private Polygon mCurrentMapExtent = null;
    private ArcGISDynamicMapServiceLayer mDynamicServiceLayer;

    // The basemap switching menu items.
    private MenuItem mStreetsMenuItem = null, mTopoMenuItem = null, mHybridBasemapItem = null, mOSMBasemapItem = null;

    // Create MapOptions for each type of basemap.
    private final MapOptions mTopoBasemap = new MapOptions(MapOptions.MapType.TOPO);
    private final MapOptions mStreetsBasemap = new MapOptions(MapOptions.MapType.STREETS);
    private final MapOptions mHybridBasemap = new MapOptions(MapOptions.MapType.HYBRID);
    private final MapOptions mOSMBasemap = new MapOptions(MapOptions.MapType.OSM);


    // MAC ADDRESS of the floors Fl - Floor L - Left, M - Middle, R - Right
    private String FAKE = "01:80:c2:00:00:03";
    // 6th
    private String BSSID6FlLL = "a0:cf:5b:3d:df:32";
    //private String BSSID6FlLR = "a0:cf:5b:fa:43:e2";
    private String BSSID6FlLR = "a0:cf:5b:3d:dd:62"; // !?
    private String BSSID6FlML = "a0:cf:5b:3f:eb:02"; // !?
    private String BSSID6FlMR = "a0:cf:5b:3f:da:f2";
    // 5th
    private String BSSID5FlLL = "a0:cf:5b:0e:35:52";
    private String BSSID5FlLR = "a0:cf:5b:3d:dd:62"; // ?!
    private String BSSID5FlML = "a0:cf:5b:3f:eb:02"; // ?!
    private String BSSID5FlMR = "a0:cf:5b:0e:34:72"; // ?!

    private int findIndex(){
        LocationMgr locationMgr = LocationMgr.getInstance(this);
        if(locationMgr == null){
            Log.e("test", "Location mgr is null");
        }
        double latitude = locationMgr.getLat(this); //this
        double longitude = locationMgr.getLong(this); //this getApplicationContext()

        // Order Lat Lon && Lat Lon
        if(latitude < 0 && longitude < 0) {
            //gps.checkGPSStatus();
        } else if((latitude > 52.511874 && longitude > 13.325517) && (latitude < 52.512440 && longitude < 13.326027)){
            //Log.i("test"," result = "+longitude);
            // Zone 1 (left side of left part)
            INDEX = 1;
        } else if((latitude > 52.511906 && longitude > 13.326167) && (latitude < 52.512450 && longitude < 13.326585)){
            // Zone 2 (right side of left part)
            INDEX = 2;
        } else if((latitude > 52.511981 && longitude > 13.326660) && (latitude < 52.512450 && longitude < 13.326940)){
            // Zone 3 (left side of middle part)
            INDEX = 3;
        } else if((latitude > 52.511968 && longitude > 13.327034) && (latitude < 52.512520 && longitude < 13.327325)){
            // Zone 4 (right side of middle part)
            INDEX = 4;
        } else if((latitude > 52.512007 && longitude > 13.327380) && (latitude < 52.512578 && longitude < 13.327756)){
            // Zone 5 (left side of right part)
            INDEX = 5;
        } else if((latitude > 52.512062 && longitude > 13.327938) && (latitude < 52.512616 && longitude < 13.328459)){
            // Zone 6 (right side of right part)
            INDEX = 6;
        }
        return INDEX;
    }

    public static int getINDEX(){
        return INDEX;
    }


    public void getHBuildingFloor(MapView mapView, int floorID) {
        switch (floorID) {
            case 100: // H contour
                int[] contourH_ID = {6};
                mapView.addLayer(new ArcGISDynamicMapServiceLayer(getServerUrl(), contourH_ID));
                break;
            case 5: // H 5th Floor
                if(mapView.getLayers().length > 2) {
                    mapView.removeLayer(2);
                    int[] floorH5_ID = {0, 1, 4};
                    mapView.addLayer(new ArcGISDynamicMapServiceLayer(getServerUrl(), floorH5_ID));
                } else {
                    int[] floorH5_ID = {0, 1, 4};
                    mapView.addLayer(new ArcGISDynamicMapServiceLayer(getServerUrl(), floorH5_ID));
                }
                break;
            case 6: //H 6th Floor
                if(mapView.getLayers().length > 2) {
                    mapView.removeLayer(2);
                    int[] floorH6_ID = {0, 1, 2, 3, 5};
                    mapView.addLayer(new ArcGISDynamicMapServiceLayer(getServerUrl(), floorH6_ID));
                } else {
                    int[] floorH6_ID = {0, 1, 2, 3, 5};
                    mapView.addLayer(new ArcGISDynamicMapServiceLayer(getServerUrl(), floorH6_ID));
                }
                break;
        }
    }


    public void getFloorByMac(int index, MapView x, String s, int i) {
        //String btnStatus = "";

        switch (index) {
            case 1:
                if (s.equals(BSSID5FlLL) || s.equals(BSSID5FlLR) || s.equals(BSSID5FlML) || s.equals(BSSID5FlMR) || s.equals(FAKE)) {
                    getHBuildingFloor(x, 5);
                    getInfoButton();
                    FLOOR = 5;
                } else if(s.equals(BSSID6FlLR) && i > -70) {
                    getHBuildingFloor(x, 6);
                    getInfoButton();
                } else if (s.equals(BSSID6FlLR) && i < -70){
                    getHBuildingFloor(x, 5);
                    getInfoButton();
                    FLOOR = 5;
                } else {
                    Toast.makeText(getApplicationContext(), "OUT OF TEST AREA", Toast.LENGTH_LONG).show();
                }
                break;
            case 2:
                if (s.equals(BSSID6FlLL) || s.equals(BSSID6FlML) || s.equals(BSSID6FlMR) || s.equals(FAKE)) {
                    getHBuildingFloor(x, 6);
                    getInfoButton();
                    FLOOR = 6;
                } else if(s.equals(BSSID6FlLR) && i > -70) {
                    getHBuildingFloor(x, 6);
                    getInfoButton();
                    FLOOR = 6;
                } else if (s.equals(BSSID6FlLR) && i < -70){
                    getHBuildingFloor(x, 5);
                    getInfoButton();
                    FLOOR = 6;
                } else {
                    Toast.makeText(getApplicationContext(), "OUT OF TEST AREA", Toast.LENGTH_LONG).show();
                    getInfoButton();
                }
                break;
            default:
                //Toast.makeText(getApplicationContext(), "Out of test area", Toast.LENGTH_LONG).show();
                break;
        }
    }

    public static int getFLOOR(){
        return FLOOR;
    }


// onCreate Method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Loading gif
        //final GifWebView gif = new GifWebView(this, "file:///android_asset/progress.bar.gif");

        // Check WiFi status
        checkWifiStatus();

        // Create basemap
        mMapView = (MapView) findViewById(R.id.map);
        // Make method return next variable
        mDynamicServiceLayer = new ArcGISDynamicMapServiceLayer(getServerUrl());
        // Draw H-building contour
        getHBuildingFloor(mMapView, 100);

        FloatingActionButton positionDetectionBtn = (FloatingActionButton)findViewById(R.id.buttonPosition);
        positionDetectionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display your position
                getPosition(mMapView);

                // If WiFi is connected, MacAddress will be obtained and map will be shown
                String wifiMac = TUUtils.getBBSID(getApplicationContext());
                int rssiMac = TUUtils.getRssi(getApplicationContext());
                int index = findIndex();

                // Render right floor based on MAC ADDRESS and Coordinates
                // Test
                /*double longitude = LocationMgr.getInstance(getApplicationContext()).getLong(getApplicationContext());
                double latitude = LocationMgr.getInstance(getApplicationContext()).getLat(getApplicationContext());
                INDEX = 1;
                getFloorByMac(INDEX, mMapView, FAKE, rssiMac);
                TextView itemLoco = (TextView) findViewById(R.id.textLocation);
                itemLoco.setText("Rssi: " + rssiMac + " BBSID: " + wifiMac + " Lon: " + longitude + "Lat: " + latitude);*/
                // Release
                getFloorByMac(index, mMapView, wifiMac, rssiMac);
            }
        });

        // Set a listener for map status changes; this will be called when switching basemaps.
        mMapView.setOnStatusChangedListener(new OnStatusChangedListener() {

            private static final long serialVersionUID = 1L;

            public void onStatusChanged(Object source, STATUS status) {
                // Set the map extent once the map has been initialized, and the basemap is added or changed;
                final RotateAnimation rotateMainAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateMainAnimation.setInterpolator(new LinearInterpolator());
                rotateMainAnimation.setDuration(500);
                double random = 1 + Math.random()*5;
                rotateMainAnimation.setRepeatCount((int)random);

                final ImageView imageWaitView = (ImageView) findViewById(R.id.loadingMainView);
                imageWaitView.startAnimation(rotateMainAnimation);
                imageWaitView.setVisibility(View.VISIBLE);

                if (STATUS.LAYER_LOADED == status) {
                    mMapView.setExtent(mCurrentMapExtent);
                    imageWaitView.setVisibility(View.GONE);
                    //gif.setVisibility(View.GONE);
                }
            }
        });

    }

    public String getServerUrl(){
        return getResources().getString(R.string.map_service_url);
    }

    // Info Button
    public void getInfoButton (){
        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        final Button nextButton = (Button) findViewById(R.id.btn_info);
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

    public void getPosition(MapView mMapView) {
        LocationDisplayManager loc = mMapView.getLocationDisplayManager();
        loc.setAutoPanMode(LocationDisplayManager.AutoPanMode.LOCATION);
        loc.start();
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

    public ArcGISDynamicMapServiceLayer getLayer(){
        return mDynamicServiceLayer;
    }

    // OptionMenu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);

        // Get the basemap switching menu items.
        mStreetsMenuItem = menu.getItem(1);
        mStreetsMenuItem.setChecked(true);
        mTopoMenuItem = menu.getItem(2);
        mHybridBasemapItem = menu.getItem(3);
        mOSMBasemapItem = menu.getItem(4);
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
