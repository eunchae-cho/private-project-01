package com.io.ex07;

import java.io.ByteArrayInputStream;

public class DataByteArrayInputStream extends ByteArrayInputStream {

	public DataByteArrayInputStream(byte[] buf) {
		super(buf);
	}

	public String readUTF() throws Exception {
		int size = this.read();
		byte[] bytes = new byte[size];
		this.read(bytes);
		return new String(bytes, "UTF-8");
	}

	public int readInt() throws Exception {
		int value = 0;

		value = this.read() << 24;
		value += this.read() << 16;
		value += this.read() << 8;
		value += this.read();
		return value;
	}

	public long readLong() throws Exception {
		long value = 0;
		value += (long) this.read() << 56;
		value += (long) this.read() << 48;
		value += (long) this.read() << 40;
		value += (long) this.read() << 32;
		value += (long) this.read() << 24;
		value += (long) this.read() << 16;
		value += this.read();
		return value;
	}

	public boolean readBoolean() throws Exception {
		if (this.read() == 1)
			return true;
		else
			return false;
	}
}
