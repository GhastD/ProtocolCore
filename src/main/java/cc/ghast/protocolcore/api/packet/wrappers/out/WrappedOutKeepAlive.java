package cc.ghast.protocolcore.api.packet.wrappers.out;

import cc.ghast.protocolcore.api.packet.wrappers.api.WrappedPacket;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.utility.MinecraftVersion;
import lombok.Getter;
import org.bukkit.entity.Player;

/**
 * @author Ghast
 * @since 01-Apr-20
 */

@Getter
public class WrappedOutKeepAlive extends WrappedPacket {
    public WrappedOutKeepAlive(PacketContainer container, Player player) {
        super(container, player);
    }

    private long time;

    @Override
    public void construct() {
        if (MinecraftVersion.getCurrentVersion().isAtLeast(MinecraftVersion.COLOR_UPDATE)){
            time = container.getLongs().readSafely(0);
        } else {
            time = container.getIntegers().readSafely(0);
        }
    }
}
