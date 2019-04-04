package e.pramu.craftmall;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AdapterWhistlist extends RecyclerView.Adapter<AdapterWhistlist.MyViewHolder> {

    private Context context;
    private List<HolderWhistlist> HW;

    public AdapterWhistlist(Context ctx,List<HolderWhistlist> hw) {

        context = ctx;
        HW = hw;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        LayoutInflater mInflater = LayoutInflater.from(context);
        v = mInflater.inflate(R.layout.grid_whistlist,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv.setText(HW.get(position).getName());
        holder.iv.setImageResource(HW.get(position).getLogo());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailBarang.class);
                intent.putExtra("Name",HW.get(position).getName());
                intent.putExtra("Logo",HW.get(position).getLogo());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return HW.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
TextView tv;
ImageView iv;
CardView cv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tvCompany);
            iv = (ImageView) itemView.findViewById(R.id.ivLogo);
            cv = (CardView) itemView.findViewById(R.id.cardview_id);

        }
    }
}
