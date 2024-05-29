class NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
    public static void main(String[] args) {
        String s1 = "1101";
        String s2 = "10";
        String s3 = "1";
        String s4 = "1111011110000011100000110001011011110010111001010111110001";
        String s5 = "1111110011101010110011100100101110010100101110111010111110110010";

        System.out.println(numStepsClever(s1));
        System.out.println(numStepsClever(s2));
        System.out.println(numStepsClever(s3));
        System.out.println(numStepsClever(s4));
        System.out.println(numStepsClever(s5));
    }

    // O(n)
    public static int numStepsClever(String s){
        int N = s.length();

        int operations = 0;
        int carry = 0;
        for(int i = N-1; i>0; i--){
            int digit = Character.getNumericValue(s.charAt(i)) + carry;

            if(digit % 2 == 1){
                operations += 2;
                carry = 1;
            }else{
                operations++;
            }
        }

        return operations + carry;
    }

    ////////////////////////////////////////////////////////
    // O(n^2)
    public static int numSteps(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);

        int steps = 0;

        while(sb.length() > 1){
            if(sb.charAt(sb.length() - 1) == '0'){
                sb.setLength(sb.length() - 1);
            }else{
                addOne(sb);
            }

            steps++;
        }

        return steps;
    }

    public static void addOne(StringBuilder sb){
        for(int i=sb.length() - 1; i>=0; i--){
            if(sb.charAt(i) == '0'){
                sb.setCharAt(i, '1');
                return;
            }else{
                sb.setCharAt(i, '0');
            }
        }
        
        sb.insert(0, '1');
    }
}