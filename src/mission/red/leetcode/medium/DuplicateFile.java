package mission.red.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/find-duplicate-file-in-system
 */
public class DuplicateFile {

    public static void main(String[] args) {
        String[] input = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt"
            + "(efgh)", "root 4.txt(efgh)"};
        System.out.println(new DuplicateFile().findDuplicate(input));
    }

    public List<List<String>> findDuplicate(String[] paths) {

        Map<String, List<String>> contentMap = new HashMap<>();

        Arrays.stream(paths)
            .forEach(x -> {
                String[] splitContent = x.split(" ");
                String path = splitContent[0];

                for (int i = 1; i < splitContent.length; i++) {
                    String filename = getFileName(splitContent[i]);
                    String content = getContent(splitContent[i]);

                    contentMap.putIfAbsent(content, new LinkedList<>());
                    contentMap.get(content).add(path + "/" + filename);
                }
            });

        return contentMap.values().stream()
            .filter(x -> x.size() > 1)
            .collect(Collectors.toList());

    }

    private String getContent(final String input) {
        return input.substring(input.indexOf('(') + 1, input.lastIndexOf(')'));
    }

    private String getFileName(final String input) {
        return input.substring(0, input.indexOf('('));
    }
}
