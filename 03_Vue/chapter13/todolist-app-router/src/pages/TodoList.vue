<template>
  <div class="row">
    <div class="col p-3">
      <!-- 링크 클릭 시 할일 추가 화면으로 이동 -->
      <router-link class="btn btn-primary" to="/todos/add"
        >할 일 추가</router-link
      >
    </div>
  </div>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <!-- todoList를 돌면서 todoItem 출력하고 자식에게 props로 todoItem 전송 -->
        <TodoItem
          v-for="todoItem in todoList"
          :key="todoItem.id"
          :todoItem="todoItem"
        />
      </ul>
    </div>
  </div>
</template>

<script setup>
import { inject } from 'vue';
import TodoItem from '@/components/TodoItem.vue';
const todoList = inject('todoList');
</script>
