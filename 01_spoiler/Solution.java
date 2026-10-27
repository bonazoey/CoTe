import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;

        // 단어 조립
        StringBuilder sb = new StringBuilder();

        // 스포일러 진입 플래그
        boolean isSpo = false;
        // 현 스포일러 인덱스
        int spoIdx = 0;
        // 임시 중요 플래그
        boolean imp = false;
        Set<String> tmp = new HashSet<>();

        // 메시지를 음절로 자른 배열
        String[] arr = message.split("");
        // 단어 모음
        Set<String> set = new HashSet<>();

        // 한 음절씩 돌기
        for (int i = 0; i < arr.length; i++) {
            System.out.println("음절 : " + arr[i] + ", 스포 : " + isSpo);
            if (!isSpo) { // 스포 범위 아닐 때
                // 스포 범위 안에 들어왔을 때
                if (spoiler_ranges[spoIdx][0] == i) {
                    isSpo = true;
                }
            }

            if (!arr[i].equals(" ")) { // 공백이 아닌 문자일 때
                if (isSpo) { // 스포 범위라면
                    while (i < arr.length && !arr[i].equals(" ")) { // 다음 공백 전까지 단어 합치기
                        sb.append(arr[i]);
                        i++;
                    }
                } else { // 스포 범위 밖이면
                    sb.append(arr[i]); // 단어 조립
                }
            }
            // 공백일 때
            System.out.println("단어 : " + sb.toString());
            if (!set.contains(sb.toString())) { // 단어 리스트에 없으면
                if (isSpo) { // 중요 단어 체크
                    imp = true;
                    tmp.add(sb.toString()); // 임시 리스트에 넣기
                    sb.setLength(0);
                    if (i >= spoiler_ranges[spoIdx][1] && imp) { // 
                        answer++;
                        imp = false;
                    }
                } else {
                    set.add(sb.toString());
                }
            } else { // 리스트에 있으면
                if (isSpo) {
                    tmp.clear();
                }
            }

            // 스포 범위 밖 설정
            if (i >= spoiler_ranges[spoIdx][1]) {
                spoIdx++;
                isSpo = false;
                for (String s : tmp) { // 임시 리스트를 단어 리스트에 옮기기
                    set.add(s);
                }
                tmp.clear();
                if (spoIdx >= spoiler_ranges.length) {
                    break;
                }
            }
        }

        return answer;
    }
}