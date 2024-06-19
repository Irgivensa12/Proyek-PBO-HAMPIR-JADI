package AppsDaurUlang;

public class Besi extends BarangBekas { // Iis

    private double beratBesi;
    public double HARGA = 10000;
    private double harga;

    public Besi(Owner owner, double admin, double harga, double beratBesi) {
        super(owner, admin, harga);
        this.beratBesi = beratBesi;
    }

    public double getBeratBesi() {
        return beratBesi;
    }

    public void setBeratBesi(double beratBesi) {
        this.beratBesi = beratBesi;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

//    public void tampilInfo(){
//        System.out.println("Jumlah Barang : "+ getBeratBesi() + " Harga (per buah): "+ getHarga());
//    }
    @Override
    public void tampilInfo() {
        super.tampilInfo();
        System.out.println("Jenis Barang: Besi");
        System.out.println("Berat Barang: " + beratBesi);
        System.out.println("Harga: " + getHarga());
    }
}
