
/**
 * ----- Comment from Leetcode -----
 * 
 * Definition for read4()
 * 
 * @param {character[]} buf Destination buffer
 * @return {number} The number of characters read
 * read4 = function(buf4) {
 *     ...
 * };
 */

/**
 * @param {function} read4
 * @return {function}
 */
var solution = function (read4) {

    const MAX_READ_CHARS_PER_CALL_OF_READ4 = 4;
    const bufferRead4 = new Array(MAX_READ_CHARS_PER_CALL_OF_READ4);

    let indexInBufferRead4 = 0;
    let numberCharsInBufferRead4 = 0;

    /**
     * @param {string[]} destinationBuffer
     * @param {number} numberOfCharsToRead
     * @return {number} 
     */
    return function (destinationBuffer, numberOfCharsToRead) {

        let indexInDestinationBuffer = 0;
        let numberOfCharsSentToDestinationBuffer = 0;

        while (numberOfCharsToRead > 0) {

            while (numberCharsInBufferRead4 > 0 && numberOfCharsToRead > 0) {
                destinationBuffer[indexInDestinationBuffer] = bufferRead4[indexInBufferRead4];

                ++indexInBufferRead4;
                ++indexInDestinationBuffer;
                ++numberOfCharsSentToDestinationBuffer;

                --numberOfCharsToRead;
                --numberCharsInBufferRead4;
            }

            if (numberCharsInBufferRead4 === 0) {
                indexInBufferRead4 = 0;
            }
            if (numberOfCharsToRead > 0) {
                numberCharsInBufferRead4 = read4(bufferRead4);
            }
            if (numberCharsInBufferRead4 === 0) {
                break;
            }
        }

        return numberOfCharsSentToDestinationBuffer;
    };
};
