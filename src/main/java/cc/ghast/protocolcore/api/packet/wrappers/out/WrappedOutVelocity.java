package cc.ghast.protocolcore.api.packet.wrappers.out;

import cc.ghast.protocolcore.api.WrappedPacket;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.StructureModifier;
import lombok.Getter;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/**
 * @author Ghast
 * @since 01-Apr-20
 */

@Getter
public class WrappedOutVelocity extends WrappedPacket {
    public WrappedOutVelocity(PacketContainer container, Player player) {
        super(container, player);
    }

    private Entity entity;
    private Vector vector;

    @Override
    public void construct() {
        entity = player.getWorld()
                .getEntities()
                .parallelStream()
                .filter(e -> e.getEntityId() == container.getIntegers().readSafely(0))
                .findFirst()
                .orElse(null);

        StructureModifier<Double> dbl = container.getDoubles();
        vector = new Vector(
                (dbl.readSafely(0) / 8000D),
                (dbl.readSafely(1) / 8000D),
                (dbl.readSafely(2) / 8000D)
        );
    }
}
