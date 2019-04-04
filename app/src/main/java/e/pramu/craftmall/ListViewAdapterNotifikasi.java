package e.pramu.craftmall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListViewAdapterNotifikasi extends ArrayAdapter<ModelNotifikasi> {

    private ArrayList<ModelNotifikasi> notif;
    private Context context;

    public ListViewAdapterNotifikasi(ArrayList<ModelNotifikasi> notif, Context context) {
        super(context, R.layout.list_item_notifikasi, notif);
        this.notif = notif;
        this.context = context;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.list_item_notifikasi, null, true);


        TextView TV = listViewItem.findViewById(R.id.textViewNotifikasi);
        ModelNotifikasi NA = notif.get(position);
        TV.setText(NA.getNotif());


        return listViewItem;
    }

}
