package pl.edu.pwr.bsadowski.model;

public class TasteAndImportance {
    private int taste;
    private int importance;
    private int pId;
    private int jValue;
    private int idJug;

    public int getTaste() {
        return taste;
    }

    public int getImportance() {
        return importance;
    }

    public int getpId() {
        return pId;
    }

    public int getjValue() {
        return jValue;
    }

    public int getIdJug() {
        return idJug;
    }

    public void setjValue(int jValue) {
        this.jValue = jValue;
    }

    public void setIdJug(int idJug) {
        this.idJug = idJug;
    }

    public TasteAndImportance(int taste, int importance, int pId, int jValue, int idJug) {
        this.taste = taste;
        this.importance = importance;
        this.pId = pId;
        this.jValue = jValue;
        this.idJug = idJug;
    }
}
