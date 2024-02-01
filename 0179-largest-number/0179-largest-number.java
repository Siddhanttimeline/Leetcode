class Solution {
    public String largestNumber(int[] nums) {
        String[] stringArr = new String[nums.length];

        int i = 0;
        for (int val : nums) {
            stringArr[i] = String.valueOf(val);
            i++;
        }

        Comparator<String> customComp = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                String order1 = s1 + s2;
                String order2 = s2 + s1;
                return order2.compareTo(order1);
            }
        };

        Arrays.sort(stringArr, customComp);

        StringBuilder result = new StringBuilder();
        for (String str : stringArr) {
            result.append(str);
        }

        if (result.charAt(0) == '0') {
            return "0";
        }

        return result.toString();
    }
}
