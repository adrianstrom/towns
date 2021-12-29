package plugin.extensions;

public class Location {
    public double x;
    public double y;
    public double z;
    public float pitch;
    public float yaw;

    // TODO: add world
    public Location(double x, double y, double z, float yaw, float pitch) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
    }

    public Location()
    {
        
    }
}
