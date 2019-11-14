package e.pramu.craftmall;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.load.resource.bitmap.BitmapDrawableResource;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class homeActivity extends AppCompatActivity implements OnMapReadyCallback{
private FragmentActivity fa;
private RecyclerView recyclerView;
private GoogleMap nMap;
private TextView Hasil;
    List<modelBarang> listWhist;
    adapterBarang AW;
ImageButton cart,profile,rekombarang,home;
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
        home = (ImageButton) findViewById(R.id.imageButton);
        cart = (ImageButton) findViewById(R.id.imageButton2);
        profile = (ImageButton) findViewById(R.id.imageButton3);
        recyclerView = (RecyclerView) findViewById(R.id.rvHome);
        listWhist = new ArrayList<>();
        listWhist.add(new modelBarang(R.drawable.hellokitty,"Hiasan Hello Kitty","Rp5000",
                "Hiasan Meja, Lemari berbentuk hello kitty cocok untuk meja belajar anak atau hiasan dalam lemari kaca\n"+
                "Rp 5.000/pcs\n"+
                "\n"+
        "Detail Barang\n"+
        "Tinggi: 10 - 15cm\n"+
        "Bahan: Tanah liat\n\n"+
        "Warna: Merah, kuning, \n\n"+
        "Berat : 150gr" ));
        listWhist.add(new modelBarang(R.drawable.meja,"Meja Tamu","1555000","Bagus\nKokoh\nCocok untuk rumah yang minimalis"));
        listWhist.add(new modelBarang(R.drawable.kursi,"Kursi Kayu Jati","2000000","Kuat\nDari Jati asli\nTidak mudah lapuk"));
        listWhist.add(new modelBarang(R.drawable.guci,"Guci Antik","44000","Telah berumur ratusan tahun\n" +
                "Stock terbatas"));
        AW = new adapterBarang(this,listWhist);
        recyclerView.setLayoutManager(new GridLayoutManager(homeActivity.this, 2));
        recyclerView.setAdapter(AW);
        buttonHCP();
    }

    private void buttonHCP(){

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeActivity.this,CartActivity.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeActivity.this,ProfileActivity.class));
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        nMap = googleMap;
        LatLng toko1 = new LatLng(-7.955187,112.589633);
        LatLng toko2 = new LatLng(-7.961253,112.613599);
        LatLng toko3 = new LatLng(-7.955014,112.621000);
        LatLng toko4 = new LatLng(-7.926718,112.602201);
        LatLng toko5 = new LatLng(-7.984516,112.627129);
        LatLng toko6 = new LatLng(-7.938956,112.634282);
        LatLng toko7 = new LatLng(-7.980795,112.657443);
        LatLng toko8= new LatLng(-7.9612392,112.6008655);
        LatLng toko9 = new LatLng(-7.908566,112.619576);
        LatLng toko10 = new LatLng(-7.949505,112.644082);
        nMap.addMarker(new MarkerOptions().position(toko1).title("Giri Palma Mebel"));
        nMap.addMarker(new MarkerOptions().position(toko2).title("Mebel 54 Malang"));
        nMap.addMarker(new MarkerOptions().position(toko3).title("Informa Furnishing").icon(BitmapDescriptorFactory.fromResource(R.drawable.location)));
        nMap.addMarker(new MarkerOptions().position(toko4).title("Toko Berkat Jaya"));
        nMap.addMarker(new MarkerOptions().position(toko5).title("Meubel Jakarta"));
        nMap.addMarker(new MarkerOptions().position(toko6).title("Toko Dunia Mebel"));
        nMap.addMarker(new MarkerOptions().position(toko7).title("Mebel Arjuna"));
        nMap.addMarker(new MarkerOptions().position(toko8).title("Mebel Mas Agung"));
        nMap.addMarker(new MarkerOptions().position(toko9).title("Olympic Furniture"));
        nMap.addMarker(new MarkerOptions().position(toko10).title("Simpel Meja Belajar Anak"));
        nMap.moveCamera(CameraUpdateFactory.newLatLng(toko1));
        nMap.moveCamera(CameraUpdateFactory.newLatLng(toko2));
        nMap.moveCamera(CameraUpdateFactory.newLatLng(toko3));
        nMap.moveCamera(CameraUpdateFactory.newLatLng(toko4));
        nMap.moveCamera(CameraUpdateFactory.newLatLng(toko5));
        nMap.moveCamera(CameraUpdateFactory.newLatLng(toko6));
        nMap.moveCamera(CameraUpdateFactory.newLatLng(toko7));
        nMap.moveCamera(CameraUpdateFactory.newLatLng(toko8));
        nMap.moveCamera(CameraUpdateFactory.newLatLng(toko9));
        nMap.moveCamera(CameraUpdateFactory.newLatLng(toko10));
        nMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        nMap.animateCamera(CameraUpdateFactory.newLatLngZoom(toko3, 13.0f),5000,null);
    }
    //Code Program pada Method dibawah ini akan Berjalan saat Option Menu Dibuat



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        //Memanggil/Memasang menu item pada toolbar dari layout menu_bar.xml
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_search, menu);
//        MenuItem searchIem = menu.findItem(R.id.search);
//
//        final SearchView searchView = (SearchView) searchIem.getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @SuppressLint("SetTextI18n")
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                Hasil.setText("Hasil Pencarian: "+query);
//
//                searchView.clearFocus();
//                return true;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                return false;
//            }
//        });
//
//        final MenuItem NotifItem = menu.findItem(R.id.notifikasi);
//        NotifItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                startActivity(new Intent(homeActivity.this,NotifikasiActivity.class));
//                return true;
//            }
//        });
//
//        final MenuItem WhistlistItem = menu.findItem(R.id.whistlist);
//        WhistlistItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                startActivity(new Intent(homeActivity.this,WhistlistActivity.class));
//                return true;
//            }
//        });
//        return true;
//    }


    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are You Sure Want to Exit?")
                .setCancelable(true)//tidak bisa tekan tombol back
                //jika pilih yess
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        moveTaskToBack(true);
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
