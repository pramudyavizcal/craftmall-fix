package e.pramu.craftmall;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText edtEmail, edtPassword;
    private Button btnLogin;
    private FirebaseAuth auth;
    ImageView iv;
    ProgressDialog pg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initView();
        login();
    }


    private void login() {

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //menampung imputan user
                final String emailUser = edtEmail.getText().toString().trim();
                final String passwordUser = edtPassword.getText().toString().trim();

                //validasi email dan password
                // jika email kosong
                if (emailUser.isEmpty()) {
                    edtEmail.setError("Email tidak boleh kosong");
                }
                // jika email not valid
                else if (!Patterns.EMAIL_ADDRESS.matcher(emailUser).matches()) {
                    edtEmail.setError("Email tidak valid");
                }
                // jika password kosong
                else if (passwordUser.isEmpty()) {
                    edtPassword.setError("Password tidak boleh kosong");
                }
                //jika password kurang dari 6 karakter
                else if (passwordUser.length() < 6) {
                    edtPassword.setError("Password minimal terdiri dari 6 karakter");
                } else {
                    auth.signInWithEmailAndPassword(emailUser, passwordUser)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    // ketika gagal locin maka akan do something
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(LoginActivity.this,
                                                "Gagal login karena " + task.getException().getMessage()
                                                , Toast.LENGTH_LONG).show();
                                    } else {
                                        Bundle bundle = new Bundle();
                                        bundle.putString("email", emailUser);
                                        bundle.putString("pass", passwordUser);
                                        startActivity(new Intent(LoginActivity.this, homeActivity.class)
                                                .putExtra("emailpass", bundle));
                                        finish();
                                    }
                                }
                            });
                }
                pg = new ProgressDialog(LoginActivity.this);
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
    }

    private void initView() {
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        iv = findViewById(R.id.imageViewLogin);
        auth = FirebaseAuth.getInstance();

    }

}
