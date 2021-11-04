package com.example.mypackage;

public class IndexRecord {
    private int startByte;
    private int recordLength;

    public IndexRecord(int startByte, int recordLength) {
        this.startByte = startByte;
        this.recordLength = recordLength;
    }

    public int getStartByte() {
        return startByte;
    }

    public void setStartByte(int startByte) {
        this.startByte = startByte;
    }

    public int getRecordLength() {
        return recordLength;
    }

    public void setRecordLength(int recordLength) {
        this.recordLength = recordLength;
    }
}
