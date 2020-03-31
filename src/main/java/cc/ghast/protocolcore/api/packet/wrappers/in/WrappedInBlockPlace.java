package cc.ghast.protocolcore.api.packet.wrappers.in;

import cc.ghast.protocolcore.api.WrappedPacket;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.EnumWrappers;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * @author Ghast
 * @since 31-Mar-20
 */

@Getter
public class WrappedInBlockPlace extends WrappedPacket {
    public WrappedInBlockPlace(PacketContainer container, Player player) {
        super(container, player);
    }

    private EnumWrappers.Direction face;
    private ItemStack itemStack;
    private BlockPosition blockPosition;

    @Override
    public void construct() {
        face = container.getDirections().readSafely(0);
        itemStack = container.getItemModifier().readSafely(0);
        blockPosition = container.getBlockPositionModifier().readSafely(0);
    }
}
