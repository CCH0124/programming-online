public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char [] achar = a.toCharArray();
        char [] bchar = b.toCharArray();
        int alen = achar.length;
        int blen = bchar.length;
        int result = 0, carry = 0; 
        while (alen >0 || blen >0) {
            int aInt = (alen > 0) ? Character.getNumericValue(achar[--alen]) : 0; 
            int bInt = (blen > 0) ? Character.getNumericValue(bchar[--blen]) : 0;
            if(carry == 0){
                sb.append((aInt+bInt)%2);
                if((aInt+bInt) == 2)
                    carry = 1;
            }else{
                sb.append((aInt + bInt + carry) % 2);
                if ((aInt + bInt == 1) || (aInt + bInt == 2))
                    carry = 1;
                else
                    carry = 0;
            }
        }
        if(carry == 1)
            sb.append(1);

        return sb.reverse().toString();
    }
