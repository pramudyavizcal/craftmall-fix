package e.pramu.craftmall;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterCart extends RecyclerView.Adapter <AdapterCart.CustomViewHolder>{
    private List<CartModel> cartM;
    private LayoutInflater _mInflater;
    private Context _context;

    public AdapterCart (Context context, List<CartModel> cm){
        this._context = context;
        cartM = cm;
        _mInflater = (LayoutInflater) context.getSystemService((Context.LAYOUT_INFLATER_SERVICE));

    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.cart_item, viewGroup, false);
        CustomViewHolder vh = new CustomViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder( CustomViewHolder holder, int position) {
        final int fotoBarang = cartM.get(position).getFotoBarang();
        final String namaBarang = cartM.get(position).getNamaBarang();
        final String harga = cartM.get(position).getHarga();
        final String kuantitas = cartM.get(position).getKuantitas();
        final String totalHarga = cartM.get(position).getTotalHarga();
        holder._imageView.setImageResource(fotoBarang);
        holder.tvNamaBarang.setText(namaBarang);
        holder.tvHargaBarang.setText(harga);
        holder.tvTotalHarga.setText(totalHarga);
        holder.kuantitas.setText(kuantitas);
    }

    @Override
    public int getItemCount() {
        return cartM.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private ImageView _imageView;
        private TextView tvNamaBarang, tvHargaBarang, tvTotalHarga;
        private ImageButton btnTambah, btnKurang, btnHapus;
        private CheckBox cekHitung;
        private EditText kuantitas;
        private CardView cv;

        public CustomViewHolder(View itemView) {
            super(itemView);
            _imageView = (ImageView) itemView.findViewById(R.id.image_view);
            tvNamaBarang = (TextView) itemView.findViewById(R.id.namaBrg);
            tvHargaBarang = (TextView) itemView.findViewById(R.id.hargaRp);
            tvTotalHarga = (TextView) itemView.findViewById(R.id.totalHrBrg);
            btnTambah = (ImageButton) itemView.findViewById(R.id.plusQnt);
            btnKurang = (ImageButton) itemView.findViewById(R.id.minQnt);
            btnHapus = (ImageButton) itemView.findViewById(R.id.btnHapus);
            cekHitung = (CheckBox) itemView.findViewById(R.id.checkBox);
            kuantitas = (EditText) itemView.findViewById(R.id.kuantitasBrg);
            cv = (CardView) itemView.findViewById(R.id.cv);
        }

    }
}
