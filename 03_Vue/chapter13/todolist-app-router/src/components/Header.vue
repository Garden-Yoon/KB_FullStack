<template>
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <span class="navbar-brand ps-2">TodoList App</span>
    <!-- 해당 버튼 클릭 시 isNavShow 값을 반대로 변경함 -->
    <button
      class="navbar-toggler"
      type="button"
      @click="isNavShow = !isNavShow"
    >
      <span class="navbar-toggler-icon"> </span>
    </button>
    <!-- isNavShow가 true일 경우 앞의 클래스, false일 경우 뒤의 클래스 적용 -->
    <div
      :class="
        isNavShow ? 'collapse navbar-collapse show' : 'collapse navbar-collapse'
      "
    >
      <ul class="navbar-nav">
        <li class="nav-item">
          <!-- to에 있는 주소로 각각의 링크 생성해줌 -->
          <router-link class="nav-link" to="/">Home</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/about">About</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/todos">TodoList</router-link>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script setup>
// composition api에서 값형 데이터를 반응형으로 만들 때 ref 사용
import { ref } from 'vue';
const isNavShow = ref(false);
</script>
