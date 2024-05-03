class ValidPalindrome {
    public static void main(String[] args) {
        
        String testcase1 = "A man, a plan, a canal: Panama";
        String testcase2 = "0P";

        System.out.println(isPalindrome(testcase1));
        System.out.println(isPalindrome(testcase2));
    }

    public static boolean isPalindrome(String s) {
        int beginPtr = 0;
        int endPtr = s.length()-1;

        while(beginPtr < endPtr){
            if(!((Character.toLowerCase(s.charAt(beginPtr)) >= 'a' && Character.toLowerCase(s.charAt(beginPtr)) <= 'z') || (s.charAt(beginPtr) >= '0' && s.charAt(beginPtr) <= '9'))){
                beginPtr++;
                continue;
            }

            if(!((Character.toLowerCase(s.charAt(endPtr)) >= 'a' && Character.toLowerCase(s.charAt(endPtr)) <= 'z') || (s.charAt(endPtr) >= '0' && s.charAt(endPtr) <= '9'))){
                endPtr--;
                continue;
            }

            if(Character.toLowerCase(s.charAt(beginPtr)) != Character.toLowerCase(s.charAt(endPtr))){
                return false;
            }

            beginPtr++;
            endPtr--;
        }

        return true;
    }
}