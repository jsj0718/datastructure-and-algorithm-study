package programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.assertThat;

public class Level2Test {

    @Test
    @DisplayName("최대 2명을 탈 수 있는 보트에서 무게 제한이 있을 때 최소한의 보트를 구하는 문제")
    void 구명보트() {
        //given
        int[] people = {70, 50, 80, 50};
        int limit = 100;

        //when
        Arrays.sort(people);

        int pointer = 0;
        for (int i = people.length - 1; i > pointer; i--) {
            if (people[pointer] + people[i] <= limit) pointer++;
        }

        //then
        assertThat(people.length - pointer).isEqualTo(3);
    }

    @Test
    void H_Index() {
        //given
        int[] citations = {3, 0, 6, 1, 5};
        int result = 3;

        //when
        int[] sortedCitations = Arrays.stream(citations)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue).toArray();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < sortedCitations.length; i++) {
            int min = Math.min(sortedCitations[i], i + 1);
            if (max < min) max = min;
        }

        //then
        assertThat(max).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource(value = "짝지어_제거하기_데이터")
    void 짝지어_제거하기(String s, int result) {
        //when
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.push(c);
        }

        int answer = (stack.isEmpty()) ? 1 : 0;

        //then
        assertThat(answer).isEqualTo(result);
    }

    static Stream<Arguments> 짝지어_제거하기_데이터() {
        return Stream.of(
                Arguments.of("baabaa", 1),
                Arguments.of("cdcd", 0)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "일차_캐시_데이터")
    void 일차_캐시(int cacheSize, String[] cities, int result) {
        //when
        int answer = 0;

        LinkedList<String> lru = new LinkedList<>();
        for (String city : cities) {
            city = city.toLowerCase();
            if (lru.contains(city)) {
                answer++;
                lru.remove(city);
                lru.addFirst(city);
            } else {
                answer += 5;
                lru.addFirst(city);
                if (lru.size() > cacheSize) lru.remove(cacheSize);
            }
        }

        //then
        assertThat(answer).isEqualTo(result);
    }

    static Stream<Arguments> 일차_캐시_데이터() {
        return Stream.of(
                Arguments.of(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}, 50),
                Arguments.of(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}, 21),
                Arguments.of(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}, 60),
                Arguments.of(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}, 52),
                Arguments.of(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}, 16),
                Arguments.of(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}, 25)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "전화번호_목록_데이터")
    @DisplayName("전화번호 목록 - 접두사 확인")
    void 전화번호_목록(String[] phone_book, boolean result) {
        //when
        boolean answer = true;

        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(phone_book).forEach(s -> map.put(s, 1));

        for (String s : phone_book) {
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.substring(0, i))) answer = false;
            }
        }

        //then
        assertThat(answer).isEqualTo(result);
    }

    static Stream<Arguments> 전화번호_목록_데이터() {
        return Stream.of(
                Arguments.of(new String[]{"119", "97674223", "1195524421"}, false),
                Arguments.of(new String[]{"123", "456", "789"}, true),
                Arguments.of(new String[]{"12", "123", "1235", "567", "88"}, false)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "위장_데이터")
    @DisplayName("위장 - 서로 다른 종류 조합하는 방법")
    void 위장V1(String[][] clothes, int result) {
        //when
        Map<String, Integer> map = new HashMap<>();

        Arrays.stream(clothes).forEach(array -> map.put(array[1], map.getOrDefault(array[1], 0) + 1));

        int[] array = map.values().stream().mapToInt(Integer::intValue).toArray();

        int answer = 1;
        for (int i = 0; i < array.length; i++) {
            answer *= (1 + array[i]);
        }

        //then
        assertThat(answer - 1).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource(value = "위장_데이터")
    @DisplayName("위장 - 서로 다른 종류 조합하는 방법")
    void 위장V2(String[][] clothes, int result) {
        //when

        //배열 -> Map, Map의 Value -> 연산 후 값 반환
        int answer = Arrays.stream(clothes)
                .collect(Collectors.groupingBy(p -> p[1], Collectors.mapping(p -> p[0], counting())))
                .values().stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;

        //then
        assertThat(answer).isEqualTo(result);
    }

    static Stream<Arguments> 위장_데이터() {
        return Stream.of(
                Arguments.of(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}, 5),
                Arguments.of(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "베스트앨범_데이터")
    @DisplayName("베스트앨범 - 총 플레이 양이 많은 장르 순서대로 각 장르별 노래를 플레이 순으로 최대 2개까지 나열 (동일하면 index 낮은 순서)")
    void 베스트앨범(String[] genres, int[] plays, int[] result) {
        //when
        Map<String, Map<Integer, Integer>> genreMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            Map<Integer, Integer> map = genreMap.getOrDefault(genres[i], new HashMap<>());
            map.put(i, plays[i]);
            genreMap.put(genres[i], map);
        }

        //then

    }

    static Stream<Arguments> 베스트앨범_데이터() {
        return Stream.of(
                Arguments.of(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500}, new int[]{4, 1, 3, 0})
        );
    }

    @ParameterizedTest
    @MethodSource(value = "기능개발_데이터")
    @DisplayName("기능개발 - 큐를 사용하여 문제 해결")
    void 기능개발V1(int[] progresses, int[] speeds, int[] result) {
        //when
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        IntStream.range(0, progresses.length).forEach(i -> q.add((int) Math.ceil((double) (100 - progresses[i]) / speeds[i])));

        while (!q.isEmpty()) {
            int time = q.peek();
            int cnt = 0;
            while (!q.isEmpty() && time >= q.peek()) {
                q.poll();
                cnt++;
            }
            list.add(cnt);
        }

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();

        //then
        assertThat(answer).contains(result);
    }

    @ParameterizedTest
    @MethodSource(value = "기능개발_데이터")
    @DisplayName("기능개발 - 큐를 사용하여 문제 해결")
    void 기능개발V2(int[] progresses, int[] speeds, int[] result) {
        //when
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        IntStream.range(0, progresses.length).forEach(i -> {
            int restTime = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            if (!q.isEmpty() && restTime > q.peek()) {
                list.add(q.size());
                q.clear();
            }
            q.add((int) Math.ceil((double) (100 - progresses[i]) / speeds[i]));
        });
        list.add(q.size());

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();

        //then
        assertThat(answer).contains(result);
    }

    static Stream<Arguments> 기능개발_데이터() {
        return Stream.of(
                Arguments.of(new int[]{93, 30, 55}, new int[]{1, 30, 5}, new int[]{2, 1}),
                Arguments.of(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}, new int[]{1, 3, 2})
        );
    }

    @ParameterizedTest
    @MethodSource(value = "프린터_데이터")
    void 프린터(int[] priorities, int location, int result) {
        //when
        Queue<Integer> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.stream(priorities).forEach(i -> {
            q.add(i);
            pq.add(i);
        });

        int answer = 0;
        while (!q.isEmpty()) {
            if (q.peek() == pq.peek()) {
                q.poll();
                pq.poll();
                answer++;
                if (--location < 0) break;
            } else {
                q.add(q.poll());
                if (--location < 0) location = q.size() - 1;
            }
        }

        //then
        assertThat(answer).isEqualTo(result);
    }

    static Stream<Arguments> 프린터_데이터() {
        return Stream.of(
                Arguments.of(new int[]{2, 1, 3, 2}, 2, 1),
                Arguments.of(new int[]{1, 1, 9, 1, 1, 1}, 0, 5)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "다리를_지나는_트럭_데이터")
    void 다리를_지나는_트럭(int bridge_length, int weight, int[] truck_weights, int result) {
        //when
        Queue<Integer> waitingQueue = new LinkedList<>();
        Queue<Integer> bridgeQueue = new LinkedList<>();

        Arrays.stream(truck_weights).forEach(i -> waitingQueue.add(i));
        IntStream.range(0, bridge_length).forEach(i -> bridgeQueue.add(0));

        int time = 0;
        int totalWeight = 0;
        while (true) {
            totalWeight -= bridgeQueue.poll();

            if (waitingQueue.isEmpty()) {
                time += bridge_length;
                break;
            }

            if (totalWeight + waitingQueue.peek() <= weight) {
                Integer afterTruckWeight = waitingQueue.poll();
                bridgeQueue.add(afterTruckWeight);
                totalWeight += afterTruckWeight;
            } else {
                bridgeQueue.add(0);
            }

            time++;
        }

        //then
        assertThat(time).isEqualTo(result);
    }

    static Stream<Arguments> 다리를_지나는_트럭_데이터() {
        return Stream.of(
                Arguments.of(2, 10, new int[]{7, 4, 5, 6}, 8),
                Arguments.of(100, 100, new int[]{10}, 101),
                Arguments.of(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, 110)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "뉴스_클러스터링_데이터")
    @DisplayName("뉴스 클러스터링 - 자카드 유사도 활용")
    void 뉴스_클러스터링(String str1, String str2, int result) {
        //when
        Map<String, Long> str1Map = IntStream.range(0, str1.length() - 1)
                .mapToObj(i -> str1.substring(i, i + 2).toLowerCase())
                .filter(s -> Pattern.matches("^[a-z]*$", s))
                .collect(groupingBy(Function.identity(), counting()));

        Map<String, Long> str2Map = IntStream.range(0, str2.length() - 1)
                .mapToObj(i -> str2.substring(i, i + 2).toLowerCase())
                .filter(s -> Pattern.matches("^[a-z]*$", s))
                .collect(groupingBy(Function.identity(), counting()));

        HashSet<String> keySet = new HashSet<>() {{
            addAll(str1Map.keySet());
            addAll(str2Map.keySet());
        }};

        int numerator = 0;
        int denominator = 0;
        for (String s : keySet) {
            numerator += Math.min(str1Map.getOrDefault(s, 0L), str2Map.getOrDefault(s, 0L));
            denominator += Math.max(str1Map.getOrDefault(s, 0L), str2Map.getOrDefault(s, 0L));
        }

        int answer = 65536;
        if (denominator != 0) answer = (int) Math.floor((double) numerator / denominator * answer);

        //then
        assertThat(answer).isEqualTo(result);
    }

    static Stream<Arguments> 뉴스_클러스터링_데이터() {
        return Stream.of(
                Arguments.of("FRANCE", "french", 16384),
                Arguments.of("handshake", "shake hands", 65536),
                Arguments.of("aa1+aa2", "AAAA12", 43690),
                Arguments.of("E=M*C^2", "e=m*c^2", 65536)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "n제곱_배열_자르기_데이터")
    @DisplayName("n제곱_배열_자르기_V1 - 2차원 배열 생성하여 풀이 시도했지만 메모리 초과")
    void n제곱_배열_자르기_V1(int n, int left, int right, int[] result) {
        //when
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = arr[j][i] = i + 1;
            }
        }

        //2차원 배열 출력
        System.out.println(Arrays.deepToString(arr));

        //평탄화
        int[] flatArr = Arrays.stream(arr).flatMapToInt(a -> Arrays.stream(a)).toArray();

        System.out.println(Arrays.toString(flatArr));

        int[] answer = Arrays.copyOfRange(flatArr, left, right + 1);

        //then
        assertThat(answer).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource(value = "n제곱_배열_자르기_데이터")
    @DisplayName("n제곱_배열_자르기_V2 - 규칙을 찾아서 해결")
    void n제곱_배열_자르기_V2(int n, int left, int right, int[] result) {
        //when
        int len = right - left + 1;
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            int row = left / n + 1;
            int col = left % n + 1;

            answer[i] = (row > col) ? row : col;
            left++;
        }

        //then
        assertThat(answer).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource(value = "n제곱_배열_자르기_데이터")
    @DisplayName("n제곱_배열_자르기_V3 - Stream 활용")
    void n제곱_배열_자르기_V3(int n, int left, int right, int[] result) {
        //when
        int[] answer = LongStream.rangeClosed(left, right).mapToInt(i -> (int) (Math.max((i / n), (i % n)) + 1)).toArray();

        //then
        assertThat(answer).isEqualTo(result);
    }


    static Stream<Arguments> n제곱_배열_자르기_데이터() {
        return Stream.of(
                Arguments.of(3, 2, 5, new int[]{3, 2, 2, 3}),
                Arguments.of(4, 7, 14, new int[]{4, 3, 3, 3, 4, 4, 4, 4})
        );
    }

    @ParameterizedTest
    @MethodSource(value = "주차_요금_계산_데이터")
    void 주차_요금_계산(int[] fees, String[] records, int[] result) {
        //when
        Map<String, Parking> parkingMap = new HashMap<>();

        for (String record : records) {
            String[] recordSplit = record.split(" ");
            String time = recordSplit[0];
            String carNumber = recordSplit[1];
            String entranceAndExit = recordSplit[2];

            if (!parkingMap.containsKey(carNumber)) {
                parkingMap.put(carNumber, new Parking(carNumber, time));
            } else if (entranceAndExit.equals("IN")) {
                parkingMap.get(carNumber).parkingCar(time);
            } else if (entranceAndExit.equals("OUT")) {
                parkingMap.get(carNumber).exitCar(time);
            }
        }

        parkingMap.keySet().stream().filter(key -> parkingMap.get(key).isParking)
                .forEach(key -> parkingMap.get(key).accParkingTime("23:59"));

        System.out.println(parkingMap);

        int[] answer = Arrays.stream(parkingMap.keySet().stream().sorted().toArray(String[]::new))
                .mapToInt(key -> parkingMap.get(key).calculateFee(fees))
                .toArray();

        //then
        assertThat(answer).isEqualTo(result);
    }

    static class Parking {
        private String carNumber;
        private String parkingRecord;
        private boolean isParking;
        private int totalParkingTime;

        public Parking(String carNumber, String parkingRecord) {
            this.carNumber = carNumber;
            this.parkingRecord = parkingRecord;
            this.isParking = true;
        }

        public void accParkingTime(String exitRecord) {
            String[] splitParkingRecord = parkingRecord.split(":");
            String[] splitExitRecord = exitRecord.split(":");
            int hour = (Integer.parseInt(splitExitRecord[0]) - Integer.parseInt(splitParkingRecord[0])) * 60;
            int minute = (Integer.parseInt(splitExitRecord[1]) - Integer.parseInt(splitParkingRecord[1]));
            this.totalParkingTime += (hour + minute);
        }

        public void parkingCar(String inRecord) {
            this.parkingRecord = inRecord;
            this.isParking = true;
        }

        public void exitCar(String exitRecord) {
            accParkingTime(exitRecord);
            this.parkingRecord = exitRecord;
            this.isParking = false;
        }

        public int calculateFee(int[] fees) {
            if (totalParkingTime <= fees[0]) return fees[1];
            int extraTime = totalParkingTime - fees[0];
            return fees[1] + (int) Math.ceil((double) extraTime / fees[2]) * fees[3];
        }

        @Override
        public String toString() {
            return "Parking{" +
                    "carNumber='" + carNumber + '\'' +
                    ", parkingRecord='" + parkingRecord + '\'' +
                    ", isParking=" + isParking +
                    ", totalParkingTime=" + totalParkingTime +
                    '}';
        }
    }

    static Stream<Arguments> 주차_요금_계산_데이터() {
        return Stream.of(
                Arguments.of(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}, new int[]{14600, 34400, 5000}),
                Arguments.of(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"}, new int[]{0, 591}),
                Arguments.of(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"}, new int[]{14841})
        );
    }

    @ParameterizedTest
    @MethodSource(value = "오픈채팅방_데이터")
    void 오픈채팅방(String[] record, String[] result) {
        //when
        List<String[]> logs = new ArrayList<>();
        HashMap<String, String> userIdAndNicknameMap = new HashMap<>();

        for (String log : record) {
            String[] data = log.split(" ");
            String status = data[0];
            String userId = data[1];

            if (status.equals("Enter")) {
                logs.add(new String[]{status, userId});
                userIdAndNicknameMap.put(userId, data[2]);
            } else if (status.equals("Leave")) {
                logs.add(new String[]{status, userId});
            } else if (status.equals("Change")) {
                userIdAndNicknameMap.put(userId, data[2]);
            }
        }

        logs.forEach(strings -> System.out.println(Arrays.toString(strings)));
        System.out.println(userIdAndNicknameMap);

        String[] answer = logs.stream()
                .map(strings -> userIdAndNicknameMap.get(strings[1]) + "님이 " + (strings[0].equals("Enter") ? "들어왔습니다." : "나갔습니다."))
                .toArray(String[]::new);
        //then
        assertThat(answer).isEqualTo(result);
    }

    static Stream<Arguments> 오픈채팅방_데이터() {
        return Stream.of(
                Arguments.of(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"}, new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."})
        );
    }

    @ParameterizedTest
    @MethodSource(value = "압축_3차_데이터")
    void 압축_3차(String msg, int[] result) {
        //when
        List<Integer> answer = new ArrayList<>();

        List<String> list = new ArrayList<>();
        IntStream.range(0, 26).forEach(i -> list.add(String.valueOf((char) (i + 65))));

        Queue<String> queue = new LinkedList<>(Arrays.stream(msg.split("")).collect(Collectors.toList()));
        while (!queue.isEmpty()) {
            String s = queue.poll();
            while (!queue.isEmpty() && list.contains(s + queue.peek())) {
                s += queue.poll();
            }
            list.add(s + queue.peek());
            answer.add(list.indexOf(s) + 1);
        }

        //then
        assertThat(answer.stream().mapToInt(Integer::intValue).toArray()).isEqualTo(result);
    }

    static Stream<Arguments> 압축_3차_데이터() {
        return Stream.of(
                Arguments.of("KAKAO", new int[]{11, 1, 27, 15}),
                Arguments.of("TOBEORNOTTOBEORTOBEORNOT", new int[]{20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34}),
                Arguments.of("ABABABABABABABAB", new int[]{1, 2, 27, 29, 28, 31, 30})
        );
    }

    int 피로도_answer = 0;
    boolean[] 피로도_visited;

    @ParameterizedTest
    @MethodSource(value = "피로도_데이터")
    void 피로도(int k, int[][] dungeons, int result) {
        //when
        피로도_visited = new boolean[dungeons.length];
        피로도_dfs(dungeons, k, 0);
        //then
        assertThat(피로도_answer).isEqualTo(result);
    }

    void 피로도_dfs(int[][] dungeons, int k, int depth) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!피로도_visited[i] && k >= dungeons[i][0]) {
                피로도_visited[i] = true;
                피로도_dfs(dungeons, k - dungeons[i][1], depth + 1);
                피로도_visited[i] = false;
            }
        }
        피로도_answer = Math.max(피로도_answer, depth);
    }

    static Stream<Arguments> 피로도_데이터() {
        return Stream.of(
                Arguments.of(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}, 3),
                Arguments.of(40, new int[][]{{40, 20}, {10, 10}, {10, 10}, {10, 10}, {10, 10}}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "두개_이하로_다른_비트_데이터")
    void 두개_이하로_다른_베트(int[] numbers, int[] result) {
        //when
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            int origin = numbers[i];
            int n = origin;
            while (true) {
                int diffBitCount = getDiffBitCount(origin, ++n);
                if (diffBitCount <= 2) break;
            }
            answer[i] = n;
        }

        //then
        System.out.println(Arrays.toString(answer));
    }

    int getDiffBitCount(int num1, int num2) {
        String s1 = Integer.toBinaryString(num1);
        String s2 = Integer.toBinaryString(num2);
        int diffLength = Math.abs(s1.length() - s2.length());

        if (s1.length() > s2.length()) {
            s2 = "0".repeat(diffLength) + s2;
        } else if (s2.length() > s1.length()) {
            s1 = "0".repeat(diffLength) + s1;
        }

        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) count++;
        }
        return count;
    }

    static Stream<Arguments> 두개_이하로_다른_비트_데이터() {
        return Stream.of(
                Arguments.of(new int[]{2, 7}, new int[]{3, 11})
        );
    }

    int[] answer;
    int count = 0;

    @Test
    void unitTest() {
        //given
        int n = 3;
        long k = 5;

        //when
        int[] numbers = IntStream.rangeClosed(1, n).toArray();
        boolean[] visited = new boolean[numbers.length];

        permutation(numbers, visited, k, 0);

        System.out.println("answer: " + Arrays.toString(answer));
    }

    void permutation(int[] numbers, boolean visited[], long k, int depth) {
        if (depth == numbers.length) {
            if (++count == k) {
                answer = Arrays.copyOf(numbers, numbers.length);
            }
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            numbers[depth] = i + 1;
            permutation(numbers, visited, k, depth + 1);
            numbers[depth] = 0;
            visited[i] = false;
        }
    }


    @ParameterizedTest
    @MethodSource(value = "전력망을_둘로_나누기_데이터")
    void 전력망을_둘로_나누기(int n, int[][] wires, int result) {
        //when
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            answer = Math.min(answer, 전력망_bfs(wires, new boolean[n + 1], n, i));
        }

        //then
        assertThat(answer == Integer.MAX_VALUE ? 0 : answer).isEqualTo(result);
    }

    int 전력망_bfs(int[][] wires, boolean[] visited, int n, int idx) {
        visited[1] = true;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < wires.length; i++) {
            if (i == idx) continue;
            int[] wire = wires[i];
            if (wire[0] == 1) queue.add(wire[1]);
            if (wire[1] == 1) queue.add(wire[0]);
        }

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            visited[node] = true;

            for (int i = 0; i < wires.length; i++) {
                if (i == idx) continue;

                int[] wire = wires[i];
                if (wire[0] == node && !visited[wire[1]]) queue.add(wire[1]);
                if (wire[1] == node && !visited[wire[0]]) queue.add(wire[0]);
            }
        }

        int cnt = 0;
        for (boolean v : visited) {
            if (v) cnt++;
        }

        return Math.abs(n - 2 * cnt);
    }

    static Stream<Arguments> 전력망을_둘로_나누기_데이터() {
        return Stream.of(
                Arguments.of(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}, 3),
                Arguments.of(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}, 0),
                Arguments.of(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "줄_서는_방법_데이터")
    void 줄_서는_방법(int n, long k, int[] result) {
        //when
        int[] answer = new int[n];

        List<Integer> numbers = IntStream.rangeClosed(1, n).mapToObj(Integer::valueOf).collect(toList());

        dfs(answer, numbers, n, k - 1, 0);

        //then
        assertThat(answer).isEqualTo(result);
    }

    void dfs(int[] answer, List<Integer> numbers, int n, long k, int depth) {
        if (depth == answer.length) return;

        int idx = (int) (k / factorial(n - 1));
        answer[depth] = numbers.remove(idx);
        dfs(answer, numbers, n - 1, k % factorial(n - 1), depth + 1);
    }

    int factorial(int n) {
        if (n < 2) return 1;
        return n * factorial(n - 1);
    }

    @ParameterizedTest
    @MethodSource(value = "줄_서는_방법_데이터")
    void 줄_서는_방법V2(int n, long k, int[] result) {
        //when
        int[] answer = new int[n];

        List<Integer> numbers = IntStream.rangeClosed(1, n).mapToObj(Integer::valueOf).collect(Collectors.toList());

        long factorial = factorialV2(n);

        k--;
        int idx = 0;
        while (idx < n) {
            factorial /= (n - idx);
            answer[idx++] = numbers.remove((int) (k / factorial));
            k %= factorial;
        }

        //then
        assertThat(answer).isEqualTo(result);
    }

    long factorialV2(int n) {
        if (n < 2) return 1;
        return n * factorialV2(n - 1);
    }

    static Stream<Arguments> 줄_서는_방법_데이터() {
        return Stream.of(
                Arguments.of(3, 5, new int[]{3, 1, 2}),
                Arguments.of(4, 15, new int[]{3, 2, 1, 4})
        );
    }

    @ParameterizedTest
    @MethodSource(value = "삼각달팽이_데이터")
    void 삼각달팽이(int n, int[] result) {
        //when
        List<int[]> list = new ArrayList<>();

        IntStream.rangeClosed(1, n).forEach(i -> list.add(new int[i]));

        int row = -1;
        int col = 0;
        int currNum = 0;

        for (int i=n; i>0; i-=3) {
            for (int j=0; j<i; j++) list.get(++row)[col] = ++currNum;
            for (int j=0; j<i-1; j++) list.get(row)[++col] = ++currNum;
            for (int j=0; j<i-2; j++) list.get(--row)[--col] = ++currNum;
        }

        int[] answer = list.stream().flatMapToInt(numbers -> Arrays.stream(numbers)).toArray();

        //then
        assertThat(answer).isEqualTo(result);
    }

    static Stream<Arguments> 삼각달팽이_데이터() {
        return Stream.of(
                Arguments.of(4, new int[]{1, 2, 9, 3, 10, 8, 4, 5, 6, 7}),
                Arguments.of(5, new int[]{1, 2, 12, 3, 13, 11, 4, 14, 15, 10, 5, 6, 7, 8, 9}),
                Arguments.of(6, new int[]{1, 2, 15, 3, 16, 14, 4, 17, 21, 13, 5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11})
        );
    }

    @ParameterizedTest
    @MethodSource(value = "두_큐_합_같게_만들기_데이터")
    void 두_큐_합_같게_만들기(int[] queue1, int[] queue2, int result) {
        //when
        Queue<Integer> leftQueue = new LinkedList<>();
        Queue<Integer> rightQueue = new LinkedList<>();

        long leftSum = 0;
        long rightSum = 0;
        for (int i = 0; i < queue1.length; i++) {
            leftSum += queue1[i];
            leftQueue.add(queue1[i]);
            rightSum += queue2[i];
            rightQueue.add(queue2[i]);
        }

        int answer = -1;
        while (answer++ <= 3 * (queue1.length - 1)) {
            if (leftSum == rightSum) break;
            else if (leftSum > rightSum) {
                rightSum += leftQueue.peek();
                leftSum -= leftQueue.peek();
                rightQueue.add(leftQueue.poll());
            } else if (leftSum < rightSum) {
                leftSum += rightQueue.peek();
                rightSum -= rightQueue.peek();
                leftQueue.add(rightQueue.poll());
            }
        }

        answer = (answer > 3 * (queue1.length - 1)) ? -1 : answer;

        //then
        assertThat(answer).isEqualTo(result);
    }

    static Stream<Arguments> 두_큐_합_같게_만들기_데이터() {
        return Stream.of(
                Arguments.of(new int[] {3, 2, 7, 2}, new int[] {4, 6, 5, 1}, 2),
                Arguments.of(new int[] {1, 2, 1, 2}, new int[] {1, 10, 1, 2}, 7),
                Arguments.of(new int[] {1, 2, 1, 2}, new int[] {1, 1, 10, 2}, 9),
                Arguments.of(new int[] {1, 1}, new int[] {1, 5}, -1)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "혼자_놀기의_달인_데이터")
    void 혼자_놀기의_달인(int[] cards, int result) {
        //when
        boolean[] visited = new boolean[cards.length];
        int first = 0;
        int second = 0;

        for (int i = 0; i < cards.length; i++) {
            int count = dfs(cards, visited, i);
            if (count > first) first = count;
            else if (count > second) second = count;
        }

        //then
        assertThat(first * second).isEqualTo(result);
    }

    int dfs(int[] cards, boolean[] visited, int idx) {
        if (visited[idx]) return 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(cards[idx]);
        visited[idx] = true;
        int count = 1;

        while (!stack.isEmpty()) {
            int nextIdx = stack.pop() - 1;
            if (visited[nextIdx]) continue;
            visited[nextIdx] = true;
            stack.push(cards[nextIdx]);
            count++;
        }

        return count;
    }

    static Stream<Arguments> 혼자_놀기의_달인_데이터() {
        return Stream.of(
                Arguments.of(new int[] {8, 6, 3, 7, 2, 5, 1, 4}, 12)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "방금그곡_데이터")
    void 방금그곡(String m, String[] musicinfos, String result) {
        //when
        String answer = "(None)";

        m = replaceSharpToLowerCase(m);

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < musicinfos.length; i++) {
            String[] musicinfo = musicinfos[i].split(",");
            String startTime = musicinfo[0];
            String endTime = musicinfo[1];
            String title = musicinfo[2];
            String score = musicinfo[3];

            score = replaceSharpToLowerCase(score);
            String originScore = "";
            int musicTime = getMusicTime(startTime, endTime);
            if (score.length() > musicTime) originScore = score.substring(0, musicTime);
            else if (score.length() < musicTime) {
                originScore = score.repeat(musicTime / score.length()) + score.substring(0, musicTime % score.length());
            }

            System.out.println("originScore = " + originScore);

            map.put(title, originScore);
        }

        System.out.println(map);

        int max = 0;
        for (int i = 0; i < musicinfos.length; i++) {
            String key = musicinfos[i].split(",")[2];
            String score = map.get(key);
            if (score.length() > max && score.contains(m) && !score.contains(m + "#")) {
                max = score.length();
                answer = key;
            }
        }

        //then
        assertThat(answer).isEqualTo(result);
    }

    public String replaceSharpToLowerCase(String melody) {
        return melody.replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f")
                .replaceAll("G#", "g").replaceAll("A#", "a");
    }

    public int getMusicTime(String startTime, String endTime) {
        String[] startTimeSplit = startTime.split(":");
        String[] endTimeSplit = endTime.split(":");

        return (Integer.parseInt(endTimeSplit[0]) - Integer.parseInt(startTimeSplit[0])) * 60
                + (Integer.parseInt(endTimeSplit[1]) - Integer.parseInt(startTimeSplit[1]));
    }

    static Stream<Arguments> 방금그곡_데이터() {
        return Stream.of(
                Arguments.of("ABCDEFG", new String[] {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}, "HELLO"),
                Arguments.of("CC#BCC#BCC#BCC#B", new String[] {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}, "FOO"),
                Arguments.of("ABC", new String[] {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}, "WORLD")
        );
    }

    @ParameterizedTest
    @MethodSource(value = "택배상자_데이터")
    void 택배상자(int[] order, int result) {
        //when
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();

        IntStream.rangeClosed(1, order.length).forEach(i -> q.add(i));

        while (!q.isEmpty()) {
            if (!q.isEmpty() && q.peek() == order[answer]) {
                q.poll();
                answer++;
            } else if (!s.isEmpty() && s.peek() == order[answer]) {
                s.pop();
                answer++;
            } else {
                s.push(q.poll());
            }
        }

        while (!s.isEmpty()) {
            if (s.peek() == order[answer]) {
                s.pop();
                answer++;
            } else {
                break;
            }
        }

        System.out.println("answer = " + answer);

        //then
        assertThat(answer).isEqualTo(result);
    }

    static Stream<Arguments> 택배상자_데이터() {
        return Stream.of(
                Arguments.of(new int[] {4, 3, 1, 2, 5}, 2),
                Arguments.of(new int[] {5, 4, 3, 2, 1}, 5)
        );
    }
    
    @ParameterizedTest
    @MethodSource(value = "롤케이크_자르기_데이터")
    void 롤케이크_자르기(int[] topping, int result) {
        //when
        int answer = 0;

        Map<Integer, Integer> originMap = new HashMap<>();
        Map<Integer, Integer> pointerMap = new HashMap<>();

        for (int item : topping) {
            originMap.put(item, originMap.getOrDefault(item, 0) + 1);
        }

        int originCount = originMap.size();
        for (int i = 0; i < topping.length; i++) {
            int item = topping[i];
            pointerMap.put(item, pointerMap.getOrDefault(item, 0) + 1);
            originMap.put(item, originMap.get(item) - 1);

            if (originMap.get(item) == 0) originCount--;
            if (pointerMap.size() == originCount) answer++;
        }

        //then
        assertThat(answer).isEqualTo(result);
    }

    static Stream<Arguments> 롤케이크_자르기_데이터() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 1, 3, 1, 4, 1, 2}, 2),
                Arguments.of(new int[] {1, 2, 3, 1, 4}, 0)
        );
    }
    
    @ParameterizedTest
    @MethodSource(value = "순위_검색_데이터")
    void 순위_검색(String[] info, String[] query, int[] result) {
        //when
        int[] answer = new int[info.length];

        List<Rank> rankList = new ArrayList<>();
        for (String data : info) {
            String[] splitData = data.split(" ");
            rankList.add(new Rank(splitData[0], splitData[1], splitData[2], splitData[3], Integer.parseInt(splitData[4])));
        }

        for (int i = 0; i < query.length; i++) {
            String q = query[i];
            String[] splitQuery = q.split(" and ");
            System.out.println(Arrays.toString(splitQuery));
        }

        //then
        
    }

    static class Rank {
        private String language;
        private String group;
        private String career;
        private String soulFood;
        private int score;

        public Rank(String language, String group, String career, String soulFood, int score) {
            this.language = language;
            this.group = group;
            this.career = career;
            this.soulFood = soulFood;
            this.score = score;
        }

        public String getLanguage() {
            return language;
        }

        public String getGroup() {
            return group;
        }

        public String getCareer() {
            return career;
        }

        public String getSoulFood() {
            return soulFood;
        }

        public int getScore() {
            return score;
        }
    }

    static Stream<Arguments> 순위_검색_데이터() {
        return Stream.of(
                Arguments.of(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                        new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"},
                        new int[]{1, 1, 1, 1, 2, 4})
        );
    }
    
    @ParameterizedTest
    @MethodSource(value = "지하철_최소환승_데이터")
    void 지하철_최소환승() {
        //when


        //then
        
    }
}

/*
SELECT b.ID, b.NAME, COUNT(s.car_id), COUNT(e.id)
FROM EMPLOYEES e, BRANCHES b, SELLINGS s
WHERE e.ID = s.EMPLOYEE_ID
AND e.BRANCH_ID = b.ID
AND s.CAR_ID = 306
GROUP BY (b.ID, b.NAME);
*/
