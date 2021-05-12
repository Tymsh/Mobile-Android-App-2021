package umn.ac.id.week13_31135;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class TambahObject extends FragmentActivity
        implements OnMapReadyCallback {
    private int pilihan = 0;
    // 0 = Marker; 1 = Circle; 2 = Polyline; 3 = Polygon
    private GoogleMap mMap;
    private Button btnSimpan;
    private EditText etRadius;
    private EditText etKeterangan;
    private RadioGroup rgShape;
    private List<LatLng> titiks;
    private UiSettings mUiSettings;
    private static MarkerDanShape objMS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_object);
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.tambahmap);
        mapFragment.getMapAsync(this);
        btnSimpan = findViewById(R.id.simpan);
        etRadius = findViewById(R.id.etRadius);
        etKeterangan = findViewById(R.id.etKeterangan);
        rgShape = findViewById(R.id.rgShape);
        titiks = new ArrayList<LatLng>();
        rgShape.setOnCheckedChangeListener(new RadioGroup.
                OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                titiks.clear();
                btnSimpan.setEnabled(false);
                if(mMap != null) {
                    mMap.clear();
                }
                switch(checkedId){
                    case R.id.marker:
                        pilihan = 0;
                        etRadius.setEnabled(false);
                        break;
                        