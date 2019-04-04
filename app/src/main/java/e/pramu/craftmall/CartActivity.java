package e.pramu.craftmall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class CartActivity extends AppCompatActivity{
    private RecyclerView mRecyclerView;
    private AdapterCart mAdapter;
    private Toolbar toolbar;
    private ImageButton ibHome, ibCart, ibProfile;
    private TextView tvTotalHarga;
    private Button btnCheckOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);
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
    }
}
