package src;

import java.io.IOException;
import java.io.InputStream;

/**
 * Поток для побитового чтения из файла
 */
public class BitInputStream implements AutoCloseable {
    
    private InputStream input;
    private int buffer;
    private int bitsInBuffer;
    
    public BitInputStream(InputStream in) {
        this.input = in;
        this.buffer = 0;
        this.bitsInBuffer = 0;
    }
    
    public int readBit() throws IOException {
        if (bitsInBuffer == 0) {
            buffer = input.read();
            if (buffer == -1) {
                return -1;
            }
            bitsInBuffer = 8;
        }
        
        bitsInBuffer--;
        return (buffer >> bitsInBuffer) & 1;
    }
    
    public int readByte() throws IOException {
        int result = 0;
        for (int i = 0; i < 8; i++) {
            int bit = readBit();
            if (bit == -1) {
                return -1;
            }
            result = (result << 1) | bit;
        }
        return result;
    }
    
    public boolean hasNext() throws IOException {
        if (bitsInBuffer > 0) {
            return true;
        }
        int next = input.read();
        if (next == -1) {
            return false;
        }
        buffer = next;
        bitsInBuffer = 8;
        return true;
    }
    
    @Override
    public void close() throws IOException {
        input.close();
    }
}