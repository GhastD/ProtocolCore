package cc.ghast.protocolcore.api.packet.wrappers.in;

import cc.ghast.protocolcore.api.WrappedPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import lombok.Getter;
import org.bukkit.entity.Player;

/**
 * @author Ghast
 * @since 31-Mar-20
 */

@Getter
public class WrappedInFlying extends WrappedPacket {
    public WrappedInFlying(PacketContainer container, Player player) {
        super(container, player);
    }

    private double x, y, z;
    private float yaw, pitch;
    private boolean look, pos, ground;

    @Override
    public void construct(){
        look = (container.getType().equals(PacketType.Play.Client.LOOK)
                || container.getType().equals(PacketType.Play.Client.POSITION_LOOK));
        pos = (container.getType().equals(PacketType.Play.Client.POSITION)
                || container.getType().equals(PacketType.Play.Client.POSITION_LOOK));

        if (look){
            yaw = container.getFloat().readSafely(0);
            pitch = container.getFloat().readSafely(1);
        }

        if (pos){
            x = container.getDoubles().readSafely(0);
            y = container.getDoubles().readSafely(1);
            z = container.getDoubles().readSafely(2);
        }

        ground = container.getBooleans().readSafely(0);

    }
}
