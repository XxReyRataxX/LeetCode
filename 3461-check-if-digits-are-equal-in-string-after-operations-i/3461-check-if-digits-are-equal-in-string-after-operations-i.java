class Solution {
    public boolean hasSameDigits(String s) {
        char[] datos = s.toCharArray();
        ArrayList<Character> current = new ArrayList<>();

        for (char c : datos) {
            current.add(c);
        }

        while (current.size() > 2) {
            ArrayList<Character> next = new ArrayList<>();
            for (int i = 0; i + 1 < current.size(); i++) {
                int a = current.get(i) - '0';
                int b = current.get(i + 1) - '0';
                char newDigit = (char) (((a + b) % 10) + '0');
                next.add(newDigit);
            }
            current = next;
        }

        return current.get(0).equals(current.get(1));
    }
}
