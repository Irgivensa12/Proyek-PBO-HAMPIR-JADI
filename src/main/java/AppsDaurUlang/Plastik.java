package AppsDaurUlang;

public class Plastik extends BarangBekas { // Ditus

    private int jumlah;
    public double HARGA_FINAL = 7000;
    private double harga;

    public Plastik(int jumlah, Owner owner, double admin, double harga) {
        super(owner, admin, harga);
        this.jumlah = jumlah;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

//    public void tampilInfo() {
//        System.out.println("Jumlah Barang : " + getJumlah() + " Harga : " + getHarga());
//    }
    @Override
    public void tampilInfo() {
        super.tampilInfo();
        System.out.println("Jenis Barang: Plastik");
        System.out.println("Jumlah Barang: " + jumlah);
        System.out.println("Harga: " + getHarga());
    }
}
