
using namespace std;

/**
* ----- Comment from Leetcode ----- 
*
* The read4 API is defined in the parent class Reader4.
*     int read4(char *buf4);
*/

class Solution {

    static const int MAX_READ_CHARS_PER_CALL_OF_READ4 = 4;
    char* bufferRead4 = new char[MAX_READ_CHARS_PER_CALL_OF_READ4];

    int indexInBufferRead4 = 0;
    int numberCharsInBufferRead4 = 0;

public:
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    int read(char* destinationBuffer, int numberOfCharsToRead) {
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
                numberCharsInBufferRead4 = read4(bufferRead4);
            }
            if (numberCharsInBufferRead4 == 0) {
                break;
            }
        }

        return numberOfCharsSentToDestinationBuffer;
    }
};
