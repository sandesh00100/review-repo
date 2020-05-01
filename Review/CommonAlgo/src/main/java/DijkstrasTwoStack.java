import java.util.HashSet;
import java.util.Set;

public class DijkstrasTwoStack {
    private Stack<Double> valueStack;
    private Stack<Character> operatorStack;
    private Set<Character> operatorSet;
    private char ADD = '+';
    private char SUB = '-';
    private char DIV = '/';
    private char MULT = '*';
    private char OPEN_PAREN = '(';
    private char CLOSED_PREN = ')';

    public DijkstrasTwoStack(){
        valueStack = new StackWithList<>();
        operatorStack = new StackWithList<>();
        operatorSet = new HashSet<>();
        operatorSet.add(ADD);
        operatorSet.add(SUB);
        operatorSet.add(DIV);
        operatorSet.add(MULT);
    }

   public double orderOfOperations(String input){
        char[] inputArr = input.toCharArray();
        for (char c:inputArr){
            if (operatorSet.contains(c)){
                operatorStack.push(c);
            } else if(Character.isDigit(c)){
                //subtracting 48 will get you to the int value
                valueStack.push((double)c-48);
            } else if (c == CLOSED_PREN) {
                char currentOperator = operatorStack.pop();
                if (currentOperator == ADD) {
                    double val2 = valueStack.pop();
                    double val1 = valueStack.pop();
                    valueStack.push(val1 + val2);
                } else if (currentOperator == SUB) {
                    double val2 = valueStack.pop();
                    double val1 = valueStack.pop();
                    valueStack.push(val1 - val2);
                } else if (currentOperator == DIV) {
                    double val2 = valueStack.pop();
                    double val1 = valueStack.pop();
                    valueStack.push(val1 / val2);
                } else if (currentOperator == MULT) {
                    double val2 = valueStack.pop();
                    double val1 = valueStack.pop();
                    valueStack.push(val1 * val2);
                }
            }
        }
        return valueStack.pop();
   }
}
