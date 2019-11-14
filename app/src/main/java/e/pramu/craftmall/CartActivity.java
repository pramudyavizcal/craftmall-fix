package e.pramu.craftmall;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class CartActivity extends AppCompatActivity{
    AlertDialog.Builder dialog;
    private RecyclerView mRecyclerView;
    private AdapterCart mAdapter;
    private CheckBox cb;
    LayoutInflater inflater;
    View dialogView;
    EditText txt_nama, txt_alamat, txt_nohp;
    private Toolbar toolbar;
    private ImageButton ibHome, ibCart, ibProfile;
    ImageButton profile,home;
    private TextView tvTotalHarga,ttotb;
    private Button btnCheckOut,btncart;
    List<CartModel> lC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);
        lC = new ArrayList<>();


        initView();
        buttonHCP();
    }

    private void initView(){
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        toolbar = (Toolbar) findViewById(R.id.toolbar_cart);
        ibHome = (ImageButton) findViewById(R.id.imageButton);
        ibCart = (ImageButton) findViewById(R.id.imageButton2);
        ibProfile = (ImageButton) findViewById(R.id.imageButton3);
        tvTotalHarga = (TextView) findViewById(R.id.textVTotal);
        btnCheckOut = (Button) findViewById(R.id.buttonCheck);
        home = (ImageButton) findViewById(R.id.imageButton);
        profile = (ImageButton) findViewById(R.id.imageButton3);
        mAdapter = new AdapterCart(this,lC);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }
    private void buttonHCP(){

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this,ProfileActivity.class));
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this,homeActivity.class));
            }
        });

        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(CartActivity.this,PaymentActivity.class));

//                btnCheckOut.setText(null);
//                DialogForm();

            }
        });

    }
    private void kosong() {
        txt_nama.setText(null);
        txt_alamat.setText(null);
        txt_nohp.setText(null);
    }

    private void DialogForm() {
        dialog = new AlertDialog.Builder(CartActivity.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.editpenerimaactivity, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("Data Penerima");

        txt_nama = (EditText) dialogView.findViewById(R.id.txt_nama);
        txt_alamat = (EditText) dialogView.findViewById(R.id.txt_usia);
        txt_nohp = (EditText) dialogView.findViewById(R.id.txt_alamat);


        kosong();

        dialog.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(CartActivity.this,PaymentActivity.class));

                dialog.dismiss();
            }
        });

        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}