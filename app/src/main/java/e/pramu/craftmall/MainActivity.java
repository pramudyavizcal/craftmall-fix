 package e.pramu.craftmall;

 import android.content.Intent;
 import android.os.Bundle;
 import android.os.Handler;
 import android.support.v7.app.AppCompatActivity;
 import android.widget.ImageView;

 import com.bumptech.glide.Glide;


 public class MainActivity extends AppCompatActivity {

     private final int SPLASH_DISPLAY_LENGHT = 8000;
     private ImageView gif;
     @Override
     protected void onCreate(Bundle incicle){
         super.onCreate(incicle);
         setContentView(R.layout.splash);
         gif = findViewById(R.id.cobagif);
         Glide.with(this).asGif()
                 .load(R.drawable.splashfix).into(gif);

         new Handler().postDelayed(new Runnable(){
             @Override
             public void run() {
                 Intent mainIntent = null;
                 mainIntent = new Intent(MainActivity.this,RegisterActivity.class);

                 MainActivity.this.startActivity(mainIntent);
                 MainActivity.this.finish();
             }
         },SPLASH_DISPLAY_LENGHT);

     }

 }