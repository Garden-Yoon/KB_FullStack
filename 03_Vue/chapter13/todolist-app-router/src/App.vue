<template>
  <!-- test commit -->
  <div class="container">
    <Header />
    <!-- 계속 페이지가 바뀌는 부분이 router-view -->
    <router-view />
  </div>
</template>
<script setup>
// script setup 키워드 사용시 components 따로 등록할 필요 없음
import Header from '@/components/Header.vue';
import { reactive, computed, provide } from 'vue';
import axios from 'axios';
const BASEURI = '/api/todos';
const states = reactive({
  todoList: [],
});
// TodoList 목록 조회하는 메소드
const fetchTodoList = async () => {
  // try~ catch 문 : 예외 처리 구문
  // try: 예외가 발생할 수 있는 문장을 넣는다
  try {
    // 서버에서 데이터를 가져올때 시간이 걸리기 때문에 await로 비동기처리
    const response = await axios.get(BASEURI);
    // status가 200인건 요청이 성공적으로 이루어졌다는 뜻
    if (response.status === 200) {
      states.todoList = response.data;
    } else {
      alert('데이터 조회 실패');
    }
    // catch: 예외를 어떻게 처리할지 적어둠
  } catch (error) {
    alert('에러발생:' + error);
  }
};
// todo를 추가하는 메소드, todo와 desc가 들어있는 객체를 구조 분해 할당으로 받음
const addTodo = async ({ todo, desc }, successCallback) => {
  // todoList의 맨 뒤에 새로운 객체 추가
  try {
    const payload = { todo, desc };
    const response = await axios.post(BASEURI, payload);
    if (response.status === 201) {
      states.todoList.push({ ...response.data, done: false });
      successCallback();
    } else {
      alert('Todo 추가 실패');
    }
  } catch (error) {
    alert('에러발생 : ' + error);
  }
};
// todo를 수정하는 메소드, 해당 id의 todo를 찾아서 todo, desc, done 값을 업데이트
const updateTodo = async ({ id, todo, desc, done }, successCallback) => {
  try {
    const payload = { id, todo, desc, done };
    // 해당 아이디를 가진 할일 전체를 업데이트해줌
    const response = await axios.put(BASEURI + `/${id}`, payload);
    if (response.status === 200) {
      // 받아온 id로 해당하는 todo를 찾은 후 해당 todo의 index 반환
      let index = states.todoList.findIndex((todo) => todo.id === id);
      // 찾아온 todo의 값을 그대로 펼친 후 todo, desc, done 값을 업데이트해서 다시 대입
      states.todoList[index] = payload;
      successCallback();
    } else {
      alert('Todo 변경 실패');
    }
  } catch (error) {
    alert('에러발생 : ' + error);
  }
};
// todo를 삭제하는 메소드, 해당 id의 todo를 찾아서 삭제
const deleteTodo = async (id) => {
  try {
    const response = await axios.delete(BASEURI + `/${id}`);
    console.log(response.status, response.data);
    if (response.status === 200) {
      // 받아온 id로 해당하는 todo를 찾은 후 해당 todo의 index 반환
      let index = states.todoList.findIndex((todo) => todo.id === id);
      states.todoList.splice(index, 1);
    } else {
      alert('Todo 삭제 실패');
    }
  } catch (error) {
    alert('에러발생 : ' + error);
  }
};
// todo의 done을 true -> false, false -> true로 변경해주는 메소드
const toggleDone = async (id) => {
  try {
    // 받아온 id로 해당하는 todo를 찾아옴
    let todo = states.todoList.find((todo) => todo.id === id);
    // todo의 값을 그대로 가져오고 done 값만 반대로 변경해줌
    let payload = { ...todo, done: !todo.done };
    // done이 변경됐으므로 해당 아이디의 todo를 업데이트해줌
    const response = await axios.put(BASEURI + `/${id}`, payload);
    if (response.status === 200) {
      todo.done = payload.done;
    } else {
      alert('Todo 완료 변경 실패');
    }
  } catch (error) {
    alert('에러발생 : ' + error);
  }
};
// provide로 하위 컴포넌트에서 사용 가능하도록 제공해줌
provide(
  'todoList',
  // computed로 감싸주면 반응성과 읽기전용 유지
  computed(() => states.todoList)
);
provide('actions', {
  addTodo,
  deleteTodo,
  toggleDone,
  updateTodo,
  fetchTodoList,
});
// 전체 목록 갱신
fetchTodoList();
</script>
