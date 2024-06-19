package AppsDaurUlang;

public class Transaksi {

    private String tanggal;
    private int jumlahBarang;
    private double berat;
    private double hargaJual;
    private Costumer customer;
    private BarangBekas item;
    //private Owner id_Pemilik;

    public Transaksi(String tanggal, int jumlahBarang, double berat, double hargaJual, Costumer customer, BarangBekas item) {
        this.berat = berat;
        this.hargaJual = hargaJual;
        this.jumlahBarang = jumlahBarang;
        this.tanggal = tanggal;

    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public double getBerat() {
        return berat;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }

    public double getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(double hargaJual) {
        this.hargaJual = hargaJual;
    }

    public Costumer getCostumer() {
        return customer;
    }

    public void setCostumer(Costumer customer) {
        this.customer = customer;
    }

    public BarangBekas getItem() {
        return item;
    }

    public void setItem(BarangBekas item) {
        this.item = item;
    }

    public double Transaksi() {
        return totalHarga();
    }

    public double totalHarga() {
        return jumlahBarang * berat * hargaJual;
    }

}
