package cc.ghast.protocolcore.api.packet.wrappers.in;

import cc.ghast.protocolcore.api.WrappedPacket;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.StructureModifier;
import lombok.Getter;
import org.bukkit.entity.Player;

/**
 * @author Ghast
 * @since 31-Mar-20
 */

@Getter
public class WrappedInAbilities extends WrappedPacket {
    public WrappedInAbilities(PacketContainer container, Player player) {
        super(container, player);
    }

    private boolean invulnerable, flying, allowedFlight, creativeMode;
    private float flySpeed, walkSpeed;

    @Override
    public void construct() {
        // BOOLEANS
        StructureModifier<Boolean> bools = container.getBooleans();
        invulnerable = bools.readSafely(0);
        flying = bools.readSafely(1);
        allowedFlight = bools.read(2);
        creativeMode = bools.read(3);

        // FLOATS
        StructureModifier<Float> floats = container.getFloat();
        flySpeed = floats.read(0);
        walkSpeed = floats.read(1);

    }
}
