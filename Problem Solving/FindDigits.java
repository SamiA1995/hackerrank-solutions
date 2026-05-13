    public static int findDigits(int n) {
        int result = 0;
        String n_string = Integer.toString(n);
        System.out.println(n_string);
        for(int i = 0; i < n_string.length(); i++) {
            int n_2 = Character.getNumericValue(n_string.charAt(i));
            System.out.println(n_2);
            if(n_2 == 0) {
               continue; 
            }
            if(n % n_2 == 0) {
                result++;
            }
        }
        return result;
    }