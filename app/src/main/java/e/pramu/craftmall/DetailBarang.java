package e.pramu.craftmall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailBarang extends AppCompatActivity {
    private TextView name,desk;
    private ImageView img;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailbarang);

        name = (TextView) findViewById(R.id.tvCompany);
        img = (ImageView) findViewById(R.id.ivLogo);
        desk = (TextView) findViewById(R.id.tvDesk);

        desk.append("\nadaasa\n" +
                "asasasa\n" +
                "asas\n" +
                "asaa\n" +
                "asaasa\n" +
                "asaaasa\n" +
                "asasaasa\n" +
                "asasasa\n" +
                "asassaas\n" +
                "asasaas\n" +
                "asasasa\n" +
                "saasaaas\n" +
                "asasasaasa\n" +
                "sasasasaa\n" +
                "adaasas\n" +
                "saasasasa\n" +
                "sasasasa");

    }
}
