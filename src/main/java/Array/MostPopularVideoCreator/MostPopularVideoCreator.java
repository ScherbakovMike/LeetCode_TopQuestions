package Array.MostPopularVideoCreator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static java.util.Map.Entry.comparingByKey;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class MostPopularVideoCreator {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        var authorViewStat = new HashMap<String, Long>();
        var authorIdStat = new HashMap<String, Map<String, Long>>();
        final var maxViews = new long[]{Integer.MIN_VALUE};
        for (var i = 0; i < ids.length; i++) {
            final var finalI = i;
            authorViewStat.compute(creators[finalI], (key, value) -> {
                        var newValue = 0L;
                        if (value == null) newValue = views[finalI];
                        else newValue = value + views[finalI];
                        if (newValue > maxViews[0]) maxViews[0] = newValue;
                        return newValue;
                    }
            );
            authorIdStat.compute(creators[finalI], (key, value) -> {
                if (value == null) {
                    return new HashMap<>(Map.of(ids[finalI], (long)views[finalI]));
                } else {
                    value.compute(ids[finalI], (key1, value1) -> {
                        if (value1 == null) {
                            return (long)views[finalI];
                        } else {
                            return value1 + views[finalI];
                        }
                    });
                    return value;
                }
            });
        }

        var result = new ArrayList<List<String>>();
        for(var entry:authorIdStat.entrySet()) {
            var author = entry.getKey();
            if(authorViewStat.get(author)!=maxViews[0]) continue;
            var treeSet = new TreeSet<>(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(comparingByKey()));
            treeSet.addAll(authorIdStat.get(author).entrySet());
            var id = treeSet.first().getKey();
            result.add(List.of(author, id));
        }
        return result;
    }

    @Test
    void test() {
        assertThat(mostPopularCreator(new String[]{"alice", "bob", "alice", "chris"},
                        new String[]{"one", "two", "three", "four"}, new int[]{5, 10, 5, 4}),
                containsInAnyOrder(contains("alice", "one"), contains("bob", "two")));
    }

    @Test
    void test2() {
        assertThat(mostPopularCreator(new String[]{"alice", "alice", "alice"},
                        new String[]{"a", "b", "c"}, new int[]{1, 2, 2}),
                contains(contains("alice", "b")));
    }

    @Test
    void test3() throws IOException {
        try (InputStream is = getClass().getResourceAsStream("/Array/MostPopularVideoCreator/test3_data.json")) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(is);

            String[] creators = toStringArray(root.get("creators"));
            String[] ids = toStringArray(root.get("ids"));
            int[] views = toIntArray(root.get("views"));
            String expectedCreator = root.get("expected").get(0).get(0).asText();
            String expectedId = root.get("expected").get(0).get(1).asText();

            assertThat(mostPopularCreator(creators, ids, views),
                    contains(contains(expectedCreator, expectedId)));
        }
    }

    private String[] toStringArray(JsonNode node) {
        String[] arr = new String[node.size()];
        for (int i = 0; i < node.size(); i++) {
            arr[i] = node.get(i).asText();
        }
        return arr;
    }

    private int[] toIntArray(JsonNode node) {
        int[] arr = new int[node.size()];
        for (int i = 0; i < node.size(); i++) {
            arr[i] = node.get(i).asInt();
        }
        return arr;
    }
}
