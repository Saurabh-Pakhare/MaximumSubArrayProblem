import spock.lang.Specification

class MaxSubArraySpec extends Specification{

    def "should return maximum sub array" () {
        given:
        List<Integer> inputArray  = new ArrayList<>();
        inputArray.add(2)
        inputArray.add(1)
        inputArray.add(-3)
        inputArray.add(4)
        inputArray.add(-1)
        inputArray.add(2)
        inputArray.add(1)
        inputArray.add(-5)
        inputArray.add(4)

        when:
        Solution maxSubArrayDetails = MaxSubArray.calculate(inputArray)

        then:
        maxSubArrayDetails.getSum() == 6

    }
}
