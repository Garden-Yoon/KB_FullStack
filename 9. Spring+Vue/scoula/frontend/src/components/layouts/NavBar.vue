<script setup>
// reactive, ref는 반응형 데이터를 만들어준다 (reactive : 참조형 데이터, ref : 값형 데이터)
// computed : 계산된 값을 캐싱, 계산된 값으로 안쪽 데이터가 변경되면 해당 변경을 감지해서 같이 변경된다
import { reactive, computed } from 'vue';
import config from '@/config';
import MenuGroup from './menu/MenuGroup.vue';
import AccountMenuGroup from './menu/AccountMenuGroup.vue';

let state = reactive({ isNavShow: false });

// state.isNavShow 값이 true이면, 앞에 있는 클래스 3개, false라면 뒤에 있는 클래스 2개 사용
let navClass = computed(() =>
  state.isNavShow ? 'collapse navbar-collapse show' : 'collapse navbar-collapse'
);

// state의 isNavShow를 무조건 반대값으로 변경해주는 함수
const toggleNavShow = () => (state.isNavShow = !state.isNavShow);
</script>

<template>
  <nav class="navbar navbar-expand-sm bg-primary navbar-dark">
    <div class="container-fluid">
      <router-link class="navbar-brand" to="/">
        <i class="fa-solid fa-house"></i>
        Scoula
      </router-link>
      <!-- @ -> v-on, 이벤트를 처리해주는 디렉티브 -->
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#collapsibleNavbar"
        @click="toggleNavShow"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <!-- navbar-toggler 버튼을 누를 때 마다 show 클래스가 추가되었다가 삭제되는걸 반복 -->
      <div :class="navClass" id="collapsibleNavbar">
        <!-- 추후 작업 예정 -->
        <MenuGroup :menus="config.menus" />
        <AccountMenuGroup />
      </div>
    </div>
  </nav>
</template>
<style></style>
