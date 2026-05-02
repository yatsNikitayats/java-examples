package src;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Поток для побитовой записи в файл
 */
public class BitOutputStream implements AutoCloseable {
    
    private OutputStream output;
    private int buffer;
    private int bitsInBuffer;
    
    public BitOutputStream(OutputStream out) {
        this.output = out;
        this.buffer = 0;
        this.bitsInBuffer = 0;
    }
    
    public void writeBit(int bit) throws IOException {
        if (bit != 0 && bit != 1) {
            throw new IllegalArgumentException("Бит должен быть 0 или 1");
        }
        
        buffer = (buffer << 1) | bit;
        bitsInBuffer++;
        
        if (bitsInBuffer == 8) {
            flushByte();
        }
    }
    
    public void writeByte(int b) throws IOException {
        if (b < 0 || b > 255) {
            throw new IllegalArgumentException("Байт должен быть от 0 до 255");
        }
        
        if (bitsInBuffer == 0) {
            output.write(b);
        } else {
            for (int i = 7; i >= 0; i--) {
                writeBit((b >> i) & 1);
            }
        }
    }
    
    public void writeBits(String bits) throws IOException {
        for (int i = 0; i < bits.length(); i++) {
            char c = bits.charAt(i);
            if (c == '0') {
                writeBit(0);
            } else if (c == '1') {
                writeBit(1);
            } else {
                throw new IllegalArgumentException("Недопустимый символ: " + c);
            }
        }
    }
    
    private void flushByte() throws IOException {
        if (bitsInBuffer > 0) {
            output.write(buffer);
            buffer = 0;
            bitsInBuffer = 0;
        }
    }
    
    @Override
    public void close() throws IOException {
        if (bitsInBuffer > 0) {
            while (bitsInBuffer < 8) {
                buffer = (buffer << 1) | 0;
                bitsInBuffer++;
            }
            flushByte();
        }
        output.close();
    }
}