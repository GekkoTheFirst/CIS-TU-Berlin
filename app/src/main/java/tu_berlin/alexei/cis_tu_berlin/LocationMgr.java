package tu_berlin.alexei.cis_tu_berlin;

import android.Manifest;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Alexei on 08.01.2016.
 */
public class LocationMgr {

    private static LocationMgr m_sLocationMgrInstance;
    private LocationManager lm;

    private final LocationListener locationListener = new LocationListener() {

        public void onLocationChanged(Location location) {
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onProviderDisabled(String provider) {
        }
    };

    private LocationMgr(Context applicationContext) {
        lm = (LocationManager) applicationContext.getSystemService(Context.LOCATION_SERVICE);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10, locationListener);
        if (!lm.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            Log.e("ERROR", "GPS is off");
        } else {
            Log.i("INFO", "GPS is on");
        }

    }

    public double getLong(Context applicationContext) {
        lm = (LocationManager) applicationContext.getSystemService(Context.LOCATION_SERVICE);
       /* if (!lm.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            Log.e("Error", "GPS is off");
        }*/
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        double longitude = location.getLongitude();
        /*if(location == null){
            longitude = 52.512330;
            Log.e("Error","Longitude is Null");
        }*/
        return longitude;
    }

    public double getLat(Context applicationContext ){
        lm = (LocationManager)applicationContext.getSystemService(Context.LOCATION_SERVICE);
        /*if ( !lm.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            Log.e("Error","GPS is off");
        }*/
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        double latitude = location.getLatitude();
        /*if(location == null){
            latitude = 13.326923;
            Log.e("Error","Latitude is Null");
        }*/
        return latitude;
    }

    public static LocationMgr getInstance(Context applicationContext){
        if(m_sLocationMgrInstance == null){
            m_sLocationMgrInstance = new LocationMgr(applicationContext);
        }
        return m_sLocationMgrInstance;
    }

}
