public class PlusOne{
    // Solution
    public static int[] plusOne(int[] digits) {
        for(int i=digits.length-1; i>=0; i--){
            if(digits[i] == 9){
                digits[i] = 0;
            }else{
                digits[i]++;
                return digits;
            }
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
    public static void main(String[] args) {
        int [] digits = {9,9,9,9};
        for(int d : plusOne(digits))
            System.out.print(d);
    }
}