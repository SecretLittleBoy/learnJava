import java.net.InetAddress;
import java.net.UnknownHostException;
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByAddress(new byte[] {(byte)127,(byte)0,(byte)0,(byte)1});
            System.out.println(address);
        }
        catch (UnknownHostException e) {
            System.out.println("Could not find");
        }
    }
}