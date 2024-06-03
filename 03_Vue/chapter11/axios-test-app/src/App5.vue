<template>
  <div>
    <h2>콘솔을 확인합니다.</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

// 4건의 목록을 조회한 후 첫번째, 두번째 할 일을 순차적으로 조회
// await를 쓰기 위해서는 함수 앞에 async를 붙여줌
const requestAPI = async () => {
  // api/todos/5같이 없는 url 쓰면 에러뜨는거 확인 가능
  const url = '/api/todos';
  // api 요청에 성공했을 때
  try {
    const response = await axios.get(url, { timeout: 900 });
    console.log('#응답객체 : ', response);
  } catch (e) {
    // api 요청에 실패했을 때
    console.log('## 다음 오류가 발생했습니다.');
    // instanceof : e가 Error 타입인지 체크
    if (e instanceof Error) console.log(e.message);
    else console.log(e);
  }
};

requestAPI();
</script>
