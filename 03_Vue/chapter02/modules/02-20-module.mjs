let base = 100;

// named 키워드(export) : 이름을 무조건 지정해줘야 한다

export const add = (x) => base + x;
export const multiply = (x) => base * x;

// default 키워드(export default) : 이름을 지정해주지 않아도 된다.
// 대신 무조건 한 파일 당 하나만 지정 가능
export default () => base;
