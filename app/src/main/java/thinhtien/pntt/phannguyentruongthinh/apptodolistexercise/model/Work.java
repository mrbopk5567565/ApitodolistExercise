package thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.model;

public class Work {
    private String congViec;
    private String thoiGian;

    public Work() {
    }

    public Work(String congViec, String thoiGian) {
        this.congViec = congViec;
        this.thoiGian = thoiGian;
    }

    public String getCongViec() {
        return congViec;
    }

    public Work setCongViec(String congViec) {
        this.congViec = congViec;
        return this;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public Work setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
        return this;
    }
}
