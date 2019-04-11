package e.pramu.craftmall;



public class modelBarang {
    private int logo;
    private String id,nama,harga,deskripsi;

    public modelBarang(){

    }

    public modelBarang (int logo, String nama){
        this.logo = logo;
        this.nama = nama;
    }
    public modelBarang(int logo,String name,String price,String desk){
        this.logo = logo;
        nama = name;
        harga = price;
        deskripsi = desk;
    }
    public modelBarang(String id,int logo,String name,String price,String desk){
        this.logo = logo;
        nama = name;
        harga = price;
        deskripsi = desk;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getId() {
        return id;
    }

    public int getLogo() {
        return logo;
    }

    public String getHarga() {
        return harga;
    }

    public String getNama() {
        return nama;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setId(String id) {
        this.id = id;
    }
}



