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
  const url = '/api/todos';
  let data = { todo: '윗몸 일으키기 3set', desc: '너무 빠르지 않게' };
  const resp1 = await axios.post(url, data);
  console.log(resp1.data);
};

requestAPI();
</script>
