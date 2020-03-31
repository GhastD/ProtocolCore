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
public class WrappedOut13KeepAlive extends WrappedPacket {
    public WrappedOut13KeepAlive(PacketContainer container, Player player) {
        super(container, player);
    }

    private long ping;

    @Override
    public void construct() {
        ping = container.getLongs().readSafely(0);
    }
}
