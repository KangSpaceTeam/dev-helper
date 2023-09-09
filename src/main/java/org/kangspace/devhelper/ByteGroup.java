package org.kangspace.devhelper;

import java.util.ArrayList;

/**
 *
 * @author other
 */
public class ByteGroup {

    private final ArrayList<Byte> BYTE_CONTAINER = new ArrayList<>();

    /**
     * 转换为byte[]
     *
     * @return byte[]
     */
    public byte[] toBytes() {
        byte[] bytes = new byte[BYTE_CONTAINER.size()];
        for (int i = 0; i < BYTE_CONTAINER.size(); i++) {
            bytes[i] = BYTE_CONTAINER.get(i);
        }
        return bytes;
    }

    /**
     * 添加byte[]
     *
     * @param bytes byte[]
     * @return {@link ByteGroup}
     */
    public ByteGroup addBytes(byte[] bytes) {
        for (byte b : bytes) {
            BYTE_CONTAINER.add(b);
        }
        return this;
    }

    /**
     * byte[] 大小
     *
     * @return int
     */
    public int size() {
        return BYTE_CONTAINER.size();
    }
}
