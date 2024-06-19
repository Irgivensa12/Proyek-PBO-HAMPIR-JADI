package AppsDaurUlang;

public class Kertas extends BarangBekas implements KondisiKertas { // Gita

    private int lembar;
    private double harga;
    public double HARGA_FINAL = 5000;
    private boolean jamur, robek, kotor;

    public boolean isJamur() {
        return jamur;
    }

    public void setJamur(boolean jamur) {
        this.jamur = jamur;
    }

    public boolean isRobek() {
        return robek;
    }

    public void setRobek(boolean robek) {
        this.robek = robek;
    }

    public boolean isKotor() {
        return kotor;
    }

    public void setKotor(boolean kotor) {
        this.kotor = kotor;
    }

    public Kertas(Owner id_Pemilik, double admin, int lembar, double harga, boolean Jamur, boolean robek, boolean kotor) {
        super(id_Pemilik, admin, harga);
        this.harga = harga;
        this.lembar = lembar;
        this.jamur = jamur;
        this.robek = robek;
        this.kotor = kotor;
    }

    public int getLembar() {
        return lembar;
    }

    public void setLembar(int lembar) {
        this.lembar = lembar;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

//    public void tampilInfo() {
//        System.out.println("Admin : " + admin);
//        System.out.println("Saldo : " + saldo);
//    }
    @Override
    public void tampilInfo() {
        super.tampilInfo();
        System.out.println("Jenis Barang: Kertas");
        System.out.println("Jumlah Lembar: " + lembar);
        System.out.println("Kondisi: Jamur = " + jamur + ", Robek = " + robek + ", Kotor = " + kotor);
        System.out.println("Harga: " + getHarga());
    }

    @Override
    public boolean isBusuk() {
        if (jamur) {
            return true;
        }
        if (robek) {
            return true;
        }
        if (kotor) {
            return true;
        }
        return false; // penyederhanaan if, tanpa else
    }

}
