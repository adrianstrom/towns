package plugin.extensions;

import java.util.UUID;

public class Location {
    public UUID id;
    public double x;
    public double y;
    public double z;
    public float pitch;
    public float yaw;

    public Location(UUID id, double x, double y, double z, float yaw, float pitch) {
        this.id = id;
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
