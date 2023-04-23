class Solution {
   public String multiply(String num1, String num2) {
    int n = num1.length(), m = num2.length();
    int[] prod = new int[n + m];
    
    for (int i = n - 1; i >= 0; i--) {
        for (int j = m - 1; j >= 0; j--) {
            int p = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            int sum = p + prod[i + j + 1];
            prod[i + j + 1] = sum % 10;
            prod[i + j] += sum / 10;
        }
    }
    
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < prod.length; i++) {
        if (sb.length() == 0 && prod[i] == 0) {
            continue;
        }
        sb.append(prod[i]);
    }
    return sb.length() == 0 ? "0" : sb.toString();
}

}