class Solution {
    public int romanToInt(String s) {
        //Seven roman symbols in a map
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        //Length of input
        int len = s.length();
        
        //If it is a single roman symbol --> return value from map
        if(len==1){
            return map.get(s.charAt(0));
        }
        
        int sum = 0;
        int i=0;
        
        //Check each roman symbol
        //if suffix is greater, then subract, else add
        for(i=0;i<len-1;i++){
            if(map.get(s.charAt(i+1))>map.get(s.charAt(i)) && (s.charAt(i)!='V' && s.charAt(i)!='L' && s.charAt(i)!='D')) {
                if(s.charAt(i+1)=='V' || s.charAt(i+1)=='X'){
                    sum+=map.get(s.charAt(i+1))-1;
                    i++;
                }else if(s.charAt(i+1)=='L' || s.charAt(i+1)=='C'){
                    sum+=map.get(s.charAt(i+1))-10;
                    i++;
                }else{
                    sum+=map.get(s.charAt(i+1))-100;
                    i++;
                }
            }else{
                sum+=map.get(s.charAt(i));
            }
        }
        
        if(i<len && s.charAt(i)!='\0'){
            sum+=map.get(s.charAt(i));
        }
        
        return sum;
    }
}