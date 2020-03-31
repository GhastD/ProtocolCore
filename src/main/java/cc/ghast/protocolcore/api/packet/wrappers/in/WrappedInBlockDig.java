package cc.ghast.protocolcore.api.packet.wrappers.in;

import cc.ghast.protocolcore.api.packet.wrappers.api.WrappedPacket;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.EnumWrappers;
import lombok.Getter;
import org.bukkit.entity.Player;

/**
 * @author Ghast
 * @since 31-Mar-20
 */

@Getter
public class WrappedInBlockDig extends WrappedPacket {
    public WrappedInBlockDig(PacketContainer container, Player player) {
        super(container, player);
    }

    private BlockPosition blockPosition;
    private EnumWrappers.Direction direction;
    private EnumWrappers.PlayerDigType digType;

    @Override
    public void construct() {
        blockPosition = container.getBlockPositionModifier().readSafely(0);
        direction = container.getDirections().readSafely(1);
        digType = container.getPlayerDigTypes().read(2);
    }
}
