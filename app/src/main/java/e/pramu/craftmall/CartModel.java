package e.pramu.craftmall;

public class CartModel {
    private  String id;
    private int fotoBarang;
    private String namaBarang;
    private String harga;
    private String kuantitas;
    private String totalHarga;

    public CartModel(){

    }
    public CartModel(int foto, String nama, String hrg, String kuan){
        fotoBarang = foto;
        namaBarang = nama;
        harga = hrg;
        kuantitas = kuan;
    }

    public CartModel(int foto, String nama, String hrg, String kuant, String tothg){
        fotoBarang = foto;
        namaBarang = nama;
        harga = hrg;
        kuantitas = kuant;
        totalHarga = tothg;
    }

    public CartModel(String _id, int foto, String nama, String hrg, String kuant, String tothg){
        id = _id;
        fotoBarang = foto;
        namaBarang = nama;
        harga = hrg;
        kuantitas = kuant;
        totalHarga = tothg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFotoBarang() {
        return fotoBarang;
    }

    public void setFotoBarang(int fotoBarang) {
        this.fotoBarang = fotoBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(String kuantitas) {
        this.kuantitas = kuantitas;
    }

    public String getTotalHarga() {
        totalHarga = String.valueOf(Integer.valueOf(harga) * Integer.valueOf(kuantitas));
        return totalHarga;
    }

    public void setTotalHarga(String totalHarga) {
        this.totalHarga = totalHarga;
    }
}
