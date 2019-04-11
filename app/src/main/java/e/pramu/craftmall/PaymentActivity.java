package e.pramu.craftmall;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PaymentActivity extends AppCompatActivity{
private TextView tvpetunjuk;
private Button btnPayment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);
        tvpetunjuk = (TextView) findViewById(R.id.petunjukpembayaran);
        btnPayment = (Button) findViewById(R.id.buttonPayment);
        tvpetunjuk.setText("1. Pilih Menu Lain > Transfer\n" +
                "2. Pilih rekening tujuan\n" +
                "3. Masukkan No Rekening tujuan dan Pilih benar\n" +
                "4. Masukkan jumlah pembayaran dan Pilih benar\n" +
                "5. Pastikan data dilayar menampilkan nama penerima CRAFTMALL dan jumlah sudah benar\n" +
                "6. Pilih benar");

        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PaymentActivity.this,homeActivity.class));
            }
        });
    }
}
