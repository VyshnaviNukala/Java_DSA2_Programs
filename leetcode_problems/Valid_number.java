class Solution{
public boolean isNumber(String s) {
    String regex = "\\s*[+-]?(\\d+\\.?\\d*|\\.\\d+)([eE][+-]?\\d+)?\\s*";
    return s.matches(regex);
}
}