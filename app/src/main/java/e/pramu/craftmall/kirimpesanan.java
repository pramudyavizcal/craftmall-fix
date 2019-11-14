package e.pramu.craftmall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class kirimpesanan extends AppCompatActivity {
    Button button;
    EditText Edtnama,
            EdtBarangpesanan,
            EdtKetPenjual;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirimpesanan);
        Edtnama=findViewById(R.id.txt_namaPemesan);
        EdtBarangpesanan=findViewById(R.id.txt_namaPesanan);
        EdtKetPenjual=findViewById(R.id.txt_ketPenjual);
        button=findViewById(R.id.btnPesan);

        button.setOnClickListener(new View.OnClickListener() {
                                      @Override public void onClick(View v) {
                                          String pesan1=Edtnama.getText().toString();
                                          String pesan2=EdtBarangpesanan.getText().toString();
                                          String pesan3=EdtKetPenjual.getText().toString();
                                          String semuapesan="Nama: "+ pesan1 + "\n"+ "Mau pesan : "+ pesan2 + "\n"+ "Keterangan : "+ pesan3;
                                          Intent kirimWA=new Intent(Intent.ACTION_SEND);
                                          kirimWA.setType("text/plain");
                                          kirimWA.putExtra(Intent.EXTRA_TEXT, semuapesan);
                                          kirimWA.putExtra("jid", "6281230290765"+ "@s.whatsapp.net");
                                          kirimWA.setPackage("com.whatsapp");
                                          startActivity(kirimWA);
                                      }
                                  }

        );
    }
}

