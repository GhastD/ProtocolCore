package cc.ghast.protocolcore.api;

import com.comphenix.protocol.events.PacketContainer;
import org.bukkit.entity.Player;

/**
 * @author Ghast
 * @since 31-Mar-20
 */
public abstract class WrappedPacket {
    public PacketContainer container;
    public Player player;

    public WrappedPacket(PacketContainer container, Player player) {
        this.container = container;
        this.player = player;
        construct();
    }

    public abstract void construct();

}
