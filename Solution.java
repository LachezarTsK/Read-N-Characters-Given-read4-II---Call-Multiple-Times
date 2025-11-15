
/**
 * ----- Comment from Leetcode -----
 *
 * The read4 API is defined in the parent class Reader4. int read4(char[]
 * buffer4);
 */
public class Solution extends Reader4 {

    private static final int MAX_READ_CHARS_PER_CALL_OF_READ4 = 4;
    private final char[] bufferRead4 = new char[MAX_READ_CHARS_PER_CALL_OF_READ4];

    private int indexInBufferRead4;
    private int numberCharsInBufferRead4;

    public int read(char[] destinationBuffer, int numberOfCharsToRead) {

        int indexInDestinationBuffer = 0;
        int numberOfCharsSentToDestinationBuffer = 0;

        while (numberOfCharsToRead > 0) {

            while (numberCharsInBufferRead4 > 0 && numberOfCharsToRead > 0) {
                destinationBuffer[indexInDestinationBuffer] = bufferRead4[indexInBufferRead4];

                ++indexInBufferRead4;
                ++indexInDestinationBuffer;
                ++numberOfCharsSentToDestinationBuffer;

                --numberOfCharsToRead;
                --numberCharsInBufferRead4;
            }

            if (numberCharsInBufferRead4 == 0) {
                indexInBufferRead4 = 0;
            }
            if (numberOfCharsToRead > 0) {
                numberCharsInBufferRead4 = super.read4(bufferRead4);
            }
            if (numberCharsInBufferRead4 == 0) {
                break;
            }
        }

        return numberOfCharsSentToDestinationBuffer;
    }
}
