package com.zhaoxiaodan.mirserver.db.entities;

import com.zhaoxiaodan.mirserver.db.objects.ItemAttr;
import com.zhaoxiaodan.mirserver.network.packets.Parcelable;
import io.netty.buffer.ByteBuf;

import javax.persistence.*;

@Entity
public class PlayerItem implements Parcelable{

	@Id
	@GeneratedValue
	public int    id;
	@ManyToOne
	@JoinColumn(name = "playerId")
	public Player player;

	@Embedded
	public ItemAttr attr;

	public short dura;

	@Override
	public void readPacket(ByteBuf in) throws WrongFormatException {

	}

	@Override
	public void writePacket(ByteBuf out) {
		attr.writePacket(out);
		out.writeInt(id);
		out.writeShort(dura);
		out.writeShort(attr.duraMax);
	}
}