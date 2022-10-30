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

        int[] answer = Arrays.copyOfRange(flatArr, left, right+1);

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
                Arguments.of(3, 2, 5, new int[] {3, 2, 2, 3}),
                Arguments.of(4, 7, 14, new int[] {4, 3, 3, 3, 4, 4, 4, 4})
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
                Arguments.of(new int[] {180, 5000, 10, 600}, new String[] {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}, new int[] {14600, 34400, 5000}),
                Arguments.of(new int[] {120, 0, 60, 591}, new String[] {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"}, new int[] {0, 591}),
                Arguments.of(new int[] {1, 461, 1, 10}, new String[] {"00:00 1234 IN"}, new int[] {14841})
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
                Arguments.of(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"}, new String[] {"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."})
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
}
