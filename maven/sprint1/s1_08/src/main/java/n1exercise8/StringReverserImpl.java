package n1exercise8;

public class StringReverserImpl implements StringReverser {
    @Override
    public String reverse(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }
}
