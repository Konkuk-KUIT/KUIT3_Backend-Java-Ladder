# Backend-Java-Ladder
KUIT 서버 파트 - 1주차 미션 수행을 위한 레포지토리입니다.

## 미션
- 미션은 [KUIT3_Backend-Java-Ladder](https://github.com/Konkuk-KUIT/KUIT3_Backend-Java-Ladder) 저장소를 Fork & Clone해 시작
- 자세한 내용은 디스코드 공지 참고

## 제출 방법
- [미션 제출 방법](https://lavender-house-a0f.notion.site/Server_-1ef654a18417443498bea1d6caca77cd?pvs=4)을 참고하여 제출

--------
- ladder의 생성 -> ladderGameFactory Class;
- - row, col만 입력 받고, 가로줄은 랜덤으로 치고 반환하는
- - 나중에 custom가능한 빈 사다리를 반환하는

- row의 배열(집합)이 ladder


Row Class 
- validation, 이동, run 이 정도 있음

------
- 필드로는 `private final int num`을 갖는다.
- 생성자는 정수를 매개변수로 입력받아, 숫자가 유효한지(자연수인지) 검증하고, 필드에 대입한다.
- 숫자를 반환하는 `public get()` 메서드, 숫자가 유효한지 검증하는 `private validate()` 메서드가 필요하다.
- 숫자가 유효한지 검증하는 `private validate()` 메서드는 숫자가 유효하지 않으면 언체크 예외(런타임 예외)를 반환한다.
- **정적 팩터리 메서드 패턴**을 사용해보자.
    - 생성자를 private 접근제어자로 설정하고,
      **정적 팩토리 메서드의 접근 제어자는** public static이며,
      생성자를 통해 NaturalNumber 객체를 만들어 반환하는 **`of` 메서드**를 구현해야 한다