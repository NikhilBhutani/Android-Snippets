package github.nikhilbhutani.mapmarkers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    GoogleMap mGoogleMap;
    boolean mapReady = false;

    MarkerOptions  dwarka, rohini, cp, lajpatnagar;

    static final CameraPosition NEWDELHI = CameraPosition.builder()
                                            .target(new LatLng(28.6139,77.2090))
                                            .zoom(14)
                                            .bearing(0)
                                            .tilt(45)
                                            .build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dwarka = new MarkerOptions()
                 .position(new LatLng(28.5921,77.0460))
                 .title("Dwarka");

        rohini = new MarkerOptions()
                 .position(new LatLng(28.7495,77.0565))
                 .title("Rohini");

        cp = new MarkerOptions()
                 .position(new LatLng(28.6315, 77.2167))
                 .title("Cp");

        lajpatnagar = new MarkerOptions()
                      .position(new LatLng(28.5677,77.2433))
                      .title("Lajpat Nagar");

        MapFragment mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mapReady = true;
        mGoogleMap = googleMap;
        mGoogleMap.addMarker(dwarka);
        mGoogleMap.addMarker(rohini);
        mGoogleMap.addMarker(cp);
        mGoogleMap.addMarker(lajpatnagar);

        flyHere(NEWDELHI);
    }


    private void flyHere(CameraPosition flyhere) {

        mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(flyhere),4000,null);

    }
}
