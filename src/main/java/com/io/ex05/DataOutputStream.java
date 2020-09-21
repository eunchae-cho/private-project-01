package com.io.ex05;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStream extends FileOutputStream {

	public DataOutputStream(String filename) throws FileNotFoundException {
		super(filename);
	}

	public void writeUTF(String str) throws IOException {
		byte[] bytes = str.getBytes("UTF-8");
		this.write(bytes.length);
		this.write(bytes);
	}

	public void writeInt(int value) throws IOException {
		this.write(value >> 24);
		this.write(value >> 16);
		this.write(value >> 8);
		this.write(value);

	}

	public void writeLong(long value) throws IOException {
		this.write((int)value >> 56);
		this.write((int)value >> 48);
		this.write((int)value >> 40);
		this.write((int)value >> 32);
		this.write((int)value >> 24);
		this.write((int)value >> 16);
		this.write((int)value >> 8);
		this.write((int) value);
	}

	public void writeBoolean(boolean value) throws IOException {
		if(value)
			this.write(1);
		else
			this.write(0);
	}
}
