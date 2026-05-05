class Solution {
    public boolean isPalindrome(String s) {
        // from the start -> string 
        // from the end -> string 
        // O(N) 
        // O(N)

        // s = 'tab a cat'
        //        l   r
        // t == t -> o
        // a == a -> o
        // b !=c -> x
        // non-alphanumerical characters -> 0~9 or 'a'~'z' or 'A'~'Z'(need to convert to lowercase)

        int left = 0, right = s.length()-1;
        while(left<right){
            while(left<right && !isAlphaNumerical(s.charAt(left))) left++;
            while(left<right &&!isAlphaNumerical(s.charAt(right))) right--;
            
            char l = Character.toLowerCase(s.charAt(left));
            char r = Character.toLowerCase(s.charAt(right));
                
            if (l != r) {
                return false;
            }

            left++;
            right--;
            
        }

        return true;
    }

      private boolean isAlphaNumerical(char c) {
          return (c >= '0' && c <= '9')
              || (c >= 'a' && c <= 'z')
              || (c >= 'A' && c <= 'Z');
      }
}
