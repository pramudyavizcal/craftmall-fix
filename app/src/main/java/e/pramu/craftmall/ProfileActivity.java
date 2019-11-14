package e.pramu.craftmall;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {
    AlertDialog.Builder dialog;
    TextView tvnama, tvalamat, tvnohp, tvemail;
    EditText txt_nama, txt_alamat, txt_email, txt_nohp;
    private Button edtprofil, btnlogout;
    ImageButton cart, home;
    LayoutInflater inflater;
    View dialogView;
    String nama, alamat, nohp, email;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        edtprofil = (Button) findViewById(R.id.editprofil);
        btnlogout = (Button) findViewById(R.id.logout);
        tvnama = (TextView) findViewById(R.id.hasilnama);
        tvalamat = (TextView) findViewById(R.id.hasilalamat);
        tvnohp = (TextView) findViewById(R.id.hasilnohp);
        tvemail = (TextView) findViewById(R.id.hasilemail);
        home = (ImageButton) findViewById(R.id.imageButton);
        cart = (ImageButton) findViewById(R.id.imageButton2);

//        FirebaseUser user = auth.getCurrentUser();

        tvnama.setText("");
        tvalamat.setText("");
        tvnohp.setText("");
        tvemail.setText("");
        edtprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogForm();
            }
        });

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.getInstance().signOut();
                startActivity(new Intent(ProfileActivity.this, RegisterActivity.class));
                finish();
            }
        });
        buttonHCP();
    }

    // untuk mengosongi edittext
    private void kosong() {
        txt_nama.setText(tvnama.getText());
        txt_alamat.setText(tvalamat.getText());
        txt_nohp.setText(tvnohp.getText());
        txt_email.setText(tvemail.getText());
    }

    private void DialogForm() {
        dialog = new AlertDialog.Builder(ProfileActivity.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.editprofilactivity, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("Edit Profil");

        txt_nama = (EditText) dialogView.findViewById(R.id.txt_nama);
        txt_alamat = (EditText) dialogView.findViewById(R.id.txt_usia);
        txt_nohp = (EditText) dialogView.findViewById(R.id.txt_alamat);
        txt_email = (EditText) dialogView.findViewById(R.id.txt_status);

        kosong();

        dialog.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                nama = txt_nama.getText().toString();
                alamat = txt_alamat.getText().toString();
                nohp = txt_nohp.getText().toString();
                email = txt_email.getText().toString();

                tvnama.setText(nama);
                tvalamat.setText(alamat);
                tvnohp.setText(nohp);
                tvemail.setText(email);
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

    private void buttonHCP() {

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, CartActivity.class));
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, homeActivity.class));
            }
        });

    }
}
