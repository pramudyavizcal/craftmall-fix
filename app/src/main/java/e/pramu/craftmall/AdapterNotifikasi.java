package e.pramu.craftmall;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class AdapterNotifikasi extends RecyclerView.Adapter <AdapterNotifikasi.CustomViewHolder> {
    private List<ModelNotifikasi> cartM;
    private LayoutInflater _mInflater;
    private Context _context;

    public AdapterNotifikasi (Context context, List<ModelNotifikasi> cm){
        this._context = context;
        cartM = cm;
        _mInflater = (LayoutInflater) context.getSystemService((Context.LAYOUT_INFLATER_SERVICE));
    }

    @Override
    public AdapterNotifikasi.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.notifikasiitem, viewGroup, false);
        AdapterNotifikasi.CustomViewHolder vh = new AdapterNotifikasi.CustomViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AdapterNotifikasi.CustomViewHolder holder,final int position) {
        final String totalHarga = cartM.get(position).getNotif();
        final String header = cartM.get(position).getJudul();
        holder.tvTotalHarga.setText(totalHarga);
        holder.tvNamaBarang.setText(header);
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_context,PaymentActivity.class);
                intent.putExtra("Header",cartM.get(position).getJudul());
                _context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartM.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private ImageView _imageView;
        private TextView tvNamaBarang, tvTotalHarga;
        private CardView cv;

        public CustomViewHolder(View itemView) {
            super(itemView);
//            _imageView = (ImageView) itemView.findViewById(R.id.iFotoNot);
            tvNamaBarang = (TextView) itemView.findViewById(R.id.Header);
            tvTotalHarga = (TextView) itemView.findViewById(R.id.PesanNot);
            cv = (CardView) itemView.findViewById(R.id.cvNotif);

        }

    }

}
