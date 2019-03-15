import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MaxSubArray {

    static Solution calculate(List<Integer> inputNumbers) {
        int start = 0;
        int temp_start = 0;
        int end = 0;
        Solution solution = new Solution();
        int current_max= inputNumbers.get(0);
        int global_max= inputNumbers.get(0);

        for (int i = 1; i < inputNumbers.size(); i++){
            current_max = Math.max(inputNumbers.get(i), current_max + inputNumbers.get(i));

            if (current_max < 0)
                temp_start = i + 1;

            if ( global_max < current_max) {
                global_max = current_max;
                start = temp_start;
                end = i;
            }

            solution.setStartIndex(start);
            solution.setEndIndex(end);
            solution.setSum(global_max);
        }
        return solution;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> inputIntegers = new ArrayList<>();
        String[] numbers;
        System.out.print("Enter the array : ");
        numbers = reader.readLine().split("\\s");

        for (String number : numbers) {
            inputIntegers.add(Integer.parseInt(number));
        }

        Solution solution = MaxSubArray.calculate(inputIntegers);
        System.out.println("Largest SubArray");
        System.out.println("Start Index: " + solution.getStartIndex());
        System.out.println("Length: " + ((solution.getEndIndex() - solution.getStartIndex()) + 1));
        System.out.println("Sum: " + solution.getSum());
        System.out.println("Elements: " + inputIntegers.subList(solution.getStartIndex(), solution.getEndIndex() + 1));
    }
}
