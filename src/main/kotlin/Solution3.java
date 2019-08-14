import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution3 implements Solution {
    @NotNull
    @Override
    public String largestNumber(@NotNull int[] nums) {

//        String[] strs = IntStream.of(nums).mapToObj(String::valueOf).toArray(String[]::new);
//        Arrays.sort(strs, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return (o2+o1).compareTo(o1+o2);
//            }
//        });
//        String res = Arrays.stream(strs).reduce("", (s, t) -> s.equals("0") ? "0" : s+t);

        List<String> strs = IntStream.of(nums).mapToObj(String::valueOf)
                .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2)).collect(Collectors.toList());
        String result = strs.stream().reduce("", (s, t) -> "0".equals(s) ? s : s + t);
        return result;
    }
}
