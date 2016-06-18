package github.nikhilbhutani.cameraanimationonmap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    protected GoogleMap googleMap;
    protected boolean mapReady = false;
    protected Button btnNewDelhi, btnMumbai, btnChennai;



    static final CameraPosition NEWDELHI = CameraPosition.builder()
            .target(new LatLng(28.6139,77.2090))
            .zoom(14)
            .bearing(0)
            .tilt(45)
            .build();

    static final CameraPosition MUMBAI = CameraPosition.builder()
            .target(new LatLng(19.0760,72.8777))
            .zoom(14)
            .bearing(0)
            .tilt(45)
            .build();

    static final CameraPosition CHENNAI = CameraPosition.builder()
            .target(new LatLng(13.0827,80.2707))
            .zoom(14)
            .bearing(90)
            .tilt(45)
            .build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNewDelhi = (Button)findViewById(R.id.buttonNewDelhi);
        btnNewDelhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  if(mapReady)
                  {
                      flyHere(NEWDELHI);
                  }
            }
        });

        btnMumbai = (Button)findViewById(R.id.buttonMumbai);
        btnMumbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flyHere(MUMBAI);
            }
        });

        btnChennai = (Button)findViewById(R.id.buttonChennai);
        btnChennai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flyHere(CHENNAI);
            }
        });

        MapFragment mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mapReady = true;
        this.googleMap = googleMap;

        this.googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        flyHere(NEWDELHI);
    }

    private void flyHere(CameraPosition flyhere) {

        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(flyhere),4000,null);

    }
}
