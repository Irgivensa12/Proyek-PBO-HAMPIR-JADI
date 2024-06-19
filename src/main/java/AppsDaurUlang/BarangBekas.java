package AppsDaurUlang;

public class BarangBekas { // Ditus

    private Owner owner;
    protected double admin;
    protected double saldo;
    private double harga;
    private String jenis; // tambahan atribut

    public BarangBekas(Owner owner, double admin, double harga) {
        this.owner = owner;
        this.admin = admin;
        this.harga = harga;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public double getAdmin() {
        return admin;
    }

    public void setAdmin(double admin) {
        this.admin = admin;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void tampilInfo() {
        System.out.println("Pemilik : " +owner);
        System.out.println("Biaya Admin : " +admin);
        System.out.println("Saldo : " +saldo);
        System.out.println("Harga : " +harga);
        System.out.println("Jenis Barang : " +harga);
    }

}
