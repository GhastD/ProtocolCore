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
public class WrappedOutTransaction extends WrappedPacket {
    public WrappedOutTransaction(PacketContainer container, Player player) {
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
