public class Main {
    public static void main(String[] args) {
        int input1[][] = {{1,2,3}, {4,5,6}, {7,8}, {9,10,11,12}};
        int unluckyNumbersArr[] = {0,1,2,4,10,13,23};
        String[] fortunes = {"Your friends are conspiring to assassinate you.","Get a pet baby; it will cheer you up.","You look pale. You should go outside.","Nuclear winter is coming."};




        System.out.println("Outputs:\nProblem 1 (Sums of each inner array):");
        int iterator = 0;
        for (int outputValue : arraySum(input1)) {
            System.out.print(outputValue);
            addComma(arraySum(input1), iterator);
            iterator++;
        }

        System.out.println("\n\nProblem 2 (Sum of every value stored in the arrays):");
        System.out.print(arraySumAll(input1));

        System.out.println("\n\nProblem 3 (Smallest values of each inner array):");
        iterator = 0;
        for (int outputValue : arraySmallestValues(input1)) {
            System.out.print(outputValue);
            addComma(arraySmallestValues(input1), iterator);
            iterator++;
        }

        System.out.println("\n\nProblem 4 (Largest value of every value stored in the arrays):");
        System.out.print(arrayLargestValue(input1));

        System.out.println("\n\nProblem 5 (Location of largest value in arrays):");
        iterator = 0;
        for (int outputValue : arrayLargestValueLocation(input1)) {
            System.out.print(outputValue);
            addComma(arrayLargestValueLocation(input1), iterator);
            iterator++;
        }

        System.out.println("\n\nProblem 6 (Replaces unlucky numbers with lucky numbers):");
        iterator = 0;
        for (int[] outputValue : arrayReplaceUnluckyNumbers(input1,unluckyNumbersArr,777)) { //i added four to the unlucky numbers
            int insideIterator = 0;
            for (int innerOutputValue : outputValue) {
                System.out.print(innerOutputValue);
                addComma(arrayReplaceUnluckyNumbers(input1,unluckyNumbersArr,777), iterator, insideIterator);
                insideIterator++;
            }
            System.out.println("");
            iterator++;
        }

        System.out.println("\n\nProblem 7 (Your fortunes):");
        for (iterator = 0; iterator < 4; iterator++) {
            System.out.print(fortunes[iterator]+"\nYour lucky numbers: ");
            int insideIterator = 0;
            for (int outputValue : input1[iterator]) {
                System.out.print(outputValue);
                addComma(input1,iterator,insideIterator);
                insideIterator++;
            }
            System.out.println("\n");
        }
    }
    public static int[] arraySum(int[][] inputArr) { //problem 1
        int iterator = 0;
        int output[] = {0,0,0,0};
        for (int[] idx : inputArr) {
            for (int value : idx) {
                output[iterator] += value;
            }
            iterator++;
        }
        return output;
    }
    public static int arraySumAll(int[][] inputArr) { //problem 2
        int output = 0;
        for (int[] idx : inputArr) {
            for (int value : idx) {
                output += value;
            }
        }
        return output;
    }
    public static int[] arraySmallestValues(int[][] inputArr) {
        int iterator = 0;
        int output[] = {0,0,0,0};
        for (int[] idx : inputArr) {
            int innerIterator = 0;
            for (int value : idx) {
                if (value < output[iterator] || innerIterator == 0) {
                    output[iterator] = value;
                }
                innerIterator++;
            }
            iterator++;
        }
        return output;
    }
    public static int arrayLargestValue(int[][] inputArr) {
        int output = 0;
        for (int[] idx : inputArr) {
            for (int value : idx) {
                if (value > output) {
                    output = value;
                }
            }
        }
        return output;
    }
    public static int[] arrayLargestValueLocation(int[][] inputArr) {
        int output[] = {0,0};
        int largestVal = 0, iterator = 0;
        for (int[] idx : inputArr) {
            int innerIterator = 0;
            for (int value : idx) {
                if (value > largestVal) {
                    largestVal = value;
                    output[0] = iterator;
                    output[1] = innerIterator;
                }
                innerIterator++;
            }
            iterator++;
        }
        return output;
    }
    public static int[][] arrayReplaceUnluckyNumbers(int[][] inputArr, int[] unluckyNums, int luckyNum) {
        int output[][] = {{0,0,0}, {0,0,0}, {0,0}, {0,0,0,0}};
        int iterator = 0;
        for (int[] idx : inputArr) {
            int innerIterator = 0;
            for (int value : idx) {
                for (int oneUnluckyNum : unluckyNums) {
                    if (oneUnluckyNum == value) {
                        output[iterator][innerIterator] = luckyNum;
                        break;
                    } else {
                        output[iterator][innerIterator] = value;
                    }
                }
                innerIterator++;
            }
            iterator++;
        }
        return output;
    }
    public static void addComma(int[] inputArr, int inputIdx) {
        if (inputIdx < inputArr.length-1) {
            System.out.print(", ");
        }
    }
    public static void addComma(int[][] inputArr, int inputIdx, int innerInputIdx) { //overloaded version of addComma for 2d arrays
        if (innerInputIdx < inputArr[inputIdx].length-1) {
            System.out.print(", ");
        }
    }
}