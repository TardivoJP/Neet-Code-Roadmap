class CompareVersionNumbers {
    public static void main(String[] args) {
        String input1a = "1.01";
        String input1b = "1.001";

        String input2a = "1.0";
        String input2b = "1.0.0";

        String input3a = "0.1";
        String input3b = "1.1";

        String input4a = "7.5.3.0";
        String input4b = "7.5.3";

        System.out.println(compareVersion(input1a, input1b));
        System.out.println(compareVersion(input2a, input2b));
        System.out.println(compareVersion(input3a, input3b));
        System.out.println(compareVersion(input4a, input4b));
        
        //If version1 < version2, return -1.
        //If version1 > version2, return 1.
        //Otherwise, return 0.
    }

    public static int compareVersion(String version1, String version2) {
        int v1 = 0;
        int v2 = 0;

        StringBuilder sbA = new StringBuilder();
        StringBuilder sbB = new StringBuilder();

        while(v1 < version1.length() || v2 < version2.length()){
            int num1 = 0;
            int num2 = 0;

            while(v1 < version1.length()){
                if(version1.charAt(v1) == '.'){
                    v1++;
                    break;
                }
                sbA.append(version1.charAt(v1));
                v1++;
            }

            while(v2 < version2.length()){
                if(version2.charAt(v2) == '.'){
                    v2++;
                    break;
                }
                sbB.append(version2.charAt(v2));
                v2++;
            }
            
            if(sbA.length() > 0){
                num1 = Integer.parseInt(sbA.toString());
                sbA = new StringBuilder();
            }

            if(sbB.length() > 0){
                num2 = Integer.parseInt(sbB.toString());
                sbB = new StringBuilder();
            }

            if(num1 > num2){
                return 1;
            }else if(num1 < num2){
                return -1;
            }
        }

        return 0;
    }
}