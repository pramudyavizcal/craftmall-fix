package e.pramu.craftmall;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class WhistlistActivity extends AppCompatActivity {
    RecyclerView rvMain;
    List<modelBarang> listWhist;
    AdapterWhistlist AW;
    ImageButton cart, profile, home;
    private Activity context;
    private DatabaseReference dbwish;

    @Override
    protected void onStart() {
        super.onStart();
        dbwish.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listWhist.clear();
                for (DataSnapshot wishsnap : dataSnapshot.getChildren()) {
                    modelBarang modelwish = wishsnap.getValue(modelBarang.class);
//                   modelBarang mod = new modelBarang(modelwish.getLogo(),modelwish.getNama());
                    listWhist.add(modelwish);
                }
                AW = new AdapterWhistlist(WhistlistActivity.this, listWhist);
                rvMain.setAdapter(AW);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whistlist);
        listWhist = new ArrayList<>();
//        listWhist.add(new HolderWhistlist(R.drawable.vas,"Vas Bunga"));
//        listWhist.add(new HolderWhistlist(R.drawable.meja,"Meja Tamu"));
//        listWhist.add(new HolderWhistlist(R.drawable.kursi,"Kursi Kayu Jati"));
//        listWhist.add(new HolderWhistlist(R.drawable.guci,"Guci Antik"));
        home = (ImageButton) findViewById(R.id.imageButton);
        cart = (ImageButton) findViewById(R.id.imageButton2);
        profile = (ImageButton) findViewById(R.id.imageButton3);
        rvMain = (RecyclerView) findViewById(R.id.rvMain);

        dbwish = FirebaseDatabase.getInstance().getReference("getdbwish");
        rvMain.setLayoutManager(new GridLayoutManager(WhistlistActivity.this, 2));
        rvMain.setAdapter(AW);
        buttonHCP();

    }

    private void buttonHCP() {

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WhistlistActivity.this, CartActivity.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WhistlistActivity.this, ProfileActivity.class));
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WhistlistActivity.this, homeActivity.class));
            }
        });
    }
}
