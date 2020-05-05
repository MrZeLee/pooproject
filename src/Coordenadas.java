import java.util.Objects;

public class Coordenadas {
    private double latitude;
    private double longitude;


    public Coordenadas() {
    }

    public Coordenadas(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Coordenadas(Coordenadas x) {
        this.latitude = x.getLatitude();
        this.longitude = x.getLongitude();
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Coordenadas latitude(double latitude) {
        this.latitude = latitude;
        return this.clone();
    }

    public Coordenadas longitude(double longitude) {
        this.longitude = longitude;
        return this.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Coordenadas)) {
            return false;
        }
        Coordenadas coordenadas = (Coordenadas) o;
        return latitude == coordenadas.latitude && longitude == coordenadas.longitude;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }

    @Override
    public String toString() {
        return "{" +
            " latitude='" + getLatitude() + "'" +
            ", longitude='" + getLongitude() + "'" +
            "}";
    }

    public Coordenadas clone(){
        return new Coordenadas(this);
    }
}