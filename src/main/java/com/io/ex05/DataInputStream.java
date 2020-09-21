package com.io.ex05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInputStream extends FileInputStream {

	public DataInputStream(String filename) throws FileNotFoundException {
		super(filename);
	}

	public String readUTF() throws IOException {
		int size = this.read();
		byte[] bytes = new byte[size];
		this.read(bytes);
		return new String(bytes, "UTF-8");
	}

	public int readInt() throws IOException {
		int value = 0;
		value = this.read() << 24;
		value += this.read() << 16;
		value += this.read() << 8;
		value += this.read();
		return value;
	}

	public long readLong() throws IOException {
		long value = 0;
		value += (long) this.read() << 56;
		value += (long) this.read() << 48;
		value += (long) this.read() << 40;
		value += (long) this.read() << 32;
		value += (long) this.read() << 24;
		value += (long) this.read() << 16;
		value += (long) this.read() << 8;
		value += this.read();
		return value;
	}

	public boolean readBoolean() throws IOException {
		if (this.read() == 1) 
			return true;
		else
			return false;
	}
}
