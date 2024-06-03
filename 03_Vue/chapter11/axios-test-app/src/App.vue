<template>
  <div>
    <h2>콘솔을 확인합니다.</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

const listUrl = '/api/todos';
const todoUrlPrefix = '/api/todos/';

// 4건의 목록을 조회한 후 첫번째, 두번째 할 일을 순차적으로 조회
const requestAPI = () => {
  let todoList = [];
  // 해당 URL에 있는 데이터를 가져와서 전체 리스트 출력
  axios
    .get(listUrl)
    .then((response) => {
      todoList = response.data;
      console.log('#TodoList : ', todoList);
      return todoList[0].id;
    })
    // 받아온 데이터로 출력 후 두번째 todo 아이디 리턴
    .then((id) => {
      return axios.get(todoUrlPrefix + id);
    })
    .then((response) => {
      console.log('## 첫번째 Todo : ', response.data);
      return todoList[1].id;
    })
    // 두번째 todo 아이디로 데이터 받아와서 출력
    .then((id) => {
      axios.get(todoUrlPrefix + id).then((response) => {
        console.log('## 두번째 Todo: ', response.data);
      });
    });
};

requestAPI();
</script>
