package e.pramu.craftmall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class CartActivity extends AppCompatActivity{
    private RecyclerView mRecyclerView;
    private AdapterCart mAdapter;
    private Toolbar toolbar;
    private ImageButton ibHome, ibCart, ibProfile;
    private TextView tvTotalHarga;
    private Button btnCheckOut;
    List<CartModel> lC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);
        lC = new ArrayList<>();
        lC.add(new CartModel(R.drawable.whistlist, "Barang satu", "200000","1"));
        lC.add(new CartModel(R.drawable.whistlist, "Barang dua", "100000","1"));
        lC.add(new CartModel(R.drawable.whistlist, "Barang tiga", "150000","1"));
        lC.add(new CartModel(R.drawable.whistlist, "Barang empat", "50000","1"));
        initView();
    }

    private void initView(){
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        toolbar = (Toolbar) findViewById(R.id.toolbar_cart);
        ibHome = (ImageButton) findViewById(R.id.imageButton);
        ibCart = (ImageButton) findViewById(R.id.imageButton2);
        ibProfile = (ImageButton) findViewById(R.id.imageButton3);
        tvTotalHarga = (TextView) findViewById(R.id.textVTotal);
        btnCheckOut = (Button) findViewById(R.id.buttonCheck);

        mAdapter = new AdapterCart(this,lC);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }
}
