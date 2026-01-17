package week2;

import java.util.HashMap;

public class Week2_1 {
	public String[] solution(String[] record) {
		String[] answer = {};

		int len = record.length;

		// 유저 이름 저장 해시 맵으로 해서 마지막으로 바뀐 이름으로 최신화 되게 맵으로 저장

		HashMap<String, String> map = new HashMap<>();
		int size = 0;
		for (int i = 0; i < len; i++) {

			String[] temp = record[i].split(" ");
			String cmd = temp[0];

			if (!cmd.equals("Change"))
				size++;

			if (cmd.equals("Enter") || cmd.equals("Change")) {
				map.put(temp[1], temp[2]);
			}
		}

		// 입 퇴장 메세지 저장
		answer = new String[size];
		int idx = 0;
		for (int i = 0; i < len; i++) {
			String[] temp = record[i].split(" ");

			if ("Enter".equals(temp[0])) {
				String in = map.get(temp[1]);
				in += "님이 들어왔습니다.";
				answer[idx++] = in;
			}

			if ("Leave".equals(temp[0])) {
				String out = map.get(temp[1]);
				out += "님이 나갔습니다.";
				answer[idx++] = out;
			}
		}

		return answer;
	}
}
