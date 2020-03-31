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
public class WrappedInCustomPayload extends WrappedPacket {
    public WrappedInCustomPayload(PacketContainer container, Player player) {
        super(container, player);
    }

    private String message;

    @Override
    public void construct() {
        message = container.getStrings().read(0);
    }
}
