package cc.ghast.protocolcore.listener;

import cc.ghast.protocolcore.ProtocolCore;
import cc.ghast.protocolcore.api.packet.utils.PacketUtil;
import cc.ghast.protocolcore.api.WrappedPacket;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;

/**
 * @author Ghast
 * @since 01-Apr-20
 */
public class PacketListener extends PacketAdapter {
    public PacketListener(ProtocolCore plugin) {
        super(plugin, ListenerPriority.MONITOR, PacketType.values());
    }

    @Override
    public void onPacketReceiving(PacketEvent event) {
        WrappedPacket packet = PacketUtil.getPacket(event.getPacket(), event.getPlayer());
        if (packet == null) return;

        // PROCESS INBOUND HERE
    }

    @Override
    public void onPacketSending(PacketEvent event) {
        WrappedPacket packet = PacketUtil.getPacket(event.getPacket(), event.getPlayer());
        if (packet == null) return;

        // PROCESS OUTBOUND HERE
    }
}
