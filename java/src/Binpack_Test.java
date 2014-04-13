import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaofei.wxf
 */
public class Binpack_Test {
    @Test
    public void testLongOverflow() throws IOException {
        long _long = Long.MIN_VALUE;
        byte[] encoded = Bin.encode(_long, "utf8");
        Object decoded = Bin.decode(encoded, "utf8");
        System.out.println(_long);
        System.out.println(decoded);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Binpack_.pack(out, Byte.MIN_VALUE);
        encoded = out.toByteArray();
        decoded = Binpack_.unpack(new ByteArrayInputStream(encoded));
        System.out.println();
    }

    @Test
    public void testPackUnpackByte() throws IOException {
        byte b = Byte.MIN_VALUE;
        for (; ; ) {
            ByteArrayOutputStream _o = new ByteArrayOutputStream();
            Binpack_.pack(_o, b);
            ByteArrayInputStream _i = new ByteArrayInputStream(_o.toByteArray());
            Object unpack = Binpack_.unpack(_i);
            System.out.println(b + " " + unpack);
            assert unpack.equals(b);
            b++;
            if (b == Byte.MIN_VALUE) {
                break;
            }
        }
    }

    @Test
    public void testPackUnpackShort() throws IOException {
        short s = Short.MIN_VALUE;
        for (; ; ) {
            ByteArrayOutputStream _o = new ByteArrayOutputStream();
            Binpack_.pack(_o, s);
            ByteArrayInputStream _i = new ByteArrayInputStream(_o.toByteArray());
            Object unpack = Binpack_.unpack(_i);
            System.out.println(s + " " + unpack);
            assert unpack.equals(s);
            s++;
            if (s == Short.MIN_VALUE) {
                break;
            }
        }
    }

    @Test
    public void testPackUnpackInteger() throws IOException {
        int i = Integer.MIN_VALUE;
        for (; ; ) {
            ByteArrayOutputStream _o = new ByteArrayOutputStream();
            Binpack_.pack(_o, i);
            ByteArrayInputStream _i = new ByteArrayInputStream(_o.toByteArray());
            Object unpack = Binpack_.unpack(_i);
            System.out.println(i + " " + unpack);
            assert unpack.equals(i);
            i++;
            if (i == Integer.MIN_VALUE) {
                break;
            }
        }
    }

    @Test
    public void testPackUnpackLong() throws IOException {
        long i = Long.MIN_VALUE;
        for (; ; ) {
            ByteArrayOutputStream _o = new ByteArrayOutputStream();
            Binpack_.pack(_o, i);
            ByteArrayInputStream _i = new ByteArrayInputStream(_o.toByteArray());
            Object unpack = Binpack_.unpack(_i);
            System.out.println(i + " " + unpack);
            assert unpack.equals(i);
            i++;
            if (i == Long.MIN_VALUE) {
                break;
            }
        }
    }

    @Test
    public void testPackUnpackList() throws IOException {
        List l = new ArrayList();
        l.add(Integer.valueOf(1));
        l.add(Byte.valueOf((byte) 1));
        l.add(Short.valueOf((short) 1));
        l.add(Long.valueOf(1));
        l.add("string");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Binpack_.pack(out, l);
        byte[] data = out.toByteArray();
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        Object o = Binpack_.unpack(in);
        System.out.println();
    }

}
