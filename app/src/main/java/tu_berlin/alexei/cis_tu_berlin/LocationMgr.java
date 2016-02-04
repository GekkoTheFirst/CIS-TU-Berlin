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

import com.esri.android.map.LocationDisplayManager;

import java.util.List;

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
            Log.i("test","onStatusChanged status "+status+" provider "+provider);
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
            Log.i(MainActivity.TAG, "GPS is off");
        } else {
            Log.i(MainActivity.TAG, "GPS is on");
        }
    }

    public double getLong(Context applicationContext) {
        lm = (LocationManager)applicationContext.getSystemService(Context.LOCATION_SERVICE);
        if(lm == null){
            return -1;
        }
        List<String> providers = lm.getAllProviders();

        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if(location == null) {
            for (String strProvider : providers) {
                //Log.i("test", "" + strProvider);
                location = lm.getLastKnownLocation(strProvider);
                if(location != null){
                    break;
                }
                //Log.i("test", "location " + location);
            }
        }

        if(location == null){
            return -1;
        }

        double longitude = location.getLongitude();

        return longitude;
    }

    public double getLat(Context applicationContext ){
        lm = (LocationManager)applicationContext.getSystemService(Context.LOCATION_SERVICE);
        if(lm == null){
            return -1;
        }
        List<String> providers = lm.getAllProviders();

        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if(location == null) {
            for (String strProvider : providers) {
                //Log.i("test", "" + strProvider);
                location = lm.getLastKnownLocation(strProvider);
                if(location != null){
                    break;
                }
                //Log.i("test", "location: " + location);
            }
        }

        if(location == null){
            return -1;
        }

        double latitude = location.getLatitude();

        return latitude;
    }

    public static LocationMgr getInstance(Context applicationContext){
        if(m_sLocationMgrInstance == null){
            m_sLocationMgrInstance = new LocationMgr(applicationContext);
        }
        return m_sLocationMgrInstance;
    }

}
