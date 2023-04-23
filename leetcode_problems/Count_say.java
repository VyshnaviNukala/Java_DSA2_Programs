class Solution {
  public String countAndSay(int n) {
    if (n == 1) {
        return "1";
    }
    String prev = countAndSay(n - 1);
    StringBuilder sb = new StringBuilder();
    int count = 1;
    char prevDigit = prev.charAt(0);
    for (int i = 1; i < prev.length(); i++) {
        char digit = prev.charAt(i);
        if (digit == prevDigit) {
            count++;
        } else {
            sb.append(count).append(prevDigit);
            prevDigit = digit;
            count = 1;
        }
    }
    sb.append(count).append(prevDigit);
    return sb.toString();
}

}