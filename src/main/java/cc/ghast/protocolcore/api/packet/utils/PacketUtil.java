package cc.ghast.protocolcore.api.packet.utils;

import cc.ghast.protocolcore.api.WrappedPacket;
import cc.ghast.protocolcore.api.packet.wrappers.in.*;
import cc.ghast.protocolcore.api.packet.wrappers.out.*;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.utility.MinecraftVersion;
import org.bukkit.entity.Player;

/**
 * @author Ghast
 * @since 01-Apr-20
 */
public class PacketUtil {
    public static WrappedPacket getPacket(PacketContainer container, Player player){

        PacketType type = container.getType();

        // POSITIONS
        if (type.equals(PacketType.Play.Client.POSITION)
                || type.equals(PacketType.Play.Client.POSITION_LOOK)
                || type.equals(PacketType.Play.Client.LOOK)
                || type.equals(PacketType.Play.Client.FLYING)){
            return new WrappedInFlying(container, player);
        }

        if (type.equals(PacketType.Play.Server.POSITION)){
            return new WrappedOutPosition(container, player);
        }

        // VELOCITY
        if (type.equals(PacketType.Play.Server.ENTITY_VELOCITY)){
            return new WrappedOutVelocity(container, player);
        }

        // KEEP ALIVE
        if (type.equals(PacketType.Play.Client.KEEP_ALIVE)){
            if (MinecraftVersion.getCurrentVersion().isAtLeast(MinecraftVersion.AQUATIC_UPDATE)){
                return new WrappedIn13KeepAlive(container, player);
            }
            return new WrappedInKeepAlive(container, player);
        }
        if (type.equals(PacketType.Play.Server.KEEP_ALIVE)){
            if (MinecraftVersion.getCurrentVersion().isAtLeast(MinecraftVersion.AQUATIC_UPDATE)){
                return new WrappedOut13KeepAlive(container, player);
            }
            return new WrappedOutKeepAlive(container, player);
        }

        // TRANSACTION

        if (type.equals(PacketType.Play.Client.TRANSACTION)){
            return new WrappedInTransaction(container, player);
        }
        if (type.equals(PacketType.Play.Server.TRANSACTION)){
            return new WrappedOutTransaction(container, player);
        }

        // ENTITY ACTION
        if (type.equals(PacketType.Play.Client.ENTITY_ACTION)){
            return new WrappedInEntityAction(container, player);
        }

        // USE ENTITY
        if (type.equals(PacketType.Play.Client.USE_ENTITY)){
            return new WrappedInUseEntity(container, player);
        }

        // ARM ANIMATION
        if (type.equals(PacketType.Play.Client.ARM_ANIMATION)){
            return new WrappedInArmAnimation(container, player);
        }

        // ABILITIES
        if (type.equals(PacketType.Play.Client.ABILITIES)){
            return new WrappedInAbilities(container, player);
        }

        // BLOCK DIG
        if (type.equals(PacketType.Play.Client.BLOCK_DIG)){
            return new WrappedInBlockDig(container, player);
        }

        // BLOCK PLACE
        if (type.equals(PacketType.Play.Client.BLOCK_PLACE)){
            return new WrappedInBlockPlace(container, player);
        }

        // CUSTOM PAYLOAD
        if (type.equals(PacketType.Play.Client.CUSTOM_PAYLOAD)){
            return new WrappedInCustomPayload(container, player);
        }

        return null;

    }


}
