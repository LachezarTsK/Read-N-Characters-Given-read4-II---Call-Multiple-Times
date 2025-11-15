
package main

/**
 * ----- Comment from Leetcode ----- 
 *
 * The read4 API is already defined for you.
 *
 *     read4 := func(buf4 []byte) int
 *
 * // Below is an example of how the read4 API can be called.
 * file := File("abcdefghijk") // File is "abcdefghijk", initially file pointer (fp) points to 'a'
 * buf4 := make([]byte, 4) // Create buffer with enough space to store characters
 * read4(buf4) // read4 returns 4. Now buf = ['a','b','c','d'], fp points to 'e'
 * read4(buf4) // read4 returns 4. Now buf = ['e','f','g','h'], fp points to 'i'
 * read4(buf4) // read4 returns 3. Now buf = ['i','j','k',...], fp points to end of file
 */

var solution = func(read4 func([]byte) int) func([]byte, int) int {

    const MAX_READ_CHARS_PER_CALL_OF_READ4 = 4
    var bufferRead4 = make([]byte, MAX_READ_CHARS_PER_CALL_OF_READ4)
    var indexInBufferRead4 = 0
    var numberCharsInBufferRead4 = 0

    return func(destinationBuffer []byte, numberOfCharsToRead int) int {

        var indexInDestinationBuffer = 0
        var numberOfCharsSentToDestinationBuffer = 0

        for numberOfCharsToRead > 0 {

            for numberCharsInBufferRead4 > 0 && numberOfCharsToRead > 0 {
                destinationBuffer[indexInDestinationBuffer] = bufferRead4[indexInBufferRead4]

                indexInBufferRead4++
                indexInDestinationBuffer++
                numberOfCharsSentToDestinationBuffer++

                numberOfCharsToRead--
                numberCharsInBufferRead4--
            }

            if numberCharsInBufferRead4 == 0 {
                indexInBufferRead4 = 0
            }
            if numberOfCharsToRead > 0 {
                numberCharsInBufferRead4 = read4(bufferRead4)
            }
            if numberCharsInBufferRead4 == 0 {
                break
            }
        }

        return numberOfCharsSentToDestinationBuffer
    }
}
