package org.scoula.common.util;

public class UploadFileName {
    public static String getUniqueName(String filename) {

//        lastIndexOf(문자열) : 뒤에서부터 해당 문자열을 찾아서 처음 등장하는 인덱스 반환
        int ix= filename.lastIndexOf('.');
//        substring(시작인덱스, 끝인덱스+1) : 시작 인덱스부터 끝 인덱스까지 문자열을 잘라냄
        String name = filename.substring(0, ix); // 파일명 추출
//        substring에 시작 인덱스만 있을 경우, 시작 인덱스부터 끝까지 잘라낸다
        String ext = filename.substring(ix+1); // 확장명 추출

        // 파일명 뒤에 타임스탬프를 부여서 고유한 파일명으로 만들어줌
        return String.format("%s-%d.%s", name, System.currentTimeMillis(), ext);
    }
}
