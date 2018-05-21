import java.util.*;
import java.io.*;
public class Main{

    private final static String[] LOCAL_INPUT = {"Test1", "Test2", ""};

    public static void main(String[] args) {
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        if(oj) {
            new Solver().run(true, System.in);
        } else {
            for(String INPUT: LOCAL_INPUT) {
                if(INPUT.length() > 0)
                    new Solver().run(false, new ByteArrayInputStream(INPUT.getBytes()));
            }
        }
    }

    static class Solver {
        InputReader in;
        PrintWriter out;

        void solve() {
            out.println(in.next());
        }

        void run(boolean OJ, InputStream is) {
            oj = OJ;
            in = new InputReader(is);
            out  = new PrintWriter(System.out);
            long startTime = System.currentTimeMillis();
            solve();
            long endTime = System.currentTimeMillis();
            out.flush();
            debug(endTime - startTime + "ms");
        }
        private boolean oj;
        private void debug(Object... o) { if(!oj)System.out.println(Arrays.deepToString(o)); }
    }

    static class InputReader {
        private byte[] inbuf = new byte[1024];
        private int lenbuf = 0, ptrbuf = 0;
        private InputStream is;

        InputReader(InputStream is) {
            this.is = is;
        }
        private int readByte() {
            if (lenbuf == -1) throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0) return -1;
            }
            return inbuf[ptrbuf++];
        }

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b)) ;
            return b;
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        char nextChar() {
            return (char) skip();
        }

        String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }
        long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }
    }
}
