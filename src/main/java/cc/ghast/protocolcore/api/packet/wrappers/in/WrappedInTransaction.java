package cc.ghast.protocolcore.api.packet.wrappers.in;

import cc.ghast.protocolcore.api.packet.wrappers.api.WrappedPacket;
import com.comphenix.protocol.events.PacketContainer;
import lombok.Getter;
import org.bukkit.entity.Player;

/**
 * @author Ghast
 * @since 31-Mar-20
 */

@Getter
public class WrappedInTransaction extends WrappedPacket {
    public WrappedInTransaction(PacketContainer container, Player player) {
        super(container, player);
    }

    private int id;
    private Short action;
    private boolean accepted;

    @Override
    public void construct() {
        id = container.getIntegers().readSafely(0);
        action = container.getShorts().readSafely(0);
        accepted = container.getBooleans().readSafely(0);
    }
}
