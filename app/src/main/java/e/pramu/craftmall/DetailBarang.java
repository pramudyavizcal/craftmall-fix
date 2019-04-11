package e.pramu.craftmall;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailBarang extends AppCompatActivity {
    private TextView name,desk,hargadetail,deskdetail,alamatdetail,iAlamat;
    private ImageView img,loc;
    private Button btnCart;
    ProgressDialog pg;
    DatabaseReference dbwish;
    private ImageButton btnWish,btnwhite,btnred,home,cart,profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailbarang);
        name = (TextView) findViewById(R.id.namabarangdetail);
        hargadetail = (TextView) findViewById(R.id.hargadetail);
        deskdetail = (TextView) findViewById(R.id.deskripsidetail);
//        alamatdetail = (TextView) findViewById(R.id.alamatdetail);
//        iAlamat = (TextView) findViewById(R.id.iAlamat);
//        loc = (ImageView) findViewById(R.id.iLok);
        img = (ImageView) findViewById(R.id.gambarbarangdetail);
//        btnWish = (ImageButton) findViewById(R.id.wishlistdetail);
        desk = (TextView) findViewById(R.id.tvDesk);
        home = (ImageButton) findViewById(R.id.imageButton);
        cart = (ImageButton) findViewById(R.id.imageButton2);
        profile = (ImageButton) findViewById(R.id.imageButton3);
        dbwish = FirebaseDatabase.getInstance().getReference("getdbwish");
        Intent intent = getIntent();
        final String nama = intent.getExtras().getString("Nama");
        final String Harga = intent.getExtras().getString("Harga");
        final int Logo = intent.getExtras().getInt("Logo");
        final String deskrip = intent.getExtras().getString("Desk");

        img.setImageResource(Logo);
        name.setText(nama);
        hargadetail.setText(Harga);
        desk.setText(deskrip);
        btnwhite = (ImageButton) findViewById(R.id.whitelove);
        btnwhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnwhite.isClickable()==true){
                    btnwhite.setVisibility(View.INVISIBLE);
                    String id = dbwish.push().getKey();
                    modelBarang mb = new modelBarang(id,Logo,nama,Harga,deskrip);
                    dbwish.child(id).setValue(mb);
                    btnred.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Ditambahkan ke wishlist",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnred = (ImageButton) findViewById(R.id.redlove);
        btnred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnred.isClickable() == true){
                    btnred.setVisibility(View.INVISIBLE);
                    btnwhite.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"Dihapus dari wishlist",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnCart = (Button) findViewById(R.id.cartBtn);
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailBarang.this,CartActivity.class));
                pg = new ProgressDialog(DetailBarang.this);
                pg.setMessage("Loading...");
                pg.setTitle("Harap Tunggu");
                pg.setProgressStyle(pg.STYLE_SPINNER);
                pg.show();
                pg.setCancelable(false);
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        pg.dismiss();
                    }
                }).start();
            }
        });
        buttonHCP();

    }
    private void buttonHCP() {

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailBarang.this, CartActivity.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailBarang.this, ProfileActivity.class));
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailBarang.this, homeActivity.class));
            }
        });
    }
}
