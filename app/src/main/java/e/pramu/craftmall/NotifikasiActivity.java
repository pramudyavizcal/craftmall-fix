package e.pramu.craftmall;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NotifikasiActivity extends AppCompatActivity {
    TextView TV;
    private List<ModelNotifikasi> NA;
    RecyclerView rView;
    CardView cardView;
    ImageButton cart, profile, home;;
    AdapterNotifikasi an;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifikasi);
        rView = findViewById(R.id.rvNot);
        TV = findViewById(R.id.textViewNotifikasi);
        home = (ImageButton) findViewById(R.id.imageButton);
        cart = (ImageButton) findViewById(R.id.imageButton2);
        profile = (ImageButton) findViewById(R.id.imageButton3);
        cardView = (CardView) findViewById(R.id.cvNotif);
        NA = new ArrayList<>();
        NA.add(new ModelNotifikasi("Segera Selesaikan Pembayaran Vas Bunga (Rp. 25000)", "CraftMall Official"));
        an = new AdapterNotifikasi(this, NA);
        rView.setLayoutManager(new LinearLayoutManager(this));
        rView.setAdapter(an);
        buttonHCP();
    }

    private void buttonHCP() {

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NotifikasiActivity.this, CartActivity.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NotifikasiActivity.this, ProfileActivity.class));
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NotifikasiActivity.this, homeActivity.class));
            }
        });

    }
}
