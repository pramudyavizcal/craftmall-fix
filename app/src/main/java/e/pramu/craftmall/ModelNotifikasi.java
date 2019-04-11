package e.pramu.craftmall;

public class ModelNotifikasi {

    private String notif;
    private String judul;

    public ModelNotifikasi( String notif, String jdl) {
        this.notif = notif;
        judul = jdl;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getNotif() {
        return notif;
    }

    public void setNotif(String notif) {
        this.notif = notif;
    }
}
