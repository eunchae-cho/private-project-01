package com.io.ex06;

import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStream extends FileOutputStream {
	byte[] buf = new byte[8196];
	int cursor;

	public BufferedOutputStream(String filename) throws Exception {
		super(filename);
	}

	@Override
	public void write(int b) throws IOException {
		if (cursor == buf.length) {
			super.write(buf);
			cursor = 0;
		}
		buf[cursor++] = (byte) b;
	}

	@Override
	public void write(byte[] buf) throws IOException {
		for (byte b : buf) {
			this.write(b & 0x000000ff);
		}
	}

	@Override
	public void close() throws IOException {
		this.flush();
		this.close();
	}

	@Override
	public void flush() throws IOException {
		if (cursor > 0) {
			this.write(buf, 0 ,cursor);
			cursor = 0;
		}
	}
}
