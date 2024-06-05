<template>
  <!-- todoItem의 done 값에 따라 클래스 이름 변경 -->
  <li
    :class="
      todoItem.done
        ? 'list-group-item list-group-item-success'
        : 'list-group-item'
    "
  >
    <span
      :class="todoItem.done ? 'todo-done pointer' : 'pointer'"
      @click="toggleDone(todoItem.id)"
      >{{ todoItem.todo }}
      {{ todoItem.done ? '(완료)' : '' }}
    </span>
    <!-- 클릭하면 해당 아이디의 todo를 편집할 수 있는 화면으로 이동 -->
    <span
      class="float-end badge bg-secondary pointer m-1"
      @click="router.push(`/todos/edit/${todoItem.id}`)"
      >편집</span
    >
    <span
      class="float-end badge bg-secondary pointer m-1"
      @click="deleteTodo(todoItem.id)"
      >삭제</span
    >
  </li>
</template>
<script setup>
import { useRouter } from 'vue-router';
import { inject } from 'vue';
// props랑 동일한 개념, script setup 문법에서 사용
// TodoList로부터 받아왔다
// 타입이 객체고, 필수값이라는 것을 미리 정의
defineProps({
  todoItem: { Type: Object, required: true },
});
const router = useRouter();
// 필요한 함수만 객체 구조 분해 할당으로 actions에서 꺼냄
const { deleteTodo, toggleDone } = inject('actions');
</script>
