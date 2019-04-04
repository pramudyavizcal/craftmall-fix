package e.pramu.craftmall;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HolderWhistlist {

    private int logo;
    private String name;


    public HolderWhistlist(){

    }

    public HolderWhistlist(int logo,String name){
        this.logo = logo;
        this.name =name;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
