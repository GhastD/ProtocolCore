package cc.ghast.protocolcore.api.packet.wrappers.in;

import cc.ghast.protocolcore.api.WrappedPacket;
import com.comphenix.protocol.events.PacketContainer;
import org.bukkit.entity.Player;

/**
 * @author Ghast
 * @since 31-Mar-20
 */
public class WrappedInArmAnimation extends WrappedPacket {
    public WrappedInArmAnimation(PacketContainer container, Player player) {
        super(container, player);
    }

    @Override
    public void construct() {
        // Literally nothing
    }
}
