<template>
  <div class="header">
    <h1 class="headerText">태평양 전쟁의 해전</h1>
    <nav>
      <!-- 부트스트랩에 있는 클래스 적용 -->
      <ul class="nav nav-tabs nav-fill">
        <li v-for="tab in tabs" :key="tab.id" class="nav-item">
          <!-- 탭의 아이디가 현재 탭과 같으면 active 클래스를 추가해줌 -->
          <a
            style="cursor: pointer"
            class="nav-link"
            :class="{ active: tab.id === currentTab }"
            @click="changeTab(tab.id)"
          >
            {{ tab.label }}
          </a>
        </li>
      </ul>
    </nav>
  </div>
  <div class="container">
    <!-- 정적 ㅌ컴포넌트인 경우 include에 포함시키면 한번만 캐싱해서 가져온다 -->
    <!-- 기본값은 항상 다시 생성한다 -->
    <!-- 동적 컴포넌트로 보여줄 데이터를 is에 넣는다 -->
    <keep-alive include="MidwayTab,CoralSeaTab">
      <component :is="currentTab"></component>
    </keep-alive>
  </div>
</template>

<script>
import CoralSeaTab from './components/CoralSeaTab.vue';
import LeyteGulfTab from './components/LeyteGulfTab.vue';
import MidwayTab from './components/MidwayTab.vue';

export default {
  name: 'App',
  components: { CoralSeaTab, LeyteGulfTab, MidwayTab },

  data() {
    return {
      currentTab: 'CoralSeaTab',
      tabs: [
        { id: 'CoralSeaTab', label: '산호해 해전' },
        { id: 'LeyteGulfTab', label: '레이테만 해전' },
        { id: 'MidwayTab', label: '미드웨이 해전' },
      ],
    };
  },
  methods: {
    changeTab(tab) {
      // 선택된 탭을 업데이트
      this.currentTab = tab;
    },
  },
};
</script>

<style>
.header {
  padding: 20px 0px 0px 20px;
}

.headerText {
  padding: 0px 20px 40px 20px;
}
.tab {
  padding: 30px;
}
</style>
