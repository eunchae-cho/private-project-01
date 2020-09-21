package com.io.ex06;

import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStream extends FileInputStream {
	byte[] buf = new byte[8192];
	int size;
	int cursor;

	public BufferedInputStream(String filename) throws Exception {
		super(filename);
	}

	@Override
	public int read() throws IOException {
		if (cursor == size) {
			if((size = super.read(buf)) == -1) {
				return -1;
			}
			cursor = 0;
		}
		return buf[cursor++] & 0x000000ff;
	}

	@Override
	public int read(byte[] buf) throws IOException {
		int i = 0;
		for(; i < buf.length; i++) {
			int b = this.read();
			if (b == -1) {
				break;
			}
			buf[i] = (byte) b;
		}
		return i;
	}
}
