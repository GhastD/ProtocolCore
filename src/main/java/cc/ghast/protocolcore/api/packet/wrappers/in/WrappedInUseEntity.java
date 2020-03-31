package cc.ghast.protocolcore.api.packet.wrappers.in;

import cc.ghast.protocolcore.api.WrappedPacket;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import lombok.Getter;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/**
 * @author Ghast
 * @since 31-Mar-20
 */

@Getter
public class WrappedInUseEntity extends WrappedPacket {
    public WrappedInUseEntity(PacketContainer container, Player player) {
        super(container, player);
    }

    private Entity target;
    private EnumWrappers.EntityUseAction action;
    private Vector body;

    @Override
    public void construct() {
        target = player.getWorld()
                .getEntities()
                .parallelStream()
                .filter(e -> e.getEntityId() == container.getIntegers().readSafely(0))
                .findFirst()
                .orElse(null);

        action = container.getEntityUseActions().readSafely(0);

        if (action == EnumWrappers.EntityUseAction.INTERACT_AT){
            body = container.getVectors().readSafely(0);
        } else {
            body = new Vector(0,0,0);
        }
    }
}
