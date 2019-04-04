package e.pramu.craftmall;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WhistlistActivity  extends AppCompatActivity {
    RecyclerView rvMain;
    List<HolderWhistlist> listWhist;
    AdapterWhistlist AW;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whistlist);
        listWhist = new ArrayList<>();
        listWhist.add(new HolderWhistlist(R.drawable.whistlist,"BLABLA"));
        listWhist.add(new HolderWhistlist(R.drawable.whistlist,"BLABLA"));
        listWhist.add(new HolderWhistlist(R.drawable.whistlist,"BLABLA"));
        listWhist.add(new HolderWhistlist(R.drawable.whistlist,"BLABLA"));
        rvMain = (RecyclerView) findViewById(R.id.rvMain);
        AW = new AdapterWhistlist(this,listWhist);
        rvMain.setLayoutManager(new GridLayoutManager(WhistlistActivity.this, 2));
        rvMain.setAdapter(AW);
    }
}
