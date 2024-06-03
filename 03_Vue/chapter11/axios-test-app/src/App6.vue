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
  // todos2는 없는 url이므로 에러가 날 것이다...
  // 하지만 todos/2는 있으므로 에러가 안날 것이다
  const url = '/api/todos2';
  axios
    .get(url, { timeout: 900 })
    // api 호출에 성공했을 경우
    .then((response) => {
      console.log('#응답객체 : ', response);
    })
    // api 호출에 실패했을 경우
    .catch((e) => {
      console.log('에러=========================');
      // instanceof : e가 Error 타입인지 체크
      if (e instanceof Error) console.log(e.message);
      else console.log(e);
    });
};

requestAPI();
</script>
