import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

public class GPSTracker extends Service implements LocationListener {
    private final Context mContext;
    boolean isGPSEnabled = false;
    boolean isNetworkEnabled = false;
    boolean canGetLocation = false;
    Location location;
    double latitude;
    double longitude;

    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1;
    protected LocationManager locationManager;

     public GPSTracker (Context mContext) {
         this.mContext = mContext;
         getLocation();
     }

     public Location getLocation() {
         try{
             if (Build.VERSION.SDK_INT >= 23 &&
                     ContextCompat.checkSelfPermission( context,
                             Manifest.permission.ACCESS_FINE_LOCATION)
                 != PackageManager.PERMISSION_GRANTED &&
                     ContextCompat.checkSelfPermission( context)
         }
     }


}
