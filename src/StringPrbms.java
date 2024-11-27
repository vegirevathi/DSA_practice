import java.util.Arrays;

public class StringPrbms {

    static String removeOuterParanthesis(String input) {
        StringBuilder sb = new StringBuilder();
        int braceCount=0;
        int startIndex=0;
        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            if(ch=='('){
                braceCount++;
            } else{
                braceCount--;
            }
            if(braceCount==0){
                sb.append(input, startIndex+1, i);
                startIndex=i+1;
            }
        }
        return sb.toString();
    }

    static String reverseWords(String input){
        StringBuilder sb=new StringBuilder();
        String[] wordsArray= input.split(" ");
        for(int i=0;i< wordsArray.length;i++){
            sb.append(wordsArray[wordsArray.length-i-1]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    static String largestOddNumber(String input){
        for(int i=input.length();i>0;i--){
            if(Integer.valueOf(input.substring(0,i))%2!=0){
                return input.substring(0,i);
            }
        }
        return "";
    }

    static String longestCommonPrefix(String[] input){
        StringBuilder sb=new StringBuilder();
        int inputSize= input.length;
        int minLength=input[0].length();
        for(int i=1;i<inputSize;i++){
            if(input[i].length()<minLength){
                minLength=input[i].length();
            }
        }
        for(int i=0;i<minLength;i++){
            if(input[0].charAt(i)==input[1].charAt(i) && input[0].charAt(i)==input[2].charAt(i) ){
                sb.append(input[i].charAt(i));
            }
        }
        return sb.toString();
    }

    static boolean rotateString(String s, String goal){
        String s1=s.concat(s);
        if(s.length()!=goal.length()){
            return false;
        }
        return s1.contains(goal);
    }

    static String longestCommonPrefix2(String[] arr){
        Arrays.sort(arr);
        String first = arr[0];
        String last = arr[arr.length - 1];
        int minLength = Math.min(first.length(),
                last.length());
        int i = 0;
        while (i < minLength &&
                first.charAt(i) == last.charAt(i)) {
            i++;
        }
        return first.substring(0, i);
    }

    public static void main(String[] args){
        boolean output=rotateString("abcde", "cdeab");
        System.out.print("Is rotated string "+output);

//        String[] input={"flower","flow","flight"};
//        System.out.print(longestCommonPrefix2(input));
//        String output=removeOuterParanthesis("(()())(())");
//        System.out.print("String after removing outer paranthesis "+output);

//        String sentence="the sky is blue";
//        System.out.print(reverseWords(sentence));

//        String number="4206";
//        System.out.print("largest odd substring "+largestOddNumber(number));
    }
}
