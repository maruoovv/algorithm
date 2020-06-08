class Trie {

    private boolean isEnd;
    private Trie[] nodes;

    // Trie 를 구현하는 문제.
    // leaf node 여부와 a-z 를 인덱스로 하는 Trie 배열을 갖고 있다.
    public Trie() {
        isEnd = false;
        nodes = new Trie[26];
    }

    // 문자열을 insert 할 때는 각 문자에 해당하는 노드가 null 인지 체크하고 생성해준다.
    // 해당 문자가 마지막 문자일 경우 leafNode 로 설정해준다
    // 아닐 경우 재귀로 insert 를 호출한다.
    public void insert(String word) {
        int index = word.charAt(0) - 'a';

        if (nodes[index] == null) {
            nodes[index] = new Trie();
        }

        if (word.length() == 1) {
            nodes[index].isEnd = true;
            return;
        }

        nodes[index].insert(word.substring(1));

    }

    // search/ startWith 는 각 문자의 노드가 null 인지 확인 후 null 이면 return false.
    // null 이 아닌 경우 한 문자만 남을 때까지 재귀 시킨다.
    // search 의 경우 마지막 문자일 때 해당 노드가 leafNode 인 경우 return true
    // startWith 인 경우 마지막 문자일 때 return true;
    public boolean search(String word) {
        if (word.isEmpty()) return false;

        int index = word.charAt(0) - 'a';
        if (nodes[index] == null) return false;
        else if (word.length() == 1 && nodes[index].isEnd) return true;

        return nodes[index].search(word.substring(1));

    }

    public boolean startsWith(String prefix) {
        if (prefix.isEmpty()) return false;

        int index = prefix.charAt(0) - 'a';
        if (nodes[index] == null) return false;
        else {
            if (prefix.length() == 1) return true;

            return nodes[index].startsWith(prefix.substring(1));
        }
    }
}
