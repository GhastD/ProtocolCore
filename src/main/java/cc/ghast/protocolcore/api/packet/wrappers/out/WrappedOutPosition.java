package cc.ghast.protocolcore.api.packet.wrappers.out;

import cc.ghast.protocolcore.api.WrappedPacket;
import com.comphenix.protocol.events.PacketContainer;
import lombok.Getter;
import org.bukkit.entity.Player;

/**
 * @author Ghast
 * @since 01-Apr-20
 */

@Getter
public class WrappedOutPosition extends WrappedPacket {
    public WrappedOutPosition(PacketContainer container, Player player) {
        super(container, player);
    }


    private double x, y, z;
    private float yaw, pitch;

    @Override
    public void construct() {
        x = container.getDoubles().readSafely(0);
        y = container.getDoubles().readSafely(1);
        z = container.getDoubles().readSafely(2);

        yaw = container.getFloat().readSafely(0);
        pitch = container.getFloat().readSafely(1);
    }
}
