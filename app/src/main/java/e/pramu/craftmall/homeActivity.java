package e.pramu.craftmall;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class homeActivity extends AppCompatActivity implements OnMapReadyCallback{
private FragmentActivity fa;
private GoogleMap nMap;
private TextView Hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Toolbar toolbar = findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);
        Hasil = findViewById(R.id.textView);
        fa = new FragmentActivity();
        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        nMap = googleMap;
        LatLng malang = new LatLng(-7.95,112.61);
        LatLng toko1 = new LatLng(-7.94,112.61);
        nMap.addMarker(new MarkerOptions().position(malang).title("Marker in Malang"));
        nMap.addMarker(new MarkerOptions().position(toko1).title("Toko ke 1"));
        nMap.moveCamera(CameraUpdateFactory.newLatLng(malang));
        nMap.moveCamera(CameraUpdateFactory.newLatLng(toko1));
        nMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        nMap.animateCamera(CameraUpdateFactory.newLatLngZoom(malang, 15.0f),5000,null);
    }
    //Code Program pada Method dibawah ini akan Berjalan saat Option Menu Dibuat

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Memanggil/Memasang menu item pada toolbar dari layout menu_bar.xml
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem searchIem = menu.findItem(R.id.search);
        final SearchView searchView = (SearchView) searchIem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onQueryTextSubmit(String query) {
                Hasil.setText("Hasil Pencarian: "+query);

                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }

    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are You Sure Want to Exit?")
                .setCancelable(true)//tidak bisa tekan tombol back
                //jika pilih yess
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                //jika pilih no
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }
}
