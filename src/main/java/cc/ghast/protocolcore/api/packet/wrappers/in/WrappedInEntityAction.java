package cc.ghast.protocolcore.api.packet.wrappers.in;

import cc.ghast.protocolcore.api.WrappedPacket;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import lombok.Getter;
import org.bukkit.entity.Player;

/**
 * @author Ghast
 * @since 31-Mar-20
 */

@Getter
public class WrappedInEntityAction extends WrappedPacket {
    public WrappedInEntityAction(PacketContainer container, Player player) {
        super(container, player);
    }

    private EnumWrappers.PlayerAction action;

    @Override
    public void construct() {
        action = container.getPlayerActions().readSafely(0);
    }
}
