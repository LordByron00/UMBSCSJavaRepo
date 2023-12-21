package DSA_Carlo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort {

    public static List<People> mergeSort(List<People> people, Comparator<People> comparator) {
        return mergeSortHelper(new ArrayList<People>(people), comparator);
    }

    public static List<People> mergeSortHelper(List<People> people, Comparator<People> comparator) {
        if (people.size() <= 1) {
            return people;
        }

        int mid = people.size() / 2;
        List<People> left = mergeSortHelper(new ArrayList<>(people.subList(0, mid)), comparator);
        List<People> right = mergeSortHelper(new ArrayList<>(people.subList(mid, people.size())), comparator);

        return merge(left, right, comparator);
    }

    public static List<People> merge(List<People> left, List<People> right, Comparator<People> comparator) {
        List<People> merged = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (comparator.compare(left.get(leftIndex), right.get(rightIndex)) <= 0) {
                merged.add(left.get(leftIndex++));
            } else {
                merged.add(right.get(rightIndex++));
            }
        }

        while (leftIndex < left.size()) {
            merged.add(left.get(leftIndex++));
        }
        while (rightIndex < right.size()) {
            merged.add(right.get(rightIndex++));
        }
        return merged;
    }
}
