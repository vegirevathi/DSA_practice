import java.util.*;

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

    static boolean isIsomorphic(String s, String t){
        if(s.length()!=t.length()) {
            return false;
        }
        Map<Character, Character> stringMap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(stringMap.containsKey(t.charAt(i))){
                t=t.replace(t.charAt(i), stringMap.get(t.charAt(i)));
            } else {
                stringMap.put(t.charAt(i), s.charAt(i));
                t=t.replace(t.charAt(i), s.charAt(i));
            }
        }
        if(s.equals(t)){
            return true;
        } else{
            return false;
        }
    }

    static boolean isAnagram(String s, String t){
        String s1 = getSortedString(s);
        String t1 = getSortedString(t);
        return s1.equals(t1)?true:false;
    }

    static String getSortedString(String s){
        char sc[] =s.toCharArray();
        Arrays.sort(sc);
        return new String(sc);
    }

    static String sortByFrequency(String s){
        Map<Character, Integer> frequencyMap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            frequencyMap.put(s.charAt(i), frequencyMap.getOrDefault(s.charAt(i), 0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );

        pq.addAll(frequencyMap.entrySet());

        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            result.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }

        return result.toString();
    }

    static int depthOfParanthesis(String s){
        int count=0;
        int maxCount=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                count++;
            } else if(c==')'){
                count--;
            } else{
                continue;
            }
            maxCount=count>maxCount?count:maxCount;
        }
        return maxCount;
    }

    static int romanToInt(String s) {
        Map<Character,Integer> romanMap=new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);
        int total=0;
        int length=s.length();
        for(int i=0;i<length;i++){
            if(i<length-1 && romanMap.get(s.charAt(i))<romanMap.get(s.charAt(i+1))){
                total-=romanMap.get(s.charAt(i));
            } else {
                total+=romanMap.get(s.charAt(i));
            }
        }
        return total;
    }

    static int stringToIntegerAtoi(String s){
        char ch=s.charAt(0);
        boolean isDigitStarted=false;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ') {
                continue;
            } else if((!isDigitStarted && s.charAt(i)=='0')) {
                isDigitStarted=true;
            } else if(!isDigitStarted && s.charAt(i)=='-'){
                sb.append(s.charAt(i));
            } else if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                sb.append(s.charAt(i));
                isDigitStarted=true;
            } else {
                break;
            }
        }
        sb.toString().stripLeading().trim();
        if(sb.length()==0){
            return 0;
        }
        return Integer.valueOf(sb.toString());
    }

    static String longestPalindrome(String s){
        int l=s.length();
        int maxCount=0;
        String longest="";
        for(int i=0;i<l;i++){
            for(int j=i;j<l;j++){
                String substr = s.substring(i, j + 1);

                // Check if the substring is a palindrome
                if (substr.equals(new StringBuilder(substr).reverse().toString()) && substr.length() > maxCount) {
                    longest = substr;
                    maxCount = substr.length();  // Update maxCount to the length of the longest palindrome found
                }
            }
        }
        return longest;
    }

    static int sumOfBeautyOfSubstrings(String s){
        int beautySum=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String sb=s.substring(i,j+1);
                beautySum+=findBeautyOfString(sb);
            }
        }
        return beautySum;
    }

    static int findBeautyOfString(String str) {
        //beauty is diff btw most and least frequent characters.
        if (str == null || str.length() == 0) {
            return 0;
        }
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;

        for (int freq : frequencyMap.values()) {
            if (freq > maxFreq) {
                maxFreq = freq;
            }
            if (freq < minFreq) {
                minFreq = freq;
            }
        }
        return maxFreq - minFreq;
    }

    public static void main(String[] args){
        int beauty=sumOfBeautyOfSubstrings("aabcbaa");
        System.out.println("beauty value: "+beauty);

        String output=longestPalindrome("babad");
        System.out.print("longest palindrome : "+output);

//        int output=stringToIntegerAtoi(" -067");
//        System.out.print("Integer value: "+output);

//        int output=romanToInt("MCMXCIV");
//        System.out.print("Integer value of roman is : "+output);

//        int output=depthOfParanthesis("(1)+((2))+(((3)))");
//        System.out.print("Depth of paranthesis "+output);
//        String output=sortByFrequency("accacc");
//        System.out.print("Sorted by frequency  : "+output);

//        boolean output=isAnagram("act", "cate");
//        System.out.print("Is anagram : "+output);
//        boolean output=rotateString("abcde", "cdeab");
//        System.out.print("Is rotated string "+output);

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
