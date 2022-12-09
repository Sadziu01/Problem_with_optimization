package pl.edu.pwr.bsadowski.model;

public class Jug {
    private final int id;
    private final int tasteId;
    private int volume;

    public int getId() {
        return id;
    }

    public int getTasteId() {
        return tasteId;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Jug(int id, int tasteId, int volume) {
        this.id = id;
        this.tasteId = tasteId;
        this.volume = volume;
    }

}
