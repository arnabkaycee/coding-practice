import java.util.Stack;

class DecodeString {

    private StringBuilder repeat(StringBuilder s, int times){
        StringBuilder output = new StringBuilder();
        for (int i = 0; i<times; i++){
            output.append(s);
        }
        return output;
    }

    public String decodeString(String s) {
//        StringBuilder output = new StringBuilder();
        int currIndex = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        stringStack.push(new StringBuilder());
        StringBuilder quantifier = new StringBuilder();
        StringBuilder currentString = new StringBuilder();

        while(currIndex < s.length()) {
            char currChar = s.charAt(currIndex);
            if (currChar >= 'a' && currChar <= 'z'){
                currentString.append(currChar);
            }else if (currChar == '[') {
                // push to the stack the quantifier
                stack.push(Integer.parseInt(quantifier.toString()));
                stringStack.push(stringStack.pop().append(currentString));
                quantifier = new StringBuilder();
                currentString = new StringBuilder();

            }else if(currChar == ']') {


                if (currentString.length() != 0){
                    stringStack.push(currentString);
                    currentString = new StringBuilder();
                }

                // pop from the stack the quantifier

                int times = stack.pop();
                currentString = stringStack.pop();
                currentString = repeat(currentString, times);

                if (!stringStack.isEmpty()) {
                    StringBuilder previousString = stringStack.pop();
                    previousString.append(currentString);
                    stringStack.push(previousString);
                    currentString = new StringBuilder();
                }else{
                    stringStack.push(currentString);
                }


            }else if (Character.isDigit(currChar)) {
                quantifier.append(currChar);
            }
            currIndex++;
        }

        return stringStack.pop().append(currentString).toString();
    }
}