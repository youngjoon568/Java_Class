package Quiz_Java;

public class Quiz_Tv {
	public static void main(String[] args) {
		Tv tv1 = new Tv();
		
		tv1.powerOnOff();
		tv1.moveChannel(299);
		tv1.channelUp();

		tv1.getTvInfo();
	}
}

class Tv {
	int channel;
	int sound;
	int previousChannel;
	boolean isPowerOn = false;
	final int MAX_CHANNEl = 300;
	final int MIN_CHANNEl = 1;
	final int MAX_SOUND = 100;
	final int MIN_SOUND = 0;
	
	public Tv() {
		channel = 7;
		sound = 20;
	}
	
	void powerOnOff() {
		isPowerOn = !isPowerOn;
	}
	
	void soundUp() {
		if(!isPowerOn) {
			System.out.println("전원이 꺼져있습니다.");
			return;
		};
		
		if(soundErrMsg()) return;
		
		sound++;
		
	}
	void soundDown() {
		if(!isPowerOn) {
			System.out.println("전원이 꺼져있습니다.");
			return;
		};
		
		if(soundErrMsg()) return;
		
		sound--;
	}
	void channelUp() {
		if(!isPowerOn) {
			System.out.println("전원이 꺼져있습니다.");
			return;
		};

		if(channelErrMsg()) return;
		if(channel == MAX_CHANNEl) {
			channel = MIN_CHANNEl;
		} else if (channel == MIN_CHANNEl) {
			channel = MAX_CHANNEl;
		} else {
			previousChannel = channel;
			channel++;
		}
	}
	void channelDown() {
		if(!isPowerOn) {
			System.out.println("전원이 꺼져있습니다.");
			return;
		};

		if(channelErrMsg()) return;
		if(channel == MAX_CHANNEl) {
			channel = MIN_CHANNEl;
		} else if (channel == MIN_CHANNEl) {
			channel = MAX_CHANNEl;
		} else {
			previousChannel = channel;
			channel--;
		}
	}
	
	
	void moveChannel(int num) {
		if(num > MAX_CHANNEl || num < MIN_CHANNEl) {
			System.out.println("해당 채널이 없습니다.");
		} else {
			previousChannel = channel;
			channel = num;
		}
		
	}

	boolean soundErrMsg() {
		if(sound >= MAX_SOUND || sound <= MIN_SOUND) {
			System.out.println("잘못된 볼륨 명령입니다.");
			return true;
		}
		
		return false;
	};
	boolean channelErrMsg() {
		if(channel > MAX_CHANNEl || channel < MIN_CHANNEl) {
			System.out.println("잘못된 채널 접근입니다.");
			return true;
		}
		return false;
	};
	
	void getTvInfo() {
		String powerText = isPowerOn ? "On" :"Off";
		System.out.println("전원 : " + powerText);
		System.out.println("채널 : " + channel);
		System.out.println("볼륨 : " + sound);
		System.out.println("이전 채널 : " + previousChannel);
	}
}

/*
TV클래스 만들기
- 채널 클래스의 기본 생성시 채널과 볼륨은 채널 7, 볼륨 20
- 최대볼륨은 100, 최소 볼륨 0, 채널의 최대 채널 300, 채널의 최소 1
이전 채널이 동작시 저장되어 있던 이전 채널로 이동
채널 이동은 채널 정보를 입력받아서 채널 이동
- 채널 이동 및 볼륨 조절은 전원 On인 상태에서 동작한다.

- 속성(멤버변수) : 채널, 볼륨, 전원, 이전채널
- 기능 : 전원 on/off, 볼륨업/다운, 채널업/다운, 
  이전 채널이동, 채널이동, TV현재정보확인(전원,채널,볼륨,저장된 이전채널)
- 
*/
