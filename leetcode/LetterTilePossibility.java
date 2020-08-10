import java.util.*;

public class LetterTilePossibility {
    // 주어진 문자열에 있는 문자로 만들수 있는 모든 문자열의 개수를 구하는 문제.
    // 문자의 길이가 길지 않아 그냥 재귀 + 완탐으로 풀었다.
    // used 배열을 이용해 사용여부를 체크하고, characters 배열을 이용해 문자열을 만들어 나갔다.
    // 재귀로 풀땐 꼭 재귀 전/후로 상태값 초기화 해주는걸 잊지 말아야 한다.
    // 이런 문제를 맨날 리스트로 만들고 distinct 를 했는데 그냥 set 을 쓰면 편하다.
    public int numTilePossibilities(String tiles) {
        Set<String> candidates = new HashSet<>();

        int length = tiles.length();
        boolean[] used = new boolean[length];
        char[] characters = new char[length];

        findCandidates(used, characters, tiles, 0, candidates);

        return candidates.size();
    }

    public void findCandidates(boolean[] used, char[] characters, String tiles, int index, Set<String> candidates) {

        String temp = "";
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != Character.MIN_VALUE) {
                temp += characters[i];
            }
        }

        if (temp != "") candidates.add(temp);


        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                characters[index] = tiles.charAt(i);
                used[i] = true;
                findCandidates(used, characters, tiles, index + 1, candidates);
                characters[index] = Character.MIN_VALUE;
                used[i] = false;
            }
        }
    }
}
