public class ExcelColumnNumber {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            result = result * 26 + (c - 'A' + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        ExcelColumnNumber sol = new ExcelColumnNumber();
        System.out.println(sol.titleToNumber("A"));  
        System.out.println(sol.titleToNumber("AB"));  
        System.out.println(sol.titleToNumber("ZY"));  
    }
}
