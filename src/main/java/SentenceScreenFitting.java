import java.util.HashMap;
import java.util.Map;

public class SentenceScreenFitting {

    public int wordsTyping(String[] sentences, int rows, int cols) {
        Map<Integer, Integer> cache = new HashMap<>();
        int remainingPositions = rows * cols;
        int currentColPosition = 0;
        int times = 0;
        while (true) {
            if (!cache.containsKey(currentColPosition)) {
                int positionsRequired = getRequiredPositionsToFitSentence(sentences, currentColPosition, cols);
                if (positionsRequired <= 0) {
                    return 0;
                }
                cache.put(currentColPosition, positionsRequired);
            } else {
                int recurrenceWidth = rows * cols - remainingPositions;
                if (recurrenceWidth > cols) { // spans across multiple columns
                    recurrenceWidth ++;
                }
                int recurrence = remainingPositions / recurrenceWidth;
                times += times * recurrence;
                int positionAdvance = recurrence * recurrenceWidth;
                remainingPositions -= positionAdvance;
            }
            if (!cache.containsKey(currentColPosition)) {
                int positionsRequired = getRequiredPositionsToFitSentence(sentences, currentColPosition, cols);
                cache.put(currentColPosition, positionsRequired);
            }
            int positionsRequired = cache.get(currentColPosition);
            if (remainingPositions >= positionsRequired) {
                currentColPosition = (currentColPosition + (positionsRequired % cols)) % cols;
                remainingPositions -= positionsRequired;
                times++;
            } else {
                break;
            }

        }
        return times;
    }

    // returns the target row and the col where the sentence would end if started from a given column index
    // we are going to memoize this.
    private int getRequiredPositionsToFitSentence(String[] sentences, int startCol, int cols) {
        int positionsRequired = 0;
        int currentWord = 0;
        int capacityLeftForRow = cols - startCol;
        while (currentWord < sentences.length) {
            // fill the row
            int requiredForCurrentWord = sentences[currentWord].length();
            if (capacityLeftForRow != cols) {
                requiredForCurrentWord++;
            }
            if (requiredForCurrentWord <= capacityLeftForRow) {
                capacityLeftForRow -= requiredForCurrentWord;
                positionsRequired += requiredForCurrentWord;
                currentWord++;
            } else {
                if (sentences[currentWord].length() > cols) {
                    return -1;
                } else {
                    positionsRequired += capacityLeftForRow;
                    capacityLeftForRow = cols;
                }
            }

        }
        return positionsRequired;
    }
}
