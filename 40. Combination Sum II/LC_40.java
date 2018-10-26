public class LC_40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }

        Arrays.sort(candidates);
        List<Integer> combination = new ArrayList<>();
        DFSHelper(results, candidates, combination, target, 0);
        return results;
    }

    public static void DFSHelper(List<List<Integer>> results, int[] candidates, List<Integer> combination, int target, int startIndex) {
        if (target == 0) {
            results.add(new ArrayList<>(combination));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i != startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            combination.add(candidates[i]);
            DFSHelper(results, candidates,combination, target - candidates[i], i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}
