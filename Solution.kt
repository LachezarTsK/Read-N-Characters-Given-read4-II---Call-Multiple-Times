
/**
 * ----- Comment from Leetcode ----- 
 *
 * The read4 API is defined in the parent class Reader4.
 * fun read4(buf4:CharArray): Int {}
 */

class Solution : Reader4() {

    private companion object {
        const val MAX_READ_CHARS_PER_CALL_OF_READ4 = 4
    }

    private val bufferRead4 = CharArray(MAX_READ_CHARS_PER_CALL_OF_READ4)
    private var indexInBufferRead4 = 0
    private var numberCharsInBufferRead4 = 0

    override fun read(destinationBuffer: CharArray, numberOfCharsToRead: Int): Int {

        var indexInDestinationBuffer = 0
        var numberOfCharsSentToDestinationBuffer = 0
        var numberOfCharsToRead = numberOfCharsToRead

        while (numberOfCharsToRead > 0) {

            while (numberCharsInBufferRead4 > 0 && numberOfCharsToRead > 0) {
                destinationBuffer[indexInDestinationBuffer] = bufferRead4[indexInBufferRead4]

                ++indexInBufferRead4
                ++indexInDestinationBuffer
                ++numberOfCharsSentToDestinationBuffer

                --numberOfCharsToRead
                --numberCharsInBufferRead4
            }

            if (numberCharsInBufferRead4 == 0) {
                indexInBufferRead4 = 0
            }
            if (numberOfCharsToRead > 0) {
                numberCharsInBufferRead4 = read4(bufferRead4)
            }
            if (numberCharsInBufferRead4 == 0) {
                break
            }
        }

        return numberOfCharsSentToDestinationBuffer
    }
}
