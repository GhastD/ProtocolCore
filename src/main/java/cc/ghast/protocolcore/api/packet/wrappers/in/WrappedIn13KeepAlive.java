package cc.ghast.protocolcore.api.packet.wrappers.in;

import cc.ghast.protocolcore.api.WrappedPacket;
import com.comphenix.protocol.events.PacketContainer;
import lombok.Getter;
import org.bukkit.entity.Player;

/**
 * @author Ghast
 * @since 01-Apr-20
 */

@Getter
public class WrappedIn13KeepAlive extends WrappedPacket {
    public WrappedIn13KeepAlive(PacketContainer container, Player player) {
        super(container, player);
    }

    private long ping;

    @Override
    public void construct() {
        ping = container.getLongs().readSafely(0);
    }
}
