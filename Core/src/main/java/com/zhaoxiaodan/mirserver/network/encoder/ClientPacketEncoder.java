package com.zhaoxiaodan.mirserver.network.encoder;

import com.zhaoxiaodan.mirserver.network.packets.ClientPacket;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.nio.ByteOrder;
import java.util.List;

public class ClientPacketEncoder extends MessageToMessageEncoder<ClientPacket> {

	@Override
	protected void encode(ChannelHandlerContext ctx, ClientPacket packet, List<Object> out) throws Exception {
		ByteBuf buf = Unpooled.buffer().order(ByteOrder.LITTLE_ENDIAN);
		packet.writePacket(buf);
		out.add(buf);
	}
}
